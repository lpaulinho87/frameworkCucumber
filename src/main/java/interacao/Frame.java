package interacao;

import static core.DriverFactory.getDriver;

public interface Frame {
	public default void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public default void sairFrame(){
		getDriver().switchTo().defaultContent();
	}

}
