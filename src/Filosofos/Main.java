package Filosofos;

/*
 * Pueden estar comiendo 2 fil�sofos a la vez:
 * El fil�sofo 0 puede comer con el fil�sofo 2 o con el 3.
 * El fil�sofo 1 puede comer con el fil�sofo 3 o con el 4.
 * El fil�sofo 2 puede comer con el fil�sofo 4 o con el 0.
 * El fil�sofo 3 puede comer con el fil�sofo 0 o con el 1.
 * El fil�sofo 4 puede comer con el fil�sofo 1 o con el 2.
 */
 
import java.util.concurrent.Semaphore;
 
/**
 * Clase main
 */
public class Main {
 
    /**
     * n�mero de fil�sofos
     */
    final static int numeroFilosofos = 5;
 
    /**
     * array bidimensional con tantas filas como fil�sofos. Cada fila
     * es un un array de 2 enteros que representan los 2 palillos del fil�sofo.
     */
    final static int[][] palillosFilosofo = {
        {0, 4}, // filosofo 0
        {1, 0}, // filosofo 1
        {2, 1}, // filosofo 2
        {3, 2}, // filosofo 3
        {4, 3}  // filosofo 4
    };
 
    /**
     * array de objetos Semaphore que representan a los palillos. Igual que el n�mero de fil�sofos.
     */
    final static Semaphore[] palillos_semaforo = new Semaphore[numeroFilosofos];
 
    /**
     * Se crean los 5 fil�sofos y se inician.
     */
    public static void main(String[] args) {
        // A cada uno se le da un �nico permiso (permiso o no permiso):
        for (int i = 0; i < numeroFilosofos; i++) {
            // porque cada palillo-semaforo solo puede tenerlo un fil�sofo a la vez.
            palillos_semaforo[i] = new Semaphore(1);
        }
 
        // creamos los objetos de tipo Filosofo que extienden Thread, y los iniciamos.
        // Pasamos al constructor el id, los semaforos y el array de los 2 palillos:
        for (int idFilosofo = 0; idFilosofo < numeroFilosofos; idFilosofo++) {
            new Filosofo(idFilosofo, palillos_semaforo, palillosFilosofo).start();
        }
    }
}
