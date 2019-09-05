package com.lay.inventario.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer moviConsecutivo;
	
	private String moviTipo;
	
	private Date moviFechaHora;

	@ManyToOne
	@JoinColumn(name = "clie_id")
	private Cliente cliente;

	private boolean moviActivo;

	public Movimiento() {
	}

	public Movimiento(Integer moviConsecutivo, String moviTipo, Date moviFechaHora, Cliente cliente,
			boolean moviActivo) {
		super();
		this.moviConsecutivo = moviConsecutivo;
		this.moviTipo = moviTipo;
		this.moviFechaHora = moviFechaHora;
		this.cliente = cliente;
		this.moviActivo = moviActivo;
	}

	public Integer getMoviConsecutivo() {
		return moviConsecutivo;
	}

	public void setMoviConsecutivo(Integer moviConsecutivo) {
		this.moviConsecutivo = moviConsecutivo;
	}

	public String getMoviTipo() {
		return moviTipo;
	}

	public void setMoviTipo(String moviTipo) {
		this.moviTipo = moviTipo;
	}

	public Date getMoviFechaHora() {
		return moviFechaHora;
	}

	public void setMoviFechaHora(Date moviFechaHora) {
		this.moviFechaHora = moviFechaHora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isMoviActivo() {
		return moviActivo;
	}

	public void setMoviActivo(boolean moviActivo) {
		this.moviActivo = moviActivo;
	}

}
