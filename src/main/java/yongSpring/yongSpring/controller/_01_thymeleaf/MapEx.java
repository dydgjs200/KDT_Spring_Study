package yongSpring.yongSpring.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MapEx {
    @GetMapping("/map")
    public String map(Model model){
        Map<String, Integer> map = new HashMap<>();
        map.put("kim", 10);
        map.put("lee", 20);
        map.put("ddd", 30);
        Person person = new Person(map);
        model.addAttribute("map", person);

        return "_01_thymeleaf/as2";
    }
}

 class Person{
    public Map<String, Integer> map;

    public Person(Map<String, Integer> map){
        this.map = map;
    }

     public Map<String, Integer> getMap() {
         return map;
     }
 }
