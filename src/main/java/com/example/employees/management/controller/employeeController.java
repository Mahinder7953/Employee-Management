package com.example.employees.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.employees.management.entity.employee;
import com.example.employees.management.service.employeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class employeeController {
    @Autowired
    private employeeService employeeServ;

    @GetMapping("/")
    public String getEmployees(Model model) {
        model.addAttribute("employees",employeeServ.getEmployees());
        return "index";
    }
    
    @GetMapping("/add")
    public String addForm() {
        return "addForm";
    }
    

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute employee newEmployee) {
        employeeServ.addEmployee(newEmployee);
        return "redirect:/";
    }
    
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id,Model model) {
        model.addAttribute("employeeData", employeeServ.updateForm(id));
        return "updateForm";
    }
    

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") employee updateData) {
        employeeServ.updateEmployee(updateData,id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeServ.deleteEmployee(id);
        return "redirect:/";
    }
    
    
}
