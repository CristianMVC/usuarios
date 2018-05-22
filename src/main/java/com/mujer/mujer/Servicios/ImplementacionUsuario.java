/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mujer.mujer.Servicios;

import com.mujer.mujer.Entidades.Roles;
import com.mujer.mujer.Entidades.Usuario;
import com.mujer.mujer.JPA.JPAroles;
import com.mujer.mujer.JPA.JPAusuario;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author cristian
 */

@Service("usuarioServicio")
public class ImplementacionUsuario implements UsuarioServicio {

    @Autowired
    private JPAusuario userRepository;
    @Autowired
    private JPAroles roleRepository;
        
     private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Usuario findUsuarioByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setActive(1);
        Roles userRole = roleRepository.findByRole("ADMIN");
        usuario.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
		userRepository.save(usuario);
    }

}