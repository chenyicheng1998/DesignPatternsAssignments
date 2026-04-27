package fibonacci;

import java.util.Iterator;

/**
 * Demonstrates the Fibonacci sequence generator using the Iterator pattern.
 */
public class Main {

    public static void main(String[] args) {

        // --- Demo 1: print the first 10 Fibonacci numbers ---
        System.out.println("First 10 Fibonacci numbers:");
        FibonacciSequence seq10 = new FibonacciSequence(10);
        Iterator<Integer> it = seq10.iterator();
        int index = 1;
        while (it.hasNext()) {
            System.out.println("F(" + index + ") = " + it.next());
            index++;
        }

        // --- Demo 2: two independent iterators from the same sequence ---
        System.out.println("\nTwo independent iterators (each printing first 5 numbers):");
        FibonacciSequence seq5 = new FibonacciSequence(5);

        Iterator<Integer> iterA = seq5.iterator();
        Iterator<Integer> iterB = seq5.iterator();

        System.out.print("Iterator A: ");
        while (iterA.hasNext()) {
            System.out.print(iterA.next() + " ");
        }

        System.out.print("\nIterator B: ");
        while (iterB.hasNext()) {
            System.out.print(iterB.next() + " ");
        }
        System.out.println();

        // --- Demo 3: "infinite" sequence – caller decides when to stop ---
        System.out.println("\nFibonacci numbers below 100 (using infinite sequence):");
        FibonacciSequence infinite = new FibonacciSequence();
        Iterator<Integer> inf = infinite.iterator();
        while (inf.hasNext()) {
            int val = inf.next();
            if (val >= 100) break;
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

