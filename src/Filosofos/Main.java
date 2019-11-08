package Filosofos;

public class Main {
 
	public static void main(String args[]){
		System.out.println("Cena de los Filosofos");
		Cena cena = new Cena();
		for(int i=0; i<5; i++){
		Filosofo pensante = new Filosofo(i, cena);
		}
	}
}
