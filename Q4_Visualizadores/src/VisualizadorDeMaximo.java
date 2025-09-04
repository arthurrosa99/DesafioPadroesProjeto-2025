import java.util.ArrayList;
import java.util.List;

public class VisualizadorDeMaximo implements Observer {
    private List<Integer> valores;
    private boolean ativo;

    public VisualizadorDeMaximo() {
        this.valores = new ArrayList<>();
        this.ativo = false;
    }

    @Override
    public void update(int novoValor) {
        if (ativo) {
            valores.add(novoValor);
            exibeMaximo();
        }
    }

    public void ativar() {
        this.ativo = true;
        System.out.println("Visualizador de Máximo ATIVADO");
    }

    public void desativar() {
        this.ativo = false;
        System.out.println("Visualizador de Máximo DESATIVADO");
    }

    public boolean isAtivo() {
        return ativo;
    }

    private void exibeMaximo() {
        int maximo = valores.stream()
            .mapToInt(Integer::intValue)
            .max()
            .orElse(0);
        System.out.println("Valor Máximo: " + maximo + 
                          ", quantidade de elementos analisados: " + valores.size());
    }
}
