package basic.initial;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping("/add")
    public int add(){
        return 10 + 20;
    }
}
