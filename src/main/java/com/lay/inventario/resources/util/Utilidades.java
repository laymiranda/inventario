package com.lay.inventario.resources.util;

import java.util.HashSet;
import java.util.Set;

import com.lay.inventario.modelo.Cliente;
import com.lay.inventario.modelo.Movimiento;
import com.lay.inventario.modelo.MovimientoDetalle;
import com.lay.inventario.modelo.MovimientoDetalleId;
import com.lay.inventario.modelo.Producto;
import com.lay.inventario.modelo.Vendedor;
import com.lay.inventario.resources.vo.ClienteVO;
import com.lay.inventario.resources.vo.MovimientoDetalleVO;
import com.lay.inventario.resources.vo.ProductoVO;
import com.lay.inventario.resources.vo.VendedorVO;

public class Utilidades {

	public static Cliente clienteVOtoModel(ClienteVO clienteVO) {
		
		Cliente cliente = new Cliente();
		
		cliente.setClieId(clienteVO.getClieId());
		cliente.setClieNombre(clienteVO.getClieNombre());
		cliente.setClieApellido(clienteVO.getClieApellido());
		cliente.setClieDireccion(clienteVO.getClieDireccion());
		cliente.setClieTelefono(clienteVO.getClieTelefono());
		clienteVO.setClieEmail(clienteVO.getClieEmail());

		return cliente;
	}

	public static Set<MovimientoDetalle> movimientoDetalleVOtoModel(Movimiento movimiento,Set<MovimientoDetalleVO> movimientoDetalleVOSet) {

		Set<MovimientoDetalle> movimientoDetalleSet = new HashSet<MovimientoDetalle>();
		
		for (MovimientoDetalleVO movimientoDetalleVO : movimientoDetalleVOSet) {
			
			MovimientoDetalle movimientoDetalle = new MovimientoDetalle();
			movimientoDetalle.setMovimientoDetalleId(new MovimientoDetalleId(movimiento.getMoviConsecutivo(),movimientoDetalleVO.getMode_item()));
			movimientoDetalle.setModeActivo(movimientoDetalleVO.isModeActivo());
			movimientoDetalle.setModeCantidad(movimientoDetalleVO.getModeCantidad());
			movimientoDetalle.setModePrecio(movimientoDetalleVO.getModePrecio());
			movimientoDetalle.setMovimiento(movimiento);
			movimientoDetalle.setProducto(productoVOtoModel(movimientoDetalleVO.getProducto()));
			
			movimientoDetalleSet.add(movimientoDetalle);
			
		}
		
		return movimientoDetalleSet;
	}

	public static Producto productoVOtoModel(ProductoVO productoVO) {
		
		Producto producto= new Producto();
		producto.setProdNombre(productoVO.getProdNombre());
		producto.setProdPrecio(productoVO.getProdPrecio());
		
		return producto;
	}

	public static Vendedor vendedorVOtoModel(VendedorVO vendedorVO) {
		Vendedor vendedor = new Vendedor();
		vendedor.setVendId(vendedorVO.getVendId());
		vendedor.setVendNombre(vendedorVO.getVendNombre());
		return vendedor;
	}

}
