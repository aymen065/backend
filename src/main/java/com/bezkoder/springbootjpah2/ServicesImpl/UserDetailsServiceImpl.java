package com.bezkoder.springbootjpah2.ServicesImpl;

import com.bezkoder.springbootjpah2.DataImpl.UserDetailsImpl;
import com.bezkoder.springbootjpah2.Models.User;
import com.bezkoder.springbootjpah2.Repositories.IUserRepository;
import com.bezkoder.springbootjpah2.Services.IUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements IUserDetailsService {

    IUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
