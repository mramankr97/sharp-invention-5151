package com.project.SwitchCase;

import java.util.List;
import java.util.Scanner;

import com.project.Bean.Admin;
import com.project.Bean.Vendor;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;

class usecase {
	
	static Scanner sc=new Scanner(System.in);
	
	public boolean loginAdmin() {
		
		boolean temp=false;
		
//		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email:");
		String email=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		TenderDao dao=new TenderDaoImp();
		
		try {
			Admin admin=new Admin();
			
			admin.setAdmemail(email);
			admin.setAdmpassword(pass);
			
			String admins=dao.adminLogin(email, pass);
			
			if(admins.equals("Login Successful!"))
			{
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return temp;
	}
	
	public void registervendor() {
//		Scanner sc=new Scanner(System.in);
		
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
	
	
	
public void viewAllVendor() {
	TenderDao dao=new TenderDaoImp();
	
	
	try {
		
		List<Vendor> vendors=dao.viewAllVendor();
		
		vendors.forEach(v->{
			System.out.println("Vendor Id: "+v.getVid());
			System.out.println("Vendor Name: "+v.getVname());
			System.out.println("Email: "+v.getEmail());
			System.out.println("Password: "+v.getPassword());
			System.out.println("Company: "+v.getCompany());
			System.out.println("Address: "+v.getAddress());
			System.out.println();
		});
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void createNewVendor() {
//	Scanner sc=new Scanner(System.in);
	
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


public void viewAllTender() {

}


public void viewAllBid() {
	
}

public void assignTenderToVendor() {
	
	TenderDao dao=new TenderDaoImp();
	
	int vid=dao.getVidByBid();
	
	System.out.println("Enter TenderID:");
	int tid=sc.nextInt();
	
	String result=null;
	
	try {
	result = dao.AssignTenderToVendor(tid, vid);
	
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println(result);

}



public boolean vendorLogin()
{
	boolean temp=false;
	
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
	
	return temp;
}

}

public class Home{
  public static void main(String[] args) {
	
	  usecase usecase=new usecase();
		
		System.out.println("WELCOME TO TENDER MANAGEMENT SYSTEM");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Select 1 for Administration");
		System.out.println("Select 2 for Vendor");
		
		int choice=sc.nextInt();
		
		switch (choice) {
		case 1: 
			System.out.println("Select 1 for Login with his account");	
			int y=sc.nextInt();
			
			switch(y) 
			{
			case 1:
				if(usecase.loginAdmin()) 
				{
					System.out.println("Select 1 for Register new Vendor.");
					System.out.println("Select 2 for View all the vendors.");
					System.out.println("Select 3 fro Create new tenders.");
					System.out.println("Select 4 for View All the Tenders.");
					System.out.println("Select 5 for View All the Bids of a tender.");
					System.out.println("Select 6 for Assign tender to a vendor.");
					
					int x=sc.nextInt();
					switch (x) 
					{
						case 1: usecase.registervendor();
						break;
					
						case 2:usecase.viewAllVendor();
					    break;
					    
						case 3:usecase.viewAllVendor();
						break;
						
						case 4:usecase.viewAllTender();
						break;
						
						case 5:usecase.viewAllBid();
						break;
						
						case 6:usecase.assignTenderToVendor();
						break;
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + x);
					}
				}
			
			}
			break;
			
			
		case 2:
			System.out.println("Select 1 for Login with his account");	
			int z=sc.nextInt();
			
			switch(z) 
			{
			case 1:
				if(usecase.vendorLogin())
				{
					System.out.println("Select 1 for View all the current Tenders.");
					System.out.println("Select 2 for Place a Bid against a Tender.");
					System.out.println("Select 3 fro  View status of a Bid (Whether Selected or Not)");
					System.out.println("Select 4 for View his own Bid History.");
				}
			}
			
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}

}   
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
}