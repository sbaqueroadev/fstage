package co.com.sbaqueroa.model.implementation;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import co.com.sbaqueroa.model.OrderInterface;

/**
 * Class which implements {@link OrderInterface}
 *  and represents a Order.  
 * 
 * @author sergio
 *
 */
@Entity
@Table(name="`order`")
public class Order implements Serializable{
	

	
	private int id=-1;
	private Customer customer;
	private String deliveryAddress;
	private Set<OrderDetail> orderDetail;
	private Date creationDate = new Date();
	
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
		this.customer = builder.customer;
		this.deliveryAddress = builder.deliveryAddress;
		this.id = builder.id;
		this.orderDetail = builder.products;
	}
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="order_id",insertable = false, nullable = false, unique = true, updatable = false)
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
	@ManyToOne(fetch=FetchType.EAGER,targetEntity=Customer.class)
    @JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return this.customer;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the deliveryAddress
	 */
	@Column(name="delivery_address",nullable=false)
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
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE}
	,targetEntity=OrderDetail.class, fetch=FetchType.LAZY,mappedBy="order")
	@JsonManagedReference
	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	/**
	 * @param products the products to set
	 */
	public void setOrderDetail(Set<OrderDetail> products) {
		this.orderDetail = products;
	}
	/**
	 * @return the creationDate
	 */
	@Column(name="creation_date")
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
				//.put("customer", this.customer.toJSON())
				.put("products", this.orderDetail)
				.put("deliveryAddress", this.deliveryAddress)
				.put("deliveryAddress", this.deliveryAddress)
				.put("creationDate", new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate));
	}
	
	
	
	/**
	 * Inner class to help in {@link Order} construction. 
	 * @author sergio
	 *
	 */
	public static class Builder {
		private int id;
		private Customer customer;
		private String deliveryAddress;
		private Set<OrderDetail> products;
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
		public Builder setCustomerId(Customer customer) {
			this.customer = customer;
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
		public Builder setProducts(Set<OrderDetail> products) {
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
