package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import core.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import utilidades.EvidenciasTela;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", 		
		glue = "",
		tags = "@login",
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary",
					"json:test-output/json/report.json", }, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		dryRun = false, 
		strict = true
		)
public class CucumberRunnerTest {
	
	@BeforeClass
	public static void configurarRunner() {
		EvidenciasTela.apagarScreenshots();
	}
	
	@AfterClass
	public static void finalizarRunner() {
//		DriverFactory.killDriver();
	}
}