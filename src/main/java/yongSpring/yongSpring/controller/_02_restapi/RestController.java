package yongSpring.yongSpring.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yongSpring.yongSpring.dto.UserDTO;

@Controller
public class RestController {
    @GetMapping("/")
    public String getReq(){
        return "_02_restapi/req";
    }

    @GetMapping("/get/res1")
    public String getRes1(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age, Model model){
        // RequestParam 어노테이션
        // string query 중에서 name key에 대한 value를 String name에 매핑
        // required=true 가 기본값이므로 요청 URL에서 name key를 필수로 보내야함.
        // /get/res1?name=someone 으로 오면 값을 처리함
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_restapi/res";
    }

    @GetMapping("/get/res2")
    public String getRes2(@RequestParam(value = "name", required = false) String name, Model model){
        // required false는 query String에서 특정 키를 optional 하게 받을 수 있음
        model.addAttribute("name", name);       //해당 코드에서는 null 처리 되었다..

        return "_02_restapi/res";
    }
    
    @GetMapping("/get/res3/{param1}/{param2}")
    public String getRes3(@PathVariable String param1, @PathVariable(value = "param2") int age, Model model){
        //@PathVariable 어노테이션
        // - test/{id} 형식의 URL 경로로 넘어오는 값을 변수로 받을 때 사용
        // 경로 변수는 값이 없다면 404 에러처리 된다.
        // url에 기입한 변수명과 다른 변수명 사용하려면 @PathVariable (value = "param2") int age 이런식으로 사용
        model.addAttribute("name", param1);
        model.addAttribute("age", age);
        return "_02_restapi/res";
    }

    @GetMapping({"/get/res4/{name}", "/get/res4/{name}/{age}"})   // 내가 선택적으로 받아오는 PathVariable 이 있다면 경로를 여러 개 설정해야 함
    public String getRest4(@PathVariable(value = "name") String name, @PathVariable(required = false) Integer age, Model model){
        // required = false 옵션
        // - name (필수), age (선택)
        // - optional 한 parameter 가 있다면 경로 맨 뒤에 오도록 설정
        // 참고. Integer age 라고 한 이유
        // - age 는 optional 한 값
        // - 즉, null 이 될 수도     @GetMapping("/get/rest4/{name}, /get/rest4/{name}/{age}")    // 내가 선택적으로 받아오는 PathVariable 이 있다면 경로를 여러 개 설정해야 함
        //    public String getRest4(@PathVariable String name, @PathVariable(required = false) Integer age, Model model){
        //        // required = false 옵션
        //        // - name (필수), age (선택)
        //        // - optional 한 parameter 가 있다면 경로 맨 뒤에 오도록 설정
        //        // 참고. Integer age 라고 한 이유
        //        // - age 는 optional 한 값
        //        // - 즉, null 이 될 수도 있기 때문에 primitive type 이 아닌 reference type 인 래퍼 객체 사용
        //        model.addAttribute("name", name);
        //        model.addAttribute("age", age);
        //        return "_02_restapi/res";
        //    }있기 때문에 primitive type 이 아닌 reference type 인 래퍼 객체 사용
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_restapi/res";
    }


    //    ============== post 요청 ===============
    // post로 전달할 때 controller에서 받는 방법은 @requestParam
    @PostMapping("/post/res1")
    public String postRes1(@RequestParam String name, @RequestParam int age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "_02_restapi/res";
    }

    // 위에는 항상 return이 view였음
    // 데이터 자체에서 응답하려면 @ResponseBody 어노테이션 사용 -> 데이터만 응답해줌
    @PostMapping("/post/res3")
    @ResponseBody
    public String postRes3(@RequestParam(required = false) String name, @RequestParam int age, Model model){
        // 리턴 시 객체를 json 형태로 (직렬화)
        // 응답 객체 전달
        model.addAttribute("name", name);

        return name + " " + age;
    }

    // =========================== dto =================================
    @GetMapping("/dto/res1")
    @ResponseBody
    public String dtoRes1(@ModelAttribute UserDTO userDTO){
        // 변수로 값을 하나씩 가져오는 것이 아니라 DTO 객체에 값을 담아서 가져오기
        // ModelAttribute : HTML 폼 데이터를 컨트롤러로 전달할 때 객체 매핑하는 어노테이션 -> 매핑 = setter 함수 실행

        return userDTO.getName() + " " + userDTO.getAge();
    }

    @PostMapping("/dto/res2")
    @ResponseBody
    public String dtoRes2(UserDTO userDTO){
        // @ModelAttribute 어노테이션이 없을 시 자동 추가(생략 가능)
        return userDTO.getName() + " " + userDTO.getAge();
    }

    @PostMapping("/dto/res3")
    @ResponseBody
    public String dtoRes3(@RequestBody UserDTO userDTO){
        // @RequestBody 어노테이션
        // 요청의 본문에 있는 req.body 데이터를 읽어서 객체에 매핑
        // 전달 받은 요청의 형식이 json or xml일 때만 실행가능
        // Post /dto/res3 요청의 경우 일반 폼 전송임 (www-x-form-urlencoded)
        // @RequestBody 어노테이션 사용 시 오류 발생
        return userDTO.getName() + " " + userDTO.getAge();
    }
}
