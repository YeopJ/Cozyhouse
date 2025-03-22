package com.baeksoo.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    String register(Authentication auth){
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/list/page/1";
        }

        return "register.html";
    }
    @PostMapping("/member")
    String member(@RequestParam(name="displayName") String displayName,
                  @RequestParam(name="username") String username,
                  @RequestParam(name="password") String password) throws Exception {

        memberService.saveMember(username, password, displayName);
        return "redirect:/login";
    }

    @GetMapping("/login")
    String login(){
        return "login.html";
    }

    @GetMapping("/my-page")
    String myPage(Authentication auth){//auth에 현재 로그인한 유저의 정보 들어있음
//        System.out.println(auth);
//        System.out.println(auth.getName());
//        System.out.println(auth.isAuthenticated());
        CustomUser result = (CustomUser) auth.getPrincipal();
        System.out.println(result.displayName);
        return "mypage.html";
    }

    @GetMapping("/user/1")
    @ResponseBody
    public MemberDto getUser(){
        var a = memberRepository.findById(1L);
        var result = a.get();
        var data = new MemberDto(result.getUsername(), result.getDisplayName(), result.getId());

        return data;
    }

}
