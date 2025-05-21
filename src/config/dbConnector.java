
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
      public int insertDataWithGeneratedKey(String query) {
    Statement stmt = null;
    ResultSet rs = null;

    try {
        if (connect == null || connect.isClosed()) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "");
        }

        stmt = connect.createStatement();
        int affectedRows = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        if (affectedRows == 0) {
            System.out.println("Insert failed, no rows affected.");
            return -1;
        }

        rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            System.out.println("No generated key returned.");
            return -1;
        }
    } catch (SQLException e) {
        System.out.println("SQL Error: " + e.getMessage());
        return -1;
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) {}
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
    }
} 

        
}
