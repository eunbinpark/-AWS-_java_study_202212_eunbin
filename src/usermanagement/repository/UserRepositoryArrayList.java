package usermanagement.repository;

import java.util.ArrayList;
import java.util.List;

import usermanagement.entity.User;

public class UserRepositoryArrayList {
	
	private List<User> userDataList;
	
	private static UserRepositoryArrayList instance;
	
	public static UserRepositoryArrayList getInstance() {
		if(instance == null) {
			instance = new UserRepositoryArrayList();
		}
		return instance;
	}
	
	private UserRepositoryArrayList() {
		userDataList = new ArrayList<>();
		userDataList.add(User.builder()
				.username("aaa")
				.password("1234")
				.name("김준일")
				.email("aaa@gmail.com")
				.build());
	}
	
	public void saveUser(User user) {
		userDataList.add(user);
	}
	
	public User findUserByUsername(String username) {
		User user = null;
		for (User u : userDataList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
	
	public User findUserByEmail(String emmail) {
		User user = null;
		for (User u : userDataList) {
			if(u.getEmail().equals(emmail)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
}