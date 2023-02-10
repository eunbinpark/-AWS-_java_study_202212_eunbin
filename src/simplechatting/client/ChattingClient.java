package simplechatting.client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChattingClient extends JFrame {

	private Socket socket;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JScrollPane userListScroll;
	private JList userList;
	private JTextField usernameInput;
	private JButton joinButton;
	private JScrollPane messageScroll;
	private JTextField messageInput;
	private JButton sendButton;

	private DefaultListModel<String> UserListModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(348, 11, 98, 32);
		contentPane.add(ipInput);
		ipInput.setColumns(10);

		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;

				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());

				try {
					socket = new Socket(ip, port);

					JOptionPane.showMessageDialog(null, socket.getInetAddress() + "서버 접속", "접속성공",
							JOptionPane.INFORMATION_MESSAGE);

					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					if (in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null, "사용자의 이름을 입력하세요.",
								JOptionPane.INFORMATION_MESSAGE);

						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);

						out.println(username);
					}

					Thread thread = new Thread(() -> {
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));

							while (true) {
								String message = reader.readLine();
								if(message.startsWith("@welcome")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
								} else if(message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									UserListModel.clear();
									for (String username : usernames) {
										UserListModel.addElement(username);
									}
									continue;
								}
								contentView.append(message + "\n");
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					});

					thread.start();

				} catch (ConnectException e1) {

					JOptionPane.showMessageDialog(null, "서버 접속 실패", "접속실패", JOptionPane.ERROR_MESSAGE);

				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(512, 10, 74, 33);
		contentPane.add(connectButton);

		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(454, 11, 50, 32);
		contentPane.add(portInput);
		portInput.setColumns(10);

		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 11, 324, 351);
		contentPane.add(contentScroll);

		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);

		userListScroll = new JScrollPane();
		userListScroll.setBounds(348, 95, 238, 267);
		contentPane.add(userListScroll);

		UserListModel = new DefaultListModel<>();
		userList = new JList(UserListModel);
		userListScroll.setViewportView(userList);

		usernameInput = new JTextField();
		usernameInput.setBounds(348, 53, 156, 32);
		contentPane.add(usernameInput);
		usernameInput.setColumns(10);

		joinButton = new JButton("접속");
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		joinButton.setBounds(512, 53, 74, 32);
		contentPane.add(joinButton);

		messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 372, 477, 41);
		contentPane.add(messageScroll);

		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!messageInput.getText().isBlank()) {
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);

							out.println(username + " : " + messageInput.getText());
							messageInput.setText("");

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		messageScroll.setViewportView(messageInput);

		sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!messageInput.getText().isBlank()) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);

						out.println(username + " : " + messageInput.getText());
						messageInput.setText("");

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		sendButton.setBounds(501, 372, 85, 39);
		contentPane.add(sendButton);
	}
}
