package aerolineas.servicio;

import java.util.Set;

import aerolineas.modelo.Avion;

public interface IServicePlanes {
	 Set<Avion> findAll();
}
