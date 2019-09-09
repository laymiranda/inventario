package com.lay.inventario.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lay.inventario.modelo.Producto;

/**
 * Interface para definir las operaciones de BD relacionadas
 * con el producto
 * @author laystiben
 *
 */
public interface ProductoRepository extends JpaRepository<Producto, String> {

	List<Producto> findByName(String name);

	Producto findByProduCodigo(Integer produCodigo);
	
}
