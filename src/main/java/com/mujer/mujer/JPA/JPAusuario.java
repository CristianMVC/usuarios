/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mujer.mujer.JPA;

import com.mujer.mujer.Entidades.Roles;
import com.mujer.mujer.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristian
 */
@Repository("usuarioRepository")
public interface JPAusuario extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

}
