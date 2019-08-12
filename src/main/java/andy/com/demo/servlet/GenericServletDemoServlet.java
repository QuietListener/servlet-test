package andy.com.demo.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="GenericServletDemoServlet",
    urlPatterns = {"/genericServletDemoServlet"},
        initParams = {
        @WebInitParam(name="admin",value="junjun"),
        @WebInitParam(name="email",value="530@qq.com")
}
)
public class GenericServletDemoServlet extends GenericServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String servletName = this.getServletInfo();

        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");

        res.setContentType("text/html");

        PrintWriter writer = res.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("<html><head></head>");
        sb.append("<body>hello from "+servletName);
        sb.append("<br/> admin : "+ admin );
        sb.append("<br/> email : "+ email );
        sb.append("</body></html>");
        writer.print(sb.toString());
    }

}
