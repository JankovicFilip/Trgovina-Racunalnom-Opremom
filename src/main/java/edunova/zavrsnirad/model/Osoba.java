/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Admin
 */
@MappedSuperclass
public class Osoba extends Entitet{
    
    private String ime;
    private String prezime;
    private String email;
    @Column(columnDefinition = "char (11)")
    private String oib;
    
    
    @Override
    public String toString() {
        return ime + " " + prezime;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime==null ? ime : ime.trim();
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime ==null ? prezime : prezime.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }
    
}
