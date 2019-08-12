package andy.com.demo.httpservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SimpleServletDispatcher extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("index1.jsp");

        Map<String,String> map = new HashMap<String,String>();
        map.put("attribute1","attribute1");
        map.put("attribute2","attribute2");

        req.setAttribute("map",map);
        dispatcher.forward(req,res);
    }
}
