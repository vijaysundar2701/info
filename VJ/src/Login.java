import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userid = request.getParameter("userid");
        String pass = request.getParameter("pass");
        HttpSession session=request.getSession();  
        session.setAttribute("userid",userid);  
        if(Validate.checkUser(userid, pass))
        {    
        	 request.getRequestDispatcher("Biodata.html").include(request, response);
        	 out.print("You are successfully uploaded...");
        }
        else
        {
           out.println("Username or Password incorrect");
        }
    }  
}
