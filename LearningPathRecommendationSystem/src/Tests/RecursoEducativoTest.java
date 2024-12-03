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

class RecursoEducativoTest {
	private RecursoEducativo RecursoEducativo1;
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
	        String material = "Inicio en Eclipse";
	        String tipoMaterial = "PDF";
	        
	 
	        RecursoEducativo1 = new RecursoEducativo(
	            descripcion,
	            objetivo,
	            nivel,
	            obligatorio,
	            "Recurso Educativo",
	            fechaLimiteDate,
	            resultado,
	            tiempoDedicado,
	            ratings,
	            resenas,
	            estado,
	            actividadesPrevias, 
	            tipoMaterial,
	            material
	        );
	}

	
	@Test
	void testGetTipoMaterial() {
		String respuesta = "PDF";
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El tipo de material no coincide");
		
	}
	
	void testSetTipoMaterial() {
		String respuesta = "Video";
		RecursoEducativo1.setTipoMaterial("Video");
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El tipo de material no se asigno correctamente");
		
	}
	
	@Test
	void testGetMaterial() {
		String respuesta = "Inicio en Eclipse";
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El material no coincide");
		
	}
	
	void testSetMaterial() {
		String respuesta = "Instalacion Eclipse";
		RecursoEducativo1.setTipoMaterial("Instalacion Eclipse");
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El material no se asigno correctamente");
		
	}
	
	@Test
	void testMarcarCompleto() {
		RecursoEducativo1.marcarCompleto();
		assertEquals(RecursoEducativo1.getTipo(),"completo", "El material no coincide");
		
	}
	
//Test relacionados con actividad
	
	@Test
	void testGetDescripcion() {
		assertEquals("Introduccion a eclipse",RecursoEducativo1.getDescripcion(),"La descripcion no coincide");
	}
	@Test
	void testSetTitulo() {
		RecursoEducativo1.setDescripcion("Introduccion a eclipse2");
		assertEquals("Introduccion a eclipse2",RecursoEducativo1.getDescripcion(),"La descripcion  no se cambio correctamente");
		}
	@Test
	void testGetObjetivo() {
		assertEquals("Familiarizar al estudiante con el programa",RecursoEducativo1.getObjetivo(),"El objetivo no coincide");
	}
	@Test
	void testSetObjetivo() {
		RecursoEducativo1.setObjetivo("Familiarizar al estudiante con el programa2");
		assertEquals("Familiarizar al estudiante con el programa2",RecursoEducativo1.getObjetivo(),"La descripcion  no se cambio correctamente");
		}
	@Test
	void testGetNivel() {
		assertEquals("Basico",RecursoEducativo1.getNivel(),"El nivel no coincide");
	}
	@Test
	void testSetNivel() {
		RecursoEducativo1.setNivel("Medio");
		assertEquals("Medio",RecursoEducativo1.getNivel(),"El nivel  no se cambio correctamente");
		}
	@Test
	void testTiempoEstimado() {
		assertEquals(5,RecursoEducativo1.getTiempoEstimado(),"El tiempo no coincide");
	}
	@Test
	void testSetTiempoEstimado() {
		RecursoEducativo1.setTiempoEstimado(7);
		assertEquals(7,RecursoEducativo1.getTiempoEstimado(),"El timepo no se cambio correctamente");
		}
	@Test
	void testISObligatorio() {
		assertEquals(true,RecursoEducativo1.isObligatorio()," no coincide");
	}
	@Test
	void testSetObligatorio() {
		RecursoEducativo1.setObligatorio(false);
		assertEquals(false,RecursoEducativo1.isObligatorio(),"El estado no se cambio correctamente");
		}

	
	

}
