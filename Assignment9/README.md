# Assignment 9: Algorithm Performance Comparison

## Overview
This project implements three sorting algorithms using the **Strategy design pattern** and compares their performance with different dataset sizes.

## Design Pattern: Strategy Pattern
The Strategy pattern allows selecting an algorithm at runtime. In this implementation:
- **Strategy Interface**: `SortingStrategy` - defines the common interface for all sorting algorithms
- **Concrete Strategies**: 
  - `BubbleSortStrategy` - implements optimized Bubble Sort
  - `QuickSortStrategy` - implements Quick Sort
  - `MergeSortStrategy` - implements Merge Sort
- **Context**: `SortingContext` - maintains a reference to a strategy and delegates sorting work to it

## Sorting Algorithms Implemented

### 1. Bubble Sort
- **Source**: https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
- **Description**: Repeatedly swaps adjacent elements if they are in wrong order
- **Optimization**: Includes early termination when no swaps occur in a pass
- **Time Complexity**: O(n²) worst case, O(n) best case

### 2. Quick Sort
- **Source**: https://www.geeksforgeeks.org/dsa/quick-sort/
- **Description**: Uses divide and conquer with a pivot element
- **Time Complexity**: O(n log n) average case, O(n²) worst case

### 3. Merge Sort
- **Source**: https://www.geeksforgeeks.org/dsa/merge-sort/
- **Description**: Divides array into halves, recursively sorts them, and merges
- **Time Complexity**: O(n log n) in all cases

## Project Structure
```
src/main/java/
├── SortingStrategy.java         # Strategy interface
├── BubbleSortStrategy.java      # Bubble Sort implementation
├── QuickSortStrategy.java       # Quick Sort implementation
├── MergeSortStrategy.java       # Merge Sort implementation
├── SortingContext.java          # Context class
└── PerformanceTest.java         # Main test program
```

## How to Run
```bash
cd src/main/java
javac *.java
java PerformanceTest
```

## Performance Test Results

The program tests each algorithm with two datasets:
- **Small array**: 30 elements
- **Large array**: 100,000 elements

### Example Results:

#### Small Array (30 elements)
- Bubble Sort: ~0.02 ms
- Quick Sort: ~0.015 ms
- Merge Sort: ~0.034 ms

#### Large Array (100,000 elements)
- Bubble Sort: ~16,258 ms (16.3 seconds)
- Quick Sort: ~18 ms
- Merge Sort: ~16 ms

### Analysis
- For small datasets, all algorithms perform similarly
- For large datasets, Quick Sort and Merge Sort significantly outperform Bubble Sort
- Bubble Sort's O(n²) complexity becomes evident with larger datasets
- Quick Sort and Merge Sort both achieve O(n log n) performance

## Code Attribution
All sorting algorithm implementations are adapted from GeeksforGeeks with proper attribution in the source code comments. The code has been modified to fit the Strategy pattern design and integrated into the performance testing framework.

## Features
- Uses Strategy pattern for flexible algorithm selection
- Generates random test data programmatically
- Measures execution time in both milliseconds and nanoseconds
- Verifies sorting correctness after each test
- Displays sorted arrays for small datasets
- Provides clear performance comparison output

