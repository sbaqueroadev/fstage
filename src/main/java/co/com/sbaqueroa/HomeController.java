package co.com.sbaqueroa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.sbaqueroa.model.implementation.Customer;
import co.com.sbaqueroa.services.CustomerImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private CustomerImpl customerImpl;

	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Redirects to /order/form as the home page.
	 * 
	 * @param request HTTP request to handle on.
	 * @param httpServletResponse HTTP response to return.
	 * 
	 * @return View represented by a JSP file.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		System.out.println(request.getRequestURL().toString() + "order/home");
		List<Customer> list = customerImpl.getAll();
	    System.out.println("User count: " + list.size());
	    System.out.println("User count: " + list.get(0).getAvailableProducts().size());
		httpServletResponse.setHeader("Location", request.getRequestURL().toString() + "order/home");
		return "redirect:order/home";
	}

}
