package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Usuario.Usuario;

public class PersistenciaUsuarioPlaintext implements IPersistenciaUsuario{

	 @Override
	    public void cargarUsuario(String archivo, Usuario usuario) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
	            String line = reader.readLine();
	            if (line != null) {
	                String[] parts = line.split(",");
	                usuario.setUsuario(parts[0]);
	                usuario.setContrasena(parts[1]);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void salvarUsuario(String archivo, Usuario usuario) {
	        try (FileWriter writer = new FileWriter(archivo)) {
	            writer.write(usuario.getUsuario() + "," + usuario.getContrasena());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

