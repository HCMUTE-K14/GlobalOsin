package com.tghelper.globalosin.core.entity.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tghelper.globalosin.core.entity.BaseEntity;
import com.tghelper.globalosin.core.entity.employees.Employees;

@Entity(name="Customer")
@Table(name="tbl_customer")
public class Customer extends BaseEntity implements Serializable {
	
	@Column(name="name")
	private String name;
	
	@Column(name="birth_day")
	private Date birthday;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="access_id")
	private String access_id;
	
	@ManyToMany
	@JoinTable(name = "tbl_emp_cus",
	              joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
	              inverseJoinColumns = {
	              @JoinColumn(name = "employee_id", referencedColumnName = "id")}
	)
	private List<Employees> employees;
	
	 
	public List<Employees> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	@Override
	public void update(Object... fields) {
		this.name=(String)fields[0];
		this.birthday=(Date)fields[1];
		this.phone_number=(String)fields[2];
		this.user_id=(String)fields[3];
		this.access_id=(String)fields[4];
		
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
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAccess_id() {
		return access_id;
	}
	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", birthday=" + birthday + ", phone_number=" + phone_number + ", user_id="
				+ user_id + ", access_id=" + access_id + ", employees=" + employees + "]";
	}
	
	
	
}
