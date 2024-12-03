package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Retroalimentacion.Resena;

class ResenaTest {
    private Resena resena1;

    @BeforeEach
    void setUp() throws Exception {
        // Usamos SimpleDateFormat para manejar la fecha correctamente
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse("2003-12-30");
        resena1 = new Resena("pepe", "Estudiante", fecha, "Pesimo curso", "No lo repetiria");
    }

    @Test
    void testGetTitulo() {
        assertEquals(resena1.getTitulo(), "Pesimo curso", "Titulo equivocado");
    }

    @Test
    void testSetTitulo() {
        resena1.setTitulo("Gran curso");
        assertEquals(resena1.getTitulo(), "Gran curso", "Titulo equivocado");
    }

    @Test
    void testGetComentario() {
        assertEquals(resena1.getComentario(), "No lo repetiria", "Comentario equivocado");
    }

    @Test
    void testSetComentario() {
        resena1.setComentario("Lo repetiria");
        assertEquals(resena1.getUsuario(), "Lo repetiria", "Comentario equivocado");
    }
    
    //RetroaliemtnacionTest
    
    @Test
    void testSetUsuario() {
        assertEquals(resena1.getUsuario(), "pepe", "El usuario no coincide");
    }

    @Test
    void testGetUsuario() {
        resena1.setUsuario("Julio");
        assertEquals(resena1.getComentario(), "Julio", "El usuario no se cambio correctamente");
    }

    
}

