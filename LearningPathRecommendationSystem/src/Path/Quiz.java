package Path;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public abstract class Quiz extends Actividad {
	
	 	protected int calificacionMinima;
	    protected boolean esSatisfactorio = false;
	    protected int puntos = 0;
	    protected List<PreguntaCerrada> preguntas;
	 

	    public Quiz(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio,
				int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
				List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias,
				int calificacionMinima, boolean esSatisfactorio, int puntos, List<PreguntaCerrada> preguntas2) {
			super(descripcion, objetivo, nivel, obligatorio, tipo, fechaLimiteDate, resultado,
					tiempoDedicado, ratings, resenas, estado, actividadesPrevias);
			this.calificacionMinima = calificacionMinima;
			this.esSatisfactorio = esSatisfactorio;
			this.puntos = 0;
			this.preguntas = preguntas2;
		}

	    public int getCalificacionMinima() {
			return calificacionMinima;
		}

		public void setCalificacionMinima(int calificacionMinima) {
			this.calificacionMinima = calificacionMinima;
		}

		public boolean isEsSatisfactorio() {
			return esSatisfactorio;
		}

		public void setEsSatisfactorio() {
			this.esSatisfactorio = true;
		}

		public int getPuntos() {
			return puntos;
		}

		public void setPuntos(int puntos) {
			this.puntos = puntos;
		}
		public void ActualizarPuntos(List<Integer> respuestas) {
		    if (respuestas == null) {
		        throw new IllegalArgumentException("La lista de respuestas no puede ser nula.");
		    }

		    while (respuestas.size() < preguntas.size()) {
		        respuestas.add(0); 
		    }
		    while (respuestas.size() > preguntas.size()) {
		        respuestas.remove(respuestas.size() - 1); 
		    }

		    int cuenta = 0;

		    for (int i = 0; i < preguntas.size(); i++) {
		        Pregunta pregunta = preguntas.get(i);


		        if (pregunta instanceof PreguntaCerrada) {
		            PreguntaCerrada preguntaCerrada = (PreguntaCerrada) pregunta;
		            if (preguntaCerrada.getRespuesta() == respuestas.get(i)) {
		                cuenta ++;
		            }
		        }
		    }

		    this.setPuntos(cuenta);

		    if (cuenta >= calificacionMinima) {
		        this.setEsSatisfactorio();
		    }
		}
	

   
}
