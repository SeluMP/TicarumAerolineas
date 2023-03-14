package aerolineas.repositorio;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Aerolinea;

@Repository
public interface RepositorioAerolinea extends CrudRepository<Aerolinea, Long> {
	Set<Aerolinea> findAll();
	Aerolinea findByName(String name);
}
