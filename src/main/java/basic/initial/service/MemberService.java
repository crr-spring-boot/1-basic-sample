package basic.initial.service;


import basic.initial.domain.Member;
import basic.initial.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(String name){
        Member member = new Member(name);
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional(readOnly = true)
    public List<Member> findAll(){
        return memberRepository.findAll();
    }
}
