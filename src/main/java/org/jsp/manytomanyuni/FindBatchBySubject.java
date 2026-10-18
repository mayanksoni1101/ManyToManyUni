package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchBySubject {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select b from Batch b where b.subject = ?1");
		System.out.println("Enter Subject to find Batch : ");
		q.setParameter(1, sc.next());
		Batch b = (Batch) q.getSingleResult();
		if(b!=null) {
			System.out.println(b);
		}
		else {
			System.err.println("No Record found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	
	}
}
