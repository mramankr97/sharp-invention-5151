package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import com.project.Bean.Admin;
import com.project.Bean.Tender;
import com.project.Bean.Vendor;
import com.project.exception.AdminException;
import com.project.exception.TenderException;
import com.project.exception.VendorException;

public interface TenderDao {

	public String adminLogin(String email, String password)throws AdminException;
	
	public String registerVendor(Vendor vendor);
	
	public List<Vendor> viewAllVendor()throws VendorException;
	
	public String createNewTender(Tender tender)throws TenderException;
	
//	public List<Tender> viewAllTender()throws TenderException;
	
	public String vendorLogin(String email, String password)throws VendorException;
	
	public String AssignTenderToVendor(int tid,int vid)throws TenderException,VendorException;
	
	public String BidOnTender(int tid, int vid,int bid);
	public int GetTenderId(String type); //take type and return id
	
	public ArrayList<Tender> viewAllTender();  

	public int getVidByBid();
	
}
