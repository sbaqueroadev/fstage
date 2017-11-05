package co.com.sbaqueroa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import co.com.sbaqueroa.dao.OrderRecordViewDAO;
import co.com.sbaqueroa.model.implementation.OrderRecordView;

/**
 * 
 * Class which implements {@link OrderRecordViewDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
public class OrderRecordViewDAOImplementation implements OrderRecordViewDAO {

	/**
	 * {@link DataSource} reference to manage SQL connection.
	 */
	private DataSource dataSource;
	
	/*
	 * Begin constant definitions.
	 */
	
	public static final String TABLE_NAME = "order_record_view";
	public static final String CUSTOMER_NAME_COLUMN_NAME = "customer_name";
	public static final String CREATION_DATE_COLUMN_NAME = "creation_date";
	public static final String DELIVERY_ADDRESS_COLUMN_NAME = "delivery_address";
	public static final String TOTAL_COLUMN_NAME = "total";
	public static final String PRODUCTS_COLUMN_NAME = "products";
	public static final String ID_COLUMN_NAME = "order_id";
	
	/*
	 * End Constant definitions
	 */
	
	
	/**<p>
	 * Set the {@link DataSource}.
	 * </p>
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<OrderRecordView> getAll() throws Exception {
		String query = "SELECT * FROM "+TABLE_NAME;
		Connection conn;
		List<OrderRecordView> records = new ArrayList<OrderRecordView>();
		try{
			conn = dataSource.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next())
				records.add(new OrderRecordView.Builder()
						.setId(rs.getInt(ID_COLUMN_NAME))
						.setTotal(rs.getFloat(TOTAL_COLUMN_NAME))
						.setCustomerName(rs.getString(CUSTOMER_NAME_COLUMN_NAME))
						.setDeliveryAddress(rs.getString(DELIVERY_ADDRESS_COLUMN_NAME))
						.setProductsDescription(rs.getString(PRODUCTS_COLUMN_NAME))
						.setCreationDate(rs.getDate(CREATION_DATE_COLUMN_NAME))
						.build());
			st.close();
		}catch (Exception e) {
			throw e;
		}
		return records;
	}

}
