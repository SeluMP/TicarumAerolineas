package aerolineas.servicio;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.exception.AerolineaNotFoundException;
import aerolineas.exception.AvionNotFoundException;
import aerolineas.exception.VueloNotFoundException;
import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.Avion;
import aerolineas.modelo.Vuelo;
import aerolineas.modelo.dto.Respuesta;
import aerolineas.modelo.dto.VueloDTO;
import aerolineas.repositorio.RepositorioAerolinea;
import aerolineas.repositorio.RepositorioAvion;
import aerolineas.repositorio.RepositorioVuelo;

@Service
public class ServicioVuelos implements IServiceFlights {
	
	@Autowired
	private RepositorioAerolinea repositorioAerolinea;
	
	@Autowired
	private RepositorioVuelo repositorioVuelo;
	
	@Autowired
	private RepositorioAvion repositorioAvion;
	
	@Override
	public Set<Vuelo> getVuelosPendientes() {
		return repositorioVuelo.findVuelosPendientes();
	}

	@Override
	public Set<Vuelo> getSalidas() {
		return repositorioVuelo.findVuelosSalidas();
	}

	@Override
	public Optional<Vuelo> getVuelo(Long id) {
		return repositorioVuelo.findById(id);
	}

	@Override
	public Vuelo modifyVuelo(Long id, VueloDTO vueloDTO) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
		Avion avion = repositorioAvion.findById(vueloDTO.getAvionId()).orElseThrow(() -> new AvionNotFoundException(id));
		Aerolinea aerolinea = repositorioAerolinea.findById(vueloDTO.getAerolineaID()).orElseThrow(() -> new AerolineaNotFoundException(id));
		vuelo.setAerolinea(aerolinea);
		vuelo.setAvion(avion);
		vuelo.setDescripcion(vueloDTO.getDescripcion());
		
		return repositorioVuelo.save(vuelo);
	}

	@Override
	public void deleteVuelo(Long id) {
		repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
        repositorioVuelo.deleteById(id);
	}

	@Override
	public Respuesta haSalidoVuelo(Long id) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
		Respuesta respuesta = new Respuesta();
		
		if(vuelo.getSalida().equals(null)) {
			respuesta.setHaSalido(true);
		} else {
			respuesta.setHaSalido(false);
		}
		respuesta.setHoraSalida(vuelo.getSalida());
		return respuesta;
	}

	@Override
	public Vuelo despegarVuelo(Long id) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
		Date date = new Date();
		vuelo.setSalida(date);
		vuelo.setPendiente(null);
		return repositorioVuelo.save(vuelo);
	}

	@Override
	public Set<Vuelo> findAll() {
		return repositorioVuelo.findAll();
	}


}
