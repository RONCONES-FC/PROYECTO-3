package Path;


public class PreguntaVerdaderoFalso extends Pregunta{
	
	public PreguntaVerdaderoFalso(String enunciado, boolean respuesta) {
		super(enunciado);
		this.respuesta = respuesta; 
	}
	private boolean respuesta;
	
	public boolean isRespuesta() {
		return respuesta;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	
		
	}
	
