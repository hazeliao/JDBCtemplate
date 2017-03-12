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

		// TermClass class1 = new TermClass(1);
		// TermClass class2 = new TermClass(2);
		// TermClass class3 = new TermClass(3);
		// TermClass class4 = new TermClass(4);
		// TermClass class5 = new TermClass(5);
		// TermClass class6 = new TermClass(6);
		// ArrayList<TermClass> classes =new ArrayList<TermClass>();
		// classes.add(class1);
		// classes.add(class2);
		// classes.add(class3);
		// classes.add(class5);
		// classes.add(class4);
		// classes.add(class6);
		// ArrayList<Term> terms1 = new ArrayList<Term>();
		// ArrayList<Term> terms2 = new ArrayList<Term>();
		// Term term1 = new Term(1, "Milkshake",DemoApplication.classes.get(1));
		// terms1.add(term1);
		// Term term2 = new Term(2,
		// "Hotchocolate",DemoApplication.classes.get(2));
		// terms2.add(term2);
		// Term term3 = new Term(3, "coffee",DemoApplication.classes.get(3));
		// terms1.add(term3);
		// Term term4 = new Term(4, "tee",DemoApplication.classes.get(2));
		// terms2.add(term4);
		// Term term5 = new Term(5, "water",DemoApplication.classes.get(4));
		// terms2.add(term5);
		// System.out.print(terms1);
		// System.out.print(terms2);
		// model.addAttribute("terms1", terms1);
		// model.addAttribute("terms2", terms2);
		FormTerm formTerm = new FormTerm("drinks", DemoApplication.primaryTerms, DemoApplication.secondaryTerms);
		model.addAttribute("formTerm", formTerm);

		// List<ServiceLevel> serviceLevels= new ArrayList<ServiceLevel>();
		// ServiceLevel level1=new ServiceLevel(1, "Basic Service", 295);
		// ServiceLevel level2=new ServiceLevel(2, "Advanced Service", 595);
		// ServiceLevel level3=new ServiceLevel(3, "Premium Service", 895);
		// serviceLevels.add(level1);
		// serviceLevels.add(level2);
		// serviceLevels.add(level3);
		// System.out.print(serviceLevels);
		model.addAttribute("serviceLevels", DemoApplication.serviceLevels);

		return "index";
	}

	// @RequestMapping(value="/form")
	// public String formlist(Model model){
	// System.out.println("hello world!");
	// return "index";
	// }

}
