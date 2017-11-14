package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sbaqueroa.dao.OrderRecordViewDAO;
import co.com.sbaqueroa.model.OrderRecordViewInterface;
import co.com.sbaqueroa.model.implementation.OrderRecordView;

@Service
public class OrderRecordViewImpl implements OrderRecordViewInterface{
	
	@Autowired
	private OrderRecordViewDAO orderRecordViewDAO;
	
	@Override
	public List<OrderRecordView> getAll() {
		try {
			return orderRecordViewDAO.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<OrderRecordView>();
	}

	@Override
	public JSONArray getAllJSON() {
		JSONArray ja = new JSONArray();
		for(OrderRecordView orv:this.getAll())
			ja.put(orv.toJSON());
		return ja;
	}
}
