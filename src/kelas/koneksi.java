/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author NITRO_VIKI
 */
public class koneksi {
    private Connection konekSQL;
    private String host = "localhost";
    private String db = "tokokita";
    private String user = "root";
    private String password = "";
    private String port = "3306";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
    
    public Connection konekDb() throws SQLException{
        try {
            konekSQL = DriverManager.getConnection(url, user, password);
            System.out.println("koneksi berhasil");
        } catch (SQLException sQLException) {
            System.out.println("koneksi gagal");
        }
        return konekSQL;
        
    }

    Connection konekDB() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
