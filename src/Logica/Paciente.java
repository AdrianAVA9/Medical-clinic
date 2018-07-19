package Logica;


	/**
	 * Clase que simula un Paciente 
	 * @author Danilo Calderon
	 * @author Marvin Calvo
	 * @author Adrian Vega
	 * @author Jose Madrigal
	 * @version v1.0
 	 **/
 	 
public class Paciente {
	
	//Atributos privados de la clase
	
	private  int cedula;
	private String nombre;
	private String direccion;
	private int telefono;
	private String fechaNacimiento;
	private int edad;
	
  /**
   	*M�todo que crea el objeto tipo Paciente
   	*@param pcedula valor entero cedula del paciente
   	*@param pnombre valor String nombre del paciente
   	*@param pdireccion valor String direccion del paciente
   	*@paran ptelefono valor int telefono del paciente
	*@param pfechaNacimiento valor String fecha nacimiento del paciente
	*@param pedad valor entero edad del paciente
   	*@return no 
   	*@exception no
   	**/
	public Paciente(int pcedula, String pnombre, String pdireccion, int ptelefono, String pfechaNacimiento, int pedad) {
		setCedula(pcedula);
		setDireccion(pdireccion);
		setEdad(pedad);
		setFechaNacimiento(pfechaNacimiento);
		setNombre(pnombre);
		setTelefono(ptelefono);
	}
	
	/**
	 * M�todo para obtener la cedula contenido en la celda.
	 * @param no requiere par�metros 
	 * @return cedula que se encuentra almacenado 
	 * @exception no se manejan excepciones 
 	 **/
	public int getCedula() {
		return cedula;
	}
	
	/**
	 * M�todo para obtener el nombre contenido en la celda.
	 * @param no requiere par�metros 
	 * @return nombre que se encuentra almacenado 
	 * @exception no se manejan excepciones 
 	 **/
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * M�todo para obtener la direccion contenido en la celda.
	 * @param no requiere par�metros 
	 * @return direccion que se encuentra almacenado 
	 * @exception no se manejan excepciones 
 	 **/
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * M�todo para obtener el telefono contenido en la celda.
	 * @param no requiere par�metros 
	 * @return telefono que se encuentra almacenado 
	 * @exception no se manejan excepciones 
 	 **/
	public int getTelefono() {
		return telefono;
	}
	
	/**
	 * M�todo para obtener la fecha nacimiento contenido en la celda.
	 * @param no requiere par�metros 
	 * @return fecha nacimiento que se encuentra almacenado 
	 * @exception no se manejan excepciones 
 	 **/
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * M�todo para obtener la edad contenido en la celda.
	 * @param no requiere par�metros 
	 * @return edad que se encuentra almacenado 
	 * @exception no se manejan excepciones 
 	 **/
	public int getEdad() {
		return edad;
	}
	
	/** 
	 * M�todo para almacenar el nombre en la celda 
	 * @param pnombre valor String para configurar el nombre 
	 * @return no retorna ning�n valor 
	 * @exception no se manejan excepciones 
	 **/
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	
	/** 
	 * M�todo para almacenar la direccion en la celda 
	 * @param pdireccion valor String para configurar la dirreccion 
	 * @return no retorna ning�n valor 
	 * @exception no se manejan excepciones 
	 **/
	public void setDireccion(String pdireccion) {
		direccion = pdireccion;
	}
	
	/** 
	 * M�todo para almacenar el telefono en la celda 
	 * @param ptelefono valor entero para configurar el telefono 
	 * @return no retorna ning�n valor 
	 * @exception no se manejan excepciones 
	 **/
	public void setTelefono(int ptelefono) {
		telefono = ptelefono;
	}
	
	/** 
	 * M�todo para almacenar la cedula en la celda 
	 * @param pcedula valor String para configurar la cedula 
	 * @return no retorna ning�n valor 
	 * @exception no se manejan excepciones 
	 **/
	private void setCedula(int pcedula) {
		cedula = pcedula;
	}
	
	/** 
	 * M�todo para almacenar la edad en la celda 
	 * @param pedad valor entero para configurar la edad 
	 * @return no retorna ning�n valor 
	 * @exception no se manejan excepciones 
	 **/
	public void setEdad(int pedad) {
		edad = pedad;
	}
	
	/** 
	 * M�todo para almacenar la fecha de nacimiento en la celda 
	 * @param pfechaNacimiento valor entero para configurar la fecha de nacimiento
	 * @return no retorna ning�n valor 
	 * @exception no se manejan excepciones 
	 **/
	public void setFechaNacimiento(String pfechaNacimiento) {
		fechaNacimiento = pfechaNacimiento;
	}
	
	/** 
	 * M�todo para obtener el estado de un Paciente 
	 * @param no requiere parametros
	 * @return msj valor String que se encuentra almacenado
	 * @exception no se manejan excepciones 
	 **/
	public String toString() {
		
		String msj;
		
		msj = "cedula: " + getCedula() +
			  "nombre: " + getNombre() +
			  "direccion: " + getDireccion() +
			  "telefono: " + getTelefono() +
			  "fecha Nacimiento: " + getFechaNacimiento() +
			  "Edad: " + getEdad();
			  
		return msj; 
	}

}
