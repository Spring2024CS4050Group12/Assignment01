package edu.umsystem;

public class SelectionSort implements SortingAlgorithm {
    SortShow arrayDisplay;

    SelectionSort(SortShow arrayDisplay) {
        this.arrayDisplay = arrayDisplay;
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }

    @Override
    public void sort() {
        int swapC = 0, compC = 0;
        for (int sortedLength = 0; sortedLength < arrayDisplay.total_number_of_lines; ++sortedLength) {
            int mindex = sortedLength;
            for (int i = sortedLength; i < arrayDisplay.total_number_of_lines; ++i) {
                compC++;
                if (arrayDisplay.compare(i, mindex) < 0)
                    mindex = i;
            }

            swapC++;
            arrayDisplay.swap(sortedLength, mindex);
        }
        System.out.println("Selection Sort used " + swapC + " swaps and " + compC + " compares");
    }
}
