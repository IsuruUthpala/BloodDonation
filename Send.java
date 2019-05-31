/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author Isuru
 */
public class Send extends javax.swing.JFrame {

    /**
     * Creates new form Send
     */
    public Send() {
        initComponents();

        jLabel33.setText("");
        jLabel34.setText("");
        jLabel35.setText("");
        jLabel36.setText("");
        jLabel37.setText("");
        jLabel38.setText("");
        jLabel39.setText("");
        jLabel13.setText("");
        jLabel14.setText("");
    }

    public ArrayList<Don> getDonorsList() {
        ArrayList<Don> donorsList = new ArrayList<Don>();

        ResultSet rs;
        String qc = "";

        try {

            Statement stmt = new DAC().getConnection().createStatement();

            String Blood = jComboBox3.getSelectedItem().toString();

            String area = jComboBox2.getSelectedItem().toString();

            if (Blood.equals("All") && area.equals("All")) {
                String query = "SELECT * FROM  donor";
                qc = "1";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }

            } else if (Blood.equals("All") && area.equals(jComboBox2.getSelectedItem())) {
                String query = "SELECT * FROM  donor WHERE Area= '" + jComboBox2.getSelectedItem() + "' ";
                qc = "2";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals(jComboBox3.getSelectedItem()) && area.equals(jComboBox2.getSelectedItem())) {
                String query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox3.getSelectedItem() + "' AND Area= '" + jComboBox2.getSelectedItem() + "' ";
                qc = "3";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals(jComboBox3.getSelectedItem()) && area.equals("All")) {
                String query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox3.getSelectedItem() + "' ";
                qc = "4";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            }
            //jTextField1.setText(qc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return donorsList;
    }

    int sux, mox, tux, wex, thx, frx, sax;

    public ArrayList<Vol> getVolunteersList() {
        if (chckFr.isSelected()) {
            frx = 1;

        } else {
            frx = 2;
        }
        if (chckMo.isSelected()) {
            mox = 1;

        } else {
            mox = 2;
        }
        if (chckTu.isSelected()) {
            tux = 1;

        } else {
            tux = 2;
        }
        if (chckWe.isSelected()) {
            wex = 1;

        } else {
            wex = 2;
        }
        if (chckTh.isSelected()) {
            thx = 1;

        } else {
            thx = 2;
        }
        if (chckSa.isSelected()) {
            sax = 1;

        } else {
            sax = 2;
        }
        if (chckSu.isSelected()) {
            sux = 1;

        } else {
            sux = 2;
        }
        ArrayList<Vol> volunteersList = new ArrayList<Vol>();

        ResultSet rs;
        String area1 = jComboBox1.getSelectedItem().toString();
        String qc = "";
        try {

            Statement stmt = new DAC().getConnection().createStatement();

            if (area1.equals("All")) {
                qc = "1";
                String query = "select * from volunteer where Sunday='" + sux + "' or Monday ='" + mox + "' or Tuesday='" + tux + "' or Wednesday='" + wex + "' or Thursday='" + thx + "'or Friday='" + frx + "' or Saturday='" + sax + "'";
                rs = stmt.executeQuery(query);

                Vol volunteer;

                while (rs.next()) {
                    volunteer = new Vol(rs.getString("VolunteerID"), rs.getString("VolunteerName"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("Area"), rs.getBoolean("Monday"), rs.getBoolean("Tuesday"), rs.getBoolean("Wednesday"), rs.getBoolean("Thursday"), rs.getBoolean("Friday"), rs.getBoolean("Saturday"), rs.getBoolean("Sunday"));
                    volunteersList.add(volunteer);
                }
            } else {
                qc = "2";
                String query = "select * from  volunteer where Area ='" + area1 + "' and (Sunday='" + sux + "' or Monday ='" + mox + "' or Tuesday='" + tux + "' or Wednesday='" + wex + "' or Thursday='" + thx + "'or Friday='" + frx + "' or Saturday='" + sax + "')";
                rs = stmt.executeQuery(query);

                Vol volunteer;

                while (rs.next()) {
                    volunteer = new Vol(rs.getString("VolunteerID"), rs.getString("VolunteerName"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("Area"), rs.getBoolean("Monday"), rs.getBoolean("Tuesday"), rs.getBoolean("Wednesday"), rs.getBoolean("Thursday"), rs.getBoolean("Friday"), rs.getBoolean("Saturday"), rs.getBoolean("Sunday"));
                    volunteersList.add(volunteer);
                }
            }

            //jTextField1.setText(qc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return volunteersList;
    }

    public String[] Add_Contacts() {
        int countvol = 0;
        int countdon = 0;

        ArrayList<Don> list = getDonorsList();
        ArrayList<Vol> list2 = getVolunteersList();
//countdon=list.size();
        String[] row = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {

            row[i] = Integer.toString(list.get(i).getContact());
            // countdon=i;
        }

        String[] row2 = new String[list2.size()];
        for (int i = 0; i < list2.size(); i++) {

            row2[i] = Integer.toString(list2.get(i).getContact());
            // countvol++;
        }
        //jLabel14.setText(Integer.toString(countvol));

        if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {

            String[] bothcon = (String[]) ArrayUtils.addAll(row, row2);
            for (int i = 0; i < bothcon.length; i++) {
                System.out.println(bothcon[i]);
                int cd = row.length;
                int cv = row2.length;
                jLabel13.setText(Integer.toString(cd));
                jLabel14.setText(Integer.toString(cv));
                return bothcon;
//countdon=list.size();
            }

        } else if (jCheckBox1.isSelected()) {

            for (int i = 0; i < list2.size(); i++) {

                row2[i] = Integer.toString(list2.get(i).getContact());
                // System.out.println(row2[i]);
                int cv = row2.length;
                jLabel14.setText(Integer.toString(cv));
                return row2;
            }

        } else if (jCheckBox2.isSelected()) {

            for (int i = 0; i < list.size(); i++) {

                row[i] = Integer.toString(list.get(i).getContact());
                // System.out.println(row[i]);
                int cd = row.length;
                jLabel13.setText(Integer.toString(cd));

            }
            return row;

        }

        return null;

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
        jLabel7 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chckSu = new javax.swing.JCheckBox();
        chckMo = new javax.swing.JCheckBox();
        chckTu = new javax.swing.JCheckBox();
        chckWe = new javax.swing.JCheckBox();
        chckTh = new javax.swing.JCheckBox();
        chckFr = new javax.swing.JCheckBox();
        chckSa = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("_");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        lblExit.setBackground(new java.awt.Color(0, 0, 0));
        lblExit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setText("X");
        lblExit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblExitMouseMoved(evt);
            }
        });
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Send SMS");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Go Back_50px.png"))); // NOI18N
        jLabel22.setText("Main Menu");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Anuradhapura", "Jaffna", "Polonnaruwa" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Area");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Available Days");

        chckSu.setText("Su");
        chckSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckSuActionPerformed(evt);
            }
        });

        chckMo.setText("Mo");

        chckTu.setText("Tu");

        chckWe.setText("We");

        chckTh.setText("Th");

        chckFr.setText("Fr");

        chckSa.setText("Sa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Volunteers");

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Donors");

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Anuradhapura", "Jaffna", "Polonnaruwa" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Area");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Blood Group");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Add Contacts");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel11.setText("Blood Donors");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel15.setText("BloodGroup");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel17.setText("None");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Filtered Data");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel25.setText("Area-");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel26.setText("None");

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel27.setText("No: of Contacts Added:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel12.setText("Volunteers");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel29.setText("Area-");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel30.setText("None");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel16.setText("Days-");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel31.setText("No: of Contacts Added:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel33.setText("All");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel34.setText("All");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel35.setText("All");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel36.setText("All");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel37.setText("All");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel38.setText("All");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel39.setText("All");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel13.setText("jLabel13");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel25))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel11)))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel16))
                                    .addComponent(jLabel29))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel35)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel36))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel37)))))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel27))
                .addGap(30, 30, 30))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)))
                    .addComponent(jLabel24))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel14))
                .addGap(27, 27, 27))
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton3.setText("Select All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chckSu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chckMo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chckTu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chckWe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chckTh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chckFr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chckSa))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(40, 40, 40)
                                        .addComponent(jCheckBox1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(88, 88, 88)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(140, 140, 140)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(18, 18, 18)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblExit)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblExit))
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jLabel6)))))
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chckSu)
                            .addComponent(chckMo)
                            .addComponent(chckTu)
                            .addComponent(chckWe)
                            .addComponent(chckTh)
                            .addComponent(chckFr)
                            .addComponent(chckSa))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Contacts");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Message");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Message_80px.png"))); // NOI18N
        jButton2.setText("SEND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        jLabel7.setForeground(Color.black);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        jLabel7.setForeground(Color.white);
    }//GEN-LAST:event_jLabel7MouseExited

    private void lblExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblExitMouseMoved

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseEntered
        // TODO add your handling code here:
        lblExit.setForeground(Color.black);
    }//GEN-LAST:event_lblExitMouseEntered

    private void lblExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseExited
        // TODO add your handling code here:
        lblExit.setForeground(Color.white);
    }//GEN-LAST:event_lblExitMouseExited

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void chckSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckSuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckSuActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Add_Contacts();
        // Send ob=new Send();
try{
        jLabel26.setText(jComboBox2.getSelectedItem().toString());
        jLabel17.setText(jComboBox3.getSelectedItem().toString());
        jLabel30.setText(jComboBox1.getSelectedItem().toString());
        // jLabel28.setText(jTextField1.getText().toString());
        // jLabel32.setText(jTextField2.getText().toString());
        //jLabel25.setText(jComboBox1.getSelectedItem().toString());
        if (chckSu.isSelected()) {
            jLabel33.setText("Su");
        }

        if (chckMo.isSelected()) {
            jLabel34.setText("Mo");
        }
        if (chckTu.isSelected()) {
            jLabel35.setText("Tu");
        }
        if (chckWe.isSelected()) {
            jLabel36.setText("We");
        }
        if (chckTh.isSelected()) {
            jLabel37.setText("Th");
        }
        if (chckFr.isSelected()) {
            jLabel38.setText("Fr");
        }
        if (chckSa.isSelected()) {
            jLabel39.setText("Sa");
        }

        String[] arr1 = Add_Contacts();
        for (int i = 0; i < arr1.length; i++) {

            jTextArea1.append("0" + arr1[i] + " , ");
        }
}
catch(Exception e){
JOptionPane.showMessageDialog(rootPane, "You have to select a Category");
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //  Send ob=new Send();
        try {
            String[] arr1 = Add_Contacts();
            for (int i = 0; i < arr1.length; i++) {

                System.out.println(arr1[i]);
            }

            SendMessage app = new SendMessage();

            Login lc = new Login();
        String emp = lc.lgname;
            //String emp = "123";
           // String don = "456";
            
             ArrayList<Don> list = getDonorsList();
        ArrayList<Vol> list2 = getVolunteersList();
        
         String[] row = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {

            row[i] = Integer.toString(list.get(i).getContact());
            // countdon=i;
        }

        String[] row2 = new String[list2.size()];
        for (int i = 0; i < list2.size(); i++) {

            row2[i] = Integer.toString(list2.get(i).getContact());
            // countvol++;
        }
        
        
        java.util.Date oDate = new java.util.Date();
            DateFormat oDateFormat = new SimpleDateFormat("EE MMM dd yyyy");
//String date=oDate.toString();
       
            String dt = oDateFormat.format(oDate);
        
        
       // new java.util.Date();
            
            
            

            String msg = jTextArea2.getText();

            // for (int i = 0; i < arr1.length; i++) {
            // Statement stmt = new DAC().getConnection().createStatement();
            //String query="INSERT INTO `employee_donor` (`EmpID`, `DonorID`, `Message`, `Date`) VALUES ('" + emp+ "', '" +arr1[i]+ "', '" +msg + "', '" + new java.util.Date() + "')";
            //int a=stmt.executeUpdate(query);
            if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
                
           for (int i = 0; i < row.length; i++) {      
Statement stmt = new DAC().getConnection().createStatement();
                 String query="INSERT INTO `employee_donor` (`EmpName`, `DonorContact`, `Message`, `Date`) VALUES ('" + emp+ "', '" +row[i]+ "', '" +msg + "', '" +dt+ "')";
int a=stmt.executeUpdate(query);
app.doIt(row[i], msg);
           }
           
           
      
           for (int i = 0; i < row2.length; i++) {      
Statement stmt = new DAC().getConnection().createStatement();
                String query2="INSERT INTO `employee_volunteer` (`EmpName`, `VolunteerContact`, `Message`, `Date`) VALUES ('" + emp+ "', '" +row2[i]+ "', '" +msg + "', '" + dt + "')";
                int b=stmt.executeUpdate(query2);
                app.doIt(row2[i], msg);
           }
            } else if (jCheckBox1.isSelected()) {

                for (int i = 0; i < arr1.length; i++) {
                    Statement stmt = new DAC().getConnection().createStatement();
                    String query = "INSERT INTO `employee_volunteer` (`EmpName`, `VolunteerContact`, `Message`, `Date`) VALUES ('" + emp + "', '" + arr1[i] + "', '" + msg + "', '" + dt+ "')";
                    int a = stmt.executeUpdate(query);
                    app.doIt(arr1[i], msg);

                }
            } else if (jCheckBox2.isSelected()) {
                for (int i = 0; i < arr1.length; i++) {
                    Statement stmt = new DAC().getConnection().createStatement();
                    String query = "INSERT INTO `employee_donor` (`EmpName`, `DonorContact`, `Message`, `Date`) VALUES ('" + emp + "', '" + arr1[i] + "', '" + msg + "', '" + dt+ "')";
                    int a = stmt.executeUpdate(query);
                    app.doIt(arr1[i], msg);

                }

            }
            else{
            
            //JOptionPane.showMessageDialog(rootPane, "You have to select a Category");
            }

            //app.doIt(arr1[i], msg);
            // }
            JOptionPane.showMessageDialog(rootPane, "Messaages sent successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please check if the fields are empty");
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        chckSa.setSelected(true);
        chckSu.setSelected(true);
        chckMo.setSelected(true);
        chckTu.setSelected(true);
        chckTh.setSelected(true);
        chckFr.setSelected(true);
        chckWe.setSelected(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        Mmenu m1 = new Mmenu();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

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
            java.util.logging.Logger.getLogger(Send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Send().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chckFr;
    private javax.swing.JCheckBox chckMo;
    private javax.swing.JCheckBox chckSa;
    private javax.swing.JCheckBox chckSu;
    private javax.swing.JCheckBox chckTh;
    private javax.swing.JCheckBox chckTu;
    private javax.swing.JCheckBox chckWe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblExit;
    // End of variables declaration//GEN-END:variables
}
