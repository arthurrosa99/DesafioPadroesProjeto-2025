public class App {
    public static void main(String[] args) {
        String aux = "Socorro alguem me ajuda";

        // Cria o codificador com a estratégia SIMPLES
        Codificador cod = new Codificador(new CodificacaoSimples());

        System.out.println(aux);
        aux = cod.codifica(aux);
        System.out.println(aux);
        aux = cod.deCodifica(aux);
        System.out.println(aux);
    }
}
