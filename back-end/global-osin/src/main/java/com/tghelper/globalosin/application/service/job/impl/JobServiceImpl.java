package com.tghelper.globalosin.application.service.job.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tghelper.globalosin.application.service.BaseServiceImpl;
import com.tghelper.globalosin.application.service.job.JobService;
import com.tghelper.globalosin.core.entity.job.Job;
import com.tghelper.globalosin.core.repository.job.JobRepository;
import com.tghelper.globalosin.exception.EntityDoesNotExistException;
import com.tghelper.globalosin.exception.UpdateEntityException;
@Service
public class JobServiceImpl extends BaseServiceImpl<Job, String, JobRepository> implements JobService {

	protected JobServiceImpl(JobRepository repository) {
		super(repository);
	}

	@Override
	public List<Job> findJobByDepartment(String dep_id) {
		try {
			List<Job> jobs = this.mRepository.findJobByDepartmant(dep_id);
			if (jobs == null) {
				throw new EntityDoesNotExistException(dep_id + " does not exist");
			}
			return jobs;
		} catch (Exception ex) {
			throw new EntityDoesNotExistException(dep_id + " does not exist", ex);
		}
	}

	@Override
	public Job update(Job entity) {

		try {
			Job job = findById(entity.getId());

			job.update(entity.getName(),entity.getSalary(),entity.getDescription(),entity.getDep_id());

			return mRepository.save(job);
		} catch (Exception ex) {
			throw new UpdateEntityException("Something went wrong when updating Address", ex);
		}
	}

	@Override
	public List<Job> findAll() {
		return super.findAll();
	}

	@Override
	public void create(Job entity) {
		super.create(entity);
	}

	@Override
	public void delete(String id) {
		super.delete(id);
	}

}
