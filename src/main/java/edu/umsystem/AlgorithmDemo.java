package edu.umsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class AlgorithmDemo {
    Algorithm algorithm;
    JRadioButton startButton;
    JLabel timeLabel;
    JLabel timeValue;
    Boolean usedStatus = false;

    public AlgorithmDemo(Algorithm algorithm, ActionListener onStart) {
        this.algorithm = algorithm;
        this.startButton = new JRadioButton(algorithm.getName());
        this.startButton.addActionListener(onStart);
        this.timeLabel = new JLabel(String.format("%s Time", algorithm.getName()));
        this.timeLabel.setForeground(Color.BLUE);
        this.timeValue = new JLabel();
        this.timeValue.setForeground(Color.RED);
    }

    public JRadioButton getStartButton() {
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

    public void sort() {
        long start = Calendar.getInstance().getTime().getTime();
        this.algorithm.sort();
        long end = Calendar.getInstance().getTime().getTime();

        this.timeValue.setText(String.format("%f Seconds", (end - start) / 1000.f));
    }

    public void reset() {
        this.startButton.setEnabled(true);
        this.timeValue.setText("");
    }
}
