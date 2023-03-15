package aerolineas.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VueloDTO {
	private Long avionId;
	private Long aerolineaID;
	private String descripcion;
}
