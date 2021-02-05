package interacao;

import static core.DriverFactory.getDriver;
import static utilidades.Configuracoes.getProperties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public interface Elemento {
	public default Boolean elementoExiste(By by, Long timeout) {
		getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		Boolean isPresent = getDriver().findElements(by).size() > 0;
		getDriver().manage().timeouts().implicitlyWait(
				Long.parseLong(getProperties().getProperty("TimeoutImplicitlyWait")), TimeUnit.SECONDS);
		return isPresent;
	}
}
