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

    private Webshop ws;

    public GUI(Webshop ws) {
        this.ws = ws;
    }

    public void getLoginWindow () {

        welcomeLabel = new JLabel("Welcome to the shoe shop!", SwingConstants.CENTER);
        welcomeLabel.setPreferredSize(new Dimension(200, 50));

        nameLabel = new JLabel("Username:", SwingConstants.RIGHT);
        nameLabel.setPreferredSize(new Dimension(40, 20));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 20));

        passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
        passwordLabel.setPreferredSize(new Dimension(40, 20));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 20));

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(welcomeLabel, BorderLayout.NORTH);

        JPanel centerPane = new JPanel();
        centerPane.setLayout(new GridLayout(2,2));
        centerPane.add(nameLabel); centerPane.add(nameField);
        centerPane.add(passwordLabel); centerPane.add(passwordField);
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
        if (e.getSource().equals(loginButton)) {
            String username = nameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            System.out.println(username + " " + password);
        }
    }
}
