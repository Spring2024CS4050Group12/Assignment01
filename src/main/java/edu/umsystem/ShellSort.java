package edu.umsystem;

public class ShellSort implements SortingAlgorithm {
    SortShow arrayDisplay;

    ShellSort(SortShow arrayDisplay) {
        this.arrayDisplay = arrayDisplay;
    }

    @Override
    public String getName() {
        return "Shell Sort";
    }

    private void insertionSort(int start, int stop, int step) {
        for (int sortedTo = start + step; sortedTo < stop; sortedTo += step) {
            arrayDisplay.delay();
            for (
                    int insertPosition = sortedTo;
                    insertPosition > start && this.arrayDisplay.checkLessThan(insertPosition, insertPosition - step);
                    insertPosition -= step
            ) {
                arrayDisplay.delay();
                arrayDisplay.delay();
                arrayDisplay.swap(insertPosition, insertPosition - step);
            }
        }
    }

    @Override
    public void sort() {
        int gap = this.arrayDisplay.total_number_of_lines / 2;

        while (gap > 0) {
            arrayDisplay.delay();
            for (int i = 0; i < gap; ++i) {
                arrayDisplay.delay();
                insertionSort(i, this.arrayDisplay.total_number_of_lines, gap);
            }
            gap /= 2;
        }
    }
}
