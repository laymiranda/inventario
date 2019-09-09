package com.lay.inventario.negocio.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lay.inventario.modelo.Cliente;
import com.lay.inventario.resources.util.UtilidadesTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void getAllClients() {
		// Act
		clienteService.list();
	}
	
	@Test
	public void findByNombreApellido() {
		// Act
		clienteService.findByNombreApellido("Lay");
	}
	
	@Test
	public void findById() {
		// Act
		clienteService.findById("112233444");
	}
	
	@Test
	public void createCliente() {
		Cliente cliente = UtilidadesTest.dummyCliente();
		clienteService.create(cliente);
	}
	
	@Test
	public void updatecliente() {
		Cliente cliente = UtilidadesTest.dummyCliente();
		cliente.setClieNombre("Nombre editado");
		clienteService.update(cliente);
		
	}

	//@Test
	public void deleteCliente() {
		Cliente cliente = UtilidadesTest.dummyCliente();
		clienteService.delete(cliente);
	}
}
