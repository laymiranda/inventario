package com.lay.inventario.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lay.inventario.modelo.Producto;
import com.lay.inventario.negocio.repository.ProductoRepository;

@Service
@Transactional(readOnly = true)
public class ProductoService {
	
	private final ProductoRepository productoRepository;
	
	public ProductoService (ProductoRepository productoRepository){
		this.productoRepository = productoRepository;
	}

	/**
	 * Metodo utilizado para guardar un producto
	 * @param producto
	 * @return
	 */
	@Transactional
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}
	
	/**
	 * Metodo utilizado para actualizar un producto
	 * @param producto
	 * @return
	 */
	@Transactional
	public Producto update(Producto producto) {
		return productoRepository.save(producto);
	}
	
	/**
	 * Metodo utilizado para obtener todos los productos
	 * @param producto
	 * @return
	 */
	public List<Producto> list(){
		return productoRepository.findAll();
	}

	/**
	 * Metodo utilizado para obtener un producto por codigo
	 * @param producto
	 * @return
	 */
	public Producto findByCodigo(Integer produCodigo) {
		return productoRepository.findByProduCodigo(produCodigo);
	}

	/**
	 * Metodo utilizado para eliminar un producto
	 * @param producto
	 * @return
	 */
	@Transactional
	public void delete(Producto producto) {
		productoRepository.delete(producto);
		
	}
}
