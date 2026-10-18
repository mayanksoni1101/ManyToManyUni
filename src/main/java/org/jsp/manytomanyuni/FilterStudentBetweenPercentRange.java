package org.jsp.manytomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FilterStudentBetweenPercentRange {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<Student> q = em.createQuery("select s from Student s where marks >= ?1 and marks <= ?2", Student.class);
		System.out.println("Enter Starting Percentage Student Range : ");
		q.setParameter(1, sc.nextDouble());
		System.out.println("Enter Ending Percantage Student Range : ");
		q.setParameter(2, sc.nextDouble());
		List<Student> stdl = q.getResultList();
		if(!stdl.isEmpty()) {
			stdl.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	}
}
