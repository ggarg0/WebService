package org.gaurav.TestmartWebService;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.gaurav.TestmartBusinessService.ProductServiceImpl;
import org.gaurav.TestmartModel.Product;

@WebService
public class ProductCatalog {
	ProductServiceImpl ProductService= new ProductServiceImpl();
	
	@WebMethod
	@WebResult(name="Product")
	public List<Product> getProductCategory(int categoryChoice)
	{		
		return ProductService.getProductCategory(categoryChoice);
		
	}
	
	@WebMethod()
	public boolean addProduct(int categoryChoice, String productName,
			String productPrice, String InStock)
	{
				
		return ProductService.addProductDetails(categoryChoice, productName,
				productPrice,InStock);
		
	}
	
	@WebMethod()
	public boolean addCategory(String CategoryName)
	{				
		return ProductService.addCategoryDetails(CategoryName);
	}
	
	
}
