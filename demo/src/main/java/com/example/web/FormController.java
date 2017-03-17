package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DemoApplication;

@Controller
public class FormController {


	// private ArrayList<ServiceLevel> serviceLevels;

//	@RequestMapping(value = "/termlist")
//	public String termlist(Model model) {
//
//		//FormTerm formTerm = new FormTerm("drinks", DemoApplication.primaryTerms, DemoApplication.secondaryTerms);
//		Form form = 
//		model.addAttribute("form", form);
//		model.addAttribute("serviceLevels", DemoApplication.serviceLevels);
//		model.addAttribute("forms", DemoApplication.database.listForms());
//		//DemoApplication.database.create(id, name);
//		//DemoApplication.database.delete(id);
//	
//		return "index";
//	}

	@RequestMapping(value="/form/{id}", method = RequestMethod.GET)
	public String formlist(@PathVariable("id") int id, Model model){
		model.addAttribute("form",DemoApplication.database.getForm(id));
		// model.addAttribute("serviceLevels", DemoApplication.database2.listServiceLevels());
		return "form";
	}
	 	
	@RequestMapping(value="/formsubmission", method = RequestMethod.GET)
	public String listFormSubmission(Model model){
		model.addAttribute("formSubmissions", DemoApplication.database3.listFormSubmission());
		return "formsubmission";
	}
	    
}
