import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ViewBooksCode")
public class ViewBooksCode extends HttpServlet {
        
        Connection con;
        PreparedStatement ps;
        Statement st;
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<div style=\"background-color:black;color:white;padding:20px;border-radius:20px\">\n" +
"            <h2>E-Library</h2>\n" +
"            <div style=\"opacity: 0.6\">\n" +
"                <table width=\"100%\">\n" +
"                    <tr align=\"center\"style=\"color:white \">\n" +
"                        \n" +
"                        <td><a href=\"ViewBooks.html\" style=\" text-decoration:none;color:white;\">View Books</a></td>\n" +
"                        <td><a href=\"StudentSetting.html\" style=\" text-decoration:none;color:white;\">Setting</a></td>\n" +
"                        <td><a href=\"index.html\" style=\" text-decoration:none;color:white;\">LogOut</a></td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"               \n" +
"            </div>\n" +
"        </div>");
        out.print("<h1>Book Details</h1>");
        try
        {
       
         
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/elibrary","root","root");
        String search = request.getParameter("id");
        ps = con.prepareStatement("select * from book where Department=?"); 
        ps.setString(1,search);
        ResultSet rs = ps.executeQuery();
        out.print("<table border='1'><tr><th>Book ID</th><th>Book Name</th><th>Author Name</th><th>Edition</th><th>Download</th>");
        while(rs.next()){
            st = con.createStatement();
            ResultSet rst = st.executeQuery("Select * from book");    
                out.print("<tr><td>");
                out.println(rs.getString("BookId"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("BookName"));
                out.print("</td>");
                out.print("<td>");
                out.print(rs.getString("AuthorName"));
                out.print("</td>");     
                out.print("<td>");
                out.print(rs.getString("Edition"));
                out.print("</td>");
                out.print("<td>");
                out.print("<a href=\"DownloadBook.html\">");
                out.print("Download");
                out.print("</a>");
                out.print("</td>");
                
            
        }
        }catch(Exception p){
            System.out.println(p);
        }
        out.print("</table>");
    }
}
