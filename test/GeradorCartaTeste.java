import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import service.GeradorCarta;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.StringReader;

public class GeradorCartaTeste {

    // Método auxiliar para chamar o private lerMultilinha(), espero que dê problema.
    private String executarLerMultilinha(String entrada) throws Exception {
        Scanner sc = new Scanner(new StringReader(entrada));

        Method metodo = GeradorCarta.class.getDeclaredMethod("lerMultilinha", Scanner.class);
        metodo.setAccessible(true);

        return (String) metodo.invoke(null, sc);
    }

    @Test
    public void deveLerTextoAteEncontrarFIM() throws Exception {
        String entrada = """
                Olá
                Tudo bem?
                FIM
                """;

        String resultado = executarLerMultilinha(entrada);

        assertEquals("Olá\nTudo bem?\n", resultado);
    }

    @Test
    public void deveRetornarVazioQuandoDigitarFIMImediatamente() throws Exception {
        String entrada = """
                FIM
                """;

        String resultado = executarLerMultilinha(entrada);

        assertEquals("", resultado);
    }

    @Test
    public void deveIgnorarTextoAposFIM() throws Exception {
        String entrada = """
                Primeira linha
                FIM
                Isso não deve entrar
                """;

        String resultado = executarLerMultilinha(entrada);

        assertEquals("Primeira linha\n", resultado);
    }
}