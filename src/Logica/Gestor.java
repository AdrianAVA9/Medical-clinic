package Logica;

import java.util.ArrayList;


    /**
	 * @author Danilo Calderon
	 * @author Marvin Calvo
	 * @author Adrian Vega
	 * @author Jose Madrigal
	 * @version v1.0
 	 **/
public class Gestor {
	
	
	/**
	 *Metodo para registrar un doctor
	 *@param pidentificacion valor entero id del doctor
	 *@param pnombre valor String nombre del doctor
	 *@param pespecialidad valor String especialidad de un doctor
	 *@param ptelefono valor entero telefono del doctor
	 *@return no
	 *@exception no
	 **/
	public void registrarDoctor(int pidentificacion,String pnombre,String pespcialidad,int ptelefono)throws Exception{
		
		MultiDoctor multiDoctor=new MultiDoctor();
		multiDoctor.crearDoctor(pidentificacion, pnombre, pespcialidad, ptelefono);
		
	}
	
	/**
	 *Metodo para buscar doctores que esten relacionados co ese identificacion 
	 *@param pidentificacion valor entero id del doctor
	 *@return String[][] datos de los doctores
	 *@exception no
	 **/
	public String[][] buscarDoctoresPorID(int pidentificacionb) throws Exception{
		
		String[][]infoDoctores;
		ArrayList<Doctor>listaDoctores;
		
		listaDoctores = (new MultiDoctor()).buscarDoctoresPorIdentificacion(pidentificacionb);
		
		infoDoctores = new String[listaDoctores.size()][4];
		
		for(int i=0; i < listaDoctores.size();i++){
			
			infoDoctores[i][0] =""+listaDoctores.get(i).getIdentificacion();
			infoDoctores[i][1] = listaDoctores.get(i).getNombre();
			infoDoctores[i][2] = listaDoctores.get(i).getEspecialidad();
			infoDoctores[i][3] = ""+listaDoctores.get(i).getTelefono();
			
		}
		
		return infoDoctores;
	}
	
	/**
	 *Metodo que busca un los datos de un expediente por el numero de cedula de un paciente
	 *@param pcedula valor entero id del paciente
	 *@return String[] datos de un expedeinte
	 *@exception si
	 **/
	public String[] buscarExpedientePorCedula(int pcedula)throws Exception{
		
		String[]listaDatosExpediente=new String[4];
		Expediente expediente=null;
		MultiExpediente multiExpediente=new MultiExpediente();
	
			try {
				expediente=multiExpediente.buscarExpedientePorCedula(pcedula);
				listaDatosExpediente[0]=""+expediente.getNumero();
				listaDatosExpediente[1]=""+expediente.getIdPaciente();
				listaDatosExpediente[2]=""+expediente.getFechaApertura();
			} catch (Exception e) {
				throw new Exception("Expediente no registrado");
			}
					
		return listaDatosExpediente;
	}
	
	/**
	 *Metodo que busca un los datos se un expediente por el numero de expediente
	 *@param pcedula valor String numero del expediente
	 *@return String[] datos de un expedeinte
	 *@exception si
	 **/
	public String[] buscarExpedientePorNumeroExpediente(String pnumero)throws Exception{
		String[]listaDatosExpediente=new String[4];
		Expediente expediente=null;
		MultiExpediente multiExpediente=new MultiExpediente();
	
			try {
				expediente=multiExpediente.buscarExpedientePorNumeroExpediente(pnumero);
				listaDatosExpediente[0]=""+expediente.getNumero();
				listaDatosExpediente[1]=""+expediente.getIdPaciente();
				listaDatosExpediente[2]=""+expediente.getFechaApertura();
			} catch (Exception e) {
				throw new Exception("Expediente no registrado");		
			}
		
		return listaDatosExpediente;
	}
	
	/**
	 *Metodo que busca los datos de un paciente por el numero de expediente
	 *@param pcedula valor String numero del expediente
	 *@return String[] datos de un expedeinte
	 *@exception si
	 **/
	public String[] buscarDatosPacientePorExpediente(String pnumero)throws Exception{
		String[]listaDatosPaciente=new String[6];
		Expediente expediente;
		Paciente paciente;
		MultiExpediente multiExpediente=new MultiExpediente();
		
			expediente=multiExpediente.buscarExpedientePorNumeroExpediente(pnumero);
			paciente=expediente.getPaciente();
			listaDatosPaciente[0]=""+paciente.getCedula();
			listaDatosPaciente[1]=paciente.getNombre();
			listaDatosPaciente[2]=paciente.getFechaNacimiento();
			listaDatosPaciente[3]=""+paciente.getEdad();
			listaDatosPaciente[4]=""+paciente.getTelefono();
			listaDatosPaciente[5]=paciente.getDireccion();
	
		return listaDatosPaciente;
	}
	
	/**
	 *Metodo que busca las consultas de un expediente
	 *@param pcedula valor String numero del expediente
	 *@return String[][] datos de las consultas
	 *@exception si
	 **/
	public String[][] buscarConsultasDeUnExpediente(String pnumeroExpediente){
		String[][] listaDatosConsultas=null;
		ArrayList<Consulta>listaConsultas;
		Expediente expediente=null;
			try {
			MultiExpediente multiExpediente=new MultiExpediente();
			expediente=multiExpediente.buscarExpedientePorNumeroExpediente(pnumeroExpediente);
			listaConsultas=expediente.getConsultas();
			listaDatosConsultas=new String[listaConsultas.size()][6];
			for(int i=0;i<listaConsultas.size();i++){
				
				listaDatosConsultas[i][0]=""+listaConsultas.get(i).getId();
				listaDatosConsultas[i][1]=""+listaConsultas.get(i).getNumeroExpediente();
				listaDatosConsultas[i][2]=""+listaConsultas.get(i).getIdDoctor();
				listaDatosConsultas[i][3]=listaConsultas.get(i).getFechaRealizacion();
				listaDatosConsultas[i][4]=listaConsultas.get(i).getDescripcion();
				listaDatosConsultas[i][5]=listaConsultas.get(i).getMedicina();
				
			}
		} catch (Exception e) {}
		
		return listaDatosConsultas;
	}
	
	/**
	 *Metodo que busca un doctor por medio de una consulta
	 *@param pcedula valor String numero del expediente
	 *@return String[] datos de un expedeinte
	 *@exception no
	 **/
	public String[] buscarDoctorDeUnaConsulta(int pidConsulta,String numeroExpediente)throws Exception{
		String[] listaDatosDoctor=new String[4];
		Doctor doctor;
		MultiExpediente multiExpediente=new MultiExpediente();
		Expediente expediente=multiExpediente.buscarExpedientePorNumeroExpediente(numeroExpediente);
		Consulta consulta = expediente.obtenerUnaConsulta(pidConsulta);
		doctor=consulta.getDoctor();
		listaDatosDoctor[0]=""+doctor.getIdentificacion();
		listaDatosDoctor[1]=doctor.getNombre();
		listaDatosDoctor[2]=doctor.getEspecialidad();
		listaDatosDoctor[3]=""+doctor.getTelefono();
		return listaDatosDoctor;
	}
	
	/**
	 *Metodo que busca a un doctor por el numero de identificacion
	 *@param pidentificacion valor entero numero de identificacion
	 *@return String[] datos de un expedeinte
	 *@exception no
	 **/
	public Doctor buscarDoctor(int pidentificacion) throws Exception{
		MultiDoctor multiDoctor=new MultiDoctor();
		Doctor doctor=multiDoctor.buscarDoctor(pidentificacion);
	
		return doctor;
	}
	
	/**
	 *Metodo para registrar un expediente
	 *@param pfechaApertura valor String fecha en que se abre el expediente
	 *@param pcedula valor entero cedula del paciente
	 *@param pnombre valor String nombre del paciente
	 *@param pdireccion valor String direccion del paciente
	 *@paran ptelefono valor int telefono del paciente
	 *@param pfechaNacimiento valor String fecha nacimiento del paciente
	 *@param pedad valor entero edad del paciente
	 *@return no
	 *@exception si
	 **/
	public void crearExpediente(String pfechaApertura,int pcedula, String pnombre, String pdireccion, int ptelefono, String pfechaNacimiento, int pedad) throws java.sql.SQLException,Exception{
		MultiExpediente multiExpediente=new MultiExpediente();
		Expediente expediente;
		try {
			expediente=multiExpediente.obtenerUltimoExpedienteRegistrado();
			expediente=new Expediente("CSM-"+(obtenerIdDelExpediente(expediente)+1),pfechaApertura,pcedula);
		} catch (Exception e) {
			expediente=new Expediente("CSM-1",pfechaApertura,pcedula);
		}
		expediente.crearPaciente(pcedula, pnombre, pdireccion, ptelefono, pfechaNacimiento, pedad);
		multiExpediente.crearExpediente(expediente.getNumero(),pfechaApertura, pcedula);	
	}
	
	
	/**
	 *Metodo que obiene el id de un expediente
	 *@param pexpediente tipo Expediente 
	 *@return int id del expediente
	 *@exception no
	 **/
	private int obtenerIdDelExpediente(Expediente pexpediente){
		String numeroExp=pexpediente.getNumero();
		String id="";
		boolean siExtraer=false;
		for(int i=0;i<numeroExp.length();i++){
			if(numeroExp.charAt(i)=='-'||siExtraer){
				siExtraer=true;
				if(numeroExp.charAt(i)!='-'){
					id=id+numeroExp.charAt(i);
				}
			}
		}
		return Integer.parseInt(id);
	}
	
	
	/**
	 *Metodo para registrar una consulta
	 *@param idDoctor valor entero identificacion de un doctor
	 *@param pfechaRealizacion valor String fecha en que se hace una consulta
	 *@param pdescripcion valor String especifica las enfermedades del paciente
	 *@param pmedicina valor String medicina recetada por un doctor
	 *@param pnumeroExpediente valor String numero de un expediente donde se almacenara la consulta
	 *@return no
	 *@exception no
	 **/
	public void registraConsulta( int pidDoctor, String pfechaRealizacion, String pdescripcion, String pmedicina,
	String pnumeroExpediente)throws Exception{
		
		Expediente expediente=new MultiExpediente().buscarExpedientePorNumeroExpediente(pnumeroExpediente);
		expediente.setConsulta(pidDoctor, pfechaRealizacion, pdescripcion, pmedicina);
	}
}
