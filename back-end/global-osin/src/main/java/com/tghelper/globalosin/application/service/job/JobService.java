package com.tghelper.globalosin.application.service.job;

import java.util.List;

import com.tghelper.globalosin.application.service.BaseService;
import com.tghelper.globalosin.core.entity.job.Job;

public interface JobService extends BaseService<Job, String> {
	List<Job> findJobByDepartment(String dep_id);
}
