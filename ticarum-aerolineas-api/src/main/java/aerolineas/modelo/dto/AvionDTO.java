package aerolineas.modelo.dto;

import aerolineas.modelo.Avion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvionDTO {
	private Long id;
	private String modelo;
	private int capacidad;
	private Long aerolineaId;
	
	public AvionDTO createDTOfromAvion(Avion avion) {
		AvionDTO avionDTO = new AvionDTO();
		avionDTO.setId(avion.getId());
		avionDTO.setModelo(avion.getModelo());
		avionDTO.setCapacidad(avion.getCapacidad());
		avionDTO.setAerolineaId(avion.getAerolinea().getId());
		
		return avionDTO;
	}

}
