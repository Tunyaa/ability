
package com.Tunyaa.ability.controller;

import com.Tunyaa.ability.model.ApplicationUser;
import com.Tunyaa.ability.service.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class SecurityApplicationUserController {
    
    private ApplicationUserService service;
    
    @PostMapping("/add")
    public String addUser(@RequestBody ApplicationUser user ){
        service.addUser(user);
        return "Save new user.";
    }
}
