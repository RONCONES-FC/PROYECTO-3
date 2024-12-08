package git;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Map;

public class CalendarMap extends JPanel {

    private Map<LocalDate, Integer> actividadPorFecha;

    public CalendarMap(Map<LocalDate, Integer> actividadPorFecha) {
        this.actividadPorFecha = actividadPorFecha;
        setLayout(new GridLayout(7, 52)); // 7 días x 52 semanas

        LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), 1, 1);

        for (int i = 0; i < 7 * 52; i++) {
            LocalDate fecha = startDate.plusDays(i);
            int actividades = actividadPorFecha.getOrDefault(fecha, 0);

            JPanel celda = new JPanel();
            celda.setBackground(calcularColor(actividades));
            celda.setToolTipText("Fecha: " + fecha + " - Actividades: " + actividades);
            add(celda);
        }
    }

    private Color calcularColor(int intensidad) {
        if (intensidad == 0) {
            return Color.LIGHT_GRAY; // Sin actividad
        }
        int verde = Math.max(255 - (intensidad * 25), 0); // Ajustar intensidad de verde
        return new Color(0, verde, 0);
    }
}
