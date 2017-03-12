package com.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DemoApplication;
import com.example.domain.FormTerm;
import com.example.domain.ServiceLevel;
import com.example.domain.Term;
import com.example.domain.TermClass;

@Controller
public class TermController {

	// private ArrayList<ServiceLevel> serviceLevels;

	@RequestMapping(value = "/termlist")
	public String termlist(Model model) {

		FormTerm formTerm = new FormTerm("drinks", DemoApplication.primaryTerms, DemoApplication.secondaryTerms);
		model.addAttribute("formTerm", formTerm);
		model.addAttribute("serviceLevels", DemoApplication.serviceLevels);
		model.addAttribute("forms", DemoApplication.database.listForms());
		//DemoApplication.database.create(id, name);
		//DemoApplication.database.delete(id);
	
		return "index";
	}

	// @RequestMapping(value="/form")
	// public String formlist(Model model){
	// System.out.println("hello world!");
	// return "index";
	// }

}
