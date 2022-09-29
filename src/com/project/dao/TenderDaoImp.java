package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.Vendor;
import com.project.exception.VendorException;
import com.project.utility.DBUtil;

public class TenderDaoImp implements TenderDao{

//================================VENDOR REGISTRATION============================================================	
	@Override
	public String registerVendor(Vendor vendor) {
		String message="Not Registered..";
		
		try (Connection con=DBUtil.provideConnection()){
			
			
			PreparedStatement ps=con.prepareStatement("insert into vendor(vname,email,password,company,address) values(?,?,?,?,?)");
			
			ps.setString(1,vendor.getVname());
			ps.setString(2,vendor.getEmail());
			ps.setString(3,vendor.getPassword());
			ps.setString(4,vendor.getCompany());
			ps.setString(5,vendor.getAddress());
			
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				message="Vendor Registration Successful!";
			}
			
			
		} catch (Exception e) {
			message=e.getMessage();
		}
		
		return message;
	}
//===================================================get All Vendor Detail=======================================================================
	@Override
	public List<Vendor> getAllVendorDetail() throws VendorException {
		
		List<Vendor> vendorList=new ArrayList<>();
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select * from vendor");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				String vi=rs.getString("vid");
				String n=rs.getString("vname");
				String e=rs.getString("email");
				String p=rs.getString("password");
				String c=rs.getString("company");
				String a=rs.getString("address");
				
				Vendor vendor=new Vendor(vi, n, e, p, c, a);
				
				vendorList.add(vendor);
			}
			
		} catch (Exception e) {
			throw new VendorException(e.getMessage());
		}
		
		
		if(vendorList.size()==0)
		{
			throw new VendorException("No Vendor found...");	
		}
		
		
		return vendorList;
	}

}
