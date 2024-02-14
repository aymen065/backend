package com.bezkoder.springbootjpah2.Services;

import com.bezkoder.springbootjpah2.Models.User;

public interface IUserService {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    void createUser(User user);

}
