public class MapComparison implements Runnable {
    private static Map<Integer, String> map;
    private Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        runPerfTest(new Hashtable<Integer, String>());
        runPerfTest(Collections.synchronizedMap(new HashMap<Integer, String>()));
        runPerfTest(new ConcurrentHashMap<Integer, String>());
        runPerfTest(new ConcurrentSkipListMap<Integer, String>());
    }

    private static void runPerfTest(Map<Integer, String> map) throws InterruptedException {
        MapComparison.map = map;
        fillMap(map);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long startMillis = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MapComparison());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(
                map.getClass().getSimpleName() + " took " + (System.currentTimeMillis() - startMillis) + " ms");
    }

    private static void fillMap(Map<Integer, String> map) {
        for (int i = 0; i < 100; i++) {
            map.put(i, String.valueOf(i));
        }
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            int randomInt = random.nextInt(100);
            map.get(randomInt);
            randomInt = random.nextInt(100);
            map.put(randomInt, String.valueOf(randomInt));
        }
    }
}