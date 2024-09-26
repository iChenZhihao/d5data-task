package org.zhihao.backend.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ChenZhihao
 * @Date 2023/3/27 23:00
 */
public class LoginUser implements UserDetails {

    private String userId;
    private String username;

    private List<String> permissionList;

    private List<SimpleGrantedAuthority> authorities;

    public LoginUser(String username, List<String> permissionList) {
        this.username = username;
        this.permissionList = permissionList;
    }

    public LoginUser(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.permissionList = new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (!CollectionUtils.isEmpty(authorities)) {
            return authorities;
        }
        authorities = permissionList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return "123456";
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
