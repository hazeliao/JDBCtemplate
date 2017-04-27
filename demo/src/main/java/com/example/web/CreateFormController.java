package com.example.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	
	private String selectedPrimaryTerms;
	
	@RequestMapping(value="/createForm", method = RequestMethod.GET)
	public String createForm(Model model ){
		Form form = new Form();
		
		// display all industryFields for selection
		List<IndustryField> ifs = DemoApplication.industryFieldDatabase.listIndustryFields();
		
		Map ifsMap = new LinkedHashMap();
		for (int i = 0; i < ifs.size(); i++){
			ifsMap.put(""+ifs.get(i).getId(), ""+ifs.get(i).getName());
		}
		
		model.addAttribute("industryFieldMap", ifsMap);
		
		// display all terms 		
		List<Term> terms = DemoApplication.termDatabase.listTerms();
			
		Map termsMap = new LinkedHashMap();
		for (int j = 0; j < terms.size(); j++){
			termsMap.put(""+terms.get(j).getId(), ""+terms.get(j).getName());
		}
		model.addAttribute("termsMap", termsMap);
		model.addAttribute("form", form);
		return "createForm";
	}
	
	@RequestMapping(value="/formConfirm", method = RequestMethod.POST)
	public String formConfirmation(@ModelAttribute("formX") Form form,BindingResult bindingResult, Model model){
		confirmation = new Form();		
		//System.out.println(form.toString());
		List<IndustryField> industryFields = DemoApplication.industryFieldDatabase.listIndustryFields();
		List<IndustryField> formIndustryFields = new ArrayList<IndustryField>();
		List<String> selectedIfs = form.getIndustryFieldIds();
		for(int i = 0; i < selectedIfs.size(); i++){
			IndustryField industryField = new IndustryField();
			industryField.setId((Integer.parseInt(selectedIfs.get(i))));
			
			for (int a = 0; a < industryFields.size(); a++){
				if (industryFields.get(a).getId() == industryField.getId()){
					industryField = industryFields.get(a);
				}
			}
			formIndustryFields.add(industryField);			
		}
		form.setIndustryFields(formIndustryFields);		
		
		List<Term> allTerms = DemoApplication.termDatabase.listTerms();
		List<Term> terms1 = new ArrayList<Term>();
		List<String> selectedTerms1 = form.getTerms1Ids();
		for(int i = 0; i < selectedTerms1.size(); i++){
			Term term = new Term();
			term.setId((Integer.parseInt(selectedTerms1.get(i))));
			
			for (int a = 0; a < allTerms.size(); a++){
				if (allTerms.get(a).getId() == term.getId()){
					term = allTerms.get(a);
				}
			}
			terms1.add(term);			
		}
		form.setTerms1(terms1);
		System.out.println(form.getTerms1());
		
		List<Term> terms2 = new ArrayList<Term>();
		List<String> selectedTerms2 = form.getTerms2Ids();
		for(int i = 0; i < selectedTerms2.size(); i++){
			Term term = new Term();
			term.setId((Integer.parseInt(selectedTerms2.get(i))));
			
			for (int a = 0; a < allTerms.size(); a++){
				if (allTerms.get(a).getId() == term.getId()){
					term = allTerms.get(a);
				}
			}
			terms2.add(term);			
		}
		form.setTerms2(terms2);
		System.out.println(form.getTerms2());
		
		System.out.println("created FORM::::"+form.toString());
		form.setServiceLevels(DemoApplication.serviceLevelDatabase.listServiceLevels());
		
		confirmation = form;
		model.addAttribute("form", form);
		return "createFormConfirm";
	}

}
