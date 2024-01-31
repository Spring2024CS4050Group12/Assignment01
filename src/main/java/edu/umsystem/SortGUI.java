/**
 * @author Ouda
 */
package edu.umsystem;

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//the class with button and main method
public class SortGUI {
    //Making a object from the class SortShow
    SortShow sortArea = new SortShow();

    //Default constructor for SortGUI
    public SortGUI() {
        //making a MyScreen object

        // You need to adjust the following values to your Screen dimensions

        MyScreen screen = new MyScreen();
        //Setting a title to the GUI window
        screen.setTitle("Assignment-1 by Abdelnasser Ouda");
        //setting the size of the window
        screen.setSize(975 + sortArea.total_number_of_lines, 450);
        //the operation when the frame is closed
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //is set to true to display the frame
        screen.setVisible(true);
    }

    //The main method
    public static void main(String[] args) {
        //initialize the class
        SortGUI sort_GUI = new SortGUI();
    }

    //A public class that extends JFrame
    public class MyScreen extends JFrame {
        //making a scramble button with a text "Scramble Lines" on it
        JButton scramble_button = new JButton("Scramble Lines");
        JButton reset = new JButton("Reset");

        ArrayList<AlgorithmDemo> demos = new ArrayList<>();

        //the default constructor for the class MyScreen
        public MyScreen() {
            // Panel where sorted lines_lengths will displayed
            //The scramble button's text will be blue
            scramble_button.setForeground(Color.BLUE);
            //setting the font of scramble button
            scramble_button.setFont(new Font("Arial", Font.BOLD, 15));

            SortingAlgorithm[] algorithms = {
                new IterativeMergeSort(sortArea),
                new BubbleSort(sortArea),
                new SelectionSort(sortArea),
            };

            for (SortingAlgorithm algorithm : algorithms) {
                AlgorithmDemo demo = new AlgorithmDemo(algorithm);
                demo.addStartButtonListener(e -> { this.runDemo(demo); });
                demos.add(demo);
            }

            this.lockOptions();

            // Panel listing the available sorting algorithm demos
            JPanel algorithmChecklist = new JPanel(new GridLayout(this.demos.size() + 1, 1, 3, 3));
            algorithmChecklist.setBorder(new javax.swing.border.TitledBorder("Sorting Algorithms"));

            // Panel listing statistics for each demo upon completion
            JPanel statisticsPanel = new JPanel(new GridLayout(2 * this.demos.size(), 1, 3, 3));

            for (AlgorithmDemo demo : this.demos) {
                algorithmChecklist.add(demo.getStartButton());
                statisticsPanel.add(demo.getTimeLabel());
                statisticsPanel.add(demo.getTimeValue());
            }

            algorithmChecklist.add(reset);

            //A Panel to hold the buttons_area_Panel and set the GridLayout
            //This buttons_area_Panel will hold scrambleButton, radio_button_selection and the time_Panel
            JPanel buttons_area_Panel = new JPanel(new GridLayout(5, 1, 5, 5));
            //adding scramble_button to the buttons_area_Panel
            buttons_area_Panel.add(scramble_button);
            //adding radio_button_selection_Panel to the buttons_area_Panel
            buttons_area_Panel.add(algorithmChecklist);
            //adding time_Panel to the buttons_area_Panel
            buttons_area_Panel.add(statisticsPanel);

            //placing the buttons_area_Panel to the east side of the window
            add(buttons_area_Panel, BorderLayout.EAST);
            //placing the sortArea object in the center of the window
            add(sortArea, BorderLayout.CENTER);

            scramble_button.addActionListener(e -> {
                sortArea.scramble_the_lines();

                //this same scrambled lines will be used for all threes sort methods used in this program
                scramble_button.setEnabled(false);

                this.unlockOptions();
            });

            reset.addActionListener(e -> {
                this.unlockOptions();
                sortArea.reset();
            });
        }

        // the program is currently performing a demo, lock the interface
        public void lockOptions() {
            for (AlgorithmDemo demo : this.demos) {
                demo.setEnabled(false);
            }

            reset.setEnabled(false);
        }

        // the array is shuffled, unlock all unused demos or the reset button if all are used (otherwise disable it)
        public void unlockOptions() {
            Boolean allUsed = true;
            for (AlgorithmDemo demo : this.demos) {
                allUsed &= demo.getUsedStatus();
                demo.setEnabled(!demo.getUsedStatus());
            }

            reset.setEnabled(allUsed);
        }

        public void runDemo(AlgorithmDemo demo) {
            // disable interface while a demo is running
            // Note: with the current implementation sort() is blocking and this doesn't seem to have any effect but
            //  it's probably better not to rely on that fact
            this.lockOptions();
            demo.sort();

            // always allow for a reset (re-shuffle) after sorting completes
            this.reset.setEnabled(true);
        }
    }
}
