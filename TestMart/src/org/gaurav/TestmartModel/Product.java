package org.gaurav.TestmartModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Product")
@XmlType(propOrder={"item_id","item_name","item_price","in_stock"})
public class Product {

	private int item_id;
	private String item_name;
	private String item_price;
	private String in_stock;
	
	public Product() {
	
	}
	
	public Product(int item_id, String item_name, 
			String item_price, String in_stock) {
		this.item_id=item_id;
		this.item_name=item_name;
		this.item_price=item_price;
		this.in_stock=in_stock;
	}

	@XmlElement(name="ProductId")
	public int getItem_id() {
		return item_id;
	}


	public void setItem_id(int itemId) {
		this.item_id = itemId;
	}


	

	@XmlElement(name="ProductDescription")
	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String itemName) {
		this.item_name = itemName;
	}

	@XmlElement(name="ProductPrice")
	public String getItem_price() {
		return item_price;
	}


	public void setItem_price(String itemPrice) {
		this.item_price = itemPrice;
	}

	@XmlElement(name="ProductInStock")
	public String getIn_stock() {
		return in_stock;
	}


	public void setIn_stock(String inStock) {
		this.in_stock = inStock;
	}


	 
}


