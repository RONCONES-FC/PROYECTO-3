package Usuario;

import java.util.List;

import Path.Actividad;
import Path.LearningPath;
import Path.Progreso;
import Path.Tarea;
import Retroalimentacion.Resena;
import Retroalimentacion.Retroalimentacion;

public class Estudiante extends Usuario  {
	
	private List<LearningPath> learningPathsInscritos;
    private List<Actividad> actividadesRealizadas;
    
	public Estudiante(String usuario, String contrasena, List<LearningPath> learningPathsInscritos, List<Actividad> actividadesRealizadas) {
		super(usuario, contrasena);
		this.learningPathsInscritos = learningPathsInscritos;
		this.actividadesRealizadas = actividadesRealizadas;
	}

	public List<LearningPath> getLearningPathsInscritos() {
		return learningPathsInscritos;
	}

	public void setLearningPathsInscritos(List<LearningPath> learningPathsInscritos) {
		this.learningPathsInscritos = learningPathsInscritos;
	}

	public List<Actividad> getActividadesRealizadas() {
		return actividadesRealizadas;
	}

	public void setActividadesRealizadas(List<Actividad> actividadesRealizadas) {
		this.actividadesRealizadas = actividadesRealizadas;
	}
	
	public Progreso verProgreso(LearningPath path) {
        return path.getProgreso();
    }
	
	public void generarResena(Actividad actividad, String titulo, String comentario) {
		//date fecha = hoy
		// cambiar null por fecha
        Resena resena = new Resena(comentario, null, null, comentario, comentario);
        List<Resena> resenas = actividad.getResenas();
        actividad.setResenas(resenas);
    }

	public void inscribirLearningPath(LearningPath path) {
        learningPathsInscritos.add(path);
    }
	
	public void realizarActividad(Actividad actividad) {
        actividadesRealizadas.add(actividad);
        //falta algo
    }
	
	 public void enviarTarea(Tarea tarea, String medioEnvio) {
	        //implementar
	    }
	 
	 public void responderEvaluacion(Actividad actividad) {
	        //implementar
	    }
    
    
}
