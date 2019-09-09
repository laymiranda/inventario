package com.lay.inventario.resources.vo;

import javax.persistence.Id;

public class ClienteVO {

	@Id
	private String clieId;
	private String clieNombre;
	private String clieApellido;
	private String clieDireccion;
	private String clieTelefono;
	private String clieEmail;

	public ClienteVO() {
	}

	public ClienteVO(String clieId, String clieNombre, String clieApellido, String clieDireccion, String clieTelefono,
			String clieEmail) {
		this.clieId = clieId;
		this.clieNombre = clieNombre;
		this.clieApellido = clieApellido;
		this.clieDireccion = clieDireccion;
		this.clieTelefono = clieTelefono;
		this.clieEmail = clieEmail;
	}

	public String getClieId() {
		return clieId;
	}

	public void setClieId(String clieId) {
		this.clieId = clieId;
	}

	public String getClieNombre() {
		return clieNombre;
	}

	public void setClieNombre(String clieNombre) {
		this.clieNombre = clieNombre;
	}

	public String getClieApellido() {
		return clieApellido;
	}

	public void setClieApellido(String clieApellido) {
		this.clieApellido = clieApellido;
	}

	public String getClieDireccion() {
		return clieDireccion;
	}

	public void setClieDireccion(String clieDireccion) {
		this.clieDireccion = clieDireccion;
	}

	public String getClieTelefono() {
		return clieTelefono;
	}

	public void setClieTelefono(String clieTelefono) {
		this.clieTelefono = clieTelefono;
	}

	public String getClieEmail() {
		return clieEmail;
	}

	public void setClieEmail(String clieEmail) {
		this.clieEmail = clieEmail;
	}

}
