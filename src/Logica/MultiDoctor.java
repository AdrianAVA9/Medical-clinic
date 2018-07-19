package Logica;

import java.sql.SQLException;
import java.util.ArrayList;

import AccesoBD.Conector;
/**
 * 
 * @author Danilo Calderon,José Madrigal,Marvin Calvo y Adrain Vega
 *
 */
public class MultiDoctor {
	/**
	 * Metodo  que inserta al objecto Doctor a la base de datos.
	 * @param pidentificacion variable int que contiene la identificacion del Doctor
	 * @param pnombre variable String que contiene el nombre del Doctor
	 * @param pespcialidad variable String que contiene la especialidad del Doctor
	 * @param ptelefono variable String que contiene el telefono del doctor
	 * @throws Exception maneja excepciones
	 * @return no retorna nada.
	 */
	public void crearDoctor(int pidentificacion,String pnombre,String pespcialidad,int ptelefono)throws Exception{
		String sql;
		Doctor doctor =new Doctor(pidentificacion, pnombre, pespcialidad, ptelefono);
		sql = "INSERT INTO Doctor (identificacion,nombre,especialidad,telefono)"+
		"VALUES("+doctor.getIdentificacion()+",'"+doctor.getNombre()+"','"+doctor.getEspecialidad()+"',"+doctor.getTelefono()+");";
		
		try{
			
			Conector.getConector().ejecutarSQL(sql);
		}catch(Exception e){
			if(e.getMessage().equals("UCAExc:::3.0.7 integrity constraint violation: unique constraint or index violation; SYS_PK_10397 table: DOCTOR")){
				throw new Exception ("El medico ya existe en el sistema");
			}else{
				throw new Exception (e.getMessage());
			}
			
		}
	}
	/**
	 * Metodo que bsuca los objectos Doctores por medio de la varible pidentificacion que recibe por parametro 
	 * @param pidentificacion valor int que contiene la identificacion del Doctor
	 * @return una lista de los doctores que se encuentra almacenado en la base de datos
	 * @throws SQLException maneja excepciones
	 * @throws Exception  maneja excepciones
	 */
	public ArrayList<Doctor> buscarDoctoresPorIdentificacion(int pidentificacion) throws SQLException, Exception{
		
		Doctor doctor = null;
		ArrayList<Doctor>listaDoctores = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
		+ "FROM [Doctor]"
		+ "WHERE identificacion LIKE'%"+pidentificacion+"%';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		listaDoctores = new ArrayList<Doctor>();
			
		if (rs.next()) {
			do {
					
				doctor = new Doctor(rs.getInt("identificacion"),
			 	rs.getString("nombre"),
			 	rs.getString("especialidad"),
			 	rs.getInt("telefono"));
				listaDoctores.add(doctor);
					
			} while (rs.next());
				
		}
			
		rs.close();
		return listaDoctores;
	}
	/**
	 * Metodo que encarga de bsucar al doctor por medio de la identificacion
	 * @param pidentificacion varible int que contiene la identificacion del Doctor
	 * @return un objecto Doctor
	 * @throws SQLException  maneja excepciones
	 * @throws Exception  maneja excepciones
	 */
	public Doctor buscarDoctor(int pidentificacion) throws SQLException, Exception{
		
		Doctor doctor = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM [Doctor]"
			+ "WHERE identificacion="+pidentificacion+";";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
				doctor = new Doctor(rs.getInt("identificacion"),
				 rs.getString("nombre"),
				 rs.getString("especialidad"),
				 rs.getInt("telefono"));
		} 
		rs.close();
		return doctor;
	}
}
