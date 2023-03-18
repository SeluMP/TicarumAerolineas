package aerolineas.modelo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VueloDAO {
	private Long avionID;
	private Long aerolineaID;
	private String descripcion;
}
