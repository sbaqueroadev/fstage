package co.com.sbaqueroa.model.implementation;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import co.com.sbaqueroa.model.ProductInterface;

/**
 * Class which implements {@link ProductInterface}
 *  and represents a product.  
 * 
 * @author sergio
 *
 */
@Entity
@Table(name="product")
public class Product implements Serializable{
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
	@Id
	@Column(name="product_id",nullable=false)
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
	@Column(name="name",nullable=false)
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
	@Column(name="price",nullable=false)
	public float getPrice() {
		return price;
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
	
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
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


	/**
	 * @return
	 */
	public JSONObject toJSON() {
		return new JSONObject()
				.put("id", this.id)
				.put("name", this.name)
				.put("price",this.price);
	}

}
