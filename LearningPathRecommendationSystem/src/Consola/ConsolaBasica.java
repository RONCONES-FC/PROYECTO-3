package Consola;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Usuario.Usuario;


import Persistencia.CentralPersistencia;
import Persistencia.IPersistenciaUsuario;
public abstract class ConsolaBasica {
   protected List<Usuario> usuarios;
   protected String nombreUsuario;
   protected String contrasena;
   private IPersistenciaUsuario persistencia;
   public ConsolaBasica() {
       this.usuarios = new ArrayList<>();
       this.persistencia = CentralPersistencia.getPersistenciaUsuario(CentralPersistencia.JSON); 
       cargarUsuariosDesdeArchivo("Datos/usuarios.json"); 
   }
   
   protected Usuario autenticar(String nombreUsuario, String contrasena) {
       return Usuario.autenticarUsuario(nombreUsuario, contrasena, "Datos/usuarios.json");
   }

   public abstract void correrAplicacion();
   private void cargarUsuariosDesdeArchivo(String archivo) {
       try {
           List<Usuario> usuariosCargados = persistencia.cargarUsuarios(archivo);
           usuarios.addAll(usuariosCargados); 
       } catch (Exception e) {
           System.out.println("Error al cargar los usuarios desde el archivo: " + e.getMessage());
           e.printStackTrace();
       }
   }
   public void guardarUsuariosEnArchivo(String archivo) {
       try {
           persistencia.salvarUsuarios(archivo, usuarios); 
       } catch (Exception e) {
           System.out.println("Error al guardar los usuarios en el archivo: " + e.getMessage());
           e.printStackTrace();
       }
   }
   
   public void agregarUsuario(Usuario usuario, String archivo) {
       usuarios.add(usuario);
       guardarUsuariosEnArchivo(archivo);
   }
 
   public void mostrarMenu() {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       try {
           System.out.print("Ingrese el nombre de usuario: ");
           String nombreUsuario = reader.readLine();
           System.out.print("Ingrese la contraseña para " + nombreUsuario + ": ");
           String contrasena = reader.readLine();
           Usuario usuario = new Usuario(nombreUsuario, contrasena);
           usuarios.add(usuario); 
           System.out.println("Seleccione la consola:");
           System.out.println("1. Verificar Estudiante");
           System.out.println("2. Seguir Progreso del Profesor");
           System.out.println("3. Crear Learning Path (Profesor)");
           int opcion = Integer.parseInt(reader.readLine());
           switch (opcion) {
               case 1:
               	
                   ConsolaEstudiante consolaEstudiante = new ConsolaEstudiante(usuarios, nombreUsuario, contrasena);
                   consolaEstudiante.correrAplicacion();
                   break;
               case 2:
                   ConsolaProfesor consolaProfesor = new ConsolaProfesor(usuarios, nombreUsuario, contrasena);
                   consolaProfesor.correrAplicacion();
                   break;
               case 3:
                   ConsolaProfesor consolaProfesor1 = new ConsolaProfesor(usuarios, nombreUsuario, contrasena);
                   consolaProfesor1.correrAplicacion();
                   break;
               default:
                   System.out.println("Opción no válida.");
                   break;
           }
       } catch (IOException e) {
           System.out.println("Error de entrada/salida: " + e.getMessage());
       } catch (NumberFormatException e) {
           System.out.println("Error: Debe ingresar un número válido.");
       }
   }
}


