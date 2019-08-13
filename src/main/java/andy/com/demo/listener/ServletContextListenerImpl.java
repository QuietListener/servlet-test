package andy.com.demo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class ServletContextListenerImpl implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servlet context Initialized");
        ServletContext context = sce.getServletContext();
        context.setAttribute("initByContextListener","initByContextListener_");
        System.out.println("## AttributeNames");
        Enumeration<String> ee =  context.getAttributeNames();
        while(ee.hasMoreElements()){
            String name = ee.nextElement();
            System.out.println("##- "+name);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet context destroyed");
    }
}
