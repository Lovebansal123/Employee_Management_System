package com.emp.first.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class Sessionhelper {
   public void removemsg() {
	   try {
		   HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		   session.removeAttribute("msg");
	   }catch (Exception e) {
		e.printStackTrace();
	}
   }
}