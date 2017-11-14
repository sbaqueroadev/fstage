package co.com.sbaqueroa.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.com.sbaqueroa.model.implementation.Order;
import co.com.sbaqueroa.model.implementation.OrderRecordView;

/**
 * Class which handles HTTP requests that are pointed to routes beginning with /order/*
 * @author sergio
 *
 */
@Controller
public class OrderServices {
	
	/** Handles request to show the add Order form view
	 * @return View in order/addForm.jsp
	 */
	
	@Autowired
	private OrderImpl orderImpl;
	
	@RequestMapping(value="/order/form",method = {RequestMethod.GET})
	public ModelAndView form(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orders/addForm");
		mv.addObject("command",new Order());
		return mv;
	}
	
	/**
	 * Handles request to show the home view
	 * @return View in order/addForm.jsp
	 */
	@RequestMapping(value="/order/home",method = {RequestMethod.GET})
	public String home(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orders/home");
		return "orders/home";
	}
	
	/**
	 * Handles request to get all {@link Order}.
	 * @return List of {@link Order} 
	 */
	@RequestMapping(value="/order/",method = {RequestMethod.GET})
	public @ResponseBody List<Order> getAll(){
		List<Order> result= new ArrayList<Order>();
		result = orderImpl.getAll();
		return result;
	}
	
	/**
	 * Handles request to add new {@link Order}
	 * @param order {@link Order} to add.
	 * @return {@link JSONObject} with result true if process is successful or fail otherwise.
	 */
	@RequestMapping(value="/order/",method = {RequestMethod.POST})
	@Transactional(noRollbackFor = Exception.class)
	public @ResponseBody String add(@RequestBody Order order){
		JSONObject result = new JSONObject();
		if(orderImpl.add(order)){
			return result.put("result", "OK").toString();
		}else
			return result.put("result", "fail").toString();
		
	}
	
	/**
	 * Handles request to get all {@link OrderRecordView}.
	 * @return List of {@link OrderRecordView} 
	 */
	@RequestMapping(value="/order/record",method = {RequestMethod.GET})
	public ModelAndView record(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orders/recordList");
		return mv;
	}
}
