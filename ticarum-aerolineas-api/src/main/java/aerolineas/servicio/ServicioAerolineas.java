package aerolineas.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.exception.AerolineaNotFoundException;
import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.dao.AerolineaDAO;
import aerolineas.modelo.dto.AerolineaDTO;
import aerolineas.repositorio.RepositorioAerolinea;

@Service
public class ServicioAerolineas implements IServicioAerolineas {

	@Autowired
	private RepositorioAerolinea repositorioAerolinea;

	@Override
	public Aerolinea crear(AerolineaDAO aerolineaDTO) {
		Aerolinea aerolinea = new Aerolinea();
		aerolinea.setNombre(aerolineaDTO.getNombre());
		return repositorioAerolinea.save(aerolinea);
	}

	@Override
	public Optional<Aerolinea> findAirlineById(Long id) {
		return repositorioAerolinea.findById(id);
	}

	@Override
	public Optional<Aerolinea> findAirlineByName(String name) {
		return Optional.of(repositorioAerolinea.findByName(name));
	}

	@Override
	public AerolineaDTO getInfoAerolinea(String nombre) {
		Aerolinea aerolinea = repositorioAerolinea.findByName(nombre);
		if (aerolinea == null)
			throw new AerolineaNotFoundException("Aerolinea" + nombre + " no encontrada - información no disponible");

		return aerolinea.createDTOfromAerolinea();
	}

}
