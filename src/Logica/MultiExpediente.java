package Logica;

import java.sql.SQLException;

import AccesoBD.Conector;

/**
 * Es una clase encargada de comunicarse con el repositorio para la gestion de los datos de los   expedientes.
 * @author Marvin Calvo
 * @author Danilo Calderon
 * @author Adrian Vega
 * @author Jose Madrigal
 *
 */
public class MultiExpediente {
	/**
	 * Metodo con la responsabilida de obtener el utimo expediente registrado  en la entidad Expediente de la base datos BDConsultas.accdb.
	 * @param No se requieren parametros.
	 * @return La referencia a los datos del ultimo expediente registrado en el repositorio.
	 * @throws Exception Si se manejan excepciones pero se deja pasar.
	 */
	public Expediente obtenerUltimoExpedienteRegistrado()throws Exception{
		Expediente expediente =null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT TOP 1 * FROM [Expediente] ORDER BY numero DESC;";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()) {
			
			do {
				expediente=new Expediente(rs.getString("numero"),rs.getString("fechaApertura"),rs.getInt("idPaciente"));	
			} while (rs.next());
				
		} 
		rs.close();
		
		return expediente;
	}
	/**
	 * Metodo con la responsabilidad de registrar un expediente en la entidad Expediente de la base datos BDConsultas.accdb.
	 * @param pnumeroExpediente: Contiene un dato String que corresponde al numero de expedinte.
	 * @param pfechaApertura: Contiene un datos String que correponde a la fecha de apertura del expediente
	 * @param pcedula: Contiene la cedula del paciente al cual pertenece el expediente.
	 * @return La referencia a los datos del expediente que se registro. 
	 * @throws Exception Si se manejan excepciones .
	 */
	public void crearExpediente(String pnumeroExpediente,String pfechaApertura,int pcedula)throws Exception{
		String sql;
		try{
			sql ="INSERT INTO [Expediente](numero,fechaApertura,idPaciente)"+
			"VALUES('"+pnumeroExpediente+"','"+pfechaApertura+"',"+pcedula+");";
			
			Conector.getConector().ejecutarSQL(sql);
			
		}catch(Exception e){
			
			throw new Exception (e.getMessage());
			
		}
		
	}
	/**
	 * Metodo con la responsabilidad de buscar el registro de un expediente filtrandolo por su numero de expediente .
	 * @param pnumero: Contiene un datos String que corresponde al numero de expediente.
	 * @return La referencia a los datos del expedinte del cual se filtro en la entidad Expediente de la base datos BDConsultas.accdb.
	 * @throws SQLException Si se manejan.
	 * @throws Exception Si se manejan.
	 */
	public Expediente buscarExpedientePorNumeroExpediente(String pnumero) throws SQLException, Exception{
		
		Expediente expediente = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "
		+ "FROM [Expediente]"
		+ "WHERE numero='"+pnumero+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			expediente = new Expediente(rs.getString("numero"),
			rs.getString("fechaApertura"),
			rs.getInt("idPaciente"));
		} 
		rs.close();
		return expediente;
	}
	/**
	 * Metodo con la responsabilidad de buscar el registro de un expediente filtrandolo por el numero de cedula del paciente.
	 * @param pcedula: Contiene un valor int que corresponde al numero de cedula del paciente.
	 * @return La referencia a los datos del expedinte del cual se filtro en la entidad Expediente de la base datos BDConsultas.accdb.
	 * @throws SQLException Si se manejan.
	 * @throws Exception Si se manejan.
	 */
	public Expediente buscarExpedientePorCedula(int pcedula) throws SQLException, Exception{
		
		Expediente expediente = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "
		+ "FROM [Expediente]"
		+ "WHERE idPaciente="+pcedula+";";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			expediente = new Expediente(rs.getString("numero"),
			rs.getString("fechaApertura"),
			rs.getInt("idPaciente"));
		} 
		rs.close();
		return expediente;
	}	
}
