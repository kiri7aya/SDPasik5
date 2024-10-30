public interface LoginView {
    String getUsername();
    String getPassword();
    void showMessage(String message);
    void setLoginListener(LoginListener listener);
}

public class LoginViewImpl extends JFrame implements LoginView {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginViewImpl() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        setLayout(new GridLayout(3, 2));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public String getUsername() {
        return usernameField.getText();
    }

    @Override
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void setLoginListener(LoginListener listener) {
        loginButton.addActionListener(e -> listener.onLogin());
    }
}
