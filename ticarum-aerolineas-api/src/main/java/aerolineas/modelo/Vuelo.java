package aerolineas.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "pendiente")
	@CreationTimestamp
	private Date pendiente;
	@Column(name = "salida")
	private Date salida;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fk_avion_id")
	private Long avionId;
	@Column(name = "fk_aerolinea_id")
	private Long aerolineaID;
}
