package aerolineas.servicio;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolineas.modelo.Avion;
import aerolineas.repositorio.RepositorioAvion;

@Service
public class ServicioAviones implements IServicePlanes {

	@Autowired
	private RepositorioAvion repositorioAvion;


	@Override
	public Set<Avion> findAll() {
		return repositorioAvion.findAll();
	}

}
