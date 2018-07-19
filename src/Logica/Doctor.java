package Logica;
/**
 * 
 * @author Danilo Calderon,José Madrigal,Marvin Calvo y Adrain Vega
 *
 */
public class Doctor {
	// Atributos de la Clase
	private int identificacion;
	private String nombre ;
	private String especialidad;
	private int telefono;
	/**
	 *  Metodo que le da valores validos a loa atributos de la Clase
	 * @param pidentificacion variable int, representa la identificacion del doctor
	 * @param pnombre variable String, representa el nombre del  Doctor
	 * @param pespcialidad variable String, representa la especialidad del Doctor
	 * @param ptelefono variable String, representa el telefono al Doctor
	 * @return no retorna ningun valor
	 * @exception no maneja excepciones
	 */
	
	public Doctor(int pidentificacion,String pnombre,String pespcialidad,int ptelefono){
	 setEspecialidad(pespcialidad);
	 setIdentificacion(pidentificacion);
	 setNombre(pnombre);
	 setTelefono(ptelefono);
	}
	/**
	 * Metodo que retorna la identificacion del Doctor
	 * @return una variable int que contiene la identicacion del doctor
	 * @exception no maneja excepciones
	 */
	public int getIdentificacion() {
		return identificacion;
	}
     /**
      * Metodo que retorna el nombre del Doctor
      * @return  una variable String  que contiene el nombre del doctor
      * @exception no maneja excepciones
      */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que retorna el telefono del Doctor
	 * @return una variable int que contirne el telefono del Doctor
	 * @exception no maneja excepciones
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * Metodo que modifica el nombre del Doctor
	 * @param pnombre variable String que contiene el nombre del nombre
	 * @return no retorna ningun valor
	 * @exception no maneja excepciones
	 */
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	/**
	 * Metodo que retorna la especialidad del Doctor
	 * @return variable String que contiene la especialidad del Doctor
	 * @exception no maneja excepciones
	 */
	public String getEspecialidad() {
		return especialidad;
	}
	/**
	 * Metodo que modifica la especialidad del Doctor
	 * @param especialidad variable String que modifica la especialidad del Doctor
	 * @exception no maneja excepciones
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
     /**
      * Metodo que modifica el telefono del Doctor
      * @param ptelefono variable int que modifica el telefono del doctor
      * @exception no maneja excepciones
      */
	public void setTelefono(int ptelefono) {
		telefono = ptelefono;
	}
	/**
	 * Metodo que modifica la identificacion del Doctor
	 * @param pidentificacion variable int que modifica la identificacion del Doctor
	 * @exception no maneja excepciones
	 */
	private void setIdentificacion(int pidentificacion) {
		identificacion = pidentificacion;
	}
	/**
	 * Metodo que retorna el estado del objecto
	 * @return 
	 * @exception no maneja excepciones
	 */
	public String toString() {
		return "Doctor [identificacion=" + identificacion + ", nombre=" + nombre + ", especialidad=" + especialidad
				+ ", telefono=" + telefono + "]";
	}

}
