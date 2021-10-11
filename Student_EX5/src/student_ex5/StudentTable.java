/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_ex5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DatabaseHandler;
/**
 *
 * @author naratcha.s
 */
public class StudentTable {
    public static int updateStudent(DatabaseHandler dbHandler, Student stu) {
        String sql = "update Student set name=?, GPA=? where ID=?";
        int rowUpdated;
        try {
            rowUpdated = dbHandler.update(sql, stu.getName(), stu.getGPA(), stu.getID());
        }
        catch (SQLException ex ) {
            
            rowUpdated = 0;
        }
        
        return rowUpdated;
    }
     public static int removeStudent(DatabaseHandler dbHandler, Student stu) {
         String sql ="delete from Student where ID = ?";
         
         int rowDeleted;
         try {
            rowDeleted = dbHandler.update(sql, stu.getID());
         }
         catch (SQLException ex ) {
             rowDeleted = 0;
         }
        return rowDeleted;
    }
    public static int insertStudent(DatabaseHandler dbHandler, Student stu) {
         String sql = "insert into Student (ID, name, GPA)" + 
               " values (?,?,?)";
         
         int rowInserted;
         try {
             rowInserted = dbHandler.update(sql, stu.getID(), stu.getName(), stu.getGPA());
         }
         catch(SQLException ex ) {
             rowInserted = 0;
         }
         return rowInserted;
    } 
     public static Student findStudentByID(DatabaseHandler dbHandler, int ID) throws SQLException {
        String sql = "select * from Student where ID = ?";
        ResultSet rs;
        Student stu = null;
        rs = dbHandler.query(sql, ID);
        if (rs.next()) {
           stu = new Student();
           stu.setID(rs.getInt("ID"));
           stu.setName(rs.getString("name"));
           stu.setGPA(rs.getDouble("GPA"));
       }
        return stu;
     }
}
