package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.models.*;
import com.greatlearning.services.*;

public class Driver {

	public static void main(String[] args) {
		CredentialService credService = new CredentialService();
		CredentialService.setCompanyName("GreatLearning");	//Not taking Company name as input from user
		
		Employee emp = new Employee();
		int dept;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Employee portal!");
		System.out.println("Enter first name : ");
		emp.setFirstName(sc.next());
		
		System.out.println("Enter last name : ");
		emp.setLastName(sc.next());
		
		while (true) {
			System.out.println("Please enter your department as per below list: ");
			System.out.println("1. Technical");
			System.out.println("2. Administrator");
			System.out.println("3. Human Resources");
			System.out.println("4. Legal");
			
			dept = sc.nextInt();
			if (dept == 1 || dept == 2 || dept == 3 || dept == 4)
				break;
			
			System.out.println("Invalid department number. Please enter valid amount!");
			System.out.println();
		}
		
		emp.setEmailAddress(credService.generateEmailAddress(emp, dept));
		emp.setPassword(credService.generatePassword());
		
		credService.showCredentials(emp);
		sc.close();
	}

}
