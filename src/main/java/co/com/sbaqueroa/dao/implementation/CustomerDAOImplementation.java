package co.com.sbaqueroa.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import co.com.sbaqueroa.dao.CustomerDAO;
import co.com.sbaqueroa.model.implementation.Customer;

/**
 * Class which implements {@link CustomerDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Customer> getAll() throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Customer> cq = builder.createQuery(Customer.class);
	    Root<Customer> root = cq.from(Customer.class);
	    cq.select(root);
	    return entityManager.createQuery(cq).getResultList();
	}

}
