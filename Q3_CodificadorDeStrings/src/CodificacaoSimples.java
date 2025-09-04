import java.util.HashMap;
import java.util.Map;

public class CodificacaoSimples implements Strategy {
    private Map<Character, Character> tabCod;
    private Map<Character, Character> tabDeCod;

    public CodificacaoSimples() {
        tabCod = new HashMap<>();
        tabCod.put('a', '@');
        tabCod.put('e', '#');
        tabCod.put('i', '!');
        tabCod.put('o', '$');
        tabCod.put('u', '%');

        tabDeCod = new HashMap<>();
        tabDeCod.put('@', 'a');
        tabDeCod.put('#', 'e');
        tabDeCod.put('!', 'i');
        tabDeCod.put('$', 'o');
        tabDeCod.put('%', 'u');
    }

    @Override
    public String codificar(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for (int i = 0; i < aux.length; i++) {
            resp[i] = tabCod.getOrDefault(aux[i], aux[i]);
        }
        return new String(resp);
    }

    @Override
    public String decodificar(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for (int i = 0; i < aux.length; i++) {
            resp[i] = tabDeCod.getOrDefault(aux[i], aux[i]);
        }
        return new String(resp);
    }
}
