package edu.umsystem;

public class InsertionSort implements SortingAlgorithm {
    SortShow arrayDisplay;

    InsertionSort(SortShow arrayDisplay) {
        this.arrayDisplay = arrayDisplay;
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }

    @Override
    public void sort() {
        for (int unsortedIndex = 1; unsortedIndex < arrayDisplay.total_number_of_lines; ++unsortedIndex) {
            int firstUnsortedElement = arrayDisplay.lines_lengths[unsortedIndex];
            insertInOrder(firstUnsortedElement, arrayDisplay.lines_lengths, 0, unsortedIndex - 1);
        }
    }

    public void insertInOrder(int element, int[] a, int begin, int end) {
        // Inserts elements into the sorted array elements a[begin] through a[end]

        int index = end;
        while (index >= begin && element < a[index]) {
            a[index + 1] = a[index]; // make room
            index--;

            arrayDisplay.paintComponent(arrayDisplay.getGraphics());
        }

        // Assertion: a[index + 1] is available
        a[index + 1] = element;

        arrayDisplay.paintComponent(arrayDisplay.getGraphics());
    }
}
