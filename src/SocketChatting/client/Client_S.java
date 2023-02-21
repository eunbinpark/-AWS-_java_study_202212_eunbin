package SocketChatting.client;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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

import com.google.gson.Gson;

import lombok.Data;
import simplechatting2.dto.JoinReqDto;
import simplechatting2.dto.RequestDto;

public class Client_S extends JFrame {
	
	// 클라이언트를 사용하기 위한 싱글톤
	private static Client_S instance;

	public static Client_S getInstance() {
		if (instance == null) {
			instance = new Client_S();
		}
		return instance;
	}

	// 소켓통신용 변수
	private static Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private BufferedReader reader;
	private PrintWriter writer;
	
	// 사용자 정보용 변수 
	private Gson gson;
	private String username;
	private String roomname;
	
	private JPanel mainPanel;
	private JTextField usernameInput;
	private JTextField textField;
	private JTextField messageInput;
	private JList<String> roomList;
	private DefaultListModel<String> roomListModel;
	private CardLayout mainCard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// ip 와 포트번호 지정
					String ip = "127.0.0.1";
					int port = 9090;

					try {
						// 클라이언트 소켓 열어줌
						socket = new Socket(ip, port);
						
						// 팝업창 띄워줌
						JOptionPane.showMessageDialog(null, 
								"서버와 연결되었습니다.", 
								"접속성공",
								JOptionPane.INFORMATION_MESSAGE);

						// 클라이언트 리시브와연결
						ClientRecive_S clientRecive = new ClientRecive_S(socket);
						clientRecive.start();
						
					} catch (ConnectException e1) {

						JOptionPane.showMessageDialog(null, "서버 접속 실패", "접속실패", JOptionPane.ERROR_MESSAGE);

					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					Client_S frame = new Client_S();
					frame.setVisible(true);
				}  catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client_S() {
		
		// 문자열 사용을 위한 gson변수 선언
		gson = new Gson();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		mainPanel = new JPanel();
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(160, 330, 116, 21);
		loginPanel.add(usernameInput);
		usernameInput.setColumns(10);
		
		JButton loginButton = new JButton("접속");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// 텍스트필드에서 입력한 이름을 들고와서 username에 저장
					String username = usernameInput.getText();
					
					// username으로 접속하기 위해 제이슨으로 변환한 스트링 변수 선언
					JoinReqDto joinReqDto = new JoinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					
					// join과 스트링으로 변환한 사용자 정보를 넘겨줌
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);

					// 정보를 보내는 스트림 
					// 저장해놨던 리퀘스트를 서버로 보냄
					OutputStream outputStream;
					outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson);
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				mainCard.show(mainPanel, "chatListPanel");
			}
		});
		loginButton.setBounds(172, 377, 97, 23);
		loginPanel.add(loginButton);
		
		JPanel chatListPanel = new JPanel();
		mainPanel.add(chatListPanel, "chatListPanel");
		chatListPanel.setLayout(null);
		
		JScrollPane roomListScroll = new JScrollPane();
		roomListScroll.setBounds(89, 0, 345, 711);
		chatListPanel.add(roomListScroll);
		
		
		roomListModel = new DefaultListModel<>();
		roomList = new JList<String>(roomListModel);
		roomListScroll.setViewportView(roomList);
		// 어떤 방이 생성되었는지 확인용 로그
		System.out.println(roomList);
		
		JButton createRoomButton = new JButton("생성");
		createRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				roomname = JOptionPane.showInputDialog(null, 
						"방 이름을 입력해 주세요.", 
						"방 이름입력",
						JOptionPane.INFORMATION_MESSAGE);
				
				mainCard.show(mainPanel, "chatPanel");
			}
		});
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
		
		JButton outRoomButton = new JButton("나가기");
		outRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mainCard.show(mainPanel, "chatListPanel");
			}
		});
		outRoomButton.setBounds(368, 0, 66, 55);
		chatPanel.add(outRoomButton);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(0, 647, 370, 64);
		chatPanel.add(messageScroll);
		
		messageInput = new JTextField();
		messageScroll.setViewportView(messageInput);
		messageInput.setColumns(10);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 메세지 전송 메소드
			}
		});
		
		// 전송버튼과 같은 동작을 하는 엔터키 메소드
		
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sendButton.setBounds(368, 647, 66, 64);
		chatPanel.add(sendButton);
	}
}
