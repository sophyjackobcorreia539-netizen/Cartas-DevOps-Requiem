package util;

import java.io.FileWriter;
import java.io.IOException;

public class ArquivoUtil {

    public static void salvar(String caminho, String texto){
        try (FileWriter writer = new FileWriter(caminho, true)){
            writer.write(texto);

        } catch (IOException e){
            System.out.print("Erro ao salvar arquivo!");
        }
    }
}
