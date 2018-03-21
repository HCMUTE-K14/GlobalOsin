package com.tghelper.globalosin.application.service.customer.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.customer.CustomerService;
import com.tghelper.globalosin.core.entity.customer.Customer;
import com.tghelper.globalosin.core.entity.employees.Employees;
import com.tghelper.globalosin.core.repository.customer.CustomerRepository;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.UpdateEntityException;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, String, CustomerRepository>
		implements CustomerService {

	protected CustomerServiceImpl(CustomerRepository repository) {
		super(repository);
	}

	@Override
	public List<Customer> findCustomerByName(String name) {
		try {
			List<Customer> customers = this.mRepository.findCustomerByName(name.trim());
			if (customers == null) {
				throw new EntityDoesNotExistException(name + " does not exist");
			}

			return customers;
		} catch (Exception ex) {
			throw new EntityDoesNotExistException(name + " does not exist", ex);
		}
	}

	@Override
	public Customer update(Customer entity) {
		try {
			Customer customer = findById(entity.getId());
			
			customer.update(entity.getName(),entity.getBirthday(),entity.getPhone_number(),entity.getUser_id(),entity.getAccess_id());

			return mRepository.save(customer);
		} catch (Exception ex) {
			throw new UpdateEntityException("Something went wrong when updating Address", ex);
		}
	}

	@Override
	public List<Customer> findAll() {
		return super.findAll();
	}

	@Override
	public void create(Customer entity) {
		super.create(entity);
	}

	@Override
	public void delete(String id) {
		super.delete(id);
	}

}
