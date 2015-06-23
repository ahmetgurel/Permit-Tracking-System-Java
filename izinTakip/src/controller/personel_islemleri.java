/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.baglanti;

/**
 *
 * @author ahmet-gurel
 */
public class personel_islemleri {
      //Personel Ekleme
    public static boolean personelEkle(String ad, String soyad, String tc, String sicilno, String cinsiyet, String dtarih, String sehir, String birim) {
        baglanti.openConnection();
        try {
            PreparedStatement ps = (PreparedStatement) baglanti.con.prepareStatement("INSERT INTO personel (ad,soyad,tcno,sicilno,cinsiyet,dogum_tarihi,sehir,birim)VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, ad);
            ps.setString(2, soyad);
            ps.setString(3, tc);
            ps.setString(4, sicilno);
            ps.setString(5, cinsiyet);
            ps.setString(6, dtarih);
            ps.setString(7, sehir);
            ps.setString(8, birim);
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Personel Değiştirme
    public static boolean personelDegistir(int id, String ad, String soyad, String tc, String sicilno, String cinsiyet, String dtarih, String sehir, String birim) {
        try {
            PreparedStatement ps = (PreparedStatement) baglanti.con.prepareStatement("update personel set ad=?,soyad=?,tcno=?,sicilno=?,cinsiyet=?,dogum_tarihi=?,sehir=?,birim=? where id=?");
            ps.setString(1, ad);
            ps.setString(2, soyad);
            ps.setString(3, tc);
            ps.setString(4, sicilno);
            ps.setString(5, cinsiyet);
            ps.setString(6, dtarih);
            ps.setString(7, sehir);
            ps.setString(8, birim);
            ps.setInt(9, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Personel Arama
    public static ArrayList<String> personelGetir(String sorgu) {
        baglanti.openConnection();
        ArrayList<String> liste = new ArrayList<String>();
        ResultSet rs = null;
        try {
            PreparedStatement ps = (PreparedStatement) baglanti.con.prepareStatement(sorgu);
            rs = ps.executeQuery();

            while (rs.next()) {
                liste.add(String.valueOf(rs.getInt("id")));
                liste.add(rs.getString("ad"));
                liste.add(rs.getString("soyad"));
                liste.add(rs.getString("tcno"));
                liste.add(rs.getString("sicilno"));
                liste.add(rs.getString("cinsiyet"));
                liste.add(rs.getString("dogum_tarihi"));
                liste.add(rs.getString("sehir"));
                liste.add(rs.getString("birim"));
            }
            return liste;
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }

   
}
