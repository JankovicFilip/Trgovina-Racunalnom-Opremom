/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

/**
 *
 * @author Admin
 */
public class ZavrsniRadException extends Exception{
    private String poruka;

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    

    public ZavrsniRadException(String poruka) {
        super(poruka);
        this.setPoruka("Prevedeno " + poruka);
    }
    
    
    
}
