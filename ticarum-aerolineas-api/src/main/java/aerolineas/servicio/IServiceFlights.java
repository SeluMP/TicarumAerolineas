package aerolineas.servicio;

import java.util.Optional;
import java.util.Set;

import aerolineas.modelo.Vuelo;
import aerolineas.modelo.dto.Respuesta;
import aerolineas.modelo.dto.VueloDTO;

public interface IServiceFlights {
	Set<Vuelo> getVuelosPendientes();

	Set<Vuelo> getSalidas();

	public Vuelo createVueloPendiente(VueloDTO vueloDTO);

	Optional<Vuelo> getVuelo(Long id);

	Vuelo modifyVuelo(Long id, VueloDTO vueloDTO);

	void deleteVuelo(Long id);

	Respuesta haSalidoVuelo(Long id);

	Vuelo despegarVuelo(Long id);

	Set<Vuelo> findAll();
}
