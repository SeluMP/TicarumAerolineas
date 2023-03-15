package aerolineas.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import aerolineas.modelo.Avion;
import aerolineas.modelo.Vuelo;
import aerolineas.modelo.dto.AvionDTO;
import aerolineas.modelo.dto.VueloDTO;

public interface IServiceFlights {
	//@Query("SELECT v FROM ")
		Optional<Set<Vuelo>> getVuelosPendientes();
		
		Optional<Set<Vuelo>> getSalidas();
		
		Avion addAvionPendientes(AvionDTO avionDTO);
		
		Avion addAvionSalidas(AvionDTO avionDTO);
		
		Vuelo getVuelo(Long id);
		
		Vuelo modifyVuelo(Long id, VueloDTO vueloDTO);
		
		boolean deleteVuelo(Long id);
		
		Vuelo haSalidoVuelo(Long id);
		
		boolean despegarVuelo(Long id);
	 Set<Vuelo> findAll();
}
