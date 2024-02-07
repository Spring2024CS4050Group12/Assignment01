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
    public void sort() {
        for (int i = 0; i < arrayDisplay.total_number_of_lines - 1; i++) {
            for (int j = 0; j < arrayDisplay.total_number_of_lines - i - 1; j++) {
                arrayDisplay.delay();
                if (arrayDisplay.lines_lengths[j] > arrayDisplay.lines_lengths[j + 1]) {
                    arrayDisplay.swap(j, j + 1);
                }
            }
        }
    }
}