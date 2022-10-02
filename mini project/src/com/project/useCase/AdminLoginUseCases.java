//package com.project.useCase;
//
//import java.util.Scanner;
//
//import com.project.Bean.Admin;
//import com.project.dao.TenderDao;
//import com.project.dao.TenderDaoImp;
//import com.project.exception.AdminException;
//
//public class AdminLoginUseCases {
//
//	public static void main(String[] args)throws AdminException {
//		
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("Enter email:");
//		String email=sc.next();
//		
//		System.out.println("Enter Password:");
//		String pass=sc.next();
//		
//		TenderDao dao=new TenderDaoImp();
//		
//		try {
//			Admin admin=new Admin();
//			
//			admin.setAdmemail(email);
//			admin.setAdmpassword(pass);
//			
//			String admins=dao.adminLogin(email, pass);
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//}
