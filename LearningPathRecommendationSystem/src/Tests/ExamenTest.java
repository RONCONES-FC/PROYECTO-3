package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.Actividad;
import Path.Examen;
import Path.PreguntaAbierta;
import Path.RecursoEducativo;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

class ExamenTest {
	private Examen examen1;
	@BeforeEach
	void setUp() throws Exception {
		
	  	SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        String descripcion = "Introduccion a eclipse";
        String objetivo = "Familiarizar al estudiante con el programa";
        String nivel = "Basico";
        int tiempoEstimado = 5;
        boolean obligatorio = true;
        Date fechaLimiteDate = fecha.parse("2024-10-30");
        boolean resultado = false;
        double tiempoDedicado = 0.0; 
        List<Rating> ratings = new ArrayList<>();
        List<Resena> resenas = new ArrayList<>(); 
        String estado = "sin empezar";
        List<Actividad> actividadesPrevias = new ArrayList<>();
        List<PreguntaAbierta> preguntas = new ArrayList<>();
        PreguntaAbierta pregunta1 = new PreguntaAbierta("Que es eclipse", 200);
        preguntas.add(pregunta1);
        
        
 
        examen1 = new Examen(
            descripcion,
            objetivo,
            nivel,
            tiempoEstimado, obligatorio,
             "Examen",
            fechaLimiteDate,
            resultado,
            tiempoDedicado,
            ratings,
            resenas,
            estado,
            actividadesPrevias, 
            preguntas
            
        );
	}
//Set -get 
//enviarRespuesta 
	@Test
	void testgetPreguntas() {
		List<PreguntaAbierta> prueba = new ArrayList<>();
		PreguntaAbierta pregunta1 = new PreguntaAbierta("Que es eclipse", 200);
		prueba.add(pregunta1);
		assertEquals(examen1.getPreguntas(),prueba,"Las preguntas no coinciden");
		
	}
	@Test
	void testSetPreguntas() {
		List<PreguntaAbierta> prueba = new ArrayList<>();
		PreguntaAbierta pregunta1 = new PreguntaAbierta("Que es eclipse", 200);
		PreguntaAbierta pregunta2 = new PreguntaAbierta("Como se crea una clase", 500);
		prueba.add(pregunta1);
		prueba.add(pregunta2);
		List<PreguntaAbierta> nuevaLista = examen1.getPreguntas();
		nuevaLista.add(pregunta2);
		examen1.setPreguntas(nuevaLista);
		assertEquals(examen1.getPreguntas(),prueba,"Las preguntas no coinciden");
		
	}
	
	@Test
	void testEnviarRespuesta() {
		List<String> prueba = new ArrayList<>();
		examen1.enviarRespuestas(prueba);
		assertEquals(examen1.getEstado(),"calificacion pendiente","Las preguntas no coinciden");
	}
	
}
