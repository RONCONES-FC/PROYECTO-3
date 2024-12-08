package git;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelDiaSemana extends JPanel {

	   public PanelDiaSemana() {
	        setLayout(new GridLayout(7, 1, 2, 2)); 
	        setBackground(Color.LIGHT_GRAY);

	        String[] diasDeLaSemana = {"Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom"};
	        for (String dia : diasDeLaSemana) {
	            JLabel diaLabel = new JLabel(dia, SwingConstants.CENTER);
	            diaLabel.setOpaque(true);
	            
	            Color gris = new Color (240,240,240);
	            
	            diaLabel.setBackground(gris);
	            add(diaLabel);
	        }
	    }
}
