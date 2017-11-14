package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * Class which handles HTTP requests that are pointed to routes beginning with /product/*
 * @author sergio
 *
 */
@Controller
public class CustomerServices {
	
	/**
	 * Handles request to get all {@link Product}.
	 * @return List of {@link Product}
	 */
	@Autowired
	private CustomerImpl customerImpl;
	
	@RequestMapping(value="/customer/",method = {RequestMethod.GET})
	public @ResponseBody List<Customer> getAll(){
		return customerImpl.getAll();
	}
	
}
