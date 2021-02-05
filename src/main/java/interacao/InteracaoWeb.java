package interacao;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public interface InteracaoWeb extends Click, CheckBox, ComboBox, Elemento,  
Frame, Janela, Navegacao, RadioButton, TextField {
	
	
	/********* TextField e TextArea ************/
	
	
	
	public default String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public default String obterValorCampo(By campo) {
		return getDriver().findElement(campo).getAttribute("value");
	}
			
	public default void mouseOn(By id) {		
		WebElement el = getDriver().findElement(id);
		Actions action = new Actions(getDriver());
		action.moveToElement(el).build().perform();
	}
	
	public default String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	public default String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public default String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

	/********* Alerts ************/
	
	public default String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public default String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;

	}
	
	public default String alertaObterTextoENega(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;

	}
	
	public default void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}

	/********* Frames e Janelas ************/
	
	
	
	
	/************** JS *********************/
	
	public default Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}

	/************** Tabela *********************/
	
	public default void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		celula.findElement(By.xpath(".//input")).click();

	}

	 default int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	default int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}
}
