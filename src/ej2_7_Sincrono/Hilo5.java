package ej2_7_Sincrono;

public class Hilo5 extends Thread{
	private Contador contador;
	public Hilo5(Contador contador) {
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
		System.out.println("h5:"+contador.getContador());
	}
	}
}
