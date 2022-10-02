package com.project.SwitchCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.project.Bean.Admin;
import com.project.Bean.Tender;
import com.project.Bean.Vendor;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;
import com.project.exception.TenderException;



public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		while(true) {
usecase usecase=new usecase();
		
		System.out.println("WELCOME TO TENDER MANAGEMENT SYSTEM");
		
		 BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		
		System.out.println("Select 1 for Administration");
		System.out.println("Select 2 for Vendor");
		
		int choice=Integer.parseInt(sc.readLine().trim());
		
		switch (choice) {
		case 1: 
			
			
			System.out.println("Select 1 for Login with his account");	
			int y=Integer.parseInt(sc.readLine().trim());
			
			switch(y) 
			{
			case 1:
				if(usecase.loginAdmin()) 
				{
					while(true) {
					System.out.println("Select 1 for Register new Vendor.");
					System.out.println("Select 2 for View all the vendors.");
					System.out.println("Select 3 fro Create new tenders.");
					System.out.println("Select 4 for View All the Tenders.");
//					System.out.println("Select 5 for View All the Bids of a tender.");
					System.out.println("Select 6 for Assign tender to a vendor.");
					
					int x=Integer.parseInt(sc.readLine().trim());
					switch (x) 
					{
						case 1: usecase.createNewVendor();
						break;
					
						case 2:usecase.viewAllVendor();
					    break;
					    
						case 3:usecase.createTender();
						break;
						
						case 4:usecase.viewAllTender();
						break;
						
//						case 5:usecase.viewAllBid();
//						break;
						
						case 6:usecase.assignTenderToVendor();
						break;
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + x);
					}
				}
			}
			}
			break;
			
			
		case 2:
			
			System.out.println("Select 1 for Login with his account");	
			int z=Integer.parseInt(sc.readLine().trim());
			
			switch(z) 
			{
			case 1:
				if(usecase.vendorLogin())
				{
					while(true) {
					
					System.out.println("Select 1 for View all the current Tenders.");
					System.out.println("Select 2 for Place a Bid against a Tender.");
//					System.out.println("Select 3 fro  View status of a Bid (Whether Selected or Not)");
					System.out.println("Select 4 for View his own Bid History.");
				
					
					int x=Integer.parseInt(sc.readLine().trim());
					switch (x) 
					{
						case 1: usecase.viewAllTender();
						break;
					
						case 2:
							usecase.placeBid();
					    break;
					    
					    default: System.out.println("Chill ");
					}
					
					
					
					
					
					
					
					
					
					
					
					
					}
			}
			}
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	}
}
