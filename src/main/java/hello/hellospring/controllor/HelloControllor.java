package hello.hellospring.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControllor {
    @GetMapping("hello")
    public String hello(Model model){
        // 직접 받기
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(
            // 외부에서 url parameter로 넘겨온 name받기
            @RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 body부분에 내가 직접 내용을 넣어준다
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    // JSON 방식
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        // 객체가 오면 Default가 객체를 JSON방식으로 저장하는 것
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
