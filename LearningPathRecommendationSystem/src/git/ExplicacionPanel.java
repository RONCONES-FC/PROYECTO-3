package git;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ExplicacionPanel extends JPanel {
	
	private Color gris = new Color(240, 240, 240);
	private Color verdeClaro = new Color(198, 228, 139);
	private Color verde = new  Color(123, 201, 111); 
	private Color verdeOscuro = new Color(35, 154, 59);  
	private Color VerdeOscuro2 = new  Color(25, 97, 39);    
	
	
	
	
	public ExplicacionPanel() {
		
		LineBorder borde = new LineBorder(Color.LIGHT_GRAY, 1);
		
		List <Color> colores = new ArrayList<>();
		colores.add(gris);
		colores.add(verdeClaro);
		colores.add(verde);
		colores.add(verdeOscuro);
		colores.add(VerdeOscuro2);
		
		
		
			
		  setLayout(new GridLayout(1, 5, 3, 3));
	       setBackground(Color.WHITE);
	      setBorder(borde);
	    for ( Color color: colores) {
	       JPanel colorPanel = new JPanel();
	        colorPanel.setBackground(color);
	        colorPanel.setPreferredSize(new Dimension(20, 20));
	        add(colorPanel, BorderLayout.EAST);
	        if (color == gris) {
	        	JLabel label = new JLabel("Pocas actividades");
	        	label.setFont(new Font("Arial", Font.PLAIN, 9));
	        	add(label, BorderLayout.WEST);
	        	add(colorPanel, BorderLayout.EAST);
	        } else if (color == VerdeOscuro2) {
	        	add(colorPanel, BorderLayout.EAST);
	        	JLabel label = new JLabel("Muchas actividades");
	        	label.setFont(new Font("Arial", Font.PLAIN, 9));
	        	add(label, BorderLayout.WEST);
	        } else { add(colorPanel, BorderLayout.EAST);}
	       

	
	       
	    }
	       
	        
	}
	

}
