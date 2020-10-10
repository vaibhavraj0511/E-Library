<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<html>
    
 
    <style>
        body{
            background-repeat:no-repeat;
            background-image:url('964725be8d25e328ff5cb44f9c37d31e.jpg');
        }
        .fonttheme
        {
            font-family:arial;
            font-weight: bold;
            font-size:20px;
        }
        .tdtheme{
            font-weight:bold;
            font-family:arial;
            font-size:30px;
        }
        .tdthemee{
            font-weight:bold;
            font-family:arial;
            font-size:50px;
        }
        a{
           text-decoration:none;
           color:white;
        }
    </style>    
    <body>
        <div style="background-color:black;color:white;padding:20px;border-radius:20px">
            <h2>E-Library</h2>
            <div style="opacity: 0.6">
                <table width="100%">
                    <tr align="center"style="color:white ">
                        <td><a href="AddBook.jsp">Add Book</a></td>
                        <td><a href="DeleteBook.html">Delete Book</a></td>
                        <td><a href="ViewStudent.html">View Student</a></td>
                        <td><a href="Downdloaddeatil.html">Book Download Detail</a></td>
                        <td><a href="index.html">LogOut</a></td>
                    </tr>
                </table>
                
               
            </div>
        </div>
        <br><br><br>
        <table width="100%">
             
                <tr align="left" >
                    <td colspan="2" class="tdtheme">Add Book</td>
                </tr>
                </table>
        <form method="POST" action="AddBookCode" enctype="multipart/form-data" >
 <table width="100%">
        <table align="left">
            <tr>
            <td class="fonttheme">Book Id</td>
                <td><input type="number" class="form-control" name="bookId" placeholder=" Enter Book Id"  style="border-radius:20px;width:250px;height:40px;background-color:white;color:black;font-size:20px"></td>
            </tr>  
            <tr>
                <td class="fonttheme">Book Name</td>
                <td><input type="text" class="form-control" id="bookName" name="bookName" placeholder=" Enter Book Name" style="border-radius:20px;width:250px;height:40px;background-color:whithe;color:black;font-size:20px"></td>
            </tr>  
            <tr>
                <td class="fonttheme">Author Name</td>
                <td><input type="text" class="form-control" name="authorName" placeholder=" Enter Author Name" style="border-radius:20px;width:250px;height:40px;background-color:white;color:black;font-size:20px"></td>
            </tr>
            <tr> 
                <td class="fonttheme">Edition</td>
                <td><input type="text" class="form-control" name="edition" placeholder=" Enter Book Edition" style="border-radius:20px;width:250px;height:40px;background-color:white;color:black;font-size:20px"></td>
            </tr>  
            <tr> 
                <td class="fonttheme">Department</td>
                <td><input type="text" class="form-control" name="Department" placeholder=" Enter Department" style="border-radius:20px;width:250px;height:40px;background-color:white;color:black;font-size:20px"></td>
            </tr>
        <tr><td class="fonttheme">Book</td>
            <td><input type="file" name="file" id="file" style="border-radius:20px;width:250px;height:40px;background-color:white;color:black;font-size:20px "> </td>
        </tr>
        <tr>
        <td class="fonttheme">
            <input type="submit" value="Upload" name="upload" id="upload" style="border-radius:20px;width:250px;height:40px;background-color:lightblue;color:white;font-size:20px" /> </td>
             <td class="fonttheme"><input type="reset" value="Cancel" style="border-radius:20px;width:250px;height:40px;background-color:lightblue;color:white;font-size:20px"></td>
        </tr>
   </table>
        </form>
    </body>
</html>