package Persistencia;
public class CentralPersistencia {
   public static final String JSON = "JSON";
   public static final String PLAIN = "PlainText";
   // Método para obtener la persistencia de usuarios
   public static IPersistenciaUsuario getPersistenciaUsuario(String tipoArchivo) {
       if (JSON.equals(tipoArchivo)) {
           return new PersistenciaUsuarioJsonConcreta(); // Usar la subclase concreta
       } else if (PLAIN.equals(tipoArchivo)) {
           return new PersistenciaUsuarioPlaintext(); // Mantener la implementación existente para texto plano
       } else {
           throw new IllegalArgumentException("Tipo de archivo no soportado: " + tipoArchivo);
       }
   }
   // Método para obtener la persistencia de LearningPaths
   public static IPersistenciaLearningPath getPersistenciaLearningPath(String tipoArchivo) {
       if (JSON.equals(tipoArchivo)) {
           return new PersistenciaLearningPathJson(); // Supongo que existe una implementación concreta
       } else if (PLAIN.equals(tipoArchivo)) {
           return new PersistenciaLearningPathPlainText(); // Supongo que existe una implementación concreta
       } else {
           throw new IllegalArgumentException("Tipo de archivo no soportado: " + tipoArchivo);
       }
   }
}

