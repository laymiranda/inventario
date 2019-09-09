package com.lay.inventario.negocio.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lay.inventario.modelo.Movimiento;
import com.lay.inventario.negocio.repository.MovimientoRepository;

@Service
@Transactional(readOnly = true)
public class MovimientoService {

	private final MovimientoRepository movimientoRepository;

	public MovimientoService(MovimientoRepository movimientoRepository) {
		this.movimientoRepository = movimientoRepository;
	}

	/**
	 * Metodo utilizado para guardar un movimiento
	 * @param producto
	 * @return
	 */
	@Transactional
	public Movimiento save(Movimiento movimiento) {
		return movimientoRepository.save(movimiento);
	}

	/**
	 * Metodo utilizado para obtener un movimiento
	 * @param producto
	 * @return
	 */
	public Movimiento findByConsecutivo(int consecutivo) {
		return movimientoRepository.findByConsecutivo(consecutivo);
	}

	/**
	 * Metodo utilizado para anular un movimiento
	 * @param producto
	 * @return
	 */
	@Transactional
	public void anular(int consecutivo) {

		Movimiento movimiento = movimientoRepository.findByConsecutivo(consecutivo);
		if (movimiento != null) {
			movimiento.setMoviActivo(false);
			movimientoRepository.save(movimiento);
		}

	}

	/**
	 * Metodo utilizado para actualizar un movimiento
	 * @param producto
	 * @return
	 */
	public Movimiento update(Movimiento movimiento) {
		return movimientoRepository.save(movimiento);
	}

}
