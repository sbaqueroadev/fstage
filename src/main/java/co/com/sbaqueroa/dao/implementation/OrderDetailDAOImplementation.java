package co.com.sbaqueroa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import co.com.sbaqueroa.dao.OrderDetailDAO;
import co.com.sbaqueroa.model.implementation.OrderDetail;

/**
 * Class which implements {@link OrderDetailDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
public class OrderDetailDAOImplementation implements OrderDetailDAO {

	/*
	 * Begin constant definitions.
	 */
	
	public static final String TABLE_NAME = "order_detail";
	public static final String ORDER_ID_COLUMN_NAME = "order_id";
	public static final String PRODUCT_ID_COLUMN_NAME = "product_id";
	public static final String QUANTITY_COLUMN_NAME = "quantity";
	
	/*
	 * End Constant definitions
	 */
	
	/**
	 * {@link DataSource} reference to manage SQL connection.
	 */
	private DataSource dataSource;

	/**
	 * <p>
	 * Set the {@link DataSource}.
	 * </p>
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(OrderDetail orderDetail) throws Exception {
			String query = "INSERT INTO "+TABLE_NAME +" ("+ORDER_ID_COLUMN_NAME+","
	+PRODUCT_ID_COLUMN_NAME+","
			+QUANTITY_COLUMN_NAME+") VALUES('"
					+orderDetail.getOrderId()+"','"+orderDetail.getProductId()+"','"+orderDetail.getQuantity()+"')";
			System.out.println(query);
			Connection conn;
			try{
				conn = dataSource.getConnection();
				PreparedStatement st = conn.prepareStatement(query);
				st.executeUpdate();
				st.close();
			}catch (Exception e) {
				throw e;
			}
	}

	

}
