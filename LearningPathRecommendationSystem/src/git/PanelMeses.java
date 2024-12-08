package git;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelMeses extends JPanel {
	
    public PanelMeses() {
    	LineBorder borde = new LineBorder(Color.LIGHT_GRAY, 1); 
        setBorder(borde);
        
        setLayout(new GridLayout(1, 53, 2, 2));
        setBackground(Color.white);

        // Generar las etiquetas de los meses
        LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        int dayOfYear = 1;
        for (int i = 0; i < 53; i++) { 
            LocalDate currentDate = startDate.plusDays(dayOfYear - 1);
            String mes = currentDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault());
            if (currentDate.getDayOfMonth() <= 7) { 
                JLabel label = new JLabel(mes, SwingConstants.CENTER);
                add(label);
            } else {
                add(new JLabel("")); 
            }
            dayOfYear += 7; // Avanzar a la siguiente semana
        }
    }
}

