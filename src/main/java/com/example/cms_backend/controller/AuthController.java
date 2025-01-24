package com.example.cms_backend.controller;

import com.example.cms_backend.model.AuthRequest;
import com.example.cms_backend.model.AuthResponse;
import com.example.cms_backend.service.JwtService;
import com.example.cms_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        try {
            // Authenticate user credentials
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );

            // Fetch user details (this can be done using the UserService)
            // You can query the user by email, if your application uses email as username
            var user = userService.findByEmail(authRequest.getEmail());

            if (user == null) {
                return ResponseEntity.status(401)
                        .body(new AuthResponse("", "Invalid credentials", "error"));
            }

            // Generate JWT token
            String token = jwtService.generateJWT(user.getEmail());

            // Return AuthResponse
            return ResponseEntity.ok(new AuthResponse(token, "Authentication successful", "success"));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401)
                    .body(new AuthResponse("", "Invalid credentials", "error"));
        }
    }
}


