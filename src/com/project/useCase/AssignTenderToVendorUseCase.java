package com.project.useCase;

import java.util.Scanner;

import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;

public class AssignTenderToVendorUseCase {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter TenderID:");
		int tid=sc.nextInt();
		
		System.out.println("Enter VendorId:");
		int vid=sc.nextInt();
		
		
		TenderDao dao=new TenderDaoImp();
		
		String result=null;
		
		try {
		result = dao.AssignTenderToVendor(tid, vid);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(result);
	}

}
