package co.com.sbaqueroa.model.implementation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Class which represents a Order detail.  
 * 
 * @author sergio
 *
 */
@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne
    @JoinColumn(name="order_id")
	@JsonBackReference
	private Order order;
	@ManyToOne
    @JoinColumn(name="product_id")
	private Product product;
	@Column(name="quantity", length=11)
	private int quantity;
	
	
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor from builder
	 * @param builder the Builder reference to create new object.
	 */
	public OrderDetail(Builder builder) {
		this.quantity = builder.quantity;
	}
	
	/**
	 * @return the orderId
	 */
	/*@EmbeddedId
	public OrderDetailId getPk() {
		return this.pk;
	}

	public void setPk(OrderDetailId pk){
		this.pk = pk;
	}
	@Transient
	public Product getProduct(){
		return this.pk.getProduct();
	}
	
	public void setProduct(Product product){
		this.pk.setProduct(product);
	}*/
	
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	
	
	
	/**
	 * @return the product
	 */
	
	public Order getOrder() {
		return this.order;
	}
	
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	


	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
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
	 * Inner class to help in Product construction. 
	 * @author sergio
	 *
	 */
	public static class Builder {
		private int orderId;
		private Product product;
		private int quantity;
		
		public Builder setOrderId(int orderId){
			this.orderId = orderId;
			return this;
		}
		
		public Builder setProduct(Product product){
			this.product = product;
			return this;
		}
		
		public Builder setQuantity(int quantity){
			this.quantity = quantity;
			return this;
		}
		
		/**
		 * Create new {@link OrderDetail} object
		 * @return {@link OrderDetail} object instantiated.
		 */
		public OrderDetail build(){
			return new OrderDetail(this);
		}
	}



}
