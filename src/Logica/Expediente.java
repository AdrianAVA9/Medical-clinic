package Logica;

import java.util.ArrayList;
/***
 * Es una clase que simula un expediente donde se almacena la informacion de un paciente y sus consultas.
 * @author Danilo Calderon
 * @author Marvin Calvo
 * @author Adrian Vega
 * @author Jose Madrigal
 */
public class Expediente {
	private String numero;
	private String fechaApertura;
	private int idPaciente;
	private Paciente paciente;
	private ArrayList<Consulta>listaConsultas;
	private Consulta consulta;
	
	/**
	 * Metodo constructor  del objeto Expediente
	 * @param pnumero: Valor String que incializa el numero de expediente.
	 * @param pfechaApertura: Valor String que inicializa la fecha de apertura del expediente
	 * @param pidPaciente: Valor int que inicialza el id del paciente al cual le pertenece el expediente
	 */
	public Expediente(String pnumero,String pfechaApertura, int pidPaciente) {
		
		setFechaApertura(pfechaApertura);
		setIdPaciente(pidPaciente);
		setNumero(pnumero);
		listaConsultas=null;
		paciente=null;
		consulta=null;
	}
	/**
	 * Metodo para obtener el numero de expediente .
	 * @param No requiere parametros.
	 * @return El dato String almacenado en el atributo numero del objeto.
	 * @exception No se manejan excepciones.
	 */
	public String getNumero() {
		return numero;
	}
	public String getFechaApertura() {
		return fechaApertura;
	}
	/**
	 * Metodo para obtener el id del paciente.
	 * @param No requiere parametros.
	 * @return El dato int almacenado en el atributo idPaciente.
	 * @exception No se manejan excepciones
	 */
	public int getIdPaciente() {
		return idPaciente;
	}
	/**
	 * Metodo que almacena el numero de expediente en el atributo numero.
	 * @param pnumero: Contiene un dato String que sobre escribe o inicializa  el dato  del atributo numero;
	 * @return No retorna ningun valor.
	 * @exception No se manejan excepciones. 
	 */
	private  void setNumero(String pnumero) {
		numero = pnumero;
	}
	/**
	 * Metodo que almacena la fecha de apertura del expediente en el atributo fechaApertura.
	 * @param pfechaApertura: Contiene un dato String que sobre escribe o inicializa el atributo fechaApertura.
	 * @return No retorna ningun valor.
	 * @exception No se manejan excepciones.
	 */
	public void setFechaApertura(String pfechaApertura) {
		fechaApertura = pfechaApertura;
	}
	/**
	 * Metodo que almacena la cedula  del paciente en el atributo idPaciente.
	 * @param pidPaciente: Contiene un valor int que sobre escribe o inicializa el atributo idPaciente.
	 * @return No retorna ningun valor.
	 * @exception No se manejan excepciones.  
	 */
	
	private void setIdPaciente(int pidPaciente) {
		idPaciente = pidPaciente;
	}
	/**
	 * Metodo que almacena las consultas del paciente en el atributo listaConsultas.
	 * @param pidDoctor:Contiene una valor int que corresponde la identificacion del doctor que atendio la consulta.
	 * @param pfechaRealizacion: Contiene una dato String que corresponde a la fecha en que se realizo la consulta.
	 * @param pdescripcion: Contiene un dato String que corresponde a la descripción del problema por el cual el paciente consulta al doctor.
	 * @param pmedicina: Contiene un dato String que corresponde a las medicina que el doctor le receto al paciente para alivial su mal.
	 * @throws Exception Si se manejan excepciones pero se deja pasar.
	 */
	public void setConsulta( int pidDoctor, String pfechaRealizacion, String pdescripcion, String pmedicina)throws Exception{
		
		consulta=new MultiConsulta().crearConsulta(pidDoctor, pfechaRealizacion, pdescripcion, pmedicina, getNumero());
		listaConsultas=getConsultas();
		listaConsultas.add(consulta);
		
	}
/**
 * Metodo para obtener la listas de las consultas del expediente o paciente.
 * @param No se requieren parametros.
 * @return La referencia a un ArrayList que contiene todas las referencias alos datos  de las consultas relacionas al expediente.
 * @throws Exception Si se manejan excepciones pero se deja pasar.
 */
	public ArrayList<Consulta> getConsultas()throws Exception{
		if(listaConsultas==null){
			MultiConsulta multiConsulta=new MultiConsulta();
			listaConsultas=multiConsulta.buscarConsultas(getNumero());
			
		}
		
		return listaConsultas;
	}
	/**
	 * Metodo que retorna la referenacia a los datos del paciente el cual pertenece el expedinete.
	 * @param No requiere parametros.
	 * @return La referencia a los datos del paciente.
	 * @throws Exception Si se manejan excepciones pero se deja pasar.
	 */
	public Paciente getPaciente()throws Exception{
		if(paciente==null){
			MultiPaciente multiPaciente=new MultiPaciente();
			paciente=multiPaciente.buscarPaciente(getIdPaciente());
			
		}
		
		return paciente;
	}
	/**
	 * Metodo  encargado de comunicarse con  la clase  multiPaciente para que almecene los datos del paciente en la base de datos.
	 * @param pcedula:Contiene una valor int que corresponde a l cedula del paciente.
	 * @param pnombre:Contiene un dato String que corresponde a el nombre del paciente.
	 * @param pdireccion:Contiene un dato String que corresponde a la dirección del paciente. 
	 * @param ptelefono:Contiene un valor int que corresponde al numero de telefono del paciente.
	 * @param pfechaNacimiento:Contiene un  datos String que corresponde a la fecha de nacimiento del paciente.
	 * @param pedad:Contiene un valor int que corresponde a la edad del paciente.
	 * @throws Exception Si se manejan excepciones pero se deja pasar.
	 */
	public void crearPaciente(int pcedula, String pnombre, String pdireccion, int ptelefono, String pfechaNacimiento, int pedad)throws Exception{
		MultiPaciente multiPaciente=new MultiPaciente();
		multiPaciente.crearPaciente(pcedula, pnombre, pdireccion, ptelefono, pfechaNacimiento, pedad);
	}
	
	/**
	 * Metodo que retorna la referenacia a los datos de una consulta que pertenece al expediente.
	 * @param pidConsulta:Contiene un valor int que correponde al id de la consulta.
	 * @return La referencia a los datos de una consulta especifica.
	 * @throws Exception Si se manejan excepciones pero se deja pasar.
	 */
	public Consulta obtenerUnaConsulta(int pidConsulta)throws Exception{
		Consulta consulta=null;
		boolean encontrado=false;
		for(int i=0;i<getConsultas().size()&&encontrado==false;i++){
			if(getConsultas().get(i).getId()==pidConsulta){
				consulta=getConsultas().get(i);
				encontrado=true;
			}
		}
		return consulta;
	}
	/**
	 * Metodo para obtener el estado del objeto expediente.
	 * @param No requiere parametros.
	 * @return Un  dato String que corresponde al estado del objeto.
	 * @exception No se manejan excepciones.
	 */
	@Override
	public String toString() {
		return "Expediente [numero=" + numero + ", fechaApertura=" + fechaApertura + ", idPaciente=" + idPaciente + "]";
	}
}
