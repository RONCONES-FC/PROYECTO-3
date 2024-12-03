package Persistencia;
import java.util.List;
import Usuario.Usuario;
public interface IPersistenciaUsuario {
	void cargarUsuario(String archivo, Usuario usuario);
   void salvarUsuario(String archivo, Usuario usuario);
	List<Usuario> cargarUsuarios(String archivo);
	void salvarUsuarios(String archivo, List<Usuario> usuarios);
}
