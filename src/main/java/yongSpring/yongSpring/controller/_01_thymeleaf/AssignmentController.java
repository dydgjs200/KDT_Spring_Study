package yongSpring.yongSpring.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssignmentController {
    @GetMapping("/assignment")
    public String assignment(Model model){
        Age age = new Age(50);
        model.addAttribute("age", age);

        return "_01_thymeleaf/as";
    }
}

class Age{
    private int age;

    public Age(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}