/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad;

import edunova.zavrsnirad.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class Start {
    private Session session;
    public Start(){
        this.session = HibernateUtil.getSession();
        
    }
    
    
    public static void main(String[] args) {
        new Start();
    }
    
}
