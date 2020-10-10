import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentLoginCode")
public class StudentLoginCode extends HttpServlet {

    Connection con;
        PreparedStatement pst;
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/elibrary","root","root");
            String user = request.getParameter("enroll");
            String pass = request.getParameter("password11");
            
            pst = con.prepareStatement("select * from student where EnrollMentNo=? and Password=?");
            pst.setString(1,user);
            pst.setString(2,pass);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                response.sendRedirect("StudentMenu.html");
            }else{
                response.sendRedirect("StudentLogin.html");
               }
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentLoginCode.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
                Logger.getLogger(StudentLoginCode.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    

}
