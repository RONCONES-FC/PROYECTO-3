package git;

import Persistencia.PersistenciaLearningPathJson;
import Path.LearningPath;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LearningPathsGit {

    private Map<LocalDate, Integer> datos;

    public LearningPathsGit() {
        this.datos = cargarDatosReales();
    }

    public Map<LocalDate, Integer> getDatos() {
        return datos;
    }

    private Map<LocalDate, Integer> cargarDatosReales() {
        Map<LocalDate, Integer> data = new HashMap<>();
        PersistenciaLearningPathJson persistencia = new PersistenciaLearningPathJson();

        try {
            List<LearningPath> learningPaths = persistencia.cargarLearningPaths("Datos/learningPaths.json");

            for (LearningPath lp : learningPaths) {
                // Imprime la fecha antes de procesarla
                System.out.println("Fecha original (antes de procesar): " + lp.getFechaDeCreacion());

                if (lp.getFechaDeCreacion() != null) {
                    LocalDate fechaCreacion = lp.getFechaDeCreacion().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    System.out.println("Fecha procesada: " + fechaCreacion);

                    data.put(fechaCreacion, data.getOrDefault(fechaCreacion, 0) + 1);
                } else {
                    System.err.println("Fecha de creación nula para: " + lp.getNombreActividad());
                }
            }

        } catch (Exception e) {
            System.err.println("Error al cargar los datos reales: " + e.getMessage());
            e.printStackTrace();
        }

        // Imprime el mapa final para diagnóstico
        for (Map.Entry<LocalDate, Integer> entry : data.entrySet()) {
            System.out.println("Mapa final -> Fecha: " + entry.getKey() + ", Actividades: " + entry.getValue());
        }

        return data;
    }

}


