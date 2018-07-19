package Logica;

/*Clase que se conecta con la base de datos
 *@author Marvin Calvo
 *@author Danilo Calderon
 *@authorJose Madrigal
 *@author Adrian Vega
 *@version v1.0 
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import AccesoBD.Conector;

public class MultiConsulta {
	
	/**Metodo que instancia objetos de tipo consulta y los registra en la base de datos
	 *@param pidDoctor: valor int que registra el id del doctor
	 *@param pfecha: valor String que registra la fecha de la consulta
	 *@pdescProblema: valor String que registra el motivo de la consulta
	 *@pmedRectadas: valor String que registra la(s) medicina(s) recetada(s)
	 *@pnumExpediente: valor String que registra el numero de expediente
	 *@return objeto Consulta que ha sido instanciado
	 *@exception no se manejan excepciones  
	 */
	
	public Consulta crearConsulta(int pidDoctor,String pfecha,String pdescProblema,String pmedRecetadas,String pnumExpediente) throws Exception{
		
		String query;
		Consulta consulta=null;
		ResultSet rs;
		int numConsulta;
			
		query="INSERT INTO"
				+ "[Consulta] (Iddoctor,fecharealizacion,descripcion,medicina,numeroexpediente) VALUES("
				+ "" + pidDoctor + ","
				+ "'" + pfecha + "',"
				+ "'" + pdescProblema + "',"
				+ "'" + pmedRecetadas + "'," 
				+ "'" + pnumExpediente + "');";
				
		Conector.getConector().ejecutarSQL(query);
		
		query="SELECT MAX(Id) AS [cantConsultas]"
				+ "FROM [Consulta];";

		rs=Conector.getConector().ejecutarSQL(query, true);
		
		if(rs.next()){
			numConsulta=rs.getInt("cantConsultas");
			new Consulta(numConsulta,pidDoctor, pfecha, pdescProblema, pmedRecetadas, pnumExpediente);
		}
		
		rs.close();
		return consulta;
	}
	
	/**Metodo que busca las consultas de un expediente en la base de datos
	 *@param pnumeroExpediente: valor String que contiene el numero de expediente
	 *@return lista de objetos Consulta que se encuentran almacenados
	 *@exception no se manejan excepciones
	 */

	 public ArrayList<Consulta> buscarConsultas (String pnumeroExpediente) throws SQLException, Exception{
			
			Consulta consulta = null;
			ArrayList<Consulta>listaConsultas = new ArrayList<Consulta>();
			java.sql.ResultSet rs;
			String sql;
			
			sql = "SELECT * "
			+ "FROM [Consulta]"
			+ "WHERE [numeroexpediente] = '"+pnumeroExpediente+"';";
			rs = Conector.getConector().ejecutarSQL(sql,true);
			
			 if(rs.next()){
				 
				 do{
					 
					 consulta = new Consulta(
					 rs.getInt("id"),
					 rs.getInt("iddoctor"),
					 rs.getString("fecharealizacion"),
					 rs.getString("descripcion") ,
					 rs.getString("medicina"),
					 rs.getString("numeroexpediente"));
					 listaConsultas.add(consulta);
				}while(rs.next());
						 
			 }
		rs.close();		 
		return listaConsultas;
	}
	 
	 /**Metodo que busca una consulta en la base de datos
	  *@param pidConsulta que contiene el id de la consulta
	  *@return objeto Consulta que se encuentra almacenado
	  *@exception no se manejan excepciones 
	  */
	 
	 public Consulta buscarConsulta(int pidConsulta) throws SQLException, Exception{
			
			Consulta consulta = null;
			ArrayList<Consulta>listaConsultas = new ArrayList<Consulta>();
			java.sql.ResultSet rs;
			String sql;
			
			sql = "SELECT * "
			+ "FROM [Consulta]"
			+ "WHERE [id] = '"+pidConsulta+"';";
			
			rs = Conector.getConector().ejecutarSQL(sql,true);
			
			 if(rs.next()){
				 
				 do{
					 
					 consulta = new Consulta(
					 rs.getInt("id"),
					 rs.getInt("iddoctor"),
					 rs.getString("fecharealizacion"),
					 rs.getString("descripcion") ,
					 rs.getString("medicina"),
					 rs.getString("numeroexpediente"));
					 listaConsultas.add(consulta);
				}while(rs.next());
						 
			 }
		rs.close();		 
		return consulta;
	} 
}
