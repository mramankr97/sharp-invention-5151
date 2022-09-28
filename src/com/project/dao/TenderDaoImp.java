package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.project.bean.Vendor;
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

}
