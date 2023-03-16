package aerolineas.controlador;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aerolineas.modelo.Vuelo;
import aerolineas.modelo.dto.Info;
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
	public ResponseEntity<Info> getInfoAerolinea(@PathVariable String aerolinea) {

		Info info = servicioAerolineas.getInfoAerolinea(aerolinea);

		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{aerolinea}/services/vuelo", produces = "application/json")
	public ResponseEntity<Set<Vuelo>> getVuelosPendientes(@PathVariable String aerolinea) {

		Set<Vuelo> vuelos = servicioVuelos.getVuelosPendientes();

		return new ResponseEntity<>(vuelos, HttpStatus.OK);
	}
	
	@PostMapping(value = "/{aerolinea}/services/vuelo", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Vuelo> addVueloPendientes(@PathVariable String aerolinea, @RequestBody VueloDTO vueloDTO) {

		Vuelo vuelo = servicioVuelos.createVueloPendiente(vueloDTO);

		return new ResponseEntity<>(vuelo, HttpStatus.NO_CONTENT);
	}

}
