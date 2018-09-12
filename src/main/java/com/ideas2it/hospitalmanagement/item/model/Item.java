package com.ideas2it.hospitalmanagement.item.model;
import javax.enterprise.inject.Model;

@Model
public class Item {

	private Integer id;
	private String itemName;
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	
}
