package Logica;

/**
 * Una clase que simula una consulta medica de un paciente
 * @author Adrian Vega
 * @author Marvin Calvo
 * @author Danilo Calderon
 * @author Jose Madrigal
 * @version v1.0
 */

public class Consulta {
	
	//Atrbutos privados de la clase consulta
	private int id;
	private int idDoctor;
	private String fechaRealizacion;
	private String descripcion;
	private String medicina;
	private String numeroExpediente;
	private Doctor doctor;
	
	/**Metodo que inicializa en estado validos los atributos del objeto
	 *@param pid: valor int que registra el id de la consulta
	 *@param pidDoctor: valor int que registra el id del doctor
	 *@param pfechaRealizacion: valor String que registra la fecha de la consulta
	 *@param pdescripcion: valor String que registra la descripcion de la consulta
	 *@param pmedicina: valor String que registra la(s) medicina(s) recetada(s)
	 *@param pnumeroExpediente: valor String que registra el numero de expediente
	 *@return no retorna ningun valor
	 *@exception no se manejan excepciones
	 */
	
	public Consulta(int pid, int pidDoctor, String pfechaRealizacion, String pdescripcion, String pmedicina,String pnumeroExpediente) {
		setDescripcion(pdescripcion);
		setFechaRealizacion(pfechaRealizacion);
		setId(pid);
		setIdDoctor(pidDoctor);
		setMedicina(pmedicina);
		setNumeroExpediente(pnumeroExpediente);
		doctor=null;
	}
	
	/**Metod que retorna el id de la consulta
	 *@param no requiere ningun parametro
	 *@return id que se encuentra almacenado
	 *@exception no se manejan excepciones
	 */

	public int getId() {
		return id;
	}
	
	/**Metodo para obtener la fecha de la consulta
	 * @param no require ningun parametro
	 * @return fechaRealizacion que se encuentra almacenada
	 * @exception no se manejan excepciones
	 */

	public String getFechaRealizacion() {
		return fechaRealizacion;
	}
	
	/**Metodo para obtener el numero del expediente
	 * @param no requiere ningun parametro
	 * @return el numero de expediente que se encuetra almacenado
	 * @exception no se manejan excepciones
	 */
	
	public String getNumeroExpediente() {
		return numeroExpediente;
	}
	
	/**Metodo para obtener la descripcion de la consulta
	 * @param no se requieren parametros
	 * @return la descripcion que se encuentra almacenada
	 * @exception no se manejan excepciones
	 */
	
	public String getDescripcion() {
		return descripcion;
	}
	
	/**Metodo para almecenar la descripcion de la consulta
	 *@param pdescripcion: valor String que modifica la descripcion de la consulta
	 *@return no retorna ningun valor
	 *@exception no se manejan excepciones
	 */
	
	public void setDescripcion(String pdescripcion) {
		descripcion = pdescripcion;
	}
	
	/**Metodo para obtener la(s) medicina(s) recetada(s)
	 *@param no se requieren parametros
	 *@return medicina que se encuentra almacenda
	 *@exception no se manejan excepciones
	 */
	
	public String getMedicina() {
		return medicina;
	}
	
	/**Metodo privado para almacenar el id de la consulta
	 *@param pid: valor int que modifica el id de la consulta
	 *@return no retorna ningun valor
	 *@exception no se manejan excepciones 
	 */
	
	private void setId(int pid) {
		id = pid;
	}
	
	/**Metodo para obtener el id del doctor de la consulta
	 *@param no se requieren parametros
	 *@return id que se encuentra almacenado
	 *@exception no se manejan excepciones
	 */
	
	public int getIdDoctor() {
		return idDoctor;
	}
	
	/**Metodo para obtener el doctor de la consulta
	 *@param no se requieren parametros
	 *@return el objeto doctor que se encuentra almacenado
	 *@exception no se manejan excepciones 
	 */
	
	public  Doctor getDoctor()throws Exception{
		
		if(doctor==null){
			MultiDoctor multiDoctor=new MultiDoctor();
			doctor=multiDoctor.buscarDoctor(getIdDoctor());
		}
		
		return doctor;
	}
	
	/**Metodo privado para registrar el id del doctor
	 *@param pidDoctor: valor int que modifica el id del doctor
	 *@return no retorna ningun valor
	 *@exception no se manejan excepciones 
	 */
	
	private void setIdDoctor(int pidDoctor) {
		idDoctor = pidDoctor;
	}
	
	/**Metodo para registrar la fecha de la consulta
	 *@param pfechaRealizacion: valor String que modifica la fecha de la consulta
	 *@return no retorna ningun valor
	 *@exception no se manejan excepciones 
	 */
	
	public void setFechaRealizacion(String pfechaRealizacion) {
		fechaRealizacion = pfechaRealizacion;
	}
	
	/**Metodo para registrar la medicina recetada
	 *@param pmedicina: valor String que modifica la(s) medicina(s)
	 *@return no retorna ningun valor
	 *@exception no se manejan excepciones 
	 */
	
	public void setMedicina(String pmedicina) {
		medicina = pmedicina;
	}
	
	/**Metodo privado para registrar el numero del expediente
	 *@param pnumeroExpediente: valor String que modifica el numero de expediente
	 *@return no retorna ningun valor
	 *@exception no se manejan excepciones 
	 */
	
	private void setNumeroExpediente(String pnumeroExpediente) {
		numeroExpediente = pnumeroExpediente;
	}
	
	/**Metodo para obtener el estado del objeto
	 *@param no se requieren parametros
	 *@return mensaje que se encuentra almacenado
	 *@exception  no se manejan excepciones 	 
	 */
	
	@Override
	public String toString() {
		return "Consulta [id=" + id + ", idDoctor=" + idDoctor + ", fechaRealizacion=" + fechaRealizacion
				+ ", descripcion=" + descripcion + ", medicina=" + medicina + ", numeroExpediente=" + numeroExpediente
				+ "]";
	}
}
