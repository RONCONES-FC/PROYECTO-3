package Interfaz;

import git.CalendarMap;
import git.LearningPathsGit;
import git.PanelDiaSemana;
import git.PanelMeses;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Map;

public class PanelVisualizarProgreso extends JFrame {

    public PanelVisualizarProgreso() {
        setTitle("Visualizar Progreso - Learning Paths");
        setSize(1800, 1400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear paneles decorativos
        PanelMeses monthLabels = new PanelMeses();
        add(monthLabels, BorderLayout.NORTH);

        PanelDiaSemana dayLabels = new PanelDiaSemana();
        add(dayLabels, BorderLayout.EAST);

        // Obtener datos de actividades
        LearningPathsGit learningPathsGit = new LearningPathsGit();
        Map<LocalDate, Integer> activityData = learningPathsGit.getDatos();

        // Crear y agregar el calendario principal
        CalendarMap panelCalendario = new CalendarMap(activityData);
        add(panelCalendario, BorderLayout.CENTER);

        setVisible(true);
    }
}
