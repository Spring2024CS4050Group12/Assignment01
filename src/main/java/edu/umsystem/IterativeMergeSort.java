package edu.umsystem;

public class IterativeMergeSort implements SortingAlgorithm {
    SortShow arrayDisplay;

    //A temp Array that is used later for sorts
    public int[] tempArray;

    IterativeMergeSort(SortShow arrayDisplay) {
        this.arrayDisplay = arrayDisplay;
    }

    @Override
    public String getName() {
        return "Iterative Merge Sort";
    }

    //iterative merge sort method
    @Override
    public void sort() {
        //assigning the size for the tempArray below
        tempArray = new int[this.arrayDisplay.total_number_of_lines];
        //saving the value of total_number_of_lines
        int beginLeftovers = this.arrayDisplay.total_number_of_lines;

        for (int segmentLength = 1; segmentLength <= this.arrayDisplay.total_number_of_lines / 2; segmentLength = 2 * segmentLength) {
            beginLeftovers = I_MergeSegmentPairs(this.arrayDisplay.total_number_of_lines, segmentLength);
            int endSegment = beginLeftovers + segmentLength - 1;
            if (endSegment < this.arrayDisplay.total_number_of_lines - 1) {
                I_Merge(beginLeftovers, endSegment, this.arrayDisplay.total_number_of_lines - 1);
            }
        }

        // merge the sorted leftovers with the rest of the sorted array
        if (beginLeftovers < this.arrayDisplay.total_number_of_lines) {
            I_Merge(0, beginLeftovers - 1, this.arrayDisplay.total_number_of_lines - 1);
        }
    }

    // Merges segments pairs (certain length) within an array
    public int I_MergeSegmentPairs(int l, int segmentLength) {
        //The length of the two merged segments

        //You suppose  to complete this part (Given).
        int mergedPairLength = 2 * segmentLength;
        int numberOfPairs = l / mergedPairLength;

        int beginSegment1 = 0;
        for (int count = 1; count <= numberOfPairs; count++) {
            int endSegment1 = beginSegment1 + segmentLength - 1;

            int beginSegment2 = endSegment1 + 1;
            int endSegment2 = beginSegment2 + segmentLength - 1;
            I_Merge(beginSegment1, endSegment1, endSegment2);

            beginSegment1 = endSegment2 + 1;
            //redrawing the lines_lengths
        }
        // Returns index of last merged pair
        return beginSegment1;
        //return 1;//modify this line
    }

    public void I_Merge(int first, int mid, int last) {
        //You suppose  to complete this part (Given).
        // Two adjacent sub-arrays
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;

        // While both sub-arrays are not empty, copy the
        // smaller item into the temporary array
        int index = beginHalf1; // Next available location in tempArray
        for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++) {
            // Invariant: tempArray[beginHalf1..index-1] is in order
            if (this.arrayDisplay.lines_lengths[beginHalf1] < this.arrayDisplay.lines_lengths[beginHalf2]) {
                this.tempArray[index] = this.arrayDisplay.lines_lengths[beginHalf1];
                beginHalf1++;
            } else {
                this.tempArray[index] = this.arrayDisplay.lines_lengths[beginHalf2];
                beginHalf2++;
            }
        }

        // Finish off the nonempty sub-array

        // Finish off the first sub-array, if necessary
        for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
            // Invariant: tempArray[beginHalf1..index-1] is in order
            this.tempArray[index] = this.arrayDisplay.lines_lengths[beginHalf1];

        // Finish off the second sub-array, if necessary
        for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
            // Invariant: tempa[beginHalf1..index-1] is in order
            this.tempArray[index] = this.arrayDisplay.lines_lengths[beginHalf2];

        // Copy the result back into the original array
        for (index = first; index <= last; index++)
            this.arrayDisplay.assign(index, this.tempArray[index]);
    }
}
