/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

/**
 *
 * @author Admin
 */
import edunova.zavrsnirad.model.Kupac;
import edunova.zavrsnirad.util.TelefonValidation;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.util.Arrays;
import java.util.List;

public class ObradaKupac extends ObradaOsoba<Kupac> {

    @Override
    public List<Kupac> read() {
        return session.createQuery("from Kupac").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        super.kontrolaCreate();
        kontrolaAdresa();
        kontrolaBrojTelefona();
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

}
