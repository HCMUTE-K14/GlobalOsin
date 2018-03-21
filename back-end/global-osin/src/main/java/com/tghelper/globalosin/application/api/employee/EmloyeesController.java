package com.tghelper.globalosin.application.api.employee;

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
import com.tghelper.globalosin.application.service.employee.EmployeeService;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.entity.employees.Employees;

@RestController
public class EmloyeesController extends AbstractApiController {
	public static final String BASE_URL = "/employee";

	private final EmployeeService mEmployeeService;

	@Autowired
	public EmloyeesController(EmployeeService employeeService) {
		this.mEmployeeService = employeeService;
	}

	@RequestMapping(value = BASE_URL, method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse getAllEmloyees() {
		LOGGER.info("[INFO] GET EMPLOYEE");
		List<Employees> list = mEmployeeService.findAll();

		return new JsonResponse.Builder<List<Employees>>().setData(list).setHttpStatus(HttpStatus.OK).isSuccess(true)
				.build();
	}

	@RequestMapping(value = BASE_URL + "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse getEmployeeById(@PathVariable("name") String name) {
		LOGGER.info("[INFO] GET EMPLOYEE:" + name);
		List<Employees> list = mEmployeeService.findEmployeesByName(name);

		return new JsonResponse.Builder<List<Employees>>().setData(list).setHttpStatus(HttpStatus.OK).isSuccess(true)
				.build();
	}

	@RequestMapping(value = BASE_URL, method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse create(@RequestBody Employees employees) {
		LOGGER.info("[INFO] CREATE EMPLOYEES");

		mEmployeeService.create(employees);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.CREATE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}

	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResponse update(@PathVariable("id") String id, @RequestBody Employees employees) {
		LOGGER.info("[INFO] UPDATE EMPLOYEE");

		if (!id.equals(employees.getId())) {
			employees.setId(id);
		}

		mEmployeeService.update(employees);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.UPDATE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}

	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonResponse delete(@PathVariable("id") String id) {
		LOGGER.info("[INFO] DELETE EMPLOYEE");

		mEmployeeService.delete(id);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}

	@RequestMapping(value = BASE_URL, method = RequestMethod.DELETE)
	@ResponseBody
	public JsonResponse delete(@RequestBody Employees employees) {
		LOGGER.info("[INFO] DELETE EMPLOYEE");

		mEmployeeService.delete(employees);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}
}
