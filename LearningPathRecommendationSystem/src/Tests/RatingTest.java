package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Retroalimentacion.Rating;

class RatingTest {
	
	private Rating rating1;
	
	@BeforeEach
	void setUp() throws Exception {
		// Usamos SimpleDateFormat para manejar la fecha correctamente
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = sdf.parse("2003-12-30");
		rating1 = new Rating("Jesus", "Estudiante", fecha, 5.0);
	}
	
	@Test
	void testGetNumero() {
		assertEquals(rating1.getNumero(), 5.0, "Rating equivocado");
	}
	
	@Test
	void testSetNumero() {
		rating1.setNumero(4.0);
		assertEquals(rating1.getNumero(), 4.0, "Rating no cambiado correctamente");
	}
	
  //RetroaliemtnacionTest
    
    @Test
    void testSetUsuario() {
        assertEquals(rating1.getUsuario(), "Jesus", "El usuario no coincide");
    }

    @Test
    void testGetUsuario() {
        rating1.setUsuario("Julio");
        assertEquals(rating1.getUsuario(), "Julio", "El usuario no se cambio correctamente");
    }
}
