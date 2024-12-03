package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.Actividad;
import Path.PreguntaCerrada;
import Path.PreguntaVerdaderoFalso;
import Path.QuizPreguntaCerrada;
import Path.QuizVerdaderoFalso;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

class QuizVerdaderoFalsoTest {
	
	private QuizVerdaderoFalso quiz1;
	
	@BeforeEach
	void setUp() throws Exception {
		  
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        String descripcion = "Encuesta del learning path";
        String objetivo = "Conocer la opinión de los estudiantes sobre el learning path";
        String nivel = "Basico";
        int tiempoEstimado = 5;
        boolean obligatorio = true;
        Date fechaLimiteDate = fecha.parse("2024-11-19");
        boolean resultado = false;
        double tiempoDedicado = 0.0; 
        List<Rating> ratings = new ArrayList<>();
        List<Resena> resenas = new ArrayList<>(); 
        String estado = "sin empezar";
        List<Actividad> actividadesPrevias = new ArrayList<>();
        List<PreguntaVerdaderoFalso> preguntas = new ArrayList<>();
        int calificacionMinima = 1;
        

        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(
            "¿Cuál es la capital de Francia?", 
            true
        );
        preguntas.add(pregunta);
        
        quiz1 = new QuizVerdaderoFalso(
            descripcion,
            objetivo,
            nivel,
            tiempoEstimado,
            obligatorio,
            tiempoEstimado, 
            "Quiz verdadero o falso",
            fechaLimiteDate,
            resultado,
            tiempoDedicado,
            ratings,
            resenas,
            estado,
            actividadesPrevias, 
            calificacionMinima,
            false,
            0,
            preguntas);
            
	}

	@Test
	void testGetCalificacion() {
		assertEquals(quiz1.getCalificacionMinima(),1,"La calificacion minima no coincide");
	}
	
	@Test
	void testsetCalificacion() {
		quiz1.setCalificacionMinima(3);
		assertEquals(quiz1.getCalificacionMinima(),3,"La calificacion minima no asigno correctamente");
	}
	
	@Test
	void testGetSatisfactorio() {
		assertEquals(quiz1.isEsSatisfactorio(),false,"El resultado no es el correcto");
	}
	
	@Test
	void testsetSatisfactorio () {
		quiz1.setEsSatisfactorio();
		assertEquals(quiz1.isEsSatisfactorio(),true,"La resultado no se cambio correctamente");
	}
	
	@Test
	void testGetPuntos() {
		assertEquals(quiz1.getPuntos(),0,"Los puntos no coinciden");
	}
	
	@Test
	void testSetPuntos() {
		quiz1.setPuntos(1);
		assertEquals(quiz1.isEsSatisfactorio(),1,"Los puntos no fueron asignados correctamente");
	}

	@Test
	void testActualizarPuntos() {
	    // Respuesta correcta
	    List<Integer> respuestasCorrectas = Arrays.asList(1); 
	    quiz1.ActualizarPuntos(respuestasCorrectas);
	    assertEquals(5, quiz1.getPuntos(), "Los puntos no coinciden con el cálculo esperado.");
	    assertTrue(quiz1.isEsSatisfactorio(), "El quiz debería marcarse como satisfactorio.");

	    // Respuesta incorrecta
	    List<Integer> respuestasIncorrectas = Arrays.asList(0); 
	    quiz1.ActualizarPuntos(respuestasIncorrectas);
	    assertEquals(0, quiz1.getPuntos(), "Los puntos no deberían acumularse con respuestas incorrectas.");
	    assertFalse(quiz1.isEsSatisfactorio(), "El quiz no debería marcarse como satisfactorio.");

	    // Lista vacía
	    List<Integer> respuestasVacias = new ArrayList<>();
	    quiz1.ActualizarPuntos(respuestasVacias);
	    assertEquals(0, quiz1.getPuntos(), "Los puntos deberían ser 0 si no se proporcionan respuestas.");
	    assertFalse(quiz1.isEsSatisfactorio(), "El quiz no debería ser satisfactorio con respuestas vacías.");

	   //Más respuestas de las necesarias
	    List<Integer> respuestasExtra = Arrays.asList(1, 2); 
	    quiz1.ActualizarPuntos(respuestasExtra);
	    assertEquals(5, quiz1.getPuntos(), "Las respuestas extra no deberían afectar los puntos calculados.");
	    assertTrue(quiz1.isEsSatisfactorio(), "El quiz debería ser satisfactorio con las respuestas correctas.");
	}
}
