package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.Actividad;
import Path.LearningPath;
import Path.Progreso;
import Path.RecursoEducativo;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

class LearningPathTest {
	
	private LearningPath path;
	
	@BeforeEach
	void setUp() throws Exception {
	  	SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLimiteDate = fecha.parse("2003-12-30");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = sdf.parse("2003-12-30");
        Date fechaFin = sdf.parse("1970-01-01");
        ArrayList<Actividad> actividadesCompletadas = new ArrayList<>();
        Progreso p1 = new Progreso(0.4, actividadesCompletadas, fechaFin, 0.3, fechaInicio, 0.2);
        List<Actividad> actividades = new ArrayList<>();
        List<Rating> ratings = new ArrayList<>();
        Rating rating1 = new Rating("Jesus", "Estudiante", fechaLimiteDate, 5.0);
        ratings.add(rating1);
        
        //Actividad
        String descripcion = "Introduccion a eclipse";
        String objetivo = "Familiarizar al estudiante con el programa";
        String nivel = "Basico";
        int tiempoEstimado = 5;
        boolean obligatorio = true;
        boolean resultado = false;
        double tiempoDedicado = 0.0; 
        List<Rating> ratings2 = new ArrayList<>();
        List<Resena> resenas = new ArrayList<>(); 
        String estado = "sin empezar";
        List<Actividad> actividadesPrevias = new ArrayList<>();
        String material = "Inicio en Eclipse";
        String tipoMaterial = "PDF";
        
 
        RecursoEducativo RecursoEducativo1 = new RecursoEducativo(
            descripcion,
            objetivo,
            nivel,
            obligatorio,
            "Recurso Educativo",
            fechaLimiteDate,
            resultado,
            tiempoDedicado,
            ratings2,
            resenas,
            estado,
            actividadesPrevias, 
            tipoMaterial,
            material
        );
        actividades.add(RecursoEducativo1);
        
        
		
		path = new LearningPath ("Dpoo",20,"Intro al DPOO", "Basico","1.1",fechaLimiteDate,p1,actividades,fechaLimiteDate,
				ratings,0.0);
	}

	@Test
	void testGetTitulo() {
		assertEquals("Dpoo",path.getTitulo(),"El titulo no coincide");
	}
	@Test
	void testSetTitulo() {
		path.setTitulo("Dpoo2");
		assertEquals("Dpoo2",path.getTitulo(),"El titulo no se cambio correctamente");
		}
		
	@Test
	void testGetDuracion() {
			assertEquals(20,path.getDuracionEnMinutos(),"La duracion no coincide");
		}
	@Test
	void testSetDuracion() {
		path.setDuracionEnMinutos(30);
		assertEquals(30,path.getDuracionEnMinutos(),"La duracion no se cambio correctamente");
	}
	@Test
	void testGetDescripcion() {
			assertEquals("Intro al DPOO",path.getDescripcion(),"La descripcion no coincide");
		}
	@Test
	void testSetDescripcion() {
		path.setDescripcion("Intro al DPOO2");
		assertEquals("Intro al DPOO2",path.getDescripcion(),"La descripcion no se cambio correctamente");
	}
	
	@Test
	void testGetDifucultad() {
			assertEquals("Basico",path.getNivelDeDificultad(),"La dificiltad no coincide");
		}
	@Test
	void testSetDificultad() {
		path.setNivelDeDificultad("Medio");
		assertEquals("Medio",path.getNivelDeDificultad(),"La dificultad  no se cambio correctamente");
	}
	
	@Test
	void testGetVersion() {
			assertEquals("1.1",path.getVersion(),"La Version no coincide");
		}
	@Test
	void testSetVersion() {
		path.setNivelDeDificultad("1.2");
		assertEquals("1.2",path.getVersion(),"La dificultad  no se cambio correctamente");
	}
	
	@Test
	void testGetFechaModificacion() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaModi = sdf.parse("2003-12-30");
			assertEquals(fechaModi,path.getUltimaFechaDeModificacion(),"La fecha no coincide");
		}
	@Test
	void testSetFechaModificacion() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaModi = sdf.parse("2003-11-30");
		path.setUltimaFechaDeModificacion(fechaModi);
		assertEquals(fechaModi,path.getUltimaFechaDeModificacion(),"La fecha  no se cambio correctamente");
	}
	
	@Test
	void testGetFechaCreacion() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaModi = sdf.parse("2003-12-30");
			assertEquals(fechaModi,path.getUltimaFechaDeModificacion(),"La fecha no coincide");
		}
	@Test
	void testSetFechaCreacion() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaModi = sdf.parse("2003-11-30");
		path.setFechaDeCreacion(fechaModi);
		assertEquals(fechaModi,path.getFechaDeCreacion(),"La fecha  no se cambio correctamente");
	}
	
	@Test
	void testGetProgreso() throws ParseException {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLimiteDate = fecha.parse("2003-12-30");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = sdf.parse("2003-12-30");
        Date fechaFin = sdf.parse("1970-01-01");
        ArrayList<Actividad> actividadesCompletadas = new ArrayList<>();
        Progreso p1 = new Progreso(0.4, actividadesCompletadas, fechaFin, 0.3, fechaInicio, 0.2);
		assertEquals(p1,path.getProgreso(),"El progreso no coincide");
		}
	@Test
	void testSetProgreso() throws ParseException {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLimiteDate = fecha.parse("2003-12-30");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = sdf.parse("2003-12-30");
        Date fechaFin = sdf.parse("1970-01-01");
        ArrayList<Actividad> actividadesCompletadas = new ArrayList<>();
        Progreso p1 = new Progreso(0.5, actividadesCompletadas, fechaFin, 0.3, fechaInicio, 0.2);
        Progreso p2 =path.getProgreso();
        p2.setPorcentajeAvance(0.5);
		path.setProgreso(p2);
		assertEquals(p1,path.getProgreso(),"El progreso no se cambio correctamente");
	}
	
	@Test
	void testGetActividades() throws ParseException {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLimiteDate = fecha.parse("2003-12-30");
        String descripcion = "Introduccion a eclipse";
        String objetivo = "Familiarizar al estudiante con el programa";
        String nivel = "Basico";
        int tiempoEstimado = 5;
        boolean obligatorio = true;
        boolean resultado = false;
        double tiempoDedicado = 0.0; 
        List<Rating> ratings = new ArrayList<>();
        List<Resena> resenas = new ArrayList<>(); 
        String estado = "sin empezar";
        List<Actividad> actividadesPrevias = new ArrayList<>();
        String material = "Inicio en Eclipse";
        String tipoMaterial = "PDF";
        Rating rating1 = new Rating("Jesus", "Estudiante", fechaLimiteDate, 5.0);
        
 
        RecursoEducativo RecursoEducativo1 = new RecursoEducativo(
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
        List<Actividad> prueba = new ArrayList<>();
        prueba.add(RecursoEducativo1);
		assertEquals(prueba,path.getActividades(),"Las actividades no coinciden");
		}
	
	@Test
	void testSetActividades() throws ParseException {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLimiteDate = fecha.parse("2003-12-30");
        String descripcion = "Introduccion a eclipse";
        String objetivo = "Familiarizar al estudiante con el programa";
        String nivel = "Basico";
        int tiempoEstimado = 5;
        boolean obligatorio = true;
        boolean resultado = false;
        double tiempoDedicado = 0.0; 
        List<Rating> ratings = new ArrayList<>();
        List<Resena> resenas = new ArrayList<>(); 
        String estado = "sin empezar";
        List<Actividad> actividadesPrevias = new ArrayList<>();
        String material = "Inicio en Eclipse";
        String tipoMaterial = "PDF";
        
 
        RecursoEducativo RecursoEducativo1 = new RecursoEducativo(
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
        
 
        RecursoEducativo RecursoEducativo2 = new RecursoEducativo(
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
        List<Actividad> prueba = new ArrayList<>();
        prueba.add(RecursoEducativo1);
        prueba.add(RecursoEducativo2);
        List<Actividad> cambio = path.getActividades();
        cambio.add(RecursoEducativo2);
        path.setActividades(cambio);
        
		assertEquals(prueba,path.getActividades(),"Las actividades no se actualizaron correctamente");
	}
	
	@Test
	void testGetRatings() throws ParseException  {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLimiteDate = fecha.parse("2003-12-30");
		Rating rating1 = new Rating("Jesus", "Estudiante", fechaLimiteDate, 5.0);
		List<Rating> prueba = new ArrayList<>();
		prueba.add(rating1);
		assertEquals(prueba,path.getRatings(),"El rating no coincide");
	}
	
	@Test
	void testSetRatings() throws ParseException {
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLimiteDate = fecha.parse("2003-12-30");
		Rating rating1 = new Rating("Jesus", "Estudiante", fechaLimiteDate, 5.0);
		Rating rating2 = new Rating("Pepe", "Estudiante", fechaLimiteDate, 4.0);
		List<Rating> prueba = new ArrayList<>();
		prueba.add(rating1);
		prueba.add(rating2);
		List<Rating> cambio = path.getRatings();
		cambio.add(rating2);
		path.setRatings(cambio);
		assertEquals(prueba,path.getRatings(),"Los rating no fueron  actualizados correctamente");
	}
	
	@Test
	void testGetRatingPromedio() throws ParseException  {
		assertEquals(0.0,path.getRatingPromedio(),"El rating promedio no coincide");
	}
	
	@Test
	void testSetRatingPromedio() throws ParseException {
		path.setRatingPromedio(5.0);
		assertEquals(5.0,path.getRatingPromedio(),"Los rating promedio no fue  actualizado correctamente");
	}
	
	
}
