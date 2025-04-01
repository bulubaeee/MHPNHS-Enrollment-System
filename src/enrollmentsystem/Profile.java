package enrollmentsystem;


import static enrollmentsystem.LogIn.txtUser;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Profile extends javax.swing.JFrame {

    int klinicksort = 0;
    int test = 1, tNum = 0, msExit = 0, saNum = 0, tmRow = 0, profPicFlag = 0, fnameLength;
    String pangkuha;
    static String user, dbsy, dbsem, smTS, smYL, arName[], arDes[], arAd[], emTS, emSY;
    Connection con;
    int px, py;
    int emCount = 0, saCount = 0, smCount = 0, rcCount = 0, tmcount = 0, rcRow = -1, trans = 0;
    int flag = 1, bago = 0, f = 0, ff = 0, h = 0, hh = 0, ctr = 0;
    static Object idSaTable = 0;
    int ind, first = 0, firstt = 0, firsttt = 0, gg = 0;
    int arrSelect[], arrGwaStemEn[], arrGwaStemMed[], stemSize;//pang kuha ng section
    String stemSec;
    Boolean sel = false, s, sa, saBool = false, tmSel, ta, ua;
    int ss = 0, count, saTblCount, res, taNum, TblCount, taTblCount, idUa, uaNum, uatblCount;
    static int id, id1, idSA, idSM, acc, tmSelected = 0, a = 0, idTr;
    String sy, sem, imagePath, scanID, path;
    String edate;
    Vector vec;
    JFileChooser jf;
    FileNameExtensionFilter filter;
    DefaultTableModel mRC;
    DefaultTableModel dtSM;

    public Profile(String username) {
        initComponents();
        user = username;
        try {

            EnrollmentForm.flg = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");
            //Statement st = con.createStatement();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("select * from tblacc");

            ResultSet rs2 = st.executeQuery("select * from tblacc");
            String mi = "".toUpperCase();
            lblUser.setText(user);

            while (rs2.next()) {
                if (rs2.getString("username").equals(username)) {
                    int ctr = 0;
                    if (rs2.getString("MiddleName").length() != 0) {
                        mi = rs2.getString("MiddleName").toUpperCase().charAt(0) + ".";
                    }
                    while (ctr < rs2.getString("MiddleName").length()) {
                        switch (rs2.getString("middlename").charAt(ctr)) {
                            case ' ':
                                mi = mi + rs2.getString("middlename").charAt(ctr + 1) + ".";
                                break;
                        }
                        ctr++;
                    }

                    lblUser.setText(rs2.getString("FirstName") + " " + mi
                            + " " + rs2.getString("LastName"));
                    lblFN1.setText(rs2.getString("FirstName") + " "
                            + " " + rs2.getString("LastName"));
                    lblname.setText(rs2.getString("FirstName") + " " + mi
                            + " " + rs2.getString("LastName"));
                    String fn = rs2.getString("FirstName") + " " + mi
                            + " " + rs2.getString("LastName");
                    fnameLength = fn.length();
                    txtfn.setText(rs2.getString("firstname"));
                    txtmn1.setText(rs2.getString("Middlename"));
                    txtln.setText(rs2.getString("Lastname"));
                    txtbd.setText(rs2.getString("bday"));
                    txtcont.setText(rs2.getString("contact"));
                    if (!rs2.getString("position").equals("Other")) {
                        lblDes.setText(rs2.getString("position"));
                    }
                    acc = rs2.getInt("admin");
                    if (fnameLength > 15) {
                        lblname.setFont(new java.awt.Font("Times New Roman", 1, 24));
                    }

                    if (lblFN1.getText().length() > 15) {
                        lblFN1.setFont(new java.awt.Font("Times New Roman", 1, 12));
                    } else {
                        lblFN1.setFont(new java.awt.Font("Times New Roman", 1, 20));
                    }

                    break;
                }
            }

            CBSort();
            CBSmTs();
            CBSmYl();
            cbSchoolYear();
            Semester();//WAG NG GALAWIN ANG PWESTO

           Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
           // Statement st3 = con.createStatement();
            ResultSet rs3 = st3.executeQuery("select * from poweruser");
            rs3.absolute(1);

            CBSY.setSelectedIndex(rs3.getInt("sy_index"));//WAG NG GALAWIN ANG PWESTO
            CBS.setSelectedIndex(rs3.getInt("sem_index"));
            emTS = (String) emStrand.getSelectedItem();
            emSY = (String) emYL.getSelectedItem();

           // Statement st1 = con.createStatement();
            Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = st1.executeQuery("select * from tblprof");

//            if (acc == 0) {//PAG USER ANG NAKA LOG IN
//                CBSY.setVisible(false);
//                lblSY.setText(CBSY.getItemAt(hh));
//                CBS.setVisible(false);
//                lblSem.setText(CBS.getItemAt(h));
//                btnAdd.setVisible(false);
//                btnArchive.setVisible(false);
//                btnProm.setVisible(false);
//                pnlEH.setVisible(false);
//                pnlRC.setVisible(false);
//                pnlSA.setVisible(false);
//                Select.setVisible(false);
//                lblSel.setVisible(false);
//                btnTMmove.setVisible(false);
//                btnTmAdd.setVisible(false);
//                jButton5.setVisible(false);
//                btnTmAdv.setVisible(false);
//                pnlUO.setBounds(1250, 195, 330, 210);
//                lbladorus.setText("User");
                  lbladorus.setText("Admin");
//            } else {//PAG ADMIN ANG NAKA LOG IN
//                lbladorus.setText("Admin");
//            }

          //  Statement st5 = con.createStatement();
          Statement st5 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs5 = st5.executeQuery("select * from images");
            while (rs5.next()) {
                if (txtUser.getText().equals(rs5.getString("user"))) {
                    lblGC.setIcon(ResizeImage(rs5.getString("path")));
                } else {
                    profPicFlag = 1;
                }
            }

            TeacherMasterlist();
            //  StudentMasterlist();

        } catch (Exception e) {
            System.err.println(e);
        }
    }//end ng InitComponents

    public void CBSmTs() throws Exception {
        DefaultComboBoxModel smTS = new DefaultComboBoxModel();
        cbSmTs.setModel(smTS);
        cbSmTs.addItem("Strand");
        cbSmTs.addItem("TVL");
        cbSmTs.addItem("STEM");
        cbSmTs.addItem("ABM");
        cbSmTs.addItem("Arts and Design");
        cbSmTs.addItem("Sports");
        cbSmTs.addItem("HUMSS");
    }

    public void CBSmYl() throws Exception {
        DefaultComboBoxModel smYl = new DefaultComboBoxModel();
        cbSmYl.setModel(smYl);
        cbSmYl.addItem("Year Level");
        cbSmYl.addItem("GRADE 11");
        cbSmYl.addItem("GRADE 12");
    }

    public void RequirementChecklist() {
        rcCount = 0;
        try {
            mRC = new DefaultTableModel();
            tblRC.setModel(mRC);
            tblRC = new JTable(mRC) {
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return String.class;
                        case 1:
                            return String.class;
                        case 9:
                            return String.class;
                        case 8:
                            return float.class;
                        default:
                            return Boolean.class;
                    }
                }

                public boolean isCellEditable(int row, int column) {
                    switch (column) {
                        case 0:
                            return false;
                        case 1:
                            return false;
                        case 8:
                            return false;
                        default:
                            return true;
                    }

                }
            };

            mRC.addColumn("LRN");
            mRC.addColumn("FULL NAME");
            mRC.addColumn("   EF");
            mRC.addColumn("   GC");
            mRC.addColumn("   F137");
            mRC.addColumn("   PSA");
            mRC.addColumn("   GM");
            mRC.addColumn("   NCAE");
            mRC.addColumn("GWA");
            mRC.addColumn("NO.");

            tblRC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblRC.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblRC.getColumnModel().getColumn(1).setPreferredWidth(340);
            tblRC.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(5).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(7).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(8).setPreferredWidth(60);
            tblRC.getColumnModel().getColumn(9).setPreferredWidth(60);
            tblRC.setRowHeight(35);

           // Statement st3 = con.createStatement();
           Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs3 = st3.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");

            while (rs3.next()) {
                if (rs3.getString("semester").equals(dbsem) && rs3.getString("sy").equals(dbsy)) {
                    if (rs3.getInt("archived") == 1) {
                    } else {
                        Vector vec2 = new Vector();
                        vec2.add(rs3.getString("LRN"));
                        vec2.add(rs3.getString("full_name"));
                        vec2.add(rs3.getBoolean("e_form"));
                        vec2.add(rs3.getBoolean("g_card"));
                        vec2.add(rs3.getBoolean("f137"));
                        vec2.add(rs3.getBoolean("nso"));
                        vec2.add(rs3.getBoolean("gm"));
                        vec2.add(rs3.getBoolean("ncae"));
                        if (rs3.getString("gwa").equals("")) {
                            vec2.add("N/A");
                        } else {
                            vec2.add(rs3.getString("gwa"));
                        }
                        vec2.add(rs3.getString("id"));
                        rcCount++;
                        mRC.addRow(vec2);
                    }
                }
            }

            tblRC.setSelectionMode(SINGLE_SELECTION);
            tblRC.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblRC.getTableHeader().setResizingAllowed(false);
            tblRC.getTableHeader().setReorderingAllowed(false);
            tblRC.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
            tblRC.setFont(new java.awt.Font("Times New Roman", 0, 16));

            tblRC.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblRCMouseClicked(evt);
                }
            });

            lblCount2.setText(rcCount + "");
            tblRC.setCellSelectionEnabled(true);
            scrollpane.setViewportView(tblRC);
        } catch (Exception e) {
            System.err.println(e);
        }
    }//END NG REQUIREMENTS CHECKLIST

    public void StudentMasterlist() throws Exception {
        smCount = 0;
        dtSM = new DefaultTableModel();
        tblSM.setModel(dtSM);

        tblSM = new JTable(dtSM) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        dtSM.addColumn("LRN");
        dtSM.addColumn("FULL NAME");
        dtSM.addColumn("SECTION");
        dtSM.addColumn("Student Type");
        dtSM.addColumn("YEAR LEVEL");
        dtSM.addColumn("DATE ADDED");
        dtSM.addColumn("STATUS");
        dtSM.addColumn("NO.");

        tblSM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblSM.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblSM.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblSM.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblSM.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblSM.getColumnModel().getColumn(4).setPreferredWidth(170);
        tblSM.getColumnModel().getColumn(5).setPreferredWidth(130);
        tblSM.getColumnModel().getColumn(6).setPreferredWidth(130);
        tblSM.getColumnModel().getColumn(7).setPreferredWidth(70);
        tblSM.setRowHeight(35);

        tblSM.setSelectionMode(SINGLE_SELECTION);
        tblSM.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblSM.getTableHeader().setResizingAllowed(false);
        tblSM.getTableHeader().setReorderingAllowed(false);
        tblSM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
        tblSM.setFont(new java.awt.Font("Times New Roman", 0, 14));

//        Statement st = con.createStatement();
Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");

        while (rs.next()) {
            if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                if (rs.getInt("archived") == 0) {
                    if (!rs.getString("section").equals("PRE-AD")) {
                        Vector vec = new Vector();
                        vec.add(rs.getString("lrn"));
                        if (rs.getString("mname").equals("")) {
                            vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                        } else {
                            vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                        }
                        vec.add(rs.getString("section"));
                        vec.add(rs.getString("student_type"));
                        vec.add(rs.getString("eag"));
                        vec.add(rs.getString("date"));
                        vec.add(rs.getString("status"));
                        vec.add(rs.getString("id"));

                        smCount++;
                        dtSM.addRow(vec);
                    }
                }
            }
        }

        tblSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSMMouseClicked(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSMMouseReleased(evt);
            }
        });

        lblSmCount.setText(smCount + "");
        spTBL.setViewportView(tblSM);
    }//end ng studentmasterlist

    public void TeacherMasterlist() throws Exception {
        tmcount = 0;
        DefaultTableModel dtTM = new DefaultTableModel();
        tblTM.setModel(dtTM);

        tblTM = new JTable(dtTM) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 0:
                        return true;
                    default:
                        return false;
                }

            }
        };

        dtTM.addColumn("");
        dtTM.addColumn("FULL NAME");
        dtTM.addColumn("Designation");
        dtTM.addColumn("Advisory Class");
        dtTM.addColumn("ID");

        tblTM.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblTM.getColumnModel().getColumn(1).setPreferredWidth(450);
        tblTM.getColumnModel().getColumn(2).setPreferredWidth(435);
        tblTM.getColumnModel().getColumn(3).setPreferredWidth(390);
        tblTM.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblTM.setRowHeight(35);

        tblTM.setSelectionMode(SINGLE_SELECTION);
        tblTM.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblTM.getTableHeader().setResizingAllowed(false);
        tblTM.getTableHeader().setReorderingAllowed(false);
        tblTM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
        tblTM.setFont(new java.awt.Font("Times New Roman", 0, 14));

      //  Statement st = con.createStatement();
      Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from tbltm;");

        while (rs.next()) {
            if (!rs.getString("desig").equals("principal")) {
                if (rs.getInt("archive") != 1) {
                    Vector vec = new Vector();
                    vec.add(false);
                    vec.add(rs.getString("fname") + ", " + rs.getString("mname") + ", " + rs.getString("lname"));
                    if (rs.getString("desig").equals("Other")) {
                        vec.add("N/A");
                    } else {
                        vec.add(rs.getString("desig"));
                    }
                    vec.add(rs.getString("advisory"));
                    vec.add(rs.getString("id"));
                    dtTM.addRow(vec);
                    tmcount++;
                }
            }
        }
        tblTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTMMouseClicked(evt);
            }
        });

        lblTmCount.setText(tmcount + "");
        spTM.setViewportView(tblTM);

    }//end ng Teachermasterlist

    public void CBSort() throws Exception {
        DefaultComboBoxModel dcSort = new DefaultComboBoxModel();
        cbSort.setModel(dcSort);
        cbSort.addItem("Name Ascending");
        cbSort.addItem("Name Descending");
        cbSort.addItem("Status Pending");
        cbSort.addItem("Status Enrolled");
    }

    public void cbSchoolYear() {
        DefaultComboBoxModel mCBSC = new DefaultComboBoxModel();
        CBSY.setModel(mCBSC);
        CBSY.addItem("Click Here");
        int nyear = 2020;
        for (int i = 2019; i <= 2080; i++) {
            CBSY.addItem(i + "-" + nyear);
            nyear++;
        }

    }

    public void Semester() {
        DefaultComboBoxModel mCBS = new DefaultComboBoxModel();
        CBS.setModel(mCBS);
        CBS.addItem("Click Here");
        CBS.addItem("First Semester");
        CBS.addItem("Second Semester");
    }

    public void emDisplay() {
        ss = 0;
        count = 0;
        DefaultTableModel dtmEM = new DefaultTableModel();
        tblEM.setModel(dtmEM);

        tblEM = new JTable(dtmEM) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 0:
                        return true;
                    default:
                        return false;
                }

            }

        };

        try {
            emCount = 0;
            dtmEM.addColumn("");
            dtmEM.addColumn("LRN");
            dtmEM.addColumn("FULL NAME");
            dtmEM.addColumn("GRADE");
            dtmEM.addColumn("SECTION");
            dtmEM.addColumn("STUDENT TYPE");
            dtmEM.addColumn("DATE");
            dtmEM.addColumn("NO.");

            tblEM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblEM.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblEM.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblEM.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblEM.getColumnModel().getColumn(3).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(4).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(5).setPreferredWidth(255);
            tblEM.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblEM.getColumnModel().getColumn(7).setPreferredWidth(50);
            tblEM.setRowHeight(35);//a

            tblEM.setSelectionMode(SINGLE_SELECTION);
            tblEM.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblEM.getTableHeader().setResizingAllowed(false);
            tblEM.getTableHeader().setReorderingAllowed(false);
            tblEM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));//aa

           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id;");

            while (rs.next()) {
                ss++;
                if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                    if (rs.getInt("archived") == 1) {
                    } else {
                        count++;
                        vec = new Vector();
                        vec.add(sel);
                        vec.add(rs.getString("LRN"));
                        if (rs.getString("mname").equals("")) {
                            vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                        } else {
                            vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                        }
                        vec.add(rs.getString("eag"));
                        vec.add(rs.getString("section"));
                        if (rs.getString("section").equals("PRE-AD")) {
                            vec.add(rs.getString("student_type") + " (PRE-AD)");
                        } else {
                            vec.add(rs.getString("student_type"));
                        }
                        vec.add(rs.getString("date"));
                        vec.add(rs.getInt("id"));
                        dtmEM.addRow(vec);
                        arrSelect = new int[ss];
                        emCount++;
                    }
                }
            }

            tblEM.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblEMMouseClicked(evt);
                }
            });

            lblCount.setText(emCount + "");
            jScrollPane1.setViewportView(tblEM);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//end ng emDisplay

    public void saDisplay() {
        try {
            saTblCount = 0;
            saCount = 0;
            DefaultTableModel dtmSA = new DefaultTableModel();
            tblSA.setModel(dtmSA);
            tblSA = new JTable(dtmSA) {
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return Boolean.class;
                        default:
                            return String.class;
                    }
                }
            };
            dtmSA.addColumn("");
            dtmSA.addColumn("LRN");
            dtmSA.addColumn("Last Name");
            dtmSA.addColumn("FIrst Name");
            dtmSA.addColumn("Middle Name");
            dtmSA.addColumn("Date archived");
            dtmSA.addColumn("Reason");
            dtmSA.addColumn("Age");
            dtmSA.addColumn("Birthday");
            dtmSA.addColumn("Birthplace");
            dtmSA.addColumn("Gender");
            dtmSA.addColumn("Citizenship");
            dtmSA.addColumn("Religion");
            dtmSA.addColumn("NO.");

            tblSA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblSA.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblSA.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblSA.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblSA.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblSA.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblSA.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblSA.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblSA.getColumnModel().getColumn(7).setPreferredWidth(50);
            tblSA.getColumnModel().getColumn(8).setPreferredWidth(150);
            tblSA.getColumnModel().getColumn(9).setPreferredWidth(500);
            tblSA.getColumnModel().getColumn(10).setPreferredWidth(80);
            tblSA.getColumnModel().getColumn(11).setPreferredWidth(150);
            tblSA.getColumnModel().getColumn(12).setPreferredWidth(150);
            tblSA.getColumnModel().getColumn(13).setPreferredWidth(50);
            tblSA.setRowHeight(35);

            tblSA.setSelectionMode(SINGLE_SELECTION);
            tblSA.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblSA.getTableHeader().setResizingAllowed(false);
            tblSA.getTableHeader().setReorderingAllowed(false);
            tblSA.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 14));
            tblSA.setFont(new java.awt.Font("Times New Roman", 0, 16));

//            Statement st = con.createStatement();
Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");

            while (rs.next()) {
                if (rs.getInt("archived") == 1) {
                    saTblCount++;
                    vec = new Vector();
                    vec.add(saBool);
                    vec.add(rs.getString("LRN"));
                    vec.add(rs.getString("lname"));
                    vec.add(rs.getString("fname"));
                    vec.add(rs.getString("mname"));
                    vec.add(rs.getString("date_archived"));
                    vec.add(rs.getString("reason"));
                    vec.add(rs.getString("age"));
                    vec.add(rs.getString("bdate"));
                    vec.add(rs.getString("bplace"));
                    vec.add(rs.getString("gender"));
                    vec.add(rs.getString("citizenship"));
                    vec.add(rs.getString("religion"));
                    vec.add(rs.getInt("id"));
                    dtmSA.addRow(vec);
                    saCount++;
                } else {
                }
            }

            tblSA.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblSAMouseClicked(evt);
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    tblSAMouseReleased(evt);
                }
            });

            lblCount1.setText(saCount + "");
            scrlSA.setViewportView(tblSA);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void TeachersArchive() throws Exception {
        taTblCount = 0;
        // trCount = 0;

        try {
            DefaultTableModel dtmTa = new DefaultTableModel();
            tblTa.setModel(dtmTa);
            tblTa = new JTable(dtmTa) {
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return Boolean.class;
                        default:
                            return String.class;
                    }
                }
            };
            dtmTa.addColumn("");
            dtmTa.addColumn("First Name");
            dtmTa.addColumn("Middle Name");
            dtmTa.addColumn("Last Name");
            dtmTa.addColumn("Designation");
            dtmTa.addColumn("advisory");
            dtmTa.addColumn("id");

            tblTa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblTa.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblTa.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblTa.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblTa.getColumnModel().getColumn(3).setPreferredWidth(215);
            tblTa.getColumnModel().getColumn(4).setPreferredWidth(255);
            tblTa.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblTa.getColumnModel().getColumn(6).setPreferredWidth(50);

            tblTa.setRowHeight(35);

            tblTa.setSelectionMode(SINGLE_SELECTION);
            tblTa.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblTa.getTableHeader().setResizingAllowed(false);
            tblTa.getTableHeader().setReorderingAllowed(false);
            tblTa.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 14));
            tblTa.setFont(new java.awt.Font("Times New Roman", 0, 16));

        //    Statement st = con.createStatement();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tbltm");

            while (rs.next()) {
                if (rs.getInt("archive") == 1) {
                    taTblCount++;
                    vec = new Vector();
                    vec.add(false);
                    vec.add(rs.getString("fname"));
                    vec.add(rs.getString("mname"));
                    vec.add(rs.getString("lname"));
                    vec.add(rs.getString("desig"));
                    vec.add("N/A"/*rs.getString("advisory")*/);
                    vec.add(rs.getString("id"));
                    dtmTa.addRow(vec);
                    //saCount++;
                } else {
                }
            }

            tblTa.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblTaMouseClicked(evt);
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    tblTaMouseReleased(evt);
                }
            });

            lblCount3.setText(taTblCount + "");
            scrlTA.setViewportView(tblTa);

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUO = new javax.swing.JPanel();
        lblFN1 = new javax.swing.JLabel();
        pnlCP = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pnlEP = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblviewprofile = new javax.swing.JLabel();
        lblUserprof = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        eks = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        PSelect = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        pnlEM = new javax.swing.JPanel();
        lblEM = new javax.swing.JLabel();
        pnlSM = new javax.swing.JPanel();
        lblSM = new javax.swing.JLabel();
        pnlRC = new javax.swing.JPanel();
        lblRC = new javax.swing.JLabel();
        pnlSA = new javax.swing.JPanel();
        lblSA = new javax.swing.JLabel();
        pnlES = new javax.swing.JPanel();
        lblES = new javax.swing.JLabel();
        pnlTM = new javax.swing.JPanel();
        lblReport = new javax.swing.JLabel();
        pnlEH = new javax.swing.JPanel();
        lblEH = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();
        PHOME = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PEM = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnEmLoad = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cbEmSort = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        emYL = new javax.swing.JComboBox<>();
        emStrand = new javax.swing.JComboBox<>();
        lblSearch = new javax.swing.JLabel();
        Select = new javax.swing.JCheckBox();
        pnlSR = new javax.swing.JPanel();
        eto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEM = new javax.swing.JTable();
        LBLENROLL1 = new javax.swing.JLabel();
        LBLENROLL2 = new javax.swing.JLabel();
        txtFSearch = new javax.swing.JTextField();
        LBLENROLL3 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CBS = new javax.swing.JComboBox<>();
        CBSY = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnlEF = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnArchive = new javax.swing.JButton();
        CBReason = new javax.swing.JComboBox<>();
        lblCount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSem = new javax.swing.JLabel();
        lblSY = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        btnProm = new javax.swing.JButton();
        lblSel = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        PSM = new javax.swing.JPanel();
        LBLENROLL6 = new javax.swing.JLabel();
        LBLENROLL7 = new javax.swing.JLabel();
        panelSM = new javax.swing.JPanel();
        panelSMTBL = new javax.swing.JPanel();
        spTBL = new javax.swing.JScrollPane();
        tblSM = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        cbSmYl = new javax.swing.JComboBox<>();
        cbSmTs = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbSort = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblSmCount = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        pnlSub = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSubj = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtSmSy = new javax.swing.JTextField();
        txtSmSem = new javax.swing.JTextField();
        txtSmSn = new javax.swing.JTextField();
        txtSmDe = new javax.swing.JTextField();
        txtSmLrn = new javax.swing.JTextField();
        txtSmTs = new javax.swing.JTextField();
        txtSmGl = new javax.swing.JTextField();
        txtSmSec = new javax.swing.JTextField();
        btnSmBack = new javax.swing.JButton();
        LBLENROLL17 = new javax.swing.JLabel();
        btnSmPrint = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lblSmSearch = new javax.swing.JLabel();
        txtSmSearch = new javax.swing.JTextField();
        PTM = new javax.swing.JPanel();
        LBLENROLL14 = new javax.swing.JLabel();
        LBLENROLL15 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblTmCount = new javax.swing.JLabel();
        cbTmSort = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        btnTmSave = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        lblTmSel = new javax.swing.JLabel();
        lblTmlist = new javax.swing.JLabel();
        txtTmSearch = new javax.swing.JTextField();
        pnlTmCard = new javax.swing.JPanel();
        spTM = new javax.swing.JScrollPane();
        tblTM = new javax.swing.JTable();
        pnlTmAdd = new javax.swing.JPanel();
        txtTmUser = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtTmUser1 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtTmUser2 = new javax.swing.JTextField();
        cbPos = new javax.swing.JComboBox<>();
        jLabel78 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        txtTmUser3 = new javax.swing.JTextField();
        btnTmAdd = new javax.swing.JButton();
        btnTmBack = new javax.swing.JButton();
        btnTMmove = new javax.swing.JButton();
        btnTmAdv = new javax.swing.JButton();
        cbTmSec = new javax.swing.JComboBox<>();
        PRC = new javax.swing.JPanel();
        LBLENROLL8 = new javax.swing.JLabel();
        LBLENROLL9 = new javax.swing.JLabel();
        lblChecklist = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCount2 = new javax.swing.JLabel();
        txtRcSearch = new javax.swing.JTextField();
        btnV = new javax.swing.JButton();
        pnlRcMain = new javax.swing.JPanel();
        pnlRc1 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        tblRC = new javax.swing.JTable();
        pnlRc2 = new javax.swing.JPanel();
        txtRcLrn = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtRcFn = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        cbRcSearch = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlCard = new javax.swing.JPanel();
        p = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        pnlGcard = new javax.swing.JPanel();
        pnlForm137 = new javax.swing.JPanel();
        lblF = new javax.swing.JLabel();
        pnlBC = new javax.swing.JPanel();
        lblBday = new javax.swing.JLabel();
        pnlGM = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        pnlNcae = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        btnRcBack = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        PSA = new javax.swing.JPanel();
        LBLENROLL12 = new javax.swing.JLabel();
        LBLENROLL13 = new javax.swing.JLabel();
        cbArch = new javax.swing.JComboBox<>();
        lblSearch4 = new javax.swing.JLabel();
        pnlArch = new javax.swing.JPanel();
        pnlAr = new javax.swing.JPanel();
        scrlSA = new javax.swing.JScrollPane();
        tblSA = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblCount1 = new javax.swing.JLabel();
        btnRet = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        cbSa = new javax.swing.JCheckBox();
        lblSaSelect = new javax.swing.JLabel();
        pnlTr = new javax.swing.JPanel();
        scrlTA = new javax.swing.JScrollPane();
        tblTa = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnTaDel = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        lblCount3 = new javax.swing.JLabel();
        pnlUr = new javax.swing.JPanel();
        scrlUA = new javax.swing.JScrollPane();
        tblUa = new javax.swing.JTable();
        btnUaRet = new javax.swing.JButton();
        btnUaDel = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        lblCount4 = new javax.swing.JLabel();
        PCR = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        cbSY = new javax.swing.JComboBox<>();
        cbSec = new javax.swing.JComboBox<>();
        LBLENROLL10 = new javax.swing.JLabel();
        LBLENROLL11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        pnlCL = new javax.swing.JPanel();
        PNLCR = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lblSec = new javax.swing.JLabel();
        lblTrack = new javax.swing.JLabel();
        lblSYear = new javax.swing.JLabel();
        lblSEM = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        lblCrAd = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtaFem = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtaMale = new javax.swing.JTextArea();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lblMarceloLogo = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        LBLMHPNHS = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lbldivision = new javax.swing.JLabel();
        lbldivision2 = new javax.swing.JLabel();
        lbldivision1 = new javax.swing.JLabel();
        lblDep = new javax.swing.JLabel();
        btnClLoad = new javax.swing.JButton();
        cbSem = new javax.swing.JComboBox<>();
        cbLvl = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        PDO = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblfn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtfn = new javax.swing.JTextField();
        txtln = new javax.swing.JTextField();
        txtmn1 = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        btned = new javax.swing.JButton();
        lbladorus = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblDes = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtcont = new javax.swing.JTextField();
        txtbd = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnBro = new javax.swing.JButton();
        btnSv = new javax.swing.JButton();
        lblGC = new javax.swing.JLabel();
        PEH = new javax.swing.JPanel();
        LBLENROLL4 = new javax.swing.JLabel();
        LBLENROLL5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEH = new javax.swing.JTable();
        btnCH = new javax.swing.JButton();
        btnEHPrint = new javax.swing.JButton();
        lblAudit = new javax.swing.JLabel();
        txtAudit = new javax.swing.JTextField();
        PBackground = new javax.swing.JPanel();
        pnlLog = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnlDO = new javax.swing.JPanel();
        lblDO3 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblBg1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlUO.setBackground(new java.awt.Color(102, 102, 102));
        pnlUO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pnlUOFocusLost(evt);
            }
        });
        pnlUO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlUOMouseExited(evt);
            }
        });
        pnlUO.setLayout(null);

        lblFN1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblFN1.setForeground(new java.awt.Color(255, 255, 255));
        lblFN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFN1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlUO.add(lblFN1);
        lblFN1.setBounds(120, 40, 190, 30);

        pnlCP.setBackground(new java.awt.Color(102, 102, 102));
        pnlCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCPMouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/changepass white.png"))); // NOI18N
        jLabel22.setText("    Change Password");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlCPLayout = new javax.swing.GroupLayout(pnlCP);
        pnlCP.setLayout(pnlCPLayout);
        pnlCPLayout.setHorizontalGroup(
            pnlCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        pnlCPLayout.setVerticalGroup(
            pnlCPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCPLayout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlUO.add(pnlCP);
        pnlCP.setBounds(0, 140, 330, 50);
        pnlCP.setBackground(new java.awt.Color(102, 102, 102));

        pnlEP.setBackground(new java.awt.Color(102, 102, 102));
        pnlEP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEPMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/Admins Option.png"))); // NOI18N
        jLabel11.setText("   User Accounts");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlEPLayout = new javax.swing.GroupLayout(pnlEP);
        pnlEP.setLayout(pnlEPLayout);
        pnlEPLayout.setHorizontalGroup(
            pnlEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEPLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        pnlEPLayout.setVerticalGroup(
            pnlEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlEP.setBackground(new java.awt.Color(102, 102, 102));

        pnlUO.add(pnlEP);
        pnlEP.setBounds(0, 210, 330, 50);

        lblviewprofile.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        lblviewprofile.setForeground(new java.awt.Color(204, 204, 204));
        lblviewprofile.setText("View Profile");
        lblviewprofile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblviewprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblviewprofileMouseClicked(evt);
            }
        });
        pnlUO.add(lblviewprofile);
        lblviewprofile.setBounds(170, 80, 90, 17);

        lblUserprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/userprofile.png"))); // NOI18N
        pnlUO.add(lblUserprof);
        lblUserprof.setBounds(40, 20, 80, 100);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("__________________________");
        pnlUO.add(jLabel23);
        jLabel23.setBounds(10, 80, 320, 50);

        getContentPane().add(pnlUO);
        pnlUO.setBounds(1250, 195, 330, 290);
        pnlUO.setVisible(false);

        jPanel3.setBackground(new java.awt.Color(50, 100, 49));
        jPanel3.setLayout(null);

        eks.setBackground(new java.awt.Color(255, 255, 255));
        eks.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        eks.setForeground(new java.awt.Color(255, 255, 255));
        eks.setText("x");
        eks.setToolTipText("EXIT");
        eks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eksMouseExited(evt);
            }
        });
        jPanel3.add(eks);
        eks.setBounds(6, 0, 13, 32);

        min.setBackground(new java.awt.Color(255, 255, 255));
        min.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        min.setForeground(new java.awt.Color(255, 255, 255));
        min.setText("-");
        min.setToolTipText("Minimize");
        min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minMouseExited(evt);
            }
        });
        jPanel3.add(min);
        min.setBounds(10, 40, 8, 32);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(1670, 0, 30, 970);

        PSelect.setBackground(new java.awt.Color(50, 100, 49));
        PSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PSelectMouseEntered(evt);
            }
        });
        PSelect.setLayout(null);

        pnlHome.setBackground(new java.awt.Color(51, 102, 0));
        pnlHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlHomeMouseExited(evt);
            }
        });
        pnlHome.setLayout(null);

        lblHome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/hOME.png"))); // NOI18N
        lblHome.setText("             Home");
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHome.add(lblHome);
        lblHome.setBounds(30, 0, 220, 73);

        PSelect.add(pnlHome);
        pnlHome.setBounds(0, 0, 310, 70);
        pnlHome.setVisible(true);
        pnlHome.setBackground(new java.awt.Color(0, 73, 0));

        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEMMouseExited(evt);
            }
        });

        lblEM.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEM.setForeground(new java.awt.Color(255, 255, 255));
        lblEM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/Enrollment Module icon.png"))); // NOI18N
        lblEM.setText("    Enrollment Module");
        lblEM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlEMLayout = new javax.swing.GroupLayout(pnlEM);
        pnlEM.setLayout(pnlEMLayout);
        pnlEMLayout.setHorizontalGroup(
            pnlEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEMLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblEM, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnlEMLayout.setVerticalGroup(
            pnlEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PSelect.add(pnlEM);
        pnlEM.setBounds(0, 80, 310, 70);

        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSMMouseExited(evt);
            }
        });
        pnlSM.setLayout(null);

        lblSM.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSM.setForeground(new java.awt.Color(255, 255, 255));
        lblSM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/QWERT.PNG"))); // NOI18N
        lblSM.setText("   Student Masterlist");
        lblSM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSM.add(lblSM);
        lblSM.setBounds(30, 10, 230, 50);

        PSelect.add(pnlSM);
        pnlSM.setBounds(0, 160, 310, 70);

        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlRCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlRCMouseExited(evt);
            }
        });
        pnlRC.setLayout(null);

        lblRC.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblRC.setForeground(new java.awt.Color(255, 255, 255));
        lblRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/checklistedited.png"))); // NOI18N
        lblRC.setText("Requirements Checklist");
        lblRC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlRC.add(lblRC);
        lblRC.setBounds(30, 10, 242, 45);

        PSelect.add(pnlRC);
        pnlRC.setBounds(0, 400, 310, 70);

        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSAMouseExited(evt);
            }
        });
        pnlSA.setLayout(null);

        lblSA.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSA.setForeground(new java.awt.Color(255, 255, 255));
        lblSA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/student archive.png"))); // NOI18N
        lblSA.setText("          Archive");
        lblSA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSA.add(lblSA);
        lblSA.setBounds(30, 10, 220, 45);

        PSelect.add(pnlSA);
        pnlSA.setBounds(0, 480, 310, 70);

        pnlES.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlESMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlESMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlESMouseExited(evt);
            }
        });
        pnlES.setLayout(null);

        lblES.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblES.setForeground(new java.awt.Color(255, 255, 255));
        lblES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/teacher.png"))); // NOI18N
        lblES.setText("  Teacher Masterlist");
        lblES.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlES.add(lblES);
        lblES.setBounds(26, 0, 260, 70);

        PSelect.add(pnlES);
        pnlES.setBounds(0, 240, 310, 70);

        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlTMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlTMMouseExited(evt);
            }
        });
        pnlTM.setLayout(null);

        lblReport.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblReport.setForeground(new java.awt.Color(255, 255, 255));
        lblReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/63 copy.png"))); // NOI18N
        lblReport.setText("    Classlist Report");
        lblReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlTM.add(lblReport);
        lblReport.setBounds(27, 10, 250, 50);

        PSelect.add(pnlTM);
        pnlTM.setBounds(0, 320, 310, 70);

        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEHMouseExited(evt);
            }
        });
        pnlEH.setLayout(null);

        lblEH.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEH.setForeground(new java.awt.Color(255, 255, 255));
        lblEH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/historYEDITED.PNG"))); // NOI18N
        lblEH.setText("           History");
        lblEH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlEH.add(lblEH);
        lblEH.setBounds(30, 10, 220, 46);

        PSelect.add(pnlEH);
        pnlEH.setBounds(0, 560, 310, 70);

        getContentPane().add(PSelect);
        PSelect.setBounds(0, 196, 310, 760);

        Panel.setBorder(new javax.swing.border.MatteBorder(null));
        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelMouseEntered(evt);
            }
        });
        Panel.setLayout(new java.awt.CardLayout());

        PHOME.setBackground(new java.awt.Color(255, 255, 255));
        PHOME.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/DITO NGA!/HOMEPAGEFINALLL.png"))); // NOI18N
        PHOME.add(jLabel5);
        jLabel5.setBounds(0, 0, 1360, 760);

        Panel.add(PHOME, "card1");

        PEM.setBackground(new java.awt.Color(255, 255, 255));
        PEM.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setLayout(null);

        btnEmLoad.setBackground(new java.awt.Color(255, 255, 255));
        btnEmLoad.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnEmLoad.setText("Load");
        btnEmLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmLoadActionPerformed(evt);
            }
        });
        jPanel7.add(btnEmLoad);
        btnEmLoad.setBounds(360, 80, 100, 25);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton6);
        jButton6.setBounds(470, 80, 90, 25);

        cbEmSort.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbEmSort.setForeground(new java.awt.Color(255, 255, 255));
        cbEmSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name Ascending", "Name Descending" }));
        cbEmSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmSortActionPerformed(evt);
            }
        });
        jPanel7.add(cbEmSort);
        cbEmSort.setBounds(90, 20, 170, 25);

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel81.setText("Sort by:");
        jPanel7.add(jLabel81);
        jLabel81.setBounds(30, 16, 70, 25);

        jLabel82.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel82.setText("Filter Records:");
        jPanel7.add(jLabel82);
        jLabel82.setBounds(270, 20, 110, 25);

        emYL.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        emYL.setForeground(new java.awt.Color(255, 255, 255));
        emYL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year Level", "GRADE 11", "GRADE 12" }));
        emYL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emYLActionPerformed(evt);
            }
        });
        jPanel7.add(emYL);
        emYL.setBounds(380, 50, 170, 25);

        emStrand.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        emStrand.setForeground(new java.awt.Color(255, 255, 255));
        emStrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Strand", "TVL", "STEM", "ABM", "Arts and Design", "Sports", "HUMSS" }));
        emStrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emStrandActionPerformed(evt);
            }
        });
        jPanel7.add(emStrand);
        emStrand.setBounds(380, 20, 170, 25);

        PEM.add(jPanel7);
        jPanel7.setBounds(688, 100, 570, 120);
        jPanel7.setVisible(false);

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/search.png"))); // NOI18N
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });
        PEM.add(lblSearch);
        lblSearch.setBounds(1290, 30, 50, 40);

        Select.setBackground(new java.awt.Color(255, 255, 255));
        Select.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });
        PEM.add(Select);
        Select.setBounds(30, 200, 30, 19);

        pnlSR.setBackground(new java.awt.Color(255, 255, 255));
        pnlSR.setOpaque(false);
        pnlSR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSRMouseEntered(evt);
            }
        });
        pnlSR.setLayout(null);

        eto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/gear-animation-green.gif"))); // NOI18N
        eto.setVisible(false);
        pnlSR.add(eto);
        eto.setBounds(8, 20, 1310, 460);

        tblEM.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblEM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblEM.setDragEnabled(false);
        tblEM.setEnabled(false);
        tblEM.setOpaque(false);
        tblEM.setRowHeight(25);
        tblEM.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblEM.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEM.getTableHeader().setResizingAllowed(false);
        tblEM.getTableHeader().setReorderingAllowed(false);
        tblEM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblEMFocusLost(evt);
            }
        });
        tblEM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEMMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEMMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEM);

        pnlSR.add(jScrollPane1);
        jScrollPane1.setBounds(8, 13, 1320, 467);

        PEM.add(pnlSR);
        pnlSR.setBounds(10, 220, 1340, 480);

        LBLENROLL1.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        LBLENROLL1.setForeground(new java.awt.Color(102, 102, 102));
        LBLENROLL1.setText("_________________________________________________________________________________________________________");
        PEM.add(LBLENROLL1);
        LBLENROLL1.setBounds(0, 60, 1370, 40);

        LBLENROLL2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL2.setForeground(new java.awt.Color(255, 0, 0));
        LBLENROLL2.setText("Student Records");
        PEM.add(LBLENROLL2);
        LBLENROLL2.setBounds(20, 170, 190, 30);

        txtFSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtFSearch.setText(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)");
        txtFSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtFSearch.setText(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)");
        txtFSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFSearchFocusLost(evt);
            }
        });
        txtFSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFSearchMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFSearchMousePressed(evt);
            }
        });
        txtFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFSearchActionPerformed(evt);
            }
        });
        PEM.add(txtFSearch);
        txtFSearch.setBounds(870, 30, 470, 40);

        LBLENROLL3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL3.setText("ENROLLMENT MODULE");
        PEM.add(LBLENROLL3);
        LBLENROLL3.setBounds(20, 30, 410, 40);

        btnView.setBackground(new java.awt.Color(255, 255, 255));
        btnView.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnView.setForeground(new java.awt.Color(51, 51, 51));
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        PEM.add(btnView);
        btnView.setBounds(1120, 710, 220, 40);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(51, 51, 51));
        btnAdd.setText("Add to Master List");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        PEM.add(btnAdd);
        btnAdd.setBounds(650, 710, 220, 40);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Semester:");
        PEM.add(jLabel15);
        jLabel15.setBounds(450, 140, 90, 25);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("School ID: ");
        PEM.add(jLabel16);
        jLabel16.setBounds(20, 110, 80, 25);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("School Year: ");
        PEM.add(jLabel17);
        jLabel17.setBounds(450, 110, 90, 25);

        CBS.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBSActionPerformed(evt);
            }
        });
        PEM.add(CBS);
        CBS.setBounds(550, 140, 160, 25);

        CBSY.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CBSY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBSYActionPerformed(evt);
            }
        });
        PEM.add(CBSY);
        CBSY.setBounds(550, 110, 110, 25);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Type of School:");
        PEM.add(jLabel18);
        jLabel18.setBounds(20, 140, 110, 25);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Public");
        PEM.add(jLabel19);
        jLabel19.setBounds(140, 140, 140, 25);

        pnlEF.setBackground(new java.awt.Color(255, 255, 255));
        pnlEF.setToolTipText("Click Here to Open Enrollment Form");
        pnlEF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlEF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEFMouseExited(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/form.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel20.setText("Enrollment Form");

        javax.swing.GroupLayout pnlEFLayout = new javax.swing.GroupLayout(pnlEF);
        pnlEF.setLayout(pnlEFLayout);
        pnlEFLayout.setHorizontalGroup(
            pnlEFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
            .addGroup(pnlEFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEFLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlEFLayout.setVerticalGroup(
            pnlEFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
            .addGroup(pnlEFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEFLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlEFLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PEM.add(pnlEF);
        pnlEF.setBounds(630, 20, 200, 60);

        btnArchive.setBackground(new java.awt.Color(255, 255, 255));
        btnArchive.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnArchive.setText("Move to Archive");
        btnArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchiveActionPerformed(evt);
            }
        });
        PEM.add(btnArchive);
        btnArchive.setBounds(890, 710, 210, 40);

        CBReason.setVisible(false);
        PEM.add(CBReason);
        CBReason.setBounds(1060, 710, 280, 30);

        lblCount.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblCount.setForeground(new java.awt.Color(255, 51, 51));
        PEM.add(lblCount);
        lblCount.setBounds(160, 710, 60, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel2.setText("Record(s) Count: ");
        PEM.add(jLabel2);
        jLabel2.setBounds(20, 710, 150, 40);

        lblSem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PEM.add(lblSem);
        lblSem.setBounds(550, 140, 160, 25);

        lblSY.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PEM.add(lblSY);
        lblSY.setBounds(550, 110, 110, 25);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel42.setText("300751");
        PEM.add(jLabel42);
        jLabel42.setBounds(140, 110, 60, 25);

        btnProm.setBackground(new java.awt.Color(255, 255, 255));
        btnProm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnProm.setText("Promote");
        btnProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromActionPerformed(evt);
            }
        });
        PEM.add(btnProm);
        btnProm.setBounds(460, 710, 180, 40);

        lblSel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSel.setText("Select all");
        PEM.add(lblSel);
        lblSel.setBounds(60, 198, 110, 30);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
        });
        jPanel13.setLayout(null);

        jLabel83.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel83.setText("Filter");
        jLabel83.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel13.add(jLabel83);
        jLabel83.setBounds(25, 57, 50, 16);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/DITO NGA!/Filter.png"))); // NOI18N
        jLabel39.setToolTipText("Click here to open filters");
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel39MouseExited(evt);
            }
        });
        jPanel13.add(jLabel39);
        jLabel39.setBounds(0, 0, 90, 70);

        PEM.add(jPanel13);
        jPanel13.setBounds(1260, 100, 90, 80);

        Panel.add(PEM, "card2");

        PSM.setBackground(new java.awt.Color(255, 255, 255));
        PSM.setLayout(null);

        LBLENROLL6.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        LBLENROLL6.setForeground(new java.awt.Color(102, 102, 102));
        LBLENROLL6.setText("_________________________________________________________________________________________________________");
        PSM.add(LBLENROLL6);
        LBLENROLL6.setBounds(0, 60, 1370, 40);

        LBLENROLL7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL7.setText("STUDENT MASTERLIST");
        PSM.add(LBLENROLL7);
        LBLENROLL7.setBounds(20, 30, 290, 40);

        panelSM.setBackground(new java.awt.Color(255, 255, 255));
        panelSM.setLayout(new java.awt.CardLayout());

        panelSMTBL.setBackground(new java.awt.Color(255, 255, 255));
        panelSMTBL.setLayout(null);

        tblSM.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        tblSM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSMMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSMMouseReleased(evt);
            }
        });
        spTBL.setViewportView(tblSM);

        panelSMTBL.add(spTBL);
        spTBL.setBounds(0, 60, 1330, 530);

        btnLoad.setBackground(new java.awt.Color(255, 255, 255));
        btnLoad.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnLoad.setText("Load Data");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        panelSMTBL.add(btnLoad);
        btnLoad.setBounds(1130, 10, 100, 30);

        cbSmYl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbSmYl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year Level", " " }));
        cbSmYl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbSmYlMouseClicked(evt);
            }
        });
        cbSmYl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSmYlActionPerformed(evt);
            }
        });
        panelSMTBL.add(cbSmYl);
        cbSmYl.setBounds(1000, 10, 120, 30);

        cbSmTs.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbSmTs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbSmTsMouseClicked(evt);
            }
        });
        cbSmTs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSmTsActionPerformed(evt);
            }
        });
        panelSMTBL.add(cbSmTs);
        cbSmTs.setBounds(830, 10, 160, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel7.setText("Filter Record(s)");
        panelSMTBL.add(jLabel7);
        jLabel7.setBounds(690, 10, 130, 30);

        cbSort.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSortItemStateChanged(evt);
            }
        });
        cbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSortActionPerformed(evt);
            }
        });
        panelSMTBL.add(cbSort);
        cbSort.setBounds(110, 10, 200, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel6.setText("Sort by:");
        panelSMTBL.add(jLabel6);
        jLabel6.setBounds(20, 10, 60, 30);

        view.setBackground(new java.awt.Color(255, 255, 255));
        view.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        view.setText("View Subjects");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        panelSMTBL.add(view);
        view.setBounds(1040, 610, 280, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel8.setText("Record(s) Count: ");
        panelSMTBL.add(jLabel8);
        jLabel8.setBounds(30, 600, 150, 40);

        lblSmCount.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblSmCount.setForeground(new java.awt.Color(255, 51, 51));
        panelSMTBL.add(lblSmCount);
        lblSmCount.setBounds(170, 600, 60, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelSMTBL.add(jButton1);
        jButton1.setBounds(1240, 10, 90, 30);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton5.setText("View requirements");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelSMTBL.add(jButton5);
        jButton5.setBounds(790, 610, 240, 30);

        panelSM.add(panelSMTBL, "card5");

        pnlSub.setBackground(new java.awt.Color(255, 255, 255));
        pnlSub.setPreferredSize(new java.awt.Dimension(1, 1));
        pnlSub.setLayout(null);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        tblSubj.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tblSubj.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSubj.setEnabled(false);
        jScrollPane4.setViewportView(tblSubj);

        pnlSub.add(jScrollPane4);
        jScrollPane4.setBounds(10, 220, 1320, 370);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel1.setText("School Year:");
        pnlSub.add(jLabel1);
        jLabel1.setBounds(30, 130, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel9.setText("Student name:");
        pnlSub.add(jLabel9);
        jLabel9.setBounds(30, 50, 120, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel13.setText("Semester:");
        pnlSub.add(jLabel13);
        jLabel13.setBounds(570, 130, 90, 30);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel40.setText("LRN:");
        pnlSub.add(jLabel40);
        jLabel40.setBounds(30, 10, 60, 30);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel43.setText("Track/Strands/Specialization:");
        pnlSub.add(jLabel43);
        jLabel43.setBounds(570, 10, 220, 30);

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel44.setText("Grade Level:");
        pnlSub.add(jLabel44);
        jLabel44.setBounds(570, 50, 110, 30);

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel45.setText("Date Enrolled:");
        pnlSub.add(jLabel45);
        jLabel45.setBounds(30, 90, 120, 30);

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel46.setText("Section:");
        pnlSub.add(jLabel46);
        jLabel46.setBounds(570, 90, 110, 30);

        txtSmSy.setEditable(false);
        pnlSub.add(txtSmSy);
        txtSmSy.setBounds(180, 130, 130, 30);

        txtSmSem.setEditable(false);
        pnlSub.add(txtSmSem);
        txtSmSem.setBounds(810, 130, 260, 30);

        txtSmSn.setEditable(false);
        pnlSub.add(txtSmSn);
        txtSmSn.setBounds(180, 50, 290, 30);

        txtSmDe.setEditable(false);
        pnlSub.add(txtSmDe);
        txtSmDe.setBounds(180, 90, 130, 30);

        txtSmLrn.setEditable(false);
        pnlSub.add(txtSmLrn);
        txtSmLrn.setBounds(180, 10, 250, 30);

        txtSmTs.setEditable(false);
        pnlSub.add(txtSmTs);
        txtSmTs.setBounds(810, 10, 470, 30);

        txtSmGl.setEditable(false);
        pnlSub.add(txtSmGl);
        txtSmGl.setBounds(810, 50, 170, 30);

        txtSmSec.setEditable(false);
        pnlSub.add(txtSmSec);
        txtSmSec.setBounds(810, 90, 370, 30);

        btnSmBack.setBackground(new java.awt.Color(255, 255, 255));
        btnSmBack.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnSmBack.setText("Back");
        btnSmBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSmBackActionPerformed(evt);
            }
        });
        pnlSub.add(btnSmBack);
        btnSmBack.setBounds(720, 610, 190, 30);

        LBLENROLL17.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL17.setForeground(new java.awt.Color(255, 0, 0));
        LBLENROLL17.setText("Subject List:");
        pnlSub.add(LBLENROLL17);
        LBLENROLL17.setBounds(10, 180, 130, 40);

        btnSmPrint.setBackground(new java.awt.Color(255, 255, 255));
        btnSmPrint.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnSmPrint.setText("Print ");
        btnSmPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSmPrintActionPerformed(evt);
            }
        });
        pnlSub.add(btnSmPrint);
        btnSmPrint.setBounds(1130, 610, 190, 30);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton7.setText("Print COR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pnlSub.add(jButton7);
        jButton7.setBounds(929, 610, 190, 30);

        panelSM.add(pnlSub, "card4");

        PSM.add(panelSM);
        panelSM.setBounds(10, 102, 1340, 650);

        lblSmSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/search.png"))); // NOI18N
        lblSmSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSmSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSmSearchMouseClicked(evt);
            }
        });
        PSM.add(lblSmSearch);
        lblSmSearch.setBounds(1290, 30, 50, 40);

        txtSmSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSmSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtSmSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtSmSearch.setText(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)");
        txtSmSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSmSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSmSearchFocusLost(evt);
            }
        });
        txtSmSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSmSearchMouseEntered(evt);
            }
        });
        txtSmSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSmSearchActionPerformed(evt);
            }
        });
        PSM.add(txtSmSearch);
        txtSmSearch.setBounds(870, 30, 470, 40);

        Panel.add(PSM, "card3");

        PTM.setBackground(new java.awt.Color(255, 255, 255));
        PTM.setLayout(null);

        LBLENROLL14.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        LBLENROLL14.setForeground(new java.awt.Color(102, 102, 102));
        LBLENROLL14.setText("_________________________________________________________________________________________________________");
        PTM.add(LBLENROLL14);
        LBLENROLL14.setBounds(0, 60, 1370, 40);

        LBLENROLL15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL15.setText("TEACHER MASTERLIST");
        PTM.add(LBLENROLL15);
        LBLENROLL15.setBounds(20, 30, 230, 40);

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel62.setText("Record(s) Count: ");
        PTM.add(jLabel62);
        jLabel62.setBounds(20, 710, 150, 40);

        lblTmCount.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblTmCount.setForeground(new java.awt.Color(255, 51, 51));
        PTM.add(lblTmCount);
        lblTmCount.setBounds(160, 710, 60, 40);

        cbTmSort.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbTmSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name Ascending", "Name Descending" }));
        cbTmSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTmSortActionPerformed(evt);
            }
        });
        PTM.add(cbTmSort);
        cbTmSort.setBounds(80, 130, 160, 30);

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel67.setText("Sort by:");
        PTM.add(jLabel67);
        jLabel67.setBounds(20, 130, 60, 30);

        btnTmSave.setBackground(new java.awt.Color(255, 255, 255));
        btnTmSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTmSave.setText("Save as PDF");
        btnTmSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmSaveActionPerformed(evt);
            }
        });
        PTM.add(btnTmSave);
        btnTmSave.setBounds(1149, 710, 190, 30);

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel70.setText("Selected item(s):");
        jLabel70.setVisible(false);
        PTM.add(jLabel70);
        jLabel70.setBounds(30, 170, 110, 20);

        lblTmSel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTmSel.setForeground(new java.awt.Color(255, 51, 51));
        lblTmSel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTmSel.setVisible(false);
        lblTmSel.setText("0");
        PTM.add(lblTmSel);
        lblTmSel.setBounds(130, 170, 40, 20);

        lblTmlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/search.png"))); // NOI18N
        lblTmlist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTmlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTmlistMouseClicked(evt);
            }
        });
        PTM.add(lblTmlist);
        lblTmlist.setBounds(1290, 30, 50, 40);

        txtTmSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTmSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtTmSearch.setText(" PLEASE ENTER TEACHERS NAME(PRESS ENTER TO SEARCH)");
        txtTmSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtTmSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTmSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTmSearchFocusLost(evt);
            }
        });
        txtTmSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTmSearchMouseEntered(evt);
            }
        });
        txtTmSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTmSearchActionPerformed(evt);
            }
        });
        PTM.add(txtTmSearch);
        txtTmSearch.setBounds(870, 30, 470, 40);

        pnlTmCard.setLayout(new java.awt.CardLayout());

        tblTM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTMMouseClicked(evt);
            }
        });
        spTM.setViewportView(tblTM);

        pnlTmCard.add(spTM, "card2");

        pnlTmAdd.setBackground(new java.awt.Color(255, 255, 255));
        pnlTmAdd.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlTmAdd.setLayout(null);

        txtTmUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlTmAdd.add(txtTmUser);
        txtTmUser.setBounds(540, 30, 310, 40);

        jLabel73.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel73.setText("First name:");
        pnlTmAdd.add(jLabel73);
        jLabel73.setBounds(410, 30, 80, 40);

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel74.setText("Middle Name:");
        pnlTmAdd.add(jLabel74);
        jLabel74.setBounds(410, 100, 110, 40);

        txtTmUser1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlTmAdd.add(txtTmUser1);
        txtTmUser1.setBounds(540, 100, 310, 40);

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel77.setText("Designation");
        pnlTmAdd.add(jLabel77);
        jLabel77.setBounds(410, 310, 110, 40);

        txtTmUser2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlTmAdd.add(txtTmUser2);
        txtTmUser2.setBounds(540, 240, 310, 40);

        cbPos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbPos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher I", "Teacher II", "Teacher III", "Master Teacher I", "Master Teacher II", "Master Teacher III", "Special Science Teacher I", "Registrar", "Administrator", "Administrative officer II", "Administrative Staff ", "Office Staff", "Principal", "Assistant Principal", "Other" }));
        cbPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPosActionPerformed(evt);
            }
        });
        pnlTmAdd.add(cbPos);
        cbPos.setBounds(540, 310, 310, 40);

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel78.setText("Contact #: ");
        pnlTmAdd.add(jLabel78);
        jLabel78.setBounds(410, 240, 110, 40);

        jButton3.setText("Add");
        pnlTmAdd.add(jButton3);
        jButton3.setBounds(410, 410, 140, 23);

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel84.setText("Last Name:");
        pnlTmAdd.add(jLabel84);
        jLabel84.setBounds(410, 170, 110, 40);

        txtTmUser3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlTmAdd.add(txtTmUser3);
        txtTmUser3.setBounds(540, 170, 310, 40);

        pnlTmCard.add(pnlTmAdd, "card3");

        PTM.add(pnlTmCard);
        pnlTmCard.setBounds(20, 200, 1320, 500);

        btnTmAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnTmAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTmAdd.setText("Add /update");
        btnTmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmAddActionPerformed(evt);
            }
        });
        btnTmAdd.setVisible(false);
        PTM.add(btnTmAdd);
        btnTmAdd.setBounds(390, 710, 250, 30);

        btnTmBack.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTmBack.setText("back");
        btnTmBack.setVisible(false);
        btnTmBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmBackActionPerformed(evt);
            }
        });
        PTM.add(btnTmBack);
        btnTmBack.setBounds(20, 720, 170, 30);

        btnTMmove.setBackground(new java.awt.Color(255, 255, 255));
        btnTMmove.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTMmove.setText("move to archived");
        btnTMmove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTMmoveActionPerformed(evt);
            }
        });
        PTM.add(btnTMmove);
        btnTMmove.setBounds(920, 710, 220, 30);

        btnTmAdv.setBackground(new java.awt.Color(255, 255, 255));
        btnTmAdv.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnTmAdv.setText("Add/remove advisory");
        btnTmAdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmAdvActionPerformed(evt);
            }
        });
        PTM.add(btnTmAdv);
        btnTmAdv.setBounds(650, 710, 260, 30);

        cbTmSec.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbTmSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GRADE 11 - TVL-1", "GRADE 11 - TVL-2", "GRADE 11 - TVL-3", "GRADE 11 - TVL-4", "GRADE 11 - TVL-5", "GRADE 11 - TVL-6", "GRADE 11 - TVL-7", "GRADE 11 - TVL-8", "GRADE 11 - TVL-9", "GRADE 11 - STEM-A", "GRADE 11 - STEM-B", "GRADE 11 - STEM-C", "GRADE 11 - STEM-D", "GRADE 11 - STEM-E", "GRADE 11 - STEM-F", "GRADE 11 - STEM-G", "GRADE 11 - STEM-H", "GRADE 11 - ABM-A", "GRADE 11 - ABM-B", "GRADE 11 - ABM-C", "GRADE 11 - ABM-D", "GRADE 11 - Arts and Design", "GRADE 11 - Sports", "GRADE 11 - HUMSS-A", "GRADE 11 - HUMSS-B", "GRADE 11 - HUMSS-C", "GRADE 11 - HUMSS-D", "GRADE 12 - TVL-1", "GRADE 12 - TVL-2", "GRADE 12 - TVL-3", "GRADE 12 - TVL-4", "GRADE 12 - TVL-5", "GRADE 12 - TVL-6", "GRADE 12 - TVL-7", "GRADE 12 - TVL-8", "GRADE 12 - TVL-9", "GRADE 12 - STEM-A", "GRADE 12 - STEM-B", "GRADE 12 - STEM-C", "GRADE 12 - STEM-D", "GRADE 12 - STEM-E", "GRADE 12 - STEM-F", "GRADE 12 - STEM-G", "GRADE 12 - STEM-H", "GRADE 12 - ABM-A", "GRADE 12 - ABM-B", "GRADE 12 - ABM-C", "GRADE 12 - ABM-D", "GRADE 12 - Arts and Design", "GRADE 12 - Sports", "GRADE 12 - HUMSS-A", "GRADE 12 - HUMSS-B", "GRADE 12 - HUMSS-C", "GRADE 12 - HUMSS-D", "Remove Advisory" }));
        PTM.add(cbTmSec);
        cbTmSec.setBounds(10000, 150, 290, 30);

        Panel.add(PTM, "card8");

        PRC.setBackground(new java.awt.Color(255, 255, 255));
        PRC.setLayout(null);

        LBLENROLL8.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        LBLENROLL8.setText("_________________________________________________________________________________________________________");
        PRC.add(LBLENROLL8);
        LBLENROLL8.setBounds(0, 60, 1370, 40);

        LBLENROLL9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL9.setText("REQUIREMENT CHECKLIST");
        PRC.add(LBLENROLL9);
        LBLENROLL9.setBounds(20, 30, 410, 40);

        lblChecklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/search.png"))); // NOI18N
        lblChecklist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblChecklist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChecklistMouseClicked(evt);
            }
        });
        PRC.add(lblChecklist);
        lblChecklist.setBounds(1290, 30, 50, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel4.setText("Record(s) Count: ");
        PRC.add(jLabel4);
        jLabel4.setBounds(20, 710, 150, 40);

        lblCount2.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblCount2.setForeground(new java.awt.Color(255, 51, 51));
        PRC.add(lblCount2);
        lblCount2.setBounds(160, 710, 60, 40);

        txtRcSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRcSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtRcSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtRcSearch.setText(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)");
        txtRcSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtRcSearchCaretUpdate(evt);
            }
        });
        txtRcSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRcSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRcSearchFocusLost(evt);
            }
        });
        txtRcSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRcSearchMousePressed(evt);
            }
        });
        txtRcSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRcSearchActionPerformed(evt);
            }
        });
        PRC.add(txtRcSearch);
        txtRcSearch.setBounds(860, 30, 480, 40);

        btnV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnV.setText("View Soft copy");
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });
        btnV.setVisible(false);
        PRC.add(btnV);
        btnV.setBounds(1150, 710, 190, 30);

        pnlRcMain.setLayout(new java.awt.CardLayout());

        pnlRc1.setBackground(new java.awt.Color(255, 255, 255));
        pnlRc1.setLayout(null);

        scrollpane.setBackground(new java.awt.Color(255, 255, 255));

        tblRC.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        tblRC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Class[] types = new Class[]{
            java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
        };
        tblRC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRC.setDragEnabled(false);
        tblRC.setOpaque(false);
        tblRC.setRowHeight(25);
        tblRC.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblRC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRCMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(tblRC);

        pnlRc1.add(scrollpane);
        scrollpane.setBounds(10, 10, 1100, 580);

        pnlRcMain.add(pnlRc1, "card2");

        pnlRc2.setBackground(new java.awt.Color(255, 255, 255));
        pnlRc2.setLayout(null);

        txtRcLrn.setEditable(false);
        txtRcLrn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtRcLrn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlRc2.add(txtRcLrn);
        txtRcLrn.setBounds(110, 30, 280, 30);

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel66.setText("No.");
        pnlRc2.add(jLabel66);
        jLabel66.setBounds(510, 70, 30, 30);

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel69.setText("LRN:");
        pnlRc2.add(jLabel69);
        jLabel69.setBounds(40, 30, 60, 30);

        txtId.setEditable(false);
        txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlRc2.add(txtId);
        txtId.setBounds(570, 70, 70, 30);

        txtRcFn.setEditable(false);
        txtRcFn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtRcFn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlRc2.add(txtRcFn);
        txtRcFn.setBounds(570, 30, 420, 30);

        jLabel68.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel68.setText("Full Name:");
        pnlRc2.add(jLabel68);
        jLabel68.setBounds(470, 30, 90, 30);

        cbRcSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbRcSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Click Here", "Grade Card", "Form 137", "Birth Certificate", "Good Moral", "National Career Assessment Examination" }));
        cbRcSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRcSearchActionPerformed(evt);
            }
        });
        pnlRc2.add(cbRcSearch);
        cbRcSearch.setBounds(110, 70, 340, 30);

        pnlCard.setPreferredSize(new java.awt.Dimension(500, 500));
        pnlCard.setLayout(new java.awt.CardLayout());

        p.setBackground(new java.awt.Color(204, 204, 204));
        p.setMaximumSize(new java.awt.Dimension(500, 500));
        p.setPreferredSize(new java.awt.Dimension(1000, 100));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/gear-animation-green.gif"))); // NOI18N

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                .addContainerGap(414, Short.MAX_VALUE)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pnlCard.add(p, "card4");

        pnlGcard.setBackground(new java.awt.Color(255, 255, 255));
        pnlGcard.setForeground(new java.awt.Color(255, 255, 255));
        pnlGcard.setLayout(null);
        pnlCard.add(pnlGcard, "card1");

        pnlForm137.setBackground(new java.awt.Color(255, 153, 51));

        lblF.setText("FORM 137");

        javax.swing.GroupLayout pnlForm137Layout = new javax.swing.GroupLayout(pnlForm137);
        pnlForm137.setLayout(pnlForm137Layout);
        pnlForm137Layout.setHorizontalGroup(
            pnlForm137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForm137Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(lblF, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        pnlForm137Layout.setVerticalGroup(
            pnlForm137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForm137Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblF, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pnlCard.add(pnlForm137, "card5");

        pnlBC.setBackground(new java.awt.Color(51, 51, 0));

        lblBday.setForeground(new java.awt.Color(255, 255, 255));
        lblBday.setText("BIRTH CERTIFICATE");

        javax.swing.GroupLayout pnlBCLayout = new javax.swing.GroupLayout(pnlBC);
        pnlBC.setLayout(pnlBCLayout);
        pnlBCLayout.setHorizontalGroup(
            pnlBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBCLayout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(lblBday)
                .addContainerGap(609, Short.MAX_VALUE))
        );
        pnlBCLayout.setVerticalGroup(
            pnlBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBCLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(lblBday)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        pnlCard.add(pnlBC, "card6");

        pnlGM.setBackground(new java.awt.Color(255, 153, 102));

        jLabel75.setText("GOOD MORAL");

        javax.swing.GroupLayout pnlGMLayout = new javax.swing.GroupLayout(pnlGM);
        pnlGM.setLayout(pnlGMLayout);
        pnlGMLayout.setHorizontalGroup(
            pnlGMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGMLayout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(579, Short.MAX_VALUE))
        );
        pnlGMLayout.setVerticalGroup(
            pnlGMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGMLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pnlCard.add(pnlGM, "card7");

        pnlNcae.setBackground(new java.awt.Color(255, 0, 153));

        jLabel76.setText("NCAE");

        javax.swing.GroupLayout pnlNcaeLayout = new javax.swing.GroupLayout(pnlNcae);
        pnlNcae.setLayout(pnlNcaeLayout);
        pnlNcaeLayout.setHorizontalGroup(
            pnlNcaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNcaeLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(513, Short.MAX_VALUE))
        );
        pnlNcaeLayout.setVerticalGroup(
            pnlNcaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNcaeLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        pnlCard.add(pnlNcae, "card8");

        jScrollPane2.setViewportView(pnlCard);

        pnlRc2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 110, 1070, 470);

        pnlRcMain.add(pnlRc2, "card3");

        PRC.add(pnlRcMain);
        pnlRcMain.setBounds(20, 110, 1090, 590);

        btnRcBack.setBackground(new java.awt.Color(255, 255, 255));
        btnRcBack.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnRcBack.setText("back");
        btnRcBack.setVisible(false);
        btnRcBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRcBackActionPerformed(evt);
            }
        });
        PRC.add(btnRcBack);
        btnRcBack.setBounds(20, 720, 130, 30);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel25.setText("LEGEND");
        PRC.add(jLabel25);
        jLabel25.setBounds(1140, 150, 90, 24);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel31.setText("EF -");
        PRC.add(jLabel31);
        jLabel31.setBounds(1140, 220, 60, 21);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel32.setText("Enrollment Form");
        PRC.add(jLabel32);
        jLabel32.setBounds(1190, 220, 140, 21);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel24.setText("GC -");
        PRC.add(jLabel24);
        jLabel24.setBounds(1140, 270, 80, 21);

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel33.setText("Grade Card(Form 138)");
        PRC.add(jLabel33);
        jLabel33.setBounds(1190, 270, 140, 21);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel26.setText("F137 -");
        PRC.add(jLabel26);
        jLabel26.setBounds(1140, 320, 80, 21);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel34.setText("Form 137");
        PRC.add(jLabel34);
        jLabel34.setBounds(1190, 320, 140, 21);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel27.setText("PSA-");
        PRC.add(jLabel27);
        jLabel27.setBounds(1140, 370, 50, 21);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel35.setText("Birth Certificate");
        PRC.add(jLabel35);
        jLabel35.setBounds(1190, 370, 140, 21);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel30.setText("GM -");
        PRC.add(jLabel30);
        jLabel30.setBounds(1140, 420, 80, 21);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel36.setText("Good Moral");
        PRC.add(jLabel36);
        jLabel36.setBounds(1190, 420, 140, 21);

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel63.setText("NCAE-");
        PRC.add(jLabel63);
        jLabel63.setBounds(1140, 470, 80, 21);

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel64.setText("National Career");
        PRC.add(jLabel64);
        jLabel64.setBounds(1200, 470, 140, 21);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel29.setText("Assessment Examination");
        PRC.add(jLabel29);
        jLabel29.setBounds(1140, 500, 200, 21);

        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel65.setText("General Weighted");
        PRC.add(jLabel65);
        jLabel65.setBounds(1200, 540, 140, 21);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel28.setText("GWA-");
        PRC.add(jLabel28);
        jLabel28.setBounds(1140, 540, 60, 21);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel37.setText("Average");
        PRC.add(jLabel37);
        jLabel37.setBounds(1140, 570, 140, 21);

        Panel.add(PRC, "card5");

        PSA.setBackground(new java.awt.Color(255, 255, 255));
        PSA.setLayout(null);

        LBLENROLL12.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        LBLENROLL12.setForeground(new java.awt.Color(102, 102, 102));
        LBLENROLL12.setText("_________________________________________________________________________________________________________");
        PSA.add(LBLENROLL12);
        LBLENROLL12.setBounds(0, 60, 1370, 40);

        LBLENROLL13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL13.setText("STUDENT ARCHIVE");
        PSA.add(LBLENROLL13);
        LBLENROLL13.setBounds(20, 30, 240, 40);

        cbArch.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbArch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Students Archived", "Teachers Archived", "Users Archived" }));
        cbArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbArchActionPerformed(evt);
            }
        });
        PSA.add(cbArch);
        cbArch.setBounds(1130, 50, 220, 30);
        PSA.add(lblSearch4);
        lblSearch4.setBounds(1270, 30, 60, 40);

        pnlArch.setLayout(new java.awt.CardLayout());

        pnlAr.setBackground(new java.awt.Color(255, 255, 255));
        pnlAr.setLayout(null);

        tblSA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblSA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSAMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSAMouseReleased(evt);
            }
        });
        scrlSA.setViewportView(tblSA);

        pnlAr.add(scrlSA);
        scrlSA.setBounds(0, 30, 1330, 570);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel3.setText("Record(s) Count: ");
        pnlAr.add(jLabel3);
        jLabel3.setBounds(10, 610, 150, 40);

        lblCount1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblCount1.setForeground(new java.awt.Color(255, 51, 51));
        lblCount1.setText("0");
        pnlAr.add(lblCount1);
        lblCount1.setBounds(150, 610, 30, 40);

        btnRet.setBackground(new java.awt.Color(255, 255, 255));
        btnRet.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnRet.setText("Retrieve");
        btnRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetActionPerformed(evt);
            }
        });
        pnlAr.add(btnRet);
        btnRet.setBounds(990, 610, 150, 27);

        btnDel.setBackground(new java.awt.Color(255, 255, 255));
        btnDel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        pnlAr.add(btnDel);
        btnDel.setBounds(1160, 610, 160, 27);

        cbSa.setBackground(new java.awt.Color(255, 255, 255));
        cbSa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSaActionPerformed(evt);
            }
        });
        pnlAr.add(cbSa);
        cbSa.setBounds(12, 5, 30, 19);

        lblSaSelect.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSaSelect.setText("Select all");
        pnlAr.add(lblSaSelect);
        lblSaSelect.setBounds(60, 0, 120, 30);

        pnlArch.add(pnlAr, "1");

        pnlTr.setBackground(new java.awt.Color(255, 255, 255));
        pnlTr.setPreferredSize(new java.awt.Dimension(1000, 1000));
        pnlTr.setLayout(null);

        tblTa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblTaMouseReleased(evt);
            }
        });
        scrlTA.setViewportView(tblTa);

        pnlTr.add(scrlTA);
        scrlTA.setBounds(0, 31, 1330, 570);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton4.setText("retrieve");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlTr.add(jButton4);
        jButton4.setBounds(990, 610, 160, 30);

        btnTaDel.setBackground(new java.awt.Color(255, 255, 255));
        btnTaDel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnTaDel.setText("delete");
        btnTaDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaDelActionPerformed(evt);
            }
        });
        pnlTr.add(btnTaDel);
        btnTaDel.setBounds(1160, 610, 160, 30);

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel79.setText("Record(s) Count: ");
        pnlTr.add(jLabel79);
        jLabel79.setBounds(10, 610, 150, 40);

        lblCount3.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblCount3.setForeground(new java.awt.Color(255, 51, 51));
        lblCount3.setText("0");
        pnlTr.add(lblCount3);
        lblCount3.setBounds(150, 610, 30, 40);

        pnlArch.add(pnlTr, "2");

        pnlUr.setBackground(new java.awt.Color(255, 255, 255));
        pnlUr.setLayout(null);

        tblUa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUaMouseClicked(evt);
            }
        });
        scrlUA.setViewportView(tblUa);

        pnlUr.add(scrlUA);
        scrlUA.setBounds(0, 33, 1330, 570);

        btnUaRet.setBackground(new java.awt.Color(255, 255, 255));
        btnUaRet.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnUaRet.setText("retrieve");
        btnUaRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUaRetActionPerformed(evt);
            }
        });
        pnlUr.add(btnUaRet);
        btnUaRet.setBounds(1010, 610, 150, 27);

        btnUaDel.setBackground(new java.awt.Color(255, 255, 255));
        btnUaDel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnUaDel.setText("delete");
        btnUaDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUaDelActionPerformed(evt);
            }
        });
        pnlUr.add(btnUaDel);
        btnUaDel.setBounds(1167, 610, 160, 27);

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel80.setText("Record(s) Count: ");
        pnlUr.add(jLabel80);
        jLabel80.setBounds(10, 610, 150, 40);

        lblCount4.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblCount4.setForeground(new java.awt.Color(255, 51, 51));
        lblCount4.setText("0");
        pnlUr.add(lblCount4);
        lblCount4.setBounds(150, 610, 30, 40);

        pnlArch.add(pnlUr, "3");

        PSA.add(pnlArch);
        pnlArch.setBounds(10, 100, 1330, 650);

        Panel.add(PSA, "card7");

        PCR.setBackground(new java.awt.Color(255, 255, 255));
        PCR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PCRMouseClicked(evt);
            }
        });
        PCR.setLayout(null);

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel47.setText("Filter Record(s):");
        PCR.add(jLabel47);
        jLabel47.setBounds(30, 120, 120, 30);

        cbSY.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbSY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSYActionPerformed(evt);
            }
        });
        PCR.add(cbSY);
        cbSY.setBounds(550, 120, 120, 30);

        cbSec.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Track/Strands/Section", "TVL-1", "TVL-2", "TVL-3", "TVL-4", "TVL-5", "TVL-6", "TVL-7", "TVL-8", "TVL-9", "STEM-A", "STEM-B", "STEM-C", "STEM-D", "STEM-E", "STEM-F", "STEM-G", "STEM-H", "ABM-A", "ABM-B", "ABM-C", "ABM-D", "Arts and Design", "Sports", "HUMSS-A", "HUMSS-B", "HUMSS-C", "HUMSS-D" }));
        cbSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecActionPerformed(evt);
            }
        });
        PCR.add(cbSec);
        cbSec.setBounds(270, 120, 270, 30);

        LBLENROLL10.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        LBLENROLL10.setForeground(new java.awt.Color(102, 102, 102));
        LBLENROLL10.setText("_________________________________________________________________________________________________________");
        PCR.add(LBLENROLL10);
        LBLENROLL10.setBounds(0, 60, 1370, 40);

        LBLENROLL11.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL11.setText("CLASSLIST REPORT");
        PCR.add(LBLENROLL11);
        LBLENROLL11.setBounds(20, 30, 280, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton2.setText("Save as PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PCR.add(jButton2);
        jButton2.setBounds(1220, 720, 120, 25);

        pnlCL.setBackground(new java.awt.Color(204, 204, 204));
        pnlCL.setPreferredSize(new java.awt.Dimension(1150, 1150));
        pnlCL.setLayout(null);

        PNLCR.setBackground(new java.awt.Color(255, 255, 255));
        PNLCR.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel53.setText("Semester:");
        jPanel1.add(jLabel53);
        jLabel53.setBounds(520, 80, 80, 17);

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel54.setText("Class Adviser:");
        jPanel1.add(jLabel54);
        jLabel54.setBounds(520, 20, 100, 17);

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel55.setText("Track/Strands/Specialization:");
        jPanel1.add(jLabel55);
        jLabel55.setBounds(20, 80, 180, 17);

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel56.setText("School Year:");
        jPanel1.add(jLabel56);
        jLabel56.setBounds(520, 50, 100, 17);

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel57.setText("Section:");
        jPanel1.add(jLabel57);
        jLabel57.setBounds(20, 50, 60, 17);

        lblSec.setText("");
        jPanel1.add(lblSec);
        lblSec.setBounds(80, 50, 250, 16);
        lblSec.setVisible(false);

        lblTrack.setText("");
        jPanel1.add(lblTrack);
        lblTrack.setBounds(210, 80, 280, 16);
        lblTrack.setVisible(false);

        lblSYear.setText("");
        jPanel1.add(lblSYear);
        lblSYear.setBounds(610, 50, 150, 16);
        lblSYear.setVisible(false);

        lblSEM.setText("");
        jPanel1.add(lblSEM);
        lblSEM.setBounds(590, 80, 150, 16);
        lblSYear.setVisible(false);

        lblLevel.setText("");
        jPanel1.add(lblLevel);
        lblLevel.setBounds(100, 20, 210, 16);
        lblSYear.setVisible(false);

        jLabel85.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel85.setText("Year level:");
        jPanel1.add(jLabel85);
        jLabel85.setBounds(20, 20, 70, 17);
        jPanel1.add(lblCrAd);
        lblCrAd.setBounds(620, 20, 240, 20);

        PNLCR.add(jPanel1);
        jPanel1.setBounds(20, 220, 880, 110);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Classlist");
        PNLCR.add(jLabel52);
        jLabel52.setBounds(360, 190, 140, 19);

        txtaFem.setEditable(false);
        txtaFem.setColumns(20);
        txtaFem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtaFem.setRows(5);
        txtaFem.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane7.setViewportView(txtaFem);

        PNLCR.add(jScrollPane7);
        jScrollPane7.setBounds(460, 370, 440, 710);

        txtaMale.setEditable(false);
        txtaMale.setColumns(20);
        txtaMale.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtaMale.setRows(5);
        txtaMale.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane8.setViewportView(txtaMale);

        PNLCR.add(jScrollPane8);
        jScrollPane8.setBounds(20, 370, 440, 710);

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel60.setText("Female");
        PNLCR.add(jLabel60);
        jLabel60.setBounds(470, 350, 70, 17);

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel61.setText("Male");
        PNLCR.add(jLabel61);
        jLabel61.setBounds(20, 350, 70, 17);

        lblMarceloLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/logo copy copy.png"))); // NOI18N
        PNLCR.add(lblMarceloLogo);
        lblMarceloLogo.setBounds(740, 30, 160, 150);

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("E-mail: marcelohdelpilarnhs@gmail.com/ Tel. No. (044) 795-5343");
        PNLCR.add(jLabel51);
        jLabel51.setBounds(200, 140, 530, 20);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Bagong Bayan, City of Malolos, Bulacan / School ID: 300751 / ww.marcelodelpilarnhs.com");
        PNLCR.add(jLabel49);
        jLabel49.setBounds(200, 120, 530, 19);

        LBLMHPNHS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LBLMHPNHS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLMHPNHS.setText("MARCELO H. DEL PILAR NATIONAL HIGH SCHOOL");
        PNLCR.add(LBLMHPNHS);
        LBLMHPNHS.setBounds(200, 100, 530, 22);

        jPanel14.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        PNLCR.add(jPanel14);
        jPanel14.setBounds(200, 90, 520, 4);

        lbldivision.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision.setText("SCHOOLS DIVISION OFFICE - CITY OF MALOLOS");
        PNLCR.add(lbldivision);
        lbldivision.setBounds(260, 70, 390, 20);

        lbldivision2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision2.setText("DEPARTMENT OF EDUCATION - REGION III");
        PNLCR.add(lbldivision2);
        lbldivision2.setBounds(260, 50, 390, 20);

        lbldivision1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbldivision1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldivision1.setText("REPUBLIC OF THE PHILIPPINES");
        PNLCR.add(lbldivision1);
        lbldivision1.setBounds(260, 30, 390, 20);

        lblDep.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/deped123.PNG"))); // NOI18N
        PNLCR.add(lblDep);
        lblDep.setBounds(40, 30, 150, 150);

        pnlCL.add(PNLCR);
        PNLCR.setBounds(220, 20, 920, 1100);

        jScrollPane6.setViewportView(pnlCL);

        PCR.add(jScrollPane6);
        jScrollPane6.setBounds(40, 160, 1300, 550);

        btnClLoad.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnClLoad.setText("Load");
        btnClLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClLoadActionPerformed(evt);
            }
        });
        PCR.add(btnClLoad);
        btnClLoad.setBounds(860, 120, 110, 30);

        cbSem.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbSem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Semester", "Second Semester" }));
        PCR.add(cbSem);
        cbSem.setBounds(680, 120, 160, 30);

        cbLvl.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cbLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GRADE 11", "GRADE 12" }));
        PCR.add(cbLvl);
        cbLvl.setBounds(150, 120, 110, 30);

        jLabel71.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel71.setText("Please save this file in A4 size paper");
        PCR.add(jLabel71);
        jLabel71.setBounds(960, 720, 250, 30);

        Panel.add(PCR, "card4");

        PDO.setBackground(new java.awt.Color(255, 255, 255));
        PDO.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(50, 100, 49));
        jPanel12.setLayout(null);
        PDO.add(jPanel12);
        jPanel12.setBounds(830, 427, 420, 3);

        jPanel11.setBackground(new java.awt.Color(50, 100, 49));
        jPanel11.setLayout(null);
        PDO.add(jPanel11);
        jPanel11.setBounds(830, 510, 420, 3);

        jPanel10.setBackground(new java.awt.Color(50, 100, 49));
        jPanel10.setLayout(null);
        PDO.add(jPanel10);
        jPanel10.setBounds(830, 243, 420, 3);

        jPanel9.setBackground(new java.awt.Color(50, 100, 49));
        jPanel9.setLayout(null);

        jLabel41.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel41.setText("User Log In");
        jPanel9.add(jLabel41);
        jLabel41.setBounds(130, 30, 220, 60);

        PDO.add(jPanel9);
        jPanel9.setBounds(830, 153, 420, 3);

        jPanel8.setBackground(new java.awt.Color(50, 100, 49));
        jPanel8.setLayout(null);
        PDO.add(jPanel8);
        jPanel8.setBounds(830, 333, 420, 3);

        lblfn.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        lblfn.setText("First Name:");
        PDO.add(lblfn);
        lblfn.setBounds(660, 130, 140, 40);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel10.setText("Middle Name:");
        PDO.add(jLabel10);
        jLabel10.setBounds(640, 220, 160, 40);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel38.setText("Contact #:");
        PDO.add(jLabel38);
        jLabel38.setBounds(670, 480, 120, 40);

        txtfn.setEditable(false);
        txtfn.setBackground(new java.awt.Color(255, 255, 255));
        txtfn.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        txtfn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfn.setBorder(null);
        txtfn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnActionPerformed(evt);
            }
        });
        PDO.add(txtfn);
        txtfn.setBounds(830, 120, 420, 40);

        txtln.setEditable(false);
        txtln.setBackground(new java.awt.Color(255, 255, 255));
        txtln.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        txtln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtln.setBorder(null);
        txtln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlnActionPerformed(evt);
            }
        });
        PDO.add(txtln);
        txtln.setBounds(830, 300, 420, 40);

        txtmn1.setEditable(false);
        txtmn1.setBackground(new java.awt.Color(255, 255, 255));
        txtmn1.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        txtmn1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtmn1.setBorder(null);
        PDO.add(txtmn1);
        txtmn1.setBounds(830, 210, 420, 40);

        lblname.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PDO.add(lblname);
        lblname.setBounds(110, 400, 470, 70);

        btned.setBackground(new java.awt.Color(255, 255, 255));
        btned.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btned.setText("Edit Profile");
        btned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedActionPerformed(evt);
            }
        });
        PDO.add(btned);
        btned.setBounds(1090, 700, 240, 40);

        lbladorus.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbladorus.setForeground(new java.awt.Color(102, 102, 102));
        lbladorus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbladorus.setText("Admin");
        PDO.add(lbladorus);
        lbladorus.setBounds(250, 500, 170, 30);

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSave.setText("Save Changes");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnSave.setVisible(false);
        PDO.add(btnSave);
        btnSave.setBounds(260, 710, 240, 40);

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        btnBack.setVisible(false);
        PDO.add(btnBack);
        btnBack.setBounds(10, 710, 240, 40);

        lblDes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDes.setText("Teacher I");
        PDO.add(lblDes);
        lblDes.setBounds(230, 470, 210, 30);

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel58.setText("Last Name:");
        PDO.add(jLabel58);
        jLabel58.setBounds(660, 300, 160, 40);

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel59.setText("Birthday:");
        PDO.add(jLabel59);
        jLabel59.setBounds(680, 390, 120, 40);

        txtcont.setEditable(false);
        txtcont.setBackground(new java.awt.Color(255, 255, 255));
        txtcont.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        txtcont.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcont.setBorder(null);
        PDO.add(txtcont);
        txtcont.setBounds(830, 470, 420, 40);

        txtbd.setEditable(false);
        txtbd.setBackground(new java.awt.Color(255, 255, 255));
        txtbd.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        txtbd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtbd.setBorder(null);
        PDO.add(txtbd);
        txtbd.setBounds(830, 390, 420, 40);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        PDO.add(jPanel2);
        jPanel2.setBounds(80, 70, 5, 480);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        PDO.add(jPanel4);
        jPanel4.setBounds(80, 70, 513, 5);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        PDO.add(jPanel5);
        jPanel5.setBounds(590, 70, 5, 480);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        PDO.add(jPanel6);
        jPanel6.setBounds(80, 550, 515, 5);

        btnBro.setBackground(new java.awt.Color(255, 255, 255));
        btnBro.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnBro.setText("Upload photo");
        btnBro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroActionPerformed(evt);
            }
        });
        PDO.add(btnBro);
        btnBro.setBounds(190, 580, 150, 30);

        btnSv.setBackground(new java.awt.Color(255, 255, 255));
        btnSv.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnSv.setText("Save");
        btnSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSvActionPerformed(evt);
            }
        });
        PDO.add(btnSv);
        btnSv.setBounds(360, 580, 150, 30);

        lblGC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/oya.png"))); // NOI18N
        PDO.add(lblGC);
        lblGC.setBounds(180, 100, 330, 280);

        Panel.add(PDO, "card9");

        PEH.setBackground(new java.awt.Color(255, 255, 255));
        PEH.setLayout(null);

        LBLENROLL4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LBLENROLL4.setText("ENROLLMENT HISTORY");
        PEH.add(LBLENROLL4);
        LBLENROLL4.setBounds(20, 30, 410, 40);

        LBLENROLL5.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        LBLENROLL5.setForeground(new java.awt.Color(102, 102, 102));
        LBLENROLL5.setText("_________________________________________________________________________________________________________");
        PEH.add(LBLENROLL5);
        LBLENROLL5.setBounds(0, 60, 1370, 40);

        tblEH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblEH.setRowSelectionAllowed(false);
        tblEH.setEnabled(false);
        jScrollPane5.setViewportView(tblEH);

        PEH.add(jScrollPane5);
        jScrollPane5.setBounds(10, 180, 1340, 490);

        btnCH.setBackground(new java.awt.Color(255, 255, 255));
        btnCH.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnCH.setText("Clear History");
        btnCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCHActionPerformed(evt);
            }
        });
        PEH.add(btnCH);
        btnCH.setBounds(20, 710, 230, 25);

        btnEHPrint.setBackground(new java.awt.Color(255, 255, 255));
        btnEHPrint.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEHPrint.setText("Print");
        btnEHPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEHPrintActionPerformed(evt);
            }
        });
        PEH.add(btnEHPrint);
        btnEHPrint.setBounds(260, 710, 260, 24);

        lblAudit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/search.png"))); // NOI18N
        lblAudit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAudit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAuditMouseClicked(evt);
            }
        });
        PEH.add(lblAudit);
        lblAudit.setBounds(1300, 30, 50, 40);

        txtAudit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAudit.setForeground(new java.awt.Color(102, 102, 102));
        txtAudit.setText(" PLEASE ENTER USERNAME (PRESS ENTER TO SEARCH)");
        txtAudit.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtAudit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAuditFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAuditFocusLost(evt);
            }
        });
        txtAudit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAuditMouseEntered(evt);
            }
        });
        txtAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuditActionPerformed(evt);
            }
        });
        PEH.add(txtAudit);
        txtAudit.setBounds(880, 30, 470, 40);

        Panel.add(PEH, "card6");

        getContentPane().add(Panel);
        Panel.setBounds(310, 196, 1360, 760);

        PBackground.setBackground(new java.awt.Color(255, 255, 255));
        PBackground.setLayout(null);

        pnlLog.setBackground(new java.awt.Color(255, 255, 255));
        pnlLog.setToolTipText("");
        pnlLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlLogMouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/DITO NGA.png"))); // NOI18N
        jLabel12.setToolTipText("LOGOUT");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlLogLayout = new javax.swing.GroupLayout(pnlLog);
        pnlLog.setLayout(pnlLogLayout);
        pnlLogLayout.setHorizontalGroup(
            pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlLogLayout.setVerticalGroup(
            pnlLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PBackground.add(pnlLog);
        pnlLog.setBounds(1600, 140, 60, 54);
        pnlLog.setVisible(true);

        pnlDO.setBackground(new java.awt.Color(255, 255, 255));
        pnlDO.setToolTipText("OPTIONS");
        pnlDO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDOMouseExited(evt);
            }
        });
        pnlDO.setLayout(null);

        lblDO3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDO3.setForeground(new java.awt.Color(51, 51, 51));
        lblDO3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/Option.png"))); // NOI18N
        lblDO3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDO.add(lblDO3);
        lblDO3.setBounds(4, 8, 50, 40);

        PBackground.add(pnlDO);
        pnlDO.setBounds(1530, 140, 60, 54);

        lblUser.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PBackground.add(lblUser);
        lblUser.setBounds(120, 170, 280, 30);
        lblUser.setVisible(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("WELCOME:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setVisible(false);
        PBackground.add(jLabel14);
        jLabel14.setBounds(-10, 170, 140, 30);

        lblBg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/enrollmentsystem/Photos/Profile Header.png"))); // NOI18N
        lblBg1.setToolTipText("");
        lblBg1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblBg1MouseDragged(evt);
            }
        });
        lblBg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBg1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBg1MousePressed(evt);
            }
        });
        PBackground.add(lblBg1);
        lblBg1.setBounds(0, 0, 1670, 200);

        getContentPane().add(PBackground);
        PBackground.setBounds(0, 0, 1700, 900);

        setSize(new java.awt.Dimension(1700, 953));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseClicked
        try {
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "update tblacc set signed = 0 where username = '" + user + "'";
            st.executeUpdate(query);
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_eksMouseClicked

    private void eksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseEntered
        eks.setForeground(java.awt.Color.GRAY);
    }//GEN-LAST:event_eksMouseEntered

    private void eksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eksMouseExited
        eks.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_eksMouseExited

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        this.setState(TableAccounts.ICONIFIED);
    }//GEN-LAST:event_minMouseClicked

    private void minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseEntered
        min.setForeground(java.awt.Color.gray);
    }//GEN-LAST:event_minMouseEntered

    private void minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseExited
        min.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_minMouseExited

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - px, y - py);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        px = evt.getX();
        py = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void pnlHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHomeMouseEntered
        pnlHome.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlHomeMouseEntered

    private void pnlHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHomeMouseExited
        if (flag == 1) {

        } else {
            pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        }

    }//GEN-LAST:event_pnlHomeMouseExited

    private void pnlEMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEMMouseEntered
        pnlEM.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlEMMouseEntered

    private void pnlEMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEMMouseExited
        if (flag == 2) {

        } else {
            pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        }

    }//GEN-LAST:event_pnlEMMouseExited

    private void pnlEHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEHMouseEntered
        pnlEH.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlEHMouseEntered

    private void pnlEHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEHMouseExited
        if (flag == 3) {

        } else {
            pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        }
    }//GEN-LAST:event_pnlEHMouseExited

    private void pnlSMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSMMouseEntered
        pnlSM.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlSMMouseEntered

    private void pnlSMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSMMouseExited
        if (flag == 4) {

        } else {
            pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        }

    }//GEN-LAST:event_pnlSMMouseExited

    private void pnlRCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRCMouseEntered
        pnlRC.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlRCMouseEntered

    private void pnlRCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRCMouseExited
        if (flag == 5) {

        } else {
            pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        }

    }//GEN-LAST:event_pnlRCMouseExited

    private void pnlTMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTMMouseEntered
        pnlTM.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlTMMouseEntered

    private void pnlTMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTMMouseExited
        if (flag == 6) {

        } else {
            pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        }

    }//GEN-LAST:event_pnlTMMouseExited

    private void pnlDOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDOMouseEntered
        pnlDO.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_pnlDOMouseEntered

    private void pnlDOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDOMouseExited
        if (msExit != 1) {
            pnlDO.setBorder(null);
        }

    }//GEN-LAST:event_pnlDOMouseExited

    private void pnlEMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEMMouseClicked
        flag = 2;
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));

        //PHOME PEM PEH PSM PRC PER PSA PES PDO
        PHOME.setVisible(false);
        PEM.setVisible(true);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(false);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(false);
        pnlUO.setVisible(false);

    }//GEN-LAST:event_pnlEMMouseClicked

    private void pnlEHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEHMouseClicked

        flag = 3;
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));

        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(true);
        PSM.setVisible(false);
        PRC.setVisible(false);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(false);

        try {
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tblhistory order by date desc");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("");
            dtm.addColumn("Date/Time");
            tblEH.setModel(dtm);
            Vector vec;
            while (rs.next()) {
                vec = new Vector();
                vec.add(rs.getString("user") + rs.getString("ginawa"));
                vec.add(rs.getString("date"));
                dtm.addRow(vec);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_pnlEHMouseClicked

    private void pnlHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHomeMouseClicked
        flag = 1;
        PHOME.setVisible(true);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(false);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(false);

        //pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));
    }//GEN-LAST:event_pnlHomeMouseClicked

    private void pnlSMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSMMouseClicked
        flag = 4;
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));

        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(true);
        PRC.setVisible(false);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(false);
    }//GEN-LAST:event_pnlSMMouseClicked

    private void pnlRCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRCMouseClicked
        RequirementChecklist();

        flag = 5;
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));

        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(true);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(false);
    }//GEN-LAST:event_pnlRCMouseClicked

    private void pnlTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTMMouseClicked
        DefaultComboBoxModel mCBSC = new DefaultComboBoxModel();
        cbSY.setModel(mCBSC);
        //cbSY.addItem("Click Here");
        int nyear = 2020;
        for (int i = 2019; i <= 2080; i++) {
            cbSY.addItem(i + "-" + nyear);
            nyear++;
        }
        flag = 6;
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));

        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(false);
        PCR.setVisible(true);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(false);
    }//GEN-LAST:event_pnlTMMouseClicked

    private void pnlSAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSAMouseEntered
        pnlSA.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlSAMouseEntered

    private void pnlSAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSAMouseExited
        if (flag == 7) {

        } else {
            pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        }
    }//GEN-LAST:event_pnlSAMouseExited

    private void pnlESMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlESMouseEntered
        pnlES.setBackground(new java.awt.Color(0, 73, 0));
    }//GEN-LAST:event_pnlESMouseEntered

    private void pnlESMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlESMouseExited
        if (flag == 8) {

        } else {
            pnlES.setBackground(new java.awt.Color(50, 100, 49));
        }
    }//GEN-LAST:event_pnlESMouseExited

    private void pnlSAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSAMouseClicked
        if (acc == 0) {
            JOptionPane.showMessageDialog(null, "Please ask Admin for assistance", "Message", 2);
            return;
        }

        flag = 7;
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));

        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(false);
        PCR.setVisible(false);
        PSA.setVisible(true);
        PTM.setVisible(false);
        PDO.setVisible(false);
    }//GEN-LAST:event_pnlSAMouseClicked

    private void pnlESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlESMouseClicked

        flag = 8;
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
//        pnlDO.setBackground(new java.awt.Color(50, 100, 49));

        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(false);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(true);
        PDO.setVisible(false);
    }//GEN-LAST:event_pnlESMouseClicked

    private void pnlDOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDOMouseClicked
        //flag = 9;
        pnlDO.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        msExit = 1;
        if (msExit == 1) {
            pnlDO.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        }
        if (bago == 0) {

            pnlUO.setVisible(true);
            bago = 1;
        } else {
            bago = 0;
            pnlUO.setVisible(false);
        }


    }//GEN-LAST:event_pnlDOMouseClicked

    private void pnlLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogMouseEntered
        //   pnlLog.setBackground(new java.awt.Color(153, 153, 153));

    }//GEN-LAST:event_pnlLogMouseEntered

    private void pnlUOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlUOFocusLost
        pnlUO.setVisible(false);
    }//GEN-LAST:event_pnlUOFocusLost

    private void pnlLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogMouseExited
        pnlLog.setBorder(null);
    }//GEN-LAST:event_pnlLogMouseExited

    private void pnlCPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCPMouseEntered
        pnlCP.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_pnlCPMouseEntered

    private void pnlCPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCPMouseExited
        pnlCP.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_pnlCPMouseExited

    private void pnlEPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEPMouseExited
        pnlEP.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_pnlEPMouseExited

    private void pnlEPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEPMouseEntered
        pnlEP.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_pnlEPMouseEntered

    private void pnlLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogMouseClicked

    }//GEN-LAST:event_pnlLogMouseClicked

    private void pnlUOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUOMouseExited

    }//GEN-LAST:event_pnlUOMouseExited

    private void PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseEntered
        pnlDO.setBorder(null);
        pnlUO.setVisible(false);
    }//GEN-LAST:event_PanelMouseEntered

    private void PSelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PSelectMouseEntered
        pnlDO.setBorder(null);
        pnlUO.setVisible(false);
    }//GEN-LAST:event_PSelectMouseEntered

    private void lblviewprofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblviewprofileMouseClicked

        flag = 0;
        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(false);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(true);
        pnlUO.setVisible(false);
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlRC.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));
    }//GEN-LAST:event_lblviewprofileMouseClicked

    private void pnlEPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEPMouseClicked
        pnlUO.setVisible(false);
        if (acc == 1) {
            try {
              // Statement st1 = con.createStatement();
              Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                int rs1 = st1.executeUpdate("update poweruser set pu = 0");
                new TableAccounts(user).setVisible(true);
                this.dispose();
            } catch (Exception e) {
                System.err.println(e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "For Admins only");
        }
    }//GEN-LAST:event_pnlEPMouseClicked


    private void pnlCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCPMouseClicked
        pnlUO.setVisible(false);
        new ChangesPass(1, user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pnlCPMouseClicked

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

        if (saNum == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        int get = JOptionPane.showConfirmDialog(null, "Are you sure do you want to delete the selected units Permanently? " + "  ", "WARNING", 0, 0);
        if (get != 0) {
            return;
        }

        try {

            for (int i = 0; i < saTblCount; i++) {
                Boolean gb = (Boolean) tblSA.getValueAt(i, 0);
                if (gb == true) {
                    //idSA = (int) tblSA.getValueAt(i, 12);
                    int no = (int) tblSA.getValueAt(i, 13);

                 //   Statement st1 = con.createStatement();
                 Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st1.executeUpdate("delete from tblprof where id =" + no);
                    st1.executeUpdate("delete from tblprofacadinfo where id =" + no);
                    st1.executeUpdate("delete from tblprofperinfo where id =" + no);
                    st1.executeUpdate("delete from tblproffaminfo where id =" + no);
                    st1.executeUpdate("delete from tblrc where id =" + no);
                    st1.executeUpdate("delete from tblsub where id =" + no);

                   // Statement st = con.createStatement();
                   Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String date = dtf.format(now);
                    Object name = (tblSA.getValueAt(i, 1) + ", " + tblSA.getValueAt(i, 2) + " " + tblSA.getValueAt(i, 3));
                    st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has deleted " + name + " (STUDENT) ', '" + date + "')");

                }
            }

            saDisplay();
            JOptionPane.showMessageDialog(null, "Success!");
            saNum = 0;
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnDelActionPerformed

    private void tblSAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSAMouseClicked

        idSA = tblSA.getSelectedRow() + 1;
        saNum = 0;

        if (tblSA.getSelectedColumn() != 0) {
            sa = (Boolean) tblSA.getValueAt(idSA - 1, 0);
            if (sa == false) {
                tblSA.setValueAt(true, idSA - 1, 0);
            } else {
                tblSA.setValueAt(false, idSA - 1, 0);
            }
        }

        for (int i = 0; i < saTblCount; i++) {
            Boolean gb = (Boolean) tblSA.getValueAt(i, 0);
            if (gb == true) {
                saNum++;
            }
        }

    }//GEN-LAST:event_tblSAMouseClicked

    private void btnRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetActionPerformed

        if (saNum == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        int get = JOptionPane.showConfirmDialog(null, "Are you sure do you want to retrieve the selected units? " + "  ", "Message", 0, 1);
        if (get != 0) {
            return;
        }

        try {
            for (int i = 0; i < saTblCount; i++) {
                Boolean gb = (Boolean) tblSA.getValueAt(i, 0);
                if (gb == true) {
                    //idSA = (int) tblSA.getValueAt(i, 12);
                    int no = (int) tblSA.getValueAt(i, 13);

                  //  Statement st = con.createStatement();
                  Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                            + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                            + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                            + "pr.id = prfi.id and prpf.id = pr.id;");
                    Object name = tblSA.getValueAt(i, 2);
                    name += ", " + tblSA.getValueAt(i, 3);
                    name += " " + tblSA.getValueAt(i, 4);
                    //rs.absolute(idSA);
                //    Statement st1 = con.createStatement();
                Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st.executeUpdate("update tblprofacadinfo set archived = " + 0 + " where id = " + no);
                    st.executeUpdate("update tblrc set archived = " + 0 + " where id = " + no);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String date = dtf.format(now);
                    st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('"
                            + txtUser.getText() + "',' has retrieved " + name + "', '" + date + "')");

                }
            }

            JOptionPane.showMessageDialog(null, "Success!");
            saDisplay();
            emDisplay();
            RequirementChecklist();
            StudentMasterlist();
            saNum = 0;

        } catch (Exception e) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_btnRetActionPerformed

    public void PEMSearch() throws Exception {
        id = 0;
        emCount = 0;
        count = 0;
        ss++;
        String x = txtFSearch.getText().trim();
        try {
            if (txtFSearch.getText().trim().equals("")) {
                emDisplay();
            } else {
                DefaultTableModel dtmEM = new DefaultTableModel();
                tblEM.setModel(dtmEM);
                tblEM = new JTable(dtmEM) {
                    @Override
                    public Class getColumnClass(int column) {
                        switch (column) {
                            case 0:
                                return Boolean.class;
                            default:
                                return String.class;
                        }
                    }

                    public boolean isCellEditable(int row, int column) {
                        switch (column) {
                            case 0:
                                return true;
                            default:
                                return false;
                        }

                    }
                };

                dtmEM.addColumn("");
                dtmEM.addColumn("LRN");
                dtmEM.addColumn("FULL NAME");
                dtmEM.addColumn("GRADE");
                dtmEM.addColumn("SECTION");
                dtmEM.addColumn("STUDENT TYPE");
                dtmEM.addColumn("DATE");
                dtmEM.addColumn("NO.");

                tblEM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tblEM.getColumnModel().getColumn(0).setPreferredWidth(40);
                tblEM.getColumnModel().getColumn(1).setPreferredWidth(250);
                tblEM.getColumnModel().getColumn(2).setPreferredWidth(350);
                tblEM.getColumnModel().getColumn(3).setPreferredWidth(215);
                tblEM.getColumnModel().getColumn(4).setPreferredWidth(215);
                tblEM.getColumnModel().getColumn(5).setPreferredWidth(255);
                tblEM.getColumnModel().getColumn(6).setPreferredWidth(200);
                tblEM.getColumnModel().getColumn(7).setPreferredWidth(50);//a
                tblEM.setRowHeight(35);

                tblEM.setSelectionMode(SINGLE_SELECTION);
                tblEM.setSelectionBackground(new java.awt.Color(50, 100, 49));
                tblEM.getTableHeader().setResizingAllowed(false);
                tblEM.getTableHeader().setReorderingAllowed(false);
                tblEM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));//aa

               // Statement st = con.createStatement();
               Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("select pr.*,prpf.*,prai.* "
                        + "from tblprof pr,"
                        + "tblprofperinfo prpf, tblprofacadinfo prai where "
                        + "(pr.id = prpf.id and pr.id = prai.id and prpf.fname like '%" + txtFSearch.getText() + "%') or "
                        + "(pr.id = prpf.id and pr.id = prai.id and prpf.mname like '%" + txtFSearch.getText() + "%')"
                        + " or (pr.id = prpf.id and pr.id = prai.id and prpf.lname like '%" + txtFSearch.getText() + "%')"
                        + "or (pr.id = prpf.id and pr.id = prai.id and pr.lrn like '%" + txtFSearch.getText() + "%');");

                while (rs.next()) {
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        ss++;
                        if (rs.getInt("archived") == 1) {
                        } else {
                            count++;
                            vec = new Vector();
                            vec.add(false);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            emCount++;
                        }
                    }
                }

                if (emCount == 0) {
                    emDisplay();
                    JOptionPane.showMessageDialog(null, "No items found!");
                    return;

                }

                tblEM.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tblEMMouseClicked(evt);
                    }
                });

                lblCount.setText(emCount + "");
                jScrollPane1.setViewportView(tblEM);

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void PSMSearch() throws Exception {
        smCount = 0;
        dtSM = new DefaultTableModel();
        tblSM.setModel(dtSM);
        dtSM.addColumn("LRN");
        dtSM.addColumn("FULL NAME");
        dtSM.addColumn("SECTION");
        dtSM.addColumn("Student Type");
        dtSM.addColumn("YEAR LEVEL");
        dtSM.addColumn("DATE ADDED");
        dtSM.addColumn("STATUS");
        dtSM.addColumn("NO.");

        tblSM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblSM.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblSM.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblSM.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblSM.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblSM.getColumnModel().getColumn(4).setPreferredWidth(170);
        tblSM.getColumnModel().getColumn(5).setPreferredWidth(130);
        tblSM.getColumnModel().getColumn(6).setPreferredWidth(130);
        tblSM.getColumnModel().getColumn(7).setPreferredWidth(70);
        tblSM.setRowHeight(35);

        tblSM.setSelectionMode(SINGLE_SELECTION);
        tblSM.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblSM.getTableHeader().setResizingAllowed(false);
        tblSM.getTableHeader().setReorderingAllowed(false);
        tblSM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
        tblSM.setFont(new java.awt.Font("Times New Roman", 0, 14));

       // Statement st = con.createStatement();
       Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select prrc.*,prpf.*,prai.*,pr.* "
                + "from tblrc prrc, tblprof pr,"
                + "tblprofperinfo prpf, tblprofacadinfo prai where "
                + "(pr.id = prrc.id and prrc.id = prpf.id and prrc.id = prai.id and prpf.fname like '%" + txtSmSearch.getText().trim() + "%') or "
                + "(pr.id = prrc.id and prrc.id = prpf.id and prrc.id = prai.id and prpf.mname like '%" + txtSmSearch.getText().trim() + "%')"
                + " or (pr.id = prrc.id and prrc.id = prpf.id and prrc.id = prai.id and prpf.lname like '%" + txtSmSearch.getText().trim() + "%')"
                + "or (pr.id = prrc.id and prrc.id = prpf.id and prrc.id = prai.id and prrc.lrn like '%" + txtSmSearch.getText().trim() + "%');");

        while (rs.next()) {
            if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                if (rs.getInt("archived") == 0) {
                    if (!rs.getString("section").equals("PRE-AD")) {
                        Vector vec = new Vector();
                        vec.add(rs.getString("lrn"));
                        if (rs.getString("mname").equals("")) {
                            vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                        } else {
                            vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                        }
                        vec.add(rs.getString("section"));
                        vec.add(rs.getString("student_type"));
                        vec.add(rs.getString("eag"));
                        vec.add(rs.getString("date"));
                        vec.add(rs.getString("status"));
                        vec.add(rs.getString("id"));
                        smCount++;
                        dtSM.addRow(vec);
                    }
                }
            }
        }
        lblSmCount.setText(smCount + "");
    }

    private void tblSMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSMMouseClicked
        idSM = tblSM.getSelectedRow() + 1;
        System.out.println(idSM);
    }//GEN-LAST:event_tblSMMouseClicked

    private void tblSMMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSMMouseReleased

    }//GEN-LAST:event_tblSMMouseReleased

    private void tblSAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSAMouseReleased
        idSA = tblSA.getSelectedRow();
    }//GEN-LAST:event_tblSAMouseReleased

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        if (idSM == 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Row!");
            return;
        }
        try {
            panelSMTBL.setVisible(false);
            pnlSub.setVisible(true);
            LBLENROLL7.setText("ENROLLMENT REPORT");
            ViewSub();
            idSM = 0;

        } catch (Exception ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_viewActionPerformed

    private void btnSmBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSmBackActionPerformed
        pnlSub.setVisible(false);
        panelSMTBL.setVisible(true);
        LBLENROLL7.setText("STUDENT MASTERLIST");
    }//GEN-LAST:event_btnSmBackActionPerformed

    private void tblRCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRCMouseClicked

        try {
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tblrc");

            int row = tblRC.getSelectedRow();
            int col = tblRC.getSelectedColumn();
            int p = tblRC.getSelectedColumn();

            String id3 = (String) tblRC.getValueAt(row, 9);

            if (p > 1 && p != 8 && p != 9) {
                Boolean user = (Boolean) tblRC.getValueAt(row, col);

                if (col == 0 || col == 1) {
                } else if (col == 2) {
                   // Statement st2 = con.createStatement();
                   Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st2.executeUpdate("update tblrc set e_form = " + user.booleanValue() + " where id =" + id3);
                } else if (col == 3) {
                   // Statement st2 = con.createStatement();
                   Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st2.executeUpdate("update tblrc set g_card = " + user.booleanValue() + " where id =" + id3);
                } else if (col == 4) {
                  //  Statement st2 = con.createStatement();
                  Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st2.executeUpdate("update tblrc set f137 = " + user.booleanValue() + " where id =" + id3);
                } else if (col == 5) {
                   // Statement st2 = con.createStatement();
                   Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st2.executeUpdate("update tblrc set nso = " + user.booleanValue() + " where id =" + id3);
                } else if (col == 6) {
                 //  Statement st2 = con.createStatement();
                 Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st2.executeUpdate("update tblrc set gm = " + user.booleanValue() + " where id =" + id3);
                } else if (col == 7) {
                    Statement st2 = con.createStatement();
                    st2.executeUpdate("update tblrc set ncae = " + user.booleanValue() + " where id =" + id3);
                }

                String lrn2 = tblRC.getValueAt(row, 9).toString();
                rs = st.executeQuery("select * from tblrc");
                int ctr = 0;
                while (rs.next()) {
                    if (lrn2.equals(rs.getString("id"))) {
                        if (rs.getBoolean("e_form") == true && rs.getBoolean("g_card") == true && rs.getBoolean("f137") == true
                                && rs.getBoolean("nso") == true && rs.getBoolean("gm") == true && rs.getBoolean("ncae") == true && !rs.getString("lrn").equals("N/A")) {
                            ctr = 1;
                            break;
                        }
                    }
                }
             //   st = con.createStatement();
              st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                if (ctr == 1) {
                    st.executeUpdate("update tblrc set status = 'Enrolled' where id = " + lrn2);
                } else {
                    st.executeUpdate("update tblrc set status = 'Pending' where id = " + lrn2);
                }

            } else {
                rcRow = tblRC.getSelectedRow();
               // Statement st3 = con.createStatement();
               Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs3 = st.executeQuery("select * from tblrc");

                while (rs3.next()) {
                    if (id3.equals(rs3.getString("id"))) {
                        txtRcLrn.setText(" " + rs3.getString("Lrn"));
                        txtRcFn.setText(" " + rs3.getString("full_name"));
                        txtId.setText(" " + rs3.getString("id"));
                        scanID = rs3.getString("id");
                    }

                }

            }
            StudentMasterlist();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_tblRCMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try {
            bck();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnBackActionPerformed

    public void bck() throws Exception {
        btnBack.setVisible(false);
        btnSave.setVisible(false);
        btned.setVisible(true);
        txtfn.setEditable(false);
        txtmn1.setEditable(false);
        txtln.setEditable(false);

        try {
            String mi = "".toUpperCase();
            //Statement st2 = con.createStatement();
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st2.executeQuery("select * from tblacc");

            while (rs2.next()) {
                if (rs2.getString("username").equals(user)) {
                    int ctr = 0;
                    if (rs2.getString("MiddleName").length() != 0) {
                        mi = rs2.getString("MiddleName").toUpperCase().charAt(0) + ".";
                    }
                    while (ctr < rs2.getString("MiddleName").length()) {
                        switch (rs2.getString("middlename").charAt(ctr)) {
                            case ' ':
                                mi = mi + rs2.getString("middlename").charAt(ctr + 1) + ".";
                                break;
                        }
                        ctr++;
                    }

                    lblUser.setText(rs2.getString("FirstName") + " " + mi
                            + " " + rs2.getString("LastName"));
                    lblFN1.setText(rs2.getString("FirstName") + " "
                            + " " + rs2.getString("LastName"));
                    lblname.setText(rs2.getString("FirstName") + " " + mi
                            + " " + rs2.getString("LastName"));
                    txtfn.setText(rs2.getString("firstname"));
                    txtmn1.setText(rs2.getString("Middlename"));
                    txtln.setText(rs2.getString("Lastname"));
                    txtcont.setText(rs2.getString("contact"));
                    acc = rs2.getInt("admin");
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        int get = JOptionPane.showConfirmDialog(null, "Do you want to Save Changes?   ", "Message", 0, 2);
        if (get != 0) {
            return;
        }

        if (txtfn.getText().equals("") || txtln.getText().equals("") || txtfn.getText().equals(" ") || txtln.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Please Fill up Empty Fields!");
            return;
        }

        for (int ctr = 0; ctr < txtfn.getText().length(); ctr++) {
            switch (txtfn.getText().toLowerCase().charAt(ctr)) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case ' ':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Field must not Contain Special Characters or Numbers!");
                    return;
            }
        }

        for (int ctr = 0; ctr < txtmn1.getText().length(); ctr++) {
            switch (txtmn1.getText().toLowerCase().charAt(ctr)) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case ' ':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Field must not Contain Special Characters or Numbers!");
                    return;
            }
        }
        for (int ctr = 0; ctr < txtln.getText().length(); ctr++) {
            switch (txtln.getText().toLowerCase().charAt(ctr)) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case ' ':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Field must not Contain Special Characters or Numbers!");
                    return;
            }
        }

        for (int ctr = 0; ctr < txtcont.getText().length(); ctr++) {
            switch (txtcont.getText().toLowerCase().charAt(ctr)) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                case '-':
                case '+':

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Field must not Contain Special Characters or Letters!");
                    return;
            }
        }

        try {
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("update tblacc set firstname ='" + txtfn.getText().trim() + "',middlename='"
                    + txtmn1.getText().trim() + "',lastname = '" + txtln.getText().trim() + "',contact = '" + txtcont.getText().trim() + "' where username ='" + user.trim() + "'");

            String mi = "".toUpperCase();
            //Statement st2 = con.createStatement();
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st2.executeQuery("select * from tblacc");

            while (rs2.next()) {
                if (rs2.getInt("signed") == 2) {
                    int ctr = 0;
                    if (rs2.getString("MiddleName").length() != 0) {
                        mi = rs2.getString("MiddleName").toUpperCase().charAt(0) + ".";
                    }
                    while (ctr < rs2.getString("MiddleName").length()) {
                        switch (rs2.getString("middlename").charAt(ctr)) {
                            case ' ':
                                mi = mi + rs2.getString("middlename").charAt(ctr + 1) + ".";
                                break;
                        }
                        ctr++;
                    }

                    lblUser.setText(rs2.getString("FirstName") + " " + mi
                            + " " + rs2.getString("LastName"));
                    lblFN1.setText(rs2.getString("FirstName") + " "
                            + " " + rs2.getString("LastName"));
                    lblname.setText(rs2.getString("FirstName") + " " + mi
                            + " " + rs2.getString("LastName"));
                    txtfn.setText(rs2.getString("firstname"));
                    txtmn1.setText(rs2.getString("Middlename"));
                    txtln.setText(rs2.getString("Lastname"));
                    acc = rs2.getInt("admin");

                    if (lblname.getText().length() > 15) {
                        lblname.setFont(new java.awt.Font("Times New Roman", 1, 24));
                    } else {
                        lblname.setFont(new java.awt.Font("Times New Roman", 1, 48));
                    }

                    break;
                }
            }

            btnBack.setVisible(false);
            btnSave.setVisible(false);
            btned.setVisible(true);
            txtfn.setEditable(false);
            txtmn1.setEditable(false);
            txtln.setEditable(false);
            JOptionPane.showMessageDialog(null, "Success");
            bck();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedActionPerformed

        btnBack.setVisible(true);
        btnSave.setVisible(true);
        btned.setVisible(false);
        txtfn.setEditable(true);
        txtmn1.setEditable(true);
        txtln.setEditable(true);
        txtcont.setEditable(true);
    }//GEN-LAST:event_btnedActionPerformed

    private void txtlnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlnActionPerformed

    private void txtfnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnActionPerformed

    }//GEN-LAST:event_txtfnActionPerformed

    private void txtRcSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRcSearchFocusLost

        txtRcSearch.setText(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)");
        txtRcSearch.setHorizontalAlignment(javax.swing.JTextField.LEADING);
    }//GEN-LAST:event_txtRcSearchFocusLost

    private void txtRcSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtRcSearchCaretUpdate

    }//GEN-LAST:event_txtRcSearchCaretUpdate

    private void txtRcSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRcSearchActionPerformed
        try {
            RCSearch();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_txtRcSearchActionPerformed

    private void txtRcSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRcSearchMousePressed
        if (txtRcSearch.getText().equals(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)")) {
            txtRcSearch.setText("");
        }
    }//GEN-LAST:event_txtRcSearchMousePressed

    private void lblChecklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChecklistMouseClicked

        try {
            RCSearch();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_lblChecklistMouseClicked

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        try {
            if (smTS.equals("Strand") && smYL.equals("Year Level")) {
                JOptionPane.showMessageDialog(null, "Please Select an Item", "Message", 2);
                return;
            }

            String sect = "";
            String sect2 = "";
            String yl = "";
            int ctr = 0;

            smCount = 0;
            DefaultTableModel dtSM = new DefaultTableModel();
            tblSM.setModel(dtSM);
            dtSM.addColumn("LRN");
            dtSM.addColumn("FULL NAME");
            dtSM.addColumn("SECTION");
            dtSM.addColumn("Student Type");
            dtSM.addColumn("YEAR LEVEL");
            dtSM.addColumn("DATE ADDED");
            dtSM.addColumn("STATUS");
            dtSM.addColumn("NO.");

            tblSM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblSM.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblSM.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblSM.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblSM.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblSM.getColumnModel().getColumn(4).setPreferredWidth(170);
            tblSM.getColumnModel().getColumn(5).setPreferredWidth(130);
            tblSM.getColumnModel().getColumn(6).setPreferredWidth(130);
            tblSM.getColumnModel().getColumn(7).setPreferredWidth(70);
            tblSM.setRowHeight(35);

            tblSM.setSelectionMode(SINGLE_SELECTION);
            tblSM.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblSM.getTableHeader().setResizingAllowed(false);
            tblSM.getTableHeader().setReorderingAllowed(false);
            tblSM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
            tblSM.setFont(new java.awt.Font("Times New Roman", 0, 14));

            //Statement st = con.createStatement();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");

            while (rs.next()) {
                if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                    if (rs.getInt("archived") == 0) {
                        if (!rs.getString("section").equals("PRE-AD")) {
                            sect = rs.getString("section");
                            sect2 = sect.substring(0, 3);
                            yl = rs.getString("eag");
                            if (sect.substring(0, 3).equals("TVL") && smTS.equals("TVL") && yl.equals(smYL)) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (sect.substring(0, 4).equals("STEM") && smTS.equals("STEM") && smTS.equals("STEM") && yl.equals(smYL)) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (sect.substring(0, 3).equals("ABM") && smTS.equals("ABM") && yl.equals(smYL)) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (sect.substring(0, 4).equals("Arts") && smTS.equals("Arts and Design") && yl.equals(smYL)) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (sect.substring(0, 5).equals("Sport") && smTS.equals("Sports") && yl.equals(smYL)) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (sect.substring(0, 5).equals("HUMSS") && smTS.equals("HUMSS") && yl.equals(smYL)) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (yl.equals(smYL) && smTS.equals("Strand")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (smYL.equals("Year Level") && smTS.equals("TVL") && sect2.equals("TVL")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (smYL.equals("Year Level") && smTS.equals("STEM") && sect2.equals("STE")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (smYL.equals("Year Level") && smTS.equals("ABM") && sect2.equals("ABM")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (smYL.equals("Year Level") && smTS.equals("Arts and Design") && sect2.equals("Art")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (smYL.equals("Year Level") && smTS.equals("Sports") && sect2.equals("Spo")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            } else if (smYL.equals("Year Level") && smTS.equals("HUMSS") && sect2.equals("HUM")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            }

                        }
                    }
                }
            }
            lblSmCount.setText(smCount + "");
            if (smCount == 0) {
                JOptionPane.showMessageDialog(null, "No Result(s) Found!", "Message", 2);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void cbSmTsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSmTsActionPerformed
        smTS = (String) cbSmTs.getSelectedItem();
    }//GEN-LAST:event_cbSmTsActionPerformed

    private void cbSmYlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSmYlActionPerformed
        smYL = (String) cbSmYl.getSelectedItem();
    }//GEN-LAST:event_cbSmYlActionPerformed

    private void cbSmTsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSmTsMouseClicked
        if (first == 0) {
            cbSmTs.removeItemAt(0);
            first++;
        }
    }//GEN-LAST:event_cbSmTsMouseClicked

    private void cbSmYlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSmYlMouseClicked
        if (firstt == 0) {
            cbSmYl.removeItemAt(0);
            firstt++;
        } else {
        }
    }//GEN-LAST:event_cbSmYlMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            StudentMasterlist();
            CBSmTs();
            CBSmYl();
            firsttt = 0;
            firstt = 0;
            first = 0;
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSecActionPerformed

    private void btnClLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClLoadActionPerformed
        try {
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id order by lname asc;");

            if (cbSec.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please select Track/Strands/Section");
                return;
            }
            lblSec.setText(cbSec.getSelectedItem() + "");
            lblLevel.setText(cbLvl.getSelectedItem() + "");
            lblSYear.setText(cbSY.getSelectedItem() + "");
            lblSEM.setText(cbSem.getSelectedItem() + "");
            lblSec.setVisible(true);
            lblSYear.setVisible(true);
            lblTrack.setVisible(true);
            lblSEM.setVisible(true);
            lblSY.setVisible(true);
            if (cbSec.getSelectedIndex() == 1) {
                lblTrack.setText("PROGRAMMING");
            }
            if (cbSec.getSelectedIndex() == 2) {
                lblTrack.setText("COMPUTER SYSTEM SERVICING (CSS)");
            }
            if (cbSec.getSelectedIndex() == 3) {
                lblTrack.setText("ANIMATION");
            }
            if (cbSec.getSelectedIndex() == 4) {
                lblTrack.setText("BREAD AND PASTRY PRODUCTION");
            }
            if (cbSec.getSelectedIndex() == 5) {
                lblTrack.setText("HOUSEKEEPING");
            }
            if (cbSec.getSelectedIndex() == 6) {
                lblTrack.setText("COOKERY");
            }
            if (cbSec.getSelectedIndex() == 7) {
                lblTrack.setText("AUTOMOTIVE");
            }
            if (cbSec.getSelectedIndex() == 8) {
                lblTrack.setText("REPAIR AND INSTALLATION");
            }
            if (cbSec.getSelectedIndex() == 9) {
                lblTrack.setText("WELDING");
            }
            if (cbSec.getSelectedIndex() == 10 || cbSec.getSelectedIndex() == 11
                    || cbSec.getSelectedIndex() == 12 || cbSec.getSelectedIndex() == 13
                    || cbSec.getSelectedIndex() == 14 || cbSec.getSelectedIndex() == 15
                    || cbSec.getSelectedIndex() == 16 || cbSec.getSelectedIndex() == 17) {
                lblTrack.setText("ENGINEERING");
            }
            if (cbSec.getSelectedIndex() == 18 || cbSec.getSelectedIndex() == 19) {
                lblTrack.setText("ACCOUNTANCY");
            }
            if (cbSec.getSelectedIndex() == 20) {
                lblTrack.setText("BUSINESS ADD");
            }
            if (cbSec.getSelectedIndex() == 21) {
                lblTrack.setText("ENTREP");
            }
            if (cbSec.getSelectedIndex() == 22) {
                lblTrack.setText("ARTS AND DESIGN");
            }
            if (cbSec.getSelectedIndex() == 23) {
                lblTrack.setText("SPORTS");
            }
            if (cbSec.getSelectedIndex() == 24 || cbSec.getSelectedIndex() == 25
                    || cbSec.getSelectedIndex() == 26 || cbSec.getSelectedIndex() == 27) {
                lblTrack.setText("Humanities and Social Sciences (HUMSS)");
            }
            int temp = 1;
            int temp1 = 1;
            txtaMale.setText("");
            txtaFem.setText("");
            txtaFem.append("\n");
            txtaMale.append("\n");
            while (rs.next()) {
                if (!rs.getString("archived").equals("1")) {
                    if (rs.getString("section").equals(cbSec.getSelectedItem())
                            && rs.getString("eag").equals(cbLvl.getSelectedItem())
                            && rs.getString("Sy").equals(cbSY.getSelectedItem())
                            && rs.getString("Semester").equals(cbSem.getSelectedItem())) {

                        if (rs.getString("gender").equals("Male")) {
                            txtaMale.append(" " + temp + ". " + rs.getString("lname") + ", "
                                    + rs.getString("fname") + " "
                                    + rs.getString("mname") + "\n");
                            txtaMale.append("\n");
                            temp++;
                        } else {

                            txtaFem.append(" " + temp1 + ". " + rs.getString("lname") + ", "
                                    + rs.getString("fname") + " "
                                    + rs.getString("mname") + "\n");
                            txtaFem.append("\n");
                            temp1++;
                        }
                    }

                }
            }

           // Statement st2 = con.createStatement();
           Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st2.executeQuery("select * from tbltm order by advisory asc");
            String ylvel = "";
            String sc = "";
            while (rs2.next()) {
                if (rs2.getString("advisory") != null) {
                    ylvel = rs2.getString("advisory").substring(0, 8);
                    sc = rs2.getString("advisory").substring(11);
                }
                System.out.println(sc);

                if (cbLvl.getSelectedItem().equals(ylvel) && cbSec.getSelectedItem().equals(sc)) {
                    lblCrAd.setText(rs2.getString("fname") + " " + rs2.getString("mname") + " " + rs2.getString("lname"));
                    break;
                } else {
                    lblCrAd.setText("N/A");
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

//        try {
//
//        } catch (Exception e) {
//            System.err.println(e);
//        }
    }//GEN-LAST:event_btnClLoadActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.PORTRAIT);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) pg;
                g2.translate(pf.getImageableX() + 10, pf.getImageableY() + 20);
                g2.scale(0.62, 0.650);
//                g2.scale(0.63, 0.700);

                PNLCR.paint(g2);
                return Printable.PAGE_EXISTS;

            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please set the paper to a4 size!", "MESSAGE", 2);
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PCRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PCRMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PCRMouseClicked

    private void cbSYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSYActionPerformed

    private void btnVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVActionPerformed
        if (rcRow == -1) {
            JOptionPane.showMessageDialog(null, "Please Select a row!");
            return;
        }

        pnlRc1.setVisible(false);
        jLabel4.setVisible(false);
        lblCount2.setVisible(false);
        pnlRc2.setVisible(true);
        btnRcBack.setVisible(true);
        btnV.setVisible(false);
        btnSv.setVisible(true);
        btnBro.setVisible(true);


    }//GEN-LAST:event_btnVActionPerformed

    private void btnRcBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRcBackActionPerformed
        pnlRc1.setVisible(true);
        jLabel4.setVisible(true);
        lblCount2.setVisible(true);
        pnlRc2.setVisible(false);
        btnRcBack.setVisible(false);
        btnV.setVisible(true);
        lblGC.setIcon(null);
        btnSv.setVisible(false);
        btnBro.setVisible(false);
        cbRcSearch.setSelectedIndex(0);
    }//GEN-LAST:event_btnRcBackActionPerformed

    private void cbRcSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRcSearchActionPerformed

        try {

            if (cbRcSearch.getSelectedIndex() == 0) {
                p.setVisible(true);
                pnlGcard.setVisible(false);
                pnlForm137.setVisible(false);
                pnlBC.setVisible(false);
                pnlGM.setVisible(false);
                pnlNcae.setVisible(false);
            } else if (cbRcSearch.getSelectedIndex() == 1) {
                p.setVisible(false);
                pnlGcard.setVisible(true);
                pnlForm137.setVisible(false);
                pnlBC.setVisible(false);
                pnlGM.setVisible(false);
                pnlNcae.setVisible(false);

            } else if (cbRcSearch.getSelectedIndex() == 2) {
                p.setVisible(false);
                pnlGcard.setVisible(false);
                pnlForm137.setVisible(true);
                pnlBC.setVisible(false);
                pnlGM.setVisible(false);
                pnlNcae.setVisible(false);
            } else if (cbRcSearch.getSelectedIndex() == 3) {
                p.setVisible(false);
                pnlGcard.setVisible(false);
                pnlForm137.setVisible(false);
                pnlBC.setVisible(true);
                pnlGM.setVisible(false);
                pnlNcae.setVisible(false);
            } else if (cbRcSearch.getSelectedIndex() == 4) {
                p.setVisible(false);
                pnlGcard.setVisible(false);
                pnlForm137.setVisible(false);
                pnlBC.setVisible(false);
                pnlGM.setVisible(true);
                pnlNcae.setVisible(false);
            } else if (cbRcSearch.getSelectedIndex() == 5) {
                p.setVisible(false);
                pnlGcard.setVisible(false);
                pnlForm137.setVisible(false);
                pnlBC.setVisible(false);
                pnlGM.setVisible(false);
                pnlNcae.setVisible(true);
            }

            //Statement st = con.createStatement();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from images");
            while (rs.next()) {
                if (scanID.equals(rs.getString("id"))) {
                    if (cbRcSearch.getSelectedIndex() == 1) {
                        if (rs.getString(("gcard")).equals("null")) {
                        } else {
                            lblGC.setIcon(ResizeImage(rs.getString("gcard")));
                        }
                    }

                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_cbRcSearchActionPerformed

    private void cbSortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSortItemStateChanged

    }//GEN-LAST:event_cbSortItemStateChanged

    private void cbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSortActionPerformed
        try {
            smCount = 0;
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            dtSM = new DefaultTableModel();
            tblSM.setModel(dtSM);
            dtSM.addColumn("LRN");
            dtSM.addColumn("FULL NAME");
            dtSM.addColumn("SECTION");
            dtSM.addColumn("Student Type");
            dtSM.addColumn("YEAR LEVEL");
            dtSM.addColumn("DATE ADDED");
            dtSM.addColumn("STATUS");
            dtSM.addColumn("NO.");

            tblSM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblSM.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblSM.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblSM.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblSM.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblSM.getColumnModel().getColumn(4).setPreferredWidth(170);
            tblSM.getColumnModel().getColumn(5).setPreferredWidth(130);
            tblSM.getColumnModel().getColumn(6).setPreferredWidth(130);
            tblSM.getColumnModel().getColumn(7).setPreferredWidth(70);
            tblSM.setRowHeight(35);

            tblSM.setSelectionMode(SINGLE_SELECTION);
            tblSM.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblSM.getTableHeader().setResizingAllowed(false);
            tblSM.getTableHeader().setReorderingAllowed(false);
            tblSM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
            tblSM.setFont(new java.awt.Font("Times New Roman", 0, 14));

            if (cbSort.getSelectedItem().equals("Name Ascending")) {
                rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prc.* from tblrc prc,tblprof"
                        + " pr,tblprofacadinfo prai,tblproffaminfo prfi,tblprofperinfo prpf where"
                        + " pr.id = prai.id and pr.id = prfi.id and prpf.id = pr.id  and pr.id = prc.id order by lname asc;");

                while (rs.next()) {
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        if (rs.getInt("archived") == 0) {
                            if (!rs.getString("section").equals("PRE-AD")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            }
                        }
                    }
                }
                lblSmCount.setText(smCount + "");
                smCount = 0;
            }

            if (cbSort.getSelectedItem().equals("Name Descending")) {
                rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prc.* from tblrc prc,tblprof"
                        + " pr,tblprofacadinfo prai,tblproffaminfo prfi,tblprofperinfo prpf where"
                        + " pr.id = prai.id and pr.id = prfi.id and prpf.id = pr.id  and pr.id = prc.id order by lname desc;");
                while (rs.next()) {
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        if (rs.getInt("archived") == 0) {
                            if (!rs.getString("section").equals("PRE-AD")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            }
                        }
                    }
                }//dulo 

                lblSmCount.setText(smCount + "");
                smCount = 0;
            }

            if (cbSort.getSelectedItem().equals("Status Pending")) {
                rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prc.* from tblrc prc,tblprof"
                        + " pr,tblprofacadinfo prai,tblproffaminfo prfi,tblprofperinfo prpf where"
                        + " pr.id = prai.id and pr.id = prfi.id and prpf.id = pr.id  and pr.id = prc.id order by Status desc;");
                while (rs.next()) {
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        if (rs.getInt("archived") == 0) {
                            if (!rs.getString("section").equals("PRE-AD")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            }
                        }
                    }
                }

                lblSmCount.setText(smCount + "");
                smCount = 0;
            }//eto yung totoong dulo

            if (cbSort.getSelectedItem().equals("Status Enrolled")) {
                rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prc.* from tblrc prc,tblprof"
                        + " pr,tblprofacadinfo prai,tblproffaminfo prfi,tblprofperinfo prpf where"
                        + " pr.id = prai.id and pr.id = prfi.id and prpf.id = pr.id  and pr.id = prc.id order by Status asc;");
                while (rs.next()) {
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        if (rs.getInt("archived") == 0) {
                            if (!rs.getString("section").equals("PRE-AD")) {
                                Vector vec = new Vector();
                                vec.add(rs.getString("lrn"));
                                if (rs.getString("mname").equals("")) {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                                } else {
                                    vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                                }
                                vec.add(rs.getString("section"));
                                vec.add(rs.getString("student_type"));
                                vec.add(rs.getString("eag"));
                                vec.add(rs.getString("date"));
                                vec.add(rs.getString("status"));
                                vec.add(rs.getString("id"));
                                smCount++;
                                dtSM.addRow(vec);
                            }
                        }
                    }
                }

                lblSmCount.setText(smCount + "");
                smCount = 0;
                System.out.println("hehe");
            }//eto yung totoong dulo
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_cbSortActionPerformed

    private void txtSmSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSmSearchFocusLost
        txtSmSearch.setText(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)");
    }//GEN-LAST:event_txtSmSearchFocusLost

    private void txtSmSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSmSearchActionPerformed
        try {
            PSMSearch();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_txtSmSearchActionPerformed

    private void lblSmSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSmSearchMouseClicked
        try {
            PSMSearch();
        } catch (Exception ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblSmSearchMouseClicked

    private void btnCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCHActionPerformed

        try {
         //   Statement st = con.createStatement();
         Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("truncate table tblhistory");
            ResultSet rs = st.executeQuery("select * from tblhistory");
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("");
            dtm.addColumn("Date/Time");
            tblEH.setModel(dtm);
            Vector vec;
            while (rs.next()) {
                vec = new Vector();
                vec.add(rs.getString("user") + rs.getString("ginawa"));
                vec.add(rs.getString("date"));
                dtm.addRow(vec);
            }
            JOptionPane.showMessageDialog(null, "Success!");
        } catch (Exception e) {
            System.err.println(e);
        }


    }//GEN-LAST:event_btnCHActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        try {
         //   Statement st = con.createStatement();
         Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "update tblacc set signed = 0 where username = '" + user + "'";
            st.executeUpdate(query);
            new LogIn().setVisible(true);
            this.dispose();
            //System.exit(0);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        pnlLog.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        pnlLog.setBorder(null);
    }//GEN-LAST:event_jLabel12MouseExited

    private void btnTmSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmSaveActionPerformed
        try {
            if (tmSelected == 0) {
                JOptionPane.showMessageDialog(null, "Please select a row!");
                return;
            }

            arName = new String[tmSelected];
            arDes = new String[tmSelected];
            arAd = new String[tmSelected];

            for (int i = 0; i < tmcount; i++) {
                Boolean tmS = (Boolean) tblTM.getValueAt(i, 0);
                if (tmS == true) {
                    arName[a] = tblTM.getValueAt(i, 1).toString();
                    arDes[a] = tblTM.getValueAt(i, 2).toString();
                    arAd[a] = tblTM.getValueAt(i, 3).toString();
                    a++;
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }

        new tmPrint().setVisible(true);
    }//GEN-LAST:event_btnTmSaveActionPerformed

    private void btnPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromActionPerformed
        if (tNum == 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Row!");
            return;
        }
        String name;
        try {
            int confirm = 0;
            confirm = JOptionPane.showConfirmDialog(null, "Do you want to promote the Selected units?");
            for (int i = 0; i < count; i++) {
                Boolean gb = (Boolean) tblEM.getValueAt(i, 0);
                pangkuha = (String) tblEM.getValueAt(i, 5);
                if (gb == true) {
                    idSaTable = tblEM.getValueAt(i, 7);
                   // Statement st = con.createStatement();
                   // Statement st1 = con.createStatement();
                   Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                   Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    //            idSaTable = tblEM.getValueAt(id - 1, 6);
                    String idTBL = idSaTable + "";

                    Calendar cal = Calendar.getInstance();
                    int mon = cal.get(Calendar.MONTH) + 1;
                    int day = cal.get(Calendar.DATE);
                    int year = cal.get(Calendar.YEAR);
                    String dateA = mon + "/" + day + "/" + year;
                    String sub = pangkuha.substring(pangkuha.length() - 8);
                    String y;
                    String yy;
                    String sy;
                    ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                            + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                            + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                            + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");
                    while (rs.next()) {
                        if (rs.getString("id").equals(idTBL)) {
                            yy = rs.getString("sy").substring(5);
                            y = rs.getString("sy").substring(0, 4);
                            name = rs.getString("lname") + ", " + rs.getString("fname") + "";
                            int y1 = Integer.parseInt(y) + 1;
                            int y2 = Integer.parseInt(yy) + 1;
                            sy = y1 + "-" + y2; //SCHOOL YEAR

                            if (confirm == 0) {
                                if (rs.getString("semester").equals("First Semester") && !sub.equals("(PRE-AD)")) {
                                    st1.executeUpdate("update tblprofperinfo set semester ='Second Semester' where id = " + idSaTable);
                                    st1.executeUpdate("update tblprof set student_type ='Old Student' where id = " + idSaTable);

                                } else if (rs.getString("semester").equals("Second Semester") && rs.getString("eag").equals("GRADE 11") && !sub.equals("(PRE-AD)")) {
                                    st1.executeUpdate("update tblprofperinfo set semester ='First Semester',sy='" + sy + "' where id = " + idSaTable);
                                    st1.executeUpdate("update tblprof set student_type ='Old Student' where id = " + idSaTable);
                                    st1.executeUpdate("update tblprofacadinfo set eag ='GRADE 12' where id = " + idSaTable);

                                } else if (rs.getString("semester").equals("Second Semester") && rs.getString("eag").equals("GRADE 12") && !sub.equals("(PRE-AD)")) {
                                    //                                    int get = JOptionPane.showConfirmDialog(null, "move to archived and mark as completer? " + "  ", "WARNING", 0, 0);
                                    //                                    if (get != 0) {
                                    //                                        return;
                                    //                                    }
                                    st1.executeUpdate("update tblprof set student_type ='Old Student' where id = " + idSaTable);
                                    st1.executeUpdate("update tblprof set date_archived = '" + dateA + "', reason= 'Completer' where id = " + idSaTable);
                                    st1.executeUpdate("update tblprofacadinfo set archived =" + 1 + " where id =" + idSaTable);
                                    st1.executeUpdate("update tblrc set archived =" + 1 + " where id =" + idSaTable);
                                } else {
                                    JOptionPane.showMessageDialog(null, "You cant promote" + rs.getString("full_name") + " not in masterlist yet");
                                    return;
                                }

                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                String date = dtf.format(now);
                                st1.executeUpdate("insert into tblhistory "
                                        + "(user, ginawa, date) values "
                                        + "('" + txtUser.getText() + "',' " + "has promoted "
                                        + name + " (STUDENT) ' , '" + date + "')");
                            }
                        }
                    }

                }
            }
            if (confirm == 0) {
                JOptionPane.showMessageDialog(null, "Success");
            }

            saDisplay();
            RequirementChecklist();
            StudentMasterlist();
            emDisplay();
            tNum = 0;

        } catch (Exception e) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnPromActionPerformed

    private void btnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveActionPerformed

        try {
            if (tNum != 0) {
                int get = JOptionPane.showConfirmDialog(null, "Are you sure you want move to archive? " + "  ", "WARNING", 0, 0);
                if (get != 0) {
                    return;
                }

                DefaultComboBoxModel cbReason = new DefaultComboBoxModel();
                CBReason.setModel(cbReason);
                CBReason.addItem("Completer");
                CBReason.addItem("Drop Out");
                CBReason.addItem("Transferred Out");
                CBReason.addItem("No Longer School");
                CBReason.addItem("Undetermined");
                CBReason.setVisible(true);
                JOptionPane.showMessageDialog(null, CBReason, "Please Select Reason", 2);
                String reason = (String) CBReason.getSelectedItem();

              //bu  eto.setVisible(true);
              // jScrollPane1.setVisible(false);

                for (int i = 0; i < count; i++) {
                    Boolean gb = (Boolean) tblEM.getValueAt(i, 0);
                    if (gb == true) {

                        Object no = tblEM.getValueAt(i, 7).toString();
                        Object name = tblEM.getValueAt(i, 2);
                        Calendar cal = Calendar.getInstance();
                        int mon = cal.get(Calendar.MONTH) + 1;
                        int day = cal.get(Calendar.DATE);
                        int year = cal.get(Calendar.YEAR);
                        String dateA = mon + "/" + day + "/" + year;

                        edate = mon + "/" + day + "/" + year;

                      //  Statement st = con.createStatement();
                      Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                        st.executeUpdate("update tblprof set date_archived = '" + dateA + "', reason= '" + reason + "' where id = " + no);
                        st.executeUpdate("update tblprofacadinfo set archived =" + 1 + " where id =" + no);
                        st.executeUpdate("update tblrc set archived =" + 1 + " where id =" + no);
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        String date = dtf.format(now);
                        st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('"
                                + txtUser.getText() + "',' has archived " + name + " (STUDENT) ', '" + date + "')");

                    }
                }
                tNum = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Please Select row");
            }
            emDisplay();
            saDisplay();
            RequirementChecklist();
            StudentMasterlist();

        } catch (Exception e) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnArchiveActionPerformed

    private void pnlEFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEFMouseExited
        pnlEF.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_pnlEFMouseExited

    private void pnlEFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEFMouseEntered
        pnlEF.setBackground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_pnlEFMouseEntered

    private void pnlEFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEFMouseClicked

        this.dispose();
        new EnrollmentForm(user).setVisible(true);
    }//GEN-LAST:event_pnlEFMouseClicked

    private void CBSYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBSYActionPerformed
        ss = 0;
        try {
            dbsy = (String) CBSY.getSelectedItem();
            //Statement st2 = con.createStatement();
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            hh = CBSY.getSelectedIndex();

            if (CBSY.getSelectedIndex() != 0) {
                st2.executeUpdate("update poweruser set sy_index = " + CBSY.getSelectedIndex());
            }

            String sem = (String) CBS.getSelectedItem();
            DefaultTableModel dtmEM = new DefaultTableModel();
            tblEM.setModel(dtmEM);
            dtmEM.addColumn("");
            dtmEM.addColumn("LRN");
            dtmEM.addColumn("FULL NAME");
            dtmEM.addColumn("GRADE");
            dtmEM.addColumn("SECTION");
            dtmEM.addColumn("STUDENT TYPE");
            dtmEM.addColumn("DATE");
            dtmEM.addColumn("NO.");

            tblEM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblEM.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblEM.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblEM.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblEM.getColumnModel().getColumn(3).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(4).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(5).setPreferredWidth(255);
            tblEM.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblEM.getColumnModel().getColumn(7).setPreferredWidth(50);
            tblEM.setRowHeight(35);
            tblEM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));

          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");

            while (rs.next()) {
                if (rs.getString("semester").equalsIgnoreCase(sem) && rs.getString("sy").equals(dbsy)) {
                    if (rs.getInt("archived") == 1) {
                        saDisplay();
                    } else {
                        StudentMasterlist();
                        RequirementChecklist();
                        emDisplay();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_CBSYActionPerformed

    private void CBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBSActionPerformed
        ss = 0;
        try {
            dbsem = (String) CBS.getSelectedItem();
            //Statement st2 = con.createStatement();
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            h = CBS.getSelectedIndex();
            if (CBS.getSelectedIndex() != 0) {
                st2.executeUpdate("update poweruser set sem_index = " + h);
            }

            String sy = (String) CBSY.getSelectedItem();
            DefaultTableModel dtmEM = new DefaultTableModel();
            tblEM.setModel(dtmEM);

            dtmEM.addColumn("");
            dtmEM.addColumn("LRN");
            dtmEM.addColumn("FULL NAME");
            dtmEM.addColumn("GRADE");
            dtmEM.addColumn("SECTION");
            dtmEM.addColumn("STUDENT TYPE");
            dtmEM.addColumn("DATE");
            dtmEM.addColumn("NO.");

            tblEM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblEM.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblEM.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblEM.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblEM.getColumnModel().getColumn(3).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(4).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(5).setPreferredWidth(255);
            tblEM.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblEM.getColumnModel().getColumn(7).setPreferredWidth(50);

            tblEM.setRowHeight(35);
            tblEM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));

           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");

            while (rs.next()) {
                if (rs.getString("semester").equalsIgnoreCase(dbsem) && rs.getString("sy").equals(sy)) {
                    if (rs.getInt("archived") == 1) {
                        saDisplay();
                    } else {
                        RequirementChecklist();
                        StudentMasterlist();
                        emDisplay();
                    }
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_CBSActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (tNum == 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Row!");
            return;
        }

        try {

           // Statement st6 = con.createStatement();
           Statement st6 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs6 = st6.executeQuery("select * from tblprofperinfo order by gwa desc");
            stemSize = 0;
            while (rs6.next()) {
                stemSize++;
                arrGwaStemEn = new int[stemSize];
                if (stemSize <= 2) {
                    arrGwaStemEn[stemSize - 1] = rs6.getInt("gwa");
                    stemSec = "STEM-A";
                    System.out.println(arrGwaStemEn[stemSize - 1] + " STEM A " + rs6.getString("id"));
                } else if (stemSize <= 4) {
                    arrGwaStemEn[stemSize - 1] = rs6.getInt("gwa");
                    stemSec = "STEM-B";
                    System.out.println(arrGwaStemEn[stemSize - 1] + " STEM B " + rs6.getString("id"));
                } else if (stemSize <= 6) {
                    arrGwaStemEn[stemSize - 1] = rs6.getInt("gwa");
                    stemSec = "STEM-C";
                    System.out.println(arrGwaStemEn[stemSize - 1] + " STEM C " + rs6.getString("id"));
                } else {
                    arrGwaStemEn[stemSize - 1] = rs6.getInt("gwa");
                    stemSec = "STEM-D";
                    System.out.println(arrGwaStemEn[stemSize - 1] + " STEM D " + rs6.getString("id"));
                }

            }//AUTOSECTIONING NG STEM A 

          ///  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id order by gwa desc;");

            for (int i = 0; i < count; i++) {
                Boolean gb = (Boolean) tblEM.getValueAt(i, 0);
                if (gb == true) {
                    idSaTable = tblEM.getValueAt(i, 7);
                }
            }
            String idTBL = idSaTable + "";

            int confirm, confirmSchoice;

            String x = "";
            while (rs.next()) {
                if (rs.getString("id").equals(idTBL)) {
                    Object name = tblEM.getValueAt(tblEM.getSelectedRow(), 2);
                    if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (ICT)-PROGRAMMING")
                            || rs.getString("fchoice").equals("Science, Technology, Engineering and Mathematics (STEM) - ENGINEERING")
                            || rs.getString("fchoice").equals("Science, Technology, Engineering and Mathematics (STEM) - MEDICINE")
                            || rs.getString("fchoice").equals("Science, Technology, Engineering and Mathematics (STEM) - ARCHITECHTURE")
                            || rs.getString("fchoice").equals("Accounting and Business Management (ABM) - ACCOUNTANCY")
                            || rs.getString("fchoice").equals("Accounting and Business Management (ABM) - Business Management")
                            || rs.getString("fchoice").equals("Humanities and Social Sciences (HUMSS)")) {
                        confirm = JOptionPane.showConfirmDialog(null, "His/Her First Choice '" + rs.getString("fchoice") + "' Require`s Examination/s /General Average of 85, DO YOU WANT TO PROCEED?");
                        if (confirm == 0) {
                            if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (ICT)-PROGRAMMING")) {
                                st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-1' where id =" + idTBL);
                            } else if (rs.getString("fchoice").equals("Science, Technology, Engineering and Mathematics (STEM) - ENGINEERING")) {
                                if (rs.getFloat("gwa") >= 95) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-A' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 90 && rs.getFloat("gwa") < 95) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-B' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 88 && rs.getFloat("gwa") < 90) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-C' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 85 && rs.getFloat("gwa") < 88) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-D' where id =" + idTBL);
                                } else {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-D' where id =" + idTBL);
                                }

                            } else if (rs.getString("fchoice").equals("Science, Technology, Engineering and Mathematics (STEM) - MEDICINE")) {
                                if (rs.getFloat("gwa") >= 90) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-E' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 88 && rs.getFloat("gwa") < 90) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-F' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 85 && rs.getFloat("gwa") < 88) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-G' where id =" + idTBL);
                                } else {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-G' where id =" + idTBL);
                                }
                            } else if (rs.getString("fchoice").equals("Science, Technology, Engineering and Mathematics (STEM) - ARCHITECHTURE")) {
                                st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'STEM-H' where id =" + idTBL);
                            } else if (rs.getString("fchoice").equals("Accounting and Business Management (ABM) - ACCOUNTANCY")) {
                                st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'ABM-A' where id =" + idTBL);
                            } else if (rs.getString("fchoice").equals("Accounting and Business Management (ABM) - Business Management")) {
                                st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'ABM-B' where id =" + idTBL);
                            } else if (rs.getString("fchoice").equals("Humanities and Social Sciences (HUMSS)")) {
                                if (rs.getFloat("gwa") >= 95) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'HUMSS-A' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 90 && rs.getFloat("gwa") < 95) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'HUMSS-B' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 88 && rs.getFloat("gwa") < 90) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'HUMSS-C' where id =" + idTBL);
                                } else if (rs.getFloat("gwa") >= 85 && rs.getFloat("gwa") < 88) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'HUMSS-D' where id =" + idTBL);
                                } else {
                                    st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'HUMSS-D' where id =" + idTBL);
                                }
                            }
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            String date = dtf.format(now);
                            st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has added " + name + " (STUDENT) to the masterlist', '" + date + "')");
                            JOptionPane.showMessageDialog(null, "Done!");
                            break;
                        } else if (confirm == 1) {//PAG NO ANG pinindot
                            confirmSchoice = JOptionPane.showConfirmDialog(null, "Move to his/her Second Choice instead?" + rs.getString("sChoice"));
                            if (confirmSchoice == 0) {
                                if (rs.getString("schoice").equals("Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2, section = 'TVL-2' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Technical-Vocational-Livelihood (ICT)-ANIMATION")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2, section = 'TVL-3' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Technical-Vocational-Livelihood (HE)-BREAD AND PASTRY PRODUCTION")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'TVL-4' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Technical-Vocational-Livelihood (HE)-HOUSEKEEPING")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'TVL-5' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Technical-Vocational-Livelihood (HE)-COOKERY")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'TVL-7' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Technical-Vocational-Livelihood (IA)-AUTOMOTIVE")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'TVL-9' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Technical-Vocational-Livelihood (IA)-REPAIR AND INSTALLATION")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'TVL-11' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Technical-Vocational-Livelihood (IA)-WELDING")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'TVL-12' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Accounting and Business Management (ABM) -ENTREPRENEURSHIP")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'ABM-D' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Applied and specialized subjects ARTS AND DESIGN")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'Arts and Design' where id =" + idTBL);
                                } else if (rs.getString("sChoice").equals("Applied and specialized subjects SPORTS")) {
                                    st.executeUpdate("update tblprofacadinfo set choice = 2,section = 'Sports' where id =" + idTBL);
                                } else {

                                }
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                String date = dtf.format(now);
                                st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has added " + name + " (STUDENT) to the masterlist', '" + date + "')");
                                JOptionPane.showMessageDialog(null, "Done!");

                                break;
                            } else {

                            }//pag no/cancel/x ang pinindot sa pagpili ng schoice

                        }
                    } else {//PAG WALANG REQUIREMENTS YUNG FIRST CHOICE
                        if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-2' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (ICT)-ANIMATION")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-3' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (HE)-BREAD AND PASTRY PRODUCTION")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-4' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (HE)-HOUSEKEEPING")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-5' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (HE)-COOKERY")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-7' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (IA)-AUTOMOTIVE")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-9' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (IA)-REPAIR AND INSTALLATION")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-11' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Technical-Vocational-Livelihood (IA)-WELDING")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'TVL-12' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Accounting and Business Management (ABM) -ENTREPRENEURSHIP")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'ABM-D' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Applied and specialized subjects ARTS AND DESIGN")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'Arts and Design' where id =" + idTBL);
                        } else if (rs.getString("fchoice").equals("Applied and specialized subjects SPORTS")) {
                            st.executeUpdate("update tblprofacadinfo set choice = 1, section = 'Sports' where id =" + idTBL);
                        }
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        String date = dtf.format(now);
                        st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has added " + name + " (STUDENT) to the masterlist', '" + date + "')");
                        JOptionPane.showMessageDialog(null, "Done!");
                        break;
                    }
                } else {
                }

            }//DULO NG WHILE
            saDisplay();
            RequirementChecklist();
            StudentMasterlist();
            emDisplay();
            tNum = 0;
            // id = 0;
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed

        if (tNum == 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Row!");
            return;
        }

        try {
            for (int i = 0; i < count; i++) {
                Boolean gb = (Boolean) tblEM.getValueAt(i, 0);
                if (gb == true) {
                    idSaTable = tblEM.getValueAt(i, 7);
                }
            }
            this.dispose();

            new enFormView().setVisible(true);

        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnViewActionPerformed

    private void txtFSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFSearchActionPerformed
        ss = 0;
        try {
            PEMSearch();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_txtFSearchActionPerformed

    private void txtFSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFSearchMousePressed
//        if (txtFSearch.getText().equals(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)")) {
//            txtFSearch.setText("");
//        }
    }//GEN-LAST:event_txtFSearchMousePressed

    private void txtFSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFSearchFocusLost
        txtFSearch.setText(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)");
    }//GEN-LAST:event_txtFSearchFocusLost

    private void tblEMMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEMMouseReleased
        id = tblEM.getSelectedRow() + 1;
    }//GEN-LAST:event_tblEMMouseReleased

    private void tblEMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEMMouseClicked

        //        try {
        id = tblEM.getSelectedRow() + 1;
        pangkuha = (String) tblEM.getValueAt(id - 1, 4);
        int idSelect = (int) tblEM.getValueAt(id - 1, 7);

        tNum = 0;

        if (tblEM.getSelectedColumn() != 0) {
            s = (Boolean) tblEM.getValueAt(id - 1, 0);
            if (s == false) {
                tblEM.setValueAt(true, id - 1, 0);
            } else {
                tblEM.setValueAt(false, id - 1, 0);
            }
        }

        for (int i = 0; i < count; i++) {
            Boolean gb = (Boolean) tblEM.getValueAt(i, 0);
            if (gb == true) {
                tNum++;
            }
        }

        if (tNum > 1) {
            btnView.setEnabled(false);
            btnAdd.setEnabled(false);
        } else {
            btnView.setEnabled(true);
            btnAdd.setEnabled(true);
        }
    }//GEN-LAST:event_tblEMMouseClicked

    private void tblEMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblEMFocusLost

    }//GEN-LAST:event_tblEMFocusLost

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        tNum = 0;
        if (Select.isSelected()) {
            lblSel.setText("Unselect all");
            sel = true;
        } else {
            lblSel.setText("Select All");
            sel = false;
        }
        emDisplay();

        for (int i = 0; i < count; i++) {
            Boolean gb = (Boolean) tblEM.getValueAt(i, 0);
            if (gb == true) {
                tNum++;
            }
        }

        if (tNum > 1) {
            btnView.setEnabled(false);
            btnAdd.setEnabled(false);
        } else {
            btnView.setEnabled(true);
            btnAdd.setEnabled(true);
        }

    }//GEN-LAST:event_SelectActionPerformed

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked

        try {
            if (txtFSearch.getText().equals(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)")) {
                return;
            }
            PEMSearch();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_lblSearchMouseClicked

    private void cbSaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSaActionPerformed
        // saNum = 0;
        if (cbSa.isSelected()) {
            lblSaSelect.setText("Unselect all");
            saBool = true;
        } else {
            lblSaSelect.setText("Select All");
            saBool = false;
        }
        saDisplay();

        for (int i = 0; i < saTblCount; i++) {
            Boolean gb = (Boolean) tblSA.getValueAt(i, 0);
            if (gb == true) {
                saNum++;
            }
        }


    }//GEN-LAST:event_cbSaActionPerformed

    private void cbTmSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTmSortActionPerformed
        jLabel70.setVisible(false);
        lblTmSel.setVisible(false);
        tmcount = 0;
        try {

            if (cbTmSort.getSelectedItem().equals("Name Ascending")) {
                DefaultTableModel dtTM = new DefaultTableModel();
                tblTM.setModel(dtTM);
                tblTM = new JTable(dtTM) {
                    @Override
                    public Class getColumnClass(int column) {
                        switch (column) {
                            case 0:
                                return Boolean.class;
                            default:
                                return String.class;
                        }
                    }

                    public boolean isCellEditable(int row, int column) {
                        switch (column) {
                            case 0:
                                return true;
                            default:
                                return false;
                        }

                    }
                };
                dtTM.addColumn("");
                dtTM.addColumn("FULL NAME");
                dtTM.addColumn("Designation");
                dtTM.addColumn("Advisory Class");
                dtTM.addColumn("ID");

                tblTM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tblTM.getColumnModel().getColumn(0).setPreferredWidth(40);
                tblTM.getColumnModel().getColumn(1).setPreferredWidth(450);
                tblTM.getColumnModel().getColumn(2).setPreferredWidth(435);
                tblTM.getColumnModel().getColumn(3).setPreferredWidth(390);
                tblTM.getColumnModel().getColumn(4).setPreferredWidth(50);

                tblTM.setRowHeight(35);

                tblTM.setSelectionMode(SINGLE_SELECTION);
                tblTM.setSelectionBackground(new java.awt.Color(50, 100, 49));
                tblTM.getTableHeader().setResizingAllowed(false);
                tblTM.getTableHeader().setReorderingAllowed(false);
                tblTM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
                tblTM.setFont(new java.awt.Font("Times New Roman", 0, 14));

               // Statement st = con.createStatement();
               Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("select * from tbltm order by fname asc;");

                while (rs.next()) {
                    if (!rs.getString("desig").equals("principal")) {
                        if (rs.getInt("archive") != 1) {
                            Vector vec = new Vector();
                            vec.add(false);
                            vec.add(rs.getString("fname") + ", " + rs.getString("mname") + ", " + rs.getString("lname"));
                            if (rs.getString("desig").equals("Other")) {
                                vec.add("Unknown");
                            } else {
                                vec.add(rs.getString("desig"));
                            }
                            vec.add(rs.getString("advisory"));
                            vec.add(rs.getString("id"));
                            dtTM.addRow(vec);
                            tmcount++;
                        }
                    }
                }
                lblTmCount.setText(tmcount + "");

            } else if (cbTmSort.getSelectedItem().equals("Name Descending")) {
                DefaultTableModel dtTM = new DefaultTableModel();
                tblTM.setModel(dtTM);
                tblTM = new JTable(dtTM) {
                    @Override
                    public Class getColumnClass(int column) {
                        switch (column) {
                            case 0:
                                return Boolean.class;
                            default:
                                return String.class;
                        }
                    }

                    public boolean isCellEditable(int row, int column) {
                        switch (column) {
                            case 0:
                                return true;
                            default:
                                return false;
                        }

                    }
                };
                dtTM.addColumn("");
                dtTM.addColumn("FULL NAME");
                dtTM.addColumn("Designation");
                dtTM.addColumn("Advisory Class");
                dtTM.addColumn("ID");

                tblTM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tblTM.getColumnModel().getColumn(0).setPreferredWidth(40);
                tblTM.getColumnModel().getColumn(1).setPreferredWidth(450);
                tblTM.getColumnModel().getColumn(2).setPreferredWidth(435);
                tblTM.getColumnModel().getColumn(3).setPreferredWidth(390);
                tblTM.getColumnModel().getColumn(4).setPreferredWidth(50);
                tblTM.setRowHeight(35);

                tblTM.setSelectionMode(SINGLE_SELECTION);
                tblTM.setSelectionBackground(new java.awt.Color(50, 100, 49));
                tblTM.getTableHeader().setResizingAllowed(false);
                tblTM.getTableHeader().setReorderingAllowed(false);
                tblTM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
                tblTM.setFont(new java.awt.Font("Times New Roman", 0, 14));

             //   Statement st = con.createStatement();
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("select * from tbltm order by fname desc;");

                while (rs.next()) {
                    if (!rs.getString("desig").equals("principal")) {
                        if (rs.getInt("archive") != 1) {
                            Vector vec = new Vector();
                            vec.add(false);
                            vec.add(rs.getString("fname") + ", " + rs.getString("mname") + ", " + rs.getString("lname"));
                            if (rs.getString("desig").equals("Other")) {
                                vec.add("Unknown");
                            } else {
                                vec.add(rs.getString("desig"));
                            }
                            vec.add(rs.getString("advisory"));
                            vec.add(rs.getString("id"));
                            dtTM.addRow(vec);
                            tmcount++;
                        }
                    }
                }
                lblTmCount.setText(tmcount + "");
            }

            lblTmCount.setText(tmcount + "");

            tblTM.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblTMMouseClicked(evt);
                }
            });

            spTM.setViewportView(tblTM);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_cbTmSortActionPerformed

    private void tblTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTMMouseClicked

        tmSelected = 0;
        tmRow = tblTM.getSelectedRow() + 1;
        tmSel = (Boolean) tblTM.getValueAt(tmRow - 1, 0);

        if (tblTM.getSelectedColumn() != 0) {
            tmSel = (Boolean) tblTM.getValueAt(tmRow - 1, 0);
            if (tmSel == null || tmSel == false) {
                tblTM.setValueAt(true, tmRow - 1, 0);
            } else {
                tblTM.setValueAt(false, tmRow - 1, 0);
            }
        }

        for (int i = 0; i < tmcount; i++) {
            Boolean gb = (Boolean) tblTM.getValueAt(i, 0);
            if (gb != null && gb != false) {
                tmSelected += 1;
            }
        }

        if (tmSelected != 0) {
            jLabel70.setVisible(true);
            lblTmSel.setVisible(true);
            lblTmSel.setText(tmSelected + "");
        } else {
            jLabel70.setVisible(false);
            lblTmSel.setVisible(false);
        }
        if (tmSelected > 1) {
            btnTmAdv.setEnabled(false);
        } else {
            btnTmAdv.setEnabled(true);
        }
    }//GEN-LAST:event_tblTMMouseClicked

    private void lblTmlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTmlistMouseClicked
        try {
            TMSearch();
        } catch (Exception ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblTmlistMouseClicked

    private void txtTmSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTmSearchActionPerformed
        try {
            TMSearch();
        } catch (Exception ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtTmSearchActionPerformed

    private void txtTmSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTmSearchFocusLost
        txtTmSearch.setText(" PLEASE ENTER TEACHERS NAME(PRESS ENTER TO SEARCH)");
    }//GEN-LAST:event_txtTmSearchFocusLost

    private void btnEHPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEHPrintActionPerformed
        new audit().setVisible(true);
    }//GEN-LAST:event_btnEHPrintActionPerformed

    private void btnBroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroActionPerformed

        int ind = cbRcSearch.getSelectedIndex();
        try {
            jf = new JFileChooser();
            jf.setCurrentDirectory(new File(System.getProperty("user.home")));
            filter = new FileNameExtensionFilter("*,IMAGE", "jpg", "gif", "png", "pdf");
            jf.addChoosableFileFilter(filter);
            res = jf.showSaveDialog(null);

            if (res == JFileChooser.APPROVE_OPTION) {
                File select = jf.getSelectedFile();
                path = select.getAbsolutePath();
                lblGC.setIcon(ResizeImage(path));
                imagePath = path;

            }
        } catch (Exception e) {
            System.err.println(e);
        }


    }//GEN-LAST:event_btnBroActionPerformed

    private void btnSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSvActionPerformed
        try {
            if (profPicFlag == 1) {
                PreparedStatement ps = con.prepareStatement("update images set user = ?,"
                        + " path = ? where user = '" + txtUser.getText() + "'");
                ps.setString(1, txtUser.getText() + "");
                ps.setString(2, (imagePath));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "SUCCESS!");
                profPicFlag = 0;
                return;
            }

            PreparedStatement ps = con.prepareStatement("insert into images(user,path) values(?,?)");
            ps.setString(1, txtUser.getText() + "");
            ps.setString(2, (imagePath));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "SUCCESS!");

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnSvActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnTmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmAddActionPerformed
        lblTmSel.setVisible(false);
        jLabel70.setVisible(false);
        jLabel67.setVisible(false);
        cbTmSort.setVisible(false);
        lblTmCount.setVisible(false);
        jLabel62.setVisible(false);
        pnlTmAdd.setVisible(true);
        btnTmAdd.setVisible(false);
        btnTmSave.setVisible(false);
        btnTmBack.setVisible(true);
        spTM.setVisible(false);
        btnTMmove.setVisible(false);
    }//GEN-LAST:event_btnTmAddActionPerformed

    private void btnTmBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmBackActionPerformed
        lblTmSel.setVisible(true);
        jLabel70.setVisible(true);
        jLabel67.setVisible(true);
        cbTmSort.setVisible(true);
        lblTmCount.setVisible(true);
        jLabel62.setVisible(true);
        btnTmBack.setVisible(false);
        pnlTmAdd.setVisible(false);
        btnTmAdd.setVisible(true);
        btnTmSave.setVisible(true);
        spTM.setVisible(true);
    }//GEN-LAST:event_btnTmBackActionPerformed

    private void lblAuditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAuditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAuditMouseClicked

    private void txtAuditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAuditFocusLost
        txtAudit.setText(" PLEASE ENTER USERNAME (PRESS ENTER TO SEARCH)");
    }//GEN-LAST:event_txtAuditFocusLost

    private void txtAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuditActionPerformed
        try {
            auditSearch();
            audit.aud = txtAudit.getText();
        } catch (Exception ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtAuditActionPerformed

    private void cbPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPosActionPerformed

    }//GEN-LAST:event_cbPosActionPerformed

    private void cbArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbArchActionPerformed

        try {
            if (cbArch.getSelectedIndex() == 0) {
                pnlAr.setVisible(true);
                pnlTr.setVisible(false);
                pnlUr.setVisible(false);
                LBLENROLL13.setText("STUDENT ARCHIVE");
            } else if (cbArch.getSelectedIndex() == 1) {
                pnlAr.setVisible(false);
                pnlTr.setVisible(true);
                pnlUr.setVisible(false);
                TeachersArchive();
                LBLENROLL13.setText("TEACHERS ARCHIVE");
            } else if (cbArch.getSelectedIndex() == 2) {
                pnlAr.setVisible(false);
                pnlTr.setVisible(false);
                pnlUr.setVisible(true);
                userDisplay();
                LBLENROLL13.setText("USERS ARCHIVE");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbArchActionPerformed

    private void btnTMmoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTMmoveActionPerformed

        try {
            if (tmSelected == 0) {
                JOptionPane.showMessageDialog(null, "Please select a row!");
                return;
            }
            int get = JOptionPane.showConfirmDialog(null, "Are you sure you want move to archive? " + "  ", "WARNING", 0, 0);
            if (get == 1 || get == -1) {
                return;
            }
            Object name = 0;
            for (int i = 0; i < tmcount; i++) {
                Boolean tmS = (Boolean) tblTM.getValueAt(i, 0);
                if (tmS == true) {
                    String x = (String) tblTM.getValueAt(i, 4);
                    name = tblTM.getValueAt(i, 1);
                    //Statement st = con.createStatement();
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    int rs = st.executeUpdate("update tbltm set archive = 1 where id = " + x);

                }
            }
          //  Statement st = con.createStatement();
          Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has archived teacher " + name + "', '" + date + "')");
            JOptionPane.showMessageDialog(null, "Success!");
            lblTmSel.setText("0");
            TeacherMasterlist();
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnTMmoveActionPerformed

    private void tblTaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaMouseClicked

        idTr = tblTa.getSelectedRow() + 1;
        taNum = 0;

        if (tblTa.getSelectedColumn() != 0) {
            ta = (Boolean) tblTa.getValueAt(idTr - 1, 0);
            if (ta == false) {
                tblTa.setValueAt(true, idTr - 1, 0);
            } else {
                tblTa.setValueAt(false, idTr - 1, 0);
            }
        }

        for (int i = 0; i < taTblCount; i++) {
            Boolean gb = (Boolean) tblTa.getValueAt(i, 0);
            if (gb == true) {
                taNum++;
            }
        }

    }//GEN-LAST:event_tblTaMouseClicked

    private void tblTaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTaMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (taNum == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        int get = JOptionPane.showConfirmDialog(null, "Are you sure do you want to retrieve the selected units? " + "  ", "Message", 0, 1);
        if (get != 0) {
            return;
        }

        try {
            for (int i = 0; i < taTblCount; i++) {
                Boolean gb = (Boolean) tblTa.getValueAt(i, 0);
                if (gb == true) {
                    //idSA = (int) tblSA.getValueAt(i, 12);
                    String no = (String) tblTa.getValueAt(i, 6);

                 //   Statement st = con.createStatement();
                 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from tbltm");
                    Object name = tblTa.getValueAt(i, 2);
                    name += ", " + tblTa.getValueAt(i, 3);
                    name += " " + tblTa.getValueAt(i, 4);
                    //rs.absolute(idSA);
                   // Statement st1 = con.createStatement();
                   Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st.executeUpdate("update tbltm set archive = " + 0 + " where id = " + no);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String date = dtf.format(now);
//                    st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('"
//                            + txtUser.getText() + "',' has retrieved " + name + "'(TEACHER), '" + date + "')");

                }
            }

            JOptionPane.showMessageDialog(null, "Success!");
            saDisplay();
            emDisplay();
            TeacherMasterlist();
            RequirementChecklist();
            StudentMasterlist();
            TeachersArchive();
            taNum = 0;
        } catch (Exception e) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnUaRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUaRetActionPerformed
        if (uaNum == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        int get = JOptionPane.showConfirmDialog(null, "Are you sure do you want to retrieve the selected units? " + "  ", "Message", 0, 1);
        if (get != 0) {
            return;
        }

        try {
            for (int i = 0; i < uatblCount; i++) {
                Boolean gb = (Boolean) tblUa.getValueAt(i, 0);
                if (gb == true) {
                    //idSA = (int) tblSA.getValueAt(i, 12);
                    String no = (String) tblUa.getValueAt(i, 1);

                  //  Statement st = con.createStatement();
                  Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from tbltm");
                    Object name = tblUa.getValueAt(i, 2);
                    name += ", " + tblUa.getValueAt(i, 3);
                    name += " " + tblUa.getValueAt(i, 4);
                    //rs.absolute(idSA);
                  //  Statement st1 = con.createStatement();
                  Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st.executeUpdate("update tblacc set archive = " + 0 + " where username = '" + no + "'");
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String date = dtf.format(now);
//                    st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('"
//                            + txtUser.getText() + "',' has retrieved " + name + "'(TEACHER), '" + date + "')");

                }
            }

            JOptionPane.showMessageDialog(null, "Success!");
            userDisplay();
            uaNum = 0;
        } catch (Exception e) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnUaRetActionPerformed

    private void tblUaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUaMouseClicked

        idUa = tblUa.getSelectedRow() + 1;
        uaNum = 0;

        if (tblUa.getSelectedColumn() != 0) {
            ua = (Boolean) tblUa.getValueAt(idUa - 1, 0);
            if (ua == false) {
                tblUa.setValueAt(true, idUa - 1, 0);
            } else {
                tblUa.setValueAt(false, idUa - 1, 0);
            }
        }

        for (int i = 0; i < uatblCount; i++) {
            Boolean gb = (Boolean) tblUa.getValueAt(i, 0);
            if (gb == true) {
                uaNum++;
            }
        }
    }//GEN-LAST:event_tblUaMouseClicked

    private void btnTaDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaDelActionPerformed
        if (taNum == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        int get = JOptionPane.showConfirmDialog(null, "Are you sure do you want to delete the selected units Permanently? " + "  ", "WARNING", 0, 0);
        if (get != 0) {
            return;
        }

        try {

            for (int i = 0; i < taTblCount; i++) {
                Boolean gb = (Boolean) tblTa.getValueAt(i, 0);
                if (gb == true) {
                    //idSA = (int) tblSA.getValueAt(i, 12);
                    String no = (String) tblTa.getValueAt(i, 6);

                   // Statement st1 = con.createStatement();
                   Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st1.executeUpdate("delete from tbltm where id =" + no);

                   // Statement st = con.createStatement();
                   Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String date = dtf.format(now);
                    Object name = (tblTa.getValueAt(i, 1) + ", " + tblTa.getValueAt(i, 2) + " " + tblTa.getValueAt(i, 3));
                    st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has deleted" + name + " (TEACHER) ', '" + date + "')");

                }
            }

            TeachersArchive();
            JOptionPane.showMessageDialog(null, "Success!");
            taNum = 0;
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnTaDelActionPerformed

    private void btnUaDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUaDelActionPerformed
        if (uaNum == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        int get = JOptionPane.showConfirmDialog(null, "Are you sure do you want to delete the selected units Permanently? " + "  ", "WARNING", 0, 0);
        if (get != 0) {
            return;
        }

        try {

            for (int i = 0; i < uatblCount; i++) {
                Boolean gb = (Boolean) tblUa.getValueAt(i, 0);
                if (gb == true) {
                    //idSA = (int) tblSA.getValueAt(i, 12);
                    String no = (String) tblUa.getValueAt(i, 1);

                   // Statement st1 = con.createStatement();
                   Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    st1.executeUpdate("delete from tblacc where username = '" + no + "'");

                 //   Statement st = con.createStatement();
                 Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String date = dtf.format(now);
                    Object name = (tblUa.getValueAt(i, 2) + ", " + tblUa.getValueAt(i, 3) + " " + tblUa.getValueAt(i, 4));
                    st.executeUpdate("insert into tblhistory (user, ginawa, date) values ('" + txtUser.getText() + "',' has deleted " + name + " (USER) ', '" + date + "')");

                }
            }

            userDisplay();
            JOptionPane.showMessageDialog(null, "Success!");
            uaNum = 0;
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnUaDelActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (idSM == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }

        String x = (String) tblSM.getValueAt(idSM - 1, 7);

        flag = 5;
        pnlRC.setBackground(new java.awt.Color(0, 73, 0));
        pnlEM.setBackground(new java.awt.Color(50, 100, 49));
        pnlEH.setBackground(new java.awt.Color(50, 100, 49));
        pnlHome.setBackground(new java.awt.Color(50, 100, 49));
        pnlSM.setBackground(new java.awt.Color(50, 100, 49));
        pnlTM.setBackground(new java.awt.Color(50, 100, 49));
        pnlSA.setBackground(new java.awt.Color(50, 100, 49));
        pnlES.setBackground(new java.awt.Color(50, 100, 49));

        PHOME.setVisible(false);
        PEM.setVisible(false);
        PEH.setVisible(false);
        PSM.setVisible(false);
        PRC.setVisible(true);
        PCR.setVisible(false);
        PSA.setVisible(false);
        PTM.setVisible(false);
        PDO.setVisible(false);

        rcCount = 0;

        try {
            mRC = new DefaultTableModel();
            tblRC.setModel(mRC);
            tblRC = new JTable(mRC) {
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return String.class;
                        case 1:
                            return String.class;
                        case 9:
                            return String.class;
                        case 8:
                            return float.class;
                        default:
                            return Boolean.class;
                    }
                }
            };

            mRC.addColumn("LRN");
            mRC.addColumn("FULL NAME");
            mRC.addColumn("   EF");
            mRC.addColumn("   GC");
            mRC.addColumn("   F137");
            mRC.addColumn("   PSA");
            mRC.addColumn("   GM");
            mRC.addColumn("   NCAE");
            mRC.addColumn("GWA");
            mRC.addColumn("NO.");

            tblRC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblRC.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblRC.getColumnModel().getColumn(1).setPreferredWidth(340);
            tblRC.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(5).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(7).setPreferredWidth(80);
            tblRC.getColumnModel().getColumn(8).setPreferredWidth(60);
            tblRC.getColumnModel().getColumn(9).setPreferredWidth(60);
            tblRC.setRowHeight(35);

           // Statement st3 = con.createStatement();
           Statement st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs3 = st3.executeQuery("select pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf,tblrc prrc where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id and prrc.id = pr.id;");

            while (rs3.next()) {
                if (rs3.getString("semester").equals(dbsem) && rs3.getString("sy").equals(dbsy)) {
                    if (rs3.getInt("archived") == 1) {

                    } else {
                        if (rs3.getString("id").equals(x)) {
                            Vector vec2 = new Vector();
                            vec2.add(rs3.getString("LRN"));
                            vec2.add(rs3.getString("full_name"));
                            vec2.add(rs3.getBoolean("e_form"));
                            vec2.add(rs3.getBoolean("g_card"));
                            vec2.add(rs3.getBoolean("f137"));
                            vec2.add(rs3.getBoolean("nso"));
                            vec2.add(rs3.getBoolean("gm"));
                            vec2.add(rs3.getBoolean("ncae"));
                            if (rs3.getString("gwa").equals("")) {
                                vec2.add("N/A");
                            } else {
                                vec2.add(rs3.getString("gwa"));
                            }
                            vec2.add(rs3.getString("id"));
                            rcCount++;
                            mRC.addRow(vec2);
                        }
                    }
                }
            }

            tblRC.setSelectionMode(SINGLE_SELECTION);
            tblRC.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblRC.getTableHeader().setResizingAllowed(false);
            tblRC.getTableHeader().setReorderingAllowed(false);
            tblRC.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
            tblRC.setFont(new java.awt.Font("Times New Roman", 0, 16));

            tblRC.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblRCMouseClicked(evt);
                }
            });

            lblCount2.setText(rcCount + "");
            tblRC.setCellSelectionEnabled(true);
            scrollpane.setViewportView(tblRC);
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void lblBg1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBg1MousePressed
        px = evt.getX();
        py = evt.getY();
    }//GEN-LAST:event_lblBg1MousePressed

    private void lblBg1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBg1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - px, y - py);
    }//GEN-LAST:event_lblBg1MouseDragged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        emStrand.setSelectedIndex(0);
        emYL.setSelectedIndex(0);
        jPanel7.setVisible(true);
        emDisplay();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked

        if (klinicksort == 0) {
            jPanel7.setVisible(true);
            klinicksort = 1;
        } else {
            jPanel7.setVisible(false);
            klinicksort = 0;
        }
    }//GEN-LAST:event_jLabel39MouseClicked

    private void cbEmSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmSortActionPerformed
        ss = 0;
        count = 0;
        DefaultTableModel dtmEM = new DefaultTableModel();
        tblEM.setModel(dtmEM);
        tblEM = new JTable(dtmEM) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 0:
                        return true;
                    default:
                        return false;
                }

            }
        };

        try {
            emCount = 0;
            dtmEM.addColumn("");
            dtmEM.addColumn("LRN");
            dtmEM.addColumn("FULL NAME");
            dtmEM.addColumn("GRADE");
            dtmEM.addColumn("SECTION");
            dtmEM.addColumn("STUDENT TYPE");
            dtmEM.addColumn("DATE");
            dtmEM.addColumn("NO.");

            tblEM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblEM.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblEM.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblEM.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblEM.getColumnModel().getColumn(3).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(4).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(5).setPreferredWidth(255);
            tblEM.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblEM.getColumnModel().getColumn(7).setPreferredWidth(50);//aa
            tblEM.setRowHeight(35);

//            tblEM.setSelectionMode(SINGLE_SELECTION);
//            tblEM.setSelectionBackground(new java.awt.Color(50, 100, 49));
//            tblEM.getTableHeader().setResizingAllowed(false);
//            tblEM.getTableHeader().setReorderingAllowed(false);
//            tblEM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
            tblEM.setSelectionMode(SINGLE_SELECTION);
            tblEM.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblEM.getTableHeader().setResizingAllowed(false);
            tblEM.getTableHeader().setReorderingAllowed(false);
            tblEM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));//aa

            if (cbEmSort.getSelectedItem().equals("Name Ascending")) {
               // Statement st = con.createStatement();
               Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                        + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                        + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                        + "pr.id = prfi.id and prpf.id = pr.id order by lname asc;");

                while (rs.next()) {
                    ss++;
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        if (rs.getInt("archived") == 1) {
                        } else {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        }
                    }
                }

                tblEM.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tblEMMouseClicked(evt);
                    }
                });

                lblCount.setText(emCount + "");
                jScrollPane1.setViewportView(tblEM);
            }//dulo ng if 
            else if (cbEmSort.getSelectedItem().equals("Name Descending")) {
               // Statement st = con.createStatement();
               Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                        + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                        + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                        + "pr.id = prfi.id and prpf.id = pr.id order by lname desc;");

                while (rs.next()) {
                    ss++;
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        if (rs.getInt("archived") == 1) {
                        } else {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        }
                    }
                }

                tblEM.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tblEMMouseClicked(evt);
                    }
                });

                lblCount.setText(emCount + "");
                jScrollPane1.setViewportView(tblEM);
            }//dulo ng if

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_cbEmSortActionPerformed

    private void emStrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emStrandActionPerformed
        emTS = (String) emStrand.getSelectedItem();
    }//GEN-LAST:event_emStrandActionPerformed

    private void emYLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emYLActionPerformed
        emSY = (String) emYL.getSelectedItem();
    }//GEN-LAST:event_emYLActionPerformed

    private void btnEmLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmLoadActionPerformed
        if (emTS.equals("Strand") && emSY.equals("Year Level")) {
            JOptionPane.showMessageDialog(null, "Please Select an Item", "Message", 2);
            return;
        }

        ss = 0;
        count = 0;
        DefaultTableModel dtmEM = new DefaultTableModel();
        tblEM.setModel(dtmEM);
        tblEM = new JTable(dtmEM) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 0:
                        return true;
                    default:
                        return false;
                }

            }
        };

        try {
            emCount = 0;
            dtmEM.addColumn("");
            dtmEM.addColumn("LRN");
            dtmEM.addColumn("FULL NAME");
            dtmEM.addColumn("GRADE");
            dtmEM.addColumn("SECTION");
            dtmEM.addColumn("STUDENT TYPE");
            dtmEM.addColumn("DATE");
            dtmEM.addColumn("NO.");

            tblEM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblEM.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblEM.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblEM.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblEM.getColumnModel().getColumn(3).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(4).setPreferredWidth(215);
            tblEM.getColumnModel().getColumn(5).setPreferredWidth(255);
            tblEM.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblEM.getColumnModel().getColumn(7).setPreferredWidth(50);//aa
            tblEM.setRowHeight(35);

            tblEM.setSelectionMode(SINGLE_SELECTION);
            tblEM.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblEM.getTableHeader().setResizingAllowed(false);
            tblEM.getTableHeader().setReorderingAllowed(false);
            tblEM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));//aa

         //   Statement st = con.createStatement();
         Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select pr.*,prai.*,prfi.*,prpf.* "
                    + "from tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                    + " prfi,tblprofperinfo prpf where pr.id = prai.id and "
                    + "pr.id = prfi.id and prpf.id = pr.id;");

            String sect;
            String sect2;
            String yl;
            while (rs.next()) {
                ss++;
                if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                    if (rs.getInt("archived") == 1) {
                    } else {

                        sect = rs.getString("section");
                        sect2 = sect.substring(0, 3);
                        yl = rs.getString("eag");

                        if (sect.substring(0, 3).equals("TVL") && emTS.equals("TVL") && yl.equals(emSY)) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (sect.substring(0, 4).equals("STEM") && emTS.equals("STEM") && yl.equals(emSY)) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (sect.substring(0, 3).equals("ABM") && emTS.equals("ABM") && yl.equals(emSY)) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (sect.substring(0, 4).equals("Arts") && emTS.equals("Arts and Design") && yl.equals(emSY)) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (sect.substring(0, 5).equals("Sport") && emTS.equals("Sports") && yl.equals(emSY)) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (sect.substring(0, 5).equals("HUMSS") && emTS.equals("HUMSS") && yl.equals(emSY)) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (yl.equals(emSY) && emTS.equals("Strand")) {

                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (emSY.equals("Year Level") && emTS.equals("TVL") && sect2.equals("TVL")) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (emSY.equals("Year Level") && emTS.equals("STEM") && sect2.equals("STE")) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (emSY.equals("Year Level") && emTS.equals("ABM") && sect2.equals("ABM")) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (emSY.equals("Year Level") && emTS.equals("Arts and Design") && sect2.equals("Art")) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (emSY.equals("Year Level") && emTS.equals("Sports") && sect2.equals("Spo")) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        } else if (emSY.equals("Year Level") && emTS.equals("HUMSS") && sect2.equals("HUM")) {
                            count++;
                            vec = new Vector();
                            vec.add(sel);
                            vec.add(rs.getString("LRN"));
                            if (rs.getString("mname").equals("")) {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname"));
                            } else {
                                vec.add(rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getString("mname"));
                            }
                            vec.add(rs.getString("eag"));
                            vec.add(rs.getString("section"));
                            if (rs.getString("section").equals("PRE-AD")) {
                                vec.add(rs.getString("student_type") + " (PRE-AD)");
                            } else {
                                vec.add(rs.getString("student_type"));
                            }
                            vec.add(rs.getString("date"));
                            vec.add(rs.getInt("id"));
                            dtmEM.addRow(vec);
                            arrSelect = new int[ss];
                            emCount++;
                        }

                    }
                }
            }

            tblEM.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblEMMouseClicked(evt);
                }
            });

            lblCount.setText(emCount + "");
            if (emCount == 0) {
                JOptionPane.showMessageDialog(null, "No Result(s) found!", null, 2);
                emStrand.setSelectedIndex(0);
                emYL.setSelectedIndex(0);
                emDisplay();

            }
            jScrollPane1.setViewportView(tblEM);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnEmLoadActionPerformed

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered

    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited

    }//GEN-LAST:event_jPanel13MouseExited

    private void jLabel39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseEntered
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        pnlUO.setVisible(false);
    }//GEN-LAST:event_jLabel39MouseEntered

    private void jLabel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseExited
        jPanel13.setBorder(null);
    }//GEN-LAST:event_jLabel39MouseExited

    private void lblBg1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBg1MouseEntered
        pnlDO.setBorder(null);
    }//GEN-LAST:event_lblBg1MouseEntered

    private void pnlSRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSRMouseEntered

    }//GEN-LAST:event_pnlSRMouseEntered

    private void txtFSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFSearchMouseEntered
        pnlUO.setVisible(false);
    }//GEN-LAST:event_txtFSearchMouseEntered

    private void txtSmSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSmSearchMouseEntered
        pnlUO.setVisible(false);
    }//GEN-LAST:event_txtSmSearchMouseEntered

    private void txtTmSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTmSearchMouseEntered
        pnlUO.setVisible(false);
    }//GEN-LAST:event_txtTmSearchMouseEntered

    private void txtAuditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAuditMouseEntered
        pnlUO.setVisible(false);
    }//GEN-LAST:event_txtAuditMouseEntered

    private void btnSmPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSmPrintActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.PORTRAIT);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) pg;
                g2.translate(pf.getImageableX() + 10, pf.getImageableY() + 20);
                g2.scale(0.63, 0.750);
//                g2.scale(0.570, 0.550);

                pnlSub.paint(g2);
                return Printable.PAGE_EXISTS;

            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_btnSmPrintActionPerformed

    private void txtFSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFSearchFocusGained
        if (txtFSearch.getText().equals(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)")) {
            txtFSearch.setText("");
        }
    }//GEN-LAST:event_txtFSearchFocusGained

    private void txtSmSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSmSearchFocusGained
        if (txtSmSearch.getText().equals(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)")) {
            txtSmSearch.setText("");
        }
    }//GEN-LAST:event_txtSmSearchFocusGained

    private void txtTmSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTmSearchFocusGained
        if (txtTmSearch.getText().equals(" PLEASE ENTER TEACHERS NAME(PRESS ENTER TO SEARCH)")) {
            txtTmSearch.setText("");
        }
    }//GEN-LAST:event_txtTmSearchFocusGained

    private void txtRcSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRcSearchFocusGained
        if (txtRcSearch.getText().equals(" PLEASE ENTER STUDENT LRN/NAME(PRESS ENTER TO SEARCH)")) {
            txtRcSearch.setText("");
        }
    }//GEN-LAST:event_txtRcSearchFocusGained

    private void txtAuditFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAuditFocusGained
        if (txtAudit.getText().equals(" PLEASE ENTER USERNAME (PRESS ENTER TO SEARCH)")) {
            txtAudit.setText("");
        }
    }//GEN-LAST:event_txtAuditFocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new corPrint().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnTmAdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmAdvActionPerformed

        if (tmSelected == 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }

        int res = JOptionPane.showOptionDialog(null, cbTmSec, "Please Select Section", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        System.out.println();
        if (res == -1) {
            return;
        }

        String tmAd = (String) cbTmSec.getSelectedItem();
        try {
         //   Statement st2 = con.createStatement();
         Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = st2.executeQuery("select * from tbltm");
            while (rs2.next()) {
                if (tmAd.equals(rs2.getString("advisory"))) {
                    JOptionPane.showMessageDialog(null, "The section has already advisory Teacher", "Ooops!", 2);
                    return;
                }
//                if (rs2.getString("advisory") != null) {
//                    int confi = JOptionPane.showConfirmDialog(null, "Do you want to change his/her advisory class?", "ARE YOU SURE?!", 1);
//                    if (confi != 0) {
//                        return;
//                    }
//                    break;
//                }
            }
            for (int i = 0; i < tmcount; i++) {
                Boolean tmS = (Boolean) tblTM.getValueAt(i, 0);
                if (tmS == true) {
                    String x = (String) tblTM.getValueAt(i, 4);
                   // Statement st = con.createStatement();
                   Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    if (tmAd.equals("Remove Advisory")) {
                        int rs = st.executeUpdate("update tbltm set advisory = 'N/A' where id =  " + x);
                        JOptionPane.showMessageDialog(null, "Success!");
                        TeacherMasterlist();
                        return;
                    }
                    int rs = st.executeUpdate("update tbltm set advisory ='" + tmAd + "' where id = " + x);
                    JOptionPane.showMessageDialog(null, "Success!");
                    lblTmSel.setText("");
                    TeacherMasterlist();

                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnTmAdvActionPerformed

    public void userDisplay() throws Exception {
        uatblCount = 0;
        // trCount = 0;

        try {
            DefaultTableModel dtmUa = new DefaultTableModel();
            tblUa.setModel(dtmUa);
            tblUa = new JTable(dtmUa) {
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return Boolean.class;
                        default:
                            return String.class;
                    }
                }
            };
            dtmUa.addColumn("");
            dtmUa.addColumn("Username");
            dtmUa.addColumn("First Name");
            dtmUa.addColumn("Middle Name");
            dtmUa.addColumn("Last Name");
            dtmUa.addColumn("Birth Day");
            dtmUa.addColumn("Gender");
            dtmUa.addColumn("Contact #");

            tblUa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tblUa.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblUa.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblUa.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblUa.getColumnModel().getColumn(3).setPreferredWidth(215);
            tblUa.getColumnModel().getColumn(4).setPreferredWidth(255);
            tblUa.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblUa.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblUa.getColumnModel().getColumn(7).setPreferredWidth(300);

            tblUa.setRowHeight(35);

            tblUa.setSelectionMode(SINGLE_SELECTION);
            tblUa.setSelectionBackground(new java.awt.Color(50, 100, 49));
            tblUa.getTableHeader().setResizingAllowed(false);
            tblUa.getTableHeader().setReorderingAllowed(false);
            tblUa.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 14));
            tblUa.setFont(new java.awt.Font("Times New Roman", 0, 16));

           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tblacc");

            while (rs.next()) {
                if (rs.getInt("archive") == 1) {
                    uatblCount++;
                    vec = new Vector();
                    vec.add(false);
                    vec.add(rs.getString("username"));
                    vec.add(rs.getString("firstname"));
                    vec.add(rs.getString("middlename"));
                    vec.add(rs.getString("lastname"));
                    vec.add(rs.getString("bday"));
                    vec.add(rs.getString("gender"));
                    vec.add(rs.getString("contact"));
                    dtmUa.addRow(vec);
                    //saCount++;
                } else {
                }
            }

            tblUa.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblUaMouseClicked(evt);
                }
            });

            lblCount4.setText(uatblCount + "");
            scrlUA.setViewportView(tblUa);

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void auditSearch() throws Exception {
     //   Statement st = con.createStatement();
     Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("Select * from tblHistory where user like '%" + txtAudit.getText() + "%'");
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("");
        dtm.addColumn("Date/Time");
        tblEH.setModel(dtm);
        Vector vec;
        while (rs.next()) {
            vec = new Vector();
            vec.add(rs.getString("user") + rs.getString("ginawa"));
            vec.add(rs.getString("date"));
            dtm.addRow(vec);
        }

    }

    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lblGC.getWidth(), lblGC.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public void TMSearch() throws Exception {
        jLabel70.setVisible(false);
        lblTmSel.setVisible(false);

        tmcount = 0;
        DefaultTableModel dtTM = new DefaultTableModel();
        tblTM.setModel(dtTM);

        tblTM = new JTable(dtTM) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 0:
                        return true;
                    default:
                        return false;
                }

            }
        };
        dtTM.addColumn("");
        dtTM.addColumn("FULL NAME");
        dtTM.addColumn("Designation");
        dtTM.addColumn("Advisory Class");
        dtTM.addColumn("id");

        tblTM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblTM.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblTM.getColumnModel().getColumn(1).setPreferredWidth(450);
        tblTM.getColumnModel().getColumn(2).setPreferredWidth(435);
        tblTM.getColumnModel().getColumn(3).setPreferredWidth(390);
        tblTM.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblTM.setRowHeight(35);

        tblTM.setSelectionMode(SINGLE_SELECTION);
        tblTM.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblTM.getTableHeader().setResizingAllowed(false);
        tblTM.getTableHeader().setReorderingAllowed(false);
        tblTM.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
        tblTM.setFont(new java.awt.Font("Times New Roman", 0, 14));

     //   Statement st = con.createStatement();
     Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from tbltm where fname like '%" + txtTmSearch.getText().trim() + "%'"
                + " or mname like '%" + txtTmSearch.getText().trim() + "%' or lname like '" + txtTmSearch.getText().trim() + "%'");

        while (rs.next()) {
            if (!rs.getString("desig").equals("principal")) {
                if (rs.getInt("archive") != 1) {
                    Vector vec = new Vector();
                    vec.add(false);
                    vec.add(rs.getString("fname") + ", " + rs.getString("mname") + ", " + rs.getString("lname"));
                    if (rs.getString("desig").equals("Other")) {
                        vec.add("N/A");
                    } else {
                        vec.add(rs.getString("desig"));
                    }
                    vec.add(rs.getString("advisory"));
                    vec.add(rs.getString("id"));
                    dtTM.addRow(vec);
                    tmcount++;
                }
            }
        }
        tblTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTMMouseClicked(evt);
            }
        });

        lblTmCount.setText(tmcount + "");
        spTM.setViewportView(tblTM);

    }

    public void RCSearch() throws Exception {
        id = 0;
        rcCount = 0;
        String x = txtRcSearch.getText().trim();
        try {
            if (txtRcSearch.getText().trim().equals("")) {
                RequirementChecklist();
            } else {

                mRC = new DefaultTableModel();
                tblRC.setModel(mRC);
                tblRC = new JTable(mRC) {
                    @Override
                    public Class getColumnClass(int column) {
                        switch (column) {
                            case 0:
                                return String.class;
                            case 1:
                                return String.class;
                            case 8:
                                return String.class;
                            default:
                                return Boolean.class;
                        }
                    }

                    public boolean isCellEditable(int row, int column) {
                        switch (column) {
                            case 0:
                                return false;
                            case 1:
                                return false;
                            case 8:
                                return false;
                            default:
                                return true;
                        }

                    }
                };

                mRC.addColumn("LRN");
                mRC.addColumn("FULL NAME");
                mRC.addColumn("EF");
                mRC.addColumn("GC");
                mRC.addColumn("F137");
                mRC.addColumn("NSO");
                mRC.addColumn("GM");
                mRC.addColumn("NCAE");
                mRC.addColumn("GWA.");
                mRC.addColumn("NO.");

                tblRC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tblRC.getColumnModel().getColumn(0).setPreferredWidth(200);
                tblRC.getColumnModel().getColumn(1).setPreferredWidth(340);
                tblRC.getColumnModel().getColumn(2).setPreferredWidth(80);
                tblRC.getColumnModel().getColumn(3).setPreferredWidth(80);
                tblRC.getColumnModel().getColumn(4).setPreferredWidth(80);
                tblRC.getColumnModel().getColumn(5).setPreferredWidth(80);
                tblRC.getColumnModel().getColumn(6).setPreferredWidth(80);
                tblRC.getColumnModel().getColumn(7).setPreferredWidth(80);
                tblRC.getColumnModel().getColumn(8).setPreferredWidth(60);
                tblRC.getColumnModel().getColumn(9).setPreferredWidth(60);
                tblRC.setRowHeight(35);

              //  Statement st = con.createStatement();
              Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("select prrc.*,prpf.*,prai.* "
                        + "from tblrc prrc,"
                        + "tblprofperinfo prpf, tblprofacadinfo prai where "
                        + "(prrc.id = prpf.id and prrc.id = prai.id and prpf.fname like '%" + txtRcSearch.getText().trim() + "%') or "
                        + "(prrc.id = prpf.id and prrc.id = prai.id and prpf.mname like '%" + txtRcSearch.getText().trim() + "%')"
                        + " or (prrc.id = prpf.id and prrc.id = prai.id and prpf.lname like '%" + txtRcSearch.getText().trim() + "%')"
                        + "or (prrc.id = prpf.id and prrc.id = prai.id and prrc.lrn like '%" + txtRcSearch.getText().trim() + "%');");

                while (rs.next()) {
                    if (rs.getString("semester").equals(dbsem) && rs.getString("sy").equals(dbsy)) {
                        if (rs.getInt("archived") == 1) {
                        } else {
                            Vector vec2 = new Vector();
                            vec2.add(rs.getString("LRN"));
                            vec2.add(rs.getString("full_name"));
                            vec2.add(rs.getBoolean("e_form"));
                            vec2.add(rs.getBoolean("g_card"));
                            vec2.add(rs.getBoolean("f137"));
                            vec2.add(rs.getBoolean("nso"));
                            vec2.add(rs.getBoolean("gm"));
                            vec2.add(rs.getBoolean("ncae"));
                            if (rs.getString("gwa").equals("")) {
                                vec2.add("N/A");
                            } else {
                                vec2.add(rs.getString("gwa"));
                            }
                            vec2.add(rs.getString("id"));
                            rcCount++;
                            mRC.addRow(vec2);
                        }
                    }
                }

                tblRC.setSelectionMode(SINGLE_SELECTION);
                tblRC.setSelectionBackground(new java.awt.Color(50, 100, 49));
                tblRC.getTableHeader().setResizingAllowed(false);
                tblRC.getTableHeader().setReorderingAllowed(false);
                tblRC.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
                tblRC.setFont(new java.awt.Font("Times New Roman", 0, 16));

                tblRC.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tblRCMouseClicked(evt);
                    }
                });

                lblCount2.setText(rcCount + "");
                tblRC.setCellSelectionEnabled(true);
                scrollpane.setViewportView(tblRC);

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void ViewSub() throws Exception {
        DefaultTableModel tmSub = new DefaultTableModel();
        tblSubj.setModel(tmSub);
        tmSub.addColumn("Core Subjects");
        tmSub.addColumn("Applied and Specialized Subjects");

        //Statement st = con.createStatement();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select ps.*,pr.*,prai.*,prfi.*,prpf.*,prrc.* "
                + "from tblsub ps, tblprof pr,tblprofacadinfo prai,tblproffaminfo"
                + " prfi,tblprofperinfo prpf,tblrc prrc where ps.id = pr.id and pr.id"
                + " = prai.id and prai.id = prfi.id and prfi.id = prpf.id and prpf.id = prrc.id");

        String IDsm = (String) tblSM.getValueAt(idSM - 1, 7);
        String mi = "".toUpperCase();
        String grade = "";
        String sec = "";
        String sem = "";

        String arSub[] = new String[8];

        while (rs.next()) {
            if (IDsm.equals(rs.getString("id"))) {
                grade = rs.getString("eag");
                sem = rs.getString("semester");
                sec = rs.getString("section");
                if (sec.substring(0, 3).equals("TVL")) {
                    sec = "tvl";
                    corPrint.sec = "TECH-VOC";
                } else if (sec.substring(0, 3).equals("ABM")) {
                    sec = "abm";
                    corPrint.sec = "ABM";
                } else if (sec.substring(0, 4).equals("Arts")) {
                    sec = "arts";
                    corPrint.sec = "Arts and Design";
                } else if (sec.substring(0, 5).equals("HUMSS")) {
                    sec = "humss";
                    corPrint.sec = "HUMSS";
                } else if (sec.substring(0, 6).equals("Sports")) {
                    sec = "sports";
                    corPrint.sec = "SPORTS";
                } else if (sec.substring(0, 4).equals("STEM")) {
                    sec = "med";
                    corPrint.sec = "STEM";
                }//gagamitin sa baba

                int ctr = 0;
                if (rs.getString("mname").length() != 0) {
                    mi = rs.getString("mname").toUpperCase().charAt(0) + ".";
                }
                while (ctr < rs.getString("mname").length()) {
                    switch (rs.getString("mname").charAt(ctr)) {
                        case ' ':
                            mi = mi + rs.getString("mname").charAt(ctr + 1) + ".";
                            break;
                    }
                    ctr++;
                }// para sa Middle Initial

                if (rs.getString("choice").equals("1")) {
                    txtSmTs.setText(rs.getString("fchoice"));
                } else if (rs.getString("choice").equals("2")) {
                    txtSmTs.setText(rs.getString("schoice"));
                }//Para sa track kung 1st/2nd choice ang ilalagay

                txtSmLrn.setText(rs.getString("lrn"));
                txtSmSn.setText(rs.getString("fname") + " " + mi + " " + rs.getString("lname"));
                txtSmDe.setText(rs.getString("date"));
                txtSmSy.setText(rs.getString("sy"));
                txtSmGl.setText(rs.getString("eag"));
                txtSmSec.setText(rs.getString("section"));
                txtSmSem.setText(rs.getString("semester"));

                if (rs.getString("s1").equals("null")) {//eto lang paraan ayaw gumana ng iba kase null ang binabato
                    trans = 0;
                } else {
                    trans = 1;//pag transferee ang pinindot
                    arSub[0] = rs.getString("s1");
                    arSub[1] = rs.getString("s2");
                    arSub[2] = rs.getString("s3");
                    arSub[3] = rs.getString("s4");
                    arSub[4] = rs.getString("s5");
                    arSub[5] = rs.getString("s6");
                    arSub[6] = rs.getString("s7");
                    arSub[7] = rs.getString("s8");

                }

            }
        }//dulo ng while

        if (trans == 1) {
            for (int i = 1; i <= 7; i++) {
                if (arSub[i].length() == 4) {
                    arSub[i] = "";
                }
            }
        }

        String sub[][] = new String[12][2];
        for (int i = 0; i < 12; i++) {
            if (grade.equals("GRADE 11") && sem.equals("First Semester") && sec.equals("tvl")) {
                sub[0][0] = "Oral Communication in Context";
                sub[0][1] = ("English for Academic and Professional Purposes");
                sub[1][0] = ("Komunikasyon at Pananaliksik sa Wika at Kulturang Pilipino");
                sub[1][1] = ("Physical Education");
                sub[2][0] = ("General Mathematics");
                sub[2][1] = ("Specialization");
                sub[3][0] = ("Earth and Life Science");
                sub[4][0] = ("Understanding Culture Society and Politics");
            } else if (grade.equals("GRADE 11") && sem.equals("Second Semester") && sec.equals("tvl")) {
                sub[0][0] = "21st Literature from the Philippines and the World";
                sub[0][1] = ("Research in Daily life 1");
                sub[1][0] = ("Pagbasa at Pagsusuri ng iba't ibang Teksto Tungo sa Pananaliksik");
                sub[1][1] = ("Empowerment Technologies (E-Tech)");
                sub[2][0] = ("Physical Education and Health");
                sub[2][1] = ("Specialization");
                sub[3][0] = ("Contemporary Philippine Arts from the Regions");
                sub[4][0] = ("Statistics and Probability");
            } else if (grade.equals("GRADE 11") && sem.equals("First Semester") && sec.equals("med")) {
                sub[0][0] = "Oral Communication in Context";
                sub[0][1] = ("English for Academic and Professional Purposes");
                sub[1][0] = ("Komunikasyon at Pananaliksik sa Wika at Kulturang Pilipino");
                sub[1][1] = ("General Biology 1");
                sub[2][0] = ("General Mathematics");
                sub[2][1] = ("Pre-Calculus");
                sub[3][0] = ("Earth and Life Science");
                sub[4][0] = ("Physical Education and Health");
            } else if (grade.equals("GRADE 11") && sem.equals("Second Semester") && sec.equals("med")) {
                sub[0][0] = "Reading and Writing Skills";
                sub[0][1] = ("English for Academic and Professional Purposes");
                sub[1][0] = ("Pagbasa at Pagsusuri ng iba't ibang Teksto Tungo sa Pananaliksik");
                sub[1][1] = ("General Biology 2");
                sub[2][0] = ("Statistics and Probability");
                sub[2][1] = ("Pre-Calculus");
                sub[3][0] = ("Physical Education and Health");
                sub[4][0] = ("Disaster and Risk Reduction");
            } else if (grade.equals("GRADE 11") && sem.equals("First Semester") && sec.equals("abm")) {
                sub[0][0] = "Oral Communication in Context";
                sub[0][1] = ("English for Academic and Professional Purposes");
                sub[1][0] = ("Komunikasyon at Pananaliksik sa Wika at Kulturang Pilipino");
                sub[1][1] = ("Organization and Management");
                sub[2][0] = ("General Mathematics");
                sub[2][1] = ("Bussiness Mathematics");
                sub[3][0] = ("Physical Education");
                sub[4][0] = ("Understanding Culture Society and Politics");
            } else if (grade.equals("GRADE 11") && sem.equals("Second Semester") && sec.equals("abm")) {
                sub[0][0] = "Reading and Writing Skills";
                sub[0][1] = ("Research in Daily life 1");
                sub[1][0] = ("Pagbasa at Pagsusuri ng iba't ibang Teksto Tungo sa Pananaliksik");
                sub[1][1] = ("Filipino sa Piling Larangan(Akademik)");
                sub[2][0] = ("Physical Education and Health");
                sub[2][1] = ("Practical Research 1");
                sub[3][0] = ("Statistics and Probability");
                sub[3][1] = ("Fundamentals of Accounting, Bussiness and Management 1");
                sub[4][0] = ("Physical Science");
                sub[4][1] = ("Principles of Marketing");
            } else if (grade.equals("GRADE 11") && sem.equals("First Semester") && sec.equals("humss")) {
                sub[0][0] = "Oral Communication in Context";
                sub[0][1] = ("English for Academic Purposes");
                sub[1][0] = ("Komunikasyon at Pananaliksik ng Wikang Filipino at Kulturang Pilipino");
                sub[1][1] = ("Disciplines and Ideas in the Social Sciences");
                sub[2][0] = ("General Mathematics");
                sub[3][0] = ("Earth and Life Science");
                sub[4][0] = ("21st Literature from the Philippines and the World");
                sub[5][0] = ("Physical Education and Health");
            } else if (grade.equals("GRADE 11") && sem.equals("Second Semester") && sec.equals("humss")) {
                sub[0][0] = "Reading and Writing Skills";
                sub[0][1] = ("Practical Research I");
                sub[1][0] = ("Pagbasa at Pagsusuri ng iba't ibang Teksto Tungo sa Pananaliksik");
                sub[1][1] = ("Filipino sa Piling Larang(Akademik)");
                sub[2][0] = ("Physical Science");
                sub[2][1] = ("Disciplines and Ideas in the Applied Social Sciences");
                sub[3][0] = ("Physical Education and Health");
                sub[3][1] = ("Creative Writing/Malikhaing Pagsulat");
                sub[4][0] = ("Statistics and Probability");
            } else if (grade.equals("GRADE 11") && sem.equals("First Semester") && sec.equals("arts")) {
                sub[0][0] = "Oral Communication in Context";
                sub[0][1] = ("English for Academic Purposes");
                sub[1][0] = ("Komunikasyon at Pananaliksik ng Wikang Filipino at Kulturang Pilipino");
                sub[1][1] = ("Filipino sa Piling Larang(Sining)");
                sub[2][0] = ("General Mathematics");
                sub[2][1] = ("Creative Industries 1: Arts and Design Appreciation and Production");
                sub[3][0] = ("Earth and Life Science");
                sub[3][1] = ("Creative Industries II: Performing Arts");
                sub[4][0] = ("Physical Education and Health");
            } else if (grade.equals("GRADE 11") && sem.equals("Second Semester") && sec.equals("arts")) {
                sub[0][0] = "Reading and Writing Skills";
                sub[0][1] = ("Practical Research I");
                sub[1][0] = ("Pagbasa at Pagsusuri ng iba't ibang Teksto Tungo sa Pananaliksik");
                sub[1][1] = ("Apprenticeship & Exploration in arts Production/");
                sub[2][0] = ("Physical Science");
                sub[2][1] = ("Apprenticeship & Exploration in the Performing Arts");
                sub[3][0] = ("Physical Education and Health");
                sub[4][0] = ("Statistics and Probability");
            } else if (grade.equals("GRADE 11") && sem.equals("First Semester") && sec.equals("sports")) {
                sub[0][0] = "Oral Communication in Context";
                sub[0][1] = ("English for Academic Purposes");
                sub[1][0] = ("Komunikasyon at Pananaliksik ng Wikang Filipino at Kulturang Pilipino");
                sub[1][1] = ("Fundamentals of Coaching");
                sub[2][0] = ("General Mathematics");
                sub[2][1] = ("Human Movement");
                sub[3][0] = ("Earth and Life Science");
                sub[3][1] = ("Phychosocial Aspects of Sports and Exercise");
                sub[4][0] = ("Physical Education and Health");

            } else if (grade.equals("GRADE 11") && sem.equals("Second Semester") && sec.equals("sports")) {
                sub[0][0] = "Reading and Writing Skills";
                sub[0][1] = ("Filipino sa Piling Larangan(Isports)");
                sub[1][0] = ("Pagbasa at Pagsusuri ng iba't ibang Teksto Tungo sa Pananaliksik");
                sub[1][1] = ("Practical Research 1");
                sub[2][0] = ("Physical Science");
                sub[2][1] = ("Fitness Testing and Basic Exercise Programming");
                sub[3][0] = ("Physical Education and Health");
                sub[3][1] = ("Sports Officiationg and Activity Management");
                sub[4][0] = ("Statistics and Probability");
            } else if (grade.equals("GRADE 12") && sem.equals("First Semester") && sec.equals("tvl")) {
                sub[0][0] = "Personal Development";
                sub[0][1] = ("Pagsulat sa Filipino Sa Piling Larangan");
                sub[1][0] = ("Physical Science");
                sub[1][1] = ("Research in Daily Life 2");
                sub[2][0] = ("Media and Information Literacy");
                sub[2][1] = ("Specialization");
                sub[3][0] = ("Introduction to the Philosophy of the Human Person/Pambungad na Pilosopya sa Tao");
                sub[4][0] = ("Physical Education and Health");
            } else if (grade.equals("GRADE 12") && sem.equals("First Semester") && sec.equals("tvl")) {
                sub[0][0] = "Personal Development";
                sub[0][1] = ("Pagsulat sa Filipino Sa Piling Larangan");
                sub[1][0] = ("Physical Science");
                sub[1][1] = ("Research in Daily Life 2");
                sub[2][0] = ("Media and Information Literacy");
                sub[2][1] = ("Specialization");
                sub[3][0] = ("Introduction to the Philosophy of the Human Person/Pambungad na Pilosopya sa Tao");
                sub[4][0] = ("Physical Education and Health");
            } else if (grade.equals("GRADE 12") && sem.equals("Second Semester") && sec.equals("tvl")) {
                sub[0][0] = "Physical Education and Health";
                sub[0][1] = ("Entrepreneurship");
                sub[1][1] = ("Inquiries, Investigations and Immersion");
                sub[2][1] = ("Work Immersion");
                sub[3][1] = ("Specialization");
            } else if (grade.equals("GRADE 12") && sem.equals("First Semester") && sec.equals("humss")) {
                sub[0][0] = "Personal Development";
                sub[1][0] = ("Trends networks and Critical Thinking in the 21st Century Culture");
                sub[0][1] = ("Entrepreneurship");
                sub[1][1] = ("Phillipine Politics and Governance");
                sub[2][0] = ("Creative non-Fiction:The literary Essay");
                sub[2][1] = ("Research Project");
                sub[3][1] = ("Disciplines and ideas in the Applied Social Sciences");
                sub[4][1] = ("Community engagement, Solidarity and Citizenship");
            } else if (grade.equals("GRADE 12") && sem.equals("Second Semester") && sec.equals("humss")) {
                sub[0][0] = "Media and Information Literacy";
                sub[1][0] = ("Introduction to the Philosophy of the Human Person/Pambungad na Pilosopya sa Tao");
                sub[0][1] = ("Practical Research 2");
                sub[1][1] = ("Filipino sa Piling Larang");
                sub[2][0] = ("Physical Science");
                sub[2][1] = ("Creative Writing");
                sub[3][1] = ("Contemporary Phillipine Arts for the Regions");
            } else if (grade.equals("GRADE 12") && sem.equals("First Semester") && sec.equals("med")) {
                sub[0][0] = "Introduction to the Philosophy of the Human Person/Pambungad na Pilosopya sa Tao";
                sub[1][0] = ("Disaster readiness and risk reduction");
                sub[0][1] = ("General Physics 1");
                sub[1][1] = ("General Biology 1");
                sub[2][0] = ("Pagsulat sa piling larang");
                sub[2][1] = ("Research in daily life");
                sub[3][0] = ("Media and Information Literacy");

            } else if (grade.equals("GRADE 12") && sem.equals("Second Semester") && sec.equals("med")) {
                sub[0][0] = "Capstone/immersion";
                sub[1][0] = ("Personal Development");
                sub[0][1] = ("Research Project");
                sub[1][1] = ("General biology 2");
                sub[2][0] = ("Entrepreneurship");
                sub[2][1] = ("General Physics 2");
                sub[3][0] = ("Contemporary Phillipine Arts for the Regions");
                sub[4][0] = ("Physical Education");
                sub[3][1] = ("General Chemistry 2");
            } else if (grade.equals("GRADE 12") && sem.equals("First Semester") && sec.equals("abm")) {
                sub[0][0] = "Introduction to the Philosophy of the Human Person/Pambungad na Pilosopya sa Tao";
                sub[1][0] = ("Physical Science");
                sub[0][1] = ("Pagsulat sa Piling Larangan(Akademik)");
                sub[1][1] = ("Research in Daily life 2");
                sub[2][0] = ("Media and Information Literacy");
                sub[2][1] = ("Fundamentals of Accounting, Bussiness and Management 2");
                sub[3][0] = ("Physical Education and Health");
                sub[3][1] = ("Bussiness Marketing");

            } else if (grade.equals("GRADE 12") && sem.equals("Second Semester") && sec.equals("abm")) {
                sub[0][0] = "Contemporary Phillipine Arts for the Regions";
                sub[1][0] = ("Physical Education and Health");
                sub[0][1] = ("Entrepreneurship");
                sub[1][1] = ("General biology 2");
                sub[2][0] = ("Personal Development");
                sub[2][1] = ("Research Project");
                sub[3][1] = ("Applied Economics");
                sub[4][1] = ("Bussiness Ethics and Social Responsibility");
                sub[5][1] = ("Bussiness Finance");
                sub[6][1] = ("Bussiness Enterprise simulation");
            } else if (grade.equals("GRADE 12") && sem.equals("First Semester") && sec.equals("arts")) {
                sub[0][0] = "Personal Development";
                sub[0][1] = ("Pagsulat sa Filipino Sa Piling Larangan");
                sub[1][0] = ("Physical Science");
                sub[1][1] = ("Research in Daily Life 2");
                sub[2][0] = ("Media and Information Literacy");
                sub[2][1] = ("Specialization");
                sub[3][0] = ("Introduction to the Philosophy of the Human Person/Pambungad na Pilosopya sa Tao");
                sub[4][0] = ("Physical Education and Health");
            } else if (grade.equals("GRADE 12") && sem.equals("Second Semester") && sec.equals("arts")) {
                sub[0][0] = "Physical Education and Health";
                sub[0][1] = ("Entrepreneurship");
                sub[1][1] = ("Inquiries, Investigations and Immersion");
                sub[2][1] = ("Work Immersion");
                sub[3][1] = ("Specialization");
            } else if (grade.equals("GRADE 12") && sem.equals("First Semester") && sec.equals("sports")) {
                sub[0][0] = "Personal Development";
                sub[0][1] = ("Pagsulat sa Filipino Sa Piling Larangan");
                sub[1][0] = ("Physical Science");
                sub[1][1] = ("Research in Daily Life 2");
                sub[2][0] = ("Media and Information Literacy");
                sub[2][1] = ("Specialization");
                sub[3][0] = ("Introduction to the Philosophy of the Human Person/Pambungad na Pilosopya sa Tao");
                sub[4][0] = ("Physical Education and Health");
            } else if (grade.equals("GRADE 12") && sem.equals("Second Semester") && sec.equals("sports")) {
                sub[0][0] = "Physical Education and Health";
                sub[0][1] = ("Entrepreneurship");
                sub[1][1] = ("Inquiries, Investigations and Immersion");
                sub[2][1] = ("Work Immersion");
                sub[3][1] = ("Specialization");
            }

        }//Di pa tapos hindi ko alam mga subj ng bawat sect

        if (trans == 1) {
            tmSub.addColumn("Acquired Subjects");
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 2; j++) {
                vec = new Vector();
                vec.add(sub[i][0]);
                vec.add(sub[i][j]);
                vec.add(arSub[i]);
                tmSub.addRow(vec);
            }
        }

        tblSubj.setSelectionBackground(new java.awt.Color(50, 100, 49));
        tblSubj.getTableHeader().setResizingAllowed(false);
        tblSubj.getTableHeader().setReorderingAllowed(false);
        tblSubj.getTableHeader().setFont(new java.awt.Font("Times New Roman", 1, 17));
        tblSubj.setFont(new java.awt.Font("Times New Roman", 0, 15));
        tblSubj.setRowHeight(35);
        trans = 0;
    }

    public static void main(String args[]) {

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBReason;
    public static javax.swing.JComboBox<String> CBS;
    public static javax.swing.JComboBox<String> CBSY;
    private javax.swing.JLabel LBLENROLL1;
    private javax.swing.JLabel LBLENROLL10;
    private javax.swing.JLabel LBLENROLL11;
    private javax.swing.JLabel LBLENROLL12;
    private javax.swing.JLabel LBLENROLL13;
    private javax.swing.JLabel LBLENROLL14;
    private javax.swing.JLabel LBLENROLL15;
    private javax.swing.JLabel LBLENROLL17;
    private javax.swing.JLabel LBLENROLL2;
    private javax.swing.JLabel LBLENROLL3;
    private javax.swing.JLabel LBLENROLL4;
    private javax.swing.JLabel LBLENROLL5;
    private javax.swing.JLabel LBLENROLL6;
    private javax.swing.JLabel LBLENROLL7;
    private javax.swing.JLabel LBLENROLL8;
    private javax.swing.JLabel LBLENROLL9;
    private javax.swing.JLabel LBLMHPNHS;
    private javax.swing.JPanel PBackground;
    private javax.swing.JPanel PCR;
    private javax.swing.JPanel PDO;
    private javax.swing.JPanel PEH;
    public javax.swing.JPanel PEM;
    private javax.swing.JPanel PHOME;
    private javax.swing.JPanel PNLCR;
    private javax.swing.JPanel PRC;
    private javax.swing.JPanel PSA;
    private javax.swing.JPanel PSM;
    private javax.swing.JPanel PSelect;
    private javax.swing.JPanel PTM;
    private javax.swing.JPanel Panel;
    private javax.swing.JCheckBox Select;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnArchive;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBro;
    private javax.swing.JButton btnCH;
    private javax.swing.JButton btnClLoad;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEHPrint;
    private javax.swing.JButton btnEmLoad;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnProm;
    private javax.swing.JButton btnRcBack;
    private javax.swing.JButton btnRet;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSmBack;
    private javax.swing.JButton btnSmPrint;
    private javax.swing.JButton btnSv;
    private javax.swing.JButton btnTMmove;
    private javax.swing.JButton btnTaDel;
    private javax.swing.JButton btnTmAdd;
    private javax.swing.JButton btnTmAdv;
    private javax.swing.JButton btnTmBack;
    private javax.swing.JButton btnTmSave;
    private javax.swing.JButton btnUaDel;
    private javax.swing.JButton btnUaRet;
    private javax.swing.JButton btnV;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btned;
    private javax.swing.JComboBox<String> cbArch;
    private javax.swing.JComboBox<String> cbEmSort;
    private javax.swing.JComboBox<String> cbLvl;
    private javax.swing.JComboBox<String> cbPos;
    private javax.swing.JComboBox<String> cbRcSearch;
    private javax.swing.JComboBox<String> cbSY;
    private javax.swing.JCheckBox cbSa;
    private javax.swing.JComboBox<String> cbSec;
    private javax.swing.JComboBox<String> cbSem;
    private javax.swing.JComboBox<String> cbSmTs;
    private javax.swing.JComboBox<String> cbSmYl;
    private javax.swing.JComboBox<String> cbSort;
    private javax.swing.JComboBox<String> cbTmSec;
    private javax.swing.JComboBox<String> cbTmSort;
    private javax.swing.JLabel eks;
    private javax.swing.JComboBox<String> emStrand;
    private javax.swing.JComboBox<String> emYL;
    private javax.swing.JLabel eto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblAudit;
    private javax.swing.JLabel lblBday;
    private javax.swing.JLabel lblBg1;
    private javax.swing.JLabel lblChecklist;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblCount1;
    private javax.swing.JLabel lblCount2;
    private javax.swing.JLabel lblCount3;
    private javax.swing.JLabel lblCount4;
    private javax.swing.JLabel lblCrAd;
    private javax.swing.JLabel lblDO3;
    private javax.swing.JLabel lblDep;
    public static javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblEH;
    private javax.swing.JLabel lblEM;
    private javax.swing.JLabel lblES;
    private javax.swing.JLabel lblF;
    private javax.swing.JLabel lblFN1;
    private javax.swing.JLabel lblGC;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblMarceloLogo;
    private javax.swing.JLabel lblRC;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblSA;
    private javax.swing.JLabel lblSEM;
    private javax.swing.JLabel lblSM;
    private javax.swing.JLabel lblSY;
    private javax.swing.JLabel lblSYear;
    private javax.swing.JLabel lblSaSelect;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearch4;
    private javax.swing.JLabel lblSec;
    private javax.swing.JLabel lblSel;
    private javax.swing.JLabel lblSem;
    private javax.swing.JLabel lblSmCount;
    private javax.swing.JLabel lblSmSearch;
    private javax.swing.JLabel lblTmCount;
    private javax.swing.JLabel lblTmSel;
    private javax.swing.JLabel lblTmlist;
    private javax.swing.JLabel lblTrack;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserprof;
    private javax.swing.JLabel lbladorus;
    private javax.swing.JLabel lbldivision;
    private javax.swing.JLabel lbldivision1;
    private javax.swing.JLabel lbldivision2;
    private javax.swing.JLabel lblfn;
    public static javax.swing.JLabel lblname;
    private javax.swing.JLabel lblviewprofile;
    private javax.swing.JLabel min;
    private javax.swing.JPanel p;
    private javax.swing.JPanel panelSM;
    private javax.swing.JPanel panelSMTBL;
    private javax.swing.JPanel pnlAr;
    private javax.swing.JPanel pnlArch;
    private javax.swing.JPanel pnlBC;
    private javax.swing.JPanel pnlCL;
    private javax.swing.JPanel pnlCP;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlDO;
    private javax.swing.JPanel pnlEF;
    private javax.swing.JPanel pnlEH;
    private javax.swing.JPanel pnlEM;
    private javax.swing.JPanel pnlEP;
    private javax.swing.JPanel pnlES;
    private javax.swing.JPanel pnlForm137;
    private javax.swing.JPanel pnlGM;
    private javax.swing.JPanel pnlGcard;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLog;
    private javax.swing.JPanel pnlNcae;
    private javax.swing.JPanel pnlRC;
    private javax.swing.JPanel pnlRc1;
    private javax.swing.JPanel pnlRc2;
    private javax.swing.JPanel pnlRcMain;
    private javax.swing.JPanel pnlSA;
    private javax.swing.JPanel pnlSM;
    private javax.swing.JPanel pnlSR;
    private javax.swing.JPanel pnlSub;
    private javax.swing.JPanel pnlTM;
    private javax.swing.JPanel pnlTmAdd;
    private javax.swing.JPanel pnlTmCard;
    private javax.swing.JPanel pnlTr;
    private javax.swing.JPanel pnlUO;
    private javax.swing.JPanel pnlUr;
    private javax.swing.JScrollPane scrlSA;
    private javax.swing.JScrollPane scrlTA;
    private javax.swing.JScrollPane scrlUA;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JScrollPane spTBL;
    private javax.swing.JScrollPane spTM;
    private javax.swing.JTable tblEH;
    public javax.swing.JTable tblEM;
    public javax.swing.JTable tblRC;
    private javax.swing.JTable tblSA;
    private javax.swing.JTable tblSM;
    private javax.swing.JTable tblSubj;
    private javax.swing.JTable tblTM;
    private javax.swing.JTable tblTa;
    private javax.swing.JTable tblUa;
    public static javax.swing.JTextField txtAudit;
    private javax.swing.JTextField txtFSearch;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtRcFn;
    private javax.swing.JTextField txtRcLrn;
    private javax.swing.JTextField txtRcSearch;
    private javax.swing.JTextField txtSmDe;
    public static javax.swing.JTextField txtSmGl;
    private javax.swing.JTextField txtSmLrn;
    private javax.swing.JTextField txtSmSearch;
    private javax.swing.JTextField txtSmSec;
    private javax.swing.JTextField txtSmSem;
    public static javax.swing.JTextField txtSmSn;
    public static javax.swing.JTextField txtSmSy;
    private javax.swing.JTextField txtSmTs;
    private javax.swing.JTextField txtTmSearch;
    private javax.swing.JTextField txtTmUser;
    private javax.swing.JTextField txtTmUser1;
    private javax.swing.JTextField txtTmUser2;
    private javax.swing.JTextField txtTmUser3;
    private javax.swing.JTextArea txtaFem;
    private javax.swing.JTextArea txtaMale;
    private javax.swing.JTextField txtbd;
    private javax.swing.JTextField txtcont;
    private javax.swing.JTextField txtfn;
    private javax.swing.JTextField txtln;
    private javax.swing.JTextField txtmn1;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables

}
