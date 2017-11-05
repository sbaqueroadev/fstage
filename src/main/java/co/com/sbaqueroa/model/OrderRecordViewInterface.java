package co.com.sbaqueroa.model;

import java.util.List;

import org.json.JSONArray;

import co.com.sbaqueroa.model.implementation.OrderRecordView;

/**
 * Interface which represents Order Record View Object operations.
 * 
 * @author sergio
 *
 */
public interface OrderRecordViewInterface {

	/**
	 * <p>
	 * Get all saved {@link OrderRecordView}.
	 * </p>
	 * @return
	 */
	public List<OrderRecordView> getAll();
	/**
	 * <p>
	 * Get all saved {@link OrderRecordView} is JSON format.
	 * </p>
	 * @return Array of {@link OrderRecordView} in JSON format.
	 */
	public JSONArray getAllJSON();
}
