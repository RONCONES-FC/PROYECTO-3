package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.Actividad;
import Path.Tarea;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class TareaTest {
	private Tarea Tarea1;
	@BeforeEach
	void setUp() throws Exception {
		
		  	SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
	        String descripcion = "Practica en eclipse";
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
	        String material = "Inicio en Eclipse";
	        String tipoMaterial = "PDF";
	        
	 
	        Tarea1 = new Tarea(
	            descripcion,
	            objetivo,
	            nivel,
	            obligatorio,
	            "Tarea",
	            fechaLimiteDate,
	            resultado,
	            tiempoDedicado,
	            ratings,
	            resenas,
	            estado,
	            actividadesPrevias, 
	            false, 
	            "N/A"
	        );
	}
	
	@Test
	void testGetEnvio() {
		boolean respuesta = false;
		assertEquals(Tarea1.isEnvio(),respuesta, "El estado del envio no coincide");
		
	}
	
	void testSetMedioEnvio() {
		String respuesta = "Correo";
		Tarea1.setMedioEnvio("Correo");
		assertEquals(Tarea1.getMedioEnvio(),respuesta, "El medio de envio no se cambio correctamente");
		assertEquals(Tarea1.isEnvio(),true, "El medio de envio no se cambio correctamente");
	}


}
