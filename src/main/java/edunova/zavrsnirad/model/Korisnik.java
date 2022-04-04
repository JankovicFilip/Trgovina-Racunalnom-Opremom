/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Korisnik extends Osoba{
    private String brojTelefona;
    private String adresa;
    private String lozinka;
    private String uloga;
    
    @OneToMany(mappedBy = "korisnik")
    private List<Narudzba> narudzbe;

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public List<Narudzba> getNarudzbe() {
        return narudzbe;
    }

    public void setNarudzbe(List<Narudzba> narudzbe) {
        this.narudzbe = narudzbe;
    }
    
    

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
}
