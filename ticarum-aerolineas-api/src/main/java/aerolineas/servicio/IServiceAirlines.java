package aerolineas.servicio;

import java.util.Optional;

import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.dto.AerolineaDTO;

public interface IServiceAirlines {
	Aerolinea crear(AerolineaDTO aerolineaDTO);
	
	Optional<Aerolinea> findAirlineById(Long id);
	
	Optional<Aerolinea> findAirlineByName(String name);
	
}
