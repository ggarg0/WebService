package org.gaurav.TestmartWebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(name="ShopDetails",portName="ShopDetailsPortname", 
		serviceName="ShopDetailsService", targetNamespace="http://Gaurav.com")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public class ShopInfo {
	
	@WebMethod(operationName="Fetch_categories_operation", action="fetch_categories_action")
	@WebResult(name="PropertyOutput")
	public String getShopInfo(@WebParam(name="PropertyInput")String property) throws InvalidInputException
	{
		String response="Invalid property";
		if("shopName".equalsIgnoreCase(property))
		{
			response="Test Mart";
		}
		else if("since".equalsIgnoreCase(property))
		{
			response="Since 2012";
		}
		else {
			throw new InvalidInputException("Invalid Input", property + " is not a valid input");
		}
		return response;
	}

}
