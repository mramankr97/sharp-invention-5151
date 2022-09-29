package com.project.dao;

import java.util.List;

import com.project.Bean.Vendor;
import com.project.exception.VendorException;

public interface TenderDao {

	public String registerVendor(Vendor vendor);
	
	
	public List<Vendor> getAllVendorDetail()throws VendorException;
}
