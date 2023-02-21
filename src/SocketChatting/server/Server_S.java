package SocketChatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import SocketChatting.dto.JoinReqDto;
import SocketChatting.dto.JoinRespDto;
import SocketChatting.dto.MessageReqDto;
import SocketChatting.dto.MessageRespDto;
import SocketChatting.dto.RequestDto;
import SocketChatting.dto.ResponseDto;
import lombok.Data;

@Data
class ConnectedSocket extends Thread {
	// 여러대 접속한 클라이언트 리스트(연결된 소켓들)
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	
	private String username;
	
	// 새로 연결된 소켓은 바로 소켓리스트에 추가 해줌
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		socketList.add(this);
	}
	
	@Override
	public void run() {
		try {
			// 클라이언트에서 넘어온 정보를 받는 스트림
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			while(true) {
				// 넘어온 리퀘스트를 읽어서 다시 변수로 저장
				String request = in.readLine();	// requestDto(JSON)
				
				// 제이슨을 다시 리퀘스트 형태로 변환(프롬제이슨)하여 변수에 저장
				RequestDto requestDto = gson.fromJson(request, RequestDto.class);
				
				// 리소스를 들고옴
				switch(requestDto.getResource()) {
					// 리소스가 조인일 경우
					case "join": 
						// 받은 리퀘스트의 바디를 다시 조인(username)의 형태로 변환
						JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
						
						// 변환한 것을 다시 변수에 저장
						username = joinReqDto.getUsername();
						
						List<String> connectedUsers = new ArrayList<>();
						
						// 연결되어있는 소켓들에서  좀전에 저장한 username을 가지고 옴
						// username을 전부 connectedUsers 리스트에 담아줌
						for(ConnectedSocket connectedSocket : socketList) {
							connectedUsers.add(connectedSocket.getUsername());
						}
						
						// 클라이언트에 보내는 접속확인 메세지
						// joinRespDto 안에 connectedUsers가 들어있음
						JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
			
						// 모두에게 보내는 메세지(지금 과제에는 필요X)
						sendToAll(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
						break;
						
						// 리소스가 샌드메세지인 경우
					case "sendMessage":
						// 받은 바디를 
						MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);
						
						if(messageReqDto.getToUser().equalsIgnoreCase("all")) {
							String message = messageReqDto.getFromUser() + "[전체]: " + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToAll(requestDto.getResource(), "ok", gson.toJson(messageRespDto));
						} else {
							String message = messageReqDto.getFromUser() + "[" + messageReqDto.getToUser() + "]: " + messageReqDto.getMessageValue();
							MessageRespDto messageRespDto = new MessageRespDto(message);
							sendToUser(requestDto.getResource(), "ok", gson.toJson(messageRespDto), messageReqDto.getToUser());
						}
						
						break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendToAll(String resource, String status, String body) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		for(ConnectedSocket connectedSocket : socketList) {
			OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			
			out.println(gson.toJson(responseDto));
		}
	}
	
	private void sendToUser(String resource, String status, String body, String toUser) throws IOException {
		ResponseDto responseDto = new ResponseDto(resource, status, body);
		for(ConnectedSocket connectedSocket : socketList) {
			if(connectedSocket.getUsername().equals(toUser) || connectedSocket.getUsername().equals(username)) {
				OutputStream outputStream = connectedSocket.getSocket().getOutputStream();
				PrintWriter out = new PrintWriter(outputStream, true);
				
				out.println(gson.toJson(responseDto));
			}
		}
	}
	
}

public class Server_S {

}
