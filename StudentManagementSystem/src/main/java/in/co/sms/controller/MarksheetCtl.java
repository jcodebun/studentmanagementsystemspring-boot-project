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

import in.co.sms.dto.ClassesDTO;
import in.co.sms.dto.MarksheetDTO;
import in.co.sms.dto.SubjectDTO;
import in.co.sms.dto.UserDTO;
import in.co.sms.exception.DuplicateRecordException;
import in.co.sms.form.MarksheetForm;
import in.co.sms.service.ClassesServiceInt;
import in.co.sms.service.MarksheetServiceInt;
import in.co.sms.service.SubjectServiceInt;
import in.co.sms.service.UserServiceInt;


@Controller
public class MarksheetCtl extends BaseCtl {

	private Logger log = Logger.getLogger(MarksheetCtl.class.getName());
	@Autowired
	private MarksheetServiceInt service;
	
	@Autowired
	private UserServiceInt userServiceInt;

	@Autowired
	private ClassesServiceInt classesServiceInt;

	@Autowired
	private SubjectServiceInt subjectServiceInt;

	@ModelAttribute
	public void preload(Model model) {
		UserDTO dto = new UserDTO();
		dto.setRoleId(2L);
		model.addAttribute("studentList", userServiceInt.search(dto));
		SubjectDTO dto2 = new SubjectDTO();
		model.addAttribute("subjectList", subjectServiceInt.search(dto2));
		ClassesDTO dto3 = new ClassesDTO();
		model.addAttribute("classList", classesServiceInt.search(dto3));

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("January", "January");
		map2.put("February", "February");
		model.addAttribute("months", map2);

		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("Present", "Present");
		map3.put("Absent", "Absent");
		model.addAttribute("statusList", map3);
	}
	
	@GetMapping("/home/login/marksheet")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") MarksheetForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			MarksheetDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "marksheet";
	}

	@PostMapping("/home/login/marksheet")
	public String submit(@Valid @ModelAttribute("form") MarksheetForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/marksheet";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "marksheet";
				}
				MarksheetDTO bean = (MarksheetDTO) populateDTO(form.getDTO(),request);
				bean.setUser(userServiceInt.findBypk(form.getUserId()));
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Marksheet update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Marksheet Added Successfully!!!!");
				}
				return "marksheet";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "marksheet";
		}
		return "";
	}

	@RequestMapping(value = "/home/login/marksheet/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") MarksheetForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/marksheet/search";
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
					MarksheetDTO dto = new MarksheetDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		MarksheetDTO dto = (MarksheetDTO) form.getDTO();
		
		List<MarksheetDTO> list = service.search(dto, pageNo, pageSize);
		List<MarksheetDTO> totallist = service.search(dto);
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
		return "marksheetList";
	}
	
	@RequestMapping(value = "/home/login/student/marksheet/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchStudentMarksheetList(@ModelAttribute("form") MarksheetForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/student/marksheet/search";
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
					MarksheetDTO dto = new MarksheetDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		MarksheetDTO dto = (MarksheetDTO) form.getDTO();
		
		List<MarksheetDTO> list = service.search(dto, pageNo, pageSize);
		List<MarksheetDTO> totallist = service.search(dto);
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
		return "studentMarksheetList";
	}
}
