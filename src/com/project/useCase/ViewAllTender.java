//package com.project.useCase;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.project.Bean.Tender;
//import com.project.dao.TenderDao;
//import com.project.dao.TenderDaoImp;
//import com.project.exception.TenderException;
//
//public class ViewAllTender {
//
//	public static void main(String[] args) {
//		
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("Enter TenderID:");
//		int tid=sc.nextInt();
//		
//		System.out.println("Enter VendorId:");
//		int vid=sc.nextInt();
//		
//		TenderDao dao=new TenderDaoImp();
//		
////		try {
////			ArrayList<Tender> tender=dao.viewAllTender(tid, vid);
//			
//			for(Tender t:tender)
//			{
//				System.out.println(t.getTid());
//				System.out.println(t.getTname());
//				System.out.println(t.getType());
//				System.out.println(t.getPrice());
//				System.out.println(t.getDeadline());
//				System.out.println(t.getLocation());
//			}
//			
////		} catch (TenderException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//
//	}
//
//}
