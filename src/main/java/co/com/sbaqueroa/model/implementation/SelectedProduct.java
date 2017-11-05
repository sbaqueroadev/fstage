package co.com.sbaqueroa.model.implementation;

import co.com.sbaqueroa.model.implementation.Product;

/**
 * Class which represents an {@link Order} selected product.
 * 
 * @author sergio
 *
 */
public class SelectedProduct extends Product {

	/**
	 * Quantity of this product.
	 */
	private int quantity = 0;
	
	public SelectedProduct(Builder builder) {
		super(builder);
	}
	
	/**
	 * Super class constructor.
	 */
	public SelectedProduct() {
		super();
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
