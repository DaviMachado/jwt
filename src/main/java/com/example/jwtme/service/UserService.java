package com.example.jwtme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtme.entity.UsuarioEntity;
import com.example.jwtme.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UsuarioEntity usuario = this.usuarioRepository.findByEmail(email);

        UserBuilder builder = null;
        if (usuario != null) {
        	
//            builder = org.springframework.security.core.userdetails
//            		.User.withUsername(usuario.getUsername());
//            builder.password(usuario.getPassword());
            
        	return User.withUsername(
        			usuario.getEmail())
        			.password(usuario.getPassword()).roles("CLIENT").build();

        } else {
            throw new UsernameNotFoundException("Usuário não encontrado!!");
        }

//        return builder.build();
    }

}
