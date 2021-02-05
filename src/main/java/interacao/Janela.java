package interacao;

import static core.DriverFactory.getDriver;

public interface Janela {
	public default void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
}
