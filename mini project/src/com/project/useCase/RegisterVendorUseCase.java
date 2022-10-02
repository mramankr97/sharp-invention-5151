package com.project.useCase;

import java.util.Scanner;

import com.project.Bean.Vendor;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;

public class RegisterVendorUseCase {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Vendor Name:");
		String vname=sc.next();
		
		System.out.println("Enter Email:");
		String email=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		System.out.println("Enter Your Company:");
		String comp=sc.next();
		
		System.out.println("Enter Address:");
		String add=sc.next();
		
		
		TenderDao tdao=new TenderDaoImp();
		
		Vendor vendor=new Vendor();
		
		vendor.setVname(vname);
		vendor.setEmail(email);
		vendor.setPassword(pass);
		vendor.setCompany(comp);
		vendor.setAddress(add);
		
		
		String result=tdao.registerVendor(vendor);
		
		System.out.println(result);
		

	}

}
