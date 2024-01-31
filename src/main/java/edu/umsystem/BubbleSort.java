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

    }
}
