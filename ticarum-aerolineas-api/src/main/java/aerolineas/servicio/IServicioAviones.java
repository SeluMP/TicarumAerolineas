package aerolineas.servicio;

import java.util.Set;

import aerolineas.modelo.dao.AvionDAO;
import aerolineas.modelo.dto.AvionDTO;

public interface IServicioAviones {
	AvionDTO create(AvionDAO avionDAO);
	
	Set<AvionDTO> findAll();
}
