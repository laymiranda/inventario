package com.lay.inventario.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MovimientoDetalleId implements Serializable {

	private static final long serialVersionUID = 7539239872958082166L;
	private Integer movi_consecutivo;
	private Integer mode_item;

	public MovimientoDetalleId(Integer movi_consecutivo, Integer mode_item) {
		this.movi_consecutivo = movi_consecutivo;
		this.mode_item = mode_item;
	}

	public MovimientoDetalleId() {
	}

	public Integer getMovi_consecutivo() {
		return movi_consecutivo;
	}

	public void setMovi_consecutivo(Integer movi_consecutivo) {
		this.movi_consecutivo = movi_consecutivo;
	}

	public Integer getMode_item() {
		return mode_item;
	}

	public void setMode_item(Integer mode_item) {
		this.mode_item = mode_item;
	}

}
