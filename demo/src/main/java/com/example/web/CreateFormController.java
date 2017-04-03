package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DemoApplication;
import com.example.domain.Form;
import com.example.domain.Term;

@Controller
public class CreateFormController {
	
	@RequestMapping(value="/createForm", method = RequestMethod.GET)
	public String createForm(Model model ){
		
		Form form = new Form();
		List<Term> terms = DemoApplication.termDatabase.listTerms();
		model.addAttribute("terms", terms);
		
		return "createForm";
	}
	

}
