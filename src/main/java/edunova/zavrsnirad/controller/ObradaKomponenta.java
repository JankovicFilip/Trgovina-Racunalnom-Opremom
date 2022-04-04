/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Komponenta;
import edunova.zavrsnirad.model.Narudzba;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ObradaKomponenta extends Obrada<Komponenta> {

    @Override
    public List<Komponenta> read() {
        return session.createQuery("from Komponenta a order by a.naziv").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        kontrolaNaziv();
        kontrolaOpis();
        kontrolaCijena();
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
        if (entitet.getNarudzbe() != null || entitet.getNarudzbe().size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Narudzba n : entitet.getNarudzbe()) {
                sb.append(n.getSifra());
                sb.append("\n");
            }
            throw new ZavrsniRadException("Ne možete obrisati stavku jer za tu komponentu postoji narudžba!" + sb.toString());

        }
    }

    private void kontrolaNaziv() throws ZavrsniRadException {
        if (entitet.getNaziv() == null || entitet.getNaziv().trim().isEmpty()) {
            throw new ZavrsniRadException("Naziv ne smije biti prazan!");
        }
        if (entitet.getNaziv().trim().length() > 100) {
            throw new ZavrsniRadException("Naziv ne smije imati vise od 100 znakova!");
        }

    }

    private void kontrolaOpis() throws ZavrsniRadException {
        if (entitet.getOpis() == null || entitet.getOpis().trim().isEmpty()) {
            throw new ZavrsniRadException("Opis ne smije biti prazan!");
        }
        if (entitet.getOpis().trim().length() > 1000) {
            throw new ZavrsniRadException("Opis ne smije imati vise od 1000 znakova!");
        }

    }

    private void kontrolaCijena() throws ZavrsniRadException {
        if (entitet.getCijena() == null) {
            throw new ZavrsniRadException("Cijena ne smije biti prazna ili 0!");
        }
        if (entitet.getCijena().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ZavrsniRadException("Cijena mora biti u pozitivnom broju!");
        }

        if (entitet.getCijena().compareTo(new BigDecimal(30000)) > 0) {
            throw new ZavrsniRadException("Cijena mora biti ispod 30000!");
        }
        /*|| entitet.getCijena().compareTo(BigDecimal.ZERO)>0
                || entitet.getCijena().compareTo(new BigDecimal(30000))<0) {
            throw new ZavrsniRadException("Cijena ne smije biti manja od 0 i veca od 30000!");
        }*/
    }

    private void kontrolaNoviNaziv() throws ZavrsniRadException {
        List<Komponenta> komponente = session.createQuery("from Komponenta k "
                + "where k.naziv=:naziv")
                .setParameter("naziv", entitet.getNaziv()).list();

        if (komponente != null && komponente.size() > 0) {
            throw new ZavrsniRadException("Naziv tog računala već postoji, molim Vas odaberite drugi naziv!");
        }
    }

    private void kontrolaPromjenaNaziva() throws ZavrsniRadException {
        List<Komponenta> komponente = session.createQuery("from Komponenta k "
                + "where k.naziv=:naziv and k.sifra!=:sifra")
                .setParameter("naziv", entitet.getNaziv())
                .setParameter("sifra", entitet.getSifra()).list();

        if (komponente != null && komponente.size() > 0) {
            throw new ZavrsniRadException("Naziv te komponente već postoji, molim Vas odaberite drugi naziv!");
        }
    }

}
