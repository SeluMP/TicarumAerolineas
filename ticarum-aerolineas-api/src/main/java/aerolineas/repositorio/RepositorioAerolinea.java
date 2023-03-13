package aerolineas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import aerolineas.modelo.Aerolinea;

public interface RepositorioAerolinea extends JpaRepository<Aerolinea, Long> {
	
}
