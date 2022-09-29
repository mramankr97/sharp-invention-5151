package com.project.useCase;

import java.util.ArrayList;
import java.util.List;

import com.project.Bean.Vendor;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;

public class ViewAllTheVendor {

	public static void main(String[] args) {
		
		TenderDao tdao=new TenderDaoImp();
		try {

			List<Vendor> vendor=new ArrayList<>();
			
			vendor.forEach(v->{
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

}
