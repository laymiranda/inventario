package com.lay.inventario.negocio.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lay.inventario.modelo.Producto;
import com.lay.inventario.resources.util.UtilidadesTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoServiceTest {

	@Autowired
	private ProductoService productoService;
	
	@Test
	public void getAllProducts() {
		// Act
		productoService.list();
	}
	
	
	@Test
	public void createAndUpdateAndDeleteProduct() {
		
		Producto producto = UtilidadesTest.dummyProduct();
		
		Producto productoCreated = productoService.create(producto);
		
		productoCreated.setProdNombre("Nombre Editado");
		
		Producto productoUpdated = productoService.update(productoCreated);
		
		//productoService.delete(productoUpdated);
		
	}

}
