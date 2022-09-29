package com.project.useCase;

import java.util.Scanner;

import com.project.Bean.Tender;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;
import com.project.exception.TenderException;

public class CreateTenderUseCases {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Tender Name:");
		String tname=sc.next();
		
		System.out.println("Type:");
		String type=sc.next();
		
		System.out.println("Price:");
		String price=sc.next();
		
		System.out.println("Deadline:");
		String deadline=sc.next();
		
		System.out.println("Enter Location:");
		String add=sc.next();
		
		
		TenderDao tdao=new TenderDaoImp();
		
		Tender tender=new Tender();
		
		tender.setTname(tname);
		tender.setType(type);
		tender.setPrice(price);
		tender.setDeadline(deadline);
		tender.setLocation(add);
		
		
	   try {
		String result=tdao.createNewTender(tender);
		System.out.println(result);
	} catch (TenderException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
