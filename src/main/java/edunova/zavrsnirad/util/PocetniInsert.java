/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

import com.github.javafaker.Faker;
import edunova.zavrsnirad.model.Komponenta;
import edunova.zavrsnirad.model.Korisnik;
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
        //PocetniInsert.unosKorisnika();
        PocetniInsert.izvedi();
    }

    public static void unosKorisnika() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        

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

        //List<Korisnik> korisnici = generirajKorisnike(faker, session);
        List<Narudzba> narudzbe = generirajNarudzbe(faker, session);
        //List<Komponenta> komponente = genererirajKomponente(faker, session);
        //List<Racunalo> racunala = genererirajRacunala(faker, session);

        /* Smjer s = new Smjer();
        s.setNaziv(faker.book().title());
        s.setCertificiran(Math.random() < 0.5 ? true : false);
        s.setTrajanje((int) Math.random() * (200 - 100) + 100);
        s.setCijena(new BigDecimal(Math.random() * (10000 - 5000) + 5000));
         */
        session.getTransaction().commit();

    }

    private static List<Korisnik> generirajKorisnike(Faker faker, Session session) {

        List<Korisnik> korisnici = new ArrayList<>();
        Korisnik k;
        for (int i = 0; i < 50; i++) {
            k = new Korisnik();
            k.setIme(faker.name().firstName());
            k.setPrezime(faker.name().lastName());
            k.setEmail(faker.name().firstName().substring(0, 1).toLowerCase()
                    + faker.name().lastName().toLowerCase().replace(" ", "")
                    + "@edunova.hr");

            k.setOib(OibUtil.generirajOib());
            k.setAdresa(faker.address().fullAddress());
            k.setBrojTelefona(faker.phoneNumber().phoneNumber());
            k.setLozinka(BCrypt.hashpw(faker.animal().name(), BCrypt.gensalt()));

            k.setEmail(faker.name().firstName().substring(0, 1).toLowerCase()
                    + faker.name().lastName().toLowerCase().replace(" ", "")
                    + "@gmail.com");
            k.setUloga("oper");
            session.save(k);
            korisnici.add(k);
            System.out.println("Kreirao korisnika: " + k.getIme() + k.getPrezime() + k.getSifra());
        }
        k = new Korisnik();
        k.setIme("Filip");
        k.setPrezime("Janković");
        k.setUloga("admin");
        k.setEmail("filip.vno.jankovic@gmail.com");
        k.setLozinka(BCrypt.hashpw("Lozinka", BCrypt.gensalt()));
        session.save(k);
        //session.getTransaction().commit();

        return korisnici;

    }

    private static List<Narudzba> generirajNarudzbe(Faker faker, Session session) {
        List<Korisnik> korisnici = generirajKorisnike(faker, session);
        List<Narudzba> narudzbe = new ArrayList<>();
        List<Komponenta> komponente = genererirajKomponente(faker, session);
        List<Racunalo> racunala = genererirajRacunala(faker, session);
        Narudzba n;
        Korisnik k;
        for (int j = 0; j < korisnici.size() - 2; j++) {
            k = korisnici.get(j);
            for (int i = 0; i < 10; i++) {
                n = new Narudzba();
                n.setDatumNarudzbe(new Date());
                n.setDatumOtpreme(new Date());
                n.setKorisnik(k);
                Collections.shuffle(korisnici);
                Collections.shuffle(komponente);
                Collections.shuffle(racunala);
                n.setKomponente(new ArrayList<>());
                for (int a = 0; a < ((int) Math.random() * (10 - 8) +2 ); a++) {
                    n.getKomponente().add(komponente.get(a));
                }
                n.setRacunala(new ArrayList<>());
                for (int b = 0; b < ((int) Math.random() * (10 - 8) + 2); b++) {
                    n.getRacunala().add(racunala.get(b));
                }
                session.save(n);
                narudzbe.add(n);
                System.out.println("Kreirao narudzbu: " + n.getSifra());
            }
        }
        /*for (int i = 0; i < 50; i++) {
            k = kupci.get(i);
            n = new Narudzba();
            n.setDatumNarudzbe(new Date());
            n.setDatumOtpreme(new Date());
            n.setKupac(k);
            Collections.shuffle(kupci);
            Collections.shuffle(komponente);
            Collections.shuffle(racunala);
            n.setKomponente(new ArrayList<>());
            n.getKomponente().add(komponente.get(i));
            n.setRacunala(new ArrayList<>());
            n.getRacunala().add(racunala.get(i));

            session.save(n);
            narudzbe.add(n);
            System.out.println("Kreirao narudzbu: " + n.getDatumNarudzbe());
        }*/

        return narudzbe;

    }

    private static List<Komponenta> genererirajKomponente(Faker faker, Session session) {

        List<Komponenta> komponente = new ArrayList<>();
        Komponenta k;

        for (int i = 0; i < 50; i++) {

            k = new Komponenta();

            k.setNaziv(faker.book().title());

            k.setOpis(faker.harryPotter().quote());

            k.setCijena(new BigDecimal(Math.random() * (10000 - 8000) + 5000));

            session.save(k);
            komponente.add(k);
            System.out.println("Kreirao komponentu: " + k.getNaziv() + k.getSifra());
        }

        return komponente;

    }

    private static List<Racunalo> genererirajRacunala(Faker faker, Session session) {

        List<Racunalo> racunala = new ArrayList<>();
        Racunalo r;

        for (int i = 0; i < 50; i++) {

            r = new Racunalo();
            r.setNaziv(faker.book().title());

            r.setOpis(faker.harryPotter().quote());

            r.setCijena(new BigDecimal(Math.random() * (10000 - 2000) + 5000));

            session.save(r);
            racunala.add(r);
            System.out.println("Kreirao racunalo: " + r.getNaziv() + r.getSifra());
        }

        return racunala;

    }

}
