package com.lay.inventario.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lay.inventario.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

	List<Cliente> findByNombreApellido(String nombreApellido);

	Cliente findClienteById(String clieId);


}
