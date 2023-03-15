package aerolineas.servicio;

import java.util.Optional;

import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.dto.AerolineaDTO;
import aerolineas.modelo.dto.Info;

public interface IServiceAirlines {
	
	Info getInfoAerolinea(String nombre);
	
	Aerolinea crear(AerolineaDTO aerolineaDTO);
	
	Optional<Aerolinea> findAirlineById(Long id);
	
	Optional<Aerolinea> findAirlineByName(String name);
	
}
