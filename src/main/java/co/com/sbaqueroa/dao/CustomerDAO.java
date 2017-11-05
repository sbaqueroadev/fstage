package co.com.sbaqueroa.dao;

import java.util.List;

import co.com.sbaqueroa.model.implementation.Customer;

/**
 * Interface which represents the Customer Data Base Object operations.
 * 
 * @author sergio
 *
 */
public interface CustomerDAO {

	/**
	 * <p>
	 * Executes query in database and processes reading result to return Customer - {@link Customer} list.
	 * </p>
	 * @return List of all clients in data base.
	 * @throws Exception if the data base reading produces an error.
	 */
	public List<Customer> getAll() throws Exception;
	
}
