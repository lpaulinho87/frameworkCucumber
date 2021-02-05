package hooks;

import core.DriverFactory;
import utilidades.EvidenciasTela;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class HookAfter {

	@After
	public void finalizar(Scenario cenario) {
		EvidenciasTela.executarScreenShotTesteFalha(cenario.isFailed(), cenario.getName());
		DriverFactory.killDriver();
	}
}
