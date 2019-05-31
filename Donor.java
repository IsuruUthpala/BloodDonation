/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Isuru
 */
public class Donor extends javax.swing.JFrame {

    Connection con;

    public Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/blood";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
        }

        return con;
    }

    /**
     * Creates new form Donor
     */
    public Donor() {
        initComponents();
        // Show_Donors_In_JTable();
        jTextField1.setVisible(false);

    }

    public void searchresult() {

    }

    public ArrayList<Don> getDonorsList() {
        ArrayList<Don> donorsList = new ArrayList<Don>();

        ResultSet rs;
        String qc="";

        try {

            getConnection();
            Statement stmt = con.createStatement();
            //Statement stmt = new DAC().getConnection().createStatement();
            // String query = "SELECT * FROM  donor ";
            String Blood = jComboBox1.getSelectedItem().toString();
            // String Elig = jComboBox2.getSelectedItem().toString();
            // String age = jComboBox3.getSelectedItem().toString();
            //String weight = jComboBox4.getSelectedItem().toString();
            String gender = jComboBox5.getSelectedItem().toString();
            String area = jComboBox6.getSelectedItem().toString();

            if (Blood.equals("All") && gender.equals("All") && area.equals("All")) {
                String query = "SELECT * FROM  donor";
                qc = "1";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }

            } else if (Blood.equals("All") && gender.equals("All") && area.equals(jComboBox6.getSelectedItem())) {
                String query = "SELECT * FROM  donor WHERE Area= '" + jComboBox6.getSelectedItem() + "' ";
                qc = "2";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals("All") && gender.equals(jComboBox5.getSelectedItem()) && area.equals("All")) {
                String query = "SELECT * FROM  donor WHERE Gender= '" + jComboBox5.getSelectedItem() + "' ";
                qc = "3";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals(jComboBox1.getSelectedItem()) && gender.equals("All") && area.equals("All")) {
                String query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' ";
                qc = "4";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals(jComboBox1.getSelectedItem()) && gender.equals(jComboBox5.getSelectedItem()) && area.equals("All")) {
                String query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' AND Gender='" + jComboBox5.getSelectedItem() + "' ";
                qc = "5";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals(jComboBox1.getSelectedItem()) && gender.equals("All") && area.equals(jComboBox6.getSelectedItem())) {
                String query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' AND Area='" + jComboBox6.getSelectedItem() + "' ";
                qc = "6";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals("All") && gender.equals(jComboBox5.getSelectedItem()) && area.equals("All")) {
                String query = "SELECT * FROM  donor WHERE Gender= '" + jComboBox5.getSelectedItem() + "' ";
                qc ="7";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            } else if (Blood.equals(jComboBox1.getSelectedItem()) && gender.equals(jComboBox5.getSelectedItem()) && area.equals(jComboBox6.getSelectedItem())) {
                String query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' AND Area='" + jComboBox6.getSelectedItem() + "' AND Gender='" + jComboBox5.getSelectedItem() + "' ";
                qc = "8";
                rs = stmt.executeQuery(query);

                Don donor;

                while (rs.next()) {
                    donor = new Don(rs.getString("DonorID"), rs.getString("DonorName"), rs.getString("Gender"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("BloodGroup"), rs.getDouble("weight"), rs.getString("DOB"), rs.getString("LastDonateDate"), rs.getString("Area"), rs.getInt("Age"));
                    donorsList.add(donor);
                }
            }
            jTextField1.setText(qc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return donorsList;
    }

    public void Show_Donors_In_JTable() {
        ArrayList<Don> list = getDonorsList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[11];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getDonorId();
            row[1] = list.get(i).getDonorName();
            row[2] = list.get(i).getContact();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getBloodGroup();
            row[5] = list.get(i).getLDD();
            row[6] = list.get(i).getweight();
            row[7] = list.get(i).getGender();
            row[8] = list.get(i).getDOB();
            row[9] = list.get(i).getAge();
            row[10] = list.get(i).getArea();

            model.addRow(row);
        }
        int x = model.getRowCount();
        String y = Integer.toString(x);
        jLabel21.setText(y);
        jTable1.setAutoCreateRowSorter(true);
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
        lblExit = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/34_blood_bank_bag_bottle_medical_treatment_drug-256.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Donor Details");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Blood Group");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Male", "Female" }));

        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMessage.setText("Go to Message");
        btnMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMessageMouseClicked(evt);
            }
        });
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel14.setText("Gender-");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel10.setText("Blood Group-");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel15.setText("All");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel19.setText("All");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("No: of Results:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Filtered Data");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel24.setText("Area-");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel25.setText("All");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel24))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19))
                        .addGap(44, 237, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel19))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Go Back_50px.png"))); // NOI18N
        jLabel22.setText("Main Menu");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Area");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Anuradhapura", "Jaffna", "Polonnaruwa" }));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(236, 236, 236)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(122, 122, 122)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnSearch)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnMessage)))
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3)
                                .addComponent(jLabel23)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1123, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblExit)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblExit))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(btnPrint)
                            .addComponent(btnMessage))
                        .addGap(29, 29, 29))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DonorId", "Name", "Contact", "Address", "BloodGroup", "LDD", "Weight(Kg)", "Gender", "DOB", "Age", "Area"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMessageActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        String condition=jTextField1.getText();

        try {
             getConnection();
             JasperDesign jd=JRXmlLoader.load("C:\\Users\\Isuru\\Documents\\NetBeansProjects\\Blood\\report2.jrxml");
             String query = null;
             if(condition.equals("1")){
                   query = "SELECT * FROM  donor";
             
             
             
         }
             else if (condition.equals("2")) {
                  query = "SELECT * FROM  donor WHERE Area= '" + jComboBox6.getSelectedItem() + "' ";
                
            }
             else if(condition.equals("3")){
                 query = "SELECT * FROM  donor WHERE Gender= '" + jComboBox5.getSelectedItem() + "' ";
             
             }
             else if (condition.equals("4")) {
                  query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' ";
                
            }
             else if (condition.equals("5")) {
                 query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' AND Gender='" + jComboBox5.getSelectedItem() + "' ";
                
            }
             else if (condition.equals("6")) {
                 query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' AND Area='" + jComboBox6.getSelectedItem() + "' ";
                
            }
             else if (condition.equals("7")) {
                  query = "SELECT * FROM  donor WHERE Gender= '" + jComboBox5.getSelectedItem() + "' ";
                
            }
             else if (condition.equals("8")) {
                 query = "SELECT * FROM  donor WHERE BloodGroup= '" + jComboBox1.getSelectedItem() + "' AND Area='" + jComboBox6.getSelectedItem() + "' AND Gender='" + jComboBox5.getSelectedItem() + "' ";
                
            }
             JRDesignQuery newQuery=new  JRDesignQuery();
             newQuery.setText(query);
             jd.setQuery(newQuery);
           
            JasperReport jr = JasperCompileManager.compileReport(jd);

            //JasperPrint jp=JasperFillManager.fillReport(jr, rs,con);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp,false);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        Mmenu m1 = new Mmenu();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Show_Donors_In_JTable();
        jLabel15.setText(jComboBox1.getSelectedItem().toString());
        jLabel19.setText(jComboBox5.getSelectedItem().toString());
        jLabel25.setText(jComboBox6.getSelectedItem().toString());


    }//GEN-LAST:event_btnSearchActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMessageMouseClicked
        // TODO add your handling code here:
        Send s1 = new Send();
        s1.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_btnMessageMouseClicked

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
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Donor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Donor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMessage;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblExit;
    // End of variables declaration//GEN-END:variables
}
