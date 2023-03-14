package aerolineas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.Avion;
import aerolineas.modelo.Vuelo;
import aerolineas.repositorio.RepositorioAerolinea;
import aerolineas.repositorio.RepositorioAvion;
import aerolineas.repositorio.RepositorioVuelo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceAirlines implements IServiceAirlines {
	
	@Autowired
	private RepositorioAerolinea repositorioAerolinea;
	@Autowired
	private RepositorioAvion repositorioAvion;
	@Autowired
	private RepositorioVuelo repositorioVuelo;

	@Override
	public Aerolinea crear(Aerolinea aerolinea) {
		return null;
	}

	@Override
	public Optional<Aerolinea> findAirlineByName(String name) {
		return Optional.ofNullable(repositorioAerolinea.findByName(name));
	}

	@Override
	public Optional<Aerolinea> findAirlineById(Long id) {
		return repositorioAerolinea.findById(id);
	}

	@Override
	public Optional<List<Vuelo>> getVuelosPendientes() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<List<Vuelo>> getSalidas() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Avion añadirAvionPendientes(Avion avion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avion añadirAvionSalidas(Avion avion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vuelo getVuelo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarVuelo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vuelo haSalidoVuelo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean despegarVuelo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vuelo modificarVuelo(Long id, Vuelo vuelo) {
		// TODO Auto-generated method stub
		return null;
	}


}
