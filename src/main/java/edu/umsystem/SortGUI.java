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
    //Making an object from the class SortShow
    SortShow sortArea = new SortShow();

    //Default constructor for SortGUI
    public SortGUI() {
        //making a MyScreen object

        // You need to adjust the following values to your Screen dimensions

        MyScreen screen = new MyScreen();
        //Setting a title to the GUI window
        screen.setTitle("Assignment-1 by Harrison, Christian, and Evan");
        //setting the size of the window
        screen.setSize(975 + sortArea.total_number_of_lines, 600);
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

        ArrayList<AlgorithmDemo> demos = new ArrayList<>();
        int unRunDemos = 0;

        //the default constructor for the class MyScreen
        public MyScreen() {
            // Panel where sorted lines_lengths will be displayed
            //The scramble button's text will be blue
            scramble_button.setForeground(Color.BLUE);
            //setting the font of scramble button
            scramble_button.setFont(new Font("Arial", Font.BOLD, 15));

            SortingAlgorithm[] algorithms = {
                new IterativeMergeSort(sortArea),
                new BubbleSort(sortArea),
                new SelectionSort(sortArea),
                new ShellSort(sortArea),
                new InsertionSort(sortArea),
                new RecursiveMergeSort(sortArea),
                new RecursiveQuickSort(sortArea)
            };

            for (SortingAlgorithm algorithm : algorithms) {
                AlgorithmDemo demo = new AlgorithmDemo(algorithm);
                demo.addStartButtonListener(e -> { this.runDemo(demo); });
                demos.add(demo);
                demo.setEnabled(false);
            }

            // Panel listing the available sorting algorithm demos
            JPanel algorithmChecklist = new JPanel(new GridLayout(0, 1, 3, 3));
            algorithmChecklist.setBorder(new javax.swing.border.TitledBorder("Sorting Algorithms"));

            // Panel listing statistics for each demo upon completion
            JPanel statisticsPanel = new JPanel(new GridLayout(0, 1, 3, 3));

            for (AlgorithmDemo demo : this.demos) {
                algorithmChecklist.add(demo.getStartButton());
                statisticsPanel.add(demo.getTimeLabel());
                statisticsPanel.add(demo.getTimeValue());
            }

            JPanel buttons_area_Panel = new JPanel(new GridBagLayout());
            buttons_area_Panel.add(scramble_button, makeConstraint(0, 0, 1.0, 0.5));
            buttons_area_Panel.add(algorithmChecklist, makeConstraint(0, 1, 1.0, 0.75));
            buttons_area_Panel.add(statisticsPanel, makeConstraint(0, 2, 1.0, 1.5));

            buttons_area_Panel.setSize(new Dimension(50, 450));

            //placing the buttons_area_Panel to the east side of the window
            add(buttons_area_Panel, BorderLayout.EAST);
            //placing the sortArea object in the center of the window
            add(sortArea, BorderLayout.CENTER);

            scramble_button.addActionListener(e -> {
                if (scramble_button.getText().equals("Reset")) {
                    sortArea.reset();
                    this.unlockOptions();
                } else {
                    sortArea.scramble_the_lines();
                    this.resetOptions();
                }

                scramble_button.setEnabled(false);
            });
        }

        public GridBagConstraints makeConstraint(int x, int y, double width, double height) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = x;
            constraints.gridy = y;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = width;
            constraints.weighty = height;
            constraints.fill = GridBagConstraints.BOTH;
            return constraints;
        }

        // the program is currently performing a demo, lock the interface
        public void lockOptions() {
            for (AlgorithmDemo demo : this.demos) {
                demo.setEnabled(false);
            }
        }

        // the array is shuffled, unlock all unused demos or the reset button if all are used (otherwise disable it)
        public void unlockOptions() {
            for (AlgorithmDemo demo : this.demos)
                demo.setEnabled(!demo.getUsedStatus());
        }

        public void resetOptions() {
            for (AlgorithmDemo demo : this.demos) demo.reset();

            unRunDemos = demos.size();
        }

        public void runDemo(AlgorithmDemo demo) {
            // disable interface while a demo is running
            // Note: with the current implementation sort() is blocking and this doesn't seem to have any effect, but
            //  it's probably better not to rely on that fact
            this.lockOptions();
            demo.sort();
            unRunDemos -= 1;

            this.scramble_button.setText((unRunDemos > 0)? "Reset" : "Scramble");
            this.scramble_button.setEnabled(true);
        }
    }
}
