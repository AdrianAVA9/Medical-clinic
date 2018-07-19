package Logica;

import java.sql.SQLException;

import AccesoBD.Conector;

	/**
	 * @author Danilo Calderon
	 * @author Marvin Calvo
	 * @author Adrian Vega
	 * @author Jose Madrigal
	 * @version v1.0
 	 **/
public class MultiPaciente {
	
	/**
   	* Método para buscar y levantar un paciente por la cedula
   	* @param pcedula tipo Int cedula del paciente
   	* @return Un objeto Paciente 
   	* @exception no
   	*/
   	
	public Paciente buscarPaciente(int pcedula) throws SQLException, Exception{
		
		Paciente paciente = null;
		java.sql.ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM [Paciente]"
			+ "WHERE cedula="+pcedula+";";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			paciente = new Paciente(rs.getInt("cedula"),
			rs.getString("nombre"),
			rs.getString("direccion"),
		    rs.getInt("telefono"),
		    rs.getString("fechanacimiento"),
		    rs.getInt("edad"));
		} 
		rs.close();
		return paciente;
	}
	
	/**
   	*Método para almacenar los datos de un paciente en le sistema
   	*@param pcedula valor entero cedula del paciente
   	*@param pnombre valor String nombre del paciente
   	*@param pdireccion valor String direccion del paciente
   	*@paran ptelefono valor int telefono del paciente
	*@param pfechaNacimiento valor String fecha nacimiento del paciente
	*@param pedad valor entero edad del paciente
   	*@return Un objeto Paciente 
   	*@exception si
   	*/
	public void crearPaciente(int pcedula, String pnombre, String pdireccion, int ptelefono, String pfechaNacimiento, int pedad)throws Exception{
		String sql;
		sql = "INSERT INTO Paciente (cedula,nombre,direccion,telefono,fechanacimiento,edad)"+
		"VALUES("+pcedula+",'"+pnombre+"','"+pdireccion+"',"+ptelefono+",'"+pfechaNacimiento+"',"+pedad+");";
		
		try{
			
			Conector.getConector().ejecutarSQL(sql);
		}catch(Exception e){
			if(e.getMessage().equals("UCAExc:::3.0.7 integrity constraint violation: unique constraint or index violation; SYS_PK_10407 table: PACIENTE")){
				throw new Exception ("El paciente ya existe en el sistema");
			}else{
				throw new Exception (e.getMessage());
			}
			
			
		}
	}
}
