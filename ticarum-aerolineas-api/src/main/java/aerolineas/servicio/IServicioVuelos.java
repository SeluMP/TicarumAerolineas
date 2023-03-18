package aerolineas.servicio;

import java.util.Optional;
import java.util.Set;

import aerolineas.modelo.Vuelo;
import aerolineas.modelo.dao.VueloDAO;
import aerolineas.modelo.dto.InfoSalida;

public interface IServicioVuelos {
	Set<Vuelo> getVuelosPendientes();

	Set<Vuelo> getSalidas();

	public Vuelo createVueloPendiente(VueloDAO vueloDTO);

	Optional<Vuelo> getVuelo(Long id);

	Vuelo modifyVuelo(Long id, VueloDAO vueloDTO);

	void deleteVuelo(Long id, String nombreAerolinea);

	InfoSalida haSalidoVuelo(Long id);

	Vuelo despegarVuelo(Long id);

	Set<Vuelo> findAll();
}
