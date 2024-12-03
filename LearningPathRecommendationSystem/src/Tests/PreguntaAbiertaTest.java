package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.PreguntaAbierta;
import Retroalimentacion.Rating;

class PreguntaAbiertaTest {
	
	private PreguntaAbierta pregunta1;
	
	@BeforeEach
	void setUp() throws Exception {
		pregunta1 = new PreguntaAbierta("¿Como hacer una infertaz grafica?",300);
	}

	@Test
	void testGetExtensionMaxima() {
		assertEquals(300,pregunta1.getExtensionMaxima(),"La extension maxima no es correcta");
	}
	
	@Test
	void testSetExtensionMaxima() {
		pregunta1.setExtensionMaxima(400);
		assertEquals(400,pregunta1.getExtensionMaxima(),"La extension maxima no se asigno correctamente");
	}
	
	//Test de pregunta 
	@Test
	void testGetEnunciado() {
		assertEquals("¿Como hacer una infertaz grafica?",pregunta1.getEnunciado(),"El enunciado no coincide");
	}
	
	@Test
	void testSetEnunciado() {
		pregunta1.setEnunciado("¿Que es un Jpanel?");
		assertEquals("¿Que es un Jpanel?",pregunta1.getEnunciado(),"El enunciado no se cambio correctamente");
	}
	


}


