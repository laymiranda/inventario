package com.lay.inventario.negocio.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lay.inventario.modelo.Vendedor;
import com.lay.inventario.resources.util.UtilidadesTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendedorServiceTest {
	
	@Autowired
	private VendedorService vendedorService;

	@Test
	public void getAllVendedores() {
		// Act
		vendedorService.list();
	}
	
	@Test
	public void createAndUpdateAndDeleteVendedor() {
		
		Vendedor vendedor = UtilidadesTest.dummyVendedor();
		
		Vendedor vendedorCreated = vendedorService.create(vendedor);
		
		vendedorCreated.setVendNombre("Nombre Editado");
		
		Vendedor vendedorUpdated = vendedorService.update(vendedorCreated);
		
		vendedorService.delete(vendedorUpdated);
		
	}
}
