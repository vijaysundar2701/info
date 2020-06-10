import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class DownloadServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter(); 
String filename = "vj.java";   
String filepath = "E:\\";   
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
            
int i;   
while ((i=fileInputStream.read()) != -1) {  
out.write(i); 
}   
fileInputStream.close();   
request.getRequestDispatcher("HLB.html").include(request, response);
out.close(); 
}  
}  
