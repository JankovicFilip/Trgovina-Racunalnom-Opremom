/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

/**
 *
 * @author Admin
 */
public class test {
    public static void main( String[] args )
   {
       System.out.println(validateZip("0955778782"));
       //System.out.println(validateCity("Osijek"));
   }
    
    public static boolean validateCity(String city) {
        return city.matches("[A-Z][a-z]*");
    }
   // validate zip
   public static boolean validateZip( String zip )
   {
      return zip.matches( "\\d{10}");
   } 
}
