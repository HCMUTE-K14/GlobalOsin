package com.tghelper.globalosin.application.api.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tghelper.globalosin.application.api.AbstractApiController;
import com.tghelper.globalosin.application.model.JsonResponse;
import com.tghelper.globalosin.application.service.job.JobService;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.entity.job.Job;

@RestController
public class JobController extends AbstractApiController {
	public static final String BASE_URL = "/job";

	private final JobService mJobService;

	@Autowired
	public JobController(JobService jobservice) {
		this.mJobService = jobservice;
	}

	@RequestMapping(value = BASE_URL, method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse getAllJob() {
		LOGGER.info("[INFO] GET JOB");
		List<Job> list = mJobService.findAll();

		return new JsonResponse.Builder<List<Job>>()
				.setData(list)
				.setHttpStatus(HttpStatus.OK)
				.isSuccess(true)
				.build();
	}
	@RequestMapping(value = BASE_URL + "/{dep_id}", method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse getJobByDepartment(@PathVariable("dep_id") String dep_id) {
		LOGGER.info("[INFO] GET JOB:" + dep_id);
		List<Job> list = mJobService.findJobByDepartment(dep_id);

		return new JsonResponse.Builder<List<Job>>().setData(list).setHttpStatus(HttpStatus.OK).isSuccess(true)
				.build();
	}
	@RequestMapping(value = BASE_URL, method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse create(@RequestBody Job job) {
		LOGGER.info("[INFO] CREATE JOB");

		mJobService.create(job);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.CREATE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResponse update(@PathVariable("id") String id, @RequestBody Job job) {
		LOGGER.info("[INFO] UPDATE JOB");

		if (!id.equals(job.getId())) {
			job.setId(id);
		}

		mJobService.update(job);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.UPDATE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}
	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonResponse delete(@PathVariable("id") String id) {
		LOGGER.info("[INFO] DELETE JOB");

		mJobService.delete(id);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}
}
