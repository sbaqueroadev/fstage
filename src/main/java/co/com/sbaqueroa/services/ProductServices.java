package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

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
public class ProductServices {
	
	/**
	 * Handles request to get all {@link Product}.
	 * @return List of {@link Product}
	 */
	@RequestMapping(value="/product/",method = {RequestMethod.GET})
	public @ResponseBody List<Customer> getAll(){
		List<Customer> result= new ArrayList<Customer>();
		return result;
	}
	
	/**
	 * Handles request to get list of available {@link Product} for a specific {@link Customer}.
	 * @param customerId Id of {@link Customer}
	 * @return List of available {@link Product}
	 */
	@RequestMapping(value="/product/availables/{customerId}",
			method = {RequestMethod.GET},produces="application/json")
	public @ResponseBody List<Product> getAvailableProducts(@PathVariable int customerId){
		List<Product> result= new ArrayList<Product>();
		result = new Customer.Builder().setId(customerId).build().getAvailableProducts();
		return result;
	}
	
}
