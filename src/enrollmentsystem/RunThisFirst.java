package enrollmentsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RunThisFirst{

    Connection con;

    public RunThisFirst() {

        try {
            int flag = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///dbsoria", "root", "root");
           // Statement st = con.createStatement();
           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from tblacc");
            while (rs.next()) {
                if (rs.getInt("signed") == 2) {
                    new Profile("").setVisible(true);
                    flag = 0;
                    System.out.println("in");
                    break;
                } else if (rs.getInt("signed") == 1) {
                    new ChangesPass(0,"").setVisible(true);
                    break;
                } else {
                    flag = 1;
                }
            }
            if (flag == 1) {
                new LogIn().setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new RunThisFirst();
    }
}
