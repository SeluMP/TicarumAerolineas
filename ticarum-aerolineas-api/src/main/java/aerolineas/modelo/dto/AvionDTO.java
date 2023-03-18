package aerolineas.modelo.dto;

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
	
}
