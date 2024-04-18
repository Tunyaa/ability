
package com.Tunyaa.ability.service;

import com.Tunyaa.ability.model.ApplicationUser;
import com.Tunyaa.ability.repository.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService {
    
    private PasswordEncoder passwordEncoder; //Шифрователь пароля.
    private ApplicationUserRepository repository;
    
    public void addUser(ApplicationUser user){
        //Пароль(переданный в контроллер) шифруем и присваем в этоже поле.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
