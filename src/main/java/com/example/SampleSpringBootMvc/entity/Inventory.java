package com.example.SampleSpringBootMvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {

	@Id
	@Column(name="inv_id")
	private Integer inventoryId;
	@Column(name="count")
	private Integer count;
	public Inventory()
	{
		
	}
	
	public Inventory(Integer inventoryId, Integer count) {
		this.inventoryId = inventoryId;
		this.count = count;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", count=" + count + "]";
	}
	
	
	
}
