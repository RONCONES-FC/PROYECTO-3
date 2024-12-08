package Path;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private Date fechaDeCreacion;
    private List<Actividad> actividades;
    private List<Rating> ratings;
    private double ratingPromedio;

    // Constructor con fechas como Strings
    public LearningPath(String nombreActividad, int duracionEnMinutos, String descripcion, String nivelDeDificultad,
                        String version, String ultimaFechaDeModificacion, List<Actividad> actividades,
                        String fechaDeCreacion, List<Rating> ratings, double ratingPromedio) {
        this.nombreActividad = nombreActividad;
        this.duracionEnMinutos = duracionEnMinutos;
        this.descripcion = descripcion;
        this.nivelDeDificultad = nivelDeDificultad;
        this.version = version;
        this.actividades = actividades != null ? actividades : new ArrayList<>();
        this.ratings = ratings != null ? ratings : new ArrayList<>();
        this.ratingPromedio = ratingPromedio;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            this.ultimaFechaDeModificacion = ultimaFechaDeModificacion != null
                    ? dateFormat.parse(ultimaFechaDeModificacion)
                    : null;
            this.fechaDeCreacion = fechaDeCreacion != null ? dateFormat.parse(fechaDeCreacion) : null;
        } catch (ParseException e) {
            System.err.println("Error al parsear las fechas en el constructor: " + e.getMessage());
        }
    }

    // Constructor completo con fechas como Date
    public LearningPath(String nombreActividad, int duracionEnMinutos, String descripcion, String nivelDeDificultad,
                        String version, Date ultimaFechaDeModificacion, List<Actividad> actividades,
                        Date fechaDeCreacion, List<Rating> ratings, double ratingPromedio) {
        this.nombreActividad = nombreActividad;
        this.duracionEnMinutos = duracionEnMinutos;
        this.descripcion = descripcion;
        this.nivelDeDificultad = nivelDeDificultad;
        this.version = version;
        this.ultimaFechaDeModificacion = ultimaFechaDeModificacion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.actividades = actividades != null ? actividades : new ArrayList<>();
        this.ratings = ratings != null ? ratings : new ArrayList<>();
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

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
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
