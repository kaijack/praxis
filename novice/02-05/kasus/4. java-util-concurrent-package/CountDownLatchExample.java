package a4;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample implements Runnable {
	private static final int NUMBER_OF_THREADS = 5;
	private static final CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);
	private static Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			executorService.execute(new CountDownLatchExample());
		}
		executorService.shutdown();
	}

	public void run() {
		try {
			int randomSleepTime = random.nextInt(20000);
			System.out.println("[" + Thread.currentThread().getName() + "] sleeping for " + randomSleepTime);
			Thread.sleep(randomSleepTime);
			latch.countDown();
			System.out.println("[" + Thread.currentThread().getName() + "] waiting for latch.");
			latch.await();
			System.out.println("[" + Thread.currentThread().getName() + "] Finished.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
