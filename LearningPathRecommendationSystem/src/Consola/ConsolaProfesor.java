package Consola;

import Persistencia.PersistenciaLearningPathJson;
import Path.LearningPath;
import Usuario.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsolaProfesor extends ConsolaBasica {

    // Constructor con parámetros
    public ConsolaProfesor(List<Usuario> usuarios, String nombreUsuario, String contrasena) {
        super();
        this.usuarios = usuarios;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Constructor vacío
    public ConsolaProfesor() {
        super(); // Inicializa los atributos base
    }

    @Override
    public void correrAplicacion() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PersistenciaLearningPathJson persistenciaLP = new PersistenciaLearningPathJson();
        List<LearningPath> learningPathsCreados = new ArrayList<>();

        try {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear y guardar un nuevo Learning Path");
            System.out.println("2. Consultar Learning Paths");
            System.out.println("3. Salir");

            int opcion = Integer.parseInt(reader.readLine());

            switch (opcion) {
                case 1:
                    // Crear y guardar un nuevo Learning Path
                    System.out.print("Ingrese el nombre de la actividad: ");
                    String nombreActividad = reader.readLine();
                    System.out.print("Ingrese la duración en minutos: ");
                    int duracion = Integer.parseInt(reader.readLine());
                    System.out.print("Ingrese la descripción: ");
                    String descripcion = reader.readLine();
                    System.out.print("Ingrese el nivel de dificultad: ");
                    String nivelDeDificultad = reader.readLine();
                    System.out.print("Ingrese la versión: ");
                    String version = reader.readLine();

                    // Crear el nuevo Learning Path
                    LearningPath nuevoPath = new LearningPath(
                            nombreActividad,
                            duracion,
                            descripcion,
                            nivelDeDificultad,
                            version,
                            new Date(), // Última fecha de modificación
                            new ArrayList<>(), // Lista de actividades
                            new Date(), // Fecha de creación
                            new ArrayList<>(), // Lista de ratings
                            0.0 // Rating promedio
                    );

                    // Guardar el nuevo Learning Path en la lista y en el archivo JSON
                    learningPathsCreados.add(nuevoPath);
                    persistenciaLP.guardarLearningPaths("Datos/learningPaths.json", learningPathsCreados);
                    System.out.println("Learning Path guardado exitosamente.");
                    break;

                case 2:
                    // Consultar Learning Paths
                    List<LearningPath> paths = persistenciaLP.cargarLearningPaths("Datos/learningPaths.json");
                    if (paths.isEmpty()) {
                        System.out.println("No hay Learning Paths disponibles.");
                    } else {
                        System.out.println("Learning Paths disponibles:");
                        for (LearningPath path : paths) {
                            System.out.println("Nombre de la actividad: " + path.getNombreActividad());
                            System.out.println("Duración: " + path.getDuracionEnMinutos() + " minutos");
                            System.out.println("Descripción: " + path.getDescripcion());
                            System.out.println("Nivel de dificultad: " + path.getNivelDeDificultad());
                            System.out.println("Versión: " + path.getVersion());
                            System.out.println("Última fecha de modificación: " + path.getUltimaFechaDeModificacion());
                            System.out.println("Fecha de creación: " + path.getFechaDeCreacion());
                            System.out.println("------------------------------");
                        }
                    }
                    break;

                case 3:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        ConsolaProfesor consola = new ConsolaProfesor();
        consola.mostrarMenu(); 
    }
}


