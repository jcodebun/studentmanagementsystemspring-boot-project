package in.co.sms.controller;

import java.util.HashMap;
import java.util.List;
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

import in.co.sms.dto.FeeDTO;
import in.co.sms.dto.UserDTO;
import in.co.sms.exception.DuplicateRecordException;
import in.co.sms.form.ClassesForm;
import in.co.sms.form.FeeForm;
import in.co.sms.service.ClassesServiceInt;
import in.co.sms.service.FeeServiceInt;
import in.co.sms.service.UserServiceInt;


@Controller
public class FeeCtl extends BaseCtl {

	private Logger log = Logger.getLogger(FeeCtl.class.getName());
	@Autowired
	private FeeServiceInt service;
	
	@Autowired
	private UserServiceInt userServiceInt;
	
	@ModelAttribute
	public void preload(Model model) {
		UserDTO dto = new UserDTO();
		dto.setRoleId(2L);
		model.addAttribute("studentList", userServiceInt.search(dto));
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("January", "January");
		map2.put("February", "February");
		map2.put("March", "March");
		map2.put("April", "April");
		map2.put("May", "May");
		map2.put("June", "June");
		map2.put("July", "July");
		map2.put("August", "August");
		map2.put("September", "September");
		map2.put("October", "October");
		map2.put("November", "November");
		map2.put("December", "December");
		model.addAttribute("months", map2);
	}
	
	@GetMapping("/home/login/fees")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") FeeForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			FeeDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "fees";
	}

	@PostMapping("/home/login/fees")
	public String submit(@Valid @ModelAttribute("form") FeeForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/fees";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "fees";
				}
				FeeDTO bean = (FeeDTO) populateDTO(form.getDTO(),request);
				bean.setUser(userServiceInt.findBypk(form.getUserId()));
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Fees update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Fees Added Successfully!!!!");
				}
				return "fees";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "fees";
		}
		return "";
	}

	@RequestMapping(value = "/home/login/fees/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") FeeForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {
		
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/fees/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} 
		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					FeeDTO dto = new FeeDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		FeeDTO dto = (FeeDTO) form.getDTO();
		
		List<FeeDTO> list = service.search(dto, pageNo, pageSize);
		List<FeeDTO> totallist = service.search(dto);
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
		return "feeList";
	}
}
