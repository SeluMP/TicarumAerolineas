package aerolineas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("aerolineas.modelo")
public class TicarumAerolineasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicarumAerolineasApiApplication.class, args);
	}

}
