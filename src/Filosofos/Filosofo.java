package Filosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;
 
/**
 * Hilo filósofo. 
 */
public class Filosofo extends Thread {
 
    /**
     * atributo para identificar cada filósofo (0 al 4)
     */
    private final int idFilosofo;
 
    /**
     * atributo de tipo array para los palillos.
     */
    private final Semaphore[] palillos_semaforo;
 
    /**
     * array bidimensional, cada fila almaceja los palillos
     * que necesita el filósofo de ese índice para comer.
     */
    private final int[][] palillosFilosofo;
 
    /**
     * atributo que indica el  palillo a la izquierda del filósofo. 
     */
    private final int palilloIzquierdo;
 
    /**
     * atributo que indica el  palillo a la derecha del filósofo. 
     */
    private final int palilloDerecho;
 
    /**
     * tiempo aleatoria que tardan los filósofos en comer y pensar.
     */
    private final Random tiempoAleatorio = new Random();
 
    /**
     * Constructor
     */
    public Filosofo(int idFilosofo, Semaphore[] palillos_semaforo, int[][] palillosFilosofo) {
        this.idFilosofo = idFilosofo;
        this.palillos_semaforo = palillos_semaforo;
        this.palillosFilosofo = palillosFilosofo;
        this.palilloIzquierdo = palillosFilosofo[idFilosofo][0];
        this.palilloDerecho = palillosFilosofo[idFilosofo][1];
    }
 
    /**
     * mensaje "Filosófo n está hambriento" mientras intenta
     * conseguir los palillos que necesita para comer. Cuando los tenga,
     * muestra el mensaje "Filósofo n está comiendo", dormirá el hilo un tiempo aleatorio. 
     * Cuando termine, muestra un mensaje "El filósofo n ha terminado de comer", 
     * indicando los palillos que quedan libres.
     */
    protected void comer() {
        /** 
        * trataremos de de coger el pallillo de su izquierda, si podemos,
        * trataremos de coger el palillo de su derecha
        * El método tryAcquire() adquiere un permiso del semáforo si es
        * posible (devolviendo true), o devuelve false si no es posible. 
        */
        if (palillos_semaforo[palilloIzquierdo].tryAcquire()) {
            if (palillos_semaforo[palilloDerecho].tryAcquire()) {
                System.out.println("FILÓSOFO " + idFilosofo + " ESTÁ COMIENDO.");
                try {
                    // timmpo aleatorio que tarda el filósofo en comer, (entre 0.5 y 1 segundos)
                    sleep(tiempoAleatorio.nextInt(1000) + 500);
                } catch (InterruptedException ex) {
                    System.out.println("Error : " + ex.toString());
                }
                System.out.println("Filósofo " + idFilosofo + " ha terminado de comer.Libera los palillos " + palilloIzquierdo + " y " + palilloDerecho);
                // ha terminado de comer y libera el palillo de su derecha:
                palillos_semaforo[palilloDerecho].release();
            }
            // libera también el palillo de su izuierda.
            palillos_semaforo[palilloIzquierdo].release();
        } else { // si el filósofo no ha podido coger el palillo, no puede comer. :(
            System.out.println("Filósofo " + idFilosofo + " está hambriento.");
        }
    }
 
    /**
     * mensaje "Filósofo n está pensando". Dormirá el hilo un tiempo aleatorio.
     */
    protected void pensar() {
        System.out.println("Filósofo " + idFilosofo + " está pensando.");
        try {
            // tiempo que tarda el filósofo en pensar (entre 100 y 1000 milisegundos)
            Filosofo.sleep(tiempoAleatorio.nextInt(1000) + 100);
        } catch (InterruptedException ex) {
            System.out.println("Error en el método pensar(): " + ex.toString());
        }
    }
 
    /**
     * Bucle infinito:
     */
    @Override
    public void run() {
        while (true) {
            pensar();
            comer();
        }
    }
}