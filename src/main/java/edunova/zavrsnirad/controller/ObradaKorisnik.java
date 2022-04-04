/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

/**
 *
 * @author Admin
 */
import edunova.zavrsnirad.model.Korisnik;
import edunova.zavrsnirad.util.TelefonValidation;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.util.Arrays;
import java.util.List;
import javax.persistence.NoResultException;
import org.mindrot.jbcrypt.BCrypt;

public class ObradaKorisnik extends ObradaOsoba<Korisnik> {

    @Override
    public List<Korisnik> read() {
        return session.createQuery("from Korisnik").list();
    }
    
    public Korisnik autoriziraj(String email, String lozinka) {
        Korisnik korisnik = null;
        try {
            korisnik = (Korisnik) session.createQuery("from Korisnik where email=:email")
                    .setParameter("email", email).getSingleResult();

        } catch (NoResultException e) {
            return null;

        }
        if(korisnik==null) {
            return null;
        }
        return BCrypt.checkpw(lozinka, korisnik.getLozinka()) ? korisnik : null;
        

    }

    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        super.kontrolaCreate();
        kontrolaAdresa();
        kontrolaBrojTelefona();
        kontrolaLozinka();
        
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
        super.kontrolaUpdate();
        kontrolaAdresa();
        kontrolaBrojTelefona();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {

    }

    private void kontrolaAdresa() throws ZavrsniRadException {
        if (entitet.getAdresa() == null || entitet.getAdresa().isEmpty()) {
            throw new ZavrsniRadException("Adresa ne smije biti prazna");
        }

    }

    private void kontrolaBrojTelefona() throws ZavrsniRadException {

        char[] dozvoljeno = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+'};
        if (entitet.getBrojTelefona() != null) {
            for (int i = 0; i < entitet.getBrojTelefona().length(); i++) {
                for (char c : dozvoljeno) {
                    if (entitet.getPrezime().charAt(i) != c) {
                        throw new ZavrsniRadException("Broj telefona mora sadrzavati samo brojeve i moze sadrzavati + znak");
                        //Arrays.toString(dozvoljeno));
                    }
                }
            }
        }

        if (entitet.getBrojTelefona().isEmpty() || entitet.getBrojTelefona() == null) {
            throw new ZavrsniRadException("Broj telefona ne smije biti prazan!!");
        }
    }

    private void kontrolaLozinka() throws ZavrsniRadException{
        if(entitet.getLozinka() == null || entitet.getLozinka().trim().isEmpty()){
            throw new ZavrsniRadException("Lozinka ne smije biti prazna!");
        }
        if(entitet.getLozinka().trim().length()<8) {
            throw new ZavrsniRadException("Lozinka mora imati minimalno 8 znakova!");
        }
        if(entitet.getLozinka().trim().length()>20) {
            throw new ZavrsniRadException("Lozinka može imati maksimalno 20 znakova!");
        }
    }

    

}
