package com.lay.inventario.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento_detalle")
public class MovimientoDetalle {

	@EmbeddedId
	MovimientoDetalleId movimientoDetalleId;

	/*
	 * @Id private Integer mode_item;
	 */

	@ManyToOne
	//@JoinColumn(name = "movi_consecutivo")
	@MapsId("movi_consecutivo")
	private Movimiento movimiento;

	@ManyToOne
	@JoinColumn(name = "prod_codigo")
	private Producto producto;

	private Integer modeCantidad;
	private Double modePrecio;
	private boolean modeActivo;

	public MovimientoDetalle() {
	}

	public MovimientoDetalle(MovimientoDetalleId movimientoDetalleId, Movimiento movimiento, Producto producto,
			Integer modeCantidad, Double modePrecio, boolean modeActivo) {
		super();
		this.movimientoDetalleId = movimientoDetalleId;
		this.movimiento = movimiento;
		this.producto = producto;
		this.modeCantidad = modeCantidad;
		this.modePrecio = modePrecio;
		this.modeActivo = modeActivo;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getModeCantidad() {
		return modeCantidad;
	}

	public void setModeCantidad(Integer modeCantidad) {
		this.modeCantidad = modeCantidad;
	}

	public Double getModePrecio() {
		return modePrecio;
	}

	public void setModePrecio(Double modePrecio) {
		this.modePrecio = modePrecio;
	}

	public boolean isModeActivo() {
		return modeActivo;
	}

	public void setModeActivo(boolean modeActivo) {
		this.modeActivo = modeActivo;
	}

	public MovimientoDetalleId getMovimientoDetalleId() {
		return movimientoDetalleId;
	}

	public void setMovimientoDetalleId(MovimientoDetalleId movimientoDetalleId) {
		this.movimientoDetalleId = movimientoDetalleId;
	}

}
