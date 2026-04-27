package fibonacci;

import java.util.Iterator;

/**
 * FibonacciSequence acts as the "ConcreteAggregate" in the Iterator pattern.
 * It does not store any computed numbers – it only knows the limit (how many
 * Fibonacci numbers should be produced) and creates a fresh FibonacciIterator
 * on demand.
 *
 * Design decision – where should the sequence state live?
 *
 * Option A: keep prev/current inside FibonacciSequence.
 *   Downside: every call to iterator() would share the same state, so two
 *   iterators obtained from the same FibonacciSequence would interfere with
 *   each other. That behaviour would be surprising and bug-prone.
 *
 * Option B (chosen): keep prev/current inside FibonacciIterator.
 *   Each iterator is fully independent. You can obtain multiple iterators
 *   from the same FibonacciSequence and they each start from the beginning
 *   without affecting one another. This is the standard expectation for the
 *   Iterator pattern.
 */
public class FibonacciSequence implements Sequence {

    // How many numbers the iterator should produce.
    // A value <= 0 means "infinite" – the caller decides when to stop.
    private final int limit;

    /** Creates a sequence that produces 'limit' Fibonacci numbers. */
    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    /** Creates a sequence with no built-in stop condition (effectively infinite). */
    public FibonacciSequence() {
        this.limit = Integer.MAX_VALUE;
    }

    @Override
    public Iterator<Integer> iterator() {
        // A new iterator is returned every time, each with its own independent state.
        return new FibonacciIterator(limit);
    }
}

