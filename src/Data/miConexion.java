/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
public class miConexion {
  private static final String URL ="jdbc:mariadb://localhost/";
    private static final String DB ="bomberos";
    private static final String USUARIO ="root";
    private static String PASSWORD ="";
    
    private static Connection connection;
    
    private miConexion(){};
    
    public static Connection getConexion(){
        if(connection == null) {
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB+ "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                       +"&user="+USUARIO+"&password="+PASSWORD);
            } catch(SQLException | ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error al cargar los Drivers"+ex.getMessage());
            }
         
        }
         return connection;
    }
}
