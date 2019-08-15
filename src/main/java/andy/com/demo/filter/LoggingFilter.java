package andy.com.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LoggingFilter implements Filter {

    private PrintWriter logger;
    private String prefix;

    public void init(FilterConfig filterConfig) throws ServletException {
        prefix = filterConfig.getInitParameter("prefix");
        String logFileName = filterConfig.getInitParameter("logFileName");
        String appPath = filterConfig.getServletContext().getRealPath("/");
        System.out.println("** appPath = " + appPath);
        System.out.println("** logFileName = " + logFileName);

        try {
            logger = new PrintWriter(new File(appPath, logFileName));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage(), e.getCause());
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("LoggingFilter.doFilter");

        HttpServletRequest req = (HttpServletRequest) request;
        logger.println(new Date() + " " + prefix + req.getRequestURI());
        logger.flush();
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("## destroying filter");
        if (logger != null) {
            logger.close();
        }

    }
}
