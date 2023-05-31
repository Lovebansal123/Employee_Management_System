package com.emp.first.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emp.first.entity.Employee;
import com.emp.first.repository.EmpRepo;

@Service
public class EmpService {
   
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	}
	
	public List<Employee> getEmp(){
		return repo.findAll();
	}
	
	public Employee getEmpbyid(int id) {
		Optional<Employee> e =  repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	public void deletebyid(int id) {
		repo.deleteById(id);
	}
	
}
