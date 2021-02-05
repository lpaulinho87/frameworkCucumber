package interacao;

import static core.DriverFactory.getDriver;

public interface Navegacao {
	public default void irUrl(String url) {
		getDriver().get(url);
	}
	
}
