package ej2_10;

public class Consumidor2 extends Thread{
	
	private Cola cola;
	private int n;
	
	public Consumidor2(Cola c, int n) {
		this.cola=c;
		this.n=n;
	}
	public void run() {
		int valor=0;
		for(int i =0;i<5;i++) {
			valor=cola.get();
			System.out.println(" "+i+" =>Consumidor: "+n+", consume: "+valor);
		}
		
	}
}
