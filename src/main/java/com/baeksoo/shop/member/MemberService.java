package com.baeksoo.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveMember(String username, String password, String displayName) throws Exception {
        if(username.length() < 6 || password.length() < 6){
            throw new Exception("너무 짧은 아이디나 비밀번호 입력");
        }
        var result = memberRepository.findByUsername(username);
        if(result.isPresent()){
            throw new Exception("중복된 아이디 존재");
        }

        Member newmember = new Member();
        newmember.setUsername(username);
        newmember.setPassword(passwordEncoder.encode(password));
        newmember.setDisplayName(displayName);

        memberRepository.save(newmember);
    }
}
