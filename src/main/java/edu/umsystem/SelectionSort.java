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
        for (int sortedLength = 0; sortedLength < arrayDisplay.total_number_of_lines; ++sortedLength) {
            arrayDisplay.delay();
            int mindex = sortedLength;
            for (int i = sortedLength; i < arrayDisplay.total_number_of_lines; ++i) {
                arrayDisplay.delay();
                if (arrayDisplay.lines_lengths[i] < arrayDisplay.lines_lengths[mindex]) {
                    arrayDisplay.delay();
                    arrayDisplay.delay();
                    mindex = i;
                }
            }

            arrayDisplay.swap(sortedLength, mindex);
        }
    }
}
