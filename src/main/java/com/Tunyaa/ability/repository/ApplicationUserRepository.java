package com.Tunyaa.ability.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Tunyaa.ability.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

    //Поиск пользователя по имени
    Optional<ApplicationUser> findByName(String userName);
}
