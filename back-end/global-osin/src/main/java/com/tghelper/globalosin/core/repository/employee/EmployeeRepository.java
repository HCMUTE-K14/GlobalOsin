package com.tghelper.globalosin.core.repository.employee;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tghelper.globalosin.core.entity.employees.Employees;


@Repository
public interface EmployeeRepository extends JpaRepository<Employees, String> {
	@Query(value = "SELECT * FROM tbl_employees " +
            "WHERE LOWER(tbl_employees.name) LIKE CONCAT('%', LOWER (:name), '%')", nativeQuery = true)
	List<Employees> findEmployeesByName(@Param("name") String name);
}
