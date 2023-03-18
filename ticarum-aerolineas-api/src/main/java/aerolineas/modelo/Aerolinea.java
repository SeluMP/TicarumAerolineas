package aerolineas.modelo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import aerolineas.modelo.dto.AerolineaDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Aerolinea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aerolinea_id")
	private Long id;
	@Column(nullable = false, unique = true)
	private String nombre;
	@OneToMany(mappedBy = "aerolinea", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Avion> aviones;
	@OneToMany(mappedBy = "aerolinea", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Vuelo> vuelos;

	public Aerolinea(String nombre) {
		this.nombre = nombre;
		this.aviones = null;
		this.vuelos = null;
	}
	
	public void addAvion(Avion avion) {
		if(null == aviones) {
			aviones = new HashSet<>();
		}
		aviones.add(avion);
		avion.setAerolinea(this);
			
	}
	
	public void removeAvion(Avion avion) {
		aviones.remove(avion);
		avion.setAerolinea(null);
	}
	
	public void addVuelo(Vuelo vuelo) {
		if(null == vuelos) {
			vuelos = new HashSet<>();
		}
		vuelos.add(vuelo);
		vuelo.setAerolinea(this);
	}
	
	public void removeVuelo(Vuelo vuelo) {
		vuelos.remove(vuelo);
		vuelo.setAerolinea(null);
	}

	public int getNumAviones() {
		return this.aviones.size();
	}
	
	public AerolineaDTO createDTOfromAerolinea() {
		AerolineaDTO aerolineaDTO = new AerolineaDTO();
		aerolineaDTO.setId(this.getId());
		aerolineaDTO.setNombre(this.getNombre());
		aerolineaDTO.setNumeroAviones(this.getNumAviones());
		
		return aerolineaDTO;
	}

}
