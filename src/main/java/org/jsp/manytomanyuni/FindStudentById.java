package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentById {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID : ");
		Student s = em.find(Student.class, sc.nextInt());
		if(s!=null) {
			System.out.println(s);
		}
		else {
			System.err.println("No Record Found!!!");
		}
		try {}
		finally {
			sc.close();
		}
	}
}
