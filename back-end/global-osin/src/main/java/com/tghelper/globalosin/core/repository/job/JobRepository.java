package com.tghelper.globalosin.core.repository.job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tghelper.globalosin.core.entity.job.Job;



@Repository
public interface JobRepository  extends JpaRepository<Job, String>{
	@Query(value = "SELECT * FROM tbl_job " +
            "WHERE tbl_job.dep_id=:dep_id", nativeQuery = true)
	List<Job> findJobByDepartmant(@Param("dep_id") String dep_id);
	
}
