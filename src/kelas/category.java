/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author NITRO_VIKI
 */
public class category {
    int category_id;
    String category_name;
    
    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public category() throws SQLException{
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDb();
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
    public void tambahCategory(){
        query = "INSERT INTO Category VALUES (?,?)";
        
        try {
            ps = konek.prepareStatement(query);
            
            ps.setInt(1, category_id);
            
            ps.setString(2, category_name);
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Category berhasil ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Category gagal ditambahkan");
        }
    }
    
    
    public ResultSet tampilCategory(){
        query = "SELECT * FROM category";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null,"Data gagal di tampilkan");
        }
        
        
        return rs;
    }
    
    public void hapusCategory(){
        try {
            query = "DELETE FROM category WHEREE category_id = ?";
            ps = konek.prepareStatement(query);

            ps.setInt(1, category_id);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Category berhasil di hapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Category gagal di hapus");
        }
        
    }
    
    
    public void ubahCategory(){
            
            query = "UPDATE category SET category_name = ?,"
                    + "WHERE category_id = ?,";
            try {
            ps = konek.prepareStatement(query);
            ps.setString(1, category_name);
            ps.setInt(2, category_id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Category berhasil di ubah");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null,"Category gagal di ubah");
        }
       
    }
    
    public ResultSet otoID(){
    
        query = "SELECT category_id FROM category ORDER BY category_id DESC LIMIT 1";
        
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil ID kategory berikutnya:"+ sQLException.getMessage());
        }
        return rs ;
    }
    
    public ResultSet tampilComboBox(){
        try {
            query = "SELECT category_name FROM category";
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan");
        }
        return rs ;
    }
    
    public ResultSet Konversi(){
        query = "SELECT category_id FROM category WHERE category_name = ?";
        try {    
            ps = konek.prepareStatement(query);
            ps.setString(1, category_name);
            
            rs = ps.executeQuery();
            System.out.println("Data masuk");
        } catch (SQLException sQLException) {
            System.out.println("Data tidak masuk");
        }
        return rs;
    }

}
