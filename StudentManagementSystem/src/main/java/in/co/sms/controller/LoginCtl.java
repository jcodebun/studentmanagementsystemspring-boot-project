package in.co.sms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.sms.dto.UserDTO;
import in.co.sms.exception.DuplicateRecordException;
import in.co.sms.form.ChangePasswordForm;
import in.co.sms.form.ForgotPasswordForm;
import in.co.sms.form.LoginForm;
import in.co.sms.form.MyProfileForm;
import in.co.sms.form.UserRegistrationForm;
import in.co.sms.service.UserServiceInt;
import in.co.sms.util.DataUtility;



@Controller
public class LoginCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_REGISTER = "Add User";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";
	protected static final String OP_CONFIRM = "Confirm";
	

	@Autowired
	private UserServiceInt userServiceInt;

	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Male", "Male");
		map2.put("Female", "Female");
		model.addAttribute("gender", map2);
		
		Map<Integer, String> map3 = new HashMap<>();
		map3.put(1,"ADMIN");
		map3.put(2,"STUDENT");
		map3.put(3, "FACULTY");
		model.addAttribute("roles", map3);

	}

	@GetMapping("/home/login")
	public String display(@ModelAttribute("form") LoginForm form, HttpSession session, Model model) {
		log.info("LoginCtl login display method start");
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "You have logout Successfully!!!");
		}

		log.info("LoginCtl login display method End");
		return "login";
	}

	@PostMapping("/home/login")
	public String submit(@RequestParam String operation, HttpSession session,
			@Valid @ModelAttribute("form") LoginForm form, BindingResult result, Model model) {
		log.info("LoginCtl login submit method start");
		System.out.println("In dopost  LoginCtl");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login";
		}

		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login";
		}

		if (result.hasErrors()) {
			System.out.println(result);
			return "login";
		}

		UserDTO bean = userServiceInt.authentication((UserDTO) form.getDTO());

		if (bean != null) {
			System.out.println(bean.toString());
			session.setAttribute("user", bean);
			return "redirect:/home";
		}

		if (bean == null) {

			model.addAttribute("error", "Login Id & Password Invalid");
		}
		log.info("LoginCtl login submit method End");
		return "login";
	}

	@GetMapping("/home/user")
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") UserRegistrationForm form, Model model) {
		log.info("LoginCtl signUp display method start");
		if (form.getId() > 0) {
			UserDTO bean = userServiceInt.findBypk(id);
			form.populate(bean);
		}
		log.info("LoginCtl signUp display method End");
		return "userRegister";
	}

	@PostMapping("/home/user")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") UserRegistrationForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request) {

		log.info("LoginCtl signUp submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/user";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "userRegister";
		}

		try {
			UserDTO entity = (UserDTO) populateDTO(form.getDTO(), request);
			if (OP_REGISTER.equalsIgnoreCase(form.getOperation())) {
				
				if(form.getRoleId()==1) {
					entity.setRoleName("ADMIN");
				}
				if(form.getRoleId()==2) {
					entity.setRoleName("STUDENT");
				}
				if(form.getRoleId()==3) {
					entity.setRoleName("FACULTY");
				}
				if(entity.getId()>0) {
					userServiceInt.update(entity);
					model.addAttribute("success", "User update Successfully!!!!");
				}else {
					userServiceInt.add(entity);
					model.addAttribute("success", "User Registerd Successfully!!!!");
				}
				
				return "userRegister";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "userRegister";
		}

		log.info("LoginCtl signUp submit method end");
		return "userRegister";
	}

	

	@RequestMapping(value = "/home/login/users/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UserRegistrationForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/users/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/user";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
				userServiceInt.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		if (OP_CONFIRM.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
					//userServiceInt.accept(dto);
				}
				model.addAttribute("success", "User accepted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		UserDTO dto = (UserDTO) form.getDTO();

		UserDTO uDto = (UserDTO) session.getAttribute("user");

		dto.setRoleId(2L);
		List<UserDTO> list = userServiceInt.search(dto, pageNo, pageSize);
		List<UserDTO> totallist = userServiceInt.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "userList";
	}

	
	@RequestMapping(value = "/home/login/myprofile", method = RequestMethod.GET)
	public String displayMyProfile(@ModelAttribute("form") MyProfileForm form, HttpSession session, Model model) {
		UserDTO dto = (UserDTO) session.getAttribute("user");
		long id = dto.getId();
		UserDTO bean = userServiceInt.findBypk(id);
		form.populate(bean);
		return "myProfile";
	}

	@RequestMapping(value = "/home/login/myprofile", method = RequestMethod.POST)
	public String submitMyProfile(HttpSession session, @ModelAttribute("form") @Valid MyProfileForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request) throws DuplicateRecordException {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/myprofile";
		}

		if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			if (bindingResult.hasErrors()) {
				return "myProfile";
		}
			System.out.println("I am heer");
			UserDTO bean = (UserDTO) populateDTO(form.getDTO(), request);
			UserDTO uDto = (UserDTO) session.getAttribute("user");
			long id = uDto.getId();
			System.out.println("bean id: " + id);
			if (id > 0) {
				uDto.setFirstName(bean.getFirstName());
				uDto.setLastName(bean.getLastName());
				uDto.setGender(bean.getGender());
				uDto.setContactNo(bean.getContactNo());
				uDto.setPassword(bean.getPassword());
				uDto.setLogin(bean.getLogin());

				userServiceInt.update(uDto);
				model.addAttribute("success", "Profile Updated Successfully!!!!");
			}

			return "myProfile";
		}
		return "";
	}

	@RequestMapping(value = "/home/login/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, HttpSession session,
			Model model) {

		return "changePassword";

	}

	@RequestMapping(value = "/home/login/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(HttpSession session, @ModelAttribute("form") @Valid ChangePasswordForm form,
			BindingResult bindingResult, Model model) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/changepassword";
		}
		if (bindingResult.hasErrors()) {
			System.out.println("erro" + bindingResult.getAllErrors());
			return "changePassword";
		}

		if (form.getNewPassword().equalsIgnoreCase(form.getConfirmPassword())) {

			UserDTO dto = (UserDTO) session.getAttribute("user");
			dto = userServiceInt.findBypk(dto.getId());

			if (userServiceInt.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword())) {
				model.addAttribute("success", "Password changed Successfully");
			} else {
				model.addAttribute("error", "Old Password Does not Matched");
			}
		} else {
			model.addAttribute("error", "New Password and confirm password does not matched");
		}
		return "changePassword";
	}
	@RequestMapping(value = "/home/login/forgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgotPasswordForm form, HttpSession session, Model model) {

		System.out.println("In doget LoginCtl forgetpassword");

		return "forgetPassword";

	}

	@RequestMapping(value = "/home/login/forgetPassword", method = RequestMethod.POST)
	public String display(@ModelAttribute("form") @Valid ForgotPasswordForm form, BindingResult bindingResult,
			Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "forgetPassword";
		}
			
		UserDTO dto = userServiceInt.findByLogin(form.getLogin());
		
		
		if (dto == null) {
			model.addAttribute("error", "Invalid Input Entered");
			return "forgetPassword";
		}

		if (dto != null) {
			
			model.addAttribute("success", "Password has been sent to your registered Email ID!!");
			 if(!DataUtility.getStringData(dto.getLogin()).equalsIgnoreCase(form.getLogin()) ) {
					model.addAttribute("error", "Incorrect details matched");
					return "forgetPassword";
				}
			
			model.addAttribute("success", "Password is Sent to Email id");
		}
		return "forgetPassword";
	}
}
