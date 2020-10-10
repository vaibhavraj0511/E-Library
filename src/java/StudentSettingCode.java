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

@WebServlet("/StudentSettingCode")
public class StudentSettingCode extends HttpServlet {

    Connection con;
        PreparedStatement pst;
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
    Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elibrary","root","root");
     String enroll=request.getParameter("enroll");
    String oldpassword=request.getParameter("oldPwd");
    String newPassword=request.getParameter("newPwd");
    String cNewPassword=request.getParameter("cNewPwd");
    PreparedStatement st=con.prepareStatement("select * from student where EnrollmentNo=? and Password=?");
        st.setString(1,enroll);
        st.setString(2,oldpassword);
        ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                if(newPassword.equals(cNewPassword))
                {
                    PreparedStatement st21=con.prepareStatement("update student set Password=? where EnrollmentNo=?");
                        st21.setString(1,newPassword);
                        st21.setString(2,enroll);
                        st21.executeUpdate();
                        con.close();
                        response.sendRedirect("StudentMenu.html");
                }
                else
                {
                    System.out.println("Password doesnot Match");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSettingCode.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
                Logger.getLogger(StudentSettingCode.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    

}
