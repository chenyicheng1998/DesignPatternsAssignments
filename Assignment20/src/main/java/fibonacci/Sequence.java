package fibonacci;

import java.util.Iterator;

/**
 * The Sequence interface corresponds to the "Aggregate" role in the Iterator pattern.
 * It declares a factory method for creating an iterator over a sequence of integers.
 */
public interface Sequence {
    Iterator<Integer> iterator();
}

