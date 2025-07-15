package com.example.controller;

import com.example.model.User;
import com.example.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;

public class Auth {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    public ResponseEntity<AuthResponse> login(AuthRequest request)
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword())
    );

    User user = (User) authentication.getPrincipal();
    String accessToken = jwtTokenUtil.generateAccessToken(user);
        return ResponseEntity.ok(new AuthResponse(user.getEmail(), accessToken));
   }

   public ResponseEntity<User> register(
        String name,
         String surname,
         String email,
         String password,
         String accountType,{

            User user = new User();
            user.setName(name);
           user.setEmail(email);
           user.setPassword(password);
           user.setAccountType(accountType);
       if (user.getAvatar() != null && !avatar.isEmpty()) {
           user.setAvatar(userService.saveAvatar(avatar));
       }

       return ResponseEntity.ok(userService.createUser(user));
   }}

}
