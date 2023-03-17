package aerolineas.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Vuelo;

@Repository
public interface RepositorioVuelo extends CrudRepository<Vuelo, Long> {
	@Query(
			  value = "SELECT * FROM VUELO", 
			  nativeQuery = true)
	Set<Vuelo> findAll();
	@Query(
			  value = "SELECT * FROM VUELO v WHERE v.PENDIENTE is not null and v.SALIDA is null", 
			  nativeQuery = true)
	Set<Vuelo> findVuelosPendientes();
	
	@Query(
			  value = "SELECT * FROM VUELO v WHERE v.SALIDA is not null", 
			  nativeQuery = true)
	Set<Vuelo> findVuelosSalidas();
}
