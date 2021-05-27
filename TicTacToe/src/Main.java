
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.util.Arrays;

// Tic Tac Toe Java Game by FktM

public class Main extends javax.swing.JFrame {

    // Variable Declaration
     String version = "R1";
     int roundnumber = 0, Xwins = 0, Owins = 0;
     boolean Xturn = true, useAI = false;
     String[] board = {"ZERO",
                             "N", "N", "N", 
                             "N", "N", "N", 
                             "N", "N", "N"
    };
    
     AI ai = new AI();
    
    public java.awt.Color jfxC2awtC(Color c) {
        java.awt.Color awtColor = new java.awt.Color((float) c.getRed(),
                                             (float) c.getGreen(),
                                             (float) c.getBlue());          
        return awtColor;
    }
    
    
    public void UpdateStatus() {if (Xturn) {g_status.setText("X's Turn!");} else {g_status.setText("O's Turn!");}}
    
    public void CheckWin() {
        boolean WonAlready = false;
        boolean StillEmpty = false;
        for (String i : board) {if (i == "N") {StillEmpty = true;}}
        
        // H LINES
        if (ctv(board[1], board[2], board[3])) {WonAlready = true; WinCondition(board[1].equals("X")); g_b_1.setForeground(Color.GREEN); g_b_2.setForeground(Color.GREEN); g_b_3.setForeground(Color.GREEN);}
        if (ctv(board[4], board[5], board[6])) {WonAlready = true; WinCondition(board[4].equals("X")); g_b_4.setForeground(Color.GREEN); g_b_5.setForeground(Color.GREEN); g_b_6.setForeground(Color.GREEN);}
        if (ctv(board[7], board[8], board[9])) {WonAlready = true; WinCondition(board[7].equals("X")); g_b_7.setForeground(Color.GREEN); g_b_8.setForeground(Color.GREEN); g_b_9.setForeground(Color.GREEN);}
        
        // V LINES
        if (ctv(board[1], board[4], board[7])) {WonAlready = true; WinCondition(board[1].equals("X")); g_b_1.setForeground(Color.GREEN); g_b_4.setForeground(Color.GREEN); g_b_7.setForeground(Color.GREEN);}
        if (ctv(board[2], board[5], board[8])) {WonAlready = true; WinCondition(board[2].equals("X")); g_b_2.setForeground(Color.GREEN); g_b_5.setForeground(Color.GREEN); g_b_8.setForeground(Color.GREEN);}
        if (ctv(board[3], board[6], board[9])) {WonAlready = true; WinCondition(board[3].equals("X")); g_b_3.setForeground(Color.GREEN); g_b_6.setForeground(Color.GREEN); g_b_9.setForeground(Color.GREEN);}
        
        // D LINES
        if (ctv(board[1], board[5], board[9])) {WonAlready = true; WinCondition(board[1].equals("X")); g_b_1.setForeground(Color.GREEN); g_b_5.setForeground(Color.GREEN); g_b_9.setForeground(Color.GREEN);}
        if (ctv(board[3], board[5], board[7])) {WonAlready = true; WinCondition(board[3].equals("X")); g_b_3.setForeground(Color.GREEN); g_b_5.setForeground(Color.GREEN); g_b_7.setForeground(Color.GREEN);}
        
        if (!StillEmpty && !WonAlready) {TieCondition();}
        
    }
    
    public void timeout(int seconds) {
        try {Thread.sleep(seconds*1000);} 
        catch (InterruptedException ex) {Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
    }
    public void reset(boolean full) {
    if (full) {roundnumber = 0; Xwins = 0; Owins = 0; Xturn = true;}
    Arrays.fill(board, "N");
    board[0] = "ZERO";
    
    if (Xturn) {g_status.setText("X's Turn!");} else {g_status.setText("O's Turn!");}
    g_wins_x.setText("X's Score: " + Xwins); g_wins_o.setText("O's Score: " + Owins);
        g_b_1.setText("[_]"); g_b_2.setText("[_]"); g_b_3.setText("[_]");
        g_b_4.setText("[_]"); g_b_5.setText("[_]"); g_b_6.setText("[_]");
        g_b_7.setText("[_]"); g_b_8.setText("[_]"); g_b_9.setText("[_]");
        
        g_b_1.setEnabled(true); g_b_2.setEnabled(true); g_b_3.setEnabled(true);
        g_b_4.setEnabled(true); g_b_5.setEnabled(true); g_b_6.setEnabled(true);
        g_b_7.setEnabled(true); g_b_8.setEnabled(true); g_b_9.setEnabled(true);
        
        g_b_1.setForeground(Color.GRAY); g_b_2.setForeground(Color.GRAY); g_b_3.setForeground(Color.GRAY);
        g_b_4.setForeground(Color.GRAY); g_b_5.setForeground(Color.GRAY); g_b_6.setForeground(Color.GRAY);
        g_b_7.setForeground(Color.GRAY); g_b_8.setForeground(Color.GRAY); g_b_9.setForeground(Color.GRAY);
        
        g_nextround.setEnabled(false);
    }
    public boolean ctv(String val1, String val2, String val3) {
        if (val1.equals("N") || val2.equals("N") || val3.equals("N")) {return false;}
        if (val1.equals(val2) && val2.equals(val3)) {return true;} else {return false;}
    }
    
    
    public void WinCondition(boolean Xwin) {
        if (Xwin) {g_status.setText("X Wins!"); Xwins++;} else {g_status.setText("O Wins!"); Owins++;}
        g_b_1.setEnabled(false); g_b_2.setEnabled(false); g_b_3.setEnabled(false);
        g_b_4.setEnabled(false); g_b_5.setEnabled(false); g_b_6.setEnabled(false);
        g_b_7.setEnabled(false); g_b_8.setEnabled(false); g_b_9.setEnabled(false);
        
        roundnumber++;
        g_wins_x.setText("X's Score: " + Xwins);
        g_wins_o.setText("O's Score: " + Owins);
        
        g_nextround.setEnabled(true);
    }
    
    public void TieCondition() {
        g_status.setText("It's a Tie!");
        
        g_b_1.setEnabled(false); g_b_2.setEnabled(false); g_b_3.setEnabled(false);
        g_b_4.setEnabled(false); g_b_5.setEnabled(false); g_b_6.setEnabled(false);
        g_b_7.setEnabled(false); g_b_8.setEnabled(false); g_b_9.setEnabled(false);
        
        roundnumber++;
        g_wins_x.setText("X's Score: " + Xwins);
        g_wins_o.setText("O's Score: " + Owins);
        
        g_nextround.setEnabled(true);
        
    }
    
    /*
    public AI StartAI() {
        AI ai = new AI();
        useAI = true;
        return ai;
    }
    
     @SuppressWarnings("FinalizeCalledExplicitly")
    public void StopAI() {
         try {
             StartAI().finalize();
         } catch (Throwable ex) {
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }
        useAI = false;
    }
    */
    
    public void AIController() {
        timeout(1);
        int moveto = ai.Move();
        board[moveto] = "O";
        switch (moveto) {
            case 1:
                g_b_1.setText("[O]");
                break;
            case 2:
                g_b_2.setText("[O]");
                break;
            case 3:
                g_b_3.setText("[O]");
                break;
            case 4:
                g_b_4.setText("[O]");
                break;
            case 5:
                g_b_5.setText("[O]");
                break;
            case 6:
                g_b_6.setText("[O]");
                break;
            case 7:
                g_b_7.setText("[O]");
                break;
            case 8:
                g_b_8.setText("[O]");
                break;
            case 9:
                g_b_9.setText("[O]");
                break;
            
        }
    }
    
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        g_title = new javax.swing.JLabel();
        g_version = new javax.swing.JLabel();
        g_status = new javax.swing.JLabel();
        g_b_1 = new javax.swing.JButton();
        g_b_2 = new javax.swing.JButton();
        g_b_3 = new javax.swing.JButton();
        g_b_4 = new javax.swing.JButton();
        g_b_5 = new javax.swing.JButton();
        g_b_6 = new javax.swing.JButton();
        g_b_7 = new javax.swing.JButton();
        g_b_8 = new javax.swing.JButton();
        g_b_9 = new javax.swing.JButton();
        g_wins_x = new javax.swing.JLabel();
        g_wins_o = new javax.swing.JLabel();
        g_nextround = new javax.swing.JButton();
        g_menu = new javax.swing.JMenuBar();
        g_menu_game = new javax.swing.JMenu();
        g_menu_game_new = new javax.swing.JMenuItem();
        g_menu_game_exit = new javax.swing.JMenuItem();
        g_menu_settings = new javax.swing.JMenu();
        g_menu_settings_useai = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe by FktM, v." + version);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);

        g_title.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_title.setText("Tic Tac Toe");

        g_version.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        g_version.setText("by FktM, v.XX");

        g_status.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        g_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g_status.setText("STATUS_MESSAGE");

        g_b_1.setBackground(java.awt.Color.lightGray);
        g_b_1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_1.setForeground(java.awt.Color.gray);
        g_b_1.setText("[1]");
        g_b_1.setEnabled(false);
        g_b_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_1ActionPerformed(evt);
            }
        });

        g_b_2.setBackground(java.awt.Color.lightGray);
        g_b_2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_2.setForeground(java.awt.Color.gray);
        g_b_2.setText("[2]");
        g_b_2.setEnabled(false);
        g_b_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_2ActionPerformed(evt);
            }
        });

        g_b_3.setBackground(java.awt.Color.lightGray);
        g_b_3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_3.setForeground(java.awt.Color.gray);
        g_b_3.setText("[3]");
        g_b_3.setEnabled(false);
        g_b_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_3ActionPerformed(evt);
            }
        });

        g_b_4.setBackground(java.awt.Color.lightGray);
        g_b_4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_4.setForeground(java.awt.Color.gray);
        g_b_4.setText("[4]");
        g_b_4.setEnabled(false);
        g_b_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_4ActionPerformed(evt);
            }
        });

        g_b_5.setBackground(java.awt.Color.lightGray);
        g_b_5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_5.setForeground(java.awt.Color.gray);
        g_b_5.setText("[5]");
        g_b_5.setEnabled(false);
        g_b_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_5ActionPerformed(evt);
            }
        });

        g_b_6.setBackground(java.awt.Color.lightGray);
        g_b_6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_6.setForeground(java.awt.Color.gray);
        g_b_6.setText("[6]");
        g_b_6.setEnabled(false);
        g_b_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_6ActionPerformed(evt);
            }
        });

        g_b_7.setBackground(java.awt.Color.lightGray);
        g_b_7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_7.setForeground(java.awt.Color.gray);
        g_b_7.setText("[7]");
        g_b_7.setEnabled(false);
        g_b_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_7ActionPerformed(evt);
            }
        });

        g_b_8.setBackground(java.awt.Color.lightGray);
        g_b_8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_8.setForeground(java.awt.Color.gray);
        g_b_8.setText("[8]");
        g_b_8.setEnabled(false);
        g_b_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_8ActionPerformed(evt);
            }
        });

        g_b_9.setBackground(java.awt.Color.lightGray);
        g_b_9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        g_b_9.setForeground(java.awt.Color.gray);
        g_b_9.setText("[9]");
        g_b_9.setEnabled(false);
        g_b_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_b_9ActionPerformed(evt);
            }
        });

        g_wins_x.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g_wins_x.setText("X's Score: XX");

        g_wins_o.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        g_wins_o.setText("O's Score: XX");

        g_nextround.setText("Next Round");
        g_nextround.setEnabled(false);
        g_nextround.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_nextroundActionPerformed(evt);
            }
        });

        g_menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        g_menu_game.setText("Game");

        g_menu_game_new.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        g_menu_game_new.setText("New Game");
        g_menu_game_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_menu_game_newActionPerformed(evt);
            }
        });
        g_menu_game.add(g_menu_game_new);

        g_menu_game_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        g_menu_game_exit.setText("Exit Game");
        g_menu_game_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_menu_game_exitActionPerformed(evt);
            }
        });
        g_menu_game.add(g_menu_game_exit);

        g_menu.add(g_menu_game);

        g_menu_settings.setText("Settings");

        g_menu_settings_useai.setText("Use AI");
        g_menu_settings_useai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_menu_settings_useaiActionPerformed(evt);
            }
        });
        g_menu_settings.add(g_menu_settings_useai);

        g_menu.add(g_menu_settings);

        setJMenuBar(g_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(g_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(g_title)
                                .addGap(189, 189, 189))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(g_version, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(g_b_4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g_b_5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g_b_6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(g_b_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g_b_2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g_b_3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(g_b_7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g_b_8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g_b_9)))
                                .addGap(179, 179, 179))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(g_wins_x, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(g_wins_o, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(g_nextround)
                .addGap(248, 248, 248))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(g_title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(g_version)
                .addGap(101, 101, 101)
                .addComponent(g_status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g_b_3)
                    .addComponent(g_b_2)
                    .addComponent(g_b_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g_b_4)
                    .addComponent(g_b_5)
                    .addComponent(g_b_6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g_b_7)
                    .addComponent(g_b_8)
                    .addComponent(g_b_9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g_wins_x)
                    .addComponent(g_wins_o))
                .addGap(18, 18, 18)
                .addComponent(g_nextround)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        g_version.setText("by FktM, v." + version);
        g_status.setText("Press F1 to start a new game.");
        g_wins_x.setText("X's Score: " + Xwins);
        g_wins_o.setText("O's Score: " + Owins);
        g_b_1.setText("[_]");
        g_b_2.setText("[_]");
        g_b_3.setText("[_]");
        g_b_4.setText("[_]");
        g_b_5.setText("[_]");
        g_b_6.setText("[_]");
        g_b_7.setText("[_]");
        g_b_8.setText("[_]");
        g_b_9.setText("[_]");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void g_b_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_3ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[3] = "X"; g_b_3.setText("[X]");} else if (!useAI && !Xturn) {board[3] = "O"; g_b_3.setText("[O]");}
        g_b_3.setEnabled(false);
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_3ActionPerformed

    private void g_menu_game_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_menu_game_newActionPerformed
    reset(true);
    }//GEN-LAST:event_g_menu_game_newActionPerformed

    private void g_b_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_2ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[2] = "X"; g_b_2.setText("[X]");} else if (!useAI && !Xturn) {board[2] = "O"; g_b_2.setText("[O]");}
        g_b_2.setEnabled(false);
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_2ActionPerformed

    private void g_b_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_1ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[1] = "X"; g_b_1.setText("[X]");} else if (!useAI && !Xturn) {board[1] = "O"; g_b_1.setText("[O]");}
        g_b_1.setEnabled(false);
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_1ActionPerformed

    private void g_b_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_4ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[4] = "X"; g_b_4.setText("[X]");} else if (!useAI && !Xturn) {board[4] = "O"; g_b_4.setText("[O]");}
        g_b_4.setEnabled(false); 
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_4ActionPerformed

    private void g_b_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_5ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[5] = "X"; g_b_5.setText("[X]");} else if (!useAI && !Xturn) {board[5] = "O"; g_b_5.setText("[O]");}
        g_b_5.setEnabled(false); 
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_5ActionPerformed

    private void g_b_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_6ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[6] = "X"; g_b_6.setText("[X]");} else if (!useAI && !Xturn) {board[6] = "O"; g_b_6.setText("[O]");}
        g_b_6.setEnabled(false); 
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_6ActionPerformed

    private void g_b_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_7ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[7] = "X"; g_b_7.setText("[X]");} else if (!useAI && !Xturn) {board[7] = "O"; g_b_7.setText("[O]");}
        g_b_7.setEnabled(false); 
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_7ActionPerformed

    private void g_b_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_8ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[8] = "X"; g_b_8.setText("[X]");} else if (!useAI && !Xturn) {board[8] = "O"; g_b_8.setText("[O]");}
        g_b_8.setEnabled(false); 
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_8ActionPerformed

    private void g_b_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_b_9ActionPerformed
        if (useAI && !Xturn) {AIController();}
        else if (Xturn) {board[9] = "X"; g_b_9.setText("[X]");} else if (!useAI && !Xturn) {board[9] = "O"; g_b_9.setText("[O]");}
        g_b_9.setEnabled(false); 
        Xturn = !Xturn;
        UpdateStatus();
        CheckWin();
    }//GEN-LAST:event_g_b_9ActionPerformed

    private void g_menu_game_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_menu_game_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_g_menu_game_exitActionPerformed

    private void g_nextroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_nextroundActionPerformed
        reset(false);
        if (!Xturn && useAI) {
            // AI TURN
            
        }
    }//GEN-LAST:event_g_nextroundActionPerformed

    private void g_menu_settings_useaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_menu_settings_useaiActionPerformed
        g_status.setText("Press F1 to start a new game.");
        
        g_b_1.setEnabled(false); g_b_2.setEnabled(false); g_b_3.setEnabled(false);
        g_b_4.setEnabled(false); g_b_5.setEnabled(false); g_b_6.setEnabled(false);
        g_b_7.setEnabled(false); g_b_8.setEnabled(false); g_b_9.setEnabled(false);
        
        useAI = !useAI;
    }//GEN-LAST:event_g_menu_settings_useaiActionPerformed


    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton g_b_1;
    private javax.swing.JButton g_b_2;
    private javax.swing.JButton g_b_3;
    private javax.swing.JButton g_b_4;
    private javax.swing.JButton g_b_5;
    private javax.swing.JButton g_b_6;
    private javax.swing.JButton g_b_7;
    private javax.swing.JButton g_b_8;
    private javax.swing.JButton g_b_9;
    private javax.swing.JMenuBar g_menu;
    private javax.swing.JMenu g_menu_game;
    private javax.swing.JMenuItem g_menu_game_exit;
    private javax.swing.JMenuItem g_menu_game_new;
    private javax.swing.JMenu g_menu_settings;
    private javax.swing.JCheckBoxMenuItem g_menu_settings_useai;
    private javax.swing.JButton g_nextround;
    private javax.swing.JLabel g_status;
    private javax.swing.JLabel g_title;
    private javax.swing.JLabel g_version;
    private javax.swing.JLabel g_wins_o;
    private javax.swing.JLabel g_wins_x;
    // End of variables declaration//GEN-END:variables
}
