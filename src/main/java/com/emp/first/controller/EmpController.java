package com.emp.first.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.first.entity.Employee;
import com.emp.first.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	@GetMapping("/")
    public String hello(Model m) {
		
		List<Employee> emp  = service.getEmp();
		m.addAttribute("emp",emp);
		
		return "index";
	}
	@GetMapping("/addemp")
	public String addemp() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg", "Employee saved successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEmpbyid(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee e) {
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {
		service.deletebyid(id);
		session.setAttribute("msg", "Employee deleted successfully...");
		return "redirect:/";
	}
}
