package co.com.sbaqueroa.model.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.sbaqueroa.dao.implementation.OrderRecordViewDAOImplementation;
import co.com.sbaqueroa.model.OrderRecordViewInterface;

/**
 * Class which implements {@link OrderRecordViewInterface}
 *  and represents a Order Record View.  
 * 
 * @author sergio
 *
 */

public class OrderRecordView extends Order implements OrderRecordViewInterface{

	private float total;
	private String customerName;
	private String productsDescription;
	
	/**
	 * Super Class constructor
	 */
	public OrderRecordView() {
		super();
	}
	/**
	 * Constructor from builder
	 * @param builder the Builder reference to create new object.
	 */
	public OrderRecordView(Builder builder) {
		Order o = new Order(builder);
		this.setCreationDate(o.getCreationDate());
		this.setDeliveryAddress(o.getDeliveryAddress());
		this.setId(o.getId());
		this.customerName = builder.customerName;
		this.productsDescription = builder.productsDescription;
		this.total = builder.total;
	}
	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the productsDescription
	 */
	public String getProductsDescription() {
		return productsDescription;
	}
	/**
	 * @param productsDescription the productsDescription to set
	 */
	public void setProductsDescription(String productsDescription) {
		this.productsDescription = productsDescription;
	}


	@Override
	public List<OrderRecordView> getAll() {
		OrderRecordViewDAOImplementation cdaoi= new OrderRecordViewDAOImplementation();
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("co/com/sbaqueroa/xml/beansConfig.xml");
		DataSource dataSource = (DataSource) appCtx.getBean("dataSource");
		cdaoi.setDataSource(dataSource);
		try {
			return cdaoi.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<OrderRecordView>();
	}
	@Override
	public JSONArray getAllJSON() {
		JSONArray ja = new JSONArray();
		for(OrderRecordView orv:this.getAll())
			ja.put(orv.toJSON());
		return ja;
	}
	
	@Override
	public JSONObject toJSON() {
		JSONObject result = super.toJSON();
		return result
				.put("customerName", this.customerName)
				.put("productsDescription", this.productsDescription)
				.put("total", this.total);
	}



	/**
	 * Inner class to help in {@link OrderRecordView} construction. 
	 * @author sergio
	 *
	 */
	public static class Builder extends Order.Builder{
		private float total;
		private String customerName;
		private String productsDescription;
		
		
		
		/**
		 * Super class constructor
		 */
		public Builder() {
			super();
		}
		
		public Builder setId(int id){
			super.setId(id);
			return this;
		}
		
		public Builder setDeliveryAddress(String deliveryAddress){
			super.setDeliveryAddress(deliveryAddress);
			return this;
		}
		public Builder setCreationDate(Date date){
			super.setCreationDate(date);
			return this;
		}
		
		/**
		 * Set new Product total.
		 * @param total the total to set.
		 * @return the builder object.
		 */
		public Builder setTotal(float total) {
			this.total = total;
			return this;
		}
		
		/* (non-Javadoc)
		 * @see co.com.sbaqueroa.model.implementation.Order.Builder#build()
		 */
		/** 
		 * Create new {@link OrderRecordView} object
		 * @return {@link OrderRecordView} object instantiated.
		 */
		public OrderRecordView build(){
			return new OrderRecordView(this);
		}
		/**
		 * Set new Product name.
		 * @param name the name to set.
		 * @return the builder object.
		 */
		public Builder setCustomerName(String customerName) {
			this.customerName = customerName;
			return this;
		}
		/**
		 * Set new Product productsDescription.
		 * @param productsDescription the productDescription to set.
		 * @return the builder object.
		 */
		public Builder setProductsDescription(String productsDescription) {
			this.productsDescription = productsDescription;
			return this;
		}
		
	}

}
