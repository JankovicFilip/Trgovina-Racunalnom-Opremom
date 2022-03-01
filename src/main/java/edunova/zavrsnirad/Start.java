/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad;



import edunova.zavrsnirad.model.Kupac;
import edunova.zavrsnirad.model.Operater;
import edunova.zavrsnirad.model.Osoba;
import edunova.zavrsnirad.util.HibernateUtil;
import java.util.Scanner;
import org.hibernate.Session;
import edunova.zavrsnirad.util.Unos;
import edunova.zavrsnirad.controller.Obrada;

/**
 *
 * @author Admin
 */
public class Start {
    private Session session;
    //private Osoba osoba;
    private Kupac kupac;
    private Scanner ulaz;
    
    public Start(){
       //this.session = HibernateUtil.getSession();
       ulaz = new Scanner(System.in);
       unos();
       ulaz.close();
        
    }
    
    private void unos() {
        kupac = new Kupac();
        kupac.setIme(Unos.unesiString(ulaz, "Koje je vaše ime?"));
        kupac.setPrezime(Unos.unesiString(ulaz, "Koje je vaše prezime?"));
        kupac.setEmail(Unos.unesiString(ulaz,"Molim Vas unesite vaš email!"));
        kupac.setOib(Unos.unesiString(ulaz, "Molim Vas unesite vaš OIB!"));
        //kupac.setAdresa(Unos.unesiString(ulaz, "Molim Vas unesite vašu adresu!"));
        
    }
    private void unosKupac(){
                kupac.setBrojTelefona(Unos.unesiString(ulaz, "Molim Vas unesite svoj broj telefona ili mobitela!"));

    }
    public static void main(String[] args) {
        new Start();
    }
    
}
