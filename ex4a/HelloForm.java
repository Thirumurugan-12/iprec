import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloForm extends HttpServlet {

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "Using GET Method to Read Form Data";
        String docType = "<!DOCTYPE html>\n"; // Use HTML5 doctype

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: " + request.getParameter("first_name") + "</li>\n" +  // Improved formatting
                "  <li><b>Last Name</b>: " + request.getParameter("last_name") + "</li>\n" +   // Improved formatting
                "</ul>\n" +
                "</body></html>");
    }



    // Method to handle POST method request.  
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);  // Simply calls doGet() to handle POST requests the same way
    }
}