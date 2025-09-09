import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        // Create datasets
        int smallSize = 30;
        int largeSize = 100_000;

        int[] smallData = generateRandomArray(smallSize);
        int[] largeData = generateRandomArray(largeSize);

        // Strategies
        SortStrategy[] strategies = { new BubbleSort(), new QuickSort(), new MergeSort() };
        String[] names = { "Bubble Sort", "Quick Sort", "Merge Sort" };

        System.out.println("=== Small Dataset (" + smallSize + " elements) ===");
        testStrategies(sorter, strategies, names, smallData);

        System.out.println("\n=== Large Dataset (" + largeSize + " elements) ===");
        testStrategies(sorter, strategies, names, largeData);
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10_000);
        }
        return arr;
    }

    private static void testStrategies(Sorter sorter, SortStrategy[] strategies, String[] names, int[] original) {
        for (int i = 0; i < strategies.length; i++) {
            int[] copy = original.clone();

            sorter.setStrategy(strategies[i]);

            long start = System.nanoTime();
            sorter.executeStrategy(copy);
            long end = System.nanoTime();

            System.out.println(names[i] + " took " + (end - start) / 1_000_000.0 + " ms");
        }

        }
    }
