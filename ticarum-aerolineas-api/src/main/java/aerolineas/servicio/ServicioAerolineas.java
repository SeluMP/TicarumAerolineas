package aerolineas.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.dto.AerolineaDTO;
import aerolineas.repositorio.RepositorioAerolinea;

@Service
public class ServicioAerolineas implements IServiceAirlines {
	
	@Autowired
	private RepositorioAerolinea repositorioAerolinea;

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
		return Optional.ofNullable(repositorioAerolinea.findByName(name));
	}

	

}
