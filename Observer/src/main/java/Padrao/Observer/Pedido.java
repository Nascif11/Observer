package Padrao.Observer;

import java.util.Observable;

public class Pedido extends Observable {

    private int numero;
    private String status;

    public Pedido(int numero, String status) {
        this.numero = numero;
        this.status = status;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", status='" + status + '\'' +
                '}';
    }
}