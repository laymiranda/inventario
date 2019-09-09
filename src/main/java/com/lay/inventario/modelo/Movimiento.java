package com.lay.inventario.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Movimiento.findByConsecutivo", query = "Select m from Movimiento m where m.moviConsecutivo =?1 ")
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

	@ManyToOne
	@JoinColumn(name = "vend_id")
	private Vendedor vendedor;

	private boolean moviActivo;

	@OneToMany(mappedBy = "movimiento")
	// @JoinColumn(name = "movi_consecutivo")
	private Set<MovimientoDetalle> movimientoDetalleSet = new HashSet<MovimientoDetalle>();

	public Movimiento() {
	}

	public Movimiento(Integer moviConsecutivo, String moviTipo, Date moviFechaHora, Vendedor vendedor, Cliente cliente,
			boolean moviActivo) {
		this.moviConsecutivo = moviConsecutivo;
		this.moviTipo = moviTipo;
		this.moviFechaHora = moviFechaHora;
		this.cliente = cliente;
		this.moviActivo = moviActivo;
		this.vendedor = vendedor;
	}

	public Movimiento(Integer moviConsecutivo, String moviTipo, Date moviFechaHora, Vendedor vendedor, Cliente cliente,
			boolean moviActivo, Set<MovimientoDetalle> movimientoDetalleSet) {
		super();
		this.moviConsecutivo = moviConsecutivo;
		this.moviTipo = moviTipo;
		this.moviFechaHora = moviFechaHora;
		this.cliente = cliente;
		this.moviActivo = moviActivo;
		this.movimientoDetalleSet = movimientoDetalleSet;
		this.vendedor = vendedor;
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

	public Set<MovimientoDetalle> getMovimientoDetalleSet() {
		return movimientoDetalleSet;
	}

	public void setMovimientoDetalleSet(Set<MovimientoDetalle> movimientoDetalleSet) {
		this.movimientoDetalleSet = movimientoDetalleSet;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
