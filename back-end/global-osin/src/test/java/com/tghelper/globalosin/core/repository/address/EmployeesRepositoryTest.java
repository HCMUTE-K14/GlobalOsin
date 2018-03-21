package com.tghelper.globalosin.core.repository.address;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tghelper.globalosin.core.entity.employees.Employees;
import com.tghelper.globalosin.core.repository.employee.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeesRepositoryTest {
	@Autowired
	EmployeeRepository mEmployeeRepository;
	
	@Test
	public void Test() {
		/*System.out.println(mEmployeeRepository==null?"bo":"ki");
		List<Employees> sfd=mEmployeeRepository.findAll();
		
		System.out.println("dsfdsf:"+sfd.get(0).getId());
		List<Employees> sdfsd=mEmployeeRepository.findEmployeesByName("a");
		System.out.println("sau:"+sdfsd.get(0).getId());*/
		
		Employees employees=new Employees();
		employees.setName("dsfdsf");
		employees.setUser_id("sdfdsfdsewrewr");
		Employees em=mEmployeeRepository.save(employees);
		em.toString();
	}
}
