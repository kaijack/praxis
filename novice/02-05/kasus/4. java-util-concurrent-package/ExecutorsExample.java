package a4;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsExample implements Callable<Integer> {
	private static Random random = new Random(System.currentTimeMillis());

	public Integer call() throws Exception {
		Thread.sleep(1000);
		return random.nextInt(100);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future<Integer>[] futures = new Future[5];
		for (int i = 0; i < futures.length; i++) {
			futures[i] = executorService.submit(new ExecutorsExample());
		}
		for (int i = 0; i < futures.length; i++) {
			Integer retVal = futures[i].get();
			System.out.println(retVal);
		}
		executorService.shutdown();
	}
}
