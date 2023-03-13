package aerolineas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import aerolineas.modelo.Avion;

public interface RepositorioAvion extends JpaRepository<Avion, Long> {

}
