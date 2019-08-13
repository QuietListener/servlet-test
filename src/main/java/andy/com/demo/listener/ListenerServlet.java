package andy.com.demo.listener;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListenerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
       //也可以跳到servlet
        RequestDispatcher dispatcher = req.getRequestDispatcher("listenerTest.jsp");

        //注意与dispatcher.include(req,res)区别;
        dispatcher.forward(req,res);
    }
}
