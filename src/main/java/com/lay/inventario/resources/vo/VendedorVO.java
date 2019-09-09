package com.lay.inventario.resources.vo;

public class VendedorVO {

	private String vendId;
	private String vendNombre;
	
	public VendedorVO() {
	}

	public VendedorVO(String vendId, String vendNombre) {
		this.vendId = vendId;
		this.vendNombre = vendNombre;
	}

	public String getVendId() {
		return vendId;
	}

	public void setVendId(String vendId) {
		this.vendId = vendId;
	}

	public String getVendNombre() {
		return vendNombre;
	}

	public void setVendNombre(String vendNombre) {
		this.vendNombre = vendNombre;
	}
}
