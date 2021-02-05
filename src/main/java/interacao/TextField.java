package interacao;

import static core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface TextField {
	public default void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public default void escreveSlow(By campo, String texto) {
		WebElement txtValor = getDriver().findElement(campo);
		List<String> list = Arrays.asList(texto.split(""));
		list.forEach(f -> txtValor.sendKeys(f));
	}
}