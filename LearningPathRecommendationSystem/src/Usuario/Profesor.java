package Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Excepciones.YaExisteLearningPathException;
import Path.Actividad;
import Path.LearningPath;
import Path.Progreso;
import Path.RecursoEducativo;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;
public class Profesor extends Usuario {
   // Campos específicos de la clase Profesor
   private List<Actividad> actividadesCreadas;
   private List<LearningPath> learningPathsCreados;
   // Constructor que inicializa los atributos básicos
   public Profesor(String nombreUsuario, String contrasena) {
       super(nombreUsuario, contrasena); // Llama al constructor de la clase base Usuario
       this.actividadesCreadas = new ArrayList<>(); // Inicializa las listas vacías
       this.learningPathsCreados = new ArrayList<>();
   }
   // Constructor adicional con parámetros para inicializar listas
   public Profesor(String nombreUsuario, String contrasena, List<Actividad> actividades, List<LearningPath> learningPaths) {
       super(nombreUsuario, contrasena);
       this.actividadesCreadas = actividades != null ? actividades : new ArrayList<>();
       this.learningPathsCreados = learningPaths != null ? learningPaths : new ArrayList<>();
   }
   // Getters y Setters
   public List<Actividad> getActividadesCreadas() {
       return actividadesCreadas;
   }
   public void setActividadesCreadas(List<Actividad> actividadesCreadas) {
       this.actividadesCreadas = actividadesCreadas;
   }
   public List<LearningPath> getLearningPathsCreados() {
       return learningPathsCreados;
   }
   public void setLearningPathsCreados(List<LearningPath> learningPathsCreados) {
       this.learningPathsCreados = learningPathsCreados;
   }
   // Métodos de la clase Profesor
   public void crearLearningPath(String titulo, int duracionEnMinutos, String descripcion, String nivelDeDificultad,
                                 String version, Date ultimaFechaDeModificacion, Progreso progreso,
                                 List<Actividad> actividades, Date fechaDeCreacion, List<Rating> ratings,
                                 double ratingPromedio) throws YaExisteLearningPathException {
       // Verificar si ya existe un LearningPath con el mismo título
       for (LearningPath path : learningPathsCreados) {
           if (path.getTitulo().equalsIgnoreCase(titulo)) {
               throw new YaExisteLearningPathException(titulo); // Lanza la excepción si existe
           }
       }
       // Crear el nuevo LearningPath y añadirlo a la lista
       LearningPath nuevoPath = new LearningPath(titulo, duracionEnMinutos, descripcion, nivelDeDificultad, version,
               ultimaFechaDeModificacion, progreso, actividades, fechaDeCreacion, ratings, ratingPromedio);
       learningPathsCreados.add(nuevoPath);
   }
   public RecursoEducativo crearActividad(String descripcion, String objetivo, String nivel, int tiempo,
                                          boolean obligatorio, Date fechaLimite, String tipoMaterial) {
       // Crear una nueva actividad
       RecursoEducativo recurso = new RecursoEducativo(descripcion, objetivo, nivel, tiempo, obligatorio,
               fechaLimite, tipoMaterial);
       actividadesCreadas.add(recurso); // Añadir la actividad creada a la lista de actividades creadas
       return recurso;
   }
   public Progreso verProgresoEstudiante(Estudiante estudiante, LearningPath path) {
       return estudiante.verProgreso(path);
   }
   public void agregarActividad(Actividad actividad, LearningPath path) {
       List<Actividad> actividades = path.getActividades();
       actividades.add(actividad);
       path.setActividades(actividades);
   }
   public void reordenarPath(LearningPath path, Actividad actividadPorCambiar, int pos) {
       List<Actividad> actividades = path.getActividades();
       actividades.remove(actividadPorCambiar);
       if (pos < 0) {
           pos = 0;
       } else if (pos > actividades.size()) {
           pos = actividades.size();
       }
       actividades.add(pos, actividadPorCambiar);
       path.setActividades(actividades);
   }
   public void revisarActividad(Actividad actividad, String resultado) {
       actividad.setEstado(resultado);
   }
   public List<Resena> verResenas(Actividad actividad) {
       return actividad.getResenas();
   }
}

