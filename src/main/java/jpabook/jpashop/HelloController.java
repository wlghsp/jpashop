package jpabook.jpashop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {
        log.info("home controller");
        return "home";
    }
}
