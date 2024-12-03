package Retroalimentacion;

import java.util.Date;

public class Rating extends Retroalimentacion {
	private double numero;

	public Rating(String usuario, String rol, Date fechaDeCreacion, double numero) {
		super(usuario, rol, fechaDeCreacion);
		this.numero = numero;
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}
	
	
	
}


