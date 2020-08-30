package com.webins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlashCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<Cards> cardLists;
    private boolean isShowAnswer;
    private JFrame frame;
    private JButton show;
    private Cards currentCard;

    public FlashCardPlayer(){

        frame = new JFrame("Flash Card Player");
        JPanel mainPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create font
        Font greatFont = new Font("Helvetica Neue", Font.BOLD, 21);
        display = new JTextArea(6,20);
        display.setFont(greatFont);

        JScrollPane qScrollPane = new JScrollPane(display);
        qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        show = new JButton("Show answer");
        mainPanel.add(qScrollPane);
        mainPanel.add(show);
        show.addActionListener(new ShowNextCard());

        //Menu bar container for menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        //the item on the menu that fires an action
        JMenuItem loadItem = new JMenuItem("Load Card Set");


        //attaching the items to the menu
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);

        loadItem.addActionListener(new FlashCardPlayer.LoadItemListener());
        //add to the frame
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(480,350);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new FlashCardPlayer() );
    }

    class ShowNextCard implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isShowAnswer){
                display.setText(currentCard.getAnswer());
                show.setText("Next card");
                isShowAnswer = false;
            }else{
                showNextCard();
            }
        }
    }

    public class LoadItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }

        private void loadFile(File selectedFile) {
                cardLists = new ArrayList<Cards>();
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                    String line = null;
                    while((line = reader.readLine()) != null){
                        makeCard(line);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                    showNextCard();

        }

        private void makeCard(String line) {
            String[] result = line.split("/"); // it will spit the line in two parts and load in repesctively in their indexes
            Cards card = new Cards(result[0], result[1]);
            cardLists.add(card);
        }
    }

    private void showNextCard() {
        if(cardLists.isEmpty()){
            display.setText("There aren't more cards");
            show.setEnabled(false);
        }else{
            display.setText(cardLists.get(0).getQuestion());
            show.setText("Show Answer");
            isShowAnswer = true;
            currentCard = cardLists.get(0);
            cardLists.remove(0);
        }
    }
}
