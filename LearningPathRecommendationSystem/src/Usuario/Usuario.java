package Usuario;

import java.util.ArrayList;
import java.util.List;

import Path.Actividad;
import Path.LearningPath;
import Persistencia.CentralPersistencia;
import Persistencia.IPersistenciaUsuario;

public class Usuario {
	protected String usuario;
    protected String contrasena;
    public static List<LearningPath> learningPaths = new ArrayList<>();
    
	public Usuario(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public static List<LearningPath> getLearningPaths() {
		return learningPaths;
	}

	public static void setLearningPaths(List<LearningPath> learningPaths) {
		Usuario.learningPaths = learningPaths;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void dejarRating(double rating, Actividad actividad) {
		//implementar
	}
	
	public void dejarResena(String resena, Actividad actividad) {
		//implementar
	}
	  
	
	protected boolean cambiarClave(String actual, String nueva) {
        if (this.contrasena.equals(actual)) {
            this.contrasena = nueva;
            return true;
        } else {
            return false; 
        }
    }
	
	public static Usuario autenticarUsuario(String username, String password, String archivoJson) {
	    // Obtener la persistencia de usuario para JSON
	    IPersistenciaUsuario persistencia = CentralPersistencia.getPersistenciaUsuario(CentralPersistencia.JSON);
	    try {
	        // Cargar los usuarios desde el archivo JSON
	        List<Usuario> usuarios = persistencia.cargarUsuarios(archivoJson);
	        // Verificar las credenciales
	        for (Usuario usuario : usuarios) {
	            if (usuario.getUsuario().equals(username) && usuario.getContrasena().equals(password)) {
	                return usuario; // Retorna el usuario si las credenciales coinciden
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error al cargar usuarios desde el archivo JSON: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return null; // Retorna null si no encuentra un usuario con las credenciales dadas
	}

	  
    
    
}
