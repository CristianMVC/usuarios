/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mujer.mujer.JPA;

import com.mujer.mujer.Entidades.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristian
 */ 

@Repository("rolesRepository")
public interface JPAroles extends JpaRepository<Roles, Integer>{
    
    Roles findByRole(String roles);
    
}
