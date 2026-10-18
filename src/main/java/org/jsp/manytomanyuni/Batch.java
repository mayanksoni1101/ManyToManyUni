package org.jsp.manytomanyuni;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String batchCode;
	private String subject;
	private String trainer;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student> std;

	
	//getter and setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Student> getStd() {
		return std;
	}

	public void setStd(List<Student> std) {
		this.std = std;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", batchCode=" + batchCode + ", subject=" + subject + ", trainer=" + trainer + "]";
	}
	
	
	
}
