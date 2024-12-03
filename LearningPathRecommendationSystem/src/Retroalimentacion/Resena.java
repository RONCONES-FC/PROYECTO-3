package Retroalimentacion;

import java.util.Date;

public class Resena extends Retroalimentacion {
	 private String titulo;
	 private String comentario;
	 
	public Resena(String usuario, String rol, Date fechaDeCreacion, String titulo, String comentario) {
		super(usuario, rol, fechaDeCreacion);
		this.titulo = titulo;
		this.comentario = comentario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
	 

}
