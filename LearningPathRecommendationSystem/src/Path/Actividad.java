package Path;




import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public abstract class Actividad {

	private String descripcion;
    private String objetivo;
    private String nivel;
    private int tiempoEstimado;
    protected boolean obligatorio;
    private final String tipo;
    private Date fechaLimiteDate;
    private boolean resultado;
    private double tiempoDedicado;
    private List<Rating> ratings;
    private List<Resena> resenas;
    private String estado;
    private List<Actividad> actividadesPrevias;
    
    
	public Actividad(String descripcion, String objetivo, String nivel, boolean obligatorio,
			String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
			List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias) {
		super();
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.nivel = nivel;
		this.tiempoEstimado = tiempoEstimado;
		this.obligatorio = obligatorio;
		this.tipo = tipo;
		this.fechaLimiteDate = fechaLimiteDate;
		this.resultado = resultado;
		this.tiempoDedicado = tiempoDedicado;
		this.ratings = ratings;
		this.resenas = resenas;
		this.estado = estado;
		this.actividadesPrevias = actividadesPrevias;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getObjetivo() {
		return objetivo;
	}


	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public int getTiempoEstimado() {
		return tiempoEstimado;
	}


	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}


	public boolean isObligatorio() {
		return obligatorio;
	}


	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}


	public int getFechaLimite() {
		return fechaLimite;
	}


	public void setFechaLimite(int fechaLimite) {
		this.fechaLimite = fechaLimite;
	}


	public String getTipo() {
		return tipo;
	}


	public Date getFechaLimiteDate() {
		return fechaLimiteDate;
	}


	public void setFechaLimiteDate(Date fechaLimiteDate) {
		this.fechaLimiteDate = fechaLimiteDate;
	}


	public boolean isResultado() {
		return resultado;
	}


	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}


	public double getTiempoDedicado() {
		return tiempoDedicado;
	}


	public void setTiempoDedicado(double tiempoDedicado) {
		this.tiempoDedicado = tiempoDedicado;
	}


	public List<Rating> getRatings() {
		return ratings;
	}


	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}


	public List<Resena> getResenas() {
		return resenas;
	}


	public void setResenas(List<Resena> resenas) {
		this.resenas = resenas;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<Actividad> getActividadesPrevias() {
		return actividadesPrevias;
	}


	public void setActividadesPrevias(List<Actividad> actividadesPrevias) {
		this.actividadesPrevias = actividadesPrevias;
	}
	
	 public double getRatingPromedio() {
	        if (ratings == null || ratings.isEmpty()) {
	            return 0.0;
	        }
	        double sum = 0.0;
	        for (Rating rating : ratings) {
	            sum += rating.getNumero();
	        }
	        return sum / ratings.size();
	    }
    
	
	
    
    
    
}
