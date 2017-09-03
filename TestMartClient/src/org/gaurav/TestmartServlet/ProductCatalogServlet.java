package org.gaurav.TestmartServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.gaurav.testmartwebservice.GetProductCategory;
import org.gaurav.testmartwebservice.Product;
import org.gaurav.testmartwebservice.ProductCatalog;
import org.gaurav.testmartwebservice.ProductCatalogService;

public class ProductCatalogServlet extends HttpServlet implements Comparator{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		ProductCatalogService productDetails = new ProductCatalogService();
		ProductCatalog obj = productDetails.getProductCatalogPort();


		
		int itemCategory = 0;
		int getItems = 0;
		boolean responseAdd;
		System.out.print("Start Adding");
		if (request.getParameter("AddItem") != null) {
			System.out.print("Inside Item");
			String itemCategoryString = request.getParameter("category");
			itemCategory = Integer.parseInt(itemCategoryString);
			String InStock = request.getParameter("txtStock");
			String ItemPrice = request.getParameter("txtPrice");
			String ItemDesc = request.getParameter("txtProduct");
			
			System.out.print("itemCategory : " + itemCategory
					+ "\nInStock : " + InStock
					+ "\nItemPrice : " + ItemPrice
					+ "\nItemDesc : " + ItemDesc);
			
			responseAdd = obj.addProduct(itemCategory, ItemDesc,
					ItemPrice, InStock);
			System.out.print(responseAdd + "AddItem");
			List<Product> products = new ArrayList<Product>();
			products = obj.getProductCategory(itemCategory);
			int size = products.size();
			System.out.println("size" + size);
			
			request.setAttribute("ProductDetails", products); //categorylist is an arraylist      contains object of class category  
			getServletConfig().getServletContext().getRequestDispatcher("/ProductDetails.jsp").forward(request,response);
			
	        } else if (request.getParameter("AddCategory") != null) {
	        	System.out.print("Inside Category");
	        	String NewCategory =request.getParameter("CategoryText");
	        	responseAdd = obj.addCategory(NewCategory);
				System.out.print(responseAdd + "AddCategory");
				List<Product> products = new ArrayList<Product>();
				products = obj.getProductCategory(itemCategory);
				int size = products.size();
				System.out.println("size" + size);
				
				request.setAttribute("ProductDetails", products); //categorylist is an arraylist      contains object of class category  
				getServletConfig().getServletContext().getRequestDispatcher("/ProductDetails.jsp").forward(request,response);
	        } 

		
		
		
		

			
		


		// boolean responseAdd = obj.addCategory("Beverages");
		// System.out.print(responseAdd + "\n");

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			ProductCatalogService productDetails = new ProductCatalogService();
			ProductCatalog obj = productDetails.getProductCatalogPort();
			
			String getItemsString = request.getParameter("getItems");
			
			int itemCategory = 0;
			int getItems = 0;
			
			if (!getItemsString.equals(null)) {
				getItems = Integer.parseInt(getItemsString);
				List<Product> products = new ArrayList<Product>();
				products = obj.getProductCategory(getItems);
				int size = products.size();
				System.out.println("size" + size);
				request.setAttribute("ProductDetails", products); //categorylist is an arraylist      contains object of class category  
				getServletConfig().getServletContext().getRequestDispatcher("/ProductDetails.jsp").forward(request,response);
				
			}

			
		
			// boolean responseAdd = obj.addCategory("Beverages");
			// System.out.print(responseAdd + "\n");

		}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
