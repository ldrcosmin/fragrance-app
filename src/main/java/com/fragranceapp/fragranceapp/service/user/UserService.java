package com.fragranceapp.fragranceapp.service.user;

import com.fragranceapp.fragranceapp.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDTO createUser (UserDTO newUser);
    UserDTO createRegularUser (UserDTO newUser);
    boolean emailAvailability(UserDTO newUser);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(long userId);
    void deleteUser(long userId);
    UserDTO updateUser(long userId, UserDTO updateUser);
    UserDTO getUserByEmail(String email);

}
