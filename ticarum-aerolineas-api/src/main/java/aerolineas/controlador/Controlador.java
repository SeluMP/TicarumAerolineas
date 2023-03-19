package aerolineas.controlador;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aerolineas.exception.AerolineaNotFoundException;
import aerolineas.exception.AvionNotFoundException;
import aerolineas.exception.VueloNotFoundException;
import aerolineas.modelo.dao.AvionDAO;
import aerolineas.modelo.dao.VueloDAO;
import aerolineas.modelo.dto.AerolineaDTO;
import aerolineas.modelo.dto.AvionDTO;
import aerolineas.modelo.dto.InfoSalida;
import aerolineas.modelo.dto.Respuesta;
import aerolineas.modelo.dto.VueloDTO;
import aerolineas.servicio.ServicioAerolineas;
import aerolineas.servicio.ServicioAviones;
import aerolineas.servicio.ServicioVuelos;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Controlador {

	@Autowired
	private ServicioAerolineas servicioAerolineas;

	@Autowired
	private ServicioVuelos servicioVuelos;

	@Autowired
	private ServicioAviones servicioAviones;

	@GetMapping(value = "/{aerolinea}/services/info", produces = "application/json")
	public ResponseEntity<Object> getInfoAerolinea(@PathVariable String aerolinea) {

		AerolineaDTO aerolineaDTO = new AerolineaDTO();
		try {
			aerolineaDTO = servicioAerolineas.getInfoAerolinea(aerolinea);

		} catch (AerolineaNotFoundException e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Aerolinea: " + aerolinea + " no encontrada."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(aerolineaDTO, HttpStatus.OK);
	}

	@PutMapping(value = "/{aerolinea}/services/avion", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createAvion(@PathVariable String aerolinea, @RequestBody AvionDAO avionDAO) {

		AvionDTO avionDTO = new AvionDTO();

		try {
			avionDTO = servicioAviones.create(avionDAO);

		} catch (AerolineaNotFoundException e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Aerolinea: " + aerolinea + " no encontrada."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(avionDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/{aerolinea}/services/vuelo", produces = "application/json")
	public ResponseEntity<Object> getVuelosPendientes(@PathVariable String aerolinea) {

		Set<VueloDTO> vuelos = servicioVuelos.getVuelosPendientes();

		return new ResponseEntity<>(vuelos, HttpStatus.OK);
	}

	@PostMapping(value = "/{aerolinea}/services/vuelo", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addVueloPendientes(@PathVariable String aerolinea, @RequestBody VueloDAO vueloDAO) {

		VueloDTO vueloDTO = new VueloDTO();

		try {
			vueloDTO = servicioVuelos.createVueloPendiente(vueloDAO);

		} catch (Exception e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Entidad Avion o Aerolinea no encontrada/s."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(vueloDTO, HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/{aerolinea}/services/vuelo/{idVuelo}", produces = "application/json")
	public ResponseEntity<Object> getVuelo(@PathVariable String aerolinea, @PathVariable Long idVuelo) {

		VueloDTO vueloDTO = new VueloDTO();

		try {
			vueloDTO = servicioVuelos.getVuelo(idVuelo);

		} catch (VueloNotFoundException e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Vuelo con id: " + idVuelo + " no encontrada."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(vueloDTO, HttpStatus.OK);
	}

	@PutMapping(value = "/{aerolinea}/services/vuelo/{idVuelo}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> editVuelo(@PathVariable String aerolinea, @PathVariable Long idVuelo,
			@RequestBody VueloDAO vueloDAO) {

		VueloDTO vueloDTO = new VueloDTO();

		try {
			vueloDTO = servicioVuelos.modifyVuelo(idVuelo, vueloDAO);

		} catch (AvionNotFoundException e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Entidad Avion o Aerolinea no encontrada/s."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(vueloDTO, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{aerolinea}/services/vuelo/{idVuelo}", produces = "application/json")
	public ResponseEntity<Respuesta> deleteVuelo(@PathVariable String aerolinea, @PathVariable Long idVuelo) {

		try {
			servicioVuelos.deleteVuelo(idVuelo, aerolinea);
		} catch (Exception e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Entidad Avion o Aerolinea no encontrada/s."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(Respuesta.errorResonse(Respuesta.NO_CONTENT, ""), HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/{aerolinea}/services/salida", produces = "application/json")
	public ResponseEntity<Object> getVuelosSalida(@PathVariable String aerolinea) {

		Set<VueloDTO> vuelos = servicioVuelos.getSalidas();

		return new ResponseEntity<>(vuelos, HttpStatus.OK);
	}

	@GetMapping(value = "/{aerolinea}/services/salida/{idVuelo}", produces = "application/json")
	public ResponseEntity<Object> getHaSalidoVuelo(@PathVariable String aerolinea, @PathVariable Long idVuelo) {

		InfoSalida respuesta = new InfoSalida();

		try {
			respuesta = servicioVuelos.haSalidoVuelo(idVuelo);

		} catch (VueloNotFoundException e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Vuelo con id: " + idVuelo + " no encontrado."),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}

	@PutMapping(value = "/{aerolinea}/services/salida/{idVuelo}/despegue", produces = "application/json")
	public ResponseEntity<Object> modifyHaSalidoVuelo(@PathVariable String aerolinea, @PathVariable Long idVuelo) {

		VueloDTO vueloDTO = new VueloDTO();

		try {
			vueloDTO = servicioVuelos.despegarVuelo(idVuelo);

		} catch (VueloNotFoundException e) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.NOT_FOUND, "Vuelo con id: " + idVuelo + " no encontrado."),
					HttpStatus.NOT_FOUND);
		}

		if (vueloDTO.getFechaSalida() == null) {
			return new ResponseEntity<>(
					Respuesta.errorResonse(Respuesta.BAD_REQUEST,
							"El Vuelo con id: " + idVuelo
									+ " debe estar en la lista de pendientes para autorizar su salida."),
					HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(vueloDTO, HttpStatus.OK);
	}

}
