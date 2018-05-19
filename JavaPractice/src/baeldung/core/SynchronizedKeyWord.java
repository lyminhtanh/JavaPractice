package baeldung.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedKeyWord {
	int sum = 0;
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		SynchronizedKeyWord synchronizedKeyWord = new SynchronizedKeyWord();
		IntStream.range(0, 1000).forEach(count -> {
			service.submit(synchronizedKeyWord::calculate);
		});
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(synchronizedKeyWord.getSum());
	}
	//no synchronized keyword => different results every time invoked
	// two thread access at the same time => increase 1 instead of 2
	// http://www.baeldung.com/java-synchronized
	
	public synchronized void calculate() {
		setSum(getSum()+1);
	}
}
