package aerolineas.modelo;

import java.util.List;

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
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aerolinea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@OneToMany(mappedBy = "aerolinea")
	private List<Avion> aviones;
	@OneToMany
	@JoinColumn(name = "VUELO_ID")
	private List<Vuelo> vuelosPendientes;
	@OneToMany
	@JoinColumn(name = "VUELO_ID")
	private List<Vuelo> salidas;

	public int getNumAviones() {
		return this.aviones.size();
	}

}
