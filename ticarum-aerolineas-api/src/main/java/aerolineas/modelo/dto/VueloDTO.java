package aerolineas.modelo.dto;

import java.util.Date;

import aerolineas.modelo.Vuelo;
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

	public VueloDTO createDTOfromVuelo(Vuelo vuelo) {
		VueloDTO vueloDTO = new VueloDTO();
		vueloDTO.setId(vuelo.getId());
		vueloDTO.setDescripcion(vuelo.getDescripcion());
		vueloDTO.setFechaPendienteDeSalida(vuelo.getPendiente());
		vueloDTO.setFechaSalida(vuelo.getSalida());
		vueloDTO.setAvionId(vuelo.getAvion().getId());
		vueloDTO.setAerolineaId(vuelo.getAerolinea().getId());

		return vueloDTO;
	}
}
