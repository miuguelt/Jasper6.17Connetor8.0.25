/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tejedor
 */
public class ConexionBD {
   
    public static Connection conexion = null;
    private ConexionBD() {
        String base = "proyectologin";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + base;
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, password);
              JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public static ConexionBD getInstance() {
        return ConexioBDHolder.INSTANCE;
    }
    
    private static class ConexioBDHolder {

        private static final ConexionBD INSTANCE = new ConexionBD();
    }
}
