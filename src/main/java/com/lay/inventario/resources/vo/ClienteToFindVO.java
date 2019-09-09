package com.lay.inventario.resources.vo;

public class ClienteToFindVO {

	private String nombreApellido;

	public ClienteToFindVO() {
	}

	public ClienteToFindVO(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

}
