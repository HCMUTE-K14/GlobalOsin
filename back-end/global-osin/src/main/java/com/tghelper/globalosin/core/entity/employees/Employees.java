package com.tghelper.globalosin.core.entity.employees;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tghelper.globalosin.core.entity.BaseEntity;
import com.tghelper.globalosin.core.entity.customer.Customer;
import com.tghelper.globalosin.core.entity.job.Job;


@Entity(name="Employees")
@Table(name="tbl_employees")
public class Employees extends BaseEntity implements Serializable {
	
	@Column(name="user_id")
	@NotNull
	private String user_id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="birthday")
	//@NotNull
	private Date birthday;
	
	@Column(name="sex")
	//@NotNull
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	@Column(name="phone_number")
	//@NotNull
	private String phone_number;
	
	@Column(name="identify_id")
	//@NotNull
	private String identifi_id;
	
	@Column(name="address_id")
	//@NotNull
	private String address_id;
	
	@Column(name="home_town")
	//@NotNull
	private String home_town;
	
	@Column(name="strong_point")
	//@NotNull
	private String strong_point;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "employees")
	private List<Customer> customers;
	
	@ManyToMany
	@JoinTable(name = "tbl_emp_job",
	              joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
	              inverseJoinColumns = {
	              @JoinColumn(name = "job_id", referencedColumnName = "id")}
	)
	private List<Job> jobs;
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public void update(Object... fields) {
		this.user_id=((String)fields[0]).trim();
		this.name=((String)fields[1]).trim();
		this.birthday=(Date)fields[2];
		this.sex=(Sex)fields[3];
		this.phone_number=((String)fields[4]).trim();
		this.identifi_id=((String)fields[5]).trim();
		this.address_id=((String)fields[6]).trim();
		this.home_town=((String)fields[7]).trim();
		this.strong_point=((String)fields[8]).trim();
		
	}
	
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Sex getSex() {
		return sex;
	}


	public void setSex(Sex sex) {
		this.sex = sex;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getIdentifi_id() {
		return identifi_id;
	}


	public void setIdentifi_id(String identifi_id) {
		this.identifi_id = identifi_id;
	}


	public String getAddress_id() {
		return address_id;
	}


	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}


	public String getHome_town() {
		return home_town;
	}


	public void setHome_town(String home_town) {
		this.home_town = home_town;
	}


	public String getStrong_point() {
		return strong_point;
	}


	public void setStrong_point(String strong_point) {
		this.strong_point = strong_point;
	}
	

	
	
	
	@Override
	public String toString() {
		return "Employees [user_id=" + user_id + ", name=" + name + ", birthday=" + birthday + ", sex=" + sex
				+ ", phone_number=" + phone_number + ", identifi_id=" + identifi_id + ", address_id=" + address_id
				+ ", home_town=" + home_town + ", strong_point=" + strong_point + "]";
	}
	
}
