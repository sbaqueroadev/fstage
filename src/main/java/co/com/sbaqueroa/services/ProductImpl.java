/**
 * 
 */
package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sbaqueroa.dao.ProductDAO;
import co.com.sbaqueroa.model.ProductInterface;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * @author sergio
 * Bee Smart S.A.S.
 *
 */
@Service
public class ProductImpl implements ProductInterface{
	
	@Autowired
	 private ProductDAO productDAO;
	
	@Override
	public List<Product> getAll() {
		try {
			return productDAO.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Product>();
	}
	@Override
	public JSONArray getAllJSON() {
		JSONArray ja = new JSONArray();
		for(Product c:this.getAll())
			ja.put(c.toJSON());
		return ja;
	}

}
