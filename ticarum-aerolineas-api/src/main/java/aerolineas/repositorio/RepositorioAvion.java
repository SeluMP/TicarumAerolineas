package aerolineas.repositorio;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Avion;

@Repository
public interface RepositorioAvion extends CrudRepository<Avion, Long> {
	Set<Avion> findAll();
}
