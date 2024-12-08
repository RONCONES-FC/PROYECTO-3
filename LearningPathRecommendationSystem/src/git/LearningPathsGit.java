package git;

import Persistencia.PersistenciaLearningPathJson;
import Path.LearningPath;

import java.time.LocalDate;
import java.time.ZoneId;
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
                LocalDate fechaCreacion = lp.getFechaDeCreacion().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                data.put(fechaCreacion, data.getOrDefault(fechaCreacion, 0) + 1);
            }

        } catch (Exception e) {
            System.err.println("Error al cargar los datos reales: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }
}

