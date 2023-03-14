package aerolineas.repositorio;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Vuelo;

@Repository
public interface RepositorioVuelo extends CrudRepository<Vuelo, Long> {
	Set<Vuelo> findAll();
}
