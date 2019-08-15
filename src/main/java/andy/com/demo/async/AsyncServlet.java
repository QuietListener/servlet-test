package andy.com.demo.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AsyncServlet extends HttpServlet {

    @Override
    public void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

        req.setAttribute("threadBefore", Thread.currentThread().getName());
        final AsyncContext context = req.startAsync(req, res);
        context.setTimeout(5000);
        context.start(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                    req.setAttribute("threadAfter", Thread.currentThread().getName());
                    context.dispatch("/async1.jsp");

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (context != null) {
                        context.complete();
                    }
                }
            }
        });
    }
}
