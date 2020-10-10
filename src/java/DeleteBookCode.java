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


@WebServlet("/DeleteBookCode")
public class DeleteBookCode extends HttpServlet {

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
            String bookid = request.getParameter("bookId");
            String cbookid = request.getParameter("cBookId");
            
            if(bookid.equals(cbookid)){                
            pst = con.prepareStatement("delete from book where BookId=?");
            pst.setString(1, bookid);
            
            pst.executeUpdate();
            }else{
                System.out.println("<h1>Id Doesn't Match</h1>");
            }
            response.sendRedirect("DeleteBook.html");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteBookCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteBookCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
}
