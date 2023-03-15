package aerolineas.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Aviones")
public class Avion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String modelo;
	@Column(nullable = false)
	private int capacidad;
	@OneToMany(targetEntity = Vuelo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_avion_id", referencedColumnName = "id")
	private List<Vuelo> vuelos;
	@Column(name = "fk_aerolinea_id")
	private Long aerolineaID;
	
	public Avion(String modelo, int capacidad) {
		this.modelo = modelo;
		this.capacidad = capacidad;
	}
	
}
