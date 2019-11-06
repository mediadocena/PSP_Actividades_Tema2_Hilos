package ej2_10;

public class main {

	public static void main(String[] args) {
		Cola cola = new Cola();
		Productor p = new Productor(cola,1);
		Consumidor c = new Consumidor(cola,1);
		Consumidor2 c2 = new Consumidor2(cola,2);
		p.start();
		c.start();
		c2.start();
	}

}
