/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_ex5;

import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author naratcha.s
 */
public class Student_EX5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Student";
        String user = "naratcha";
        String passwd = "3376";
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student stu1 = new Student(1, "Tossakorn", 3.99);
        Student stu2 = new Student(2, "Nirattisai", 3.99);
        Student stu3 = new Student(3, "Naratcha", 4.00);
        StudentTable.insertStudent(dbHandler, stu1);
        StudentTable.insertStudent(dbHandler, stu2);
        StudentTable.insertStudent(dbHandler, stu3);
        StudentTable.updateStudent(dbHandler, stu1);
        //Student stu = StudentTable.findStudentByID(dbHandler, 1);
        //stu.setName("Poramet");
        //stu.setGPA(0.99);
        //StudentTable.updateStudent(dbHandler, stu);
        //StudentTable.removeStudent(dbHandler, stu);
        
        dbHandler.closeConnection();
    }
    
}
