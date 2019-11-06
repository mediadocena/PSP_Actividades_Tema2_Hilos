package ej2_8;

public class Saldo {

	private double saldo;
	
	public Saldo(double saldo){
		this.saldo = saldo;
	}

	public double getSaldo() throws InterruptedException {
		Thread.sleep((long) (Math.random()*10));
		return saldo;
	}

	public void setSaldo(double saldo) throws InterruptedException {
		Thread.sleep((long) (Math.random()*10));
		this.saldo = saldo;
	}
	
	public synchronized void sumarSaldo(double cantidad, String nombre) {
		System.out.println("Estado inicial del saldo: "+saldo);
		saldo = saldo+cantidad;
		System.out.println("cantidad añadida: "+cantidad);
		//System.out.println("Total: "+saldo);
		System.out.println("Ingreso hecho por: "+nombre);
	}

	@Override
	public String toString() {
		return "Saldo [saldo=" + saldo + "]";
	}
	
	
}