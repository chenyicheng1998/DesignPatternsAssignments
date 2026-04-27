package fibonacci;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * FibonacciIterator is the "ConcreteIterator" in the Iterator pattern.
 *
 * All mutable state needed to calculate the next Fibonacci number is stored
 * here, not in FibonacciSequence. This ensures that each iterator obtained
 * from FibonacciSequence.iterator() starts fresh at F(1) = 1 and advances
 * independently of any other iterator on the same sequence.
 *
 * The Fibonacci recurrence used:
 *   F(1) = 1,  F(2) = 1
 *   F(n) = F(n-1) + F(n-2)  for n > 2
 */
public class FibonacciIterator implements Iterator<Integer> {

    // The two most recently produced values – maintained as the iterator advances.
    private int prev = 0;    // conceptual F(0) = 0, used only as a starting seed
    private int current = 1; // F(1) = 1, the first real Fibonacci number

    // How many numbers have been returned so far
    private int produced = 0;

    // Upper bound on how many numbers to produce
    private final int limit;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    /**
     * Returns true as long as we have not yet produced 'limit' numbers.
     * For an "infinite" sequence (limit == Integer.MAX_VALUE) this is
     * practically always true; the caller is responsible for stopping.
     */
    @Override
    public boolean hasNext() {
        return produced < limit;
    }

    /**
     * Returns the next Fibonacci number and advances the internal state.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Fibonacci sequence limit reached.");
        }

        int value = current;

        // Advance: shift the window forward by one step
        int next = prev + current;
        prev = current;
        current = next;

        produced++;
        return value;
    }
}

