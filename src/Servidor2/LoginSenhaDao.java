package Servidor2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class LoginSenhaDao {
	
	public boolean validaLoginEsenha(String login, String senha) throws SQLException{
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from usuarios where login = ? and senha = ?";
		PreparedStatement stm = conexao.prepareStatement(sql);
		stm.setString(1, login);
		stm.setString(2, senha);
		
		ResultSet result = stm.executeQuery();
		if(result.next()){
			return true;
		}else{
			return false;
		}
	}
	public boolean cadastrar(String login, String senha){
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "insert into usuarios values(?,?)";
		try{
		PreparedStatement stm = conexao.prepareStatement(sql);
		stm.setString(1, login);
		stm.setString(2, senha);
		stm.execute();
		}catch (PSQLException e) {
			return false;
} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		LoginSenhaDao x = new LoginSenhaDao();
		System.out.println(x.cadastrar("rogerio", "123"));
		 
	}
}
