import java.util.ArrayList;
import java.util.List;

public class VisualizadorDeMedia implements Observer {
    private List<Integer> valores;
    private boolean ativo;

    public VisualizadorDeMedia() {
        this.valores = new ArrayList<>();
        this.ativo = false;
    }

    @Override
    public void update(int novoValor) {
        if (ativo) {
            valores.add(novoValor);
            exibeMedia();
        }
    }

    public void ativar() {
        this.ativo = true;
        System.out.println("Visualizador de Média ATIVADO");
    }

    public void desativar() {
        this.ativo = false;
        System.out.println("Visualizador de Média DESATIVADO");
    }

    public boolean isAtivo() {
        return ativo;
    }

    private void exibeMedia() {
        double media = valores.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
        System.out.println("Média: " + String.format("%.2f", media) + 
                          ", quantidade de elementos analisados: " + valores.size());
    }
}