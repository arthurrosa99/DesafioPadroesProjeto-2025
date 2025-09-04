import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FonteDeDados implements Subject {
    private List<Integer> lst;
    private List<Observer> observers;

    public FonteDeDados() {
        lst = new LinkedList<>();
        observers = new ArrayList<>();
    }

    public void add(Integer value) {
        if (value <= 0) throw new IllegalArgumentException("Valor deve ser positivo e maior que zero");
        lst.add(value);
        notificarObservers(value);
    }

    public int quantidade() {
        return lst.size();
    }

    public List<Integer> getValores() {
        return new ArrayList<>(lst);
    }

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(int valor) {
        for (Observer observer : observers) {
            observer.update(valor);
        }
    }
}