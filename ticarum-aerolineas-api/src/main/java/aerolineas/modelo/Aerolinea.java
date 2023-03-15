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
@Table(name="Aerolineas")
public class Aerolinea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nombre;
	@OneToMany(targetEntity = Avion.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_aerolinea_id", referencedColumnName = "id")
	private List<Avion> aviones;
	@OneToMany(targetEntity = Vuelo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_aerolinea_id", referencedColumnName = "id")
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
