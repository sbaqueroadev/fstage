package co.com.sbaqueroa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import co.com.sbaqueroa.dao.AvailableProductDAO;
import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * 
 * Class which implements {@link AvailableProductDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
public class AvaliableProductDAOImplementation implements AvailableProductDAO {

	/*
	 * Begin constant definitions.
	 */
	private static final String TABLE_NAME = "available_product_view";
	private static final String CUSTOMER_ID_COLUMN_NAME = "customer_id";
	private static final String ID_COLUMN_NAME = "product_id";
	private static final String NAME_COLUMN_NAME = "product_name";
	private static final String PRICE_COLUMN_NAME = "product_price";

	/*
	 * End Constant definitions
	 */
	/**
	 * {@link DataSource} reference to manage SQL connection.
	 */
	private DataSource dataSource;

	@Override
	public List<Product> getByCustomer(Customer customer) throws Exception {
		String query = "SELECT * FROM "+TABLE_NAME +" WHERE "+CUSTOMER_ID_COLUMN_NAME+" = '"+customer.getId()+"'";
		System.out.println(query);
		Connection conn;
		List<Product> products = new ArrayList<Product>();
		try{
			conn = dataSource.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next())
				products.add(new Product.Builder().setId(rs.getInt(ID_COLUMN_NAME))
						.setName(rs.getString(NAME_COLUMN_NAME))
						.setPrice(rs.getFloat(PRICE_COLUMN_NAME)).build());
			st.close();
		}catch (Exception e) {
			throw e;
		}
		return products;
	}

	/**
	 * <p>
	 * Set the {@link DataSource}.
	 * </p>
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
