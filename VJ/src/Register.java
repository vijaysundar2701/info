import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

String u=request.getParameter("userid");
String p=request.getParameter("pass");
String n=request.getParameter("name");  
String e=request.getParameter("email");  
 
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vj","root","root");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into register values(?,?,?,?)");  

ps.setString(1,u);  
ps.setString(2,p);  
ps.setString(3,n);  
ps.setString(4,e);

          
int i=ps.executeUpdate();  
if(i>0)
out.print("You are successfully registered...");  
request.getRequestDispatcher("login.html").include(request, response);
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  
