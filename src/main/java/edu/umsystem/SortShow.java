/**
 * @author Ouda
 */
package edu.umsystem;

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

//The class that has all the sorts in it
public class SortShow extends JPanel {
    //The amount of lines needed
    public final int total_number_of_lines = 256;
    // An array to hold the lines_lengths to be sorted
    public int[] lines_lengths;
    // An array to holds the scrambled lines_lengths
    public int[] scramble_lines;

    //the default constructor for the SortShow class
    public SortShow() {
        //assigning the size for the lines_lengths below
        lines_lengths = new int[total_number_of_lines];
        for (int i = 0; i < total_number_of_lines; i++)
            lines_lengths[i] = i + 5;

    }

    //A method that scrambles the lines
    public void scramble_the_lines() {
        //A random generator
        Random num = new Random();
        //Randomly switching the lines
        for (int i = 0; i < total_number_of_lines; i++) {
            //getting a random number using the nextInt method (a number between 0 to i + 1)
            int j = num.nextInt(i + 1);
            //swapping The element at i and j
            swap(i, j);
        }
        //assigning the size for the scramble_lines below
        scramble_lines = new int[total_number_of_lines];
        //copying the now scrambled lines_lengths array into the scramble_lines array
        //to store for reuse for other sort methods
        //so that all sort methods will use the same scrambled lines for fair comparison
        System.arraycopy(lines_lengths, 0, scramble_lines, 0, total_number_of_lines);
        //Drawing the now scrambled lines_lengths
        paintComponent(this.getGraphics());
    }

    //Swapping method that swaps two elements in the lines_lengths array
    public void swap(int i, int j) {
        //storing the i element in lines_lengths in temp
        int temp = lines_lengths[i];
        //giving i element in lines_lengths the value of j element in lines_lengths
        lines_lengths[i] = lines_lengths[j];
        //giving j element in lines_lengths the value of temp
        lines_lengths[j] = temp;
    }

    public Boolean checkLessThan(int i, int j) {
        return lines_lengths[i] < lines_lengths[j];
    }

    ///////////////////////////////////////////////////////////////////////////////////

    //recursive merge sort method
    public void R_MergeSort() {
    }

    //recursive merge sort method
    public void R_MergeSort(int first, int last) {
        if (first < last) {

            //You need to complete this part.

            //Causing a delay for 10ms
            delay(10);
        }
    }

    //recursive merge sort method
    public void R_Merge(int first, int mid, int last) {

        //You need to complete this part.

    }

    //////////////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////////////////////////

    //This method resets the window to the scrambled lines display
    public void reset() {
        if (scramble_lines != null) {
            //copying the old scrambled lines into lines_lengths
            System.arraycopy(scramble_lines, 0, lines_lengths, 0, total_number_of_lines);
            //Drawing the now scrambled lines_lengths
            paintComponent(this.getGraphics());
        }
    }

    //This method colours the lines and prints the lines
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //A loop to assign a colour to each line
        for (int i = 0; i < total_number_of_lines; i++) {
            //using eight colours for the lines
            if (i % 8 == 0) {
                g.setColor(Color.green);
            } else if (i % 8 == 1) {
                g.setColor(Color.blue);
            } else if (i % 8 == 2) {
                g.setColor(Color.yellow);
            } else if (i % 8 == 3) {
                g.setColor(Color.red);
            } else if (i % 8 == 4) {
                g.setColor(Color.black);
            } else if (i % 8 == 5) {
                g.setColor(Color.orange);
            } else if (i % 8 == 6) {
                g.setColor(Color.magenta);
            } else g.setColor(Color.gray);

            //Drawing the lines using the x and y-components
            g.drawLine(4 * i + 25, 300, 4 * i + 25, 300 - lines_lengths[i]);
        }
    }

    //A delay method that pauses the execution for the milliseconds time given as a parameter
    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
