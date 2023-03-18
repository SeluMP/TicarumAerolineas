package aerolineas.servicio;

import java.util.Optional;

import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.dao.AerolineaDAO;
import aerolineas.modelo.dto.AerolineaDTO;

public interface IServicioAerolineas {
	Aerolinea crear(AerolineaDAO aerolineaDAO);

	AerolineaDTO getInfoAerolinea(String nombre);

	Optional<Aerolinea> findAirlineById(Long id);

	Optional<Aerolinea> findAirlineByName(String name);

}
