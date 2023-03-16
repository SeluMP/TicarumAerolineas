package aerolineas.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Aerolinea;

@Repository
public interface RepositorioAerolinea extends CrudRepository<Aerolinea, Long> {
	Set<Aerolinea> findAll();
	@Query(
			  value = "SELECT * FROM AEROLINEA a WHERE a.nombre = ?1", 
			  nativeQuery = true)
	Aerolinea findByName(String name);
	
}
