package com.lay.inventario.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lay.inventario.modelo.Cliente;
import com.lay.inventario.modelo.Producto;
import com.lay.inventario.negocio.services.ClienteService;
import com.lay.inventario.resources.util.Utilidades;
import com.lay.inventario.resources.vo.ClienteToFindVO;
import com.lay.inventario.resources.vo.ClienteVO;
import com.lay.inventario.resources.vo.ProductoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/Cliente")
@Api(tags = "Cliente")
public class ClienteResource {

	private final ClienteService clienteService;
	
	public ClienteResource (ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Cliente>> list(){
		try {
			return ResponseEntity.ok(clienteService.list());
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/Buscar")
	@ApiOperation(value = "Buscar Clientes", notes = "Servicio para buscar clientes por nombre y apellido")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Cliente>> findByNombreApellido(@RequestBody ClienteToFindVO clienteToFindVO){
		try {
			return ResponseEntity.ok(clienteService.findByNombreApellido(clienteToFindVO.getNombreApellido()));
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{clieId}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Cliente> getCliente(@PathVariable("clieId") String clieId) {
		try {
			return new ResponseEntity<>(this.clienteService.findById(clieId), HttpStatus.OK);
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO) {
		
		try {
		
			if (clienteVO!=null) {
				Cliente cliente = Utilidades.clienteVOtoModel(clienteVO);
				return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			}
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/{clieId}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Cliente> updateCliente(@PathVariable("clieId") String clieId,
			@RequestBody ClienteVO clienteVO) {
		
		try {
			Cliente cliente= this.clienteService.findById(clieId);
	
			if (cliente == null) {
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			} else {
				cliente = Utilidades.clienteVOtoModel(clienteVO);
			}
			return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
