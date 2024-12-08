package git;

import java.awt.Color;
import java.time.LocalDate;

import javax.swing.JPanel;

public class DiaPanel extends JPanel {
	
	  public DiaPanel(LocalDate dia, int actividades) {
		  	setToolTipText("Fecha: " + dia + " - Actividades: " + actividades);
	        setBackground(ColorPorDia(actividades));
	          
	    }

	    private Color ColorPorDia(int actividades) {
	    	
	        if (actividades == 0)  return new Color(240, 240, 240); // Gris claro
	        if (actividades <= 2) return new Color(198, 228, 139); // Verde claro
	        if (actividades <= 5) return new Color(123, 201, 111); // Verde medio
	        if (actividades <= 8) return new Color(35, 154, 59);   // Verde oscuro
	        return new Color(25, 97, 39);                            // Verde muy oscuro

	    }
}
