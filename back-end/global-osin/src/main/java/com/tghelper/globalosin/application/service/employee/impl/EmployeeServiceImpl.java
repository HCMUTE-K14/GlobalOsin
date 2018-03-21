package com.tghelper.globalosin.application.service.employee.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.employee.EmployeeService;
import com.tghelper.globalosin.core.entity.address.Address;
import com.tghelper.globalosin.core.entity.address.ProvinceCity;
import com.tghelper.globalosin.core.entity.employees.Employees;
import com.tghelper.globalosin.core.repository.address.AddressRepository;
import com.tghelper.globalosin.core.repository.employee.EmployeeRepository;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.UpdateEntityException;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employees, String, EmployeeRepository> implements EmployeeService {

	protected EmployeeServiceImpl(EmployeeRepository repository) {
		super(repository);
	}
	@Override
	public List<Employees> findEmployeesByName(String name) {
		  try {
	            List<Employees> employees = this.mRepository.findEmployeesByName(name.trim());
	            if (employees == null) {
	                throw new EntityDoesNotExistException(name + " does not exist");
	            }
	            
	            return employees;
	        } catch (Exception ex) {
	            throw new EntityDoesNotExistException(name + " does not exist", ex);
	        }
	}

	@Override
	public List<Employees> findAll() {
		return super.findAll();
	}
	@Override
	public Employees update(Employees entity) {
		 try {
			 Employees employees = findById(entity.getId());
	            
			 employees.update(entity.getUser_id(),entity.getName(),entity.getBirthday(),entity.getSex(),entity.getPhone_number(),entity.getIdentifi_id(),
					 entity.getAddress_id(),entity.getHome_town(),entity.getStrong_point());
	            
	            return mRepository.save(employees);
	        } catch (Exception ex) {
	            throw new UpdateEntityException("Something went wrong when updating Address", ex);
	        }
	}
	@Override
	public void create(Employees entity) {
		super.create(entity);
	}
	@Override
	public void delete(Employees entity) {
		super.delete(entity);
	}
	
	

}
