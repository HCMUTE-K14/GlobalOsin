package com.tghelper.globalosin.application.service.employee;

import java.io.Serializable;
import java.util.List;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.core.entity.employees.Employees;

public interface EmployeeService extends BaseService<Employees, String>{
	
	List<Employees> findEmployeesByName(String name);
}
