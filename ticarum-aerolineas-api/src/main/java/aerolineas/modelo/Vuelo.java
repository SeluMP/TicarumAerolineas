package aerolineas.modelo;

import java.util.Date;

import jakarta.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@ManyToOne
    @JoinColumn(name="fk_avion_id", nullable=false)
	private Avion avion;
	@ManyToOne
    @JoinColumn(name="fk_aerolinea_id", nullable=false)
	private Aerolinea aerolinea;
}
