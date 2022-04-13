package com.example.springbootsmsapp.controller;



import com.example.springbootsmsapp.entity.Student;
import com.example.springbootsmsapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String listStudents(Model theModel) {

        List<Student> students = studentService.findAll();
        theModel.addAttribute("students",students);
        return "list-students"; // /WEB-INF/views/list-students.jsp

    }
    @RequestMapping(value = "/403")
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;

    }
    @RequestMapping("/showFormForAdd")
    public String showFormforAdd(Model theModel) {
        Student theStudent = new Student();

        theModel.addAttribute("Student",theStudent);

        return "Student-form";

    }
    @RequestMapping("/showFormForUpdate")
    public String showFormforUpdate(@RequestParam("studentId") Long id,Model theModel) {
        Student theStudent = studentService.findById(id);

        theModel.addAttribute("Student",theStudent);

        return "Student-form";

    }
    @PostMapping("/save")
    public String saveStudents(@RequestParam("id") Long id,
                               @RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("course") String course,@RequestParam("country") String country) {

        System.out.println(id);

        Student theStudent;

        if(id!=0) {
            theStudent  = studentService.findById(id);
            theStudent.setFname(fname);
            theStudent.setLname(lname);
            theStudent.setCountry(country);
            theStudent.setCourse(course);
        }
        else
            theStudent = new Student(fname,lname,course,country);
        studentService.save(theStudent);

        return "redirect:/students/list";

    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") Long theId) {

        // delete the Student
        studentService.deleteById(theId);

        // redirect to /Students/list
        return "redirect:/students/list";

    }
}
