
import javax.swing.JOptionPane;

// JPad by FktM

public class Main extends javax.swing.JFrame {

    // Variable Setup
    String version = "1.0";
    
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        UpperMenu = new javax.swing.JMenuBar();
        UM_File = new javax.swing.JMenu();
        UM_File_New = new javax.swing.JMenuItem();
        UM_File_Open = new javax.swing.JMenuItem();
        UM_File_Save = new javax.swing.JMenuItem();
        UM_File_Exit = new javax.swing.JMenuItem();
        UM_Help = new javax.swing.JMenu();
        UM_Help_About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JPad");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);

        jTextArea1.setBackground(new java.awt.Color(230, 230, 230));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        UpperMenu.setBackground(new java.awt.Color(255, 255, 255));
        UpperMenu.setForeground(new java.awt.Color(255, 255, 255));

        UM_File.setText("File");

        UM_File_New.setText("New");
        UM_File_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UM_File_NewActionPerformed(evt);
            }
        });
        UM_File.add(UM_File_New);

        UM_File_Open.setText("Open");
        UM_File_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UM_File_OpenActionPerformed(evt);
            }
        });
        UM_File.add(UM_File_Open);

        UM_File_Save.setText("Save");
        UM_File_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UM_File_SaveActionPerformed(evt);
            }
        });
        UM_File.add(UM_File_Save);

        UM_File_Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        UM_File_Exit.setText("Exit");
        UM_File_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UM_File_ExitActionPerformed(evt);
            }
        });
        UM_File.add(UM_File_Exit);

        UpperMenu.add(UM_File);

        UM_Help.setText("Help");

        UM_Help_About.setText("About");
        UM_Help_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UM_Help_AboutActionPerformed(evt);
            }
        });
        UM_Help.add(UM_Help_About);

        UpperMenu.add(UM_Help);

        setJMenuBar(UpperMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UM_Help_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UM_Help_AboutActionPerformed
        JOptionPane.showMessageDialog(jTextArea1, "JPad by FktM\nVersion " + version + "\nA simple and lightweight java based text editor.", "About JPad", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_UM_Help_AboutActionPerformed

    private void UM_File_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UM_File_NewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UM_File_NewActionPerformed

    private void UM_File_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UM_File_OpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UM_File_OpenActionPerformed

    private void UM_File_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UM_File_SaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UM_File_SaveActionPerformed

    private void UM_File_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UM_File_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_UM_File_ExitActionPerformed

    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Darcula".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu UM_File;
    private javax.swing.JMenuItem UM_File_Exit;
    private javax.swing.JMenuItem UM_File_New;
    private javax.swing.JMenuItem UM_File_Open;
    private javax.swing.JMenuItem UM_File_Save;
    private javax.swing.JMenu UM_Help;
    private javax.swing.JMenuItem UM_Help_About;
    private javax.swing.JMenuBar UpperMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
