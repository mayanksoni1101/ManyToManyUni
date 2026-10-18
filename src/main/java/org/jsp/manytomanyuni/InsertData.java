package org.jsp.manytomanyuni;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		
		Batch b1 = new Batch();
		b1.setBatchCode("A18");
		b1.setSubject("Java");
		b1.setTrainer("Abhi Sir");
		
		Batch b2 = new Batch();
		b2.setBatchCode("M15");
		b2.setSubject("Hibernate");
		b2.setTrainer("Mayank Sir");
		
		Batch b3 = new Batch();
		b3.setBatchCode("A86");
		b3.setSubject("Spring");
		b3.setTrainer("Anugraha Sir");
		
		Student s1 = new Student();
		s1.setName("Mohit");
		s1.setMarks(98);
		s1.setPhone(9876543210l);
		
		Student s2 = new Student();
		s2.setName("Mayank");
		s2.setMarks(99);
		s2.setPhone(9485688456l);
		
		Student s3 = new Student();
		s3.setName("Badal");
		s3.setMarks(65);
		s3.setPhone(9785634120l);
		
		Student s4 = new Student();
		s4.setName("Aryan"); 
		s4.setMarks(86);
		s4.setPhone(982343210l);
		
		Student s5 = new Student();
		s5.setName("Kuldeep");
		s5.setMarks(79);
		s5.setPhone(6176543210l);
		
		Student s6 = new Student();
		s6.setName("Cloud");
		s6.setMarks(69);
		s6.setPhone(9861543210l);
		
		b1.setStd(Arrays.asList(s1,s2,s3,s4,s5,s6));
		b2.setStd(Arrays.asList(s2,s4,s6));
		b3.setStd(Arrays.asList(s1,s3,s5));
		
		List<Batch> bl = Arrays.asList(b1,b2,b3);
		for(Batch b : bl) {
			em.persist(b);
		}
		etran.commit();
		
	}
}
