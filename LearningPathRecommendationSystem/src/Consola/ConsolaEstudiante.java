package Consola;
import Usuario.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class ConsolaEstudiante extends ConsolaBasica {
   // Constructor con parámetros
   public ConsolaEstudiante(List<Usuario> usuarios, String nombreUsuario, String contrasena) {
       super(); // Llama al constructor de ConsolaBasica para inicializar atributos base
       this.usuarios = usuarios;
       this.nombreUsuario = nombreUsuario;
       this.contrasena = contrasena;
   }
   // Constructor vacío para inicialización genérica
   public ConsolaEstudiante() {
       super(); // Inicializa los atributos base
   }
   @Override
   public void correrAplicacion() {
       // Intentar autenticar al usuario
       Usuario usuario = autenticar(nombreUsuario, contrasena);
       if (usuario != null) {
           System.out.println("Autenticación exitosa. Mostrando información del estudiante: " + usuario.getUsuario());
           // Funcionalidades específicas del estudiante
           System.out.println("Bienvenido a tu espacio personal de estudiante.");
       } else {
           System.out.println("Error: Usuario no encontrado.");
           // Preguntar al usuario si desea añadirse
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           try {
               System.out.print("¿Desea registrarse como un nuevo estudiante? (sí/no): ");
               String respuesta = reader.readLine().trim().toLowerCase();
               if (respuesta.equals("sí") || respuesta.equals("si")) {
                   // Crear un nuevo usuario con las credenciales ingresadas
                   Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
                   agregarUsuario(nuevoUsuario, "Datos/usuarios.json"); // Guardar el nuevo usuario en el archivo JSON
                   System.out.println("Registro exitoso. Bienvenido al sistema, " + nombreUsuario + ".");
               } else {
                   System.out.println("El usuario no fue registrado. Cerrando sesión...");
               }
           } catch (IOException e) {
               System.out.println("Error al leer la entrada: " + e.getMessage());
           }
       }
   }
   public static void main(String[] args) {
       // Instancia genérica de ConsolaEstudiante
       ConsolaEstudiante consola = new ConsolaEstudiante();
       consola.mostrarMenu(); // Llama al método de la clase base
   }
}
