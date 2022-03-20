/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Kupac;
import edunova.zavrsnirad.model.Narudzba;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ObradaNarudzba extends Obrada<Narudzba> {

    @Override
    public List<Narudzba> read() {
        return session.createQuery("from Narudzba n order by n.datumNarudzbe").list();
    }

    @Override
    protected void kontrolaCreate() throws ZavrsniRadException {
        kontrolaDatumNarudzbe();
        kontrolaDatumOtpreme();
    }

    @Override
    protected void kontrolaUpdate() throws ZavrsniRadException {
        kontrolaDatumNarudzbe();
        kontrolaDatumOtpreme();
    }

    @Override
    protected void kontrolaDelete() throws ZavrsniRadException {
        /*if (entitet.getKupac() != null) {
            StringBuilder sb = new StringBuilder();
            Narudzba n = new Narudzba();
            sb.append(n.getKupac());
            sb.append("\n");

        }*/
    }

    private void kontrolaDatumNarudzbe() throws ZavrsniRadException{
        if(entitet.getDatumNarudzbe()==null || entitet.getDatumNarudzbe().toString().isEmpty()) {
            throw new ZavrsniRadException("Datum narudzbe ne smije biti prazan!");
        }
        
        /*if (entitet.getDatumNarudzbe()!= null) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(entitet.getDatumNarudzbe());
            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                    || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                throw new ZavrsniRadException("Datum ne može biti na vikend (subota ili vikend");
            }
            
        }*/

    }

    private void kontrolaDatumOtpreme() throws ZavrsniRadException{
         if(entitet.getDatumOtpreme()==null || entitet.getDatumOtpreme().toString().isEmpty()) {
            throw new ZavrsniRadException("Datum otpreme ne smije biti prazan!");
         }
    }

}
