package Persistencia;

import Path.LearningPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersistenciaLearningPathJson {

    private final SimpleDateFormat standardFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private final SimpleDateFormat alternativeFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

    public void guardarLearningPaths(String archivo, List<LearningPath> learningPaths) {
        JSONArray jsonArray = new JSONArray();

        for (LearningPath lp : learningPaths) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombreActividad", lp.getNombreActividad());
            jsonObject.put("duracionEnMinutos", lp.getDuracionEnMinutos());
            jsonObject.put("descripcion", lp.getDescripcion());
            jsonObject.put("nivelDeDificultad", lp.getNivelDeDificultad());
            jsonObject.put("version", lp.getVersion());
            jsonObject.put("ultimaFechaDeModificacion", lp.getUltimaFechaDeModificacion() != null ? standardFormat.format(lp.getUltimaFechaDeModificacion()) : null);
            jsonObject.put("fechaDeCreacion", lp.getFechaDeCreacion() != null ? standardFormat.format(lp.getFechaDeCreacion()) : null);
            jsonObject.put("ratingPromedio", lp.getRatingPromedio());
            jsonArray.add(jsonObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(jsonArray.toJSONString());
        } catch (IOException e) {
            System.out.println("Error al guardar Learning Paths: " + e.getMessage());
        }
    }

    public List<LearningPath> cargarLearningPaths(String archivo) {
        List<LearningPath> learningPaths = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                String nombreActividad = (String) jsonObject.get("nombreActividad");
                int duracionEnMinutos = ((Long) jsonObject.get("duracionEnMinutos")).intValue();
                String descripcion = (String) jsonObject.get("descripcion");
                String nivelDeDificultad = (String) jsonObject.get("nivelDeDificultad");
                String version = (String) jsonObject.get("version");
                String ultimaFechaDeModificacionStr = (String) jsonObject.get("ultimaFechaDeModificacion");
                String fechaDeCreacionStr = (String) jsonObject.get("fechaDeCreacion");
                double ratingPromedio = (Double) jsonObject.get("ratingPromedio");

                Date ultimaFechaDeModificacion = parseDate(ultimaFechaDeModificacionStr);
                Date fechaDeCreacion = parseDate(fechaDeCreacionStr);

                if (nombreActividad != null && descripcion != null && nivelDeDificultad != null && version != null) {
                    LearningPath path = new LearningPath(
                            nombreActividad,
                            duracionEnMinutos,
                            descripcion,
                            nivelDeDificultad,
                            version,
                            ultimaFechaDeModificacion,
                            new ArrayList<>(), // Actividades
                            fechaDeCreacion,
                            new ArrayList<>(), // Ratings
                            ratingPromedio
                    );
                    learningPaths.add(path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar Learning Paths: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo JSON: " + e.getMessage());
        }
        return learningPaths;
    }

    private Date parseDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty() || dateStr.equalsIgnoreCase("null")) {
            return null;
        }

        try {
            return standardFormat.parse(dateStr);
        } catch (ParseException e1) {
            try {
                return alternativeFormat.parse(dateStr);
            } catch (ParseException e2) {
                System.err.println("No se pudo parsear la fecha: " + dateStr);
                return null;
            }
        }
    }
}
