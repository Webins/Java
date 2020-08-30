package com.webins;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo {

    public SwingDemo(){

        // inside here we create a new JFrame container
        JFrame jFrame = new JFrame("Swing");

        // Create a JLabel, JLabel is a component that allow to add text to our frame
        JLabel jLabel = new JLabel("Hello from Swing");

        // Create a JTextArea. A text area is an input component from large texts
        JTextArea jTextArea;

        // We add to the jFrame the text area with a scroll scroll that help to navigate better the text areas. it will start the cursor at the bottom of the text area.
        jFrame.add(new JScrollPane(jTextArea = new JTextArea(5, 30)), BorderLayout.PAGE_START);
        //Specify FlowLayout for the layout manager. It allows the components to aligns correctly
        jFrame.setLayout(new FlowLayout());

        // when we initialize the frame it has no size so we need to add
        jFrame.setSize(2000,350); //width and height

        // Terminate the program when the user closes the app
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the buttons
        JButton jButton1 = new JButton("Show");
        JButton jButton2 = new JButton("Hidden");
        JButton jButton3 = new JButton("Change");

        // Add event listener to buttons
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setVisible(true);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setVisible(false);
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTextArea.getText().length() > 0){
                    jLabel.setText(jTextArea.getText());
                }
            }
        });

        // set the size for the buttons
        jButton1.setSize(50,25);
        jButton2.setSize(50, 25);
        jButton3.setSize(50,25);

        //Add the field and the change button
        jFrame.add(jButton3);

        // Add the label
        jFrame.add(jLabel);

        //add the buttons to the frame container
        jFrame.add(jButton1);
        jFrame.add(jButton2);

        // make it visible
        jFrame.setVisible(true);

    }
    public static void main(String[] args) {
        // First gui application

        //create the frame on the event dispathcing thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });

    }
}
