package co.com.sbaqueroa.model.implementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.sbaqueroa.dao.implementation.OrderDAOImplementation;
import co.com.sbaqueroa.dao.implementation.OrderDetailDAOImplementation;
import co.com.sbaqueroa.model.OrderInterface;

/**
 * Class which implements {@link OrderInterface}
 *  and represents a Order.  
 * 
 * @author sergio
 *
 */
public class Order implements OrderInterface{
	
	private int id;
	private int customerId;
	private String deliveryAddress;
	private List<SelectedProduct> products;
	private Date creationDate;
	
	/**
	 * Super class constructor
	 */
	public Order() {
		super();
	}
	/**
	 * Constructor from builder
	 * @param builder the Builder reference to create new object.
	 */
	public Order(Builder builder) {
		this.creationDate = builder.creationDate;
		this.customerId = builder.customerId;
		this.deliveryAddress = builder.deliveryAddress;
		this.id = builder.id;
		this.products = builder.products;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	/**
	 * @return the products
	 */
	public List<SelectedProduct> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<SelectedProduct> products) {
		this.products = products;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * Parse object to JSON format.
	 * @return Object in JSON format.
	 */
	public JSONObject toJSON() {
		return new JSONObject()
				.put("id", this.id)
				.put("customerId", this.customerId)
				.put("products", this.products)
				.put("deliveryAddress", this.deliveryAddress)
				.put("creationDate", new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate));
	}
	
	@Override
	public boolean add() {
		OrderDAOImplementation cdaoi= new OrderDAOImplementation();
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("co/com/sbaqueroa/xml/beansConfig.xml");
		DataSource dataSource = (DataSource) appCtx.getBean("dataSource");
		cdaoi.setDataSource(dataSource);
		try {
			OrderDetailDAOImplementation odim = new OrderDetailDAOImplementation();
			odim.setDataSource(dataSource);
			this.setId(cdaoi.insert(this));
			for(SelectedProduct sp:this.products)
				odim.insert(new OrderDetail.Builder().setOrderId(this.id)
						.setProductId(sp.getId())
						.setQuantity(sp.getQuantity())
						.build());
						
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Inner class to help in {@link Order} construction. 
	 * @author sergio
	 *
	 */
	public static class Builder {
		private int id;
		private int customerId;
		private String deliveryAddress;
		private List<SelectedProduct> products;
		private Date creationDate;
		
		/**
		 * Set new {@link Order} id.
		 * @param id the id to set.
		 * @return the builder object.
		 */
		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		/**
		 * Set new {@link Order} customer id.
		 * @param customerId the customer id to set.
		 * @return the builder object.
		 */
		public Builder setCustomerId(int customerId) {
			this.customerId = customerId;
			return this;
		}
		/**
		 * Set new {@link Order} delivery address.
		 * @param deliveryAddress the delivery address to set.
		 * @return the builder object.
		 */
		public Builder setDeliveryAddress(String deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
			return this;
		}
		/**
		 * Set new {@link Order} selected products.
		 * @param products the selected products to set.
		 * @return the builder object.
		 */
		public Builder setProducts(List<SelectedProduct> products) {
			this.products = products;
			return this;
		}
		/**
		 * Set new {@link Order} creation date.
		 * @param creationDate the creation date to set.
		 * @return the builder object.
		 */
		public Builder setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
			return this;
		}
		
		/**
		 * Create new {@link Order} object
		 * @return {@link Order} object instantiated.
		 */
		public Order build(){
			return new Order(this);
		}
	}

}
