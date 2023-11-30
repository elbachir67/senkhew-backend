package com.gestionEvent.handlerService.HandlerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.gestionEvent.handlerService.HandlerService.entities.*;


@Service
public class PrestataireDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private PrestataireRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Prestataire> user = repository.findByUsername(username);

        UserBuilder builder = null;
        if (user.isPresent()){
            Prestataire currentUser = user.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(currentUser.getPassword());
            //builder.roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
