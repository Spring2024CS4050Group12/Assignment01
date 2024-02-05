package edu.umsystem;

public class BubbleSort implements SortingAlgorithm {
    SortShow arrayDisplay;

    BubbleSort(SortShow arrayDisplay) {
        this.arrayDisplay = arrayDisplay;
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }

    @Override
    public SortShow getArrayDisplay() {
        return this.arrayDisplay;
    }

    @Override
    public void sort() {
        for (int i = 0; i < arrayDisplay.total_number_of_lines; i++) {
            for (int j = 0; j < arrayDisplay.total_number_of_lines - i - 1; j++) {
                if (arrayDisplay.checkLessThan(arrayDisplay.at(j + 1), arrayDisplay.at(j))) {
                    arrayDisplay.swap(j, j + 1);
                }
            }
        }
    }
}