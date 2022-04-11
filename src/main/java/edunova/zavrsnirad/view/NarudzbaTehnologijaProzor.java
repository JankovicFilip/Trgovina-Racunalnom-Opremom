/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.zavrsnirad.view;

import edunova.zavrsnirad.controller.ObradaKomponenta;
import edunova.zavrsnirad.controller.ObradaKorisnik;
import edunova.zavrsnirad.controller.ObradaNarudzba;
import edunova.zavrsnirad.controller.ObradaRacunalo;
import edunova.zavrsnirad.model.Komponenta;
import edunova.zavrsnirad.model.Korisnik;
import edunova.zavrsnirad.model.Narudzba;
import edunova.zavrsnirad.model.Racunalo;
import edunova.zavrsnirad.util.OperaterUtil;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.awt.event.KeyEvent;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NarudzbaTehnologijaProzor extends javax.swing.JFrame {

    ObradaNarudzba obradaNarudzba;
    ObradaKorisnik obradaKorisnik;
    ObradaKomponenta obradaKomponenta;
    ObradaRacunalo obradaRacunalo;

    /**
     * Creates new form NarudzbaTehnologijaProzor
     */
    public NarudzbaTehnologijaProzor() {
        initComponents();
        setTitle(OperaterUtil.getNaslov("Košarica"));
        obradaNarudzba = new ObradaNarudzba();
        obradaKorisnik = new ObradaKorisnik();
        obradaKomponenta = new ObradaKomponenta();
        obradaRacunalo = new ObradaRacunalo();
        ucitajNarudzbe();
        ucitajKorisnika();

    }

    private void preuzmiVrijednosti() {
        var e = obradaNarudzba.getEntitet();
        e.setKorisnik((Korisnik) cmbKorisnik.getSelectedItem());
        if (dpDatumNarudzbe.getDate() != null) {
            e.setDatumNarudzbe(
                    Date.from(
                            dpDatumNarudzbe.getDate().atStartOfDay().atZone(
                                    ZoneId.systemDefault()
                            ).toInstant()
                    )
            );
        } else {
            e.setDatumNarudzbe(null);
        }
        if (dpDatumOtpreme.getDate() != null) {
            e.setDatumOtpreme(
                    Date.from(
                            dpDatumOtpreme.getDate().atStartOfDay().atZone(
                                    ZoneId.systemDefault()
                            ).toInstant()
                    )
            );
        } else {
            e.setDatumOtpreme(null);
        }
        //lblBrojNarudzbe.setText(String.valueOf(e.getSifra()));
    }

    private void ucitajNarudzbe() {
        DefaultListModel<Narudzba> narudzbe = new DefaultListModel<>();
        List<Narudzba> entiteti = obradaNarudzba.read();

        for (Narudzba n : entiteti) {
            narudzbe.addElement(n);
        }
        lstEntiteti.setModel(narudzbe);
    }

    private void ucitajKorisnika() {
        DefaultComboBoxModel<Korisnik> mk = new DefaultComboBoxModel<>();
        Korisnik korisnik = new Korisnik();
        korisnik.setSifra(Long.valueOf(0));
        korisnik.setIme("Nije odabrano!");
        korisnik.setPrezime("Nije odabrano");

        mk.addElement(korisnik);
        new ObradaKorisnik().read().forEach(s -> {
            mk.addElement(s);
        });

        cmbKorisnik.setModel(mk);

    }

    private void ucitajRacunala() {
        DefaultListModel<Racunalo> racunala = new DefaultListModel<>();
        List<Racunalo> entiteti = obradaRacunalo.read();

        if (chbPocetakNazivaRacunalo.isSelected()) {
            entiteti = obradaRacunalo.readPocetakNazivaRacunala(txtUvjetRacunalo.getText().trim());
        } else {
            entiteti = obradaRacunalo.read(txtUvjetRacunalo.getText());
        }

        Collections.sort(entiteti, new RacunaloComparator());

        for (Racunalo r : entiteti) {
            racunala.addElement(r);
        }
        lstSvaRacunala.setModel(racunala);

    }

    private void ucitajKomponente() {
        DefaultListModel<Komponenta> komponente = new DefaultListModel<>();
        List<Komponenta> entiteti;

        if (chbPocetakNazivaKomponenta.isSelected()) {
            entiteti = obradaKomponenta.readPocetakNazivaKomponente(txtUvjetKomponenta.getText().trim());
        } else {
            entiteti = obradaKomponenta.read(txtUvjetKomponenta.getText());
        }

        Collections.sort(entiteti, new KomponentaComparator());
        for (Komponenta k : entiteti) {
            komponente.addElement(k);
        }
        lstSveKomponente.setModel(komponente);
    }

    private boolean postojiKomponentaUNarudzbi(DefaultListModel<Komponenta> m, Komponenta k) {
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getSifra().equals(k.getSifra())) {
                return true;
            }
        }
        return false;
    }

    private boolean postojiRacunaloUNarudzbi(DefaultListModel<Racunalo> m, Racunalo r) {
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getSifra().equals(r.getSifra())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        dpDatumNarudzbe = new com.github.lgooddatepicker.components.DatePicker();
        dpDatumOtpreme = new com.github.lgooddatepicker.components.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbKorisnik = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRacunalaNaNarudzbi = new javax.swing.JList<>();
        btnDodajRacunalo = new javax.swing.JButton();
        btnMakniRacunalo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSvaRacunala = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSveKomponente = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstKomponentaNaNarudzbi = new javax.swing.JList<>();
        btnDodajKomponentu = new javax.swing.JButton();
        btnMakniKomponentu = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtUvjetKomponenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUvjetRacunalo = new javax.swing.JTextField();
        btnTraziKomponente = new javax.swing.JButton();
        btnTraziRacunala = new javax.swing.JButton();
        chbPocetakNazivaKomponenta = new javax.swing.JCheckBox();
        chbPocetakNazivaRacunalo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Datum narudžbe");

        jLabel2.setText("Datum Otpreme");

        jLabel3.setText("Korisnik");

        jScrollPane2.setViewportView(lstRacunalaNaNarudzbi);

        btnDodajRacunalo.setText(" <<");
        btnDodajRacunalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajRacunaloActionPerformed(evt);
            }
        });

        btnMakniRacunalo.setText(">>");
        btnMakniRacunalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakniRacunaloActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(lstSvaRacunala);

        jScrollPane4.setViewportView(lstSveKomponente);

        jScrollPane5.setViewportView(lstKomponentaNaNarudzbi);

        btnDodajKomponentu.setText(" <<");
        btnDodajKomponentu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajKomponentuActionPerformed(evt);
            }
        });

        btnMakniKomponentu.setText(">>");
        btnMakniKomponentu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakniKomponentuActionPerformed(evt);
            }
        });

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel4.setText("Traži po nazivu komponente");

        txtUvjetKomponenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKomponentaKeyPressed(evt);
            }
        });

        jLabel5.setText("Traži po nazivu računala");

        txtUvjetRacunalo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetRacunaloKeyPressed(evt);
            }
        });

        btnTraziKomponente.setText("Traži");
        btnTraziKomponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziKomponenteActionPerformed(evt);
            }
        });

        btnTraziRacunala.setText("Traži");
        btnTraziRacunala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziRacunalaActionPerformed(evt);
            }
        });

        chbPocetakNazivaKomponenta.setText("Početak naziva komponente");

        chbPocetakNazivaRacunalo.setText("Početak naziva računala");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnKreiraj)
                        .addGap(22, 22, 22)
                        .addComponent(btnPromjeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dpDatumNarudzbe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dpDatumOtpreme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKorisnik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMakniKomponentu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDodajKomponentu, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMakniRacunalo, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(btnDodajRacunalo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUvjetKomponenta, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbPocetakNazivaKomponenta)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTraziKomponente))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbPocetakNazivaRacunalo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUvjetRacunalo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTraziRacunala))))))
                .addGap(0, 269, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnTraziKomponente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbPocetakNazivaKomponenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnDodajKomponentu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMakniKomponentu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodajRacunalo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMakniRacunalo)
                        .addGap(197, 197, 197))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dpDatumNarudzbe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dpDatumOtpreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnObrisi)
                                    .addComponent(btnPromjeni)
                                    .addComponent(btnKreiraj)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUvjetKomponenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(btnTraziRacunala))
                                .addGap(2, 2, 2)
                                .addComponent(chbPocetakNazivaRacunalo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUvjetRacunalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(69, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMakniRacunaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakniRacunaloActionPerformed
        DefaultListModel<Racunalo> m = (DefaultListModel<Racunalo>) lstRacunalaNaNarudzbi.getModel();
        for (Racunalo r : lstRacunalaNaNarudzbi.getSelectedValuesList()) {
            m.removeElement(r);
            for (Racunalo mr : obradaNarudzba.getEntitet().getRacunala()) {
                if (mr.getSifra().equals(r.getSifra())) {
                    obradaNarudzba.getEntitet().getRacunala().remove(mr);
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnMakniRacunaloActionPerformed

    private void btnMakniKomponentuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakniKomponentuActionPerformed
        DefaultListModel<Komponenta> m = (DefaultListModel<Komponenta>) lstKomponentaNaNarudzbi.getModel();
        for (Komponenta k : lstKomponentaNaNarudzbi.getSelectedValuesList()) {
            m.removeElement(k);
            for (Komponenta mk : obradaNarudzba.getEntitet().getKomponente()) {
                if (mk.getSifra().equals(k.getSifra())) {
                    obradaNarudzba.getEntitet().getKomponente().remove(mk);
                    break;
                }
            }
        }

    }//GEN-LAST:event_btnMakniKomponentuActionPerformed

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting() || lstEntiteti.getSelectedValue() == null) {
            return;
        }

        obradaNarudzba.setEntitet(lstEntiteti.getSelectedValue());
        var e = obradaNarudzba.getEntitet();
        if (e.getDatumNarudzbe() != null) {
            dpDatumNarudzbe.setDate(e.getDatumNarudzbe().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        } else {
            dpDatumNarudzbe.setDate(null);
        }

        if (e.getDatumOtpreme() != null) {
            dpDatumOtpreme.setDate(e.getDatumOtpreme().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        } else {
            dpDatumOtpreme.setDate(null);
        }
        if (e.getKorisnik() == null) {
            cmbKorisnik.setSelectedIndex(0);
        } else {
            cmbKorisnik.setSelectedItem(e.getKorisnik());
        }

        DefaultListModel<Komponenta> mk = new DefaultListModel<>();
        if (e.getKomponente() != null) {
            Collections.sort(e.getKomponente(), new KomponentaComparator());
            mk.addAll(e.getKomponente());
        }
        lstKomponentaNaNarudzbi.setModel(mk);

        DefaultListModel<Racunalo> mr = new DefaultListModel<>();
        if (e.getRacunala() != null) {
            Collections.sort(e.getRacunala(), new RacunaloComparator());
            mr.addAll(e.getRacunala());
        }
        lstRacunalaNaNarudzbi.setModel(mr);


    }//GEN-LAST:event_lstEntitetiValueChanged

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        try {
            if (obradaNarudzba.getEntitet() == null) {
                obradaNarudzba.setEntitet(new Narudzba());
            }
            preuzmiVrijednosti();
            obradaNarudzba.create();
            ucitajNarudzbe();

        } catch (ZavrsniRadException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (obradaNarudzba.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Odaberite što želite mjenjati!");
            return;
        }
        preuzmiVrijednosti();

        try {
            obradaNarudzba.update();
            ucitajNarudzbe();
        } catch (ZavrsniRadException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obradaNarudzba.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Odaberite što želite obrisati!");
            return;
        }

        if (JOptionPane.showConfirmDialog(getRootPane(),
                "Sigurno želite obrisati: \"" + obradaNarudzba.getEntitet().getSifra() + "\"?",
                "Brisanje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE)
                == JOptionPane.NO_OPTION) {
            return;

        }

        try {
            obradaNarudzba.delete();
            ucitajNarudzbe();
        } catch (ZavrsniRadException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void txtUvjetKomponentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKomponentaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajKomponente();
        }
    }//GEN-LAST:event_txtUvjetKomponentaKeyPressed

    private void txtUvjetRacunaloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetRacunaloKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajRacunala();
        }
    }//GEN-LAST:event_txtUvjetRacunaloKeyPressed

    private void btnTraziKomponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziKomponenteActionPerformed
        ucitajKomponente();
    }//GEN-LAST:event_btnTraziKomponenteActionPerformed

    private void btnTraziRacunalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziRacunalaActionPerformed
        ucitajRacunala();
    }//GEN-LAST:event_btnTraziRacunalaActionPerformed

    private void btnDodajKomponentuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajKomponentuActionPerformed
        DefaultListModel<Komponenta> m;
        try {
            if (obradaNarudzba.getEntitet() != null) {
                m = (DefaultListModel<Komponenta>) lstKomponentaNaNarudzbi.getModel();

            } else {
                obradaNarudzba.setEntitet(new Narudzba());
                obradaNarudzba.getEntitet().setKomponente(new ArrayList<>());
                //obradaNarudzba.getEntitet().setRacunala(new ArrayList<>());
                preuzmiVrijednosti();
                m = new DefaultListModel<>();
                lstKomponentaNaNarudzbi.setModel(m);
            }
            if (obradaNarudzba.getEntitet().getKomponente() == null) {
                obradaNarudzba.getEntitet().setKomponente(new ArrayList<>());
            }
            /*if (obradaNarudzba.getEntitet().getRacunala() == null) {
            obradaNarudzba.getEntitet().setRacunala(new ArrayList<>());
        }*/

            for (Komponenta k : lstSveKomponente.getSelectedValuesList()) {
                if (!postojiKomponentaUNarudzbi(m, k)) {
                    obradaNarudzba.getEntitet().getKomponente().add(k);
                    m.addElement(k);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Molim vas kreirajte narudžbu prvo!");
        }

        lstKomponentaNaNarudzbi.repaint();

    }//GEN-LAST:event_btnDodajKomponentuActionPerformed

    private void btnDodajRacunaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajRacunaloActionPerformed
        DefaultListModel<Racunalo> m;
        try {
            if (obradaNarudzba.getEntitet() != null) {
                m = (DefaultListModel<Racunalo>) lstRacunalaNaNarudzbi.getModel();

            } else {
                obradaNarudzba.setEntitet(new Narudzba());
                obradaNarudzba.getEntitet().setRacunala(new ArrayList<>());
                preuzmiVrijednosti();
                m = new DefaultListModel<>();
                lstRacunalaNaNarudzbi.setModel(m);
            }
            if (obradaNarudzba.getEntitet().getRacunala() == null) {
                obradaNarudzba.getEntitet().setRacunala(new ArrayList<>());
            }

            for (Racunalo r : lstSvaRacunala.getSelectedValuesList()) {
                if (!postojiRacunaloUNarudzbi(m, r)) {
                    obradaNarudzba.getEntitet().getRacunala().add(r);
                    m.addElement(r);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Molim vas kreirajte narudžbu prvo!");
        }

        lstRacunalaNaNarudzbi.repaint();
    }//GEN-LAST:event_btnDodajRacunaloActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajKomponentu;
    private javax.swing.JButton btnDodajRacunalo;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnMakniKomponentu;
    private javax.swing.JButton btnMakniRacunalo;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTraziKomponente;
    private javax.swing.JButton btnTraziRacunala;
    private javax.swing.JCheckBox chbPocetakNazivaKomponenta;
    private javax.swing.JCheckBox chbPocetakNazivaRacunalo;
    private javax.swing.JComboBox<Korisnik> cmbKorisnik;
    private com.github.lgooddatepicker.components.DatePicker dpDatumNarudzbe;
    private com.github.lgooddatepicker.components.DatePicker dpDatumOtpreme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Narudzba> lstEntiteti;
    private javax.swing.JList<Komponenta> lstKomponentaNaNarudzbi;
    private javax.swing.JList<Racunalo> lstRacunalaNaNarudzbi;
    private javax.swing.JList<Racunalo> lstSvaRacunala;
    private javax.swing.JList<Komponenta> lstSveKomponente;
    private javax.swing.JTextField txtUvjetKomponenta;
    private javax.swing.JTextField txtUvjetRacunalo;
    // End of variables declaration//GEN-END:variables
}
