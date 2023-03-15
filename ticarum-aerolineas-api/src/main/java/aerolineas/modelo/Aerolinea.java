package aerolineas.modelo;

import java.util.List;

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
public class Aerolinea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nombre;
	@OneToMany(mappedBy="aerolinea")
	private List<Avion> aviones;
	@OneToMany(mappedBy="aerolinea")
	private List<Vuelo> vuelos;

	public Aerolinea(String nombre) {
		this.nombre = nombre;
		this.aviones = null;
		this.vuelos = null;
	}
	
	public int getNumAviones() {
		return this.aviones.size();
	}

}
