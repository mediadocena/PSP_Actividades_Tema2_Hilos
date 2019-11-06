package ej2_8;
public class Main {

	public static void main(String[] args) throws InterruptedException {

		Saldo sal = new Saldo(10);
		Suma s1 = new Suma(15, "Alejandro", sal);
		Suma s2 = new Suma(20, "Jose", sal);
		Suma s3 = new Suma(150, "Javier", sal);
		
		s1.start();
		s2.start();
		s3.start();
		
		System.out.println(sal.getSaldo());
	}

}
