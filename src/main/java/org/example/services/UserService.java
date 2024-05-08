package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;

import java.util.List;


@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public User addUser(UserDTO userDTO) {

        if(userDTO == null) {
            throw new WebApplicationException("UserDTO cannot be null", 400);
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setCommonName(userDTO.getCommonName());
        user.setSurname(userDTO.getSurname());

        userRepository.persist(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.listAll();
    }

    public User getUser(Long id) {
        if(id == null) {
            throw new WebApplicationException("Id cannot be null", 400);
        }

        User user = userRepository.findById(id);

        if(user == null) {
            throw new WebApplicationException("User not found", 400);
        }
        return user;
    }

}
