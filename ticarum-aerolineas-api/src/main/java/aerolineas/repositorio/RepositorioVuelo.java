package aerolineas.repositorio;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Vuelo;

@Repository
public interface RepositorioVuelo extends JpaRepository<Vuelo, Long> {
	List<Vuelo> findAll();
	@Query(
			  value = "SELECT * FROM Vuelos v WHERE v.pendiente is not null", 
			  nativeQuery = true)
	Set<Vuelo> findVuelosPendientes();
	
	@Query(
			  value = "SELECT * FROM Vuelos v WHERE v.salidas is not null", 
			  nativeQuery = true)
	Set<Vuelo> findVuelosSalidas();
}
