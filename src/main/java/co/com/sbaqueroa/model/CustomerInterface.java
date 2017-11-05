package co.com.sbaqueroa.model;

import java.util.List;

import org.json.JSONArray;

import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * Interface which represents Customer Object operations.
 * 
 * @author sergio
 *
 */
public interface CustomerInterface {

	/**
	 * <p>
	 * Get all saved {@link Customer}.
	 * </p>
	 * @return List of {@link Customer}
	 */
	public List<Customer> getAll();
	/**
	 * @return
	 */
	public JSONArray getAllJSON();
	/**
	 * <p>
	 * Get all saved available {@link Product} for this client.
	 * </p>
	 * @return List of available {@link Product} for this client.
	 */
	public List<Product> getAvailableProducts();
}
