package aerolineas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aerolineas.modelo.dto.Info;
import aerolineas.repositorio.RepositorioAerolinea;
import aerolineas.repositorio.RepositorioAvion;
import aerolineas.repositorio.RepositorioVuelo;
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

}
