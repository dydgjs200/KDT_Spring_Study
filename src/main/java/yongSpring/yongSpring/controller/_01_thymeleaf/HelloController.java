package yongSpring.yongSpring.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("hi")
    public String getHi(Model model){
        // Model model : controller 클래스 안의 메서드가 파라미터로 받을 수 있는 객체
        // 정보를 담아 View 에게 넘겨줄 때 사용
        // 개발자가 직접 model을 생성할 필요 없이, 파라미터로 선언하면 Spring이 알아서 만듦.
        model.addAttribute("msg", "hi");

        model.addAttribute("uText", "<strong>Hello</strong>");

        model.addAttribute("value", "이름을 입력하세요");

        model.addAttribute("withValue", "hello");

        model.addAttribute("link", "hi");

        model.addAttribute("imgSrc", "alzip.png");

        model.addAttribute("userRole", "admin");

        model.addAttribute("isAdmin", "false");

        List<String> names = Arrays.asList("kim", "park", "son", "harry", "salah");
        model.addAttribute("names", names);

        Hello hello = new Hello(10);
        model.addAttribute("classHello",hello);
        return "_01_thymeleaf/hi";      //이 html 파일을 실행하겠다 (resources/templates/_01_thymeleaf/hi.html 경로)
    }
}

class Hello{
    private int age;
    public Hello(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }
}
