package ej2_7_Sincrono;

public class Hilo4 extends Thread{
	private Contador contador;
	public Hilo4(Contador contador) {
		this.contador=contador;
	}
	
	public void run() {
		synchronized(contador) {
		for (int i = 0; i < 5000; i++) {
			contador.incrementaContador();
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("h4:"+contador.getContador());
	}
	}
}
