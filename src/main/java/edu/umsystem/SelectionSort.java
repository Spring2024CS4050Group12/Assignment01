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
            int mindex = sortedLength;
            for (int i = sortedLength; i < arrayDisplay.total_number_of_lines; ++i)
                if (arrayDisplay.lines_lengths[i] < arrayDisplay.lines_lengths[mindex])
                    mindex = i;

            arrayDisplay.swap(sortedLength, mindex);
        }
    }
}
