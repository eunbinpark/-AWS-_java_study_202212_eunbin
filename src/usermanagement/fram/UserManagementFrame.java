package usermanagement.fram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonObject;

import usermanagement.service.UserService;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManagementFrame extends JFrame {

	private List<JTextField> loginFields;
	private List<JTextField> registerFields;
	private CardLayout mainCard;

	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementFrame() {
		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);

		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));

		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);

		JLabel logoText = new JLabel("User Management");
		logoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(77, 35, 235, 52);
		loginPanel.add(logoText);

		JLabel loginText = new JLabel("Login");
		loginText.setFont(new Font("CookieRun Regular", Font.PLAIN, 24));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(136, 84, 112, 33);
		loginPanel.add(loginText);

		usernameField = new JTextField();
		usernameField.setBounds(27, 186, 333, 27);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(27, 242, 333, 27);
		loginPanel.add(passwordField);

		JLabel usernameLabel = new JLabel("Username or email");
		usernameLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		usernameLabel.setBounds(27, 164, 155, 15);
		loginPanel.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		passwordLabel.setBounds(27, 223, 155, 15);
		loginPanel.add(passwordLabel);

		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userLoginJson = new JsonObject();
				userLoginJson.addProperty("usernameAndEmail", usernameField.getText());
				userLoginJson.addProperty("password", passwordField.getText());

				UserService userService = UserService.getInstance();

				Map<String, String> response = userService.authorize(userLoginJson.toString());

				if (response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.setFont(new Font("CookieRun Regular", Font.BOLD, 16));
		loginButton.setBounds(27, 290, 333, 38);
		loginPanel.add(loginButton);

		JLabel signupDesc = new JLabel("Don't have an account?");
		signupDesc.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signupDesc.setBounds(91, 375, 133, 15);
		loginPanel.add(signupDesc);

		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields);
			}
		});
		signupLink.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signupLink.setForeground(new Color(0, 153, 255));
		signupLink.setBounds(238, 375, 43, 15);
		loginPanel.add(signupLink);

		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setForeground(new Color(0, 153, 255));
		forgotPasswordLink.setFont(new Font("D2Coding", Font.PLAIN, 12));
		forgotPasswordLink.setBounds(125, 400, 133, 15);
		loginPanel.add(forgotPasswordLink);

		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);

		JLabel signinLink = new JLabel("Sign in");
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		signinLink.setForeground(new Color(0, 153, 255));
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(240, 424, 132, 15);
		registerPanel.add(signinLink);

		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("CookieRun Regular", Font.PLAIN, 24));
		registerText.setBounds(136, 84, 112, 33);
		registerPanel.add(registerText);

		JLabel registerLogoText = new JLabel("User Management");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		registerLogoText.setBounds(77, 35, 235, 52);
		registerPanel.add(registerLogoText);

		JLabel registerUsernameLable = new JLabel("Username");
		registerUsernameLable.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerUsernameLable.setBounds(28, 127, 155, 15);
		registerPanel.add(registerUsernameLable);

		registerUsernameField = new JTextField();
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(28, 149, 333, 27);
		registerPanel.add(registerUsernameField);

		registerPasswordField = new JPasswordField();
		registerPasswordField.setBounds(28, 205, 333, 27);
		registerPanel.add(registerPasswordField);

		JLabel registerPasswordLabel = new JLabel("Password");
		registerPasswordLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerPasswordLabel.setBounds(28, 186, 155, 15);
		registerPanel.add(registerPasswordLabel);

		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerNameLabel.setBounds(28, 246, 155, 15);
		registerPanel.add(registerNameLabel);

		registerNameField = new JTextField();
		registerNameField.setColumns(10);
		registerNameField.setBounds(28, 268, 333, 27);
		registerPanel.add(registerNameField);

		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		registerEmailLabel.setBounds(28, 307, 155, 15);
		registerPanel.add(registerEmailLabel);

		registerEmailField = new JTextField();
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(28, 329, 333, 27);
		registerPanel.add(registerEmailField);

		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());

				UserService userService = UserService.getInstance();

				Map<String, String> response = userService.register(userJson.toString());

				if (response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		registerButton.setFont(new Font("CookieRun Regular", Font.BOLD, 16));
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(28, 376, 333, 38);
		registerPanel.add(registerButton);

		loginFields.add(usernameField);
		loginFields.add(passwordField);

		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
	}

	private void clearFields(List<JTextField> textField) {
		for (JTextField field : textField) {
			if (field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
	}
}
