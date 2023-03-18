package aerolineas.modelo;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import aerolineas.modelo.dto.VueloDTO;
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
	
	public VueloDTO createDTOfromVuelo() {
		VueloDTO vueloDTO = new VueloDTO();
		vueloDTO.setId(this.getId());
		vueloDTO.setDescripcion(this.getDescripcion());
		vueloDTO.setFechaPendienteDeSalida(this.getPendiente());
		vueloDTO.setFechaSalida(this.getSalida());
		vueloDTO.setAvionId(this.getAvion().getId());
		vueloDTO.setAerolineaId(this.getAerolinea().getId());

		return vueloDTO;
	}
}
