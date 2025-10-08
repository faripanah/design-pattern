import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        FibonacciSequence seq = new FibonacciSequence();


        System.out.println("First 10 Fibonacci numbers (method 1):");
        Iterator<Integer> it = seq.iterator(10);
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        System.out.println("\nFirst 10 Fibonacci numbers (method 2):");
        Iterator<Integer> it2 = seq.iterator();
        int count = 0;
        while (it2.hasNext() && count < 10) {
            System.out.println(it2.next());
            count++;
        }



    }
}