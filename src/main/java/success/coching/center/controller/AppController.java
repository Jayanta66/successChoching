package success.coching.center.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import success.coching.center.beans.Student;
import success.coching.center.beans.User;
import success.coching.center.repository.UserRepository;
import success.coching.center.service.StudentService;
import success.coching.center.service.SecurityService;

@Controller
public class AppController {
	@Autowired
	private StudentService service;
	
	 	
	@RequestMapping({"/","index"})
	public String viewHomePagee(Model model, @Param("keyword") String keyword) {
		List<Student> listStudent = service.listAll(keyword);

		int totalstudent  = listStudent.size();

		model.addAttribute("totalstudent", totalstudent);
		model.addAttribute("listStudent", listStudent);
		model.addAttribute("keyword", keyword);
		
		return "/index";
	}
	
	@RequestMapping("/index")
	public String viewHomePage1(Model model, @Param("keyword") String keyword) {
		List<Student> listStudent = service.listAll(keyword);
		model.addAttribute("listStudent", listStudent);
		model.addAttribute("keyword", keyword);
		
		return "/index";
	}
	
	
	
	@RequestMapping("/listStudent")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {

		
		List<Student> listStudent = service.listAll(keyword);
		
		
		int totalStudent  = listStudent.size();

		model.addAttribute("listStudent", listStudent);
		
		
		
		model.addAttribute("totalStudent", totalStudent);

		
		model.addAttribute("keyword", keyword);
		
		return "/listStudent";
	}
	
	
	
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "new_student";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("listStudent") Student listStudent) {
		service.save(listStudent);
		
		return "redirect:/listStudent";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_student");
		
		Student student = service.get(id);
		mav.addObject("student", student);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/listStudent";
	}
	
	///======================================================================
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping({"/login"})
	public String login() {
		return "login";
		}
	
	@GetMapping({"/home"})
	public String home() {
		return "home";
		}
	

	
	@PostMapping("/login")
	public String longinresponse(String email, String password,HttpServletRequest request, HttpServletResponse response) {
		boolean loginResponse = securityService.longin(email, password,request, response);

		if(loginResponse) {
			return "/joblist";
		}
		return "login";
		
	}
		
	@GetMapping("/registration")
	public String registration() {
		return "registration";
		}
	
	@PostMapping("/registration")
	public String register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login";
		}


}
