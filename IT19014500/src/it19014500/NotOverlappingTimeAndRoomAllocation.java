/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it19014500;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author it19014500
 */
public class NotOverlappingTimeAndRoomAllocation extends javax.swing.JFrame {

    /**
     * Creates new form NotOverlappingTimeAndRoomAllocation
     */
    public NotOverlappingTimeAndRoomAllocation() {
        initComponents();
        show_NoverLapping();
    }


    //Table
        public ArrayList<nOverlapping> noOverList(){
        ArrayList<nOverlapping> noOverList = new ArrayList<>();
          try{
            
    
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String lquery = "select * from notoverlappingtimeallo";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(lquery);
            
            nOverlapping nol;
            while(rs.next()){
                nol = new nOverlapping(rs.getInt("noId"),rs.getInt("rid"),rs.getString("room"),rs.getString("day"),rs.getString("session"),rs.getString("sTime"),rs.getString("sam"),rs.getString("eTime"),rs.getString("eam"),rs.getInt("tid"),rs.getInt("session2"));
                noOverList.add(nol);
            }
            
          }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          return noOverList;
    }
        
    public void show_NoverLapping(){
        ArrayList<nOverlapping> list2 = noOverList();
        DefaultTableModel model2 = (DefaultTableModel)UniqueAllocaionTable.getModel();
        Object[] row2 = new Object[11];
        
        for(int i =0; i<list2.size(); i++){
            row2[0] = list2.get(i).getnoId();
            row2[1] = list2.get(i).getrid();
            row2[2] = list2.get(i).getroom1();
            row2[3] = list2.get(i).getday1();
            row2[4] = list2.get(i).getsession1();
            row2[5] = list2.get(i).getsTime1();
            row2[6] = list2.get(i).getSam();
            row2[7] = list2.get(i).geteTime1();
            row2[8] = list2.get(i).getEam();
            row2[9] = list2.get(i).getTid();
            row2[10] = list2.get(i).getsession2();
            model2.addRow(row2);
        
        }
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UniqueAllocaionTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        noidLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ridLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        roomLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dayLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sessionLbl = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sTimeLbl = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        eTimeLbl = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        taId5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        samCom = new javax.swing.JComboBox<>();
        eamCom = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ses2Lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 250, 222));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(3, 48, 118));
        jLabel1.setText("NOT OVERLAPPING TIME ALLOCATION");

        jPanel3.setBackground(new java.awt.Color(176, 223, 236));

        jToggleButton1.setText("Consecutive");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Parellel");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(102, 255, 102));
        jToggleButton3.setText("Non Overlapping");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Not Available Times");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jButton4.setText("Dash Board");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(212, 233, 221));

        UniqueAllocaionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No ID", "RID", "ROOM", "DAY", "Category", "START TIME", "S. a.m./p.m.", "END TIME", "E. a.m./p.m.", "T.A.ID", "Session ID"
            }
        ));
        UniqueAllocaionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UniqueAllocaionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UniqueAllocaionTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 78, 99));
        jLabel2.setText("Unique Allocation");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 78, 99));
        jLabel3.setText("NO ID");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 78, 99));
        jLabel5.setText("RID");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 78, 99));
        jLabel7.setText("ROOM");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 78, 99));
        jLabel9.setText("DAY");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 78, 99));
        jLabel11.setText("CATEGORY");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 78, 99));
        jLabel13.setText("START TIME");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 78, 99));
        jLabel15.setText("END TIME");

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 78, 99));
        jLabel4.setText("T.A. ID");

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        samCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A.M.", "P.M." }));

        eamCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A.M.", "P.M." }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 78, 99));
        jLabel6.setText("SESSION ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(261, 261, 261))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomLbl)
                    .addComponent(ridLbl)
                    .addComponent(dayLbl)
                    .addComponent(noidLbl))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eTimeLbl)
                            .addComponent(sTimeLbl)
                            .addComponent(sessionLbl))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jLabel4)
                                        .addGap(44, 44, 44)
                                        .addComponent(taId5)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eamCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(samCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ses2Lbl))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton6)
                        .addGap(68, 68, 68)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(noidLbl)
                            .addComponent(jLabel11)
                            .addComponent(sessionLbl)
                            .addComponent(taId5)
                            .addComponent(jLabel4))
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ridLbl)
                            .addComponent(jLabel13)
                            .addComponent(sTimeLbl)
                            .addComponent(samCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(roomLbl)
                                    .addComponent(jLabel15)
                                    .addComponent(eTimeLbl)
                                    .addComponent(eamCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(dayLbl)
                    .addComponent(jLabel6)
                    .addComponent(ses2Lbl))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton2)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Dash Board:
        if(evt.getActionCommand().equals("Dash Board")){
            System.out.println("Return Dash Board");
        }
        close();
        Member3_Dash_Board wd = new Member3_Dash_Board();
        wd.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Remove Button:
        try{

            //apache Connection
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "insert into addLocation(room,day,session,sTime,samt,eTime,eamt,tid,session2)values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = c.prepareStatement(sql);

            String sam1 = "";
            String eam1 = "";
            
            pstmt.setString(1, roomLbl.getText());
            pstmt.setString(2, dayLbl.getText());
            pstmt.setString(3, sessionLbl.getText());
            pstmt.setString(4, sTimeLbl.getText());
            
            sam1 = samCom.getSelectedItem().toString();
            pstmt.setString(5, sam1);
            
            pstmt.setString(6, eTimeLbl.getText());
            
            eam1 = eamCom.getSelectedItem().toString();
            pstmt.setString(7, eam1);
            
            pstmt.setString(8, taId5.getText());
            
            pstmt.setInt(9, Integer.valueOf(ses2Lbl.getText()));


            pstmt.executeUpdate();
            //            JOptionPane.showMessageDialog(null, "Remove from Parellel Section Successfully!");

            //deleting ovrlap

            try{

                Connection j = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
                int row4 = UniqueAllocaionTable.getSelectedRow();
                String value3 = (UniqueAllocaionTable.getModel().getValueAt(row4, 0).toString());
                String drqery2 = "DELETE from notoverlappingtimeallo where noId="+value3;
                PreparedStatement pstt = j.prepareStatement(drqery2);
                pstt.executeUpdate();
                DefaultTableModel model3 = (DefaultTableModel)UniqueAllocaionTable.getModel();
                model3.setRowCount(0);
                show_NoverLapping();
                noidLbl.setText("");
                ridLbl.setText("");
                roomLbl.setText("");
                dayLbl.setText("");
                sessionLbl.setText("");
                sTimeLbl.setText("");
                eTimeLbl.setText("");
                taId5.setText("");
                eamCom.setSelectedIndex(0);
                samCom.setSelectedIndex(0);
                ses2Lbl.setText("");
                

                JOptionPane.showMessageDialog(null, "Passed to Parellel Section!");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

            //deleting overlap over

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Back Button to Reserved Room:
        if(evt.getActionCommand().equals("Dash Board")){
            System.out.println("Return Dash Board");
        }
        close();
        ReservedRooms wd = new ReservedRooms();
        wd.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void UniqueAllocaionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UniqueAllocaionTableMouseClicked
        // Mouse Click Event:
        int ir = UniqueAllocaionTable.getSelectedRow();
        TableModel model2 = UniqueAllocaionTable.getModel();

        String idno = model2.getValueAt(ir, 0).toString();
        noidLbl.setText(idno);

        String idri = model2.getValueAt(ir, 1).toString();
        ridLbl.setText(idri);

        String room2 = model2.getValueAt(ir, 2).toString();
        roomLbl.setText(room2);

        String dayl = model2.getValueAt(ir, 3).toString();
        dayLbl.setText(dayl);

        String session5 = model2.getValueAt(ir, 4).toString();
        sessionLbl.setText(session5);

        String sTime5 = model2.getValueAt(ir, 5).toString();
        sTimeLbl.setText(sTime5);
        
        String saam = model2.getValueAt(ir, 6).toString();
        switch(saam){
            case "":
                samCom.setSelectedIndex(0);
                break;
            case "A.M.":
                samCom.setSelectedIndex(0);
                break;
            case "P.M.":
                samCom.setSelectedIndex(1);
                break;  
        }

        String eTime5 = model2.getValueAt(ir, 7).toString();
        eTimeLbl.setText(eTime5);
        
        String eaam = model2.getValueAt(ir, 8).toString();
        switch(eaam){
            case "":
                eamCom.setSelectedIndex(0);
                break;
            case "A.M.":
                eamCom.setSelectedIndex(0);
                break;
            case "P.M.":
                eamCom.setSelectedIndex(1);
                break;  
        }

        String TAiD5 = model2.getValueAt(ir, 9).toString();
        taId5.setText(TAiD5);
        
        ses2Lbl.setText(model2.getValueAt(ir, 10).toString());
    }//GEN-LAST:event_UniqueAllocaionTableMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Reset Button:
        noidLbl.setText("");
        ridLbl.setText("");
        roomLbl.setText("");
        dayLbl.setText("");
        sessionLbl.setText("");
        sTimeLbl.setText("");
        eTimeLbl.setText("");
        taId5.setText("");
        eamCom.setSelectedIndex(0);
        samCom.setSelectedIndex(0);
        ses2Lbl.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Refresh Button:
        DefaultTableModel model2 = (DefaultTableModel)UniqueAllocaionTable.getModel();
        model2.setRowCount(0);
        show_NoverLapping();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        //        Consecutive Button
        if(evt.getActionCommand().equals("")){
            System.out.println("");
        }
        close();
        consecutiveTimesAllocation wd = new consecutiveTimesAllocation();
        wd.setVisible(true);    
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
                // Parelll Button:
        if(evt.getActionCommand().equals("Dash Board")){
            System.out.println("Return Dash Board");
        }
        close();
        ReservedRooms wd = new ReservedRooms();
        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
//                // Non Overlapping:
//        if(evt.getActionCommand().equals("Dash Board")){
//            System.out.println("Return Dash Board");
//        }
//        close();
//        NotOverlappingTimeAndRoomAllocation wd = new NotOverlappingTimeAndRoomAllocation();
//        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
                // Not Available Button:
        if(evt.getActionCommand().equals("")){
            System.out.println("");
        }
        close();
        sessionAndNotAvailableTime wd = new sessionAndNotAvailableTime();
        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(NotOverlappingTimeAndRoomAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotOverlappingTimeAndRoomAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotOverlappingTimeAndRoomAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotOverlappingTimeAndRoomAllocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotOverlappingTimeAndRoomAllocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable UniqueAllocaionTable;
    private javax.swing.JLabel dayLbl;
    private javax.swing.JLabel eTimeLbl;
    private javax.swing.JComboBox<String> eamCom;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JLabel noidLbl;
    private javax.swing.JLabel ridLbl;
    private javax.swing.JLabel roomLbl;
    private javax.swing.JLabel sTimeLbl;
    private javax.swing.JComboBox<String> samCom;
    private javax.swing.JLabel ses2Lbl;
    private javax.swing.JLabel sessionLbl;
    private javax.swing.JLabel taId5;
    // End of variables declaration//GEN-END:variables
}
