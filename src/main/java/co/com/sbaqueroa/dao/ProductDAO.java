package co.com.sbaqueroa.dao;

import java.util.List;

import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * 
 * Interface which represents the Available Product Data Base Object operations.
 * 
 * @author sergio
 *
 */
public interface ProductDAO {

	/**
	 * <p>
	 * Executes query in database and processes reading result to return
	 *  Available Products - {@link Product} list.
	 * </p>
	 * @param customer Client {@link Customer} which determines the id to look for Products.
	 * @return List of the client available products. 
	 * @throws Exception if the data base reading produces an error.
	 */
	public List<Product> getAll() throws Exception;
}
