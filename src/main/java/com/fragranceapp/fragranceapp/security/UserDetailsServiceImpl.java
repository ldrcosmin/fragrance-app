package com.fragranceapp.fragranceapp.security;

import com.fragranceapp.fragranceapp.entity.persistence.UserEntity;
import com.fragranceapp.fragranceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findUserByEmail(email);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("The username with email: " + email + " doesn't exist");
        }
        return user.get();
    }


}
