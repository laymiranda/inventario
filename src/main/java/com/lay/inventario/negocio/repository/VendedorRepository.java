package com.lay.inventario.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lay.inventario.modelo.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, String>{

	Vendedor findVendedorById(Integer vendId);


}
