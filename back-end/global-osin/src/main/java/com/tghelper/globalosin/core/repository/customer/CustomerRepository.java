package com.tghelper.globalosin.core.repository.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tghelper.globalosin.core.entity.customer.Customer;
import com.tghelper.globalosin.core.entity.employees.Employees;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	@Query(value = "SELECT * FROM tbl_customer " +
            "WHERE LOWER(tbl_customer.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
	List<Customer> findCustomerByName(@Param("name") String name);
}
