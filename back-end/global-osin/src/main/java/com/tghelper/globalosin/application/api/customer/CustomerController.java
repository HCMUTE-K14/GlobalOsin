package com.tghelper.globalosin.application.api.customer;

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
import com.tghelper.globalosin.application.service.customer.CustomerService;
import com.tghelper.globalosin.core.ApplicationMessage;
import com.tghelper.globalosin.core.entity.customer.Customer;

@RestController
public class CustomerController extends AbstractApiController {
	public static final String BASE_URL = "/customer";

	private final CustomerService mCustomerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.mCustomerService = customerService;
	}

	@RequestMapping(value = BASE_URL, method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse getAllCustomer() {
		LOGGER.info("[INFO] GET CUSTOMER");
		List<Customer> list = mCustomerService.findAll();
		LOGGER.info("CUSTOMER:" + list.get(0).toString());

		return new JsonResponse.Builder<List<Customer>>().setData(list).setHttpStatus(HttpStatus.OK).isSuccess(true)
				.build();
	}

	@RequestMapping(value = BASE_URL + "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse getCustomerById(@PathVariable("name") String name) {
		LOGGER.info("[INFO] GET CUSTOMER:" + name);
		List<Customer> list = mCustomerService.findCustomerByName(name);

		return new JsonResponse.Builder<List<Customer>>().setData(list).setHttpStatus(HttpStatus.OK).isSuccess(true)
				.build();
	}

	@RequestMapping(value = BASE_URL, method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse create(@RequestBody Customer customer) {
		LOGGER.info("[INFO] CREATE CUSTOMER");

		mCustomerService.create(customer);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.CREATE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}

	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResponse update(@PathVariable("id") String id, @RequestBody Customer customer) {
		LOGGER.info("[INFO] UPDATE CUSTOMER");

		if (!id.equals(customer.getId())) {
			customer.setId(id);
		}

		mCustomerService.update(customer);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.UPDATE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}

	@RequestMapping(value = BASE_URL + "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonResponse delete(@PathVariable("id") String id) {
		LOGGER.info("[INFO] DELETE CUSTOMER");

		mCustomerService.delete(id);

		return new JsonResponse.Builder<ApplicationMessage>().setData(ApplicationMessage.DELETE_ENTITY_SUCCESSFUL)
				.setHttpStatus(HttpStatus.OK).isSuccess(true).build();
	}
}
