package clase4;

/**
 * @author Mateo Valdesolo
 *
 */
public class ThreadNumOne extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println(i);
			waitXMillis(3000);
		}
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
