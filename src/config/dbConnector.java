
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConnector {
    
    private Connection connect;

       // constructor to connect to our database
        public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
    
        //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
    
        //Function to save data
        public boolean insertData(String sql){
            
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
                return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
                return false;
            }
            
        }
        
        //Function to update data
        public boolean updateData(String sql, Object... params) {
    try (PreparedStatement pst = connect.prepareStatement(sql)) {
        // Set parameters dynamically
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }

        int rowsUpdated = pst.executeUpdate();
        return rowsUpdated > 0;

    } catch (SQLException ex) {
        System.out.println("Connection Error: " + ex.getMessage());
        return false;
    }
}

        
}
