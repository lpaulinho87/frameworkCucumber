package interacao;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public interface Click {

	public default void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
}