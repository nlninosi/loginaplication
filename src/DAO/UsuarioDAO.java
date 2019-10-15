/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Usuario;
import javax.persistence.*;

/**
 *
 * @author Estudiante
 */
public class UsuarioDAO {
    private static EntityManagerFactory
            emf= Persistence.createEntityManagerFactory("LoginAplicationPU");
    public void crear(Usuario object){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
        em.close();
    }
    }
    public boolean eliminar(Usuario object){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            em.remove(object);
            em.getTransaction().commit();
            ret =true;
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }
    public Usuario leer(Usuario par){
        EntityManager em = emf.createEntityManager();
        Usuario usuario=null;
        Query q=em.createQuery("Select u FROM Usuario u"+"WHERE u.nombre Like :nombre"
                +"AND u.password LIKE :password")
                .setParameter("nombre", par.getNombre())
                .setParameter("password", par.getPassword());
        try{
            usuario = (Usuario) q.getSingleResult();
        } catch(NonUniqueResultException e){
            usuario = (Usuario) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return usuario;
        }
    }
    public boolean actualizar(Usuario object, Usuario newobject){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object=leer(object);
            object.setNombre(newobject.getNombre());
            object.setPassword(newobject.getPassword());
            em.merge(object);
            em.getTransaction().commit();
            ret=true;
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }
    
}
