package com.py.assignment.runner.utils;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Utils {

		
	public String changeUpper(String str) {
	
		return str.toUpperCase();
	}
	
}
