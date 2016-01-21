package Servidor2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection(){
		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/batalhaNaval", "postgres","1234");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception{
	
	close(conn, stmt, rs);
	}
	public static void closeConnection(Connection conn, Statement stmt) throws Exception	{
	close(conn, stmt, null);
	}
	public static void closeConnection(Connection conn) throws Exception	{
	close(conn,null,null);
	}
	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception
	{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
		throw new Exception(e.getMessage());
			}
	}
}
