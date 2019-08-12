package andy.com.demo.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="MyServelt",
        urlPatterns = {"/my"}
)
public class MyServlet implements Servlet {

    transient private ServletConfig config;
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    public ServletConfig getServletConfig() {
        return this.config;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String servletName = this.getServletInfo();
        res.setContentType("text/html");

        PrintWriter writer = res.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("<html><head></head>");
        sb.append("<body>hello from "+servletName);
        sb.append("</body></html>");
        writer.print(sb.toString());
    }

    public String getServletInfo() {
        return this.getClass().getSimpleName();
    }

    public void destroy() {
        System.out.println(this.getServletInfo()+"  destroy");
    }
}
