package aerolineas.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VueloDTO {
	private Long id;
	private String descripcion;
	private Date fechaPendienteDeSalida;
	private Date fechaSalida;
	private Long avionId;
	private Long aerolineaId;

}
