import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Curriculum extends HttpServlet {  
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
HttpSession session=request.getSession(false);  
if(session!=null){  
String name=(String)session.getAttribute("name");  
  
out.print("Hi, "+name+" "+"Upload your curriculum details");  
} 
String t=request.getParameter("userid"); 
String c=request.getParameter("Course_name");  
String co=request.getParameter("College_name");  
String cg= request.getParameter("CGPA");
String yoc= request.getParameter("YOC");
String s=request.getParameter("Skills"); 

          
try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vj","root","root");    
  
PreparedStatement ps=con.prepareStatement("insert into studies values(?,?,?,?,?,?)");  

ps.setString(1,t);
ps.setString(2,c);  
ps.setString(3,co);  
ps.setString(4,cg);  
ps.setString(5,yoc);
ps.setString(6,s);

          
int i=ps.executeUpdate();  
if(i>0)
{
	out.print("You are successfully uploaded...");   
	request.getRequestDispatcher("VED.html").include(request, response);
}    
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  