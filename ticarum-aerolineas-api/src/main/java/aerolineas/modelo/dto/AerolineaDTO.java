package aerolineas.modelo.dto;

import aerolineas.modelo.Aerolinea;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AerolineaDTO {
	private Long id;
	private String nombre;
	private int numeroAviones;
	
	public AerolineaDTO createDTOfromAerolinea(Aerolinea aerolinea) {
		AerolineaDTO aerolineaDTO = new AerolineaDTO();
		aerolineaDTO.setId(aerolinea.getId());
		aerolineaDTO.setNombre(aerolinea.getNombre());
		aerolineaDTO.setNumeroAviones(aerolinea.getNumAviones());
		
		return aerolineaDTO;
	}

}
