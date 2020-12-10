package com.bed2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	MCQRepository springRepo;
	
	@Autowired
	HibernateRepository hibernateRepo;
	
	@Autowired
	ResultRepository resultRepo;
	
	private String email;
	
	private String pattern = "dd-MM-yyyy HH:mm:ss";
	private SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern);
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/login/do", method = RequestMethod.POST)
	public String validateUser(@ModelAttribute("user") Users user) {
		Users access = repository.findByEmail(user.email);
		email = user.email;
		if(access == null) {
			return "/invalidUser.jsp";
		}
		else if (!access.password.equals(user.password)) {
			return "/passwordError.jsp";
		}
		else if (access.userType.equals("admin"))
			return "/admin.jsp";
		
		return "/candidate.jsp";
	}
	
	@RequestMapping("/register.html")
	public String registerUser() {
		return "register.jsp";
	}

	@RequestMapping(value = "/registration/do", method = RequestMethod.POST)
	public String userRegistered(@ModelAttribute("user") Users user) {
		user.setUserType("candidate");
		repository.save(user);
		return "/successRegister.jsp";
	}
	
	@RequestMapping(value="/springAssessment.html")
	public String springAssessment(ModelMap model) {
		List<SpringMCQs> questions = springRepo.findAll();
		logger.info(""+model.addAttribute("question",questions));
		return "/springAssessment.jsp";
	}
	
	@RequestMapping(value="/hibernateAssessment.html")
	public String hibernateAssessment(ModelMap model) {
		List<HibernateMCQs> questions = hibernateRepo.findAll();
		logger.info(""+model.addAttribute("question",questions));
		return "/hibernateAssessment.jsp";
	}
	
	@RequestMapping(value="/evaluate/{type}/test", method = RequestMethod.POST)
	public String evaluate(@PathVariable("type") String type, 
			@RequestParam("Question1") String opt1,
			@RequestParam("Question2") String opt2,
			@RequestParam("Question3") String opt3,
			@RequestParam("Question4") String opt4,
			@RequestParam("Question5") String opt5) {
		
		int marks=0;
		
		if(type.equals("spring")) {
			type = "Spring";
			if(opt1.equals("J2EE App Development Framework")) {
				marks+=10;
			}
			if(opt2.equals("Inversion Of Control")) {
				marks+=10;
			}
			if(opt3.equals("Aspect Oriented Programming")) {
				marks+=10;
			}
			if(opt4.equals("Application Context")) {
				marks+=10;
			}
			if(opt5.equals("Dispatcher Servlet")) {
				marks+=10;
			}
		}
		else if(type.equals("hibernate")) {
			type = "Hibernate";
			if(opt1.equals("Object Relational Mapping")) {
				marks+=10;
			}
			if(opt2.equals("uni-directional & bi-directional")) {
				marks+=10;
			}
			if(opt3.equals("configuration file")) {
				marks+=10;
			}
			if(opt4.equals("Hibernate Query Language")) {
				marks+=10;
			}
			if(opt5.equals("isolation levels")) {
				System.out.println(opt5);
				marks+=10;
			}
		}
		if(marks>=30) {
			logger.info(""+resultRepo.save(new AssessmentResult(simpleDateFormat.format(new Date()), type+"-L1", marks, email, "Passed")));
			return "/pass.jsp";
		}
		logger.info(""+resultRepo.save(new AssessmentResult(simpleDateFormat.format(new Date()), type+"-L1", marks, email, "Failed")));
		return "/fail.jsp";
	}
	
	@RequestMapping("/users/all")
	public String userDetails(ModelMap model) {
		List<Users> users = repository.findAll(Sort.by("firstName"));
		logger.info(""+model.addAttribute("users",users));
		return "/userDetails.jsp";
	}
	
	@RequestMapping("/tests/all")
	public String testReports(ModelMap model) {
		List<AssessmentResult> reports = resultRepo.findAll();
		logger.info(""+model.addAttribute("reports",reports));
		return "/testReports.jsp";
	}
}