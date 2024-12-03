package Persistencia;

import Path.LearningPath;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersistenciaLearningPathJson {

    public void guardarLearningPaths(String archivo, List<LearningPath> learningPaths) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("[\n");
            for (int i = 0; i < learningPaths.size(); i++) {
                LearningPath lp = learningPaths.get(i);
                writer.write("    {\n");
                writer.write("        \"nombreActividad\": \"" + lp.getNombreActividad() + "\",\n");
                writer.write("        \"duracionEnMinutos\": " + lp.getDuracionEnMinutos() + ",\n");
                writer.write("        \"descripcion\": \"" + lp.getDescripcion() + "\",\n");
                writer.write("        \"nivelDeDificultad\": \"" + lp.getNivelDeDificultad() + "\",\n");
                writer.write("        \"version\": \"" + lp.getVersion() + "\",\n");
                writer.write("        \"ultimaFechaDeModificacion\": \"" + lp.getUltimaFechaDeModificacion() + "\",\n");
                writer.write("        \"fechaDeCreacion\": \"" + lp.getFechaDeCreacion() + "\",\n");
                writer.write("        \"ratingPromedio\": " + lp.getRatingPromedio() + "\n");
                writer.write("    }");
                if (i < learningPaths.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("Error al guardar Learning Paths: " + e.getMessage());
        }
    }

    public List<LearningPath> cargarLearningPaths(String archivo) {
        List<LearningPath> learningPaths = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line.trim());
            }

            // Procesar el JSON manualmente
            String json = jsonBuilder.toString().trim();
            if (json.startsWith("[") && json.endsWith("]")) {
                json = json.substring(1, json.length() - 1).trim(); // Eliminar corchetes externos
                String[] pathsJson = json.split("},\\s*\\{"); // Separar objetos JSON

                for (String pathJson : pathsJson) {
                    pathJson = pathJson.replace("{", "").replace("}", "").replace("\"", "").trim();
                    String[] campos = pathJson.split(",");

                    String nombreActividad = null;
                    int duracionEnMinutos = 0;
                    String descripcion = null;
                    String nivelDeDificultad = null;
                    String version = null;
                    Date ultimaFechaDeModificacion = null;
                    Date fechaDeCreacion = null;
                    double ratingPromedio = 0.0;

                    for (String campo : campos) {
                        String[] keyValue = campo.split(":");
                        if (keyValue.length == 2) {
                            String key = keyValue[0].trim();
                            String value = keyValue[1].trim();
                            switch (key) {
                                case "nombreActividad":
                                    nombreActividad = value;
                                    break;
                                case "duracionEnMinutos":
                                    duracionEnMinutos = Integer.parseInt(value);
                                    break;
                                case "descripcion":
                                    descripcion = value;
                                    break;
                                case "nivelDeDificultad":
                                    nivelDeDificultad = value;
                                    break;
                                case "version":
                                    version = value;
                                    break;
                                case "ultimaFechaDeModificacion":
                                    try {
                                        ultimaFechaDeModificacion = dateFormat.parse(value);
                                    } catch (ParseException e) {
                                        System.out.println("Error al parsear la fecha de modificación: " + value);
                                        ultimaFechaDeModificacion = new Date(); // Asignar fecha actual como predeterminada
                                    }
                                    break;
                                case "fechaDeCreacion":
                                    try {
                                        fechaDeCreacion = dateFormat.parse(value);
                                    } catch (ParseException e) {
                                        System.out.println("Error al parsear la fecha de creación: " + value);
                                        fechaDeCreacion = new Date(); // Asignar fecha actual como predeterminada
                                    }
                                    break;
                                case "ratingPromedio":
                                    ratingPromedio = Double.parseDouble(value);
                                    break;
                            }
                        }
                    }

                    // Crear un objeto LearningPath y añadirlo a la lista
                    if (nombreActividad != null && descripcion != null && nivelDeDificultad != null && version != null) {
                        LearningPath path = new LearningPath(
                                nombreActividad,
                                duracionEnMinutos,
                                descripcion,
                                nivelDeDificultad,
                                version,
                                ultimaFechaDeModificacion != null ? ultimaFechaDeModificacion : new Date(),
                                new ArrayList<>(), // Actividades
                                fechaDeCreacion != null ? fechaDeCreacion : new Date(),
                                new ArrayList<>(), // Ratings
                                ratingPromedio
                        );
                        learningPaths.add(path);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar Learning Paths: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo JSON: " + e.getMessage());
        }
        return learningPaths;
    }
}
