package website.goslenburgos.crudrestfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreRecurso;
	private String nombreArchivo;
	private Object valorArchivo;
	
	public ResourceNotFoundException(String nombreRecurso, String nombreArchivo, Object valorArchivo) {
		super(String.format("%s no se encontro %s", nombreRecurso, nombreArchivo, valorArchivo));
		this.nombreRecurso = nombreRecurso;
		this.nombreArchivo = nombreArchivo;
		this.valorArchivo = valorArchivo;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Object getValorArchivo() {
		return valorArchivo;
	}

	public void setValorArchivo(String valorArchivo) {
		this.valorArchivo = valorArchivo;
	}
}
