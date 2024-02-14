package com.bezkoder.springbootjpah2;

import com.bezkoder.springbootjpah2.Models.ERole;
import com.bezkoder.springbootjpah2.Models.Role;
import com.bezkoder.springbootjpah2.Repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IRoleRepository roleRepository;

    @Autowired
    public DataInitializer(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        roleRepository.save(new Role(ERole.ROLE_USER));
        roleRepository.save(new Role(ERole.ROLE_MODERATOR));
        roleRepository.save(new Role(ERole.ROLE_ADMIN));
    }
}