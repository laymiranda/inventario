package com.lay.inventario.resources.util;

import java.util.Date;

import com.lay.inventario.modelo.Cliente;
import com.lay.inventario.modelo.Movimiento;
import com.lay.inventario.modelo.MovimientoDetalle;
import com.lay.inventario.modelo.MovimientoDetalleId;
import com.lay.inventario.modelo.Producto;
import com.lay.inventario.modelo.Vendedor;

public class UtilidadesTest {

	public static Movimiento dummyMovimiento() {

		Cliente cliente = dummyCliente();

		Movimiento movimiento = new Movimiento();
		movimiento.setCliente(cliente);
		movimiento.setMoviActivo(true);
		movimiento.setMoviTipo("ENTRADA");
		movimiento.setMoviFechaHora(new Date());

		Producto producto = dummyProduct();

		MovimientoDetalle movimientoDetalle = new MovimientoDetalle();
		movimientoDetalle.setMovimientoDetalleId(new MovimientoDetalleId(movimiento.getMoviConsecutivo(),1));
		//movimientoDetalle.setMode_item(1);
		movimientoDetalle.setModeCantidad(2);
		movimientoDetalle.setProducto(producto);
		movimientoDetalle.setModePrecio(producto.getProdPrecio());
		movimientoDetalle.setModeActivo(true);

		movimiento.getMovimientoDetalleSet().add(movimientoDetalle);

		return movimiento;
	}
	
	public static Producto dummyProduct() {

		Producto producto = new Producto();
		producto.setProdNombre("Producto test");
		producto.setProdCategoria("Test");
		producto.setProdPrecio(new Double(1000));

		return producto;
	}
	
	public static Cliente dummyCliente() {
		Cliente cliente = new Cliente();
		cliente.setClieId("112233444");
		cliente.setClieNombre("Lay Stiben");
		cliente.setClieApellido("Miranda");
		cliente.setClieDireccion("Calle 123");
		cliente.setClieEmail("laymiranda@gmail.com");
		cliente.setClieTelefono("3011112111");
		return cliente;
	}

	public static Vendedor dummyVendedor() {
		Vendedor vendedor = new Vendedor();
		vendedor.setVendNombre("Vendedor de pruebas");
		return vendedor;
	}
}
