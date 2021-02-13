package aula25;

public class ThreadSoma implements Runnable {

	private String id;
	private static int cont = 0;
			
	public ThreadSoma(String id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		for (int i=0 ; i<10 ; i++) {
			incrementa();
			System.out.println(id + ": " + cont);
		}
		System.out.println(id + ": valor final do cont = " + cont);
	}
	
	private static synchronized void incrementa() {
		int temp = cont;
		for (int i=0 ; i<10_000_000 ; i++) {
			for (int j=0 ; j<1_000_000_000 ; j++) {
			}
			if ((i%1_000_000)==0) System.out.print("");
		}
		cont = temp + 1;
	}

	

}
