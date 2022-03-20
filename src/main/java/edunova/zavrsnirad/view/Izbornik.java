/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.zavrsnirad.view;

import edunova.zavrsnirad.util.OperaterUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Izbornik extends javax.swing.JFrame {

    private SimpleDateFormat df;
    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        postavke();
    }
    
    private void postavke(){
        setTitle(OperaterUtil.getNaslov("Izbornik"));
        jmAplikacija.setText(OperaterUtil.NAZIV_APP);
        
        df= new SimpleDateFormat("dd. MMMM. yyy. HH:mm:ss");
        Vrijeme v = new Vrijeme();
        v.start();
    }
    
    private class Vrijeme extends Thread{

        @Override
        public void run() {
                    lblVrijeme.setText(df.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Izbornik.class.getName()).log(Level.SEVERE, null, ex);
            }
            run();

        }   
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblVrijeme = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAplikacija = new javax.swing.JMenu();
        jmiExit = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiCpu = new javax.swing.JMenuItem();
        jmiGpu = new javax.swing.JMenuItem();
        jmiMb = new javax.swing.JMenuItem();
        jmiPsu = new javax.swing.JMenuItem();
        jmiRam = new javax.swing.JMenuItem();
        jmiFan = new javax.swing.JMenuItem();
        jmiSsd = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiLaptop = new javax.swing.JMenuItem();
        jmiPc = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        lblVrijeme.setText("jLabel1");
        jToolBar1.add(lblVrijeme);

        jmAplikacija.setText("File");

        jmiExit.setText("Izlaz");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmAplikacija.add(jmiExit);

        jMenuBar1.add(jmAplikacija);

        jMenu4.setText("Komponente");

        jmiCpu.setText("Procesori");
        jMenu4.add(jmiCpu);

        jmiGpu.setText("Grafičke kartice");
        jMenu4.add(jmiGpu);

        jmiMb.setText("Matične ploče");
        jMenu4.add(jmiMb);

        jmiPsu.setText("Napajanja");
        jMenu4.add(jmiPsu);

        jmiRam.setText("Radna memorija");
        jmiRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRamActionPerformed(evt);
            }
        });
        jMenu4.add(jmiRam);

        jmiFan.setText("Ventilatori");
        jMenu4.add(jmiFan);

        jmiSsd.setText("Hard i SSD diskovi");
        jMenu4.add(jmiSsd);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Racunala");

        jmiLaptop.setText("Prijenosna računala");
        jMenu5.add(jmiLaptop);

        jmiPc.setText("Stolna računala");
        jMenu5.add(jmiPc);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 491, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 424, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiRamActionPerformed

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
            dispose();
    }//GEN-LAST:event_jmiExitActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmAplikacija;
    private javax.swing.JMenuItem jmiCpu;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiFan;
    private javax.swing.JMenuItem jmiGpu;
    private javax.swing.JMenuItem jmiLaptop;
    private javax.swing.JMenuItem jmiMb;
    private javax.swing.JMenuItem jmiPc;
    private javax.swing.JMenuItem jmiPsu;
    private javax.swing.JMenuItem jmiRam;
    private javax.swing.JMenuItem jmiSsd;
    private javax.swing.JLabel lblVrijeme;
    // End of variables declaration//GEN-END:variables
}
