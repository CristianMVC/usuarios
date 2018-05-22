/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mujer.mujer.Servicios;


import com.mujer.mujer.JPA.JPAmenu;
import com.mujer.mujer.JPA.JPAroles;
import java.awt.Menu;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */

@Service("obtenermenu")
public class ObtenerMenu  {
    
@Autowired
    private JPAmenu menu;    



public List obtenerMenus()
{

 return this.menu.findAll();

}
    
    
 public List obtenerMenuPorRol(Set roles) 
 {
    List list = null;
   
   return list;
 }
      
 
 
 
 
 
    
}
