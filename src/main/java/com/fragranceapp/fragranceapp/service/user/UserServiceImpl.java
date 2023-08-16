package com.fragranceapp.fragranceapp.service.user;

import com.fragranceapp.fragranceapp.dto.UserDTO;
import com.fragranceapp.fragranceapp.dto.UserRoleDTO;
import com.fragranceapp.fragranceapp.entity.persistence.UserEntity;
import com.fragranceapp.fragranceapp.entity.persistence.UserRoleEntity;
import com.fragranceapp.fragranceapp.exceptions.roleExceptions.RoleNotFoundException;
import com.fragranceapp.fragranceapp.exceptions.userExceptions.InvalidPasswordException;
import com.fragranceapp.fragranceapp.exceptions.userExceptions.UserNotFoundException;
import com.fragranceapp.fragranceapp.mapper.Mapper;
import com.fragranceapp.fragranceapp.repository.UserRepository;
import com.fragranceapp.fragranceapp.repository.UserRoleRepository;
import com.fragranceapp.fragranceapp.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {

    private UserRepository userRepository;

    private PasswordConfig passwordConfig;

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordConfig passwordConfig, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordConfig = passwordConfig;
        this.userRoleRepository = userRoleRepository;
    }

    public boolean checkPassword(String password) {
        boolean isDigit = false;
        boolean isLetter = false;

        for(int i = 0; i < password.length(); i ++) {
            if(Character.isLetter(password.charAt(i))) {
                isLetter = true;
            }
            else if (Character.isDigit(password.charAt(i))) {
                isDigit = true;
            }
        }

        return (isDigit & isLetter & password.length() >= 6);
    }

    @Override
    public UserDTO createUser(UserDTO newUser) {
        if(!checkPassword(newUser.getPassword())) {
            throw new InvalidPasswordException("The password doesn't meet the requirements");
        }
        UserEntity userEntity = Mapper.dtoToUser(newUser);
        Optional<UserRoleEntity> userRoleEntity = userRoleRepository.findRoleById(newUser.getRoleId());
        if(userRoleEntity.isEmpty()) {
            throw new RoleNotFoundException("The role with id " + newUser.getRoleId() + " doesn't exist");
        }
        userEntity.setRole(userRoleEntity.get());
        userEntity.setPassword(passwordConfig.passwordEncoder().encode(newUser.getPassword()));
        userRepository.save(userEntity);

        return newUser;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users= userRepository.findAll();
        List<UserDTO> userDTOS = users.stream()
                .map(entity -> Mapper.userToDto(entity))
                .collect(Collectors.toList());

        return userDTOS;
    }

    @Override
    public UserDTO getUserById(long userId) {
        Optional<UserEntity> user = userRepository.findUserById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("The user with id " + userId + " doesn't exist");
        }

        return Mapper.userToDto(user.get());
    }

    @Override
    public UserDTO updateUser(long userId, UserDTO updateUser) {
        Optional<UserEntity> user = userRepository.findUserById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("The user with id " + userId + " doesn't exist");
        }
        user.get().setPassword(passwordConfig.passwordEncoder().encode(updateUser.getPassword()));

        return updateUser;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        Optional<UserEntity> user = userRepository.findUserByEmail(email);
        if(user.isEmpty()) {
            throw new UserNotFoundException("The user with email " + email + " doesn't exist");
        }

        return Mapper.userToDto(user.get());
    }

    @Override
    public void deleteUser(long userId) {
        Optional<UserEntity> user = userRepository.findUserById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("The user with id " + userId + " doesn't exist");
        }
        userRepository.deleteById(userId);
    }
}
