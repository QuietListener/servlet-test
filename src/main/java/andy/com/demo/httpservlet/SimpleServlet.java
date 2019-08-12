package andy.com.demo.httpservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter writer = res.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("<html><head></head>");
        sb.append("<body>Simple Servlet");
        sb.append("</body></html>");
        writer.print(sb.toString());
    }
}
