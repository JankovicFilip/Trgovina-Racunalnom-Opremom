/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Narudzba extends Entitet {

    @OneToOne
    private Kupac kupac;

    private Date datumNarudzbe;

    private Date datumOtpreme;
    @ManyToMany
    private List<Racunalo> racunala;
    @ManyToMany
    private List<Komponenta> komponente;

    public List<Komponenta> getKomponente() {
        return komponente;
    }

    public void setKomponente(List<Komponenta> komponente) {
        this.komponente = komponente;
    }
    
    

    public List<Racunalo> getRacunala() {
        return racunala;
    }

    public void setRacunala(List<Racunalo> racunala) {
        this.racunala = racunala;
    }

    @Override
    public String toString() {
        return datumNarudzbe + " " + datumOtpreme;
    }
    
    

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    

    public Date getDatumNarudzbe() {
        return datumNarudzbe;
    }

    public void setDatumNarudzbe(Date datumNarudzbe) {
        this.datumNarudzbe = datumNarudzbe;
    }

    public Date getDatumOtpreme() {
        return datumOtpreme;
    }

    public void setDatumOtpreme(Date datumOtpreme) {
        this.datumOtpreme = datumOtpreme;
    }

}
