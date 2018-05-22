/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mujer.mujer.Controladores;

import com.mujer.mujer.Entidades.Menus;
import com.mujer.mujer.Entidades.Roles;
import com.mujer.mujer.Entidades.Usuario;
import com.mujer.mujer.Servicios.ObtenerMenu;
import com.mujer.mujer.Servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author cristian
 */

@Controller 
public class LoginController {
    
    
    @Autowired
    private UsuarioServicio userService;
    
    @Autowired
    private ObtenerMenu obtenerMenu;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
        
  
       
        
        @RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
           
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("registration");
		return modelAndView;
	}    
        
        
        
        @RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario userExists = userService.findUsuarioByEmail(usuario.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {System.out.println("error");
			modelAndView.setViewName("registration");
		} else {System.out.println("no  error");
			userService.saveUsuario(usuario);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
        
        
        @RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
           ArrayList <Roles> certName = new ArrayList<Roles>();
           
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = userService.findUsuarioByEmail(auth.getName());
               // Obtenemos los roles
                Set roles = usuario.getRoles();
                
                obtenerMenu.obtenerMenuPorRol(usuario.getRoles());
                
                for (Iterator iterator2 = roles.iterator(); iterator2.hasNext();){
                certName.add((Roles)iterator2.next()); 
              
               }
        
             
               Roles Rol_menu = certName.get(1); 
               Set menu = Rol_menu.getMenus();
               
                for (Iterator iterator2 = menu.iterator(); iterator2.hasNext();){
                Menus certName2 = (Menus) iterator2.next(); 
               System.out.println("Menu: " + certName2.getNombre()); 
              
               }
                
                
                
                
                
                
                ///////////////
                
                // Obtiene el menu
           //     Iterator iter = obtenerMenu.obtenerMenuPorRol(1).iterator();
            //    while(iter.hasNext()){
              //      Menus menus = (Menus)iter.next(); /* Cast del Objeto a la Clase Persona*/
             //       System.out.println(menus.getNombre());/* Accedo a los atributos de la clase 
                                //           por medio de sus Getters*/
      ///////////
           //     }
		modelAndView.addObject("userName", "Welcome " + usuario.getName() + " " + usuario.getLastName() + " (" + usuario.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("index");
		return modelAndView;
	}
    
}
