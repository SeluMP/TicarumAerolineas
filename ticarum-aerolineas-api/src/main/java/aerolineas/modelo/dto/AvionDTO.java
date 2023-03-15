package aerolineas.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvionDTO {
	private Long aerolineaID;
	private Long avionID;
	private String modelo;
	private int capacidad;
}