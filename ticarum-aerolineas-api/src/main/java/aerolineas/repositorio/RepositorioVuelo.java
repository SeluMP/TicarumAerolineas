package aerolineas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import aerolineas.modelo.Vuelo;

public interface RepositorioVuelo extends JpaRepository<Vuelo, Long> {

}
