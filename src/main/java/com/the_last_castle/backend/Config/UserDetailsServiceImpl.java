package com.the_last_castle.backend.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.Entity.UserEntity;
import com.the_last_castle.backend.Repository.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByLoginUser(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        Collection<? extends GrantedAuthority> authorities = userEntity.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoles()))
                .collect(Collectors.toSet());

        return new User(userEntity.getLoginUser(),
                userEntity.getPasswordUser(),
                true,
                true,
                true,
                true,
                authorities);
    }
}