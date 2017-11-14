package co.com.sbaqueroa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import co.com.sbaqueroa.dao.OrderRecordViewDAO;
import co.com.sbaqueroa.model.implementation.OrderRecordView;

/**
 * 
 * Class which implements {@link OrderRecordViewDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
@Repository
public class OrderRecordViewDAOImplementation implements OrderRecordViewDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<OrderRecordView> getAll() throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<OrderRecordView> cq = builder.createQuery(OrderRecordView.class);
	    Root<OrderRecordView> root = cq.from(OrderRecordView.class);
	    cq.select(root);
	    return entityManager.createQuery(cq).getResultList();
	}

}
