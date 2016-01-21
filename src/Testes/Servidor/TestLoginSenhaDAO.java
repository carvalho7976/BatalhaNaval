package Testes.Servidor;


import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import Servidor2.LoginSenhaDao;

public class TestLoginSenhaDAO {

	@Test
	public void esperaTrueParaUsuarioCadastrado() throws SQLException {
		LoginSenhaDao login = new LoginSenhaDao();
		assertEquals(true, login.validaLoginEsenha("leuson", "123"));
	}
	
	@Test
	public void esperaFalseParaUsuarioCadastrado() throws SQLException {
		LoginSenhaDao login = new LoginSenhaDao();
		assertEquals(false, login.validaLoginEsenha("leuson", "1235"));
	}
	
	@Test
	public void esperaTrueParaCadastrarUsuarioComLoginUnico() throws SQLException {
		LoginSenhaDao login = new LoginSenhaDao();
		assertEquals(true, login.cadastrar("maria", "123"));
	}
	
	@Test
	public void esperaFalseParaCadastrarUsuarioSemLoginUnico() throws SQLException {
		LoginSenhaDao login = new LoginSenhaDao();
		assertEquals(false, login.cadastrar("leuson", "123123"));
	}

}
