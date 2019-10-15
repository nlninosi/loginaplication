/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;
import java.io.*;
import javax.persistence.*;

/**
 *
 * @author Estudiante
 */
@Entity
@Table(name="usuarios")
public class Usuario {
    private String nombre;
    private String password;
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id;
    public Usuario(){
        
    }
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getPassword(){
        return password;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
}
