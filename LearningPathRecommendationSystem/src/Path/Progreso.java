package Path;

import java.util.Date;
import java.util.List;


public class Progreso {

    private double porcentajeAvance;
    private List<Actividad> actividadesCompletadas;
    private Date fechaFin;
    private double tasaExito;
    private Date fechaInicio;
    private double tasaFracaso;
    
	public Progreso(double porcentajeAvance, List<Actividad> actividadesCompletadas,
			Date fechaFin, double tasaExito, Date fechaInicio, double tasaFracaso) {
		super();
		this.porcentajeAvance = porcentajeAvance;
		this.actividadesCompletadas = actividadesCompletadas;
		this.fechaFin = fechaFin;
		this.tasaExito = tasaExito;
		this.fechaInicio = fechaInicio;
		this.tasaFracaso = tasaFracaso;
		
		
	}


	public double getPorcentajeAvance() {
		return porcentajeAvance;
	}

	public void setPorcentajeAvance(double porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}

	public List<Actividad> getActividadesCompletadas() {
		return actividadesCompletadas;
	}

	public void setActividadesCompletadas(List<Actividad> actividadesCompletadas) {
		this.actividadesCompletadas = actividadesCompletadas;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getTasaExito() {
		return tasaExito;
	}

	public void setTasaExito(double tasaExito) {
		this.tasaExito = tasaExito;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getTasaFracaso() {
		return tasaFracaso;
	}

	public void setTasaFracaso(double tasaFracaso) {
		this.tasaFracaso = tasaFracaso;
	}
    
    
}
