package co.com.sbaqueroa.model.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.sbaqueroa.dao.implementation.AvaliableProductDAOImplementation;
import co.com.sbaqueroa.dao.implementation.CustomerDAOImplementation;
import co.com.sbaqueroa.model.CustomerInterface;

/**
 * Class which implements {@link CustomerInterface}
 *  and represents a Customer.  
 * 
 * @author sergio
 *
 */
public class Customer implements CustomerInterface{
	
	private int id;
	private String name;
	private String email;
	private List<Product> availableProducts;
	
	
	
	/**
	 * Super clas constructor
	 */
	public Customer() {
		super();
	}

	/**
	 * Constructor from builder
	 * @param builder the Builder reference to create new object.
	 */
	public Customer(Builder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.id = builder.id;
	}

	@Override
	public JSONArray getAllJSON() {
		JSONArray ja = new JSONArray();
		for(Customer c:this.getAll())
			ja.put(c.toJSON());
		return ja;
	}
	
	/**
	 * Parse object to JSON format.
	 * @return Object in JSON format.
	 */
	private JSONObject toJSON() {
		return new JSONObject()
				.put("name", this.name)
				.put("email", this.email)
				.put("id", this.id);
	}

	@Override
	public List<Customer> getAll() {
		CustomerDAOImplementation cdaoi= new CustomerDAOImplementation();
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("co/com/sbaqueroa/xml/beansConfig.xml");
		DataSource dataSource = (DataSource) appCtx.getBean("dataSource");
		cdaoi.setDataSource(dataSource);
		try {
			return cdaoi.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Customer>();
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	@Override
	public List<Product> getAvailableProducts() {
		AvaliableProductDAOImplementation cdaoi= new AvaliableProductDAOImplementation();
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("co/com/sbaqueroa/xml/beansConfig.xml");
		DataSource dataSource = (DataSource) appCtx.getBean("dataSource");
		cdaoi.setDataSource(dataSource);
		try {
			return cdaoi.getByCustomer(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Product>();
	}
	
	/**
	 * Inner class to help in {@link Customer} construction. 
	 * @author sergio
	 *
	 */
	public static class Builder {

		private int id;
		private String name;
		private String email;

		/**
		 * Set new {@link Customer} name.
		 * @param name the name to set.
		 * @return the builder object.
		 */
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		/**
		 * Set new {@link Customer} email.
		 * @param email the email to set.
		 * @return the builder object.
		 */
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * Set new {@link Customer} id.
		 * @param id the id to set.
		 * @return the builder object.
		 */
		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		
		/**
		 * Create new {@link Customer} object
		 * @return {@link Customer} object instantiated.
		 */
		public Customer build() {
			return new Customer(this);
		}
		

	}

}
