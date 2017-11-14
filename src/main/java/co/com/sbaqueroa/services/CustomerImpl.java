/**
 * 
 */
package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import co.com.sbaqueroa.dao.CustomerDAO;
import co.com.sbaqueroa.dao.implementation.CustomerDAOImplementation;
import co.com.sbaqueroa.model.CustomerInterface;
import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * @author sergio
 * Bee Smart S.A.S.
 *
 */
@Service
public class CustomerImpl implements CustomerInterface {

	@Autowired
	 private CustomerDAO customerDAO;
	
	/* (non-Javadoc)
	 * @see co.com.sbaqueroa.model.CustomerInterface#getAll()
	 */
	@Override
	public List<Customer> getAll() {
		try {
			return customerDAO.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Customer>();
	}

	/* (non-Javadoc)
	 * @see co.com.sbaqueroa.model.CustomerInterface#getAllJSON()
	 */
	@Override
	public JSONArray getAllJSON() {
		JSONArray ja = new JSONArray();
		for(Customer c:this.getAll())
			ja.put(c.toJSON());
		return ja;
	}

	/* (non-Javadoc)
	 * @see co.com.sbaqueroa.model.CustomerInterface#getAvailableProducts()
	 */
	@Override
	public List<Product> getAvailableProducts() {
	/*	AvaliableProductDAOImplementation cdaoi= new AvaliableProductDAOImplementation();
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("co/com/sbaqueroa/xml/beansConfig.xml");
		DataSource dataSource = (DataSource) appCtx.getBean("dataSource");
		cdaoi.setDataSource(dataSource);
		try {
			return cdaoi.getByCustomer(this);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return new ArrayList<Product>();
	}

}
