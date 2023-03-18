package aerolineas.modelo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvionDAO {
	private Long aerolineaID;
	private String modelo;
	private int capacidad;
}
