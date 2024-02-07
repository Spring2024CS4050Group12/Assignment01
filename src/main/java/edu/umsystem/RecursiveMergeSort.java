package edu.umsystem;

public class RecursiveMergeSort implements SortingAlgorithm {
    SortShow arrayDisplay;

    RecursiveMergeSort(SortShow arrayDisplay) {
        this.arrayDisplay = arrayDisplay;
    }

    @Override
    public String getName() {
        return "Recursive Merge Sort";
    }

    @Override
    public void sort() {
        // Do first mergeSort with a temp array and bounds of entire array
        int[] temp = new int[arrayDisplay.total_number_of_lines];
        mergeSort(arrayDisplay.lines_lengths, temp, 0, arrayDisplay.total_number_of_lines - 1);
    }

    public void mergeSort(int[] a, int[] temp, int first, int last) {
        // As long as bounds are valid
        if (first < last) {
            arrayDisplay.delay();
            // Split at the middle
            int mid = (first + last) / 2;
            // Recursively continue mergeSort on new bounds
            mergeSort(a, temp, first, mid);
            mergeSort(a, temp ,mid + 1, last);
            // As recursive calls return merge back into array
            merge(a, temp, first, mid, last);
        }
    }

    public void merge(int[] a, int[] temp, int first, int mid, int last) {
        // Set iterators for front half, back half, and temp array
        int firstHalfI = first;
        int secondHalfI = mid + 1;
        int tempI = first;

        // Loop while bounds are valid
        while ((firstHalfI <= mid) && (secondHalfI <= last)) {
            arrayDisplay.delay();
            if (a[firstHalfI] < a[secondHalfI]) {
                // If first half smaller copy into temp
                arrayDisplay.delay();
                temp[tempI] = a[firstHalfI];
                firstHalfI++;
            } else {
                // Else copy in second half element
                arrayDisplay.delay();
                temp[tempI] = a[secondHalfI];
                secondHalfI++;
            }
            // In either case move forward temp iterator
            tempI++;
        }

        // Copy over any remaining values in array
        for (int i = firstHalfI; i <= mid; i++) {
            arrayDisplay.delay();
            arrayDisplay.delay();
            temp[tempI] = a[i];
            tempI++;
        }
        for (int i = secondHalfI; i <= last; i++) {
            arrayDisplay.delay();
            arrayDisplay.delay();
            temp[tempI] = a[i];
            tempI++;
        }

        // Copy values back from the temp array and paint as you go
        for (int i = first; i <= last; i++) {
            arrayDisplay.assign(i, temp[i]);
        }
    }

}
