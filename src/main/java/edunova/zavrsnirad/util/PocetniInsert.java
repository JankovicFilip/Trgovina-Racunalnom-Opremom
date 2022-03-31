/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

import com.github.javafaker.Faker;
import edunova.zavrsnirad.model.Komponenta;
import edunova.zavrsnirad.model.Kupac;
import edunova.zavrsnirad.model.Narudzba;
import edunova.zavrsnirad.model.Operater;
import edunova.zavrsnirad.model.Racunalo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Admin
 */
public class PocetniInsert {

    public static void inicijalniPodaci() {
        PocetniInsert.unosOperatera();
        PocetniInsert.izvedi();
    }

    public static void unosOperatera() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Operater o = new Operater();
        o.setIme("Filip");
        o.setPrezime("Janković");
        o.setUloga("admin");
        o.setEmail("filip.vno.jankovic@gmail.com");
        o.setLozinka(BCrypt.hashpw("Lozinka", BCrypt.gensalt()));
        session.save(o);
        session.getTransaction().commit();

    }

    /*public static void insertPolaznikaBezOIB() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();
        List<Polaznik> polaznici = generirajPolaznike(faker, session, false, 50);
        session.getTransaction().commit();
    }*/
    public static void izvedi() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();

        List<Kupac> kupci = generirajKupce(faker, session);
        List<Narudzba> narudzbe = generirajNarudzbe(faker, session);
        List<Komponenta> komponente = genererirajKomponente(faker, session);
        List<Racunalo> racunala = genererirajRacunala(faker, session);

        /* Smjer s = new Smjer();
        s.setNaziv(faker.book().title());
        s.setCertificiran(Math.random() < 0.5 ? true : false);
        s.setTrajanje((int) Math.random() * (200 - 100) + 100);
        s.setCijena(new BigDecimal(Math.random() * (10000 - 5000) + 5000));
         */
       

       
        session.getTransaction().commit();

    }

    private static List<Kupac> generirajKupce(Faker faker, Session session) {

        List<Kupac> kupci = new ArrayList<>();
        Kupac k;
        for (int i = 0; i < 144; i++) {
            k = new Kupac();
            k.setIme(faker.name().firstName());
            k.setPrezime(faker.name().lastName());
            k.setEmail(faker.name().firstName().substring(0, 1).toLowerCase()
                    + faker.name().lastName().toLowerCase().replace(" ", "")
                    + "@edunova.hr");

            k.setOib(OibUtil.generirajOib());
            k.setAdresa(faker.address().fullAddress());
            k.setBrojTelefona(faker.phoneNumber().phoneNumber());

            k.setEmail(faker.name().firstName().substring(0, 1).toLowerCase()
                    + faker.name().lastName().toLowerCase().replace(" ", "")
                    + "@gmail.com");
            session.save(k);
            kupci.add(k);
            System.out.println("Kreirao kupca: " + k.getIme() + k.getPrezime());
        }

        return kupci;

    }

    private static List<Narudzba> generirajNarudzbe(Faker faker, Session session) {
        List<Kupac> kupci = generirajKupce(faker, session);
        List<Narudzba> narudzbe = new ArrayList<>();
        Narudzba n;
        Kupac k;
        for (int i = 0; i < 144; i++) {
            k = kupci.get(i);
            n = new Narudzba();
            n.setDatumNarudzbe(new Date());
            n.setDatumOtpreme(new Date());
            n.setKupac(k);
            /*p.setPrezime(faker.name().lastName());
            p.setEmail(faker.name().firstName().substring(0, 1).toLowerCase()
                    + faker.name().lastName().toLowerCase().replace(" ", "")
                    + "@edunova.hr");

            p.setOib(EdunovaUtil.generirajOib());

            p.setIban("");*/
            session.save(n);
            narudzbe.add(n);
            System.out.println("Kreirao narudzbu: " + n.getDatumNarudzbe());
        }

        return narudzbe;

    }

    private static List<Komponenta> genererirajKomponente(Faker faker, Session session) {

        List<Komponenta> komponente = new ArrayList<>();
        Komponenta k;
        List<Narudzba> narudzbe = generirajNarudzbe(faker, session);
        Narudzba n;
        for (int i = 0; i < 144; i++) {
            n = narudzbe.get(i);
            k = new Komponenta();
            k.setNaziv(faker.book().title());

            k.setOpis(faker.harryPotter().quote());
            k.setNarudzbe(new ArrayList<>());
            k.getNarudzbe().add(n);

            k.setCijena(new BigDecimal(Math.random() * (10000 - 8000) + 5000));

            session.save(k);
            komponente.add(k);
            System.out.println("Kreirao komponentu: " + k.getNaziv());
        }

        return komponente;

    }

    private static List<Racunalo> genererirajRacunala(Faker faker, Session session) {

        List<Racunalo> racunala = new ArrayList<>();
        Racunalo r;
        List<Narudzba> narudzbe = generirajNarudzbe(faker, session);
        Narudzba n;

        for (int i = 0; i < 144; i++) {
            n = narudzbe.get(i);
            r = new Racunalo();
            r.setNaziv(faker.book().title());
            /*k.setCertificiran(Math.random() < 0.5 ? true : false);
            s.setTrajanje((int) Math.random() * (200 - 100) + 100);*/
            r.setOpis(faker.harryPotter().quote());
            r.setNarudzbe(new ArrayList<>());
            r.getNarudzbe().add(n);

            r.setCijena(new BigDecimal(Math.random() * (10000 - 2000) + 5000));

            session.save(r);
            racunala.add(r);
            System.out.println("Kreirao racunalo: " + r.getNaziv());
        }

        return racunala;

    }

}
