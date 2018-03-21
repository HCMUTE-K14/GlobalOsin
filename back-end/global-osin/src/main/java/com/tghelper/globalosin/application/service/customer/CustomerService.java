package com.tghelper.globalosin.application.service.customer;

import java.util.List;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.core.entity.customer.Customer;

public interface CustomerService extends BaseService<Customer, String>{
	List<Customer> findCustomerByName(String name);
}

