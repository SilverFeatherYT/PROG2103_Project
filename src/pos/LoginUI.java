
package pos;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

public class LoginUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private LoginDatabase loginManager;

    public LoginUI(LoginDatabase loginManager) {
        this.loginManager = loginManager;

        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500, 1000);
        setLayout(null);

        // Set Background Image
        ImageIcon bg = new ImageIcon("image/wave.png");
        JLabel BG = new JLabel();
        BG.setIcon(bg);
        BG.setSize(1920, 1080);

        // Set a panel to put component login
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
        panelLogin.setBounds(390, 180, 700, 600);
        panelLogin.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 255), null, null, new Color(255, 255, 204)));
        panelLogin.setLayout(null);

        // Set Pos Logo at panel
        ImageIcon logo = new ImageIcon("image/logo.png");
        Image NewLogo = logo.getImage();
        Image NewLogo1 = NewLogo.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        JLabel LOGO = new JLabel();
        logo = new ImageIcon(NewLogo1);
        LOGO.setIcon(logo);
        LOGO.setBounds(270, 30, 150, 150);
        panelLogin.add(LOGO);

        // Set a eye icon to show password
        ImageIcon eye = new ImageIcon("image/view.png");
        Image EYE = eye.getImage();
        Image EYECHANGE = EYE.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        JLabel eye1 = new JLabel();

        // Set a eye icon to hide password
        ImageIcon eyeclose = new ImageIcon("image/hide.png");
        Image EYEC = eyeclose.getImage();
        Image EYECLOSE = EYEC.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        JLabel eyeclose1 = new JLabel();

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(550, 395, 95, 45);
        usernameLabel.setFont(new Font("Geneva", Font.PLAIN, 20));
        panelLogin.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(550, 475, 95, 45);
        passwordLabel.setFont(new Font("Geneva", Font.PLAIN, 20));
        panelLogin.add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(658, 403, 220, 35);
        usernameField.setFont(new Font("Geneva", Font.PLAIN, 18));
        panelLogin.add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(658, 483, 220, 35);
        passwordField.setFont(new Font("Geneva", Font.PLAIN, 18));
        panelLogin.add(passwordField);

        eye1.setBounds(190, 3, 30, 30);
        passwordField.add(eye1);
        eye = new ImageIcon(EYECHANGE);
        eye1.setIcon(eye);
        eye1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                eye1.setVisible(false);
                eyeclose1.setVisible(true);
                passwordField.setEchoChar((char) 0);
            }
        });

        eyeclose1.setBounds(190, 3, 30, 30);
        passwordField.add(eyeclose1);
        eyeclose = new ImageIcon(EYECLOSE);
        eyeclose1.setIcon(eyeclose);
        eyeclose1.setVisible(false);
        eyeclose1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                eye1.setVisible(true);
                eyeclose1.setVisible(false);
                passwordField.setEchoChar('•');
            }
        });

        loginButton = new JButton("Login");
        loginButton.setBounds(738, 550, 140, 30);
        loginButton.setText("Login");
        loginButton.setFont(new Font("Geneva", Font.PLAIN, 20));
        loginButton.setFocusable(false);
        panelLogin.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(550, 550, 140, 30);
        registerButton.setText("Register");
        registerButton.setFont(new Font("Geneva", Font.PLAIN, 20));
        registerButton.setFocusable(false);
        panelLogin.add(registerButton);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);
        add(panelLogin);
        add(BG);

        // Login the user
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Username and password are required.");
                } else if (loginManager.checkUserCredentials(username, password)) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Login successful!");
                    dispose();
                    new Home().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginUI.this, "Invalid username or password.");
                }
            }
        });

        // Register new user
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Username and password are required.");
                } else {
                    loginManager.insertUser(username, password);
                    JOptionPane.showMessageDialog(LoginUI.this, "User registered successfully!");
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });
    }

    // Start the project by login page
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginDatabase loginManager = new LoginDatabase();

                new LoginUI(loginManager).setVisible(true);
//                new Home().setVisible(true);
                loginManager.createTable();
                loginManager.closeConnection();
            }
        });
    }
}
