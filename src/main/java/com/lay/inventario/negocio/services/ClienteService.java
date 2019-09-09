package com.lay.inventario.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lay.inventario.modelo.Cliente;
import com.lay.inventario.negocio.repository.ClienteRepository;

@Service
@Transactional(readOnly = true)
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService (ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	/**
	 * Metodo utilizado para crear un cliente
	 * @param producto
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo utilizado para buscar un cliente por nombre o apellido
	 * @param producto
	 * @return
	 */
	public List<Cliente> list() {
		return clienteRepository.findAll();
	}

	/**
	 * Metodo utilizado para buscar un cliente por nombre o apellido
	 * @param producto
	 * @return
	 */
	public List<Cliente> findByNombreApellido(String nombreApellido) {
		return clienteRepository.findByNombreApellido(nombreApellido);
	}

	/**
	 * Metodo utilizado para buscar un cliente por Id
	 * @param producto
	 * @return
	 */
	public Cliente findById(String clieId) {
		return clienteRepository.findClienteById(clieId);
	}

	/**
	 * Metodo utilizado para actualizar un cliente
	 * @param producto
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	/**
	 * Metodo utilizado para eliminar un cliente
	 * @param producto
	 * @return
	 */
	@Transactional
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

}
