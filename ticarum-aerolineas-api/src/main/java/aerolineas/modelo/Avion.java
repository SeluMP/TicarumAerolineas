package aerolineas.modelo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	@OneToMany(mappedBy="avion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Vuelo> vuelos;
	@ManyToOne
	@JoinColumn(name="fk_aerolinea_id", nullable=false)
	@JsonIgnore
	private Aerolinea aerolinea;
	
	public Avion(String modelo, int capacidad) {
		this.modelo = modelo;
		this.capacidad = capacidad;
	}
	
	public void addVuelo(Vuelo vuelo) {
		if(null == vuelos) {
			vuelos = new HashSet<>();
		}
		vuelos.add(vuelo);
		vuelo.setAvion(this);
	}
	
	public void removeVuelo(Vuelo vuelo) {
		vuelos.remove(vuelo);
		vuelo.setAvion(null);
	}
	
}
