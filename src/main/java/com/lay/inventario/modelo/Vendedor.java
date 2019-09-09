package com.lay.inventario.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Vendedor.findByName", query = "Select v from Vendedor v where v.vendNombre like '%?1%' ")
@NamedQuery(name = "Vendedor.findVendedorById", query = "Select v from Vendedor v where v.vendId = ?1")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String vendId;
	private String vendNombre;
	
	public Vendedor() {
	}

	public Vendedor(String vendId, String vendNombre) {
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
