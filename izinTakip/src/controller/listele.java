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

import java.sql.ResultSet;
import javax.swing.table.TableModel;


public class listele {
 
    static ResultSet rs=null;      
    //Tabloda Göster
    public static DefaultTableModel tableAktar() {
        model.baglanti.openConnection();
        DefaultTableModel tm = new DefaultTableModel();
        try {
            PreparedStatement ps = (PreparedStatement) model.baglanti.con.prepareStatement("select * from personel");
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
    
        public static DefaultTableModel tableAktar2() {
        model.baglanti.openConnection();
        DefaultTableModel tm = new DefaultTableModel();
        try {
            PreparedStatement ps = (PreparedStatement) model.baglanti.con.prepareStatement("select p.ad,p.soyad,sum(i.kullanilan_izin) as Izin from personel p,izin i where p.sicilno=i.sicilno group by p.ad,p.soyad");
            
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