package j12_배열;

import java.util.Scanner;

public class J12_UserService {

	// 여기서 스캐너를 정의해두면 클래스를 생성하지 않아도 항상 생성됨
	private Scanner scanner;
	
	private J12_UserRepository userRepository; 

	// 클래스가 생성되어야 스캐너가 생성됨
	public J12_UserService(J12_UserRepository userRepository) {
		scanner = new Scanner(System.in);
		this.userRepository = userRepository;
	}

	public void run() {
		boolean loopFlag = true;
		char select = '\0';

		while (loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}
	}

	public void stop() {
		for (int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}

	// 메뉴 선택(select값 리턴)
	private char inputSelect(String menuName) {
		System.out.print(menuName + "메뉴 선택 : ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}

	// 메인메뉴 출력
	private void showMainMenu() {
		System.out.println("==============<< 메인메뉴 >>==============");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==========================================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	// 회원 전체 조회
	private void showUsers() {
		J12_User[] users = userRepository.getUserTable();
		
		System.out.println("===========<< 회원 전체 조회 >>===========");
		
		for (J12_User user : users) {
			System.out.println(user.toString());
		}
		
		System.out.println("==========================================");
		
	}
	
	// 회원 등록
	private void registerUser() {
		J12_User user = new J12_User();
		
		System.out.println("==============<< 회원 등록 >>==============");
		System.out.print("사용자이름 : ");
		user.setUsername(scanner.nextLine());
		
		System.out.print("비밀번호 : ");
		user.setPassword(scanner.nextLine());
		
		System.out.print("성명 : ");
		user.setName(scanner.nextLine());
		
		System.out.print("이메일 : ");
		user.setEmail(scanner.nextLine());
		
		userRepository.saveUser(user);
	}
	
	// 사용자이름으로 회원 조회
	private void findUser() {
		J12_User user = null;
		
		System.out.println("=======<< 사용자이름으로 회원 조회 >>=======");
		System.out.print("사용자이름 : ");
		user = vertifyUsername();
		
		// null일때 조건걸어주는 것이 좋음
		if(user == null) {
			System.out.println("존재하지 않는 사용자 이름입니다.");
			return;
		}
		
		System.out.println(user.toString());
		System.out.println("==========================================");
		
	}
	
	
	
	// 회원 정보 수정
	private void UpdateUser() {
		J12_User user = vertifyUsername();
		
		if(user == null) {
			System.out.println("존재하지 않는 사용자 이름입니다.");
			return;
		}
		
		boolean loopFlag = true;
		char select = '\0';
		
		while (loopFlag) {
			showUpdateMenu(user);
			select = inputSelect("수정");
			loopFlag = updateMenu(user, select);
		}
	}
	
	// 회원정보 수정 메뉴 출력
	private void showUpdateMenu(J12_User user) {
		System.out.println("==============<< 수정메뉴 >>==============");
		System.out.println("사용자이름 : " + user.getUsername());
		System.out.println("==========================================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("==========================================");
		System.out.println("b. 뒤로가기");
		System.out.println();
		
	}

	// 메뉴 번호 선택
	private boolean mainMenu(char select) {
		boolean flag = true;

		if (isExit(select)) {
			flag = false;
		} else {
			if (select == '1') {
				showUsers();
			} else if (select == '2') {
				registerUser();
			} else if (select == '3') {
				findUser();
			} else if (select == '4') {
				UpdateUser();
			} else {
				System.out.println(getSelectedErrorMessaage());
			}
		}
		System.out.println();

		return flag;
	}

	// 프로그램 종료 값 리턴
	// 프로그램 종료 불값 리턴
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}

	// 뒤로가기 값 리턴
	private boolean isBack(char select) {
		return select == 'b' || select == 'Q';
	}
	
	// 잘못된 번호 입력 문자열
	// 잘못된 번호 입력시 메세지 출력
	private String getSelectedErrorMessaage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	// 사용자 이름 검증
	private J12_User vertifyUsername() {
		String username = null;
		System.out.print("사용자이름 : ");
		username = scanner.nextLine();
		return userRepository.findUserByUsername(username);
	}

	// 업데이트 메뉴 
	private boolean updateMenu(J12_User user, char select) {
		boolean flag = true;
		
		if(isBack(select)) {
			flag = false;
		} else {
			if(select == '1') {
				updatePassword(user);
			} else if(select == '2') {
				
			} else if(select == '3') {
				
			} else {
				System.out.println(getSelectedErrorMessaage());
			}
		}
		
		return flag;
	}
	
	// 비밀번호 변경
	private void updatePassword(J12_User user) {
		String oldPassword = null;
		String newPassword = null;
		String confirmPassword = null;
		
		System.out.println("=======<< 비밀번호 변경 >>=======");
		
		System.out.print("기존 비밀번호 입력 : ");
		oldPassword = scanner.nextLine();
		
		if (comparePassword(user.getPassword(), oldPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		System.out.print("새로운 비밀번호 입력 : ");
		newPassword = scanner.nextLine();
		System.out.print("새로운 비밀번호 확인 : ");
		confirmPassword = scanner.nextLine();
		
		if(!comparePassword(newPassword, confirmPassword)) {
			System.err.println("새로운 비밀번호가 일치하지 않습니다.");
			return;
		}
		
		user.setPassword(newPassword);
		System.out.println("비밀번호 변경 완료.");
	}
	
	// 이전패스워드와 나중패스워드 비교
	private boolean comparePassword(String prePassword, String nextPassword) {
		return prePassword.equals(nextPassword);
	}
}
