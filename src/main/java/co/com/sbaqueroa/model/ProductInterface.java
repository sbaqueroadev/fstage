package co.com.sbaqueroa.model;

import java.util.List;

import org.json.JSONArray;

import co.com.sbaqueroa.model.implementation.Product;

/**
 * Interface which represents Product Object operations.
 * 
 * @author sergio
 *
 */
public interface ProductInterface {

	/**
	 * <p>
	 * Get all saved {@link Product}.
	 * </p>
	 * @return List of {@link Product}
	 */
	public List<Product> getAll();
	/**
	 * <p>
	 * Get all saved {@link Product} is JSON format.
	 * </p>
	 * @return Array of {@link Product} in JSON format.
	 */
	public JSONArray getAllJSON();
}
