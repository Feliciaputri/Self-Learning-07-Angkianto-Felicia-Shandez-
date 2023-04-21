package AdventureTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationFrame extends JInternalFrame implements ActionListener
{
    private JLabel headerLabel = new JLabel("Registration");
    private JPanel footerPanel = new JPanel();
    private JPanel centerPanel = new JPanel(new GridLayout(3, 2));
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel ageLabel = new JLabel("Age");
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField usernameField = new JTextField();
    private JFormattedTextField ageField = new JFormattedTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton submitBtn = new JButton("Register");

    public RegistrationFrame() {
        super("", false, true);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);
        centerPanel.add(usernameLabel);
        centerPanel.add(usernameField);

        centerPanel.add(ageLabel);
        centerPanel.add(ageField);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        add(centerPanel);

        footerPanel.add(submitBtn);
        submitBtn.addActionListener(this);
        add(footerPanel, BorderLayout.SOUTH);
        setVisible(true);
        setBounds(10, 10, 300, 170);
    }

    private JFrame parent = null;

    public void setParent(JFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(usernameField.getText().isBlank() || usernameField.getText().length() < 8) {
            JOptionPane.showMessageDialog(this, "User name must be more than 8 characters");
        }else if(passwordField.getPassword().length < 5){
            JOptionPane.showMessageDialog(this, "Password must be more than 5 characters");
        }
        else {
            dataPlayer data = new dataPlayer(usernameField.getText(), Integer.parseInt(ageField.getText()), passwordField.getPassword());
            Main.listPlayer.add(data);
            JOptionPane.showMessageDialog(this, "Success to register!");
            if (parent instanceof Main frame) {
                frame.login(usernameField.getText());
            }
            this.dispose();
        }
    }
}
