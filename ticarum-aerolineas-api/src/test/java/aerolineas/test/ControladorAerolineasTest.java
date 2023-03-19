package aerolineas.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import aerolineas.controlador.Controlador;
import aerolineas.modelo.dao.VueloDAO;
import aerolineas.modelo.dto.AerolineaDTO;
import aerolineas.modelo.dto.Respuesta;
import aerolineas.modelo.dto.VueloDTO;
import aerolineas.servicio.ServicioAerolineas;
import aerolineas.servicio.ServicioAviones;
import aerolineas.servicio.ServicioVuelos;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = Controlador.class)
public class ControladorAerolineasTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServicioAerolineas servicioAerolineas;

	@MockBean
	private ServicioVuelos servicioVuelos;

	@MockBean
	private ServicioAviones servicioAviones;

	AerolineaDTO mockAerolineaDTO = new AerolineaDTO((long) 1, "birdarilnes", 5);

	@Test
	public void getInfoAerolineaTest() throws Exception {
		Mockito.when(servicioAerolineas.getInfoAerolinea(Mockito.anyString())).thenReturn(mockAerolineaDTO);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/birdarilnes/services/info");

		MvcResult result = null;

		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expected = "{\"id\":1,\"nombre\":\"birdarilnes\",\"numeroAviones\":5}";

		// Test aerolinea "birdarilnes"
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void getVuelosPendientesTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/birdarilnes/services/vuelo");

		MvcResult result = null;

		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Test aerolinea "birdarilnes"
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	@Test
	public void addVueloPendientesTest() throws Exception {

		String exampleVuelo = "{\r\n" + "    \"avionID\": 2,\r\n" + "    \"aerolineaID\": 1,\r\n"
				+ "    \"descripcion\": \"Vuelo Murcia-Bombay\"\r\n" + "}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/birdarilnes/services/vuelo")
				.accept(MediaType.APPLICATION_JSON).content(exampleVuelo).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}

	@Test
	public void getVueloTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/birdarilnes/services/vuelo/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void deleteVueloTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/birdarilnes/services/vuelo/2")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}
	
	@Test
	public void getVueloSalidaTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/birdarilnes/services/salida")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void getVueloHaSalidoVuelo() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/birdarilnes/services/salida/4")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	

}
