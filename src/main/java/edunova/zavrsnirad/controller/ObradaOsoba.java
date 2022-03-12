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
    }
    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException{
        kontrolaEmail();
        kontrolaOib();
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
    
   
    
}
