package co.com.sbaqueroa.dao;

import co.com.sbaqueroa.model.implementation.OrderDetail;

/**
 * Interface which represents the Order Detail Data Base Object operations.
 * 
 * @author sergio
 *
 */
public interface OrderDetailDAO {

	/**
	 * <p>
	 * Executes query in database to insert an {@link OrderDetail}.
	 * </p>
	 * @param orderDetail {@link OrderDetail} to insert in database.
	 * @throws Exception if the data base writing produces an error.
	 */
	public void insert(OrderDetail orderDetail) throws Exception;
	
}
