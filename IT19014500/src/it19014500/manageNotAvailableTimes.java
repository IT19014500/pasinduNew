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
public class manageNotAvailableTimes extends javax.swing.JFrame {

    Integer TaId =0;
    public manageNotAvailableTimes() {
        initComponents();
        show_timing();
        mgroupCombo2();
        subGroupCombo2();
        lecturerCombo2();
        subCode2();
        timeAllo33();
    }
    
    private void dayAllo23()
    {
     try
        {
            
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from days where idwd ='"+TaId+"'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                String day1 = rs.getString("workingDay");
                dayLbl2.addItem(day1);  
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
     private void timeAllo33()
    {
     try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from workingdayshours";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                
                String wd1 = rs.getString("id");
                tAllo2.addItem(wd1);
                
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    public ArrayList<Timing> timingList(){
        ArrayList<Timing> timingList = new ArrayList<>();
        try{
            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=jayamadhuka;user=sa;password=root";
//            Connection conn = DriverManager.getConnection(url);
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String NAquery = "select * from notavailabletime";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(NAquery);
            
            Timing timing;
            while(rs.next()){
                timing = new Timing(rs.getInt("ntId"),rs.getString("time"),rs.getString("mainGroup"),rs.getString("subGroup"),rs.getString("subCode"),rs.getString("sessionId"),rs.getString("lecturer"),rs.getInt("tid"),rs.getString("day"),rs.getInt("session2"));
                timingList.add(timing);
            }
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return timingList;
    }
    
    public void show_timing(){
        ArrayList<Timing> list1 = timingList();
        DefaultTableModel model1 = (DefaultTableModel)notAvailableTimeTable.getModel();
        Object[] row1 = new Object[10];
        for(int i =0; i<list1.size(); i++){
            row1[0] = list1.get(i).getntId();
            row1[1] = list1.get(i).gettime();
            row1[2] = list1.get(i).getmainGroup();
            row1[3] = list1.get(i).getsubGroup();
            row1[4] = list1.get(i).getsubCode();
            row1[5] = list1.get(i).getsessionId();
            row1[6] = list1.get(i).getlecturer();
            row1[7] = list1.get(i).getTid();
            row1[8] = list1.get(i).getDay();
            row1[9] = list1.get(i).getSession2();
            model1.addRow(row1);
        
        }
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private void mgroupCombo2(){
        try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from student";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                String mgroup = rs.getString("group_id");
                addMainGroup2.addItem(mgroup);
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void subGroupCombo2(){
        try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from student";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                String mgroup = rs.getString("sub_group_id");
                addSubGroup2.addItem(mgroup);
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
 
    private void lecturerCombo2(){
        try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from lecture";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                String mgroup = rs.getString("lecture_name");
                addLec2.addItem(mgroup);
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void subCode2(){
        try
        {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            String sql = "select * from subject";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next())
            {
                String mgroup = rs.getString("subject_code");
                addsCode2.addItem(mgroup);
            }
                    
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notAvailableTimeTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addTime2 = new javax.swing.JTextField();
        addMainGroup2 = new javax.swing.JComboBox<>();
        addSubGroup2 = new javax.swing.JComboBox<>();
        addsCode2 = new javax.swing.JComboBox<>();
        addssId2 = new javax.swing.JComboBox<>();
        addLec2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Idl = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        tAllo2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        dayLbl2 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        sCodelbl = new javax.swing.JLabel();
        leclbl = new javax.swing.JLabel();
        mgrplbl = new javax.swing.JLabel();
        sgrplbl = new javax.swing.JLabel();
        taidlbl1 = new javax.swing.JLabel();
        dlbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        sessionBro = new javax.swing.JComboBox<>();
        sesLbl62 = new javax.swing.JLabel();
        sesLbl6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 250, 222));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(3, 48, 118));
        jLabel1.setText("MANAGE NOT AVAILABLE TIMES");

        jPanel2.setBackground(new java.awt.Color(212, 233, 221));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 78, 99));
        jLabel2.setText("NOT AVAILABLE TIME DETAILS");

        jButton1.setBackground(new java.awt.Color(28, 72, 188));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        notAvailableTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Duration", "Group ID", "Sub Group ID", "Subject Code", "Category", "Lecturer", "T.A. ID", "Day", "Session"
            }
        ));
        notAvailableTimeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notAvailableTimeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(notAvailableTimeTable);

        jButton2.setBackground(new java.awt.Color(138, 135, 135));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 78, 99));
        jLabel3.setText("Time");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 78, 99));
        jLabel4.setText("Select Group");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 78, 99));
        jLabel5.setText("Select Sub Group");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 78, 99));
        jLabel6.setText("Subject Code");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 78, 99));
        jLabel7.setText("Select Category");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 78, 99));
        jLabel8.setText("Select Lecturer");

        addTime2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTime2ActionPerformed(evt);
            }
        });

        addMainGroup2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Group" }));

        addSubGroup2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Sub Group" }));

        addsCode2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject Code" }));

        addssId2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Consecutive", "Non Consecutive" }));

        addLec2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Lecturer" }));

        jButton3.setBackground(new java.awt.Color(28, 72, 188));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 78, 99));
        jLabel9.setText("ID");

        jButton4.setBackground(new java.awt.Color(75, 155, 153));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(182, 4, 45));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Dash Board");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 78, 99));
        jLabel10.setText("Time Allocation ID");

        tAllo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ID" }));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 78, 99));
        jLabel11.setText("Day");

        dayLbl2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Day" }));

        jButton6.setText("Set");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(3, 48, 118));
        jLabel12.setText("Be Kind Enough to Set Time Allocation ID Before Selecting Your Day");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("If you add another Allocation ID please click on Refresh Button First");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 78, 99));
        jLabel14.setText("Select Session");

        sessionBro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Session" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12))
                                .addGap(63, 63, 63)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mgrplbl)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addTime2)
                                        .addComponent(addMainGroup2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addSubGroup2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tAllo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(sgrplbl)
                                    .addComponent(taidlbl1)
                                    .addComponent(Idl)
                                    .addComponent(jButton3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(75, 75, 75)
                                        .addComponent(jButton5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jButton6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel11)))
                                            .addComponent(jLabel14))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(sesLbl62)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sesLbl6)
                                                .addGap(37, 37, 37))
                                            .addComponent(sCodelbl)
                                            .addComponent(addsCode2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addssId2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addLec2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dayLbl2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(leclbl)
                                            .addComponent(dlbl)
                                            .addComponent(sessionBro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jToggleButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sesLbl6)
                    .addComponent(sesLbl62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14)
                            .addComponent(sessionBro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(addTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addsCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(sCodelbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(addMainGroup2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addssId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(mgrplbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(addSubGroup2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addLec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tAllo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jButton6)
                            .addComponent(jLabel11)
                            .addComponent(dayLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leclbl)
                            .addComponent(sgrplbl))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(taidlbl1)
                            .addComponent(dlbl))
                        .addGap(35, 35, 35)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Idl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(171, 171, 171))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Refresh Button:
        if(evt.getActionCommand().equals("Back")){
           System.out.println("Details Page of Sessions Not Available Time Allocation");
        }
        close();
        manageNotAvailableTimes nt = new manageNotAvailableTimes();
        nt.setVisible(true);
        
        DefaultTableModel model1 = (DefaultTableModel)notAvailableTimeTable.getModel();
        model1.setRowCount(0);
        show_timing();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Back Button:
        
        if(evt.getActionCommand().equals("Back")){
           System.out.println("Details Page of Sessions Not Available Time Allocation");
        }
        close();
        sessionAndNotAvailableTime nt = new sessionAndNotAvailableTime();
        nt.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Update Button:
        try{
            
            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=jayamadhuka;user=sa;password=root";
//            Connection conn = DriverManager.getConnection(url);
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            int row1 = notAvailableTimeTable.getSelectedRow();
            String value1 = (notAvailableTimeTable.getModel().getValueAt(row1, 0).toString());
            String wdu1 = "Update notavailabletime SET time=?,mainGroup=?,subGroup=?,subCode=?,sessionId=?,lecturer=?,tid=?,day=?,session2=? where ntId="+value1;
            PreparedStatement pstmt = c.prepareStatement(wdu1);
            
            String mGroup1 = "";
            String sGroup1 = "";
            String sCode1 = "";
            String ssId1 = "";
            String lec1 = "";
            String tidd1 = "";
            String dayy1 = "";
            String sesB = "";
            
            pstmt.setString(1, addTime2.getText());
            
            mGroup1 = addMainGroup2.getSelectedItem().toString();
            pstmt.setString(2, mGroup1);
            
            sGroup1 = addSubGroup2.getSelectedItem().toString();
            pstmt.setString(3, sGroup1);
            
            sCode1 = addsCode2.getSelectedItem().toString();
            pstmt.setString(4, sCode1);
            
            ssId1 = addssId2.getSelectedItem().toString();
            pstmt.setString(5, ssId1);
            
            lec1 = addLec2.getSelectedItem().toString();
            pstmt.setString(6, lec1);
            
            tidd1 = tAllo2.getSelectedItem().toString();
            pstmt.setInt(7, Integer.valueOf(tidd1));
            
            dayy1 = dayLbl2.getSelectedItem().toString();
            pstmt.setString(8, dayy1);
            
            sesB = sessionBro.getSelectedItem().toString();
            pstmt.setInt(9, Integer.valueOf(sesB));
            
            pstmt.executeUpdate();
            
            DefaultTableModel model1 = (DefaultTableModel)notAvailableTimeTable.getModel();
            model1.setRowCount(0);
            show_timing();
            JOptionPane.showMessageDialog(null, "Updated Successfully!");
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTime2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTime2ActionPerformed

    private void notAvailableTimeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notAvailableTimeTableMouseClicked
        
 
        // Mouse Click Event:
        int iv = notAvailableTimeTable.getSelectedRow();
        TableModel model1 = notAvailableTimeTable.getModel();
        
        String idl2 = model1.getValueAt(iv, 0).toString();
        Idl.setText(idl2);
        
        String time1 = model1.getValueAt(iv, 1).toString();
        addTime2.setText(time1);
        
        String mGroup1 = model1.getValueAt(iv, 2).toString();
        mgrplbl.setText("Selected as - "+mGroup1);
        
        //sub Group

        String sGroup1 = model1.getValueAt(iv, 3).toString();
        sgrplbl.setText("Selected as - "+sGroup1);
        
        //sub Code
        
        String sCode1 = model1.getValueAt(iv, 4).toString();
        sCodelbl.setText("Selected as - "+sCode1);
        
        //Session ID
        String seId = model1.getValueAt(iv, 5).toString();
        switch(seId){
            case "":
                addssId2.setSelectedIndex(0);
                break;
            case "Consecutive":
                addssId2.setSelectedIndex(1);
                break;
            case "Non Consecutive":
                addssId2.setSelectedIndex(2);
                break;
           
        }
        
        //Lecturer
        String lec1 = model1.getValueAt(iv, 6).toString();
        leclbl.setText("Selected as - "+lec1);
        
        String taaid = model1.getValueAt(iv, 7).toString();
        taidlbl1.setText("Selected as - "+taaid);
        
        
        //Day
        String dayy = model1.getValueAt(iv, 8).toString();
        switch(dayy){
            case "":
                dayLbl2.setSelectedIndex(0);
                break;
            case "MonDay":
                dayLbl2.setSelectedIndex(1);
                break;
            case "TuesDay":
                dayLbl2.setSelectedIndex(2);
                break;
            case "WednesDay":
                dayLbl2.setSelectedIndex(3);
                break;
            case "ThursDay":
                dayLbl2.setSelectedIndex(4);
                break;
            case "FriDay":
                dayLbl2.setSelectedIndex(5);
                break;
            case "SaturDay":
                dayLbl2.setSelectedIndex(6);
                break;
            case "SunDay":
                dayLbl2.setSelectedIndex(7);
                break;
            default:
                dayLbl2.setSelectedIndex(0);
                break;
           
        }
        
        sesLbl62.setText("Selected as - ");
        sesLbl6.setText(model1.getValueAt(iv, 9).toString());
    }//GEN-LAST:event_notAvailableTimeTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Reset Button:
        Idl.setText("");
        sesLbl6.setText("");
        sesLbl62.setText("");
        addTime2.setText("");
        addMainGroup2.setSelectedIndex(0);
        addSubGroup2.setSelectedIndex(0);
        addsCode2.setSelectedIndex(0);
        addssId2.setSelectedIndex(0);
        addLec2.setSelectedIndex(0);
        tAllo2.setSelectedIndex(0);
        dayLbl2.setSelectedIndex(0);
        mgrplbl.setText("");
        sgrplbl.setText("");
        sCodelbl.setText("");
        leclbl.setText("");
        taidlbl1.setText("");
        sessionBro.setSelectedIndex(0);
//        dlbl.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Delete Button:
        
        try{
           
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=jayamadhuka;user=sa;password=root";
//            Connection conn = DriverManager.getConnection(url);
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltdmgdb?zeroDateTimeBehavior=convertToNull","root","");
            int row1 = notAvailableTimeTable.getSelectedRow();
            String value1 = (notAvailableTimeTable.getModel().getValueAt(row1, 0).toString());
            String dqery1 = "DELETE from notavailabletime where ntId="+value1;
            PreparedStatement pstm = c.prepareStatement(dqery1);
            pstm.executeUpdate();
            DefaultTableModel model1 = (DefaultTableModel)notAvailableTimeTable.getModel();
            model1.setRowCount(0);
            show_timing();
            Idl.setText("");
            addTime2.setText("");
            addMainGroup2.setSelectedIndex(0);
            addSubGroup2.setSelectedIndex(0);
            addsCode2.setSelectedIndex(0);
            addssId2.setSelectedIndex(0);
            addLec2.setSelectedIndex(0);
            tAllo2.setSelectedIndex(0);
            dayLbl2.setSelectedIndex(0);
            mgrplbl.setText("");
            sgrplbl.setText("");
            sCodelbl.setText("");
            leclbl.setText("");
            taidlbl1.setText("");
            sessionBro.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
        // Time Set:
        String Nv = tAllo2.getSelectedItem().toString();
        TaId = Integer.valueOf(Nv);
        dayAllo23();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(manageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageNotAvailableTimes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Idl;
    private javax.swing.JComboBox<String> addLec2;
    private javax.swing.JComboBox<String> addMainGroup2;
    private javax.swing.JComboBox<String> addSubGroup2;
    private javax.swing.JTextField addTime2;
    private javax.swing.JComboBox<String> addsCode2;
    private javax.swing.JComboBox<String> addssId2;
    private javax.swing.JComboBox<String> dayLbl2;
    private javax.swing.JLabel dlbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel leclbl;
    private javax.swing.JLabel mgrplbl;
    private javax.swing.JTable notAvailableTimeTable;
    private javax.swing.JLabel sCodelbl;
    private javax.swing.JLabel sesLbl6;
    private javax.swing.JLabel sesLbl62;
    private javax.swing.JComboBox<String> sessionBro;
    private javax.swing.JLabel sgrplbl;
    private javax.swing.JComboBox<String> tAllo2;
    private javax.swing.JLabel taidlbl1;
    // End of variables declaration//GEN-END:variables

   
}
