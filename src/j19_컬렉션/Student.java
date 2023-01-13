package j19_컬렉션;

// ctrl + Shift + o : 임포트 정리
import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor	// 기본 생성자
//@RequiredArgsConstructor
//@Getter				// 게터
//@Setter				// 세터
//@ToString			// 투스트링
//@EqualsAndHashCode

@AllArgsConstructor // 전체 생성자
@Data

public class Student {
	private String name;	// 이름
	private int year;		// 학년
//	private final String address;	// 주소
}