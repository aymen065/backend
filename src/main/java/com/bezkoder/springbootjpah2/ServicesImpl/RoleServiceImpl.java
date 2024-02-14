package com.bezkoder.springbootjpah2.ServicesImpl;

import com.bezkoder.springbootjpah2.Models.ERole;
import com.bezkoder.springbootjpah2.Models.Role;
import com.bezkoder.springbootjpah2.Repositories.IRoleRepository;
import com.bezkoder.springbootjpah2.Services.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class RoleServiceImpl implements IRoleService {

    private IRoleRepository roleRepository;

    @Override
    public Set<Role> RolesMap(Set<String> strRoles) {

        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            List<Role> rolesData = roleRepository.findAll();

            strRoles.forEach(strRole -> {
                switch (strRole) {
                    case "admin":

                        rolesData.stream()
                                .filter(role -> role.getName().equals(ERole.ROLE_ADMIN))
                                .findAny()
                                .ifPresentOrElse(roles::add, () -> {
                            throw new RuntimeException("Error: Role ADMIN is not found.");
                        });
                        break;
                    case "mod":
                        rolesData.stream()
                                .filter(role -> role.getName().equals(ERole.ROLE_MODERATOR))
                                .findAny()
                                .ifPresentOrElse(roles::add, () -> {
                            throw new RuntimeException("Error: Role MODERATOR is not found.");
                        });
                        break;
                    default:
                        rolesData.stream()
                                .filter(role -> role.getName().equals(ERole.ROLE_USER))
                                .findAny()
                                .ifPresentOrElse(roles::add, () -> {
                            throw new RuntimeException("Error: Role USER is not found.");
                        });

                }
            });
        }

        return roles;
    }
}
