package aerolineas.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.exception.AerolineaNotFoundException;
import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.dto.AerolineaDTO;
import aerolineas.modelo.dto.Info;
import aerolineas.repositorio.RepositorioAerolinea;
import aerolineas.repositorio.RepositorioAvion;

@Service
public class ServicioAerolineas implements IServiceAirlines {

	@Autowired
	private RepositorioAerolinea repositorioAerolinea;
	
	@Autowired
	private RepositorioAvion repositorioAvion;

	@Override
	public Aerolinea crear(AerolineaDTO aerolineaDTO) {
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
	public Info getInfoAerolinea(String nombre) {
		Aerolinea aerolinea = repositorioAerolinea.findByName(nombre);
		if (aerolinea == null)
			throw new AerolineaNotFoundException("Aerolinea no encontrada - información no disponible");

		Info info = new Info();
		info.setId(aerolinea.getId());
		info.setNombre(aerolinea.getNombre());
		info.setNumAvionesFlota((int) repositorioAvion.findAvionesPorAerolinea(aerolinea.getId()));

		return info;
	}

}
