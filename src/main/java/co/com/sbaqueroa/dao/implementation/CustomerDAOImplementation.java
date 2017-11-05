package co.com.sbaqueroa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import co.com.sbaqueroa.dao.CustomerDAO;
import co.com.sbaqueroa.model.implementation.Customer;

/**
 * Class which implements {@link CustomerDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
public class CustomerDAOImplementation implements CustomerDAO {

	/**
	 * {@link DataSource} reference to manage SQL connection.
	 */
	private DataSource dataSource;
	/*
	 * Begin constant definitions.
	 */
	public static final String TABLE_NAME = "customer";
	public static final String NAME_COLUMN_NAME = "name";
	public static final String EMAIL_COLUMN_NAME = "email";
	public static final String ID_COLUMN_NAME = "customer_id";
	/*
	 * End Constant definitions
	 */
	
	/**
	 * <p>
	 * Set the {@link DataSource}.
	 * </p>
	 * 
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Customer> getAll() throws Exception {
		String query = "SELECT * FROM "+TABLE_NAME;
		Connection conn;
		List<Customer> costumers = new ArrayList<Customer>();
		try{
			conn = dataSource.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next())
				costumers.add(new Customer.Builder().setName(rs.getString(NAME_COLUMN_NAME))
						.setEmail(rs.getString(EMAIL_COLUMN_NAME))
						.setId(rs.getInt(ID_COLUMN_NAME)).build());
			st.close();
		}catch (Exception e) {
			throw e;
		}
		return costumers;
	}

}
