package aerolineas.servicio;

import java.util.List;
import java.util.Optional;

import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.Vuelo;
import aerolineas.modelo.Avion;

public interface IServiceAirlines {
	Aerolinea crear(Aerolinea aerolinea);
	
	Optional<Aerolinea> findAirlineById(Long id);
	
	Optional<Aerolinea> findAirlineByName(String name);
	
	//@Query("SELECT v FROM ")
	Optional<List<Vuelo>> getVuelosPendientes();
	
	Optional<List<Vuelo>> getSalidas();
	
	Avion añadirAvionPendientes(Avion avion);
	
	Avion añadirAvionSalidas(Avion avion);
	
	Vuelo getVuelo(Long id);
	
	Vuelo modificarVuelo(Long id, Vuelo vuelo);
	
	boolean eliminarVuelo(Long id);
	
	Vuelo haSalidoVuelo(Long id);
	
	boolean despegarVuelo(Long id);

}
