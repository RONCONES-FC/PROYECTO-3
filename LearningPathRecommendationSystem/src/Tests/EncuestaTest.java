package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.Actividad;
import Path.Encuesta;
import Path.PreguntaAbierta;
import Path.RecursoEducativo;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

class EncuestaTest {

    private Encuesta encuesta1; 

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
        List<PreguntaAbierta> preguntas = new ArrayList<>();
        
 
        encuesta1 = new Encuesta(
            descripcion,
            objetivo,
            nivel,
            tiempoEstimado,
            obligatorio,
            tiempoEstimado, 
            "Encuesta",
            fechaLimiteDate,
            resultado,
            tiempoDedicado,
            ratings,
            resenas,
            estado,
            actividadesPrevias, 
            preguntas
        );

        
        preguntas.add(new PreguntaAbierta("¿Cuál es su opinión sobre el learning path?", 200));
        encuesta1.setPreguntas(preguntas);
    }

    @Test
    void testGetPreguntas() {
        PreguntaAbierta pregunta1 = new PreguntaAbierta("¿Cuál es su opinión sobre el learning path?", 200);
        ArrayList<PreguntaAbierta> prueba = new ArrayList<>();
        prueba.add(pregunta1);

        assertEquals(encuesta1.getPreguntas(), prueba, "Las preguntas de la encuesta no coinciden");
    }

    @Test
    void testSetPreguntas() {
        PreguntaAbierta pregunta1 = new PreguntaAbierta("¿Cuál es su opinión sobre el learning path?", 200);
        PreguntaAbierta pregunta2 = new PreguntaAbierta("¿Qué mejorarías del learning path?", 100);

        ArrayList<PreguntaAbierta> prueba = new ArrayList<>();
        prueba.add(pregunta1);
        prueba.add(pregunta2);

        List<PreguntaAbierta> preguntas = encuesta1.getPreguntas();
        preguntas.add(pregunta2);
        encuesta1.setPreguntas(preguntas);

        
        assertEquals(encuesta1.getPreguntas(), prueba, "Las preguntas de la encuesta no coinciden");
    }

}
