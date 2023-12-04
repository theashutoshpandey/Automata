package deviser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel logo = new JLabel();
    JLabel message = new JLabel();

    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    public void createLoginGui() {
        setTitle("Automata Test - Login");
        setBounds(10, 10, 370, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        setIconImage(icon);

        setVisible(true);

    }

    LoginFrame() {
        setFrameIcon();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        addBorder();

    }

    public void setFrameIcon() {
        logo.setIcon(new ImageIcon("logo.png"));
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        logo.setBounds(80, 30, 200, 60);
        message.setBounds(50, 320, 250, 30);
        userLabel.setBounds(50, 120, 100, 30);
        loginButton.setBounds(50, 270, 100, 20);
        resetButton.setBounds(200, 270, 100, 20);
        passwordLabel.setBounds(50, 170, 100, 30);
        showPassword.setBounds(150, 210, 150, 30);
        userTextField.setBounds(150, 120, 150, 30);
        passwordField.setBounds(150, 170, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(logo);
        container.add(message);
        container.add(userLabel);
        container.add(loginButton);
        container.add(resetButton);
        container.add(showPassword);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
    }

    public void addBorder() {
        loginButton.setBorder(new RoundedBorder(18));
        resetButton.setBorder(new RoundedBorder(18));
        userTextField.setBorder(new RoundedBorder(6));
        passwordField.setBorder(new RoundedBorder(6));
    }

    public void addActionEvent() {
        resetButton.addActionListener(this);
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = passwordField.getText();

            if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("root@123")) {
                // JOptionPane.showMessageDialog(this, "Login Successful");
                message.setText("Login Successful !");
                UserSpaceHandle userSpaceHandle = new UserSpaceHandle();
                userSpaceHandle.createUserHandleGui();
                dispose();
            } else {
                // JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                message.setText("Invalid Username or Password !");
            }

        }
        // Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            message.setText("");
        }
        // Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }

}