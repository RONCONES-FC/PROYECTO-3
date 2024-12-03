package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class Tarea extends Actividad{
	
	public Tarea(String descripcion, String objetivo, String nivel, boolean obligatorio, String tipo,
			Date fechaLimiteDate, boolean resultado, double tiempoDedicado, List<Rating> ratings, List<Resena> resenas,
			String estado, List<Actividad> actividadesPrevias, boolean envio, String medioEnvio) {
		super(descripcion, objetivo, nivel, obligatorio, "Tarea", fechaLimiteDate, resultado, tiempoDedicado, ratings, resenas,
				estado, actividadesPrevias);
		this.envio=envio;
		this.medioEnvio = medioEnvio;
	}

	private boolean envio;
    private String medioEnvio;
    

	public boolean isEnvio() {
		return envio;
	}


	public String getMedioEnvio() {
		return medioEnvio;
	}

	public void setMedioEnvio(String medioEnvio) {
		this.medioEnvio = medioEnvio;
	
		if(medioEnvio != null && !medioEnvio.isEmpty());
			this.envio = true;
			this.setEstado("Enviado");
	}


    
}
