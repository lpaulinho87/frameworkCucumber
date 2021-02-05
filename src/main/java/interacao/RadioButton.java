package interacao;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface RadioButton {
	public default void clicarRadio(By by) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		executor.executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(by)));
	}
	
	public default void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	
	public default boolean isRadioMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
}
