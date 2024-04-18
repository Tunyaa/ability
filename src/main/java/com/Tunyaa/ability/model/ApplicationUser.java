
package com.Tunyaa.ability.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ability_application_users")
public class ApplicationUser {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(unique = true)
    private String name;
    private String password;
    private String role;
    
}
