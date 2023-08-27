package com.company.servicename.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.servicename.Constants;
import com.company.servicename.Grade;
import com.company.servicename.Repository.GradeRepository;
import com.company.servicename.Service.GradeService;


// @Controller is also a bean which creates a sping bean GradeController
// And this is how it handles all the web requests
// All the beans are stored inside the spring container
@Component
@Controller
public class GradeController {
    
    @Autowired
    GradeService gradeService;

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Grade grade) {
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }

}
