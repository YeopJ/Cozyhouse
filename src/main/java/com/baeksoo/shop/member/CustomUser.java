package com.baeksoo.shop.member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    public String displayName;
    public Long id;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        //extends로 복사한 클래스의 constructor
        super(username, password, authorities);
    }
}
