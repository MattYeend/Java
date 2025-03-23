/*
 * Author:  Matthew Yeend
 * Project: Simple Chat Bot
 * Version: v1.1.1
 * Date:    23/03/2025
 */

package matthewyeend.simplechatbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author matthewyeend
 */
public class SimpleChatBot extends JFrame {
private JTextArea chatArea;
    private JTextField userInput;
    private JButton sendButton;
    
    // Predefined chatbot responses
    private Map<String, String> responses;

    public SimpleChatBot() {
        // Initialize chatbot responses
        responses = new HashMap<>();
        responses.put("hello", "Hi there! How can I assist you today?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! Thanks for asking.");
        responses.put("your name", "I'm JavaBot, your virtual assistant!");
        responses.put("bye", "Goodbye! Have a wonderful day!");
        responses.put("weather", "I can't check live weather, but you can try a weather app!");
        responses.put("help", "I can chat with you! Ask me about time, date, weather, or general facts.");
        responses.put("joke", "Why don't programmers like nature? Too many bugs!");
        responses.put("time", "I'm not a real clock, but you can check your device!");
        responses.put("date", "Today's date is " + java.time.LocalDate.now());
        responses.put("thanks", "You're welcome! Happy to help. 😊");

        // Set up JFrame
        setTitle("AI ChatBot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat display area (JTextArea inside JScrollPane)
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // User input field (JTextField)
        userInput = new JTextField();
        
        // Send button
        sendButton = new JButton("Send");

        // Panel for user input and button
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(userInput, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add components to JFrame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Action listeners for sending messages
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        userInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    // Method to send user message and get chatbot response
    private void sendMessage() {
        String userText = userInput.getText().trim().toLowerCase();
        if (!userText.isEmpty()) {
            chatArea.append("You: " + userText + "\n");
            String botResponse = getBotResponse(userText);
            chatArea.append("Bot: " + botResponse + "\n");
            userInput.setText(""); // Clear input field
        }
    }

    // Method to get chatbot response
    private String getBotResponse(String input) {
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }
        return "I'm not sure I understand. Can you rephrase?";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleChatBot());
    }
}
