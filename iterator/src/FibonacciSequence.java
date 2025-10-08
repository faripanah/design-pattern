import java.util.Iterator;
import java.util.Objects;
public class FibonacciSequence implements Sequence {

    public FibonacciSequence() {
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }

    public Iterator<Integer> iterator(int n) {
        if (n <= 0) {
            return new FibonacciIterator();
        } else {
            return new FibonacciIterator(n);
        }
    }
}

