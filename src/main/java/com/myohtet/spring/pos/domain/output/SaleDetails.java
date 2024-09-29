package com.myohtet.spring.pos.domain.output;

import java.time.LocalDateTime;
import java.util.List;

public class SaleDetails {

	private int id;
	private String salePerson;
	private LocalDateTime saleAt;
	private List<SaleDetailsItem> items;

	public int getItemCount() {
		if (items != null && !items.isEmpty()) {
			return items.stream().mapToInt(a -> a.getQuantity()).sum();
		}
		return 0;
	}

	public int getTotal() {

		if (items != null && !items.isEmpty()) {
			return items.stream().mapToInt(a -> a.getTotal()).sum();
		}
		return 0;
	}

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

	public List<SaleDetailsItem> getItems() {
		return items;
	}

	public void setItems(List<SaleDetailsItem> items) {
		this.items = items;
	}

	public static SaleDetails from(SaleInfo saleInfo, List<SaleDetailsItem> items) {

		var details = new SaleDetails();

		details.setId(saleInfo.getId());
		details.setSalePerson(saleInfo.getSalePerson());
		details.setSaleAt(saleInfo.getSaleAt());
		details.setItems(items);
		return details;
	}

}
