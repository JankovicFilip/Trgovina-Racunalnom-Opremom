/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad;

import edunova.zavrsnirad.model.Kupac;
import java.util.Scanner;
import org.hibernate.Session;
import edunova.zavrsnirad.util.Unos;
import edunova.zavrsnirad.util.ZavrsniRadException;
import edunova.zavrsnirad.controller.Obrada;
import edunova.zavrsnirad.controller.ObradaKupac;
import edunova.zavrsnirad.controller.ObradaOsoba;
import edunova.zavrsnirad.model.Osoba;
import edunova.zavrsnirad.util.HibernateUtil;
import edunova.zavrsnirad.util.PocetniInsert;
import edunova.zavrsnirad.view.SplashScreen;

/**
 *
 * @author Admin
 */
public class Start {

    private Session session;
    //private Osoba osoba;
    private Kupac kupac;
    private Scanner ulaz;

    public Start() {

        this.session = HibernateUtil.getSession();
        
        
        

    }

    public void unos() {
        Kupac k = new Kupac();
        //o.setSifra(Unos.unesiLong(ulaz, "Molim vas unesite sifru!"));
        /*k.setEmail(Unos.unesiString(ulaz, "Koji je vas email?"));
        k.setOib(Unos.unesiString(ulaz, "Koji je vas oib?"));*/
        ObradaKupac ok = new ObradaKupac();
        ok.setEntitet(k);
        /*k.setIme(Unos.unesiString(ulaz, "Koje je Vase ime?"));

        k.setPrezime(Unos.unesiString(ulaz, "Vase ime molim"));
        k.setEmail(Unos.unesiString(ulaz, "Koji je vas email?"));
        k.setOib(Unos.unesiString(ulaz, "Koji je vas oib?"));
        */
        k.setBrojTelefona(Unos.unesiString(ulaz, "Telefon"));
        /*try {
            k.setIme(Unos.unesiString(ulaz, "Koje je Vase ime?"));

            ok.create();
        } catch (ZavrsniRadException e) {
            System.out.println(e.getPoruka());
            
            
        }
        k.setPrezime(Unos.unesiString(ulaz, "Koje je vase prezime?"));
        try {
            k.setPrezime(Unos.unesiString(ulaz, "Koje je vase prezime?"));

            ok.create();
        } catch (ZavrsniRadException e) {
            System.out.println(e.getPoruka());
        }*/
 /*k.setEmail(Unos.unesiString(ulaz, "Koji je vas email?"));
        try {
            ok.create();
        } catch (ZavrsniRadException e) {
            System.out.println(e.getPoruka());
        }
        k.setOib(Unos.unesiString(ulaz, "Koji je vas oib?"));
        try {
            ok.create();
        } catch (ZavrsniRadException e) {
            System.out.println(e.getPoruka());
        }
         */
    }

    public static void main(String[] args) {
        //new Start();
        PocetniInsert.inicijalniPodaci();
        //new edunova.zavrsnirad.view.SplashScreen().setVisible(true);
    }

}
