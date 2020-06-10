import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Biodata extends HttpServlet {  
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
HttpSession session=request.getSession(false);  
if(session!=null){  
String name=(String)session.getAttribute("name");  
  
out.print("Hello, "+name+" "+"Upload your personal details");  
}
String d=request.getParameter("userid");          
String p= request.getParameter("Phonenumber"); 
String b=request.getParameter("Birthday");  
String g=request.getParameter("Gender");  
String a=request.getParameter("Address"); 
String c=request.getParameter("City"); 

          
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vj","root","root");    
  
PreparedStatement ps=con.prepareStatement("insert into person values(?,?,?,?,?,?)");  

ps.setString(1,d);
ps.setString(2,p);  
ps.setString(3,b);  
ps.setString(4,g);  
ps.setString(5,a);
ps.setString(6,c);

          
int i=ps.executeUpdate();  
if(i>0)
{
	out.print("You are successfully uploaded...");   
	request.getRequestDispatcher("Curriculum.html").include(request, response);
}    
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  