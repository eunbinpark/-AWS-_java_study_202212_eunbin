package usermanagement.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.entity.User;
import usermanagement.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	private Gson gson;

	private static UserService instance;

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	public Map<String, String> register(String userJson) {
		Map<String, String> response = new HashMap<>();

		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		for (Entry<String, String> userEntry : userMap.entrySet()) {

			if (userEntry.getValue().isBlank()) {
				response.put("error", userEntry.getKey() + "은(는) 공백일 수 없습니다.");
				return response;
			}
		}

		User user = gson.fromJson(userJson, User.class);
		System.out.println("서비스에 넘어옴! User 객체로 변환");
		System.out.println(user);

		if (duplicatedUsername(user.getUsername())) {
			response.put("error", "이미 사용중인 사용자 이름입니다.");
			return response;
		}

		if (duplicatedUEmail(user.getEmail())) {
			response.put("error", "이미 가입된 이메일 입니다.");
			return response;
		}

		String pw = BCrypt.hashpw("1234", BCrypt.gensalt());

//		System.out.println(pw);
//		user.setPassword(BCrypt.);

		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("암호화 후");
		System.out.println(user);
		System.out.println(BCrypt.checkpw("1234", pw));

		userRepository.saveUser(user);
		response.put("ok", "회원가입 성공.");

		return response;
	}
	
	public Map<String, String> Login(String userLoginJson){
		Map<String, String> response = new HashMap<>();
		Map<String, String> userLoginMap = gson.fromJson(userLoginJson, Map.class);
		
		System.out.println(userLoginMap);
		
		return response;
	}

	private boolean duplicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null;
	}

	private boolean duplicatedUEmail(String emmail) {
		return userRepository.findUserByEmail(emmail) != null;
	}
}