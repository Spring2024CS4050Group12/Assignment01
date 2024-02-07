package edu.umsystem;

public class RecursiveQuickSort implements SortingAlgorithm {
    SortShow arrayDisplay;

    RecursiveQuickSort(SortShow arrayDisplay) {
        this.arrayDisplay = arrayDisplay;
    }

    @Override
    public String getName() {
        return "Recursive Quick Sort";
    }

    @Override
    public void sort() {
        quickSort(arrayDisplay.lines_lengths, 0, arrayDisplay.total_number_of_lines - 1);
    }

    private void quickSort(int[] a, int first, int last) {
        if (first < last) {
            // Split array into three partitions: [first, pivot - 1], [pivot] (sorted), and [pivot + 1, last]
            int pivot = partition(a, first, last);

            // Sort first and third partitions
            quickSort(a, first, pivot - 1);
            quickSort(a, pivot + 1, last);
        }
    }

    private int partition(int[] a, int first, int last) {
        int left = first;
        int right = last - 1;
        int pivot = a[last];

        while (left <= right) {
            arrayDisplay.delay();
            // If a[left] <= pivot, everything to the left of `left` is sorted
            while (left <= right && a[left] <= pivot) {
                arrayDisplay.delay();
                arrayDisplay.delay();
                ++left;
            }

            // If a[right] >= pivot, everything to the right of `right` is sorted
            while (left <= right && a[right] >= pivot) {
                arrayDisplay.delay();
                arrayDisplay.delay();
                --right;
            }

            if (left < right) {
                arrayDisplay.delay();
                arrayDisplay.swap(left, right);
            }
        }

        // Place pivot in it's sorted position
        arrayDisplay.swap(left, last);
        return left;
    }
}
