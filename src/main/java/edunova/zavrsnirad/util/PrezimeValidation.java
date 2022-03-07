/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

/**
 *
 * @author Admin
 */
public class PrezimeValidation {
    
     public static boolean checkPrezime(String prezime){
         
        return prezime.matches("[A-Z][a-zA-Z]*");
    }
    
}
