package service;

public class SubscriptionService {
	private int ZERO = 0;	
	private int TWO = 2;	
	
	public String truncate(String orderDetails, int i, String strToReplace) {
		
		String returnString = orderDetails.substring(ZERO, TWO) + strToReplace + orderDetails.substring(orderDetails.length()-TWO, orderDetails.length());
		return computeFinalString(orderDetails, returnString, i);			
	}

	private String computeFinalString(String orderDetails, String returnString, int i) {
		return checkFinalLength(orderDetails, returnString, i) ? orderDetails : returnString;			
	}

	private boolean checkFinalLength(String orderDetails, String returnString, int i) {
		boolean flag = false;
		if(orderDetails.length() <= i || returnString.length()>i)
		{
			flag = true;
		}
		return flag;
	}


}
