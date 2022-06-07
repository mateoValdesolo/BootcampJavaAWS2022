package clase4;

public class ThreadNumTwo extends Thread {

	private char option;

	public ThreadNumTwo(char option) {
		// 'E' Para que imprima los numeros pares, 'O' Para los impares.
		this.option = option;
	}

	@Override
	public void run() {
		int total = 0;
		boolean opt = (this.option == 'E');
		for (int i = 1; i <= 10; i++) {
			if(opt && i % 2 == 0) {
				System.out.println("Par - "+i);
				total+= i;
			} else {
				if(i % 2 != 0) {
					System.out.println("Impar - "+i);
					total+= i;
				}
			}
			waitXMillis(500);
		}
		System.out.println("La suma total es: "+ total);
	}
	
	private void waitXMillis(int millis) {
		/**
		 * Duerme el hilo los milisegundos pasados por parametro.
		 */
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
