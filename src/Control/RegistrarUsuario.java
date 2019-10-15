/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.*;
import frontera.*;

/**
 *
 * @author Estudiante
 */
public class RegistrarUsuario {
    private Sistema sistema=Frameprincipal.sistema;
    public RegistrarUsuario(){
        
    }
    public void CrearUsuario(Usuario usuario){
        if(validarUsuario(usuario)){
            System.out.println("");
        }else{
            System.out.println("");
        }
    }
    
    public boolean validarUsuario(Usuario usuario){
        if(!verificarLongitudNombre(usuario.getNombre())){
            return false;
        }
        if(!verificarLongitudPassword(usuario.getPassword())){
            return false;
        }
        for(Usuario u: sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre())&&(u.getPassword().equals(usuario.getPassword()))){
                return(false);
            }
        }
        return true;
    }
    public boolean verificarLongitudNombre(String nombre){
        return (nombre.length()>1&&nombre.length()<=6);
    }
    public boolean verificarLongitudPassword(String password){
        return (password.length()>=3&&password.length()<6);
    }
}
