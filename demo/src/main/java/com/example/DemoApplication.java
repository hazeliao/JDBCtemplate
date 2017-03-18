package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.dao.imp.FormDaoImpl;
import com.example.dao.imp.FormSubmissionDaoImpl;
import com.example.dao.imp.IndustryFieldImpl;
import com.example.dao.imp.ServiceLevelDaoImpl;
import com.example.domain.Form;
import com.example.domain.FormSubmission;
import com.example.domain.ServiceLevel;
import com.example.domain.Term;



import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	public static ArrayList<ServiceLevel> serviceLevels;
//	
//	public static ArrayList<TermClass> classes;
//	
//	public static ArrayList<Term> primaryTerms;
//	
//	public static ArrayList<Term> secondaryTerms;
	
	public static FormDaoImpl formDatabase = new FormDaoImpl();
	
	public static ServiceLevelDaoImpl serviceLevelDatabase = new ServiceLevelDaoImpl();
	
	public static FormSubmissionDaoImpl formSubmissionDatabase = new FormSubmissionDaoImpl();
	
	public static IndustryFieldImpl industryFieldDatabase = new IndustryFieldImpl();
	@Bean
	public CommandLineRunner demo(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		return(args) -> {
			log.info("save a couple of cps");
			
			// database = new FormDaoImpl();
			formDatabase.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
			industryFieldDatabase.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
			serviceLevelDatabase.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
			formSubmissionDatabase.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
			
			List<ServiceLevel> serviceLevels = serviceLevelDatabase.listServiceLevels();
			
			Form form = formDatabase.getForm(101);
			ArrayList<ServiceLevel> sl = form.getServiceLevels();
			System.out.println("muumi: " + form.getTerms1().toString());
			System.out.println("muumi.size(): " + serviceLevels.size());
			System.out.println("muumi: " + sl.toString());
			System.out.println("muumi.size(): " + sl.size());
			
			
			List<FormSubmission> formSubmissions = formSubmissionDatabase.listFormSubmission();
			System.out.println("formSubmissions: " + formSubmissions.toString());
			//TEST DATABASE VALUES: Remember that two creates of the same value crash the app!
			ArrayList<Term> terms = new ArrayList<Term>();
			terms.add(formDatabase.getForm(101).getTerms1().get(0));
			System.out.println("terms: " + terms);
			//database3.create(10005, 101, 22, "xxx@xx.com", "Blueberry", terms);
			//FormSubmission fs= new FormSubmission(10005, 101, 22, "xxx@xx.com", "Blueberry", terms);
			//System.out.println("FormSubmission: " + fs);
			//formSubmissionDatabase.created(fs);
			System.out.println("formsubmissions: " + formSubmissionDatabase.listFormSubmission());
			
			
			
			// Create users: admin/admin user/user
			/*classes = new ArrayList<TermClass>();
			for ( int i = 0; i < 6; i++ )
			{
				classes.add( new TermClass(i+1) );
			}
						
			primaryTerms =  new ArrayList<Term>();
			secondaryTerms = new ArrayList<Term>();
			Term term1 = new Term(1, "Milkshake",classes.get(0));
			Term term2 = new Term(2, "Hot Chocolate",classes.get(2));
			Term term3 = new Term(3, "Coffee",classes.get(1));
			Term term4 = new Term(4, "Tea",classes.get(0));	
			Term term5 = new Term(5, "Water",classes.get(3));
							
			primaryTerms.add(term1);
			primaryTerms.add(term3);
			primaryTerms.add(term4);
			
			Collections.sort(primaryTerms, new TermClassComparator());

			secondaryTerms.add(term2);
			secondaryTerms.add(term5);
			
			Collections.sort(secondaryTerms, new TermClassComparator());
			
			*/

					

		};
	}
}
