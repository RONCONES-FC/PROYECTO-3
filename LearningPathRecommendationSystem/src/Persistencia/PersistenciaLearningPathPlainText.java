package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Path.Actividad;
import Path.LearningPath;
import Retroalimentacion.Rating;

public class PersistenciaLearningPathPlainText implements IPersistenciaLearningPath {

    @Override
    public void cargarLearningPath(String archivo, LearningPath learningPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {

            learningPath.setDuracionEnMinutos(Integer.parseInt(reader.readLine()));
            learningPath.setDescripcion(reader.readLine());
            learningPath.setNivelDeDificultad(reader.readLine());
            learningPath.setVersion(reader.readLine());
            learningPath.setUltimaFechaDeModificacion(new Date(Long.parseLong(reader.readLine())));
           
            
 
            int numActividades = Integer.parseInt(reader.readLine());
            List<String[]> actividades = new ArrayList<>();
            for (int i = 0; i < numActividades; i++) {
                String[] actividadData = new String[12]; // Número de atributos de actividad a guardar
                actividadData[0] = reader.readLine();  // Descripción
                actividadData[1] = reader.readLine();  // Objetivo
                actividadData[2] = reader.readLine();  // Nivel
                actividadData[3] = reader.readLine();  // Tiempo estimado
                actividadData[4] = reader.readLine();  // Obligatorio (boolean)
                actividadData[5] = reader.readLine();  // Fecha límite (int)
                actividadData[6] = reader.readLine();  // Tipo
                actividadData[7] = reader.readLine();  // Fecha límite en Date (long)
                actividadData[8] = reader.readLine();  // Resultado (boolean)
                actividadData[9] = reader.readLine();  // Tiempo dedicado (double)
                actividadData[10] = reader.readLine(); // Estado
                actividades.add(actividadData); // Guardamos los datos en la lista
            }


            learningPath.setFechaDeCreacion(new Date(Long.parseLong(reader.readLine())));

            // Cargar los ratings de manera similar a las actividades (estructura temporal)
            int numRatings = Integer.parseInt(reader.readLine());
            List<String[]> ratings = new ArrayList<>();
            for (int i = 0; i < numRatings; i++) {
                String[] ratingData = new String[2]; // Ajustar según la estructura de Rating
                ratingData[0] = reader.readLine(); // Valor del rating (double)
                ratingData[1] = reader.readLine(); // Comentario
                ratings.add(ratingData);
            }

            learningPath.setRatingPromedio(Double.parseDouble(reader.readLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvarLearningPath(String archivo, LearningPath learningPath) {
        try (FileWriter writer = new FileWriter(archivo)) {
            // Escribir los atributos de LearningPath
            
            writer.write(learningPath.getDuracionEnMinutos() + "\n");
            writer.write(learningPath.getDescripcion() + "\n");
            writer.write(learningPath.getNivelDeDificultad() + "\n");
            writer.write(learningPath.getVersion() + "\n");
            writer.write(learningPath.getUltimaFechaDeModificacion().getTime() + "\n"); // Fecha como timestamp
            
            // Escribir las actividades en el archivo de texto
            List<Actividad> actividades = learningPath.getActividades();
            writer.write(actividades.size() + "\n"); // Número de actividades
            for (Actividad actividad : actividades) {
                writer.write(actividad.getDescripcion() + "\n");
                writer.write(actividad.getObjetivo() + "\n");
                writer.write(actividad.getNivel() + "\n");
                writer.write(actividad.getTiempoEstimado() + "\n");
                writer.write(actividad.isObligatorio() + "\n");
                writer.write(actividad.getFechaLimite() + "\n");
                writer.write(actividad.getTipo() + "\n");
                writer.write(actividad.getFechaLimiteDate().getTime() + "\n"); // Fecha como timestamp
                writer.write(actividad.isResultado() + "\n");
                writer.write(actividad.getTiempoDedicado() + "\n");
                writer.write(actividad.getEstado() + "\n");
                // El resto de atributos (ratings, resenas, actividadesPrevias) se pueden manejar según sea necesario
            }

            writer.write(learningPath.getFechaDeCreacion().getTime() + "\n"); // Fecha como timestamp
            
            // Escribir los ratings
            List<Rating> ratings = learningPath.getRatings();
            writer.write(ratings.size() + "\n"); // Número de ratings
            for (Rating rating : ratings) {
                writer.write(rating.getNumero() + "\n"); // Suponiendo que Rating tiene un número
              
            }

            writer.write(learningPath.getRatingPromedio() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
