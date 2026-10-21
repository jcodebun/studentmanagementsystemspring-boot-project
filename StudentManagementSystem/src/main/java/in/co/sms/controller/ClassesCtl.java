package in.co.sms.controller;

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
import in.co.sms.exception.DuplicateRecordException;
import in.co.sms.form.ClassesForm;
import in.co.sms.service.ClassesServiceInt;


@Controller
public class ClassesCtl extends BaseCtl {

	private Logger log = Logger.getLogger(ClassesCtl.class.getName());
	@Autowired
	private ClassesServiceInt service;
	
	@GetMapping("/home/login/classes")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") ClassesForm form,
			HttpSession session, Model model) {
		if (form.getId() > 0) {
			ClassesDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "classes";
	}

	@PostMapping("/home/login/classes")
	public String submit(@Valid @ModelAttribute("form") ClassesForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/classes";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "classes";
				}
				ClassesDTO bean = (ClassesDTO) populateDTO(form.getDTO(),request);
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Class update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Class Added Successfully!!!!");
				}
				return "classes";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "classes";
		}
		return "";
	}

	@RequestMapping(value = "/home/login/classes/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") ClassesForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/classes/search";
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
					ClassesDTO dto = new ClassesDTO();
					dto.setId(id);
					service.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		ClassesDTO dto = (ClassesDTO) form.getDTO();
		
		List<ClassesDTO> list = service.search(dto, pageNo, pageSize);
		List<ClassesDTO> totallist = service.search(dto);
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
		return "classesList";
	}
}
