package com.baeksoo.shop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder name(){
        return new BCryptPasswordEncoder();
    }

    //어떤 페이지에 로그인 검사르 할 지 선택가능한 함수
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {///FilterChain: 유저 요청과 서버 응답 사이에 자동으로 실행시켜주고 싶은 코드를 담는 곳
        //csrf 공격: 다른 사이트에서 내 API로 요청 날리는 것
        http.csrf((csrf) -> csrf.disable());//csrf 끄기. () -> {} 이런 식으로 빠르게 함수 만들 수 있음.
//        http.csrf(csrf -> csrf.csrfTokenRepository(csrfTokenRepository())
//                .ignoringRequestMatchers("/login")
//        );csrf 켜기
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()//문자열 안에 url 작성, permitAll은 모두 로그인하지 않아도 허가
        );
        http.formLogin((formLogin) -> formLogin.loginPage("/login") //폼으로 로그인하겠다는 뜻
                .defaultSuccessUrl("/list/page/1")
                //실패시 기본적으로 /login?error 로 이동
                //.failureUrl("/fail")
        );
        //url로 GET 요청하면 자동로그아웃
        http.logout(logout -> logout.logoutUrl("/logout"));

        return http.build();
    }

    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}
