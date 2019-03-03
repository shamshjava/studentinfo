package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	
	 @Autowired
	 StudentDao sdao;
	 
	
	 @RequestMapping("/userlogin")
	    public String userValidation() {
	        return "User: Successfully logged in!";

	       
	    }

	    @RequestMapping("/adminlogin")
	    public String adminValidation() {
	        return "Admin: Successfully logged in!";

	    } 
	 
	@RequestMapping(path={"/","/home"})
	public ModelAndView home(Model model) {
		System.out.println("Hi Shamshir Alam");

		ModelAndView mv = new ModelAndView("studentinput");
		mv.addObject("student",new Student());
		return mv;
		/*model.addAttribute("student", new Student());
		return "studentinput";*/
	}

	
	@RequestMapping("/addupdateStudent") 
	public String addupdateStudent(Student student) {
		System.out.println("Hi add"); 
		sdao.save(student);
		return "redirect:/findAllStudent";
  }
	@RequestMapping("/editStudent") 
	public ModelAndView editStudent(@RequestParam int id) {
		System.out.println("Hi edit"); 
		ModelAndView mv = new ModelAndView("studentinput");
		Optional<Student> student  = sdao.findById(id);
		mv.addObject("student",student);
		return mv;
  }
	@RequestMapping("/findStudent") 
	public ModelAndView findStudent(@RequestParam int id) {
		System.out.println("Hi find"); 
		ModelAndView mv = new ModelAndView("studentinfo");
		List<Student> list = new ArrayList<Student>();
		Student student  = sdao.findById(id).orElse(new Student());
		if(student.getId() != 0) {
			list.add(student);
		}
		mv.addObject("list",list);
		return mv;
  }
	@Cacheable(value="cacheStudentInfo")
	@RequestMapping("/findAllStudent") 
	public ModelAndView findAllStudent() {
		System.out.println("Display All Students"); 
		ModelAndView mv = new ModelAndView("studentinfo");
		List<Student> list = (List<Student>) sdao.findAll();
		mv.addObject("list",list);
		return mv;
  }
	@RequestMapping("/deleteStudent") 
	public String deleteStudent(int id) {
		System.out.println("Hi delete"); 
		sdao.deleteById(id);
		return "redirect:/findAllStudent";
  }
	 

}
