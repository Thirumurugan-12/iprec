import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class parameter extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
PrintWriter out=res.getWriter();
String s1=req.getParameter("name");
String s2=req.getParameter("no");
out.println("<html>");
out.println("<head><title>parameter passing</title></head>");
out.println("<body>");
out.println("<h1> your name:"+s1+"</h1>");
out.println(s2);
out.println("<h1>STUDENT DETAILS</h1>");


out.println("</body></html>");
}
}