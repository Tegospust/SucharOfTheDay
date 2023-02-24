/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ounis.sucharoftheday;

import com.ounis.frames.BaseFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author AndroidDev
 */
public class MainFrame extends BaseFrame implements ActionListener {

    private static final String CHESTNUT_TOOL_TIP_TEXT = "Dwuklik losuje kolejnego sucharka...";
   
    
//    kliknięcie klawisza btnClose
    class BtnCloseClick implements ActionListener {
        
        private MainFrame mainFrame;
        BtnCloseClick(MainFrame aMainFrame) {
            this.mainFrame = aMainFrame;
        }
        
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            this.mainFrame.setVisible(false);
            this.mainFrame.dispatchEvent(new WindowEvent(this.mainFrame, WindowEvent.WINDOW_CLOSING));
        }
        
    }
    
    
    class btnCloseKeyListener implements KeyListener {
        
        private BaseFrame mainFrame;
        btnCloseKeyListener(BaseFrame aMainFrame) {
            this.mainFrame = aMainFrame;
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.mainFrame.setVisible(false);
                this.mainFrame.dispatchEvent(new WindowEvent(this.mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
//    dwukrotne kilknięcie lewym przyciskiem myszy na taTextChestNut
    class ChestNutTextMouseAdapter extends MouseAdapter {

//        private JTextArea object;
//        ChestNutTextMouseHandler() {
//            super();
//            this.object = anObject;
//        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if ( e.getSource().equals(taChestNutText)) {
                int btnNum = e.getButton();
                int clkCount = e.getClickCount();
                if (btnNum == MouseEvent.BUTTON1) { // lewy przycisk myszy
                    if (clkCount == 2)  { // dwuklik
                        taChestNutText.setText(getChestNutText());
//                        System.out.println("Losowanie następnego sucharka...");
                    }
                }
            }  
        }
    }
    
    private String getChestNutText() {
        String[] prefixes = new String[] {"A wiesz,","Albo,", "Aaaaa,"};
        String prefix = prefixes[(new Random().nextInt(prefixes.length-1))];
        
        return String.format("%s\n%s", prefix, new ChestNuts(ChestNuts.FILE_CHEST_NUTS));        
    }
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setTitle("Sucharki...");
        setResizable(false);
        
        btnClose.requestFocus();
        
        btnClose.addActionListener(new BtnCloseClick(this));
        btnClose.addKeyListener(new btnCloseKeyListener(this));
        
//        ChestNuts chn = new ChestNuts(ChestNuts.FILE_CHEST_NUTS);
        
        taChestNutText.addMouseListener(new MouseAdapter() {           
        });
        taChestNutText.addMouseListener(new ChestNutTextMouseAdapter());
        
        
                
        
        taChestNutText.setText(getChestNutText());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taChestNutText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClose.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClose.setText("Buachachachachacha!");

        taChestNutText.setEditable(false);
        taChestNutText.setBackground(new java.awt.Color(204, 255, 255));
        taChestNutText.setColumns(20);
        taChestNutText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        taChestNutText.setLineWrap(true);
        taChestNutText.setRows(5);
        taChestNutText.setToolTipText(this.CHESTNUT_TOOL_TIP_TEXT);
        jScrollPane1.setViewportView(taChestNutText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                MainFrame mf = new MainFrame();
//                mf.centerFrame();
//                mf.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taChestNutText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
//        this.setVisible(false);
//        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
