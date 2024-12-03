package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class Encuesta extends Actividad{
	
    private List<PreguntaAbierta> preguntas;
    
    
	public Encuesta(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio,
			int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
			List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias,
			List<PreguntaAbierta> preguntas) {
		super(descripcion, objetivo, nivel, obligatorio, "Encuesta", fechaLimiteDate, resultado,
				tiempoDedicado, ratings, resenas, estado, actividadesPrevias);
		this.preguntas = preguntas;
	}


	public List<PreguntaAbierta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaAbierta> preguntas) {
		this.preguntas = preguntas;
	}




	
}
