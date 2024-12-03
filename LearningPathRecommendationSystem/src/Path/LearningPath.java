package Path;

import java.util.Date;
import java.util.List;
import Retroalimentacion.Rating;

public class LearningPath {
    private String nombreActividad;
    private int duracionEnMinutos;
    private String descripcion;
    private String nivelDeDificultad;
    private String version;
    private Date ultimaFechaDeModificacion;
    private List<Actividad> actividades;
    private Date fechaDeCreacion;
    private List<Rating> ratings;
    private double ratingPromedio;

    // Constructor completo
    public LearningPath(String nombreActividad, int duracionEnMinutos, String descripcion, String nivelDeDificultad,
                        String version, Date ultimaFechaDeModificacion, List<Actividad> actividades,
                        Date fechaDeCreacion, List<Rating> ratings, double ratingPromedio) {
        this.nombreActividad = nombreActividad;
        this.duracionEnMinutos = duracionEnMinutos;
        this.descripcion = descripcion;
        this.nivelDeDificultad = nivelDeDificultad;
        this.version = version;
        this.ultimaFechaDeModificacion = ultimaFechaDeModificacion;
        this.actividades = actividades;
        this.fechaDeCreacion = fechaDeCreacion;
        this.ratings = ratings;
        this.ratingPromedio = ratingPromedio;
    }

    // Getters y Setters
    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivelDeDificultad() {
        return nivelDeDificultad;
    }

    public void setNivelDeDificultad(String nivelDeDificultad) {
        this.nivelDeDificultad = nivelDeDificultad;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getUltimaFechaDeModificacion() {
        return ultimaFechaDeModificacion;
    }

    public void setUltimaFechaDeModificacion(Date ultimaFechaDeModificacion) {
        this.ultimaFechaDeModificacion = ultimaFechaDeModificacion;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public double getRatingPromedio() {
        return ratingPromedio;
    }

    public void setRatingPromedio(double ratingPromedio) {
        this.ratingPromedio = ratingPromedio;
    }
}
