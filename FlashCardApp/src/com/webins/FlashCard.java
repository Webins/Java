package com.webins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FlashCard {
    //instace variables
    private JTextArea question;
    private JTextArea answer;
    private JFrame frame;
    private ArrayList<Cards> cardsLists;
    private boolean questionBorder = false;
    private boolean answerBorder = false;
    public FlashCard(){
        cardsLists = new ArrayList<Cards>();
        frame = new JFrame("Flash Card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // panel that holds everythin
        JPanel mainPanel = new JPanel();

        //create font
        Font greatFont = new Font("Helvetica Neue", Font.BOLD, 21);

        question = new JTextArea(6,20);
        //set Line wrap makes sure that the text fit on the textArea
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(greatFont);
        question.setName("Question");

        JScrollPane qScrollPane = new JScrollPane(question);
        qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(greatFont);
        answer.setName("Answer");

        JScrollPane aScrollPane = new JScrollPane(answer);
        aScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next card");

        //create font
        Font labelFont = new Font("Helvetica", Font.ITALIC | Font.BOLD, 16);

        JLabel questionLabel = new JLabel("Question");
        questionLabel.setFont(labelFont);
        JLabel answerLabel= new JLabel("Answer");
        answerLabel.setFont(labelFont);

        //Add components
        mainPanel.add(questionLabel);
        mainPanel.add(qScrollPane);
        mainPanel.add(answerLabel);
        mainPanel.add(aScrollPane);
        mainPanel.add(nextButton);

        //Menu bar container for menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        //the item on the menu that fires an action
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        //ataching the itms tu the menu
        fileMenu.add(saveMenuItem);
        fileMenu.add(newMenuItem);
        menuBar.add(fileMenu);

        question.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(isQuestionBorder()){
                    question.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
                    setQuestionBorder(false);
                }if(isAnswerBorder()){
                    answer.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
                    setAnswerBorder(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        answer.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(isQuestionBorder()){
                    question.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
                    setQuestionBorder(false);
                }if(isAnswerBorder()){
                    answer.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
                    setAnswerBorder(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //connecting the button to a listener in other class
        nextButton.addActionListener(new nextCardListener());
        newMenuItem.addActionListener(new newMenuListener());
        saveMenuItem.addActionListener(new saveMenuListener());
        //add to the frame
        frame.setJMenuBar(menuBar); //only for Jmenubar
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(480,500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlashCard());
    }

    public boolean isAnswerBorder() {
        return answerBorder;
    }

    public void setAnswerBorder(boolean answerBorder) {
        this.answerBorder = answerBorder;
    }

    public boolean isQuestionBorder() {
        return questionBorder;
    }

    public void setQuestionBorder(boolean questionBorder) {
        this.questionBorder = questionBorder;
    }

    class nextCardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cardsLists.add(new Cards(question.getText(), answer.getText()));
            if(question.getText().length() > 0 && answer.getText().length() > 0){
                for(Cards card: cardsLists){
                    if(card.getAnswer() == answer.getText() && card.getQuestion() == question.getText()){
                        cardsLists.remove(card);
                    }
                }
                question.setText("");
                answer.setText("");
                question.requestFocus();
            }else{
                if(question.getText().length() <= 0){
                    markBorder(true, question);
                    question.setBorder(BorderFactory.createLineBorder(Color.decode("#d9534f")));
                }if(answer.getText().length() <= 0){
                    markBorder(true, answer);
                    answer.setBorder(BorderFactory.createLineBorder(Color.decode("#d9534f")));
                }
            }
        }

        public void markBorder(boolean b, JTextArea area) {
            if(area.getName() == "Question"){
                setQuestionBorder(true);
            }if(area.getName() == "Answer"){
                setAnswerBorder(true);
            }
        }
    }

    class newMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("New");
        }
    }

    class saveMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           //create a file dialog
            cardsLists.add(new Cards(question.getText(), answer.getText()));
            JFileChooser fileSaving = new JFileChooser();
            fileSaving.showSaveDialog(frame);
            saveFile(fileSaving.getSelectedFile());
        }

        private void saveFile(File selectedFile) {
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                Iterator<Cards> cardsIterator = cardsLists.iterator();
                while(cardsIterator.hasNext()){
                    Cards card = cardsIterator.next();
                    if(card.getAnswer().length() >0 && card.getQuestion().length() >0){
                        writer.write(card.getQuestion() + "/");
                        writer.write(card.getAnswer() + "\n");
                    }
                }
                writer.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

