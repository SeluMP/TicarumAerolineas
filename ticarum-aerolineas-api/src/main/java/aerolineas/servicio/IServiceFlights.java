package aerolineas.servicio;

import java.util.Set;

import aerolineas.modelo.Vuelo;

public interface IServiceFlights {
	 Set<Vuelo> findAll();
}
