package com.fragranceapp.fragranceapp.service.user;

import com.fragranceapp.fragranceapp.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDTO createUser (UserDTO newUser);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(long userId);
    void deleteUser(long userId);
    UserDTO updateUser(long userId, UserDTO updateUser);
    UserDTO getUserByEmail(String email);

}
