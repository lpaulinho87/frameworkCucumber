package pages;

import org.openqa.selenium.By;

import assertcustom.AssertionsCustom;

public class LoginPage extends BasePage {
	
	public void euAcessoOSiteSeuBarriga() {
		interacao.irUrl("https://seubarriga.wcaquino.me/");
	}
	
	public void insiroE(String usuario, String senha) {
		interacao.escrever(By.id("email"), usuario);
		interacao.escrever(By.id("senha"), senha);
	}
	
	public void clicoNoBotao(String botao) {
		clicarNoBotao(botao);
	}
	
	public void exibeAMensagem(String mensagem) {
		String msgLida = interacao.obterTexto(By.xpath("//div[contains(@class, 'alert')]"));
		AssertionsCustom.myAssertEquals("Status login", mensagem, msgLida);
	}

}
