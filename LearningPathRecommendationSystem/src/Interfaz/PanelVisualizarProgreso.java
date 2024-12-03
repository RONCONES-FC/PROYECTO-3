package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PanelVisualizarProgreso extends JFrame {
    public PanelVisualizarProgreso() {
        setTitle("Visualizar Progreso - Learning Paths");
        setSize(800, 400);
        setLayout(new GridLayout(7, 52));

        Map<LocalDate, Integer> actividadPorFecha = generarDatosSimulados();

        for (int i = 0; i < 7 * 52; i++) {
            JPanel celda = new JPanel();
            celda.setBackground(Color.LIGHT_GRAY);

            LocalDate fecha = calcularFechaInicioAño().plusDays(i);

            if (actividadPorFecha.containsKey(fecha)) {
                int intensidad = actividadPorFecha.get(fecha);
                celda.setBackground(calcularColor(intensidad));
            }

            add(celda);
        }

        setLocationRelativeTo(null);
    }

    private Map<LocalDate, Integer> generarDatosSimulados() {
        Map<LocalDate, Integer> datos = new HashMap<>();
        datos.put(LocalDate.now().minusDays(1), 3);
        datos.put(LocalDate.now().minusDays(2), 5);
        datos.put(LocalDate.now().minusDays(10), 1);
        return datos;
    }

    private LocalDate calcularFechaInicioAño() {
        return LocalDate.of(LocalDate.now().getYear(), 1, 1);
    }

    private Color calcularColor(int intensidad) {
        int verde = Math.max(255 - (intensidad * 50), 0);
        return new Color(0, verde, 0);
    }
}

