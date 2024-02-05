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
    public SortShow getArrayDisplay() {
        return this.arrayDisplay;
    }

    @Override
    public void sort() {
        for (int unsortedIndex = 1; unsortedIndex < arrayDisplay.total_number_of_lines; ++unsortedIndex) {
            int firstUnsortedElement = arrayDisplay.at(unsortedIndex);
            insertInOrder(firstUnsortedElement, 0, unsortedIndex - 1);
        }
    }

    public void insertInOrder(int element, int begin, int end) {
        // Inserts elements into the sorted array elements a[begin] through a[end]

        int index = end;
        while (index >= begin && arrayDisplay.checkLessThan(element, arrayDisplay.at(index))) {
            arrayDisplay.assign(index + 1, arrayDisplay.at(index)); // make room
            index--;
        }

        // Assertion: a[index + 1] is available
        arrayDisplay.assign(index + 1, element);
    }
}
