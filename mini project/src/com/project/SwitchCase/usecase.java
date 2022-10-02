package com.project.SwitchCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.Bean.Admin;
import com.project.Bean.Tender;
import com.project.Bean.Vendor;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;
import com.project.exception.TenderException;

class usecase {
	
	TenderDao dao=new TenderDaoImp();
	

	 BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
//	sc.readLine(); Integer.parseInt(sc.readLine().trim());
	public boolean loginAdmin() throws IOException {
		
		boolean temp=false;

		
		System.out.println("Enter email:");
		String email = null;
		try {
			email = sc.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Enter Password:");
		String pass=sc.readLine();
		
		
		try {
			Admin admin=new Admin();
			
			admin.setAdmemail(email);
			admin.setAdmpassword(pass);
			
			String admins=dao.adminLogin(email, pass);
			
			if(admins.equals("Login Successful!"))
			{
				temp=true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return temp;
	}
	
//	public void registervendor() throws IOException {
////		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("Enter Vendor Name:");
//		String vname=sc.readLine();
//		
//		System.out.println("Enter Email:");
//		String email=sc.readLine();
//		
//		System.out.println("Enter Password:");
//		String pass=sc.readLine();
//		
//		System.out.println("Enter Your Company:");
//		String comp=sc.readLine();
//		
//		System.out.println("Enter Address:");
//		String add=sc.readLine();
//		
//		
////		TenderDao tdao=new TenderDaoImp();
//		
//		Vendor vendor=new Vendor(0);
//		
//		vendor.setVname(vname);
//		vendor.setEmail(email);
//		vendor.setPassword(pass);
//		vendor.setCompany(comp);
//		vendor.setAddress(add);
//		
//		
//		String result= dao.registerVendor(vendor);
//		
//		System.out.println(result);
//		
//
//	}
//	
	
	
public void viewAllVendor() {
	
	
	
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

public void createNewVendor() throws IOException {
//	Scanner sc=new Scanner(System.in);
	
	
	System.out.println("Enter Vendor Name:");
	String vname=sc.readLine(); 
	
	System.out.println("Enter Email:");
	String email=sc.readLine(); 
	
	System.out.println("Enter Password:");
	String pass=sc.readLine(); 
	
	System.out.println("Enter Your Company:");
	String comp=sc.readLine(); 
	
	System.out.println("Enter Address:");
	String add=sc.readLine(); 
	
	
	TenderDao tdao=new TenderDaoImp();
	
	Vendor vendor=new Vendor(0,vname,email,pass,comp,add);
	
//	vendor.setVname(vname);
//	vendor.setEmail(email);
//	vendor.setPassword(pass);
//	vendor.setCompany(comp);
//	vendor.setAddress(add);
	
	
	String result=tdao.registerVendor(vendor);
	
	System.out.println(result);
	
}


public void createTender() throws IOException {
	
	System.out.println("Enter Tender Name:");
	String tname=sc.readLine(); 
	
	
	System.out.println("Type:");
	String type=sc.readLine(); 
	
	System.out.println("Price:");
	int price=Integer.parseInt(sc.readLine().trim());
	
	System.out.println("Deadline (yy-mm-dd)");
	String deadline=sc.readLine(); 
	
	System.out.println("Enter Location:");
	String add=sc.readLine(); 
	
	
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


public void viewAllTender() {
	
	ArrayList<Tender> td = dao.viewAllTender();
	
	td.forEach(v->{
		System.out.println("name : "+v.getTname());
		System.out.println("Tid : "+v.getTid());
		System.out.println("prince: "+v.getPrice());
		System.out.println("location: "+v.getLocation());
		System.out.println("deadline: "+v.getDeadline());
		System.out.println("type: "+v.getType());
		System.out.println();
	});
	
	
}
//bid pandding
//
//public void viewAllBid() {
//	
//}

public void assignTenderToVendor() throws NumberFormatException, IOException {
	
	TenderDao dao=new TenderDaoImp();
	
	int vid=dao.getVidByBid();
	
	System.out.println("Enter TenderID:");
	int tid= Integer.parseInt(sc.readLine());
	
	String result=null;
	
	try {
	result = dao.AssignTenderToVendor(tid, vid);
	
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println(result);

}



public boolean vendorLogin() throws IOException
{
	boolean temp=false;
	
	
	
	System.out.println("Enter email:");
	String email=sc.readLine(); 
	
	System.out.println("Enter Password:");
	String pass=sc.readLine(); 
	
	
	
	try {
		Vendor vendor=new Vendor();
		String chill = null;
		vendor.setEmail(email);
		vendor.setPassword(pass);
		
		chill   =dao.vendorLogin(email, pass);
		
		if(chill.equals("Success"))temp = true;
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	return temp;
}


public String placeBid() throws NumberFormatException, IOException {
	
	System.out.println("Enter TenderID:");
	int a= Integer.parseInt(sc.readLine());
	System.out.println("Ente rvendor ID:");
	int b= Integer.parseInt(sc.readLine());
	System.out.println("Enter bid amount:");
	int c= Integer.parseInt(sc.readLine());
	
	String s = dao.BidOnTender(a, b, c);
	return s;
	
	
	
}



}

