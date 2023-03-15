package aerolineas.modelo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "avion_id")
	private Long id;
	@Column(nullable = false)
	private String modelo;
	@Column(nullable = false)
	private int capacidad;
	@OneToMany(mappedBy="avion")
	private Set<Vuelo> vuelos;
	@Column(name = "fk_aerolinea_id")
	private Long aerolinea;
	
	public Avion(String modelo, int capacidad) {
		this.modelo = modelo;
		this.capacidad = capacidad;
	}
	
}
