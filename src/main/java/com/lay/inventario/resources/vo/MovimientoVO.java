package com.lay.inventario.resources.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MovimientoVO {

	private Integer moviConsecutivo;
	private String moviTipo;
	private Date moviFechaHora;
	private ClienteVO cliente;
	private boolean moviActivo;
	private Set<MovimientoDetalleVO> movimientoDetalleSet = new HashSet<MovimientoDetalleVO>();

	public MovimientoVO() {
	}

	public MovimientoVO(Integer moviConsecutivo, String moviTipo, Date moviFechaHora, ClienteVO cliente,
			boolean moviActivo) {
		this.moviConsecutivo = moviConsecutivo;
		this.moviTipo = moviTipo;
		this.moviFechaHora = moviFechaHora;
		this.cliente = cliente;
		this.moviActivo = moviActivo;
	}

	public MovimientoVO(Integer moviConsecutivo, String moviTipo, Date moviFechaHora, ClienteVO cliente, boolean moviActivo,
			Set<MovimientoDetalleVO> movimientoDetalleSet) {
		this.moviConsecutivo = moviConsecutivo;
		this.moviTipo = moviTipo;
		this.moviFechaHora = moviFechaHora;
		this.cliente = cliente;
		this.moviActivo = moviActivo;
		this.movimientoDetalleSet = movimientoDetalleSet;
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

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public boolean isMoviActivo() {
		return moviActivo;
	}

	public void setMoviActivo(boolean moviActivo) {
		this.moviActivo = moviActivo;
	}

	public Set<MovimientoDetalleVO> getMovimientoDetalleSet() {
		return movimientoDetalleSet;
	}

	public void setMovimientoDetalleSet(Set<MovimientoDetalleVO> movimientoDetalleSet) {
		this.movimientoDetalleSet = movimientoDetalleSet;
	}
}
