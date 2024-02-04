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
        int swapC = 0, compC = 0;
        for (int i = 0; i < arrayDisplay.total_number_of_lines - 1; i++) {
            for (int j = 0; j < arrayDisplay.total_number_of_lines - i - 1; j++) {
                compC++;
                if (arrayDisplay.compare(j, j + 1) > 0) {
                    swapC++;
                    arrayDisplay.swap(j, j + 1);
                }
            }
        }
        System.out.println("Bubble Sort used " + swapC + " swaps and " + compC + " compares");
    }
}