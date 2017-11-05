package co.com.sbaqueroa.model.implementation;

/**
 * Class which represents a Order detail.  
 * 
 * @author sergio
 *
 */
public class OrderDetail {

	private int orderId;
	private int productId;
	private int quantity;
	
	/**
	 * Constructor from builder
	 * @param builder the Builder reference to create new object.
	 */
	public OrderDetail(Builder builder) {
		this.orderId = builder.orderId;
		this.productId = builder.productId;
		this.quantity = builder.quantity;
	}
	
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @return the customerId
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Inner class to help in Product construction. 
	 * @author sergio
	 *
	 */
	public static class Builder {
		private int orderId;
		private int productId;
		private int quantity;
		
		/**
		 * Set new {@link OrderDetail} order id.
		 * @param order_id the order id to set.
		 * @return the builder object.
		 */
		public Builder setOrderId(int order_id){
			this.orderId = order_id;
			return this;
		}
		
		/**
		 * Set new {@link OrderDetail} product id.
		 * @param product_id the id to set.
		 * @return the builder object.
		 */
		public Builder setProductId(int product_id){
			this.productId = product_id;
			return this;
		}
		
		/**
		 * Set new {@link OrderDetail} quantity.
		 * @param quantity the quantity to set.
		 * @return the builder object.
		 */
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
