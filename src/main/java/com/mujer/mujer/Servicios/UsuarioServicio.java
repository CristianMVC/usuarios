/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mujer.mujer.Servicios;

import com.mujer.mujer.Entidades.Roles;
import com.mujer.mujer.Entidades.Usuario;

/**
 *
 * @author cristian
 */
public interface UsuarioServicio {
    
    public Usuario findUsuarioByEmail(String email);

    public void saveUsuario(Usuario usuario);
    
}
