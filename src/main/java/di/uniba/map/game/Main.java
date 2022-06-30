package di.uniba.map.game;

import com.formdev.flatlaf.FlatDarkLaf;
import di.uniba.map.game.engine.Engine;
import di.uniba.map.game.menu.*;
import di.uniba.map.game.story.Story;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.*;

/**
 * Classe Main per l'avvio dell'applicazione.
 * 
 * @author Piersilvio
 * @author Giulio Russo
 * @author Francesco Pio Scoglietti
 * 
 * @version 1.0
 */
public class Main extends JFrame {
    
    private ChiSiamo chisiamo;
    private HelpComandi helpcomandi;
    private Thread t = new Thread(new ThreadMusic());
    private static boolean flagMusic = false;

    public Main() throws InterruptedIOException {
        
        if(!flagMusic){ 
            flagMusic = true;
            t.start(); 
        }

        initComponents();
        ImageIcon image = new ImageIcon("Img//Logo.png");
        setIconImage(image.getImage());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nuovaPartita = new javax.swing.JButton();
        helpComandi = new javax.swing.JButton();
        esciGioco = new javax.swing.JButton();
        chiSiamo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gli Amari");
        setBackground(new java.awt.Color(51, 51, 51));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName("frameMain"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        title.setText("Gli Amari!");

        nuovaPartita.setText("Gioca...");
        nuovaPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuovaPartitaActionPerformed(evt);
            }
        });

        helpComandi.setText("Come Giocare...");
        helpComandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpComandiActionPerformed(evt);
            }
        });

        esciGioco.setText("Esci dal gioco");
        esciGioco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esciGiocoActionPerformed(evt);
            }
        });

        chiSiamo.setText("Chi siamo...");
        chiSiamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiSiamoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(esciGioco))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(helpComandi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nuovaPartita, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chiSiamo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(helpComandi)
                            .addComponent(nuovaPartita)
                            .addComponent(chiSiamo))
                        .addGap(50, 50, 50)))
                .addComponent(esciGioco)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("1.0");

        jLabel3.setIcon(new javax.swing.ImageIcon("Img//Copertina.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /** 
     * evento sul bottone "Chi Siamo..."
     * 
     * @param evt
     */
    private void chiSiamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiSiamoActionPerformed
        try{
            chisiamo = new ChiSiamo();
            chisiamo.setVisible(true);
            setVisible(false);
        }catch(IOException e){}
    }//GEN-LAST:event_chiSiamoActionPerformed

    
    /** 
     * evento sul bottone "Esci"
     * 
     * @param evt
     */
    private void esciGiocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esciGiocoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_esciGiocoActionPerformed

    
    /** 
     * evento sul bottone "Come Giocare..."
     * 
     * @param evt
     */
    private void helpComandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpComandiActionPerformed
        try{
            helpcomandi = new HelpComandi();
            helpcomandi.setVisible(true);
            setVisible(false);
        }catch(IOException e){}
    }//GEN-LAST:event_helpComandiActionPerformed

    
    /** 
     * evento sul bottone "Nuova partita..."
     * 
     * @param evt
     */
    private void nuovaPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuovaPartitaActionPerformed
        try{
            setVisible(false);
            Engine engine = new Engine(new Story());
            Engine.engine(engine);
            setVisible(true);
        }catch(IllegalAccessException | NoSuchMethodException | InvocationTargetException e){}
    }//GEN-LAST:event_nuovaPartitaActionPerformed

    
    /** 
     * metodo statico per la creazione del Frame di avvio.
     * è stato impostato il look and feel di default a FlatLaf Dark.
     * per info sui look and feel vedi: http://www.java-tips.org/java-se-tips-100019/javax.swing.plaf.metal.MetalLookAndFeel/
     * 
     * @param args passa una stringa
     */
    public static void main(String args[]) {
        
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }catch(UnsupportedLookAndFeelException e){
             System.err.println( "Failed to initialize LaF" );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Main().setVisible(true);
            } catch (InterruptedIOException e) {
                e.printStackTrace();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chiSiamo;
    private javax.swing.JButton esciGioco;
    private javax.swing.JButton helpComandi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton nuovaPartita;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
