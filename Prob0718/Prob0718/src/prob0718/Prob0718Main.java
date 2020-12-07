package prob0718;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Chapter 7, Problem 18 from <i>Computer Systems</i>.
 *
 * <p>
 * File: <code>Prob0718.java</code>
 *
 * <p>
 * Name: Martin Owen Sagide
 *
 * <p>
 * Date:
 *
 * <p>
 * Assignment: ASSIGNMENT 12
 */
public class Prob0718Main implements ActionListener {

    final JFrame mainWindowFrame;
    final JPanel inputPanel;
    final JLabel label;
    final JTextField textField;
    final JPanel buttonPanel;
    final JButton button;

    public Prob0718Main() {
        // Set up the main window.
        mainWindowFrame = new JFrame("Problem 7.18");
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindowFrame.setSize(new Dimension(240, 120));

        // Lay out the label and text field input panel from top to bottom.
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        label = new JLabel("Enter a number:");
        inputPanel.add(label);
        textField = new JTextField(20);
        inputPanel.add(textField);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Lay out the button from left to right.
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        button = new JButton("Parse");
        buttonPanel.add(button);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        // Combine the input panel and the button panel in the main window.
        mainWindowFrame.add(inputPanel, BorderLayout.CENTER);
        mainWindowFrame.add(buttonPanel, BorderLayout.PAGE_END);

        textField.addActionListener(this);
        button.addActionListener(this);

        mainWindowFrame.pack();
        mainWindowFrame.setVisible(true);
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Prob0718Main();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Prob0718Main::createAndShowGUI);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String line = textField.getText();
        // Exercise for the student.
        // Remove the following code and parse the decimal number here.
        Parser parser = new Parser();
        parser.parseNum(line);
        if (parser.getValid()) {
            System.out.printf("%s is valid: %d\n",line, parser.getNumber());
        }else {
            System.out.printf("%s is not valid.\n", line);
        }
    }
}
