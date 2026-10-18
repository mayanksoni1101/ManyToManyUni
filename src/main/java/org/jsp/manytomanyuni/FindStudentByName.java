package org.jsp.manytomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByName {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select s from Student s where s.name = ?1");
		System.out.println("Enter Student Name : ");
		q.setParameter(1, sc.nextLine());
		@SuppressWarnings("unchecked")
		List<Student> stdl = q.getResultList();
		if(!stdl.isEmpty()) {
			stdl.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!");
		}
		try {}
		finally {
			sc.close();
		}
	
	}
}
