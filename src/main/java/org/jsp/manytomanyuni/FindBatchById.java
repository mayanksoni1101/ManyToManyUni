package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchById {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch Id : ");
		Batch b = em.find(Batch.class, sc.nextInt());
		if(b!=null) {
			System.out.println(b);
		}
		else {
			System.err.println("No Record Found !!!");
		}
		try {
			
		}
		finally {
			sc.close();
		}
	}
}
