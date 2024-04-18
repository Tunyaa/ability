
package com.Tunyaa.ability.service;

import com.Tunyaa.ability.config.ApplicationUserDetails;
import com.Tunyaa.ability.model.ApplicationUser;
import com.Tunyaa.ability.repository.ApplicationUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{
    
    @Autowired
    private ApplicationUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> user = repository.findByName(username);
        return user.map(ApplicationUserDetails::new )
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
    }
    
    
}
