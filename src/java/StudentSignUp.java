import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentSignUp")
public class StudentSignUp extends HttpServlet {


    Connection con;
    PreparedStatement pat;
    PreparedStatement pat1;
    
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       try{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/elibrary","root","root");
        String fullName = request.getParameter("fullName");
        String enrollment = request.getParameter("enroll");
        String password = request.getParameter("password");
        String gender = request.getParameter("Gender");
        String branch = request.getParameter("branch");
        String year = request.getParameter("year");
        String contact = request.getParameter("contactNo");
        
        pat= con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
        pat.setString(1,fullName);
        pat.setString(2,enrollment);
        pat.setString(3,password);
        pat.setString(4,gender);
        pat.setString(5,branch);
        pat.setString(6,year);
        pat.setString(7,contact);
        pat.executeUpdate();
        
        response.sendRedirect("StudentLogin.html");
                
        
    }catch(ClassNotFoundException ex){
                Logger.getLogger(StudentSignUp.class.getName()).log(Level.SEVERE, null, ex);
            } catch(SQLException ex){
                Logger.getLogger(StudentSignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
               
    }
}
