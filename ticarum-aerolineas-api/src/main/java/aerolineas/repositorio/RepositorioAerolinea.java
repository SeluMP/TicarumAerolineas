package aerolineas.repositorio;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Aerolinea;

@Repository
public interface RepositorioAerolinea extends JpaRepository<Aerolinea, Long> {
	List<Aerolinea> findAll();
	@Query(
			  value = "SELECT * FROM Aerolineas a WHERE a.nombre = ?1", 
			  nativeQuery = true)
	Aerolinea findByName(String name);
}
