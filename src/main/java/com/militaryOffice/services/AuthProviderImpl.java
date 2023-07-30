//package com.militaryOffice.services;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@AllArgsConstructor
//@Component
//public class AuthProviderImpl implements AuthenticationProvider {
//
//    private final AccountDetailsService accountDetailsService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        UserDetails userDetails = accountDetailsService.loadUserByUsername(username);
//
//        String password = authentication.getCredentials().toString();
//
//        if(!passwordEncoder.encode(password).equals(userDetails.getPassword()))
//            throw new BadCredentialsException("Неправильный пароль");
//        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
