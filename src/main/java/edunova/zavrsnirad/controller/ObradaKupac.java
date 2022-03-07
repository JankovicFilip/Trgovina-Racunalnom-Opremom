/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

/**
 *
 * @author Admin
 */


import edunova.zavrsnirad.model.Kupac;
import edunova.zavrsnirad.util.TelefonValidation;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.util.List;

public class ObradaKupac extends ObradaOsoba<Kupac>{
    @Override
    public List<Kupac> read() {
        return session.createQuery("from Kupac").list();
    }
    @Override
     protected void kontrolaCreate() throws ZavrsniRadException{
         super.kontrolaCreate();
         //kontrolaAdresa();
         kontrolaBrojTelefona();
     }
     @Override
     protected void kontrolaUpdate() throws ZavrsniRadException{
         super.kontrolaUpdate();
         //kontrolaAdresa();
         kontrolaBrojTelefona();
     }
     
     @Override
     protected void kontrolaDelete() throws ZavrsniRadException{
         
         
     }

    private void kontrolaAdresa() throws ZavrsniRadException{
        
    }

    private void kontrolaBrojTelefona() throws ZavrsniRadException{
    if(!TelefonValidation.vazeciBroj(entitet.getBrojTelefona())) {
        throw new ZavrsniRadException("Molim vas toćno unesite svoj broj telefona");
    }
    }
    
}
