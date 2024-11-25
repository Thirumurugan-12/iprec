
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class profile extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.html");
            return;
        }
        String userId = (String) session.getAttribute("userId");

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        pw.println("<h2>Welcome, " + userId + "!</h2>"); // Display user ID
        // Add more profile details here as needed.
        pw.println("</body></html>");

    }
}