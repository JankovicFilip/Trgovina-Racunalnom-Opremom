/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Narudzba;
import edunova.zavrsnirad.model.Racunalo;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ObradaRacunalo extends Obrada<Racunalo> {
    @Override
    public List<Racunalo> read() {
        return session.createQuery("from Racunalo a order by a.naziv").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        kontrolaNaziv();
        kontrolaOpis();
        kontrolaCijena();
        //kontrolaNarudzba();
        kontrolaNoviNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
        kontrolaNaziv();
        kontrolaOpis();
        kontrolaCijena();
        kontrolaPromjenaNaziva();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
        if(entitet.getNarudzbe()!=null || entitet.getNarudzbe().size()>0) {
            StringBuilder sb = new StringBuilder();
            for(Narudzba n : entitet.getNarudzbe()) {
                sb.append(n.getSifra());
                sb.append("\n");
            }
            throw new ZavrsniRadException("Ne možete obrisati stavku jer za to računalo postoji narudžba!" + sb.toString());
        }

    }

    private void kontrolaNaziv() throws ZavrsniRadException{
        if(entitet.getNaziv()==null || entitet.getNaziv().trim().isEmpty()) {
            throw new ZavrsniRadException("Naziv ne smije biti prazan!");
        }
        if(entitet.getNaziv().trim().length()>100) {
            throw new ZavrsniRadException("Naziv ne smije imati vise od 100 znakova!");
        }
    }
    

    private void kontrolaOpis() throws ZavrsniRadException{
        if(entitet.getOpis()==null || entitet.getOpis().trim().isEmpty()) {
            throw new ZavrsniRadException("Opis ne smije biti prazan!");
        }
        if(entitet.getOpis().trim().length()>1000) {
            throw new ZavrsniRadException("Opis ne smije imati vise od 1000 znakova!");
        }
            
    }

    private void kontrolaCijena() throws ZavrsniRadException{
        if(entitet.getCijena()==null) {
            throw new ZavrsniRadException("Cijena ne smije biti prazna!");
        }
        if(entitet.getCijena().compareTo(BigDecimal.ZERO)<=0) {
            throw new ZavrsniRadException("Cijena mora biti pozitivan broj!");
        }
        if(entitet.getCijena().compareTo(new BigDecimal(30000))>0) {
            throw new ZavrsniRadException("Cijena mora biti manja od 30000!");
        }
                //|| entitet.getCijena().compareTo(BigDecimal.ZERO)>0
                //|| entitet.getCijena().compareTo(new BigDecimal(30000))>0) {
            //throw new ZavrsniRadException("Cijena more biti veca od 0 i manja od 30000!");
        //}
        
    }

    /*private void kontrolaNarudzba() throws ZavrsniRadException{
        if(entitet.getNarudzbe()!=null || entitet.getNarudzbe().size()>0) {
            StringBuilder sb = new StringBuilder();
            for(Narudzba n : entitet.getNarudzbe()) {
                sb.append(n.getSifra());
                sb.append("\n");
            }
            throw new ZavrsniRadException("Ne možete obrisati stavku jer za to računalo postoji narudžba!" + sb.toString());
        }
        
    }*/
    
    private void kontrolaNoviNaziv() throws ZavrsniRadException{
        List<Racunalo> racunala = session.createQuery("from Racunalo r "
                + "where r.naziv=:naziv")
                .setParameter("naziv", entitet.getNaziv()).list();
                
                if(racunala!=null  && racunala.size()>0) {
                    throw new ZavrsniRadException("Naziv tog računala već postoji, molim Vas odaberite drugi naziv!");
                }
    }

    private void kontrolaPromjenaNaziva() throws ZavrsniRadException{
        List<Racunalo> racunala = session.createQuery("from Racunalo r "
                + "where r.naziv=:naziv and r.sifra!=:sifra")
                .setParameter("naziv", entitet.getNaziv())
                .setParameter("sifra", entitet.getSifra()).list();
        
        if(racunala!=null && racunala.size()>0) {
            throw new ZavrsniRadException("Naziv tog računala već postoji, molim Vas odaberite drugi naziv!");
        }
    }
}
