package com.gwozdz1uu.store.auth;

import com.gwozdz1uu.store.users.User;
import com.gwozdz1uu.store.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public User getCurrentUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var userId = (Long) authentication.getPrincipal();

        System.out.println(userId);
        return userRepository.findById(userId).orElse(null);
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return new LoginResponse(accessToken,refreshToken);
    }

    public Jwt refreshAccessToken(String refreshToken){
        var jwt = jwtService.parseToken(refreshToken);
        if(jwt==null || jwt.isExpired()){
            throw new BadCredentialsException("Invalid refresh token or expired.");
        }

        var user = userRepository.findById(jwt.getUserId()).orElseThrow();
        return jwtService.generateAccessToken(user);
    }
}
