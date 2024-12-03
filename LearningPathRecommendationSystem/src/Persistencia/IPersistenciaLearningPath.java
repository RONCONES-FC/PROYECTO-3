package Persistencia;

import Path.LearningPath;

public interface IPersistenciaLearningPath {
    void cargarLearningPath(String archivo, LearningPath learningPath);
    void salvarLearningPath(String archivo, LearningPath learningPath);
}

