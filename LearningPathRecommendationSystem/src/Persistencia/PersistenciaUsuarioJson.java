package Persistencia;

import Usuario.Usuario;
import Usuario.Profesor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaUsuarioJson implements IPersistenciaUsuario {

    @Override
    public List<Usuario> cargarUsuarios(String archivo) {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line.trim());
            }

            String json = jsonBuilder.toString().trim();
            if (json.startsWith("[") && json.endsWith("]")) {
                json = json.substring(1, json.length() - 1).trim();
                String[] usuariosJson = json.split("},\\s*\\{");

                for (String usuarioJson : usuariosJson) {
                    Usuario usuario = procesarUsuarioJson(usuarioJson);
                    if (usuario != null) {
                        usuarios.add(usuario);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void salvarUsuarios(String archivo, List<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("[\n");
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);
                writer.write(formatearUsuarioJson(usuario));
                if (i < usuarios.size() - 1) {
                    writer.write(","); // Separador
                }
                writer.write("\n");
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("Error al guardar los usuarios en JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected Usuario procesarUsuarioJson(String usuarioJson) {
        usuarioJson = usuarioJson.replace("{", "").replace("}", "").replace("\"", "").trim();
        String[] campos = usuarioJson.split(",");

        String nombreUsuario = null;
        String contrasena = null;
        String tipo = null;

        for (String campo : campos) {
            String[] keyValue = campo.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "nombreUsuario":
                        nombreUsuario = value;
                        break;
                    case "contrasena":
                        contrasena = value;
                        break;
                    case "tipo":
                        tipo = value;
                        break;
                }
            }
        }

        if ("Profesor".equalsIgnoreCase(tipo)) {
            return new Profesor(nombreUsuario, contrasena); // Crea una instancia de Profesor
        } else {
            return new Usuario(nombreUsuario, contrasena); // Crea una instancia de Usuario
        }
    }

    protected String formatearUsuarioJson(Usuario usuario) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("    {");
        jsonBuilder.append("\"nombreUsuario\": \"").append(usuario.getUsuario()).append("\", ");
        jsonBuilder.append("\"contrasena\": \"").append(usuario.getContrasena()).append("\"");

        if (usuario instanceof Profesor) {
            jsonBuilder.append(", \"tipo\": \"Profesor\"");
        } else {
            jsonBuilder.append(", \"tipo\": \"Usuario\"");
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    @Override
    public void cargarUsuario(String archivo, Usuario usuario) {
        List<Usuario> usuarios = cargarUsuarios(archivo);
        if (usuarios != null) {
            for (Usuario u : usuarios) {
                if (u.getUsuario().equals(usuario.getUsuario())) {
                    usuario.setContrasena(u.getContrasena());
                    return;
                }
            }
        }
        System.out.println("Usuario no encontrado en el archivo.");
    }

    @Override
    public void salvarUsuario(String archivo, Usuario usuario) {
        List<Usuario> usuarios = cargarUsuarios(archivo);
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        boolean exists = false;
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario.getUsuario())) {
                u.setContrasena(usuario.getContrasena());
                exists = true;
                break;
            }
        }
        if (!exists) {
            usuarios.add(usuario);
        }
        salvarUsuarios(archivo, usuarios);
    }
}
