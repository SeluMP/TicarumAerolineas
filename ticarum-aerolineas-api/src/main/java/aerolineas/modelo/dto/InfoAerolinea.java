package aerolineas.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoAerolinea {
	String nombre;
	Long id;
	int numAvionesFlota;
}
