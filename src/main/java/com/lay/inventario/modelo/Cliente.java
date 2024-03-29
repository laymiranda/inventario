package com.lay.inventario.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Cliente.findClienteById", query="Select c from Cliente c where c.clieId = ?1")
@NamedQuery(name="Cliente.findByNombreApellido", query = "Select c from Cliente c where c.clieNombre like '%?1%' or c.clieApellido like '%?1%' ")
public class Cliente {

	@Id
	private String clieId;
	private String clieNombre;
	private String clieApellido;
	private String clieDireccion;
	private String clieTelefono;
	private String clieEmail;

	public Cliente() {
	}

	public Cliente(String clieId, String clieNombre, String clieApellido, String clieDireccion, String clieTelefono,
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
