package com.bezkoder.springbootjpah2.Services;

import com.bezkoder.springbootjpah2.Models.Role;

import java.util.Set;

public interface IRoleService {

    Set<Role> RolesMap(Set<String> strRoles) throws RuntimeException;
}
