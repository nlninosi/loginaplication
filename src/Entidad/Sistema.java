/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Sistema {
    private ArrayList <Usuario> Usuarios;
    public Sistema(){
       
    }
    public ArrayList<Usuario> getUsuarios(){
        return Usuarios;
    }
    public void setUsuarios(ArrayList <Usuario> Usuarios){
        this.Usuarios=Usuarios;
    }
    
}
