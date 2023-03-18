package aerolineas.servicio;

import java.util.Set;

import aerolineas.modelo.dao.VueloDAO;
import aerolineas.modelo.dto.InfoSalida;
import aerolineas.modelo.dto.VueloDTO;

public interface IServicioVuelos {
	Set<VueloDTO> getVuelosPendientes();

	Set<VueloDTO> getSalidas();

	public VueloDTO createVueloPendiente(VueloDAO vueloDAO);

	VueloDTO getVuelo(Long id);

	VueloDTO modifyVuelo(Long id, VueloDAO vueloDAO);

	void deleteVuelo(Long id, String nombreAerolinea);

	InfoSalida haSalidoVuelo(Long id);

	VueloDTO despegarVuelo(Long id);

	Set<VueloDTO> findAll();
}
