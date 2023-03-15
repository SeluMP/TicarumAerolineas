package aerolineas.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import aerolineas.modelo.Aerolinea;
import aerolineas.modelo.dto.AerolineaDTO;

@Service
public class ServiceAirlines implements IServiceAirlines {
	
	/*@Autowired
	private RepositorioAerolinea repositorioAerolinea;*/

	@Override
	public Aerolinea crear(AerolineaDTO aerolineaDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Aerolinea> findAirlineById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public Optional<Aerolinea> findAirlineByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	

}
