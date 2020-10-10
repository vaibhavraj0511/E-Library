import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewStudentCode")
public class ViewStudentCode extends HttpServlet {

   
Connection con;
Statement stmt;    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print(" <div style=\"background-color:black;color:white;padding:10px;border-radius:20px\">\n" +
"            <h2>E-Library</h2>\n" +
"            <div style=\"opacity: 0.6\">\n" +
"                <table width=\"100%\">\n" +
"                    <tr align=\"center\"style=\"color:white \">\n" +
"                        \n" +
"                        <td><a href=\"AddBook.html\" style=\" text-decoration:none;color:white;\">Add Book</a></td>\n" +
"                        <td><a href=\"DeleteBook.html\" style=\" text-decoration:none;color:white;\">Delete Book</a></td>\n" +
"                        <td><a href=\"ViewStudent.html\" style=\" text-decoration:none;color:white;\">View Student</a></td>\n" +
"                        <td><a href=\"Downdloaddeatil.html\" style=\" text-decoration:none;color:white;\">Book Download Detail</a></td>\n" +
"                        <td><a href=\"index.html\" style=\" text-decoration:none;color:white;\">LogOut</a></td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </div>\n" +
"        </div>");
        String id=request.getParameter("id");
        out.print("<h1>Display the Record</h1>");
        out.print("<table border='1'><tr><th>Name</th><th>EnrollMent</th><th>Password</th><th>Gender</th><th>Branch</th><th>Year</th><th>Contact</th>");
        
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/elibrary","root","root");
            stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("Select * from student");
           while(rs.next())
            {
                out.print("<tr><td>");
                out.println(rs.getString("FullName"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("EnrollmentNo"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("Password"));
                out.print("</td>");     
                out.print("<td>");
                out.print(rs.getString("Gender"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("Branch"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("Year"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("Contact"));
                out.print("</td>");
               
            }
        }catch(Exception p){
            System.out.println(p);
        }
        out.print("</table>");
    }

    
}
