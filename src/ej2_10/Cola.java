package ej2_10;


public class Cola {

    private int numero;
    private boolean disponible=false;
    public synchronized int get() {
        while(!disponible) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        disponible=false;
        notify();
        return numero;
    }
    public synchronized void put(int valor) {
        while(disponible) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        numero = valor;
        disponible=true;
        notify();
    }
}
