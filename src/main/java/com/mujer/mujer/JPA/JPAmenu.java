/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mujer.mujer.JPA;

import com.mujer.mujer.Entidades.Menus;
import com.mujer.mujer.Entidades.Roles;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import org.hibernate.annotations.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristian
 */

@Repository("menuRepository")
public interface JPAmenu  extends JpaRepository<Menus, Integer>{
    
  List<Menus> findAll();
  
  List<Menus> findById(int id);
    
}
