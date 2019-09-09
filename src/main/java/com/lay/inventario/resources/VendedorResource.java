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

import com.lay.inventario.modelo.Vendedor;
import com.lay.inventario.negocio.services.VendedorService;
import com.lay.inventario.resources.util.Utilidades;
import com.lay.inventario.resources.vo.VendedorVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/Vendedor")
@Api(tags = "Vendedor")
public class VendedorResource {

	private final VendedorService vendedorService;
	
	public VendedorResource (VendedorService vendedorService) {
		this.vendedorService =vendedorService;
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Vendedores", notes = "Servicio para listar todos los vendedores")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Vendedores encontrados"),
			@ApiResponse(code = 404, message = "Vendedores no encontrados") })
	public ResponseEntity<List<Vendedor>> list(){
		try {
			return ResponseEntity.ok(vendedorService.list());
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping
	@ApiOperation(value = "Crear Vendedor", notes = "Servicio para crear un nuevo vendedor")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Vendedor creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Vendedor> createVendedor(@RequestBody VendedorVO vendedorVO) {
		
		try {
		
			if (vendedorVO!=null) {
				Vendedor vendedor = Utilidades.vendedorVOtoModel(vendedorVO);
				return new ResponseEntity<>(this.vendedorService.create(vendedor), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
			}
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/{vendId}")
	@ApiOperation(value = "Obtener Vendedor", notes = "Servicio para obtener la informacion de un vendedor")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Vendedor encontrado"),
			@ApiResponse(code = 204, message = "Vendedor no encontrado"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Vendedor> getVendedor(@PathVariable("vendId") Integer vendId) {
		try {
			return new ResponseEntity<>(this.vendedorService.findbyId(vendId), HttpStatus.OK);
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{vendId}")
	@ApiOperation(value = "Actualizar Vendedor", notes = "Servicio para actualizar un vendedor")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Vendedor actualizado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Vendedor> updateVendedor(@PathVariable("vendId") Integer vendId,
			@RequestBody VendedorVO vendedorVO) {
		
		try {
			Vendedor vendedor= this.vendedorService.findbyId(vendId);
	
			if (vendedor == null) {
				return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
			} else {
				vendedor = Utilidades.vendedorVOtoModel(vendedorVO);
			}
			return new ResponseEntity<>(this.vendedorService.update(vendedor), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
