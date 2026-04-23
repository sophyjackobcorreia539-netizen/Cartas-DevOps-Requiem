package model;

import util.Cores;

public class Carta {
    private static int contador = 1;

    private int id;
    private String remetente;
    private String destinatario;
    private String tipo;
    private String conteudo;

    public Carta(String remetente, String destinatario, String tipo, String conteudo) {
        this.id = contador++;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public String formatarCarta() {
        String linha = Cores.AZUL + "=".repeat(50) + Cores.RESET;

        String emoji = switch (tipo) {
            case "Amor" -> "❤️";
            case "Amizade" -> "🤝";
            case "Desculpas" -> "🙏";
            case "Formal" -> "📄";
            case "Motivacional" -> "🔥";
            default -> "✉️";
        };

        return "\n" + linha +
                "\n" + Cores.NEGRITO + emoji + " CARTA #" + id + emoji + Cores.RESET +
                "\n" + linha +
                "\n" + Cores.AMARELO + "Tipo: " + tipo + Cores.RESET +
                "\n\n" + Cores.VERDE + "De: " + remetente +
                "\nPara: " + destinatario + Cores.RESET +
                "\n" + linha +
                "\n\n" + conteudo +
                "\n" + linha +
                "\n\n" + Cores.ROXO + "Com carinho,\n" + remetente + Cores.RESET +
                "\n" + linha + "\n\n";
    }

    public String getRemetente() { return remetente; }
    public String getTipo() { return tipo; }
}
