package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class RecursoEducativo extends Actividad {

	
    private String tipoMaterial;
    private String material;


	public RecursoEducativo(String descripcion, String objetivo, String nivel, boolean obligatorio, String tipo,
			Date fechaLimiteDate, boolean resultado, double tiempoDedicado, List<Rating> ratings, List<Resena> resenas,
			String estado, List<Actividad> actividadesPrevias, String tipoMaterial, String material) {
		super(descripcion, objetivo, nivel, obligatorio, "Recurso educativo", fechaLimiteDate, resultado, tiempoDedicado, ratings, resenas,
				estado, actividadesPrevias);
		this.material=material;
		this.tipoMaterial = tipoMaterial;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	
    
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void marcarCompleto() {
		this.setEstado("completo");
    }
    

	
}
