package aerolineas.modelo.dto;

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
	
}
