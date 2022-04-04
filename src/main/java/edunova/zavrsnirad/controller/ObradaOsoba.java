/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Osoba;
import edunova.zavrsnirad.util.ImeValidation;
import edunova.zavrsnirad.util.OibValidation;
import edunova.zavrsnirad.util.PrezimeValidation;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Admin
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T>{
    
    @Override
    protected void kontrolaCreate() throws ZavrsniRadException{
        kontrolaEmail();
        kontrolaOib();
        kontrolaIme();
        kontrolaPrezime();
        kontrolaNoviEmail();
    }
    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException{
        kontrolaEmail();
        kontrolaOib();
        kontrolaIme();
        kontrolaPrezime();
    }
    
    @Override
    protected void kontrolaDelete() throws ZavrsniRadException{
        
    }

    

    private void kontrolaEmail() throws ZavrsniRadException{
        
        try {
            InternetAddress emailAddr = new InternetAddress(entitet.getEmail());
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new ZavrsniRadException("Email nije formalno ispravan!");
        }
    }

    private void kontrolaOib() throws ZavrsniRadException{
        if (!OibValidation.checkOIB(entitet.getOib())) {
            throw new ZavrsniRadException("Oib nije formalno ispravan!!!");
        }
    }

    private void kontrolaIme() throws ZavrsniRadException{
       char[] nedozvoljeno = {'1','2','3','4','5','6','7','8','9','0',',','.','/','<','>','?',':',';','"','\'','\\','|',
       '{','[','}',']','=','+','-','_','!','@','#','$','%','^','&','*','(',')','`','~','€'};
       if(entitet.getIme()!=null){
           for(int i=0;i<entitet.getIme().length();i++){
               for(char c: nedozvoljeno){
                   if(entitet.getIme().charAt(i)==c){
                       throw new ZavrsniRadException("Ime ne smije imati jedan od znakova:\n" + 
                               Arrays.toString(nedozvoljeno));
                   }
               }
           }
       }
    }

    private void kontrolaPrezime() throws ZavrsniRadException{
        char[] nedozvoljeno = {'1','2','3','4','5','6','7','8','9','0',',','.','/','<','>','?',':',';','"','\\','|',
       '{','[','}',']','=','+','_','!','@','#','$','%','^','&','*','(',')','`','~','€'};
       if(entitet.getPrezime()!=null){
           for(int i=0;i<entitet.getPrezime().length();i++){
               for(char c: nedozvoljeno){
                   if(entitet.getPrezime().charAt(i)==c){
                       throw new ZavrsniRadException("Prezime ne smije imati jedan od znakova:\n" + 
                               Arrays.toString(nedozvoljeno));
                   }
               }
           }
       }
    }

    private void kontrolaNoviEmail() throws ZavrsniRadException{
        List<Osoba> osobe = session.createQuery("from Osoba o "
                + "where o.email=:email")
                .setParameter("email", entitet.getEmail()).list();
        
        if (osobe != null && osobe.size() > 0) {
            throw new ZavrsniRadException("Email se već koristi!");
        }
        
    }

    
    
   
    
}
