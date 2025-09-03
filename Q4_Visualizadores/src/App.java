import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var dados = new FonteDeDados();
        var visualizadorMedia = new VisualizadorDeMedia();
        var visualizadorSomatorio = new VisualizadorDeSomatorio();
        var visualizadorMaximo = new VisualizadorDeMaximo();

        // Registrar todos os observadores
        dados.adicionarObserver(visualizadorMedia);
        dados.adicionarObserver(visualizadorSomatorio);
        dados.adicionarObserver(visualizadorMaximo);

        Scanner s = new Scanner(System.in);
        
        System.out.println("=== Sistema de Visualização de Dados ===");
        System.out.println("Todos os visualizadores começam DESLIGADOS");
        exibirMenu();

        while (true) {
            System.out.print("\nEntre um valor positivo maior que zero (0=fim, negativo=menu): ");
            int valor = Integer.parseInt(s.nextLine());
            
            if (valor == 0) {
                break;
            } else if (valor < 0) {
                processarComandoMenu(valor, visualizadorMedia, visualizadorSomatorio, visualizadorMaximo);
            } else {
                try {
                    dados.add(valor);
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        
        System.out.println("Fim do programa!");
        s.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== COMANDOS DISPONÍVEIS ===");
        System.out.println("-1: Alternar Visualizador de Somatório");
        System.out.println("-2: Alternar Visualizador de Média");
        System.out.println("-3: Alternar Visualizador de Máximo");
        System.out.println("-9: Exibir este menu");
        System.out.println("Número positivo: Adicionar valor aos dados");
        System.out.println("0: Sair do programa");
    }

    private static void processarComandoMenu(int comando, 
                                           VisualizadorDeMedia vMedia,
                                           VisualizadorDeSomatorio vSomatorio, 
                                           VisualizadorDeMaximo vMaximo) {
        switch (comando) {
            case -1:
                if (vSomatorio.isAtivo()) {
                    vSomatorio.desativar();
                } else {
                    vSomatorio.ativar();
                }
                break;
            case -2:
                if (vMedia.isAtivo()) {
                    vMedia.desativar();
                } else {
                    vMedia.ativar();
                }
                break;
            case -3:
                if (vMaximo.isAtivo()) {
                    vMaximo.desativar();
                } else {
                    vMaximo.ativar();
                }
                break;
            case -9:
                exibirMenu();
                break;
            default:
                System.out.println("Comando inválido! Use -9 para ver o menu.");
        }
    }
}