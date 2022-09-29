package com.project.useCase;

import java.util.Scanner;

import com.project.Bean.Vendor;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;

public class VendorLoginUseCase {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email:");
		String email=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		TenderDao dao=new TenderDaoImp();
		
		try {
			Vendor vendor=new Vendor();
			
			vendor.setEmail(email);
			vendor.setPassword(pass);
			
			Vendor vendors=dao.vendorLogin(email, pass);
			
			System.out.println("WELCOME "+vendors.getVname().toUpperCase());
			System.out.println("VendorID: "+vendors.getVid());
			System.out.println("Comapny: "+vendors.getCompany());
			System.out.println("Address: "+vendors.getAddress());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
