package aerolineas.servicio;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.exception.AerolineaNotFoundException;
import aerolineas.exception.AvionNotFoundException;
import aerolineas.exception.VueloNotFoundException;
import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.Avion;
import aerolineas.modelo.Vuelo;
import aerolineas.modelo.dao.VueloDAO;
import aerolineas.modelo.dto.InfoSalida;
import aerolineas.modelo.dto.VueloDTO;
import aerolineas.repositorio.RepositorioAerolinea;
import aerolineas.repositorio.RepositorioAvion;
import aerolineas.repositorio.RepositorioVuelo;

@Service
public class ServicioVuelos implements IServicioVuelos {

	@Autowired
	private RepositorioAerolinea repositorioAerolinea;

	@Autowired
	private RepositorioVuelo repositorioVuelo;

	@Autowired
	private RepositorioAvion repositorioAvion;

	@Override
	public Set<VueloDTO> getVuelosPendientes() {
		Set<VueloDTO> vuelos = new HashSet<>();
		repositorioVuelo.findVuelosPendientes().stream().forEach(v -> vuelos.add(v.createDTOfromVuelo()));
		return vuelos;
	}

	@Override
	public Set<VueloDTO> getSalidas() {
		Set<VueloDTO> vuelos = new HashSet<>();
		repositorioVuelo.findVuelosSalidas().stream().forEach(v -> vuelos.add(v.createDTOfromVuelo()));
		return vuelos;
	}

	@Override
	public VueloDTO getVuelo(Long id) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));

		return vuelo.createDTOfromVuelo();
	}

	@Override
	public VueloDTO createVueloPendiente(VueloDAO vueloDAO) {
		Vuelo vuelo = new Vuelo();
		vuelo.setDescripcion(vueloDAO.getDescripcion());
		Date date = new Date();
		vuelo.setPendiente(date);
		vuelo.setSalida(null);
		Avion avion = repositorioAvion.findById(vueloDAO.getAvionID())
				.orElseThrow(() -> new AvionNotFoundException(vueloDAO.getAvionID()));
		Aerolinea aerolinea = repositorioAerolinea.findById(vueloDAO.getAerolineaID())
				.orElseThrow(() -> new AerolineaNotFoundException(vueloDAO.getAerolineaID()));
		vuelo.setAvion(avion);
		vuelo.setAerolinea(aerolinea);

		aerolinea.addVuelo(vuelo);
		avion.addVuelo(vuelo);
		repositorioAerolinea.save(aerolinea);
		repositorioAvion.save(avion);
		repositorioVuelo.save(vuelo);

		return vuelo.createDTOfromVuelo();
	}

	@Override
	public VueloDTO modifyVuelo(Long id, VueloDAO vueloDAO) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
		Avion avion = repositorioAvion.findById(vueloDAO.getAvionID())
				.orElseThrow(() -> new AvionNotFoundException(id));
		Aerolinea aerolinea = repositorioAerolinea.findById(vueloDAO.getAerolineaID())
				.orElseThrow(() -> new AerolineaNotFoundException(id));
		vuelo.setAerolinea(aerolinea);
		vuelo.setAvion(avion);
		vuelo.setDescripcion(vueloDAO.getDescripcion());

		aerolinea.addVuelo(vuelo);
		avion.addVuelo(vuelo);

		repositorioAerolinea.save(aerolinea);
		repositorioAvion.save(avion);

		repositorioVuelo.save(vuelo);

		return vuelo.createDTOfromVuelo();
	}

	@Override
	public void deleteVuelo(Long id, String nombreAerolinea) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
		Aerolinea aerolinea = repositorioAerolinea.findByName(nombreAerolinea);
		if (aerolinea == null)
			throw new AerolineaNotFoundException();
		aerolinea.removeVuelo(vuelo);

		repositorioAerolinea.save(aerolinea);
	}

	@Override
	public InfoSalida haSalidoVuelo(Long id) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
		InfoSalida respuesta = new InfoSalida();

		Date date = new Date();
		if (null == vuelo.getSalida()) {
			respuesta.setHaSalido(false);
		} else if (vuelo.getSalida().after(date)) {
			respuesta.setHaSalido(false);
		} else {
			respuesta.setHaSalido(true);
		}
		respuesta.setHoraSalida(vuelo.getSalida());
		return respuesta;
	}

	@Override
	public VueloDTO despegarVuelo(Long id) {
		Vuelo vuelo = repositorioVuelo.findById(id).orElseThrow(() -> new VueloNotFoundException(id));
		if (vuelo.getPendiente() != null) {
			Date date = new Date();
			vuelo.setSalida(date);
			repositorioVuelo.save(vuelo);
		}

		return vuelo.createDTOfromVuelo();
	}

	@Override
	public Set<VueloDTO> findAll() {
		Set<VueloDTO> vuelos = new HashSet<>();
		repositorioVuelo.findAll().stream().forEach(v -> vuelos.add(v.createDTOfromVuelo()));
		return vuelos;
	}

}
