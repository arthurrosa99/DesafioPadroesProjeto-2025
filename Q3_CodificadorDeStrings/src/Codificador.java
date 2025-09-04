public class Codificador {
    private Strategy estrategia;

    public Codificador(Strategy estrategia) {
        this.estrategia = estrategia;
    }

    public String codifica(String str) {
        return estrategia.codificar(str);
    }

    public String deCodifica(String str) {
        return estrategia.decodificar(str);
    }

    public void setEstrategia(Strategy estrategia) {
        this.estrategia = estrategia;
    }
}
