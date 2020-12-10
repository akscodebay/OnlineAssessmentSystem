package com.bed2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class OnlineAssessmentSystemApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	MCQRepository mcqRepo;
	
	@Autowired
	HibernateRepository hibernateRepo;
	
	@Autowired
	ResultRepository resultRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineAssessmentSystemApplication.class, args);
	}
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		logger.info(""+repo.save(new Users("roger@gmail.com", "Roger", "Kutcher", "wipro@123", "admin")));
		logger.info(""+repo.save(new Users("steve@gmail.com", "Steve", "Martin", "wipro@123", "admin")));
		
		logger.info(""+mcqRepo.save(new SpringMCQs("What is spring?", "J2EE App Server", "J2EE App Development Framework", "Configuration Management Tool", "Build tool")));
		logger.info(""+mcqRepo.save(new SpringMCQs("What is the full form of IOC?", "Inversion Of Control", "Interjection of Control", "Internal Object Control", "In-built Object Control")));
		logger.info(""+mcqRepo.save(new SpringMCQs("What is the full form of AOP?", "Anticipation of Properties", "Aspect Oriented Programming", "Associated Object Programming", "Anti Object Programming")));
		logger.info(""+mcqRepo.save(new SpringMCQs("Which of the below is a spring container?", "View Resolver", "Application Context", "Handler Mapping", "Dispatcher Servlet")));
		logger.info(""+mcqRepo.save(new SpringMCQs("Which is Spring's front Controller Implementation?", "Bean Factory", "Class Path Application Context", "Application Context", "Dispatcher Servlet")));
		
		logger.info(""+hibernateRepo.save(new HibernateMCQs("What is the full form of ORM?", "Object Random Memory", "Object Relational Mismatch", "Object Relational Mapping", "Object Random Mapping")));
		logger.info(""+hibernateRepo.save(new HibernateMCQs("In Hibernate, based on directionality, what could be the mappings?", "uni-directional & bi-directional", "one-to-many & many-to-one", "inheritance mapping", "north & south mapping")));
		logger.info(""+hibernateRepo.save(new HibernateMCQs("In an Hibernate application, which file would have datasource details?", "hibernate mapping file", "configuration file", "Model/Entity class", "HibernateUtil class")));
		logger.info(""+hibernateRepo.save(new HibernateMCQs("What is the full form of HQL?", "High-level Query Language", "Hidden Query Language", "Hibernate Query Language", "Hibernate Quadratic Language")));
		logger.info(""+hibernateRepo.save(new HibernateMCQs("In an Hibernate application, concurrency can be controlled by setting?", "concurrency level", "one-to-one mapping", "many-to-one bi-directional mapping", "isolation levels")));
		
	}

}
