package com.lay.inventario.resources.vo;

public class MovimientoDetalleVO {

	private Integer mode_item;
	private MovimientoVO movimiento;
	private ProductoVO producto;
	private Integer modeCantidad;
	private Double modePrecio;
	private boolean modeActivo;

	public MovimientoDetalleVO() {
	}
	
	public MovimientoDetalleVO(Integer mode_item, MovimientoVO movimiento, ProductoVO producto, Integer modeCantidad,
			Double modePrecio, boolean modeActivo) {
		this.mode_item = mode_item;
		this.movimiento = movimiento;
		this.producto = producto;
		this.modeCantidad = modeCantidad;
		this.modePrecio = modePrecio;
		this.modeActivo = modeActivo;
	}

	public MovimientoVO getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(MovimientoVO movimiento) {
		this.movimiento = movimiento;
	}

	public ProductoVO getProducto() {
		return producto;
	}

	public void setProducto(ProductoVO producto) {
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

	public Integer getMode_item() {
		return mode_item;
	}

	public void setMode_item(Integer mode_item) {
		this.mode_item = mode_item;
	}

}
