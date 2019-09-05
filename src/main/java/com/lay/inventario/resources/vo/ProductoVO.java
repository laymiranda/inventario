package com.lay.inventario.resources.vo;

public class ProductoVO {
	
	private Integer prodCodigo;
	private String prodNombre;
	private String prodCategoria;
	private Double prodPrecio;

	public ProductoVO() {
	}

	public ProductoVO(Integer prodCodigo, String prodNombre, String prodCategoria, Double prodPrecio) {
		this.prodCodigo = prodCodigo;
		this.prodNombre = prodNombre;
		this.prodCategoria = prodCategoria;
		this.prodPrecio = prodPrecio;
	}

	public Integer getProdCodigo() {
		return prodCodigo;
	}

	public void setProdCodigo(Integer prodCodigo) {
		this.prodCodigo = prodCodigo;
	}

	public String getProdNombre() {
		return prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}

	public String getProdCategoria() {
		return prodCategoria;
	}

	public void setProdCategoria(String prodCategoria) {
		this.prodCategoria = prodCategoria;
	}

	public Double getProdPrecio() {
		return prodPrecio;
	}

	public void setProdPrecio(Double prodPrecio) {
		this.prodPrecio = prodPrecio;
	}
}
