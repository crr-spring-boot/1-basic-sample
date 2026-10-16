package basic.initial.controller;


import basic.initial.domain.Member;
import basic.initial.repository.MemberRepository;
import basic.initial.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public Long join(@RequestParam String name){
        return memberService.join(name);
    }

    @GetMapping("/members")
    public List<Member> list(){
        return memberService.findAll();
    }
}
