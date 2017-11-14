package co.com.sbaqueroa.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.sbaqueroa.dao.OrderDAO;
import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.model.implementation.Order;

/**
 * Class which implements {@link OrderDAO}. Contains table and column names and the 
 * {@link DataSource} object to manage SQL connection.
 * 
 * @author sergio
 *
 */
@Repository
public class OrderDAOImplementation implements OrderDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(readOnly=false)
	public Order insert(Order order) throws Exception {
		entityManager.persist(order);
		entityManager.flush();
		return order;
	}

	@Override
	public List<Order> getAll() throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Order> cq = builder.createQuery(Order.class);
	    Root<Order> root = cq.from(Order.class);
	    cq.select(root);
	    return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<Order> get(String field, String value) throws Exception {
		/*String query = "SELECT * FROM "+TABLE_NAME +" WHERE "+field+" = '"+value+"'";
		System.out.println(query);
		Connection conn;
		*/List<Order> orders = new ArrayList<Order>();
		/*try{
			conn = dataSource.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				orders.add(new Order.Builder().setId(rs.getInt(ID_COLUMN_NAME))
						.setCustomerId(rs.getInt(CUSTOMER_ID_COLUMN_NAME))
						.setCreationDate(rs.getDate(CREATION_DATE_COLUMN_NAME))
						.setDeliveryAddress(rs.getString(DELIVERY_ADDRESS_COLUMN_NAME))
						.build());
				
			}
			st.close();
		}catch (Exception e) {
			throw e;
		}*/
		return orders;
	}

	@Override
	public void update(Order order) {
		entityManager.refresh(order);
	}

}
