package co.com.sbaqueroa.model.implementation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.json.JSONObject;

import co.com.sbaqueroa.model.CustomerInterface;

/**
 * Class which implements {@link CustomerInterface}
 *  and represents a Customer.  
 * 
 * @author sergio
 *
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable{
	
	private int id;
	private String name;
	private String email;
	
	private Set<Product> availableProducts = new HashSet<Product>();
	
	
	
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

	
	
	/**
	 * Parse object to JSON format.
	 * @return Object in JSON format.
	 */
	public JSONObject toJSON() {
		return new JSONObject()
				.put("name", this.name)
				.put("email", this.email)
				.put("id", this.id);
	}

	
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name="customer_id")
	public int getId() {
		return this.id;
	}
	
	

	/**
	 * @return the name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * @return the email
	 */
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name = "available_product"
	, joinColumns = { @JoinColumn(name = "customer_id") }
	, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	public Set<Product> getAvailableProducts() {
		return this.availableProducts;
	}
	
	
	
	
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param availableProducts the availableProducts to set
	 */
	public void setAvailableProducts(Set<Product> availableProducts) {
		this.availableProducts = availableProducts;
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
