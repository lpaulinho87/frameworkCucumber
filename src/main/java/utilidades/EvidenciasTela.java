package utilidades;

import static core.DriverFactory.getDriver;

import java.io.File;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class EvidenciasTela {

	static String caminhoTesteOK = System.getProperty("user.dir").concat(Configuracoes.getProperties()
			.getProperty("Screenshot.caminhoTesteOk").replace("/", File.separator));
	
	static String caminhoTesteFalha = System.getProperty("user.dir").concat(Configuracoes.getProperties()
			.getProperty("Screenshot.caminhoTesteFalha").replace("/", File.separator));
	
	public static void executarScreenShotTesteOK(boolean falha, String nomeCenario) {
		if (!falha) {
			executarScreenShot(false, nomeCenario);
		}
	}

	public static void executarScreenShotTesteFalha(boolean falha, String nomeCenario) {
		if (falha) {
			executarScreenShot(true, nomeCenario);
		}
	}

	static void executarScreenShot(boolean falha, String nomeCenario) {
		if (!falha) {
			tirarScreenshotWeb(caminhoTesteOK, nomeCenario);
		} else {
			tirarScreenshotWeb(caminhoTesteFalha, nomeCenario);
		}		
	}

	static void tirarScreenshotWeb(String caminhoDaImagem, String nomeCenario) {
		try {

			File caminhoDeCaptura = new File(caminhoDaImagem);
			caminhoDeCaptura.mkdirs();

			Shutterbug.shootPage(getDriver(), ScrollStrategy.WHOLE_PAGE_CHROME, 5000, true).withName(nomeCenario)
					.save(caminhoDaImagem);
		} catch (Exception e) {
			System.out.println("HOUVE UM ERRO PARA REALIZAR O PRINT");
		}
	}	

	public static void apagarScreenshots() {
		Gerais.excluirTodosArquivos(caminhoTesteOK);
		Gerais.excluirTodosArquivos(caminhoTesteFalha);
	}
}
