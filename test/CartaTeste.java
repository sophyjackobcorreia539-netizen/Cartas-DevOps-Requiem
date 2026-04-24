import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Carta;

public class CartaTeste {

    @Test
    public void deveCriarCartaComRemetenteCorreto() {
        Carta carta = new Carta("Sophia", "Ana", "Amor", "Você é especial.");

        assertEquals("Sophia", carta.getRemetente());
    }

    @Test
    public void deveCriarCartaComTipoCorreto() {
        Carta carta = new Carta("Lucas", "Maria", "Formal", "Prezada senhora.");

        assertEquals("Formal", carta.getTipo());
    }

    @Test
    public void deveFormatarCartaComTipoAmor() {
        Carta carta = new Carta("João", "Clara", "Amor", "Te admiro muito.");

        String resultado = carta.formatarCarta();

        assertTrue(resultado.contains("❤️"));
        assertTrue(resultado.contains("Tipo: Amor"));
    }

    @Test
    public void deveFormatarCartaComTipoFormal() {
        Carta carta = new Carta("Empresa", "Cliente", "Formal", "Prezados.");

        String resultado = carta.formatarCarta();

        assertTrue(resultado.contains("📄"));
        assertTrue(resultado.contains("Tipo: Formal"));
    }

    @Test
    public void deveFormatarCartaComTipoDesconhecido() {
        Carta carta = new Carta("Teste", "Destino", "Aleatório", "Conteúdo qualquer.");

        String resultado = carta.formatarCarta();

        assertTrue(resultado.contains("✉️"));
    }

    @Test
    public void deveConterRemetenteEDestinatarioNaFormatacao() {
        Carta carta = new Carta("Sophia", "Professor", "Motivacional", "Continue firme.");

        String resultado = carta.formatarCarta();

        assertTrue(resultado.contains("De: Sophia"));
        assertTrue(resultado.contains("Para: Professor"));
    }
}
