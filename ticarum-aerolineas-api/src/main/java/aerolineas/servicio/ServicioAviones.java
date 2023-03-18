package aerolineas.servicio;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.exception.AerolineaNotFoundException;
import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.Avion;
import aerolineas.modelo.dao.AvionDAO;
import aerolineas.modelo.dto.AvionDTO;
import aerolineas.repositorio.RepositorioAerolinea;
import aerolineas.repositorio.RepositorioAvion;

@Service
public class ServicioAviones implements IServicioAviones {

	@Autowired
	private RepositorioAvion repositorioAvion;
	@Autowired
	private RepositorioAerolinea repositorioAerolinea;

	@Override
	public AvionDTO create(AvionDAO avionDAO) {
		Avion avion = new Avion();
		Aerolinea aerolinea = repositorioAerolinea.findById(avionDAO.getAerolineaID())
				.orElseThrow(() -> new AerolineaNotFoundException(avionDAO.getAerolineaID()));

		avion.setModelo(avionDAO.getModelo());
		avion.setCapacidad(avionDAO.getCapacidad());
		avion.setAerolinea(aerolinea);
		avion.setVuelos(null);

		aerolinea.addAvion(avion);
		repositorioAerolinea.save(aerolinea);
		repositorioAvion.save(avion);

		return avion.createDTOfromAvion();
	}

	@Override
	public Set<AvionDTO> findAll() {

		Set<AvionDTO> aviones = new HashSet<AvionDTO>();
		repositorioAvion.findAll().stream().forEach(a -> aviones.add(a.createDTOfromAvion()));
		return aviones;

	}

}
