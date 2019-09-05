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
	
	public List<Producto> list(){
		return productoRepository.findAll();
	}

	public Producto findByCodigo(Integer produCodigo) {
		return productoRepository.findByProduCodigo(produCodigo);
	}
}
