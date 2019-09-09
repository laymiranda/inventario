package com.lay.inventario.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lay.inventario.modelo.Movimiento;

/**
 * Interface para definir las operaciones de BD relacionadas a los movimientos
 * con el producto
 * @author laystiben
 *
 */
public interface MovimientoRepository extends JpaRepository<Movimiento, String> {
	
	Movimiento findByConsecutivo(int consecutivo);
	
}
