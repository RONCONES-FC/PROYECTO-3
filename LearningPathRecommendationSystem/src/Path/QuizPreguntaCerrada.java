package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class QuizPreguntaCerrada extends Quiz {

	public QuizPreguntaCerrada(String descripcion, String objetivo, String nivel, int tiempoEstimado,
			boolean obligatorio, int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado,
			double tiempoDedicado, List<Rating> ratings, List<Resena> resenas, String estado,
			List<Actividad> actividadesPrevias, int calificacionMinima, boolean esSatisfactorio, int puntos,
			List<PreguntaCerrada> preguntas) {
		super(descripcion, objetivo, nivel, tiempoEstimado, obligatorio, fechaLimite, "Quiz pregunta cerrada", fechaLimiteDate, resultado,
				tiempoDedicado, ratings, resenas, estado, actividadesPrevias, calificacionMinima, esSatisfactorio, puntos,
				preguntas);
		
	}
}

	
		
