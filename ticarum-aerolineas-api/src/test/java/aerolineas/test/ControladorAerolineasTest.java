package aerolineas.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import aerolineas.controlador.Controlador;
import aerolineas.modelo.dao.VueloDAO;
import aerolineas.modelo.dto.AerolineaDTO;
import aerolineas.servicio.ServicioAerolineas;
import aerolineas.servicio.ServicioAviones;
import aerolineas.servicio.ServicioVuelos;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = Controlador.class)
@RunWith(SpringRunner.class)
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

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void getInfoAerolineaTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{aerolinea}/services/info", "birdarilnes");

		MvcResult result = null;

		try {
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Test aerolinea "birdarilnes"
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	@Test
	public void getVuelosPendientesTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{aerolinea}/services/vuelo", "birdarilnes");

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

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{aerolinea}/services/vuelo", "birdarilnes")
				.accept(MediaType.APPLICATION_JSON).content(exampleVuelo).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}

	@Test
	public void getVueloTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/{aerolinea}/services/vuelo/{idVuelo}", "birdarilnes", 1).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void editVueloTest() throws Exception {

		VueloDAO vueloDAO = new VueloDAO();
		vueloDAO.setAerolineaID(1l);
		vueloDAO.setAvionID(3l);
		vueloDAO.setDescripcion("Vuelo Murcia-San Diego");

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/{aerolinea}/services/vuelo/{idVuelo}", "birdarilnes", 1).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content((asJsonString(vueloDAO)));

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void deleteVueloTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/{aerolinea}/services/vuelo/{idVuelo}", "birdarilnes", 2).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	}

	@Test
	public void getVueloSalidaTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{aerolinea}/services/salida", "birdarilnes")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void getVueloHaSalidoVueloTest() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/{aerolinea}/services/salida/{idVuelo}", "birdarilnes", 4).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}
