package SocketChatting.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Client_S extends JFrame {

	private JPanel mainPanel;
	private JTextField usernameField;
	private JTextField textField;
	private JTextField messageInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_S frame = new Client_S();
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
	public Client_S() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		mainPanel = new JPanel();
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(160, 330, 116, 21);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JButton loginButton = new JButton("New button");
		loginButton.setBounds(172, 377, 97, 23);
		loginPanel.add(loginButton);
		
		JPanel chatListPanel = new JPanel();
		mainPanel.add(chatListPanel, "chatListPanel");
		chatListPanel.setLayout(null);
		
		JScrollPane roomListScroll = new JScrollPane();
		roomListScroll.setBounds(89, 0, 345, 711);
		chatListPanel.add(roomListScroll);
		
		JList roomList = new JList();
		roomListScroll.setViewportView(roomList);
		
		JButton createRoomButton = new JButton("");
		createRoomButton.setBounds(12, 99, 57, 49);
		chatListPanel.add(createRoomButton);
		
		JPanel chatPanel = new JPanel();
		mainPanel.add(chatPanel, "chatPanel");
		chatPanel.setLayout(null);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(0, 54, 434, 594);
		chatPanel.add(contentScroll);
		
		JTextArea contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		textField = new JTextField();
		textField.setBounds(54, 0, 316, 55);
		chatPanel.add(textField);
		textField.setColumns(10);
		
		JButton outRoomButton = new JButton("");
		outRoomButton.setBounds(368, 0, 66, 55);
		chatPanel.add(outRoomButton);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(0, 647, 370, 64);
		chatPanel.add(messageScroll);
		
		messageInput = new JTextField();
		messageScroll.setViewportView(messageInput);
		messageInput.setColumns(10);
		
		JButton sendButton = new JButton("");
		sendButton.setBounds(368, 647, 66, 64);
		chatPanel.add(sendButton);
	}
}
