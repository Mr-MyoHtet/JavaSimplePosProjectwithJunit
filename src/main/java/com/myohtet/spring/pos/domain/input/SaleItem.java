package com.myohtet.spring.pos.domain.input;

public class SaleItem {

	// sale Item is equal to sale product
	private int saleId;
	private String productCode;
	private int unitPrice;
	private int quantity;

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "SaleItem [saleId=" + saleId + ", productCode=" + productCode + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + "]";
	}

}
