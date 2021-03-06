package view.chat;

import util.chat.Chatbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

public class ChatboxView extends JPanel {

    private JEditorPane convoPane;
    private JScrollPane convoScrollPane;
    private JTextArea textArea;
    private JButton submitButton;
    private Chatbox chatbox = new Chatbox();

    public ChatboxView() {
        setupChatboxView();
    }


    public void setupChatboxView() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /* this is where you will see the conversation occur */
        this.convoPane = new JEditorPane();
        convoPane.setEnabled(false);
        this.convoScrollPane = new JScrollPane(convoPane);

        //action listener

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convoPane.setText(chatbox.getOneChat());
            }
        };

        Timer timer = new Timer(2000, actionListener);
        timer.start();

        //

        /* THIS IS WHERE YOU CAN WRITE A CHAT RESPONSE */
        this.textArea = new JTextArea("Write to the chat...", 5, 10);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        /* button to click to submit your response */
        this.submitButton = new JButton();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convoPane.setText(textArea.getText());
            }
        });


        /* sets preferred size for all JComponents */
        convoScrollPane.setPreferredSize(new Dimension(250, 200));
        textArea.setPreferredSize(new Dimension(250, 200));
        submitButton.setPreferredSize(new Dimension(10, 20));

        /* sets minimum size for all the JComponents */
        convoScrollPane.setMinimumSize(new Dimension(250, 100));
        textArea.setMinimumSize(new Dimension(250, 100));
        submitButton.setMinimumSize(new Dimension(10, 20));



        /* do single edits on convo panel */
        convoScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        convoScrollPane.setMinimumSize(new Dimension(10, 10));

        /* do single edits on text area */
        textArea.setLineWrap(true);


        /* do single edits on the button */
        submitButton.setText("submit chat");

        /* set the border of the chat box */
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Chatbox"),
                BorderFactory.createEmptyBorder(5,5,5,5)));


        /* add all the sub components we've been adding into ONE chat box view */
        add(convoScrollPane);
        add(scrollPane);
        add(submitButton);


    }


}
