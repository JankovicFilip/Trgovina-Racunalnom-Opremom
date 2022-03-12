/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Operater;
import java.util.List;
import javax.persistence.NoResultException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Admin
 */
public class ObradaOperater extends ObradaOsoba<Operater>{

    @Override
    public List<Operater> read() {
                return session.createQuery("from Operater").list();
    }
    public Operater autoriziraj(String email, String lozinka) {
        Operater operater = null;
        try {
            operater = (Operater) session.createQuery("from Operater where email=:email")
                    .setParameter("email", email).getSingleResult();

        } catch (NoResultException e) {
            return null;

        }
        if(operater==null) {
            return null;
        }
        return BCrypt.checkpw(lozinka, operater.getLozinka()) ? operater : null;
        

    }
    
}
