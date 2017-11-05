package co.com.sbaqueroa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

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
		httpServletResponse.setHeader("Location", request.getRequestURL().toString() + "order/home");
		return "redirect:order/home";
	}

}
