package com.bezkoder.springbootjpah2.ServicesImpl;

import com.bezkoder.springbootjpah2.Models.User;
import com.bezkoder.springbootjpah2.Repositories.IUserRepository;
import com.bezkoder.springbootjpah2.Services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
