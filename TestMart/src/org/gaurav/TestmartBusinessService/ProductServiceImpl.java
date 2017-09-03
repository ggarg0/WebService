package org.gaurav.TestmartBusinessService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gaurav.TestmartModel.Product;

public class ProductServiceImpl {

	List<Product> categoryItemsConnList = new ArrayList();
		public Connection getDBConnection() {
		try {
			Connection connection = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager
			.getConnection("jdbc:oracle:thin:@//localhost:1521/XE",
					"hr", "hr");

			return connection;

		} catch (Exception e) {

			System.out.println("Exception in getDBConnection: " + e);
			e.printStackTrace();
			return null;
		}
	}

	public void closeDBConnection(Connection con) {
		try {
			con.close();

		} catch (Exception e) {

			System.out.println("Exception in closeDBConnection: " + e);
			e.printStackTrace();

		}
	}

	public List<Product> getCategoryItems(int categoryChoice) {
		List<Product> categoryItemsConnListDB = new ArrayList();
		Connection categoryItemsConn= getDBConnection();
		System.out.println("");
		System.out.println("-------- Category Item List -------");
		try {
			
			ResultSet result = null;
			String query = "SELECT item_id,item_name,item_price,in_stock FROM Category_Items where category_id=?";
			PreparedStatement pstmt = categoryItemsConn.prepareStatement(query);
			pstmt.setInt(1, categoryChoice); 
			result = pstmt.executeQuery();
			System.out.println("");
			
			
			while (result.next()) {
				categoryItemsConnListDB.add(new Product(result.getInt(1),
						result.getString(2),result.getString(3),
						result.getString(4)));
				System.out.println(result.getInt(1)+" --- "
						+ result.getString(2)+" --- "
						+ result.getString(3)+" --- "
						+ result.getString(4)+" --- ");
				
				categoryItemsConnListDB.get(0).getItem_id();
			}
			System.out.println("");
			return categoryItemsConnListDB;
	
		}
		catch (Exception e)
		{
			System.out.println("Exception in getMovies: " + e);
			return null;
		}finally
		{
			try{
				categoryItemsConn.close();	
			}catch(Exception e)
			{
				System.out.println("Exception in getMovies: " + e);
			}
		}
			}

	
	public List<Product> getProductCategory(int choice) {
		
			categoryItemsConnList=getCategoryItems(choice);
			return categoryItemsConnList;
		
	}

	public boolean addCategoryItems(int categoryChoice, String itemDetails,
			String productPrice, String InStock) {
		
		Connection ItemConn= getDBConnection();
		
		try {
			System.out.print("cALLING iNSERT FINAL  : " );
			System.out.print("\ncategoryChoice : " + categoryChoice
					+ "\nitemDetails : " + itemDetails
					+ "\nproductPrice LAST : " + productPrice
					+ "\nInStock : " + InStock);
			PreparedStatement preparedStatement = ItemConn.prepareStatement
			("INSERT INTO Category_Items " +
					"(item_name,item_price,in_stock,category_id)" +
					" VALUES (?,?,?,?)");
			
			preparedStatement.setString(1,itemDetails);
			preparedStatement.setString(2,productPrice);
			preparedStatement.setString(3,InStock);
			preparedStatement.setInt(4,categoryChoice);
			preparedStatement.execute();
			ItemConn.commit();
			System.out.println("nRecord Inserted Successfully");
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Exception in addCategoryItems: " + e);
			return false;
		}finally
		{
			try{
				ItemConn.close();	
			}catch(Exception e)
			{
				System.out.println("Exception in addCategoryItems: " + e);
			}
		}
			}
	
	public boolean addCategoryDetails(String CategotyDetails) {
		
		Connection CategoryConn= getDBConnection();
		
		try {
			
			PreparedStatement preparedStatement = CategoryConn.prepareStatement("INSERT INTO Category_Details (Category_Name) VALUES (?)");
			preparedStatement.setString(1,CategotyDetails);
			preparedStatement.execute();
			CategoryConn.commit();
			System.out.println("nRecord Inserted Successfully");
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Exception in addCategoryDetails: " + e);
			return false;
		}finally
		{
			try{
				CategoryConn.close();	
			}catch(Exception e)
			{
				System.out.println("Exception in addCategoryDetails: " + e);
			}
		}
			}
	
		public boolean addProductDetails(int categoryChoice, String productDetails,
				String productPrice, String InStock) {
			
		boolean addResult=addCategoryItems(categoryChoice,productDetails,
				productPrice,InStock);
		return addResult;
	}

}
