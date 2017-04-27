package com.example.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DemoApplication;
import com.example.domain.Form;
import com.example.domain.IndustryField;
import com.example.domain.Term;

@Controller
public class CreateFormController {
	
	private Form confirmation = null;
	
	@RequestMapping(value="/createForm", method = RequestMethod.GET)
	public String createForm(Model model ){
		Form form = new Form();
		model.addAttribute("form", form);
		// display all industryFields for selection
		List<IndustryField> ifs = DemoApplication.industryFieldDatabase.listIndustryFields();
		
		Map ifsMap = new LinkedHashMap();
		for (int i = 0; i < ifs.size(); i++){
			ifsMap.put(""+ifs.get(i).getId(), ifs.get(i).getName());
		}
		
		model.addAttribute("industryFieldMap", ifsMap);
		
		// display all terms 		
		List<Term> terms = DemoApplication.termDatabase.listTerms();
		Map termsMap = new LinkedHashMap();
		for (int j = 0; j < terms.size(); j++){
			termsMap.put(""+terms.get(j).getId(), terms.get(j).getName());
		}
		model.addAttribute("termsMap", termsMap);
		return "createForm";
	}
	
	@RequestMapping(value="/formConfirm", method = RequestMethod.POST)
	public String formConfirmation(@ModelAttribute("form") Form form,BindingResult bindingResult, Model model){
		confirmation = new Form();
		
		//string allprimaryterms
		
		//find primary terms from
			//form.terms2
		
		
		return "formConfirm";
	}

}
