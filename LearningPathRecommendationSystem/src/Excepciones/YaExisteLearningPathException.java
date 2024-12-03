package Excepciones;

public class YaExisteLearningPathException extends Exception {
    
    private static final long serialVersionUID = 1L; 

    public YaExisteLearningPathException(String titulo) {
        super("El Learning Path con el título '" + titulo + "' ya existe.");
    }
}
