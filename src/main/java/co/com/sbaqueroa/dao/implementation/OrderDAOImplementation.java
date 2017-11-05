package co.com.sbaqueroa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import co.com.sbaqueroa.dao.OrderDAO;
import co.com.sbaqueroa.model.implementation.Order;

/**
 * Class which implements {@link OrderDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
public class OrderDAOImplementation implements OrderDAO {

	/*
	 * Begin constant definitions.
	 */
	public static final String TABLE_NAME = "`order`";
	public static final String ID_COLUMN_NAME = "order_id";
	public static final String CUSTOMER_ID_COLUMN_NAME = "customer_id";
	public static final String DELIVERY_ADDRESS_COLUMN_NAME = "delivery_address";
	public static final String CREATION_DATE_COLUMN_NAME = "creation_date";

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
	public int insert(Order order) throws Exception {
			String insertQuery = "INSERT INTO "+TABLE_NAME +" ("+CUSTOMER_ID_COLUMN_NAME+","
	+DELIVERY_ADDRESS_COLUMN_NAME+","+CREATION_DATE_COLUMN_NAME+") VALUES('"
					+order.getCustomerId()+"','"+order.getDeliveryAddress()+"','"
	+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"')";
			String selectQuery = "SELECT MAX(order_id) AS result FROM `order`";
			
			//order.getDeliveryAddress()
			System.out.println(insertQuery);
			System.out.println(selectQuery);
			Connection conn = null;
			int result = -1;
			try{
				conn = dataSource.getConnection();
				conn.setAutoCommit(false);
				PreparedStatement stinsert = conn.prepareStatement(insertQuery);
				PreparedStatement stselect = conn.prepareStatement(selectQuery);
				stinsert.execute();
				ResultSet rs = stselect.executeQuery();
				while(rs.next())
					result = rs.getInt("result");
				conn.commit();
				stinsert.close();
				stselect.close();
				conn.rollback();
			}catch (Exception e) {
				if(conn!=null)
					conn.rollback();
				throw e;
			}
			return result;
	}

	@Override
	public List<Order> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> get(String field, String value) throws Exception {
		String query = "SELECT * FROM "+TABLE_NAME +" WHERE "+field+" = '"+value+"'";
		System.out.println(query);
		Connection conn;
		List<Order> orders = new ArrayList<Order>();
		try{
			conn = dataSource.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				orders.add(new Order.Builder().setId(rs.getInt(ID_COLUMN_NAME))
						.setCustomerId(rs.getInt(CUSTOMER_ID_COLUMN_NAME))
						.setCreationDate(rs.getDate(CREATION_DATE_COLUMN_NAME))
						.setDeliveryAddress(rs.getString(DELIVERY_ADDRESS_COLUMN_NAME))
						.build());
				
			}
			st.close();
		}catch (Exception e) {
			throw e;
		}
		return orders;
	}

}
