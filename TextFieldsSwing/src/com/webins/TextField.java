package com.webins;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField implements ActionListener{
    JLabel promptLabel;
    JLabel contentLabel;
    JButton reverseButton;
    JTextField jTextField;
    public TextField(){
        JFrame jFrame = new JFrame("Reverse your input!");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500,350); //width and height
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jTextField = new JTextField(10);
        //It will differentiate the actions with this
        jTextField.setActionCommand("textField");

        reverseButton = new JButton("Reverse");
        promptLabel = new JLabel("Enter a text: ");
        contentLabel = new JLabel("");

        //connecting the action listener
        jTextField.addActionListener(this); // adding action listener
        reverseButton.addActionListener(this);

        jFrame.add(promptLabel);
        jFrame.add(jTextField);
        jFrame.add(reverseButton);
        jFrame.add(contentLabel);
        jFrame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reverse")){
            String holder = "";
            for(int i = jTextField.getText().length() -1; i >=0; i--){
                holder += jTextField.getText().charAt(i);
            }
            contentLabel.setText("You Reversed text is : " + holder);
        }else if(e.getActionCommand().equals("textField")){
            contentLabel.setText("You pressed Enter. Text is: " + jTextField.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextField());
    }


}
