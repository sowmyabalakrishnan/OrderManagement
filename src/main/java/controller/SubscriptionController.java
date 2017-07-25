package controller;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SubscriptionService;

@Controller
public class SubscriptionController {
	
		private static final String VIEW_INDEX = "index";
		private static final String ORIG_STRING = "origString";	
		private static final String ALLOWED_CHARACTERS = "allowedCharacters";		
		private static final String ERROR_MSG = "Mandatory filed left blank";
		private static final String STR_TO_REPLACE = " ... (truncated) ... ";
		SubscriptionService subscriptionService= new SubscriptionService();
		
		@RequestMapping(value = "", method = RequestMethod.GET)
		public String loadIndex(HttpServletRequest request) {
			System.out.println("Entering SubscriptionController:: loadIndex ");
			return VIEW_INDEX;
		}
		
		@RequestMapping(value = "subscribe", method = RequestMethod.GET)
		public @ResponseBody String subscribe(HttpServletRequest request) {
			System.out.println("Entering SubscriptionController :: subscribe");		
			
			String orderDetails = request.getParameter(ORIG_STRING);
			String allowedChars = request.getParameter(ALLOWED_CHARACTERS);
			if(allowedChars!=null && orderDetails!=null)
			{
			int totalCharacters = Integer.parseInt(allowedChars);			
			String trunctedOrderDetails = subscriptionService.truncate(orderDetails, totalCharacters, STR_TO_REPLACE);				
			System.out.println("Exitting SubscriptionController:trunctedOrderDetails "+trunctedOrderDetails);
			return trunctedOrderDetails;
			}
			else
				return ERROR_MSG;
		}
}
