import java.util.Iterator;
import java.util.NoSuchElementException;
public class FibonacciIterator implements Iterator<Integer> {
    private int prev;
    private int curr;
    private int returned;
    private final int limit;

    public FibonacciIterator() {
        this.prev = 0;
        this.curr = 1;
        this.returned = 0;
        this.limit = -1;
    }


    public FibonacciIterator(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0 or use default constructor for infinite");
        }
        this.prev = 0;
        this.curr = 1;
        this.returned = 0;
        this.limit = n;
    }

    @Override
    public boolean hasNext() {
        if (limit < 0) {
            return true;
        } else {
            return returned < limit;
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more Fibonacci numbers (limit reached).");
        }


        int value = curr;

        int next = prev + curr;

        prev = curr;
        curr = next;

        returned++;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
