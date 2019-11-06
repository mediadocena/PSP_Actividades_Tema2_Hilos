package ej_2_7;

public class Main {
	static int contador;
	public static void main(String[]args) {
		Contador c = new Contador();
		Hilo1 h1 = new Hilo1(c);
		Hilo2 h2 = new Hilo2(c);
		Hilo3 h3 = new Hilo3(c);
		Hilo4 h4 = new Hilo4(c);
		Hilo5 h5 = new Hilo5(c);
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
	}
}
