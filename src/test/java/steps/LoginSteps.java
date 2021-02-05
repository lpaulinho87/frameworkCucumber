package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	
	LoginPage loginPage = new LoginPage();
	
	@Given("eu acesso o site seu barriga")
	public void euAcessoOSiteSeuBarriga() {
		loginPage.euAcessoOSiteSeuBarriga();
	}

	@When("insiro {string} e {string}")
	public void insiroE(String usuario, String senha) {
	   loginPage.insiroE(usuario, senha);
	}
	@When("clico no botao {string}")
	public void clicoNoBotao(String botao) {
	    loginPage.clicarNoBotao(botao);
	}
	@Then("exibe a mensagem: {string}")
	public void exibeAMensagem(String mensagem) {
	    loginPage.exibeAMensagem(mensagem);
	}

}
