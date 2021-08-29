package com.greatlearning.services;

import java.util.*;

import com.greatlearning.models.*;

public class CredentialService {
	private static String companyName;
	
	public static String getCompanyName() {
		return companyName;
	}

	public static void setCompanyName(String companyName) {
		CredentialService.companyName = companyName;
	}

	public String generateEmailAddress(Employee emp, int dept) {
		String department = "";
		 
		 /*
		  * Department mappings 
		  * 1 - Technical
		  * 2 - Admin
		  * 3 - Human Resource
		  * 4 - Legal
		  * */
		 
		 switch(dept) {
		 case 1:	department = "tech";
		 break;
		 
		 case 2:	department = "admin";
		 break;
		 
		 case 3:	department = "hr";
		 break;
		 
		 case 4:	department = "legal";
		 break;
		 }
		 
		 return emp.getFirstName().toLowerCase() + emp.getLastName().toLowerCase() + "." + department + "@" + CredentialService.companyName.toLowerCase() + ".com";
	}
	
	public String generatePassword() {
		final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
		final String UPPER_CASE = LOWER_CASE.toUpperCase();
		final String NUMBERS = "0123456789";
		final String SPECIAL = "!@#$%^&*()+-";
		final String ALLCHARS = LOWER_CASE + UPPER_CASE + NUMBERS + SPECIAL;
		
		Random rand = new Random();
		//char[] password = new char[8];
		ArrayList<Character> password = new ArrayList<>();
		
		password.add(LOWER_CASE.charAt(rand.nextInt(LOWER_CASE.length())));
		password.add(UPPER_CASE.charAt(rand.nextInt(UPPER_CASE.length())));
		password.add(NUMBERS.charAt(rand.nextInt(NUMBERS.length())));
		password.add(SPECIAL.charAt(rand.nextInt(SPECIAL.length())));
		for (int i = 0; i < 4; i++)
			password.add(ALLCHARS.charAt(rand.nextInt(ALLCHARS.length())));
		
		Collections.shuffle(password);
		String pswd = "";
		for (char s: password)
			pswd += s;
		
		return pswd;
	}
	
	public void showCredentials(Employee emp) {
		System.out.println();
		System.out.println("Dear " + emp.getFirstName() + ", your generated credentials are as follows: ");
		System.out.println("Email --> " + emp.getEmailAddress());
		System.out.println("Password --> " + emp.getPassword());
	}

}
