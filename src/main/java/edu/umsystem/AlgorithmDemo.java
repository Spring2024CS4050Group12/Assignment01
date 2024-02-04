package edu.umsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class AlgorithmDemo {
    private final SortingAlgorithm algorithm;
    private final JCheckBox startButton;
    private final JLabel timeLabel;
    private final JLabel timeValue;
    private Boolean usedStatus = false;

    public AlgorithmDemo(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
        this.startButton = new JCheckBox(algorithm.getName());
        this.timeLabel = new JLabel(String.format("%s Time", algorithm.getName()));
        this.timeLabel.setForeground(Color.BLUE);
        this.timeValue = new JLabel();
        this.timeValue.setForeground(Color.RED);
    }

    public JCheckBox getStartButton() {
        return startButton;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public JLabel getTimeValue() {
        return timeValue;
    }

    public Boolean getUsedStatus() {
        return usedStatus;
    }

    public void setEnabled(Boolean enabled) {
        startButton.setEnabled(enabled);
    }

    public void addStartButtonListener(ActionListener listener) {
        this.startButton.addActionListener(listener);
    }

    public void sort() {
        long start = Calendar.getInstance().getTime().getTime();
        this.algorithm.sort();
        long end = Calendar.getInstance().getTime().getTime();

        this.timeValue.setText(String.format("%f Seconds", (end - start) / 1000.f));

        usedStatus = true;
    }

    public void reset() {
        this.startButton.setEnabled(true);
        this.usedStatus = false;
        this.startButton.setSelected(false);
        this.timeValue.setText("");
    }
}
