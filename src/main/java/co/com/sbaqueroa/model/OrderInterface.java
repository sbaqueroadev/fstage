package co.com.sbaqueroa.model;

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
	 * Add new {@link Order}.
	 * </p>
	 * @return true if process is successful or false otherwise.
	 */
	public boolean add();
}
