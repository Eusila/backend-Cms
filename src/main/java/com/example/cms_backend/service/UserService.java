package com.example.cms_backend.service;

import com.example.cms_backend.exception.UserNotFoundException;
import com.example.cms_backend.model.Role;
import com.example.cms_backend.model.Users;
import com.example.cms_backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


     // Register a new user with encoded password.

    public Users registerUser(Users user) {
        validateUserDetails(user); // Validate user fields
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(Role.BUYER); // Default role
        }
        return userRepository.save(user);
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
               //.orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }



     //Get a list of users by their role.

    public List<Users> getUsersByRole(Role role) {
        return userRepository.findByRole(role);
    }


    //Get user by ID, throw exception if not found.

    public Users getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
    }


     //Update user details. Password is encoded if provided.

    public Users updateUser(UUID id, Users updatedUser) {
        Users existingUser = getUserById(id);

        // Update allowed fields
        if (updatedUser.getUsername() != null) {
            existingUser.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getContact() != null) {
            existingUser.setContact(updatedUser.getContact());
        }
        if (updatedUser.getAddress() != null) {
            existingUser.setAddress(updatedUser.getAddress());
        }
        if (updatedUser.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        return userRepository.save(existingUser);
    }



     // Delete a user by ID.

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        userRepository.deleteById(id);
    }


     //Validate user details for registration or update.

    private void validateUserDetails(Users user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
    }
}


