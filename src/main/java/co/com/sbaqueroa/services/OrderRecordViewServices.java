package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.sbaqueroa.model.implementation.Order;
import co.com.sbaqueroa.model.implementation.OrderRecordView;

/**
 * Class which handles HTTP requests that are pointed to routes beginning with /order/*
 * @author sergio
 *
 */
@Controller
public class OrderRecordViewServices {
	
	/** Handles request to show the add Order form view
	 * @return View in order/addForm.jsp
	 */
	
	@Autowired
	private OrderRecordViewImpl orderRecordViewImpl;
	
	/**
	 * Handles request to get all {@link Order}.
	 * @return List of {@link Order} 
	 */
	@RequestMapping(value="/orderRecordView/",method = {RequestMethod.GET})
	public @ResponseBody List<OrderRecordView> getAll(){
		List<OrderRecordView> result= new ArrayList<OrderRecordView>();
		result = orderRecordViewImpl.getAll();
		return result;
	}
}
