package co.com.sbaqueroa.model;

import java.util.List;

import org.json.JSONArray;

import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.model.implementation.Order;

/**
 * Interface which represents Order Object operations.
 * 
 * @author sergio
 *
 */
public interface OrderInterface {

	/**
	 * <p>
	 * Get all saved {@link Customer}.
	 * </p>
	 * @return List of {@link Customer}
	 */
	public List<Order> getAll();
	/**
	 * @return
	 */
	public JSONArray getAllJSON();
	
	public boolean add(Order order);
	public boolean update(Order order);
}
