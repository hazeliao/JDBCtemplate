package com.example.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

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
import com.example.domain.Term;

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
		
		Form form = DemoApplication.formDatabase.getForm(id);
		model.addAttribute("form", form);
		formSubmission.setFormId(id);
		model.addAttribute("formSubmission",formSubmission);
		/*
		List<Term> terms1 = form.getTerms1();
		Map terms1Map = new HashMap();	
		for (int b = 0 ; b < terms1.size(); b++){
			
				terms1Map.put((""+terms1.get(b).getId()), terms1.get(b));
				//newMap.put((""+terms1.get(b).getId()), terms1.get(b).getName()+", " +terms1.get(b).getTermClass().getTermClassId());
				
		}
		model.addAttribute("termMap1", terms1Map);
		
		*/
		List<Term> terms1 = form.getTerms1();
		Map terms1Map = new HashMap();		
		for (int a = 0; a < terms1.size(); a++)
		{
			int x = (int)terms1.get(a).getTermClass().getTermClassId();
			Map newMap = new LinkedHashMap();
			boolean foundAtleastOneClassIdMatch = false;
			for (int b = 0 ; b < terms1.size(); b++){
				if (x == (int)terms1.get(b).getTermClass().getTermClassId()){
					//newMap.put((""+terms1.get(b).getId()), terms1.get(b));
					newMap.put((""+terms1.get(b).getId()), terms1.get(b).getName());
					foundAtleastOneClassIdMatch = true;
				}
			}
			if ( foundAtleastOneClassIdMatch )
				terms1Map.put(""+x, newMap);
		}		
		//Sort it by classid.
		Map<String, LinkedHashMap> map = new TreeMap<String, LinkedHashMap>(terms1Map);		
		System.out.println(map);
		model.addAttribute("terms1Map", map);
			
		
		List<Term> terms2 = form.getTerms2();
		Map terms2Map = new HashMap();		
		for (int a = 0; a < terms2.size(); a++)
		{
			int x = (int)terms2.get(a).getTermClass().getTermClassId();
			Map newMap = new LinkedHashMap();
			boolean foundAtleastOneClassIdMatch = false;
			for (int b = 0 ; b < terms2.size(); b++){
				if (x == (int)terms2.get(b).getTermClass().getTermClassId()){
					newMap.put((""+terms2.get(b).getId()), terms2.get(b).getName()+", " +terms2.get(b).getTermClass().getTermClassId());
					foundAtleastOneClassIdMatch = true;
				}
			}
			if ( foundAtleastOneClassIdMatch )
				terms2Map.put(""+x, newMap);
		}		
		//Sort it by classid.
		Map<String, LinkedHashMap> map2 = new TreeMap<String, LinkedHashMap>(terms2Map);		
		System.out.println(map2);
		model.addAttribute("terms2Map", map2);
				
		List<ServiceLevel> serviceLevels= form.getServiceLevels();
		System.out.println(serviceLevels);
		Map serviceLevelMap = new LinkedHashMap();
		
		for (int i = 0; i < serviceLevels.size(); i++){
			serviceLevelMap.put((""+serviceLevels.get(i).getId()), serviceLevels.get(i).getName()+"  Attorney free "+serviceLevels.get(i).getPrice());
			System.out.println(serviceLevelMap);
		}
		model.addAttribute("serviceLevelMap", serviceLevelMap);
	    
		// model.addAttribute("serviceLevels", DemoApplication.database2.listServiceLevels());
		return "form";
	}
	 	
	@RequestMapping(value="/formSubmission", method = RequestMethod.POST)
	public String FormSubmission(@ModelAttribute("formSubmission") FormSubmission formSubmission,BindingResult bindingResult, Model model){
		System.out.println("small stuff");
		System.out.println(formSubmission.toString());
		Form form =  DemoApplication.formDatabase.getForm((int) formSubmission.getFormId());
		List<Term> terms = new ArrayList<Term>();
		terms.addAll(form.getTerms1());
		terms.addAll(form.getTerms2());
		List<Term> parsedTerms = new ArrayList<Term>();
		
		List<String> userChoices = formSubmission.getTermIds();
		for ( int i = 0; i < userChoices.size(); i++ )
		{
			Term term = new Term();
			term.setId((Integer.parseInt(userChoices.get(i)) ));
			
			for ( int a = 0; a < terms.size(); a++ )
			{
				if ( terms.get(a).getId() == term.getId() )
				{
					term = terms.get(a);
				}
			}
	//		term = terms.;
					//(Integer.parseInt(userChoices.get(i)) );
			parsedTerms.add(term);
		}
		formSubmission.setTerms(parsedTerms);
		System.out.println(parsedTerms);
				
		DemoApplication.formSubmissionDatabase.createFormSubmission(formSubmission);
		
		//model.addAttribute("formSubmissions", DemoApplication.database3.listFormSubmission());
//		System.out.println("formsubmissions: " + DemoApplication.formSubmissionDatabase.listFormSubmission());
		List<FormSubmission> ls = DemoApplication.formSubmissionDatabase.listFormSubmission();
		formSubmission.setId(ls.get(ls.size()-1).getId());
		
		DemoApplication.formSubmissionDatabase.createFormSubmissionTerm(formSubmission);
		model.addAttribute("formSubmission", DemoApplication.formSubmissionDatabase.getFormSubmission((int)formSubmission.getId()));
		return "formsubmission";
	}
	    
}
