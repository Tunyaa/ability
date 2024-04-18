
package com.Tunyaa.ability.config;

import com.Tunyaa.ability.model.ApplicationUser;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class ApplicationUserDetails implements UserDetails{

    private ApplicationUser user;

    public ApplicationUserDetails(ApplicationUser user) {
        this.user = user;
    }
    
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user.getRole().split(", ")) //Сплитим строку ролей
                .map(SimpleGrantedAuthority::new )//преобразуем каждое значение в класс
                .collect(Collectors.toList());//Собираем Классы в лист
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
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
