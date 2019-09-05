package com.lay.inventario.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Producto.findByName", query = "Select p from Producto p where p.prodNombre like '%?1%' ")
@NamedQuery(name="Producto.findByProduCodigo", query="Select p from Producto p where p.prodCodigo = ?1")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer prodCodigo;
	private String prodNombre;
	private String prodCategoria;
	private Double prodPrecio;

	public Producto() {
	}

	public Producto(Integer prodCodigo, String prodNombre, String prodCategoria, Double prodPrecio) {
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
