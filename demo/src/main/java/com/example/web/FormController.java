package com.example.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DemoApplication;
import com.example.domain.Form;
import com.example.domain.FormSubmission;
import com.example.domain.ServiceLevel;

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
		
		FormSubmission formSubmission= new FormSubmission();
		
		Form theForm = DemoApplication.formDatabase.getForm(id);
		model.addAttribute("form", theForm);
		formSubmission.setFormId(id);
		model.addAttribute("formSubmission",formSubmission);
		
		List<ServiceLevel> serviceLevels= theForm.getServiceLevels();
		Map serviceLevelMap = new LinkedHashMap();
		for (int i = 0; i < serviceLevels.size(); i++){
			serviceLevelMap.put((""+serviceLevels.get(i).getId()), serviceLevels.get(i).getName()+"  Attorney free "+serviceLevels.get(i).getPrice());
		}
		model.addAttribute("serviceLevelMap", serviceLevelMap);
	    
		// model.addAttribute("serviceLevels", DemoApplication.database2.listServiceLevels());
		return "form";
	}
	 	
	@RequestMapping(value="/formSubmission", method = RequestMethod.POST)
	public String FormSubmission(@ModelAttribute("formSubmission") FormSubmission formSubmission, BindingResult bindingResult){
		System.out.println("small stuff");
		System.out.println(formSubmission.toString());
				
		DemoApplication.formSubmissionDatabase.created(formSubmission);
		//model.addAttribute("formSubmissions", DemoApplication.database3.listFormSubmission());
		
		return "formsubmission";
	}
	    
}
