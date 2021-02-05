package interacao;

import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public interface CheckBox {
	public default void marcarCheck(By by) {
		if (!isCheckMarcado(by)) 
			getDriver().findElement(by).click();
	}

	public default void desmarcarCheck(By by) {
		if (isCheckMarcado(by)) 
			getDriver().findElement(by).click();
	}

	public default boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).isSelected();
	}
}
