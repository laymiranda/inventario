package com.lay.inventario.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lay.inventario.modelo.Movimiento;
import com.lay.inventario.negocio.services.MovimientoService;
import com.lay.inventario.resources.util.Utilidades;
import com.lay.inventario.resources.vo.MovimientoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/Movimiento")
@Api(tags = "Movimiento")
public class MovimientoResource {

	private final MovimientoService movimientoService;

	public MovimientoResource(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}

	@PostMapping
	@ApiOperation(value = "Crear Movimiento", notes = "Servicio para crear un nuevo movimiento")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Movimiento creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Movimiento> createMovimiento(@RequestBody MovimientoVO movimientoVO) {
		try {
			Movimiento movimiento = new Movimiento();
			movimiento.setMoviFechaHora(movimientoVO.getMoviFechaHora());
			movimiento.setCliente(Utilidades.clienteVOtoModel(movimientoVO.getCliente()));
			movimiento.setMoviActivo(true);
			movimiento.setMoviTipo(movimientoVO.getMoviTipo());
			movimiento.setMovimientoDetalleSet(
					Utilidades.movimientoDetalleVOtoModel(movimiento, movimientoVO.getMovimientoDetalleSet()));

			return new ResponseEntity<>(this.movimientoService.save(movimiento), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Movimiento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	@ApiOperation(value = "Actualizar Movimiento", notes = "Servicio para actualizar un movimiento")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Movimiento actualizado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Movimiento> updateMovimiento(@RequestBody MovimientoVO movimientoVO) {

		try {
			Movimiento movimiento = this.movimientoService
					.findByConsecutivo(movimientoVO.getMoviConsecutivo().intValue());

			if (movimiento == null) {
				return new ResponseEntity<Movimiento>(HttpStatus.NOT_FOUND);
			} else {
				movimiento.setMoviFechaHora(movimientoVO.getMoviFechaHora());
				movimiento.setCliente(Utilidades.clienteVOtoModel(movimientoVO.getCliente()));
				movimiento.setMoviActivo(true);
				movimiento.setMoviTipo(movimientoVO.getMoviTipo());
				movimiento.setMovimientoDetalleSet(
						Utilidades.movimientoDetalleVOtoModel(movimiento, movimientoVO.getMovimientoDetalleSet()));
			}

			return new ResponseEntity<>(this.movimientoService.update(movimiento), HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Movimiento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@DeleteMapping("/{moviConsecutivo}")
	@ApiOperation(value = "Anular Movimiento", notes = "Servicio para anular un nuevo movimiento")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Movimiento anulado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity anularMovimiento(@PathVariable("moviConsecutivo") Integer moviConsecutivo) {

		try {
			this.movimientoService.anular(moviConsecutivo);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
