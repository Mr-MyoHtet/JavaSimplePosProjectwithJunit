package com.myohtet.spring.pos.domain.output;

import java.time.LocalDateTime;

public class SaleInfo {

	private int id;
	private String salePerson;
	private LocalDateTime saleAt;
	private long itemCount;
	private Long totalAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalePerson() {
		return salePerson;
	}

	public void setSalePerson(String salePerson) {
		this.salePerson = salePerson;
	}

	public LocalDateTime getSaleAt() {
		return saleAt;
	}

	public void setSaleAt(LocalDateTime saleAt) {
		this.saleAt = saleAt;
	}

	public long getItemCount() {
		return itemCount;
	}

	public void setItemCount(long itemCount) {
		this.itemCount = itemCount;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

}
