package yongSpring.yongSpring.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssignController {
    @GetMapping("/introduce/{name}")
    public String path(@PathVariable(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "_02_restapi/ass1";
    }

    @GetMapping("/introduce")
    public String path2(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "_02_restapi/ass2";
    }

    @GetMapping("/ass3")
    public String path3(){
        return "_02_restapi/ass3";
    }
}
