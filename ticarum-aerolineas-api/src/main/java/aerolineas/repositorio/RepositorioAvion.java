package aerolineas.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Avion;

@Repository
public interface RepositorioAvion extends CrudRepository<Avion, Long> {
	Set<Avion> findAll();
	
	@Query(
			  value = "SELECT COUNT(*) FROM AVION a WHERE a.FK_AEROLINEA_ID = ?1", 
			  nativeQuery = true)
	long findAvionesPorAerolinea(long aerolineaID);
}
