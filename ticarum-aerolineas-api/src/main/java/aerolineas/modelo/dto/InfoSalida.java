package aerolineas.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoSalida {
	public boolean haSalido;
	public Date horaSalida;
}
