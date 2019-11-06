package ej2_8;

public class Suma extends Thread{

	private double cantidad;
	private String nombre;
	private Saldo saldo;
	
	public Suma(double cantidad, String nombre, Saldo saldo) {
		this.cantidad=cantidad;
		this.nombre=nombre;
		this.saldo=saldo;
	}
	
	@Override
	public void run() {
		saldo.sumarSaldo(cantidad, nombre);
	}
}
