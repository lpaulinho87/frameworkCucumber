package utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracoes {

	public static Properties getProperties() {
		Properties prop = new Properties();
		String caminho = "src/test/resources/configuracoes/configuracoesGerais.properties";
		try {
			FileInputStream file = new FileInputStream(caminho);
			prop.load(file);
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Não foi possível realizar a leitura de " + caminho);
		}
	}

}
