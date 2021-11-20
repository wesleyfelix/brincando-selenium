package email;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() throws InterruptedException {
	
		paginaDeLogin.preencheFormularioDeLogin("selenium_testes@outlook.com", "123mudar");
		Assertions.assertTrue(paginaDeLogin.seLogou());
		
	}

}
