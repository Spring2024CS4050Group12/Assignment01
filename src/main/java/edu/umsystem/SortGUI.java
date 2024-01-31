/**
 * @author Ouda
 */
package edu.umsystem;

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JRadioButton reset = new JRadioButton("Reset");

        ArrayList<AlgorithmDemo> demos = new ArrayList<>();

        IterativeMergeSort iterativeMergeSort;
        AlgorithmDemo iterativeMergeSortDemo;

        //the default constructor for the class MyScreen
        public MyScreen() {
            // Panel where sorted lines_lengths will displayed
            //The scramble button's text will be blue
            scramble_button.setForeground(Color.BLUE);
            //setting the font of scramble button
            scramble_button.setFont(new Font("Arial", Font.BOLD, 15));
            //A Panel to hold the radio_button_selection and set the GridLayout
            JPanel radio_button_selection_Panel = new JPanel(new GridLayout(4, 1, 3, 3));

            iterativeMergeSort = new IterativeMergeSort(sortArea);
            iterativeMergeSortDemo = new AlgorithmDemo(iterativeMergeSort, e -> {
                // TODO: extract this and temporarily disable everything in demos and restore to usedStatus afterward
                iterativeMergeSortDemo.sort();
                iterativeMergeSortDemo.setEnabled(false);
            });

            demos.add(iterativeMergeSortDemo);

            //Adding the selection button to the radio_button_selection_Panel
            radio_button_selection_Panel.add(iterativeMergeSortDemo.getStartButton());
            //Adding the reset button to the radio_button_selection_Panel
            radio_button_selection_Panel.add(reset);
            //giving the radio_button_selection_Panel a border with a title
            radio_button_selection_Panel.setBorder(new javax.swing.border.TitledBorder("Sort Algorithms"));

            //A Panel to hold the time_Panel and set the GridLayout
            JPanel time_Panel = new JPanel(new GridLayout(6, 1, 3, 3));
            //Adding the selection_time_label to the time_Panel
            time_Panel.add(iterativeMergeSortDemo.getTimeLabel());
            //Adding the selection_time_taken to the time_Panel
            time_Panel.add(iterativeMergeSortDemo.getTimeValue());

            //A Panel to hold the buttons_area_Panel and set the GridLayout
            //This buttons_area_Panel will hold scrambleButton, radio_button_selection and the time_Panel
            JPanel buttons_area_Panel = new JPanel(new GridLayout(5, 1, 5, 5));
            //adding scramble_button to the buttons_area_Panel
            buttons_area_Panel.add(scramble_button);
            //adding radio_button_selection_Panel to the buttons_area_Panel
            buttons_area_Panel.add(radio_button_selection_Panel);
            //adding time_Panel to the buttons_area_Panel
            buttons_area_Panel.add(time_Panel);

            //placing the buttons_area_Panel to the east side of the window
            add(buttons_area_Panel, BorderLayout.EAST);
            //placing the sortArea object in the center of the window
            add(sortArea, BorderLayout.CENTER);

            //The following code is for creating a listener for each GUI element

            //Creating an action listener for scramble button
            //This button will be used to scramble the lines in a random way
            //this same scrambled lines will be used for all threes sort methods used in this program
            scramble_button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Scrambling the lines_lengths array
                    sortArea.scramble_the_lines();
                    //Since it has already been clicked, it will no longer be enabled
                    scramble_button.setEnabled(false);
                    //setting all booleans true except for reset
                }
            });

            //Creating an action listener for reset button
            reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //disabling reset since it was clicked
                    reset.setEnabled(false);
                    //reseting the lines_lengths to its scrambled lines
                    sortArea.reset();

                    //There are many different combinations of what could be clicked
                    //The following code below covers all possibilities
                    //FOr the following use the same comments as above
//                    if (Selection_Done && Recersive_Merge_Done && Iterative_Merge_Done) {
//                        scramble_button.setEnabled(true);
//                        Recersive_Merge_Done = false;
//                        Iterative_Merge_Done = false;
//                        Selection_Done = false;
//                        Set_Available_Chooses(false, false, false, false);
//                        selection_time_taken.setText("");
//                        rmerge_time_taken.setText("");
//                        imerge_time_taken.setText("");
//
//                    } else if (Recersive_Merge_Done && Iterative_Merge_Done) {
//                        Set_Available_Chooses(true, false, false, false);
//
//                    } else if (Selection_Done && Recersive_Merge_Done) {
//
//                        Set_Available_Chooses(false, false, true, false);
//
//                    } else if (Selection_Done && Iterative_Merge_Done) {
//                        Set_Available_Chooses(false, true, false, false);
//
//                    } else if (Selection_Done) {
//                        Set_Available_Chooses(false, true, true, false);
//
//                    } else if (Recersive_Merge_Done) {
//                        Set_Available_Chooses(true, false, true, false);
//
//                    } else {
//                        Set_Available_Chooses(true, true, false, false);
//
//                    }
                }
            });
        }
    }
}
