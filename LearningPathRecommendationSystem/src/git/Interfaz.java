package git;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import git.LearningPathsGit;

public class Interfaz extends JFrame {
	
	private LearningPathsGit mundo = new LearningPathsGit(); 

	public Interfaz() {
        setTitle("Calendario de Actividades creadas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 1400);
        
        
        setLayout(new BorderLayout()); 
   	 PanelMeses monthLabels = new PanelMeses();
        add(monthLabels, BorderLayout.NORTH);
        
        
        PanelDiaSemana dayLabels = new PanelDiaSemana();
        add(dayLabels, BorderLayout.EAST);
        
        
   
        JPanel ajuste = new JPanel( new GridLayout(1,2));
        ajuste.setBackground(Color.WHITE);
        JPanel relleno = new  JPanel(new GridLayout(2,1));
        relleno.setBackground(Color.white);
        JPanel relleno2 = new JPanel();
        JPanel relleno3 = new JPanel();
        relleno3.setBackground(Color.white);
        relleno2.setBackground(Color.white);
        relleno.add(relleno3);
        ExplicacionPanel guiaColor = new ExplicacionPanel();
        relleno.add(guiaColor,BorderLayout.SOUTH);
        ajuste.add(relleno2);
        ajuste.add(relleno);
        add(ajuste, BorderLayout.SOUTH);
        

        
        Map<LocalDate, Integer> activityData = mundo.getDatos();

        CalendarMap PanelCalendario = new CalendarMap(activityData);
        add(PanelCalendario);

        add(PanelCalendario, BorderLayout.CENTER);
        setVisible(true);

    }
	


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interfaz::new);
    }
}
