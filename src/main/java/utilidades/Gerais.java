package utilidades;

import java.io.File;
import java.util.Arrays;

public class Gerais {
	public static void excluirTodosArquivos(String caminho) {
		try {
			File file = new File(caminho);
			if (file.listFiles().length > 0) {
				Arrays.stream(file.listFiles()).forEach(File::delete);
			}
		} catch (Exception e) {
			System.out.println("Não foi possível excluir os arquivos");
		}
	}
}
