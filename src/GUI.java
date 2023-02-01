import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI extends JFrame implements ActionListener {
    private JLabel welcomeLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public GUI() {
        super("Shoe Shop Login");

        // Create welcome label
        welcomeLabel = new JLabel("Welcome to the shoe shop", SwingConstants.CENTER);
        welcomeLabel.setPreferredSize(new Dimension(250, 50));

        // Create name label and text field
        nameLabel = new JLabel("Name:", SwingConstants.RIGHT);
        nameLabel.setPreferredSize(new Dimension(50, 20));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 20));

        // Create password label and password field
        passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
        passwordLabel.setPreferredSize(new Dimension(50, 20));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 20));

        // Create login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        // Add components to the content pane
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(welcomeLabel, BorderLayout.NORTH);

        JPanel centerPane = new JPanel();
        centerPane.setLayout(new GridLayout(2,2));
        centerPane.add(nameLabel);
        centerPane.add(nameField);
        centerPane.add(passwordLabel);
        centerPane.add(passwordField);
        contentPane.add(centerPane, BorderLayout.CENTER);

        contentPane.add(loginButton, BorderLayout.SOUTH);
        setContentPane(contentPane);


        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Add code here to handle the login button being clicked
        System.out.println("du har tryckt på knappen");
    }

    public static void main(String[] args) {
        new GUI();
    }
}
