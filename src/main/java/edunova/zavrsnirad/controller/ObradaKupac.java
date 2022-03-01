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

public abstract class ObradaKupac<T extends Kupac> extends Obrada<T>{
     protected void kontrolaCreate() throws ZavrsniRadException{
         kontrolaAdresa();
         kontrolaBrojTelefona();
     }
     
     protected void kontrolaUpdate() throws ZavrsniRadException{
         kontrolaAdresa();
         kontrolaBrojTelefona();
     }
     
     
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
