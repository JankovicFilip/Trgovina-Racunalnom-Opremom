/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

import edunova.zavrsnirad.controller.ObradaRacunalo;
import edunova.zavrsnirad.model.Entitet;
import edunova.zavrsnirad.model.Racunalo;
import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class test {

    private ObradaRacunalo obrada;
    
    //OVO JE RAD SA DATUMIMA
    /* Calendar c = Calendar.getInstance();
        for(int i=0;i<10;i++){
            c.set(Calendar.MONTH, 5); // mjeseci kreću od nule
        c.set(Calendar.DAY_OF_MONTH, slucajniBroj(27, 1));
        c.set(Calendar.YEAR, 2022);
        c.set(Calendar.HOUR_OF_DAY,  slucajniBroj(9, 7));
        c.set(Calendar.MINUTE,  slucajniBroj(59, 1));
        c.set(Calendar.SECOND, slucajniBroj(59, 1) );
        System.out.println("Početak: " + c.getTime());
        if(slucajniBroj(19, 1)>5){
            c.add(Calendar.MINUTE, slucajniBroj((8*60) + 10, (7 * 60) + 50));
            System.out.println("Kraj: " + c.getTime());
        }else{
            //postaviš završni datum na null (ne moraš ništa raditi)
        }
            System.out.println("-------------");
        
        }*/

    public test() {
        obrada = new ObradaRacunalo();
        
        try {
            var s = obrada.getEntitet();
        s.setOpis("Test3");
        s.setNaziv("T4");
        s.setCijena(new BigDecimal(20000.00));
        obrada.create();
        } catch (ZavrsniRadException e) {
            System.out.println(e.getPoruka());
        }
        
    }

    public static void main(String[] args) {
        new test();

        //System.out.println(validateZip("0955778782"));
        //System.out.println(validateCity("Osijek"));
    }

    public static boolean validateCity(String city) {
        return city.matches("[A-Z][a-z]*");
    }
    // validate zip

    public static boolean validateZip(String zip) {
        return zip.matches("\\d{10}");
    }
}
