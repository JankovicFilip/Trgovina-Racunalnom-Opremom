/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class ImeValidation {
     public static boolean checkIme(String in){
        return Pattern.matches("[A-Z]+([ '-][a-zA-Z]+)*", in);
    }
    
}
