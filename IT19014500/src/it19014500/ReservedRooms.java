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
public class ReservedRooms extends javax.swing.JFrame {

    /**
     * Creates new form ReservedRooms
     */
    Integer TaId2 = 0;
    
    public ReservedRooms() {
        initComponents();
        show_Location();
        roomCombo();
        allocationComboIdPart();
        allocatesidCombo2();
        
    }
    
//    sidCombo2
    
    private void allocatesidCombo2(){
        try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from session";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                
                String wd1 = rs.getString("id");
                sidCombo2.addItem(wd1);
                
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    private void allocationComboIdPart(){
        try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from workingdayshours";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                
                String wd1 = rs.getString("id");
                timeAllocation2.addItem(wd1);
                
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void roomCombo(){
        try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from location";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                String name = rs.getString("room_name");
                addRoom1.addItem(name);
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void roomDay(){
        try
        {
            
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from days where idwd='"+TaId2+"'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                String day1 = rs.getString("workingDay");
                addDay1.addItem(day1);  
            }
                  
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    public ArrayList<location1> locationList(){
        ArrayList<location1> locationList = new ArrayList<>();
          try{
            
    
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String lquery = "select * from addLocation";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(lquery);
            
            location1 locate;
            while(rs.next()){
                locate = new location1(rs.getInt("lId"),rs.getString("room"),rs.getString("day"),rs.getString("session"),rs.getString("sTime"),rs.getString("samt"),rs.getString("eTime"),rs.getString("eamt"),rs.getInt("tid"),rs.getInt("session2"));
                locationList.add(locate);
            }
            
          }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          return locationList;
    }
    
    public void show_Location(){
        ArrayList<location1> list2 = locationList();
        DefaultTableModel model2 = (DefaultTableModel)ReservedRoomTable.getModel();
        Object[] row2 = new Object[10];
        
        for(int i =0; i<list2.size(); i++){
            row2[0] = list2.get(i).getlId();
            row2[1] = list2.get(i).getroom();
            row2[2] = list2.get(i).getday();
            row2[3] = list2.get(i).getsession();
            row2[4] = list2.get(i).getsTime();
            row2[5] = list2.get(i).getSamt();
            row2[6] = list2.get(i).geteTime();
            row2[7] = list2.get(i).getEamt();
            row2[8] = list2.get(i).getTid();
            row2[9] = list2.get(i).getSession2();
            model2.addRow(row2);
        
        }
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReservedRoomTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addsTime1 = new javax.swing.JTextField();
        addeTime1 = new javax.swing.JTextField();
        addRoom1 = new javax.swing.JComboBox<>();
        addDay1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        rid = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        timeAllocation2 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sessionCons = new javax.swing.JComboBox<>();
        roomlbl = new javax.swing.JLabel();
        roomlblvalue = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        sam2 = new javax.swing.JComboBox<>();
        eam2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sidCombo2 = new javax.swing.JComboBox<>();
        selSession = new javax.swing.JLabel();
        sesSave = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 250, 222));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(3, 48, 118));
        jLabel1.setText("ROOM DETAILS");

        jPanel3.setBackground(new java.awt.Color(176, 223, 236));

        jPanel2.setBackground(new java.awt.Color(212, 233, 221));

        jButton1.setBackground(new java.awt.Color(28, 72, 188));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 78, 99));
        jLabel2.setText("Reserved Room Details");

        ReservedRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ROOM", "DAY", "CATEGORY", "START TIME", "Sa.m/p.m", "END TIME", "Ea.m/p.m", "T. A. ID", "SESSION ID"
            }
        ));
        ReservedRoomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReservedRoomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ReservedRoomTable);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 78, 99));
        jLabel3.setText("Select Room");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 78, 99));
        jLabel4.setText("Select Day");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 78, 99));
        jLabel5.setText("Start Time");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 78, 99));
        jLabel6.setText("End Time");

        addsTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsTime1ActionPerformed(evt);
            }
        });

        addeTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addeTime1ActionPerformed(evt);
            }
        });

        addRoom1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room" }));

        addDay1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Day" }));
        addDay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDay1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 78, 99));
        jLabel7.setText("ID");

        jButton2.setBackground(new java.awt.Color(28, 72, 188));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(182, 4, 45));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(138, 135, 135));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(75, 155, 153));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 78, 99));
        jLabel8.setText("Time Allocation ID");

        timeAllocation2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ID" }));

        jButton6.setBackground(new java.awt.Color(70, 115, 189));
        jButton6.setText("Set");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Be Kind Enough to Set Time Allocation ID Before Selecting Your Day");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 78, 99));
        jLabel10.setText("Select Category");

        sessionCons.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Consecutive", "Non Consecutive" }));

        jButton7.setText("Not Overlapping");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("View");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        sam2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A.M.", "P.M." }));

        eam2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A.M.", "P.M." }));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("If you add another Allocation ID please click on Refresh Button First");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 78, 99));
        jLabel12.setText("Select Session");

        sidCombo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Session ID" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rid)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addsTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(sessionCons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(roomlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(roomlblvalue))))
                        .addGap(10, 10, 10)
                        .addComponent(sam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addDay1, 0, 140, Short.MAX_VALUE)
                                    .addComponent(addeTime1)
                                    .addComponent(timeAllocation2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(sesSave)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selSession, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(sidCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(83, 83, 83)
                                .addComponent(jButton5)
                                .addGap(84, 84, 84))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton3)
                        .addGap(193, 193, 193))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton8))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selSession)
                                    .addComponent(sesSave))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12)
                                    .addComponent(sidCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(rid, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(timeAllocation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jLabel10)
                    .addComponent(sessionCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(addRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomlbl)
                    .addComponent(roomlblvalue))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addeTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(addsTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(sam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel11))
                .addGap(40, 40, 40))
        );

        jToggleButton2.setText("Consecutive");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(102, 255, 102));
        jToggleButton3.setText("Parellel");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Non Overlapping");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setText("Not Available Times");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Dash Board");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton2)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton4)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4)
                    .addComponent(jToggleButton5)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addsTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsTime1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addsTime1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Back Button:
        if(evt.getActionCommand().equals("Back")){
           System.out.println("Details Adding Page of Location");
        }
        close();
        AddLocations nt = new AddLocations();
        nt.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void addeTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addeTime1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addeTime1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Update Button:
        
        try{
            
            
            //apachi Connection
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            
            int row2 = ReservedRoomTable.getSelectedRow();
            String value2 = (ReservedRoomTable.getModel().getValueAt(row2, 0).toString());
            String rrt = "Update addLocation SET room=?,day=?,session=?,sTime=?,eTime=?,tid=?,session2=? where lId="+value2;
            PreparedStatement pstmt = c.prepareStatement(rrt);
            
            String room1 = "";
            String day1 = "";
            String session1 = "";
            String tid1 = "";
            String samtt2 ="";
            String eamtt2 ="";
            String sid2 = "";
            
            room1 = addRoom1.getSelectedItem().toString();
            pstmt.setString(1, room1);
            
            day1 = addDay1.getSelectedItem().toString();
            pstmt.setString(2, day1);
            
            session1 = sessionCons.getSelectedItem().toString();
            pstmt.setString(3, session1);
            
            pstmt.setString(4, addsTime1.getText());
            
            samtt2 = sam2.getSelectedItem().toString();
            pstmt.setString(5, samtt2);
            
            pstmt.setString(6, addeTime1.getText());
            
            eamtt2 = eam2.getSelectedItem().toString();
            pstmt.setString(7, eamtt2);
            
            tid1 = timeAllocation2.getSelectedItem().toString();
            pstmt.setString(8, tid1);
            
            sid2 = sidCombo2.getSelectedItem().toString();
            pstmt.setInt(9, Integer.valueOf(sid2));
            
            pstmt.executeUpdate();
            
            DefaultTableModel model2 = (DefaultTableModel)ReservedRoomTable.getModel();
            model2.setRowCount(0);
            show_Location();
            JOptionPane.showMessageDialog(null, "Updated Successfully!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ReservedRoomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservedRoomTableMouseClicked
        // On Mouse Clicked:
        
        int ir = ReservedRoomTable.getSelectedRow();
        TableModel model2 = ReservedRoomTable.getModel();
        
        String idln = model2.getValueAt(ir, 0).toString();
        rid.setText(idln);
        
        String room2 = model2.getValueAt(ir, 1).toString();
        roomlbl.setText("Selected Room - ");
        roomlblvalue.setText(room2);
        
//        String room1 = model2.getValueAt(ir, 1).toString();
//        switch(room1){
//            case "":
//                addRoom1.setSelectedIndex(0);
//                break;
////            case "L501":
////                addRoom1.setSelectedIndex(1);
////                break;
//            
//        }
        
        //add day
        String day1 = model2.getValueAt(ir, 2).toString();
        switch(day1){
            case "":
                addDay1.setSelectedIndex(0);
                break;
            case "MonDay":
                addDay1.setSelectedIndex(1);
                break;
            case "TuesDay":
                addDay1.setSelectedIndex(2);
                break;
            case "WednesDay":
                addDay1.setSelectedIndex(3);
                break;
            case "ThursDay":
                addDay1.setSelectedIndex(4);
                break;
            case "FriDay":
                addDay1.setSelectedIndex(5);
                break;
            case "SaturDay":
                addDay1.setSelectedIndex(6);
                break;
            case "SunDay":
                addDay1.setSelectedIndex(7);
                break;
        }
        
        String conse = model2.getValueAt(ir, 3).toString();
        switch(conse){
            case "":
                sessionCons.setSelectedIndex(0);
                break;
            case "Consecutive":
                sessionCons.setSelectedIndex(1);
                break;
            case "Non Consecutive":
                sessionCons.setSelectedIndex(2);
                break;
            
        }
        
        //add Start Time
        String sTime = model2.getValueAt(ir, 4).toString();
        addsTime1.setText(sTime);
        
        String samc = model2.getValueAt(ir, 5).toString();
        switch(samc){
            case "":
                sam2.setSelectedIndex(0);
                break;
            case "A.M.":
                sam2.setSelectedIndex(0);
                break;
            case "P.M.":
                sam2.setSelectedIndex(1);
                break;
            
        }
        
        //add End Time
        String eTime = model2.getValueAt(ir, 6).toString();
        addeTime1.setText(eTime);
        
        String eamc = model2.getValueAt(ir, 7).toString();
        switch(eamc){
            case "":
                eam2.setSelectedIndex(0);
                break;
            case "A.M.":
                eam2.setSelectedIndex(0);
                break;
            case "P.M.":
                eam2.setSelectedIndex(1);
                break;
            
        }
        sesSave.setText("Saved as - ");
        selSession.setText(model2.getValueAt(ir, 9).toString());
        
    }//GEN-LAST:event_ReservedRoomTableMouseClicked

    private void addDay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDay1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Reset Button:
        rid.setText("");
        roomlbl.setText("");
        roomlblvalue.setText("");
        addRoom1.setSelectedIndex(0);
        sessionCons.setSelectedIndex(0);
        addDay1.setSelectedIndex(0);
        addsTime1.setText("");
        addeTime1.setText("");
        timeAllocation2.setSelectedIndex(0);
        sam2.setSelectedIndex(0);
        eam2.setSelectedIndex(0);
        selSession.setText("");
        sesSave.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Refresh Button:
        DefaultTableModel model2 = (DefaultTableModel)ReservedRoomTable.getModel();
        model2.setRowCount(0);
        show_Location();
        
        if(evt.getActionCommand().equals("Dash Board")){
            System.out.println("Return Dash Board");
        }
        close();
        ReservedRooms wd = new ReservedRooms();
        wd.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Delete Button:
        try{
           
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            int row3 = ReservedRoomTable.getSelectedRow();
            String value3 = (ReservedRoomTable.getModel().getValueAt(row3, 0).toString());
            String drqery = "DELETE from addLocation where lId="+value3;
            PreparedStatement pstm = c.prepareStatement(drqery);
            pstm.executeUpdate();
            DefaultTableModel model3 = (DefaultTableModel)ReservedRoomTable.getModel();
            model3.setRowCount(0);
            show_Location();
            rid.setText("");
            addRoom1.setSelectedIndex(0);
            addDay1.setSelectedIndex(0);
            sessionCons.setSelectedIndex(0);
            timeAllocation2.setSelectedIndex(0);
            addsTime1.setText("");
            addeTime1.setText("");
            roomlbl.setText("");
            roomlblvalue.setText("");
            selSession.setText("");
            sesSave.setText("");
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // Dash Board:
        if(evt.getActionCommand().equals("Dash Board")){
            System.out.println("Return Dash Board");
        }
        close();
        Member3_Dash_Board wd = new Member3_Dash_Board();
        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // SET:
        
        String Nv2 = timeAllocation2.getSelectedItem().toString();
        TaId2 = Integer.valueOf(Nv2);
        roomDay();
         
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Not Overlapping:
        try{
          
            
            //apache Connection
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "insert into notoverlappingtimeallo(rid,room,day,session,sTime,sam,eTime,eam,tid,session2)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = c.prepareStatement(sql);
            
            
//            String room1 = "";
            String day1 = "";
            String session1 = "";
            String tiid1 = "";
            String same = "";
            String eame = "";
            
            pstmt.setString(1, rid.getText());
            
            pstmt.setString(2, roomlblvalue.getText());
            
            day1 = addDay1.getSelectedItem().toString();
            pstmt.setString(3, day1);
            
            session1 = sessionCons.getSelectedItem().toString();
            pstmt.setString(4, session1);
            
            pstmt.setString(5, addsTime1.getText());
            
            same = sam2.getSelectedItem().toString();
            pstmt.setString(6, same);
            
            pstmt.setString(7, addeTime1.getText());
            
            eame = eam2.getSelectedItem().toString();
            pstmt.setString(8, eame);
            
            tiid1 = timeAllocation2.getSelectedItem().toString();
            pstmt.setString(9, tiid1);
            
            pstmt.setInt(10, Integer.valueOf(selSession.getText()));
            
            pstmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Remove from Parellel Section Successfully!");
            
            
                //deleting ovrlap

                try{

    //            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //            String url = "jdbc:sqlserver://localhost:1433;databaseName=jayamadhuka;user=sa;password=root";
    //            Connection conn = DriverManager.getConnection(url);
                Connection j = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
                int row4 = ReservedRoomTable.getSelectedRow();
                String value3 = (ReservedRoomTable.getModel().getValueAt(row4, 0).toString());
                String drqery2 = "DELETE from addLocation where lId="+value3;
                PreparedStatement pstt = j.prepareStatement(drqery2);
                pstt.executeUpdate();
                DefaultTableModel model3 = (DefaultTableModel)ReservedRoomTable.getModel();
                model3.setRowCount(0);
                show_Location();
                rid.setText("");
                addRoom1.setSelectedIndex(0);
                addDay1.setSelectedIndex(0);
                sessionCons.setSelectedIndex(0);
                timeAllocation2.setSelectedIndex(0);
                addsTime1.setText("");
                addeTime1.setText("");
                roomlbl.setText("");
                roomlblvalue.setText("");
                eam2.setSelectedIndex(0);
                sam2.setSelectedIndex(0);
                selSession.setText("");
                sesSave.setText("");
                JOptionPane.showMessageDialog(null, "Passed to Non Overlapping Section!");

            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
            
            //deleting overlap over
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }   
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // View Non Overlapping:
        if(evt.getActionCommand().equals("Dash Board")){
            System.out.println("Return Dash Board");
        }
        close();
        NotOverlappingTimeAndRoomAllocation wd = new NotOverlappingTimeAndRoomAllocation();
        wd.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        //        Consecutive Button
        if(evt.getActionCommand().equals("")){
            System.out.println("");
        }
        close();
        consecutiveTimesAllocation wd = new consecutiveTimesAllocation();
        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
//        // Parelll Button:
//        if(evt.getActionCommand().equals("Dash Board")){
//            System.out.println("Return Dash Board");
//        }
//        close();
//        ReservedRooms wd = new ReservedRooms();
//        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // Non Overlapping:
        if(evt.getActionCommand().equals("Dash Board")){
            System.out.println("Return Dash Board");
        }
        close();
        NotOverlappingTimeAndRoomAllocation wd = new NotOverlappingTimeAndRoomAllocation();
        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // Not Available Button:
        if(evt.getActionCommand().equals("")){
            System.out.println("");
        }
        close();
        sessionAndNotAvailableTime wd = new sessionAndNotAvailableTime();
        wd.setVisible(true);
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    
    
    
    //over deleting overlap
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
            java.util.logging.Logger.getLogger(ReservedRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservedRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservedRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservedRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservedRooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ReservedRoomTable;
    private javax.swing.JComboBox<String> addDay1;
    private javax.swing.JComboBox<String> addRoom1;
    private javax.swing.JTextField addeTime1;
    private javax.swing.JTextField addsTime1;
    private javax.swing.JComboBox<String> eam2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JLabel rid;
    private javax.swing.JLabel roomlbl;
    private javax.swing.JLabel roomlblvalue;
    private javax.swing.JComboBox<String> sam2;
    private javax.swing.JLabel selSession;
    private javax.swing.JLabel sesSave;
    private javax.swing.JComboBox<String> sessionCons;
    private javax.swing.JComboBox<String> sidCombo2;
    private javax.swing.JComboBox<String> timeAllocation2;
    // End of variables declaration//GEN-END:variables
}
