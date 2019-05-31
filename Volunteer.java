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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class Volunteer extends javax.swing.JFrame {

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
     * Creates new form Volunteer
     */
    public Volunteer() {
        initComponents();
        jLabel27.setText("");
        jLabel28.setText("");
        jLabel29.setText("");
        jLabel30.setText("");
        jLabel31.setText("");
        jLabel32.setText("");
        jLabel33.setText("");
        jTextField1.setVisible(false);
        // Show_volunteers_In_JTable();
    }

    int sux, mox, tux, wex, thx, frx, sax;

    public ArrayList<Vol> getVolunteersList() {
        ArrayList<Vol> volunteersList = new ArrayList<Vol>();

        ResultSet rs;
        String area = jComboBox1.getSelectedItem().toString();
        String qc = "";
        try {

            Statement stmt = new DAC().getConnection().createStatement();

            if (area.equals("All")) {
                qc = "1";
                String query = "select * from volunteer where Sunday='" + su + "' or Monday ='" + mo + "' or Tuesday='" + tu + "' or Wednesday='" + we + "' or Thursday='" + th + "'or Friday='" + fr + "' or Saturday='" + sa + "'";
                rs = stmt.executeQuery(query);

                Vol volunteer;

                while (rs.next()) {
                    volunteer = new Vol(rs.getString("VolunteerID"), rs.getString("VolunteerName"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("Area"), rs.getBoolean("Monday"), rs.getBoolean("Tuesday"), rs.getBoolean("Wednesday"), rs.getBoolean("Thursday"), rs.getBoolean("Friday"), rs.getBoolean("Saturday"), rs.getBoolean("Sunday"));
                    volunteersList.add(volunteer);
                }
            } else {
                qc = "2";
                String query = "select * from  volunteer where Area ='" + area + "' and (Sunday='" + su + "' or Monday ='" + mo + "' or Tuesday='" + tu + "' or Wednesday='" + we + "' or Thursday='" + th + "'or Friday='" + fr + "' or Saturday='" + sa + "')";
                rs = stmt.executeQuery(query);

                Vol volunteer;

                while (rs.next()) {
                    volunteer = new Vol(rs.getString("VolunteerID"), rs.getString("VolunteerName"), rs.getInt("Contact"), rs.getString("Address"), rs.getString("Area"), rs.getBoolean("Monday"), rs.getBoolean("Tuesday"), rs.getBoolean("Wednesday"), rs.getBoolean("Thursday"), rs.getBoolean("Friday"), rs.getBoolean("Saturday"), rs.getBoolean("Sunday"));
                    volunteersList.add(volunteer);
                }
            }

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

            chckSa.setSelected(false);
            chckSu.setSelected(false);
            chckMo.setSelected(false);
            chckTu.setSelected(false);
            chckTh.setSelected(false);
            chckFr.setSelected(false);
            chckWe.setSelected(false);
            jTextField1.setText(qc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return volunteersList;
    }

    public void Show_volunteers_In_JTable() {

        ArrayList<Vol> list = getVolunteersList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[12];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getVolunteerId();
            row[1] = list.get(i).getVolunteerName();
            row[2] = list.get(i).getContact();
            row[3] = list.get(i).getAddress();
            row[4] = list.get(i).getArea();
            row[5] = list.get(i).getMonday();
            row[6] = list.get(i).getTuesday();
            row[7] = list.get(i).getWednesday();
            row[8] = list.get(i).getThursday();
            row[9] = list.get(i).getFriday();
            row[10] = list.get(i).getSaturday();
            row[11] = list.get(i).getSunday();

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        chckSu = new javax.swing.JCheckBox();
        chckMo = new javax.swing.JCheckBox();
        chckTu = new javax.swing.JCheckBox();
        chckWe = new javax.swing.JCheckBox();
        chckTh = new javax.swing.JCheckBox();
        chckFr = new javax.swing.JCheckBox();
        chckSa = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 370));

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

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Volunteer Details");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Area");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Available Days");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Anuradhapura", "Polonnaruwa", "Jaffna" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

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

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Go Back_50px.png"))); // NOI18N
        jLabel22.setText("Main Menu");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        chckSu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chckSu.setText("Su");
        chckSu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chckSuStateChanged(evt);
            }
        });
        chckSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckSuActionPerformed(evt);
            }
        });

        chckMo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chckMo.setText("Mo");
        chckMo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chckMoStateChanged(evt);
            }
        });

        chckTu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chckTu.setText("Tu");
        chckTu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chckTuStateChanged(evt);
            }
        });

        chckWe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chckWe.setText("We");
        chckWe.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chckWeStateChanged(evt);
            }
        });

        chckTh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chckTh.setText("Th");
        chckTh.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chckThStateChanged(evt);
            }
        });

        chckFr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chckFr.setText("Fr");
        chckFr.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chckFrStateChanged(evt);
            }
        });

        chckSa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chckSa.setText("Sa");
        chckSa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chckSaStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

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

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel26.setText("Available Days-");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel27.setText("All");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel28.setText("All");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel29.setText("All");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel30.setText("All");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel31.setText("All");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel32.setText("All");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel33.setText("All");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 125, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel29)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel30))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel33)))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_fact_1in7.png"))); // NOI18N

        jButton1.setText("SELECT ALL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblExit)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                                .addComponent(btnSearch)
                                                .addGap(29, 29, 29)))
                                        .addComponent(btnMessage))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(chckSu)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chckMo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chckTu))
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox1, 0, 1, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(chckWe)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chckTh))
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chckFr)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chckSa)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(269, 269, 269)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))))
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
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chckSu)
                                    .addComponent(chckMo)
                                    .addComponent(chckTu)
                                    .addComponent(chckWe)
                                    .addComponent(chckTh)
                                    .addComponent(chckFr)
                                    .addComponent(chckSa))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPrint)
                                    .addComponent(btnMessage)
                                    .addComponent(btnSearch)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Volunteer ID", "Name", "Contact", "Address", "Area"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMessageActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        Mmenu m1 = new Mmenu();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        jLabel27.setText("");
        jLabel28.setText("");
        jLabel29.setText("");
        jLabel30.setText("");
        jLabel31.setText("");
        jLabel32.setText("");
        jLabel33.setText("");
        jLabel25.setText(jComboBox1.getSelectedItem().toString());
        if (su == 1) {
            jLabel27.setText("Su");
        }

        if (mo == 1) {
            jLabel28.setText("Mo");
        }
        if (tu == 1) {
            jLabel29.setText("Tu");
        }
        if (we == 1) {
            jLabel30.setText("We");
        }
        if (th == 1) {
            jLabel31.setText("Th");
        }
        if (fr == 1) {
            jLabel32.setText("Fr");
        }
        if (sa == 1) {
            jLabel33.setText("Sa");
        }

        Show_volunteers_In_JTable();


    }//GEN-LAST:event_btnSearchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        try {

            int i = jTable1.getSelectedRow();

            TableModel model = jTable1.getModel();
            jComboBox1.setSelectedItem(model.getValueAt(i, 4).toString());

            // Display Slected Row In JTexteFields
            Statement stmt = new DAC().getConnection().createStatement();
            String x = (model.getValueAt(i, 0).toString());

            String query = "SELECT * FROM  volunteer WHERE Area='" + jComboBox1.getSelectedItem() + "' AND VolunteerID='" + x + "'  ";

            ResultSet rs;
            rs = stmt.executeQuery(query);

            int su1, mo1, tu1, we1, th1, fr1, sa1;
            while (rs.next()) {
                su1 = rs.getInt("Sunday");
                mo1 = rs.getInt("Monday");
                tu1 = rs.getInt("Tuesday");
                we1 = rs.getInt("Wednesday");
                th1 = rs.getInt("Thursday");
                fr1 = rs.getInt("Friday");
                sa1 = rs.getInt("Saturday");

                if (su1 == 1) {
                    chckSu.setSelected(true);
                } else {
                    chckSu.setSelected(false);
                }

                if (mo1 == 1) {
                    chckMo.setSelected(true);
                } else {
                    chckMo.setSelected(false);
                }
                if (tu1 == 1) {
                    chckTu.setSelected(true);
                } else {
                    chckTu.setSelected(false);
                }
                if (we1 == 1) {
                    chckWe.setSelected(true);
                } else {
                    chckWe.setSelected(false);
                }
                if (th1 == 1) {
                    chckTh.setSelected(true);
                } else {
                    chckTh.setSelected(false);
                }
                if (fr1 == 1) {
                    chckFr.setSelected(true);
                } else {
                    chckFr.setSelected(false);
                }
                if (sa1 == 1) {
                    chckSa.setSelected(true);
                } else {
                    chckSa.setSelected(false);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }


    }//GEN-LAST:event_jTable1MouseClicked
    int su = 2, mo = 2, tu = 2, we = 2, th = 2, fr = 2, sa = 2, wee;

    private void chckSaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chckSaStateChanged
        // TODO add your handling code here:
        if (chckSa.isSelected()) {
            sa = 1;

        } else {
            sa = 2;
        }
    }//GEN-LAST:event_chckSaStateChanged

    private void chckFrStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chckFrStateChanged
        // TODO add your handling code here:
        if (chckFr.isSelected()) {
            fr = 1;

        } else {
            fr = 2;
        }
    }//GEN-LAST:event_chckFrStateChanged

    private void chckThStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chckThStateChanged
        // TODO add your handling code here:
        if (chckTh.isSelected()) {
            th = 1;

        } else {
            th = 2;
        }
    }//GEN-LAST:event_chckThStateChanged

    private void chckWeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chckWeStateChanged
        // TODO add your handling code here:
        if (chckWe.isSelected()) {
            we = 1;

        } else {
            we = 2;
        }
    }//GEN-LAST:event_chckWeStateChanged

    private void chckTuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chckTuStateChanged
        // TODO add your handling code here:

        if (chckTu.isSelected()) {
            tu = 1;

        } else {
            tu = 2;
        }
    }//GEN-LAST:event_chckTuStateChanged

    private void chckMoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chckMoStateChanged
        // TODO add your handling code here:
        if (chckMo.isSelected()) {
            mo = 1;

        } else {
            mo = 2;
        }
    }//GEN-LAST:event_chckMoStateChanged

    private void chckSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckSuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckSuActionPerformed

    private void chckSuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chckSuStateChanged
        // TODO add your handling code here:
        if (chckSu.isSelected()) {
            su = 1;

        } else {
            su = 2;
        }
    }//GEN-LAST:event_chckSuStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        chckSa.setSelected(true);
        chckSu.setSelected(true);
        chckMo.setSelected(true);
        chckTu.setSelected(true);
        chckTh.setSelected(true);
        chckFr.setSelected(true);
        chckWe.setSelected(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        String condition = jTextField1.getText();

        try {
            getConnection();
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\Isuru\\Documents\\NetBeansProjects\\Blood\\reportvol.jrxml");
            String query = null;
            if (condition.equals("1")) {
                query = "select * from volunteer where Sunday='" + sux + "' or Monday ='" + mox + "' or Tuesday='" + tux + "' or Wednesday='" + wex + "' or Thursday='" + thx + "'or Friday='" + frx + "' or Saturday='" + sax + "'";

            } else if (condition.equals("2")) {
                query = "select * from  volunteer where Area ='" + jComboBox1.getSelectedItem() + "' and (Sunday='" + sux + "' or Monday ='" + mox + "' or Tuesday='" + tux + "' or Wednesday='" + wex + "' or Thursday='" + thx + "'or Friday='" + frx + "' or Saturday='" + sax + "')";

            }

            JRDesignQuery newQuery = new JRDesignQuery();
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
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Volunteer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Volunteer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMessage;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chckFr;
    private javax.swing.JCheckBox chckMo;
    private javax.swing.JCheckBox chckSa;
    private javax.swing.JCheckBox chckSu;
    private javax.swing.JCheckBox chckTh;
    private javax.swing.JCheckBox chckTu;
    private javax.swing.JCheckBox chckWe;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblExit;
    // End of variables declaration//GEN-END:variables
}
