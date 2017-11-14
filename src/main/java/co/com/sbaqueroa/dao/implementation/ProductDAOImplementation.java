package co.com.sbaqueroa.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import co.com.sbaqueroa.dao.ProductDAO;
import co.com.sbaqueroa.model.implementation.Product;

/**
 * 
 * Class which implements {@link AvailableProductDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
@Repository
public class ProductDAOImplementation implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Product> getAll() throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Product> cq = builder.createQuery(Product.class);
	    Root<Product> root = cq.from(Product.class);
	    cq.select(root);
	    return entityManager.createQuery(cq).getResultList();
	}

}
