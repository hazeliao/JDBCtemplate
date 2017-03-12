package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.ServiceLevel;
import com.example.domain.Term;
import com.example.domain.TermClass;
import com.example.domain.TermClassComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public static ArrayList<ServiceLevel> serviceLevels;
	
	public static ArrayList<TermClass> classes;
	
	public static ArrayList<Term> primaryTerms;
	
	public static ArrayList<Term> secondaryTerms;
	
	@Bean
	public CommandLineRunner demo(){
		return(args) -> {
			log.info("save a couple of cps");
			
			
			// Create users: admin/admin user/user
//			TermClass class1 = new TermClass(1);
//			TermClass class2 = new TermClass(2);
//			TermClass class3 = new TermClass(3);
//			TermClass class4 = new TermClass(4);
//			TermClass class5 = new TermClass(5);
//			TermClass class6 = new TermClass(6);
			classes = new ArrayList<TermClass>();
			for ( int i = 0; i < 6; i++ )
			{
				classes.add( new TermClass(i+1) );
			}
			
			primaryTerms =  new ArrayList<Term>();
			secondaryTerms = new ArrayList<Term>();
			Term term1 = new Term(1, "Milkshake",classes.get(0));
			Term term2 = new Term(2, "Hotchocolate",classes.get(2));
			Term term3 = new Term(3, "coffee",classes.get(1));
			Term term4 = new Term(4, "tea",classes.get(0));	
			Term term5 = new Term(5, "water",classes.get(3));
							
			primaryTerms.add(term1);
			primaryTerms.add(term3);
			primaryTerms.add(term4);
			
			Collections.sort(primaryTerms, new TermClassComparator());
			
			//primaryTerms.sort(primaryTerms);
			secondaryTerms.add(term2);
			secondaryTerms.add(term5);
			
			serviceLevels=new ArrayList<ServiceLevel>();
					
			ServiceLevel level1=new ServiceLevel(1, "Basic Service", 295);
			ServiceLevel level2=new ServiceLevel(2, "Advanced Service", 595);
			ServiceLevel level3=new ServiceLevel(3, "Premium Service", 895);
			
			serviceLevels.add(level1);
			serviceLevels.add(level2);
			serviceLevels.add(level3);
			
			log.info("Testing my cool Bean!");
			
	
		};
	}
}
