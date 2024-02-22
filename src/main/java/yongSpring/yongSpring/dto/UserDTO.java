package yongSpring.yongSpring.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// UserDTO = 유저 정보를 담는 객체
// DTO 사용 이유 = 비즈니스 로직을 캡슐화
// 모델은 DB 테이블 구조와 매우 유사함 -> DTO 변환 시 외부사용자에게 내부로직 비공개 가능
// 부가 정보 추가 가능 = ex) error message

// lombok 라이브러리
// getter, setter, builder 등 코드를 자동 생성 -> 어플리케이션 실행 후에 생성
// @builder: 빌더 패턴 지원
// @NonNull : null 금지
// @RequiredArgsConstructor : 인자 갖는 생성자
// @NoArgsConstructor : 인자 없는 생성자
// @AllArgsConstructor : 모든 멤버 변수를 받는 생성자
// @Data : 클래스 멤버 변수의 get, set를 자동생성