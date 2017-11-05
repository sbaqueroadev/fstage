package co.com.sbaqueroa.model.implementation;

import java.util.List;

import org.json.JSONArray;

import co.com.sbaqueroa.model.ProductInterface;

/**
 * Class which implements {@link ProductInterface}
 *  and represents a product.  
 * 
 * @author sergio
 *
 */
public class Product implements ProductInterface{
	
	private int id;
	private String name;
	private float price;
	
	
	
	/**
	 * Super class constructor
	 */
	public Product() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}
	/**
	 * Constructor from builder
	 * @param builder the Builder reference to create new object.
	 */
	public Product(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.price = builder.price;
	}
	@Override
	public List<Product> getAll() {
		//TODO Auto-generated method stub
		return null;
	}
	@Override
	public JSONArray getAllJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Inner class to help in Product construction. 
	 * @author sergio
	 *
	 */
	public static class Builder {
		private int id;
		private String name;
		private float price;
		
		/**
		 * Set new Product id.
		 * @param id the id to set.
		 * @return the builder object.
		 */
		public Builder setId(int id){
			this.id = id;
			return this;
		}
		
		/**
		 * Set new Product name.
		 * @param name the name to set.
		 * @return the builder object.
		 */
		public Builder setName(String name){
			this.name = name;
			return this;
		}
		
		/**
		 * Set new Product price.
		 * @param price the price to set.
		 * @return the builder object.
		 */
		public Builder setPrice(float price){
			this.price = price;
			return this;
		}
		
		/**
		 * Create new Product object
		 * @return Product object instantiated.
		 */
		public Product build(){
			return new Product(this);
		}
	}

}
