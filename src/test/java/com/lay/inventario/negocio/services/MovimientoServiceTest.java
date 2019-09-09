package com.lay.inventario.negocio.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lay.inventario.modelo.Movimiento;
import com.lay.inventario.resources.util.UtilidadesTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientoServiceTest {

	@Autowired
	private MovimientoService movimientoService;


	@Test
	public void createMovimiento() {

		//Arrange
		Movimiento movimiento = UtilidadesTest.dummyMovimiento();

		//Act
		movimiento = movimientoService.save(movimiento);

		//Assert
		assertNotNull(movimiento);

	}

	@Test
	public void obtenerMovimiento() {
		//Arrange
		Movimiento movimiento = UtilidadesTest.dummyMovimiento();
		
		//Act
		movimiento = movimientoService.findByConsecutivo(movimiento.getMoviConsecutivo().intValue());
		
		//Assert
		assertNotNull(movimiento);
	}

	@Test
	public void anularMovimiento() {
		//Arrange
		Movimiento movimiento = UtilidadesTest.dummyMovimiento();
		//Act
		movimientoService.anular(movimiento.getMoviConsecutivo().intValue());

	}

	

	
}
