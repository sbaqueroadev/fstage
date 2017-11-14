/**
 * 
 */
package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sbaqueroa.dao.OrderDAO;
import co.com.sbaqueroa.model.OrderInterface;
import co.com.sbaqueroa.model.implementation.Order;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * @author sergio
 * Bee Smart S.A.S.
 *
 */
@Service
public class OrderImpl implements OrderInterface {

	@Autowired
	 private OrderDAO orderDAO;
	
	/* (non-Javadoc)
	 * @see co.com.sbaqueroa.model.CustomerInterface#getAll()
	 */
	@Override
	public List<Order> getAll() {
		try {
			return orderDAO.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Order>();
	}

	/* (non-Javadoc)
	 * @see co.com.sbaqueroa.model.CustomerInterface#getAllJSON()
	 */
	@Override
	public JSONArray getAllJSON() {
		JSONArray ja = new JSONArray();
		for(Order c:this.getAll())
			ja.put(c.toJSON());
		return ja;
	}

	@Override
	public boolean add(Order order) {
		try {
			orderDAO.insert(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Order order) {
		try {
			orderDAO.update(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
