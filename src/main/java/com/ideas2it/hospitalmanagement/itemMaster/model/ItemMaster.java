package com.ideas2it.hospitalmanagement.itemMaster.model;

import javax.enterprise.inject.Model;

/**
 * <p>
 * ItemMaster class is having the getters and setter methods which is used to
 * get the values and set values. This class acts as an Model for the Item
 * Details.
 * <p>
 * 
 * @author navaneeth and hari
 */
@Model
public class ItemMaster {

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
