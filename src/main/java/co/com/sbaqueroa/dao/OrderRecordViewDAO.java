package co.com.sbaqueroa.dao;

import java.util.List;

import co.com.sbaqueroa.model.implementation.OrderRecordView;

/**
 * Interface which represents the Order Record View Data Base Object operations.
 * 
 * @author sergio
 *
 */
public interface OrderRecordViewDAO {

	/**
	 * <p>
	 * Executes query in database and processes reading result to return
	 *  {@link OrderRecordView} list.
	 * </p>
	 * @return List of all {@link OrderRecordView} in database.
	 * @throws Exception if the data base reading produces an error.
	 */
	public List<OrderRecordView> getAll() throws Exception;
	
}
