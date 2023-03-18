package aerolineas.modelo;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vuelo_id")
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
	@JsonIgnore
	private Avion avion;
	@ManyToOne
    @JoinColumn(name="fk_aerolinea_id", nullable=false)
	@JsonIgnore
	private Aerolinea aerolinea;
}
