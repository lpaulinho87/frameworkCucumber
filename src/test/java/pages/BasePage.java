package pages;

import org.openqa.selenium.By;

import assertcustom.AssertionsCustom;
import interacao.Interacao;
import interacao.InteracaoWeb;

public class BasePage {

	protected InteracaoWeb interacao;

	public BasePage() {
		interacao = (InteracaoWeb) new Interacao();
	}

	public void pressionarOBotaoExcluir() {
		interacao.clicarBotao(By.id("MainContent_btnExcluir"));
		interacao.clicarBotao(By.id("MainContent_btnExclui"));
		interacao.clicarBotao(By.id("MainContent_btnVoltaPosExclusao"));
	}

	public void realizarLogoff() {
		By btnSair = By.xpath("//*[@id=\"NavigationMenu\"]//a[.='Sair']");
		interacao.clicarBotao(btnSair);
		By btnEntrar = By.id("btnEntrar");
		String msgLida = interacao.obterValorCampo(btnEntrar);
		AssertionsCustom.myAssertEquals("Mensagem Senha", "Entrar", msgLida);
	}

	public void clicarNoBotao(String botao) {
		By btn = By.xpath("//button[.='"+botao+"']");
		interacao.clicarBotao(btn);		
	}

	public void exibeMensagem(String mensagem) {
		By lblMensagem = By.xpath("//span[contains(@id,'lblMensagem')]");
		String mensagemLida;
		mensagemLida = interacao.obterTexto(lblMensagem);
		AssertionsCustom.myAssertEquals("Mensagem",mensagem, mensagemLida);		
	}	

}