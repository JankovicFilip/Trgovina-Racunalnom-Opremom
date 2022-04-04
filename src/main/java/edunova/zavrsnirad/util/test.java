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
