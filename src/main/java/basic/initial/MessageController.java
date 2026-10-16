package basic.initial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/hi")
    public String hi() {
        return "Hi String!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye String!";
    }
}
