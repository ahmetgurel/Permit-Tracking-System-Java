package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class baglanti {

    public static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/izintakip";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "root";
    static ResultSet rs = null;

    //Bağlantıyı Açar
    public static void openConnection() {
        try {
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "bağlantı başarısız");
        }
    }

}
