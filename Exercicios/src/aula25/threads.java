package aula25;

public class threads {


	public static void main(String[] args) {
		ThreadSoma s1 = new ThreadSoma("s1");
		ThreadSoma s2 = new ThreadSoma("s2");
		ThreadSoma s3 = new ThreadSoma("s3");
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		t1.start();
		t2.start();
		t3.start();
	}


}
