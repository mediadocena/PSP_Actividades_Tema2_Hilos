package ej2_10;

public class Productor extends Thread{
	private Cola cola;
	private int n;
	public Productor(Cola c, int n) {
		this.cola=c;
		this.n=n;
	}
	public void run() {
		for(int i=0;i<5;i++) {
			cola.put(i);
			System.out.println(i+" =>Productor:"+n+" ,Produce: "+i);
			
		}
	}
}
