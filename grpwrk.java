package Work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class grpwrk extends JFrame {
    private JTextField patientNameField, ownerNameField, emailField, addressField, dateField;
    private JRadioButton vet1Button, vet2Button;
    private JButton registerButton, clearButton, exitButton;
    private JLabel messageLabel;

    public grpwrk() {
        // Set up the frame
        setTitle("New Patient Record");
        setSize(400, 350); // Increased height to accommodate the date field
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set custom icon
        ImageIcon icon = new ImageIcon("custom_icon.png");
        setIconImage(icon.getImage());

        // Create and add components
        JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5)); // Updated grid layout for the additional field
        add(panel);

        panel.add(new JLabel("Date (YYYY-MM-DD):")); // Date field on the left
        dateField = new JTextField();
        panel.add(dateField);

        panel.add(new JLabel("Patient Name:"));
        patientNameField = new JTextField();
        panel.add(patientNameField);

        panel.add(new JLabel("Owner Name:"));
        ownerNameField = new JTextField();
        panel.add(ownerNameField);

        panel.add(new JLabel("Email Address:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Address:"));
        addressField = new JTextField();
        panel.add(addressField);

        panel.add(new JLabel("Vet Assigned:"));
        vet1Button = new JRadioButton("Dr. Smith");
        vet2Button = new JRadioButton("Dr. Johnson");
        vet1Button.setSelected(true); // Default selection
        ButtonGroup vetGroup = new ButtonGroup();
        vetGroup.add(vet1Button);
        vetGroup.add(vet2Button);
        JPanel vetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel for vet radio buttons
        vetPanel.add(vet1Button);
        vetPanel.add(vet2Button);
        panel.add(vetPanel); // Add the panel instead of individual buttons

        panel.add(new JLabel()); // Empty cell
        registerButton = new JButton("Register");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
        panel.add(registerButton);
        panel.add(clearButton);
        panel.add(exitButton);

        messageLabel = new JLabel();
        panel.add(messageLabel);

        // Add tooltips
        patientNameField.setToolTipText("Enter patient name");
        ownerNameField.setToolTipText("Enter owner name");
        emailField.setToolTipText("Enter valid email address");
        addressField.setToolTipText("Enter patient address");
        dateField.setToolTipText("Enter date in YYYY-MM-DD format");
        registerButton.setToolTipText("Register new patient (Alt + R)");
        clearButton.setToolTipText("Clear form (Alt + C)");
        exitButton.setToolTipText("Exit form (Alt + X)");

        // Add keyboard shortcuts
        registerButton.setMnemonic(KeyEvent.VK_R);
        clearButton.setMnemonic(KeyEvent.VK_C);
        exitButton.setMnemonic(KeyEvent.VK_X);

        // Add action listeners
        registerButton.addActionListener(e -> registerPatient());
        clearButton.addActionListener(e -> clearForm());
        exitButton.addActionListener(e -> dispose());
    }

    private void registerPatient() {
        String patientName = patientNameField.getText();
        String ownerName = ownerNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String vetAssigned = vet1Button.isSelected() ? "Dr. Smith" : "Dr. Johnson";
        String currentDate = dateField.getText(); // Modified to get the date from the date field

        // Validate input
        if (patientName.isEmpty() || ownerName.isEmpty() || email.isEmpty() || address.isEmpty() || currentDate.isEmpty() || !isValidEmail(email)) {
            messageLabel.setText("Please fill all fields correctly.");
            return;
        }

        // Write to file
        try (PrintWriter writer = new PrintWriter("newpatientfile.txt")) {
            writer.println("**Patient Registration Document**");
            writer.println("Patient Name: " + patientName);
            writer.println("Owner Name: " + ownerName);
            writer.println("Email Address: " + email);
            writer.println("Address: " + address);
            writer.println("Vet Assigned: " + vetAssigned);
            writer.println("Date: " + currentDate);
            messageLabel.setText("Patient registration successful.");
        } catch (IOException e) {
            messageLabel.setText("Error: Failed to write to file.");
        }
    }

    private boolean isValidEmail(String email) {
        // Simple email validation, can be improved
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    private void clearForm() {
        patientNameField.setText("");
        ownerNameField.setText("");
        emailField.setText("");
        addressField.setText("");
        vet1Button.setSelected(true);
        dateField.setText(""); // Clear date field
        messageLabel.setText("");
        patientNameField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            grpwrk form = new grpwrk();
            form.setVisible(true);
        });
    }
}
