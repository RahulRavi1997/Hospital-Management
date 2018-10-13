package com.ideas2it.hospitalmanagement.item.model;

import javax.enterprise.inject.Model;

/**
 * <p>
 * Item class is having the getters and setter methods which is used to get the
 * values and set values. This class acts as an Model for the Item Details.
 * <p>
 * 
 * @author navaneeth and hari
 */
@Model
public class Item {

	private int id;
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
