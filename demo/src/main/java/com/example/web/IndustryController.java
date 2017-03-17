package com.example.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DemoApplication;
import com.example.domain.IndustryField;



@Controller
public class IndustryController {
		
	@RequestMapping(value="/industryPage", method = RequestMethod.GET)
	 public String formlist( Model model){
		
		 List<IndustryField> ls0 = DemoApplication.database1.listIndustryFields();
		 
//		 List<IndustryField> ls = new ArrayList<IndustryField>();
//		 for(int i = 0; i < ls.size() ; i++){
//			forms = IndustryApplication.database.getIndustryField(ls.get(i).getId()).getForms();
//		 }
	
		 model.addAttribute("industryFields", ls0);
		 return "industrypage";
	 }
	
	

}
		
