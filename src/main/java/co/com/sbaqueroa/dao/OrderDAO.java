package co.com.sbaqueroa.dao;

import java.util.List;

import co.com.sbaqueroa.model.implementation.Order;

/**
 * Interface which represents the Order Data Base Object operations.
 * 
 * @author sergio
 *
 */
public interface OrderDAO {

	/**
	 * <p>
	 * Executes query in database and processes writing result to return
	 *  the new order id.
	 * </p>
	 * @param order Order to insert in data base. @see {@link Order}
	 * @throws Exception if the data base writing produces an error.
	 */
	public int insert(Order order) throws Exception;
	/**
	 * <p>
	 * Executes query in database and processes reading result to return
	 *  Orders - {@link Order} list.
	 * </p>
	 * @param field Table column name to look for in.
	 * @param value Table column value to compare to.
	 * @return List of {@link Order} in database which "field" value corresponds to <b>value</b> param.
	 * @throws Exception if the data base reading produces an error.
	 */
	public List<Order> get(String field, String value) throws Exception;
	/**
	 * <p>
	 * Executes query in database and processes reading result to return
	 *  {@link Order} list.
	 * </p>
	 * @return List of all {@link Order} in database.
	 * @throws Exception if the data base reading produces an error.
	 */
	public List<Order> getAll() throws Exception;
	
}
