package org.jsp.manytomanyuni;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentWhosePerMore60 {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select s from Student s where marks >= 60");
		@SuppressWarnings("unchecked")
		List<Student> stdl = q.getResultList();
		System.out.println("Student with more than 60 percentage");
		if(!stdl.isEmpty()) {
			stdl.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!");
		}
	}
}
