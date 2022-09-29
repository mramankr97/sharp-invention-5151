package com.project.useCase;

import java.util.Scanner;

import com.project.Bean.Admin;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;
import com.project.exception.AdminException;

public class AdminLoginUseCases {

	public static void main(String[] args)throws AdminException {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email:");
		String email=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		TenderDao dao=new TenderDaoImp();
		
		try {
			Admin admin=new Admin();
			
			admin.setAdmemail(email);
			admin.setAdmpassword(pass);
			
			Admin admins=dao.adminLogin(email, pass);
			
			
			System.out.println("Admin Id: "+admins.getAid());
			System.out.println("Admin Name: "+admins.getAname());
			System.out.println("Admin Email: "+admins.getAdmemail());
			System.out.println("Admin Password: "+admins.getAdmpassword());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
