package aerolineas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolineas.modelo.Avion;

@Repository
public interface RepositorioAvion extends JpaRepository<Avion, Long> {
	List<Avion> findAll();
}
