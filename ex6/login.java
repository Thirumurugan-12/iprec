import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap; // For in-memory data store

public class login extends HttpServlet {

    private HashMap<String, String> users = new HashMap<>();  // In-memory user store

    public void init() throws ServletException {
        // Add some dummy users (replace with your own)
        users.put("user1", "pass1");
        users.put("user2", "pass2");
    }

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if (users.containsKey(id) && users.get(id).equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", id);
            pw.println("<html><body>");
            pw.println("<h2>Login Successful!</h2>");
            pw.println("<a href='profile.html'>View Profile</a><br>");
            pw.println("<a href='catalog.html'>View Catalog</a>");
            pw.println("</body></html>");
        } else {
            pw.println("<html><body>");
            pw.println("<h2>Invalid Login!</h2>");
            pw.println("<a href='login.html'>Try Again</a>");
            pw.println("</body></html>");
        }
    }
}