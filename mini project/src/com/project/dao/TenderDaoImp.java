package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Bean.Admin;
import com.project.Bean.Tender;
import com.project.Bean.Vendor;
import com.project.exception.AdminException;
import com.project.exception.TenderException;
import com.project.exception.VendorException;
import com.project.utility.DBUtil;

public class TenderDaoImp implements TenderDao{

	
//======================================================admin Login==================================================================================	
		@Override
		public String adminLogin(String email, String password) throws AdminException {

			String admin="Admin Login failed";
			
			try (Connection con=DBUtil.provideConnection()){
				
				PreparedStatement ps=con.prepareStatement("select * from admin where admemail=? AND adminPass=?");
				ps.setString(1, email);
				ps.setString(2, password);
				
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					admin="Login Successful!";
				}
				else
				{
					throw new AdminException("Invalid email and password....");
				}
				
			} catch (SQLException e) {
				throw new AdminException(e.getMessage());
			}
			
			
			
			
			return admin;
		}	
	
	
	
//================================VENDOR REGISTRATION============================================================	
	@Override
	public String registerVendor(Vendor vendor) {
		String message="Not Registered..";
		
		try (Connection con=DBUtil.provideConnection()){
			
			
			PreparedStatement ps=con.prepareCall("insert into vendor(vname,email,password,company,address) values(?,?,?,?,?)");
			
			ps.setString(1,vendor.getVname());
			ps.setString(2,vendor.getEmail());
			ps.setString(3,vendor.getPassword());
			ps.setString(4,vendor.getCompany());
			ps.setString(5,vendor.getAddress());
			
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				message="Vendor Registration Successful!!";
			}
			
			
		} catch (Exception e) {
			message=e.getMessage();
		}
		
		return message;
	}
//===================================================get All Vendor Detail=======================================================================
	@Override
	public List<Vendor> viewAllVendor() throws VendorException {
		
		List<Vendor> vendorList=new ArrayList<>();
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select * from vendor");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int vi=rs.getInt(1);
				String n=rs.getString(2);
				String e=rs.getString(3);
				String p=rs.getString(4);
				String c=rs.getString(5);
				String a=rs.getString(6);
				
				Vendor vendor=new Vendor(vi, n, e, p, c, a);
				
				vendorList.add(vendor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(vendorList.size()==0)
		{
			throw new VendorException("No Vendor found...");	
		}
		
		
		return vendorList;
	}


//===================================================create New Tender===========================================================
	@Override
	public String createNewTender(Tender tender) throws TenderException {
		
		String message="Not Created!";
		
		try (Connection con=DBUtil.provideConnection()){
			

			PreparedStatement ps=con.prepareStatement("insert into tender(tname,type,price,deadline,location) values(?,?,?,?,?)");
			ps.setString(1,tender.getTname());
			ps.setString(2,tender.getType());
			ps.setInt(3,tender.getPrice());
			ps.setString(4,tender.getDeadline());
			ps.setString(5,tender.getLocation());
						
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				message="Tender Created Successful!";
			}
			
			
		} catch (Exception e) {
			message=e.getMessage();
		}
		
		return message;
	}

	//===============================viewAllTender=========================================================
public ArrayList<Tender>  viewAllTender() {
		
	ArrayList<Tender> list=new ArrayList<>();
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select * from tender");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int vi=rs.getInt(1);
				String n=rs.getString(2);
				String e=rs.getString(3);
				int p=rs.getInt(4);
				String c=rs.getString(5);
				String a=rs.getString(6);
				
				Tender td = new Tender(vi, n, e, p, c, a);
				
				list.add(td);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(list.size()==0)
		{
			System.out.println("");
//			throw new VendorException("No Vendor found...");	
		}
		
		
		return list;
	}



	
//=======================================================================================//

//=======================================Vendor Login ================================================================================
	@Override
	public String vendorLogin(String email, String password) throws VendorException {
	
		String vendor=null;
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select * from vendor where email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				vendor= "Success";
			}
			else
			{
				throw new VendorException("Invalid email and password....");
			}
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		return vendor;
	}


//===============================================AssignTenderToVendor======================================================
	@Override
	public String AssignTenderToVendor(int tid, int vid) throws TenderException, VendorException {
		String message="Tender Not Assigned!";
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("insert into ten_ven values(?,?)");
			ps.setInt(1, tid);
			ps.setInt(2, vid);
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				message="Tender Assigned!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TenderException("Invalid Tender ID...");
		}
		
		
		return message;
	}
	

//==================================================view All Tender==========================================================================================
	
//	@Override
//	public ArrayList<Tender> viewAllTender(int vid) {
//		
//		ArrayList<Tender> tenderlist=null;
//		
//	
//		try (Connection con=DBUtil.provideConnection()){
//			
//			PreparedStatement ps=con.prepareCall("select t.* from tender t INNER JOIN ten_ven tv ON t.?=tv.?;");
////			ps.setInt(1, tid);
//			ps.setInt(2, vid);
//			
//			ResultSet rs  = ps.executeQuery();
//			
//			while(rs.next()) 
//			{
//				
//				int i=rs.getInt(1);
//				String n=rs.getString(2);
//				String t=rs.getString(3);
//				int p=rs.getInt(4);
//				String d=rs.getString(5);
//				String l=rs.getString(6);
//				
//			Tender tender=new Tender(i, n, t, p, d, l);
//			
//			tenderlist.add(tender);
//			}
//			
//		}catch (Exception e) {
////			throw new TenderException(e.getMessage());
//			e.printStackTrace();
//		}
//		
//		
//		if(tenderlist.size()==0)
//		{
////			throw new TenderException("No Tender found...");	
//		}
//		
//		
//		
//		return tenderlist;
//	}

//============================================BID ON TENDER ============================================================================

	@Override
	public String BidOnTender(int tid,int vid,int bid) {

		String message="BID FAILED !";
		
//		int id=GetTenderId(type);
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("insert into bid values(?,?,?)");
			ps.setInt(1,tid);
			ps.setInt(2,vid);
			ps.setInt(3, bid);
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				message="Bid is register";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return message;
	}



	@Override
	public int GetTenderId(String type) {
		int id=0;
		
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select tid from tender where type=?");
			ps.setString(1, type);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				id=rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return id;
	}



	

	
//============================================================================================================================================	

	
	@Override
	public int getVidByBid() {
		int vid=0;
		
		try (Connection con=DBUtil.provideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select v1id from bid where bid=(select min(bid) from bid)");
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				vid=rs.getInt("v1id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return vid;
	}

//==============================================================================
}
	