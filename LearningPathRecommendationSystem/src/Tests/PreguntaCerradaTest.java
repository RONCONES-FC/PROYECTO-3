package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.PreguntaAbierta;
import Path.PreguntaCerrada;

class PreguntaCerradaTest {
	
	private PreguntaCerrada pregunta1;
	
	@BeforeEach
	void setUp() throws Exception {
		List<String> opciones = new ArrayList<>();
		List<String> explicaciones = new ArrayList<>();
		opciones.add("Opcion A");
		opciones.add("Opcion B");
		opciones.add("Opcion C");
		opciones.add("Opcion D");
		explicaciones.add("Explicacion D");
		explicaciones.add("Explicacion C");
		explicaciones.add("Explicacion B");
		explicaciones.add("Explicacion A");
		
		pregunta1 = new PreguntaCerrada("¿Cual de las siguientes es verdadera?",opciones,2,explicaciones);
	}
	
	@Test
	void testGetOpciones() {
		List<String> respuesta = new ArrayList<>();
		respuesta.add("Opcion A");
		respuesta.add("Opcion B");
		respuesta.add("Opcion C");
		respuesta.add("Opcion D");
		assertEquals(respuesta,pregunta1.getOpciones(),"Las opciones no coinciden");
	}
	
	@Test
	void testSetOpciones() {
		List<String> respuesta = new ArrayList<>();
		respuesta.add("Opcion A");
		respuesta.add("Opcion B");
		respuesta.add("Opcion C");
		respuesta.add("Opcion E");
		List<String> cambio = pregunta1.getOpciones();
		cambio.remove(3);
		cambio.add("Opcion E");
		assertEquals(respuesta,pregunta1.getOpciones(),"Las opciones no se cambiaron correctamente");
	}
	
	@Test
	void testGetRespuesta() {
		assertEquals(2,pregunta1.getRespuesta(),"La respuesta no es correcta");
	}

	@Test
	void testSetRespuesta() {
		pregunta1.setRespuesta(1);
		assertEquals(1,pregunta1.getRespuesta(),"La respuesta no se cambio correctamente");
	}
	
	@Test
	void testGetExplicaciones() {
		List<String> respuesta = new ArrayList<>();
		respuesta.add("Explicacion D");
		respuesta.add("Explicacion C");
		respuesta.add("Explicacion B");
		respuesta.add("Explicacion A");
		
		assertEquals(respuesta,pregunta1.getExplicaciones(),"Las explicaciones no coinciden");
	}
	
	void testSetExplicaciones() {
		List<String> respuesta = new ArrayList<>();
		respuesta.add("Explicacion A");
		respuesta.add("Explicacion B");
		respuesta.add("Explicacion C");
		respuesta.add("Explicacion E");
		List<String> cambio = pregunta1.getExplicaciones();
		cambio.remove(3);
		cambio.add("Explicacion E");
		assertEquals(respuesta,pregunta1.getExplicaciones(),"Las explicaciones nos e cambiaron correctamente");
	}
	
	//Test de pregunta 
	@Test
	void testGetEnunciado() {
		assertEquals("¿Cual de las siguientes es verdadera?",pregunta1.getEnunciado(),"El enunciado no coincide");
	}
	
	@Test
	void testSetEnunciado() {
		pregunta1.setEnunciado("¿Que es un Jpanel?");
		assertEquals("¿Que es un Jpanel?",pregunta1.getEnunciado(),"El enunciado no se cambio correctamente");
	}
}
