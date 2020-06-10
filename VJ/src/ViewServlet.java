import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class ViewServlet extends HttpServlet {  
  
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter(); 
String userid=request.getParameter("userid");  
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vj","root","root"); 
              
    
PreparedStatement ps=con.prepareStatement("select name,email,password from register where userid=?");
ps.setString(1,userid); 
out.print("<table width=50% border=1>");  
out.print("<caption>Your Profile</caption>");  
  
ResultSet rs=ps.executeQuery();  
              
/* Printing column names */  
ResultSetMetaData rsmd=rs.getMetaData();               
/* Printing result */  
  
while(rs.next())  
{  
	out.print("<tr>");

       out.print("<td>"+rsmd.getColumnName(1)+"</td>");

       out.print("<td>"+rs.getString(1)+"</td></tr>");

       out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");

       out.print("<td>"+rs.getString(2)+"</td></tr>");
       
       out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");

       out.print("<td>"+rs.getString(3)+"</td></tr>");
}
       
out.print("</table>");
PreparedStatement pa=con.prepareStatement("select phonenumber,Birthday,Gender,Address,City from person where userid=?");
pa.setString(1,userid); 
out.print("<table width=50% border=1>");  
out.print("<caption>Personal Details</caption>");  

ResultSet ra=pa.executeQuery();  
      
/* Printing column names */  
ResultSetMetaData rsm=ra.getMetaData();               
/* Printing result */  

while(ra.next())  
{
  out.print("<tr>");
  
    out.print("<tr><td>"+rsm.getColumnName(1)+"</td>");

    out.print("<td>"+ra.getLong(1)+"</td></tr>");  
    
    out.print("<tr><td>"+rsm.getColumnName(2)+"</td>");

    out.print("<td>"+ra.getDate(2)+"</td></tr>");

    out.print("<tr><td>"+rsm.getColumnName(3)+"</td>");

    out.print("<td>"+ra.getString(3)+"</td></tr>");

    out.print("<tr><td>"+rsm.getColumnName(4)+"</td>");

    out.print("<td>"+ra.getString(4)+"</td></tr>");

    out.print("<tr><td>"+rsm.getColumnName(5)+"</td>");

    out.print("<td>"+ra.getString(5)+"</td></tr>");  
}
    
out.print("</table>"); 
PreparedStatement pc=con.prepareStatement("select Course_name,College_name,CGPA,YOC,Skills from studies where userid=?");
pc.setString(1,userid); 
out.print("<table width=50% border=1>");  
out.print("<caption>Academic Details</caption>");  

 ResultSet rb=pc.executeQuery();  
       
 /* Printing column names */  
 ResultSetMetaData rm=rb.getMetaData();               
 /* Printing result */  

 while(rb.next())  
 {
   out.print("<tr>");
   
     out.print("<tr><td>"+rm.getColumnName(1)+"</td>");

     out.print("<td>"+rb.getString(1)+"</td></tr>");  
     
     out.print("<tr><td>"+rm.getColumnName(2)+"</td>");

     out.print("<td>"+rb.getString(2)+"</td></tr>");

     out.print("<tr><td>"+rm.getColumnName(3)+"</td>");

     out.print("<td>"+rb.getFloat(3)+"</td></tr>");

     out.print("<tr><td>"+rm.getColumnName(4)+"</td>");

     out.print("<td>"+rb.getInt(4)+"</td></tr>");

     out.print("<tr><td>"+rm.getColumnName(5)+"</td>");

     out.print("<td>"+rb.getString(5)+"</td></tr>");  
 }
     
  out.print("</table>"); 
}  

catch (Exception e2) {e2.printStackTrace();}  

          
finally{out.close();}  
  
} 
}
