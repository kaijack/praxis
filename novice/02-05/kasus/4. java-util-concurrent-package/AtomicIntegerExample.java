package a4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample implements Runnable {
	private static final AtomicInteger atomicInteger = new AtomicInteger();

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new AtomicIntegerExample());
		}
		executorService.shutdown();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			int newValue = atomicInteger.getAndIncrement();
			if (newValue == 42) {
				System.out.println("[" + Thread.currentThread().getName() + "]: " + newValue);
			}
		}
	}
}
