package com.project.useCase;

import java.util.List;

import com.project.Bean.Tender;
import com.project.dao.TenderDao;
import com.project.dao.TenderDaoImp;

public class ViewAllTendersUseCases {

	public static void main(String[] args) {
		
		TenderDao dao=new TenderDaoImp();
		
		
		try {
			
			List<Tender> tenders=dao.viewAllTender();
			
				tenders.forEach(t->{
				System.out.println("Tender Id: "+t.getTid());
				System.out.println("Tender Name: "+t.getTname());
				System.out.println("Tender type: "+t.getType());
				System.out.println("Tender price: "+t.getPrice());
				System.out.println("Deadline: "+t.getDeadline());
				System.out.println("Location: "+t.getLocation());
				System.out.println();
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
