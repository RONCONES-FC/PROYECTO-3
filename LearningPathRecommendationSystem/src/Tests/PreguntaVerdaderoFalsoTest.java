package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.PreguntaVerdaderoFalso;

class PreguntaVerdaderoFalsoTest {
	
	private PreguntaVerdaderoFalso pregunta1;
	
	@BeforeEach
	void setUp() throws Exception {
		pregunta1 = new PreguntaVerdaderoFalso("Eclipse es bueno para la POO", true);
	}

	@Test
	void testGetRespuesta() {
		assertEquals(true, pregunta1.isRespuesta(), "La respuesta no es correcta");
	}
	
	@Test
	void testSetRespuesta() {
		pregunta1.setRespuesta(false);
		assertEquals(false, pregunta1.isRespuesta(), "La respuesta no es correcta");
	}
	
	//Test de pregunta 
	@Test
	void testGetEnunciado() {
		assertEquals("¿Eclipse es bueno para la POO",pregunta1.getEnunciado(),"El enunciado no coincide");
	}
	
	@Test
	void testSetEnunciado() {
		pregunta1.setEnunciado("Progrmar es muy demorado");
		assertEquals("Programar es muy demorado",pregunta1.getEnunciado(),"El enunciado no se cambio correctamente");
	}

}
