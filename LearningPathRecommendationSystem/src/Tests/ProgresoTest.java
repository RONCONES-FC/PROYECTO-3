package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.Actividad;
import Path.Progreso;
import Path.RecursoEducativo;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class ProgresoTest {

    private Progreso progreso;

    @BeforeEach
    void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = sdf.parse("2003-12-30");
        Date fechaFin = sdf.parse("1970-01-01");
        ArrayList<Actividad> actividadesCompletadas = new ArrayList<>();
        progreso = new Progreso(0.4, actividadesCompletadas, fechaFin, 0.3, fechaInicio, 0.2);
    }

    @Test
    void testGeFechaInicio() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date respuesta = sdf.parse("2003-12-30");
        assertEquals(progreso.getFechaInicio(), respuesta, "La fecha de inicio no coincide");
    }

    @Test
    void testSetFechaInicio() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nuevaFecha = sdf.parse("2003-12-29");
        progreso.setFechaInicio(nuevaFecha);
        assertEquals(progreso.getFechaInicio(), nuevaFecha, "La fecha de inicio no se cambió correctamente");
    }

    @Test
    void testGetFechaFin() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date respuesta = sdf.parse("1970-01-01"); 
        assertEquals(progreso.getFechaFin(), respuesta, "La fecha de fin no coincide");
    }

    @Test
    void testSetFechaFin() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nuevaFecha = sdf.parse("2023-12-29");
        progreso.setFechaFin(nuevaFecha);
        assertEquals(progreso.getFechaFin(), nuevaFecha, "La fecha de fin no se actualizó correctamente");
    }

    @Test
    void testGetTasaExito() {
        assertEquals(progreso.getTasaExito(), 0.3, "La tasa de éxito no es correcta");
    }

    @Test
    void testSetTasaExito() {
        progreso.setTasaExito(0.6);
        assertEquals(progreso.getTasaExito(), 0.6, "La tasa de éxito no se actualizó correctamente");
    }

    @Test
    void testGetTasaFracaso() {
        assertEquals(progreso.getTasaFracaso(), 0.2, "La tasa de fracaso no es correcta");
    }

    @Test
    void testSetTasaFracaso() {
        progreso.setTasaFracaso(0.3);
        assertEquals(progreso.getTasaFracaso(), 0.3, "La tasa de fracaso no se actualizó correctamente");
    }

    @Test
    void testGetPorcentajeAvance() {
        assertEquals(progreso.getPorcentajeAvance(), 0.4, "El porcentaje de avance no es correcto");
    }

    @Test
    void testSetPorcentajeAvance() {
        progreso.setPorcentajeAvance(0.6);
        assertEquals(progreso.getPorcentajeAvance(), 0.6, "El porcentaje de avance no se actualizó correctamente");
    }

    @Test
    void testGetActividadesCompletadas() {
        ArrayList<Actividad> respuesta = new ArrayList<>();
        assertEquals(progreso.getActividadesCompletadas(), respuesta, "Las actividades completadas no coinciden con el registro");
    }

    @Test
    void testSetActividadesCompletadas() throws Exception {
        ArrayList<Actividad> respuesta = new ArrayList<>();
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
        respuesta.add(RecursoEducativo1);
        progreso.setActividadesCompletadas(respuesta);
        assertEquals(progreso.getActividadesCompletadas(), respuesta, "Las actividades completadas no coinciden");
    }
    
}
