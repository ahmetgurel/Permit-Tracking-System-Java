/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import model.baglanti;

/**
 *
 * @author ahmet-gurel
 */
public class izin_islemleri {
    
    static ResultSet rs=null;
    
    
              //Tabloda İzinleri Göster
    public static DefaultTableModel izinGoster(String sicilno) {
        baglanti.openConnection();
        DefaultTableModel tm = new DefaultTableModel();
        try {
            PreparedStatement ps = (PreparedStatement) baglanti.con.prepareStatement("select * from izin where sicilno='"+sicilno+"'");
            rs = ps.executeQuery();
            int colCount = rs.getMetaData().getColumnCount(); // Toplam sütun sayısını alıyor
            for (int i = 1; i < colCount + 1; i++) {
                tm.addColumn(rs.getMetaData().getColumnName(i)); //Tabloya sütun ekliyor
            }
            while (rs.next()) {
                Object[] row = new Object[colCount];
                for (int i = 1; i < colCount + 1; i++) {
                    row[i - 1] = (Object) rs.getObject(i);
                }
                tm.addRow(row);
            }
        } catch (Exception ex) {
        }
        return tm;
    }

    
}
