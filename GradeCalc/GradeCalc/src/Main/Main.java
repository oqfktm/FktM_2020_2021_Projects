// Final Grade Calculator by FktM
package Main;

// Imports
import java.util.ArrayList;

public class Main extends javax.swing.JFrame {

    // Variable Declaration
        static String version = "Rel. [R1]";  // Version: Release R
        static int fin = 0;
        ArrayList<String> read = new ArrayList<String>();
        static float avg = 0, weightval = 0, fullavg = 0;
        ArrayList<Float> calc = new ArrayList<Float>();
        static String listString = "";
        ArrayList<Float> fullweight = new ArrayList<Float>();
        
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        GUI_WeightSlider = new javax.swing.JSlider();
        weightval = 1;
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        GUI_Button_1 = new javax.swing.JButton();
        GUI_Button_3 = new javax.swing.JButton();
        GUI_Button_2 = new javax.swing.JButton();
        GUI_Button_4 = new javax.swing.JButton();
        GUI_Button_5 = new javax.swing.JButton();
        GUI_Button_Backspace = new javax.swing.JButton();
        GUI_Button_Calculate = new javax.swing.JButton();
        GUI_Result = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GUI_FullArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        GUI_Reset = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        GUI_Version = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GradeCalc " + version);
        setResizable(false);

        GUI_WeightSlider.setMajorTickSpacing(25);
        GUI_WeightSlider.setPaintTicks(true);
        GUI_WeightSlider.setSnapToTicks(true);
        GUI_WeightSlider.setToolTipText("");
        GUI_WeightSlider.setValue(25);
        GUI_WeightSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GUI_WeightSlider.setName("Weight Slider"); // NOI18N
        GUI_WeightSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GUI_WeightSliderStateChanged(evt);
            }
        });

        jLabel1.setText("0,5");

        jLabel2.setText("1");

        jLabel3.setText("1,5");

        jLabel4.setText("2");

        jLabel5.setText("3");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setText("GradeCalc");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Weight");

        GUI_Button_1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Button_1.setText("1");
        GUI_Button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Button_1ActionPerformed(evt);
            }
        });

        GUI_Button_3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Button_3.setText("3");
        GUI_Button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Button_3ActionPerformed(evt);
            }
        });

        GUI_Button_2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Button_2.setText("2");
        GUI_Button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Button_2ActionPerformed(evt);
            }
        });

        GUI_Button_4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Button_4.setText("4");
        GUI_Button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Button_4ActionPerformed(evt);
            }
        });

        GUI_Button_5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Button_5.setText("5");
        GUI_Button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Button_5ActionPerformed(evt);
            }
        });

        GUI_Button_Backspace.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Button_Backspace.setText("<-");
        GUI_Button_Backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Button_BackspaceActionPerformed(evt);
            }
        });

        GUI_Button_Calculate.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Button_Calculate.setText("=");
        GUI_Button_Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Button_CalculateActionPerformed(evt);
            }
        });

        GUI_Result.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GUI_Result.setText("0 (0)");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setText("Result:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GUI_FullArea.setEditable(false);
        GUI_FullArea.setColumns(20);
        GUI_FullArea.setLineWrap(true);
        GUI_FullArea.setRows(6);
        GUI_FullArea.setToolTipText("");
        GUI_FullArea.setWrapStyleWord(true);
        GUI_FullArea.setName(""); // NOI18N
        jScrollPane2.setViewportView(GUI_FullArea);

        jLabel8.setText("FktM");

        GUI_Reset.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GUI_Reset.setText("RESET");
        GUI_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_ResetActionPerformed(evt);
            }
        });

        jLabel10.setText("Grade Buttons");

        jLabel11.setText("Breakdown");

        GUI_Version.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(GUI_WeightSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(268, 268, 268)
                            .addComponent(jLabel7))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(200, 200, 200)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(GUI_Button_1)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(GUI_Button_2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(GUI_Button_3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(GUI_Button_4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel2)
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel3)
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel4)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(GUI_Button_5)
                                    .addGap(38, 38, 38)
                                    .addComponent(GUI_Button_Backspace))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addComponent(GUI_Button_Calculate))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(GUI_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(219, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GUI_Version, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GUI_Reset)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GUI_Version)))
                .addGap(92, 92, 92)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(GUI_WeightSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GUI_Button_1)
                        .addComponent(GUI_Button_3)
                        .addComponent(GUI_Button_2)
                        .addComponent(GUI_Button_4)
                        .addComponent(GUI_Button_5)
                        .addComponent(GUI_Button_Backspace)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GUI_Button_Calculate)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GUI_Result)
                            .addComponent(jLabel9))
                        .addGap(72, 72, 72)
                        .addComponent(GUI_Reset)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GUI_Version.setText(version);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void GUI_Button_BackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Button_BackspaceActionPerformed
        // Backspace Logic
        if (read.size() == 0 || calc.size() == 0 || fullweight.size() == 0) {} else {
        
        read.remove(read.size()-1);
        calc.remove(calc.size()-1);
        fullweight.remove(fullweight.size()-1);
        
        listString = "";
        for (String s : read) {listString += s + ", ";}
        GUI_FullArea.setText(listString);
        GUI_Result.setText("0 (0)");
        }
        
    }//GEN-LAST:event_GUI_Button_BackspaceActionPerformed

    private void GUI_Button_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Button_5ActionPerformed
        calc.add(5*weightval);
        read.add("5(" + weightval + ")");
        fullweight.add(weightval);
        
        listString = "";
        for (String s : read) {listString += s + ", ";}
        GUI_FullArea.setText(listString);
    }//GEN-LAST:event_GUI_Button_5ActionPerformed

    private void GUI_Button_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Button_1ActionPerformed
        calc.add(1*weightval);
        read.add("1(" + weightval + ")");
        fullweight.add(weightval);
        
        listString = "";
        for (String s : read) {listString += s + ", ";}
        GUI_FullArea.setText(listString);
        
    }//GEN-LAST:event_GUI_Button_1ActionPerformed

    private void GUI_Button_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Button_2ActionPerformed
        calc.add(2*weightval);
        read.add("2(" + weightval + ")");
        fullweight.add(weightval);
        
        listString = "";
        for (String s : read) {listString += s + ", ";}
        GUI_FullArea.setText(listString);
    }//GEN-LAST:event_GUI_Button_2ActionPerformed

    private void GUI_Button_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Button_3ActionPerformed
        calc.add(3*weightval);
        read.add("3(" + weightval + ")");
        fullweight.add(weightval);
        
        listString = "";
        for (String s : read) {listString += s + ", ";}
        GUI_FullArea.setText(listString);
    }//GEN-LAST:event_GUI_Button_3ActionPerformed

    private void GUI_Button_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Button_4ActionPerformed
        calc.add(4*weightval);
        read.add("4(" + weightval + ")");
        fullweight.add(weightval);
        
        listString = "";
        for (String s : read) {listString += s + ", ";}
        GUI_FullArea.setText(listString);
    }//GEN-LAST:event_GUI_Button_4ActionPerformed

    private void GUI_Button_CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Button_CalculateActionPerformed
        // Calculate Logic
        if (read.size() == 0 || calc.size() == 0 || fullweight.size() == 0) {} else {
            
        avg = 0;
        for (float temp : calc) {
            avg += temp;
            temp = 0;
        }
        
        for (int i=0; i<fullweight.size(); i++) {fullavg += fullweight.get(i);}
        
        avg /= fullavg;
        fin = Math.round(avg);
        GUI_Result.setText(fin + " (" + avg + ")");
        
        System.out.println(read);
        System.out.println(calc);
        System.out.println(fullweight);
        
        }
    }//GEN-LAST:event_GUI_Button_CalculateActionPerformed

    private void GUI_WeightSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GUI_WeightSliderStateChanged
        // Slider Logic
        switch(GUI_WeightSlider.getValue()) {
            case 0: 
                weightval = 0.5f;
                break;
            case 25:
                weightval = 1;
                break;
            case 50:
                weightval = 1.5f;
                break;
            case 75:
                weightval = 2;
                break;
            case 100:
                weightval = 3;
                break;
            default:
        }
    }//GEN-LAST:event_GUI_WeightSliderStateChanged

    private void GUI_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_ResetActionPerformed
        // Reset Logic
        calc.clear();
        read.clear();
        fullweight.clear();
        GUI_FullArea.setText("");
        GUI_Result.setText("0 (0)");
        avg = 0;
    }//GEN-LAST:event_GUI_ResetActionPerformed

    
    
    public static void main(String args[]) {
        
        

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
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
            @Override
            public void run() {
                new Main().setVisible(true);
            }
            
                    
        
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GUI_Button_1;
    private javax.swing.JButton GUI_Button_2;
    private javax.swing.JButton GUI_Button_3;
    private javax.swing.JButton GUI_Button_4;
    private javax.swing.JButton GUI_Button_5;
    private javax.swing.JButton GUI_Button_Backspace;
    private javax.swing.JButton GUI_Button_Calculate;
    private javax.swing.JTextArea GUI_FullArea;
    private javax.swing.JButton GUI_Reset;
    private javax.swing.JLabel GUI_Result;
    private javax.swing.JLabel GUI_Version;
    private javax.swing.JSlider GUI_WeightSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
