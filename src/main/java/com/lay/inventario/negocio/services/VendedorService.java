package com.lay.inventario.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lay.inventario.modelo.Vendedor;
import com.lay.inventario.negocio.repository.VendedorRepository;

@Service
@Transactional(readOnly = true)
public class VendedorService {
	
	private final VendedorRepository vendedorRepository;

	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}

	/**
	 * Metodo utilizado para obtener todos los vendedores
	 * @param producto
	 * @return
	 */
	@Transactional
	public List<Vendedor> list() {
		return this.vendedorRepository.findAll();
		
	}

	/**
	 * Metodo utilizado para crear un vendedor
	 * @param producto
	 * @return
	 */
	@Transactional
	public Vendedor create(Vendedor vendedor) {
		return this.vendedorRepository.save(vendedor);
	}

	/**
	 * Metodo utilizado para actualizar un vendedor
	 * @param producto
	 * @return
	 */
	@Transactional
	public Vendedor update(Vendedor vendedor) {
		return this.vendedorRepository.save(vendedor);
	}
	
	/**
	 * Metodo utilizado para eliminar un vendedor
	 * @param producto
	 * @return
	 */
	@Transactional
	public void delete(Vendedor vendedor) {
		this.vendedorRepository.delete(vendedor);
	}

	public Vendedor findbyId(Integer vendId) {
		return this.vendedorRepository.findVendedorById(vendId);
	}
	

}
