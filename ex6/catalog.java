import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class catalog extends HttpServlet {

    private List<String> books = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Initialize with some sample book titles
        books.add("The Lord of the Rings");
        books.add("The Hitchhiker's Guide to the Galaxy");
        books.add("Pride and Prejudice");
    }



    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<html><body>");
        pw.println("<h2>Available Books:</h2>");
        pw.println("<ul>");
        for (String book : books) {
            pw.println("<li>" + book + "</li>");
        }
        pw.println("</ul>");
        pw.println("</body></html>");
    }
}