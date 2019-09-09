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

import com.lay.inventario.modelo.Producto;
import com.lay.inventario.negocio.services.ProductoService;
import com.lay.inventario.resources.util.Utilidades;
import com.lay.inventario.resources.vo.ProductoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/Producto")
@Api(tags = "Producto")
public class ProductoResource {

	private final ProductoService productoService;
	
	public ProductoResource (ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Productos", notes = "Servicio para listar todos los productos")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Productos encontrados"),
			@ApiResponse(code = 404, message = "Productos no encontrados") })
	public ResponseEntity<List<Producto>> list(){
		try {
			return ResponseEntity.ok(productoService.list());
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Producto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{produCodigo}")
	@ApiOperation(value = "Obtener un Producto", notes = "Servicio para obtener la información de un producto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Producto encontrado"),
			@ApiResponse(code = 204, message = "Producto no encontrado"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Producto> getProducto(@PathVariable("produCodigo") Integer produCodigo) {
		try {
			return new ResponseEntity<>(this.productoService.findByCodigo(produCodigo), HttpStatus.OK);
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Producto", notes = "Servicio para crear un nuevo producto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Producto creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Producto> createProducto(@RequestBody ProductoVO productoVO) {
		
		try {
		
			if (productoVO!=null) {
				Producto producto = Utilidades.productoVOtoModel(productoVO);
				return new ResponseEntity<>(this.productoService.create(producto), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			}
		}  catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/{produCodigo}")
	@ApiOperation(value = "Actualizar Producto", notes = "Servicio para actualizar un producto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Producto actualizado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Producto> updateProducto(@PathVariable("produCodigo") Integer produCodigo,
			@RequestBody ProductoVO productoVO) {
		
		try {
			Producto producto= this.productoService.findByCodigo(produCodigo);
	
			if (producto == null) {
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			} else {
				producto.setProdNombre(productoVO.getProdNombre());
				producto.setProdCategoria(productoVO.getProdCategoria());
				producto.setProdPrecio(productoVO.getProdPrecio());
			}
			return new ResponseEntity<>(this.productoService.update(producto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
