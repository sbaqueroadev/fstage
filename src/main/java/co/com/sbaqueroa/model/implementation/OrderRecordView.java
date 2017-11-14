package co.com.sbaqueroa.model.implementation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import co.com.sbaqueroa.model.OrderRecordViewInterface;

/**
 * Class which implements {@link OrderRecordViewInterface}
 *  and represents a Order Record View.  
 * 
 * @author sergio
 *
 */
@Entity
@Table(name="order_record_view")
public class OrderRecordView implements Serializable{

	@Id
	@OneToOne
    @JoinColumn(name = "order_id")
	@JsonManagedReference
	private Order order;
	@Column(name="total")
	private float total;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="products")
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
		this.order = new Order();
		this.order.setCreationDate(builder.order.getCreationDate());
		this.order.setDeliveryAddress(builder.order.getDeliveryAddress());
		this.order.setId(builder.order.getId());
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
	
	


	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}
	public JSONObject toJSON() {
		JSONObject result = this.order.toJSON();
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
	public static class Builder{
		private float total;
		private String customerName;
		private String productsDescription;
		private Order order;
		
		
		
		/**
		 * Super class constructor
		 */
		public Builder() {
			super();
		}
		
		public Builder setId(int id){
			this.order.setId(id);
			return this;
		}
		
		public Builder setDeliveryAddress(String deliveryAddress){
			this.order.setDeliveryAddress(deliveryAddress);
			return this;
		}
		public Builder setCreationDate(Date date){
			this.order.setCreationDate(date);
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
