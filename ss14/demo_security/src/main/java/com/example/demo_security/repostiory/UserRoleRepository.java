package com.example.demo_security.repostiory;

import com.example.demo_security.model.AppUser;
import com.example.demo_security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
