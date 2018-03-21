package com.tghelper.globalosin.core.entity.job;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tghelper.globalosin.core.entity.BaseEntity;
import com.tghelper.globalosin.core.entity.employees.Employees;

@Entity(name="Job")
@Table(name="tbl_job")
public class Job extends BaseEntity implements Serializable{
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="salary")
	@NotNull
	private double salary;
	
	@Column(name="description")
	@NotNull
	private String description;
	
	@Column(name="dep_id")
	@NotNull
	private String dep_id;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "jobs")
	private List<Employees> employees;
	
	public String getDep_id() {
		return dep_id;
	}


	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Job [name=" + name + ", salary=" + salary + ", description=" + description + ", dep_id=" + dep_id
				+ "]";
	}
	@Override
	public void update(Object... fields) {
		// TODO Auto-generated method stub
		this.name=(String)fields[0];
		this.salary=(Double)fields[1];
		this.description=(String)fields[2];
	}
	
}
